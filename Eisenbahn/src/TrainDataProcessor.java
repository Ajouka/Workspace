import java.awt.*;

import java.io.*;
import java.util.*;
import java.util.List;


public class TrainDataProcessor {
    // Eingabedatei einlesen
    public List<Set<String>> readInput(String filePath) throws IOException {
        List<Set<String>> trainRoutes = new ArrayList<Set<String>>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.startsWith("#") && !line.trim().isEmpty()) {
                    String[] stations = line.split(";");
                    trainRoutes.add(Collections.singleton(String.valueOf(new HashSet<>(Arrays.asList(stations)))));
                }
            }
        }
        return trainRoutes;
    }

    // Datenreduktionstechniken
    public List<Set<String>> reduceData(List<Set<String>> trainRoutes) {
        // Technik 1: Entfernen von Duplikaten innerhalb einer Verbindung
        for (Set<String> route : trainRoutes) {
            Set<String> uniqueStations = new HashSet<>(route);
            route.clear();
            route.addAll(uniqueStations);
        }

        // Technik 2: Entfernen redundanter Bahnhöfe
        Set<String> allStations = new HashSet<>();
        for (Set<String> route : trainRoutes) {
            allStations.addAll(route);
        }

        for (String station : new HashSet<>(allStations)) {
            boolean canBeRemoved = true;
            for (Set<String> route : trainRoutes) {
                if (route.contains(station) && route.size() == 1) {
                    canBeRemoved = false;
                    break;
                }
            }
            if (canBeRemoved) {
                for (Set<String> route : trainRoutes) {
                    route.remove(station);
                }
            }
        }

        return trainRoutes;
    }
    // Algorithmus zur Berechnung der minimalen Servicestationen
    public Set<String> calculateServiceStations(List<Set<String>> trainRoutes) {
        Set<String> serviceStations = new HashSet<>();

        while (!trainRoutes.isEmpty()) {
            // Häufigster Bahnhof identifizieren
            Map<String, Integer> stationCount = new HashMap<>();
            for (Set<String> route : trainRoutes) {
                for (String station : route) {
                    stationCount.put(station, stationCount.getOrDefault(station, 0) + 1);
                }
            }

            String mostFrequentStation = Collections.max(stationCount.entrySet(), Map.Entry.comparingByValue()).getKey();

            // Station als Servicestation hinzufügen
            serviceStations.add(mostFrequentStation);

            // Zugverbindungen entfernen, die von dieser Servicestation abgedeckt werden
            trainRoutes.removeIf(route -> route.contains(mostFrequentStation));
        }

        return serviceStations;
    }
    // Ergebnisse in eine Datei schreiben
    public void writeOutput(String filePath, Set<String> serviceStations) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.write("Servicestationen in: " + String.join(", ", serviceStations));
        }
    }
}
