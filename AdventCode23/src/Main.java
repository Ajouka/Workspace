import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {


    public static int counter(String filePath) throws IOException {
        HashMap<String, Integer> values = new HashMap<>();
        values.put("one", 1);
        values.put("two", 2);
        values.put("three", 3);
        values.put("four", 4);
        values.put("five", 5);
        values.put("six", 6);
        values.put("seven", 7);
        values.put("eight", 8);
        values.put("nine", 9);
        values.put("1", 1);
        values.put("2", 2);
        values.put("3", 3);
        values.put("4", 4);
        values.put("5", 5);
        values.put("6", 6);
        values.put("7", 7);
        values.put("8", 8);
        values.put("9", 9);
        int sum = 0;
        List<String> lines = Files.readAllLines(Path.of(filePath));

        for (String x : lines) {
            boolean firstFound = false;
            boolean lastFound = false;
            int indexFirst = 0;
            int indexlast = 0;
            int firstDigit = 0;
            int lastDigit = 0;

            for (String x1 : values.keySet()) {
                if (!firstFound && x.contains(x1)) {
                    firstFound = true;
                    indexFirst = indexlast = x.indexOf(x1);
                    firstDigit = lastDigit = values.get(x1);
                    continue;
                }
                if (firstFound && x.contains(x1) && x.indexOf(x1) < indexFirst) {
                    indexFirst = x.indexOf(x1);
                    firstDigit = values.get(x1);

                }


            }

            for (String x1 : values.keySet()) {

                if (x.contains(x1) && x.lastIndexOf(x1) > indexlast) {
                    indexlast = x.lastIndexOf(x1);
                    lastDigit = values.get(x1);
                }
            }


            sum += firstDigit * 10 + lastDigit;


        }

        return sum;

    }

    public static void main(String[] args) throws IOException {
        System.out.println(counter("/Users/tarkoowolf/Workspace/AdventCode23/src/input.dat"));
    }
}