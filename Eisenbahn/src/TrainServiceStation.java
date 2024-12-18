import java.io.IOException;
import java.util.List;

public class TrainServiceStation {

    public static void main(String[] args) throws IOException {
        // Controller-Klasse initialisieren
        TrainServiceController controller = new TrainServiceController("input.txt", "output.txt");
        controller.execute();
    }
}
