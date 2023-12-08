import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class day2 {

    public static int counter(String filePath) throws IOException {
        File f = new File("AdventCode23/src/Out.dat");
        PrintWriter pw = new PrintWriter(f);
        int sum = 0;
        List<String> lines = Files.readAllLines(Path.of(filePath));
        for (String x : lines) {
            String num = x.split(" ")[1];
            int num1 = Integer.parseInt(num.substring(0, num.length() - 1));
            boolean poosible = true;

            String[] bags = x.split(";");
            for (String x1 : bags) {
                if (x1.contains("red") && x1.charAt(x1.indexOf("red") - 3) != ' ' && Integer.parseInt("" + x1.charAt(x1.indexOf("red") - 2) + x1.charAt(x1.indexOf("red") - 3)) > 12) {
                    poosible = false;
                    break;

                }
                if (x1.contains("green") && x1.charAt(x1.indexOf("green") - 3) != ' ' && Integer.parseInt("" + x1.charAt(x1.indexOf("green") - 2) + x1.charAt(x1.indexOf("green") - 3)) > 13) {
                    poosible = false;
                    break;

                }
                if (x1.contains("blue") && x1.charAt(x1.indexOf("blue") - 3) != ' ' && Integer.parseInt("" + x1.charAt(x1.indexOf("blue") - 2) + x1.charAt(x1.indexOf("blue") - 3)) > 14) {
                    poosible = false;
                    break;

                }


            }
            if (!poosible) {
                sum += num1;
                pw.println("**" + x);
            } else pw.println(x);
        }
        pw.close();
        return sum;
    }


    public static void main(String[] args) throws IOException {
        System.out.println(counter("C:\\Workspace\\Workspace\\AdventCode23\\src\\input.dat"));

    }
}

