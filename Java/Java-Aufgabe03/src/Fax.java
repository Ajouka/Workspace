import java.util.ArrayList;

public class Fax {
    public static ArrayList<Integer> encode(String binary) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        char current = '1';
        int counter = 0;
        for (int i = 0; i < binary.length(); i++) {
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

    public static String decode(ArrayList<Integer> list) {
        StringBuilder res = new StringBuilder();
        boolean isOne = true;
        for (Integer integer : list) {
            if (isOne) {
                res.append("1".repeat(integer));
                isOne = false;
                continue;
            }
            else {
                res.append("0".repeat(integer));
                isOne = true;
                continue;
            }

        }


        return res.toString();
    }
}