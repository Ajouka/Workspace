import java.io.IOException;

public class TrainServiceStation {
    public static void main(String[] args) throws IOException {
      /*  if (args.length < 2) {
            System.err.println("Bitte geben Sie den Eingabe- und Ausgabepfad an.");
            System.exit(1);
        }

        String inputFile = args[0];
        String outputFile = args[1];*/

        TrainServiceController controller = new TrainServiceController("C:\\Workspace\\Workspace\\Eisenbahn\\src\\input.txt", "C:\\Workspace\\Workspace\\Eisenbahn\\src\\output.txt");
        controller.execute();
    }
}
