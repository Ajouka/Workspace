import java.io.*;
import java.util.*;

public class TrainDataProcessor {
    private Set<String> bestSolution;
    private int minStations;

    // Eingabedatei einlesen
    public List<Set<String>> readInput(String filePath) throws IOException {
        List<Set<String>> trainRoutes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.startsWith("#") && !line.trim().isEmpty()) {
                    String[] stations = line.split(";");
                    trainRoutes.add(new HashSet<>(Arrays.asList(stations)));
                }
            }
        }
        return trainRoutes;
    }

    // Datenreduktionstechniken
    public List<Set<String>> reduceData(List<Set<String>> trainRoutes) {
        // Entfernen von Duplikaten innerhalb einer Zugverbindung
        for (Set<String> route : trainRoutes) {
            Set<String> uniqueStations = new HashSet<>(route);
            route.clear();
            route.addAll(uniqueStations);
        }

        // Entfernen redundanter Bahnhöfe
        Map<String, Set<String>> stationToTrains = new HashMap<>();

        // 1. Map erstellen, die speichert, welche Bahnhöfe in welchen Zugverbindungen vorkommen
        for (Set<String> route : trainRoutes) {
            for (String station : route) {
                stationToTrains.computeIfAbsent(station, k -> new HashSet<>()).addAll(route);
            }
        }

        Set<String> removableStations = new HashSet<>();

        // 2. Prüfen, ob ein Bahnhof immer von anderen Bahnhöfen ersetzt wird
        for (String station : stationToTrains.keySet()) {
            boolean canBeRemoved = false;

            for (String otherStation : stationToTrains.keySet()) {
                if (!station.equals(otherStation) && stationToTrains.get(otherStation).containsAll(stationToTrains.get(station))) {
                    canBeRemoved = true;
                    break;
                }
            }

            if (canBeRemoved) {
                removableStations.add(station);
            }
        }

        // 3. Entferne die wirklich redundanten Bahnhöfe
        for (Set<String> route : trainRoutes) {
            route.removeAll(removableStations);
        }


        // Datenreduktionstechnik 3: Reduktion der Zugverbindungen
        trainRoutes.removeIf(route1 -> trainRoutes.stream().anyMatch(route2 -> !route1.equals(route2) && route2.containsAll(route1)));

        return trainRoutes;
    }

    // Optimierte Berechnung der minimalen Servicestationen mit Backtracking
    public Set<String> calculateServiceStations(List<Set<String>> trainRoutes) {
        bestSolution = new HashSet<>();
        minStations = Integer.MAX_VALUE;

        Set<String> allStations = new HashSet<>();
        for (Set<String> route : trainRoutes) {
            allStations.addAll(route);
        }

        List<String> stationsList = new ArrayList<>(allStations);
        backtrack(trainRoutes, new HashSet<>(), stationsList, 0);

        return bestSolution;
    }

    private void backtrack(List<Set<String>> trainRoutes, Set<String> currentSet, List<String> stationsList, int index) {
        // Basisfall: Alle Züge sind versorgt
        if (allTrainsCovered(trainRoutes, currentSet)) {
            if (currentSet.size() < minStations) {
                minStations = currentSet.size();
                bestSolution = new HashSet<>(currentSet);
            }
            return;
        }

        // Abbruchbedingung: Lösung ist bereits schlechter oder Index überschritten
        if (currentSet.size() >= minStations || index >= stationsList.size()) return;

        // 1. Aktuelle Station hinzufügen und rekursiv aufrufen
        currentSet.add(stationsList.get(index));
        backtrack(trainRoutes, currentSet, stationsList, index + 1);

        // 2. Station entfernen und rekursiv ohne sie weitermachen
        currentSet.remove(stationsList.get(index));
        backtrack(trainRoutes, currentSet, stationsList, index + 1);
    }

    private boolean allTrainsCovered(List<Set<String>> trainRoutes, Set<String> serviceStations) {
        for (Set<String> route : trainRoutes) {
            boolean covered = false;
            for (String station : route) {
                if (serviceStations.contains(station)) {
                    covered = true;
                    break;
                }
            }
            if (!covered) return false;
        }
        return true;
    }

    // Ergebnisse in eine Datei schreiben
    public void writeOutput(String filePath, Set<String> serviceStations) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.write("Servicestationen in: " + String.join(";", serviceStations));
        }
    }
}
