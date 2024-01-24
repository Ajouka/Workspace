import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class Fax {
    public static ArrayList<Integer> encode(String binary) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        char current = binary.charAt(0);
        int counter = 1;
        for (int i = 1; i < binary.length(); i++) {
            if (binary.charAt(i) == current) {
                counter++;
            } else {
                res.add(counter);
                counter = 1;
                current = binary.charAt(i);
            }

            if (i == binary.length() - 1) res.add(counter);


        }


        return res;
    }

    public static String entcoden(ArrayList<Integer> list) {
        StringBuilder res = new StringBuilder();
        boolean isOne = true;
        for (Integer integer : list) {
            if (isOne) {
                res.append("1".repeat(integer));
                isOne = false;
                continue;
            }
            if (!isOne) {
                res.append("0".repeat(integer));
                isOne = true;
                continue;
            }

        }


        return res.toString();
    }
}