import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class day1 {


    public static int counter(String filePath) throws IOException {
        int sum = 0;
        List<String> lines = Files.readAllLines(Path.of(filePath));
        for (String x : lines) {
            String s = "";
            for (int i = 0; i < x.length(); i++) {
                if (Character.isDigit(x.charAt(i))) {
                    s += x.charAt(i);
                    break;
                }
            }
            for (int i = x.length() - 1; i >= 0; i--) {

                if (Character.isDigit(x.charAt(i))) {
                    s += x.charAt(i);
                    break;
                }

            }
            sum += Integer.parseInt(s);

        }


        return sum;
    }

    public static void main(String[] args) throws IOException {

        System.out.println(counter("C:\\Workspace\\Workspace\\AdventCode23\\src\\input.dat"));


    }


}
