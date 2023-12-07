import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class day2 {

    public static int counter(String filePath) throws IOException {
        int sum = 0;
        List<String> lines = Files.readAllLines(Path.of(filePath));
        for (String x : lines) {
            int num = Integer.parseInt("" + x.charAt(5));
            boolean poosible = true;

            String[] bags = x.split(";");
            for (String x1 : bags) {
                if (Integer.parseInt("" + x1.charAt(x1.indexOf("red") - 2)) > 12) {
                    poosible = false;
                    break;

                }
                if (Integer.parseInt("" + x1.charAt(x1.indexOf("green") - 2)) > 13) {
                    poosible = false;
                    break;

                }
                if (Integer.parseInt("" + x1.charAt(x1.indexOf("blue") - 2)) > 14) {
                    poosible = false;
                    break;

                }


            }
            if (!poosible) sum += num;


        }
        return sum;
    }


    public static void main(String[] args) throws IOException {
        System.out.println(counter("/Users/tarkoowolf/Workspace/AdventCode23" +
                "/src/input2.dat"));



    }
}
