import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        TrainDataProcessor processor = new TrainDataProcessor();
        processor.execute("C:\\Workspace\\Workspace\\Eisenbahn1\\src\\input.txt", "C:\\Workspace\\Workspace\\Eisenbahn1\\src\\output.txt");
    }
}