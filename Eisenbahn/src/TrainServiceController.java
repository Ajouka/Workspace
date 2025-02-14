import java.io.IOException;
import java.util.Set;
import java.util.List;

public class TrainServiceController {
    private final String inputFilePath;
    private final String outputFilePath;
    private final TrainDataProcessor dataProcessor;

    public TrainServiceController(String inputFilePath, String outputFilePath) {
        this.inputFilePath = inputFilePath;
        this.outputFilePath = outputFilePath;
        this.dataProcessor = new TrainDataProcessor();
    }

    public void execute() throws IOException {
        // Eingabedatei lesen
        List<Set<String>> trainRoutes = dataProcessor.readInput(inputFilePath);

        // Datenreduktion durchführen
        trainRoutes = dataProcessor.reduceData(trainRoutes);

        // Berechnung der minimalen Anzahl von Servicestationen
        Set<String> serviceStations = dataProcessor.calculateServiceStations(trainRoutes);

        // Ausgabe
        System.out.println("Servicestationen in: " + String.join(";", serviceStations));

        // Ergebnisse in einer Datei speichern
        dataProcessor.writeOutput(outputFilePath, serviceStations);
    }
}
