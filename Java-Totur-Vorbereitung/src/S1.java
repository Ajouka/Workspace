import java.util.*;

public class S1 {


    public static String longestConsec(String[] strarr, int k) {
        if (k > strarr.length || k <= 0) return "";
        String bigString = "";
        for (int i = 0; i <= strarr.length - k; i++) {
            String actual = strarr[i];

            for (int j = 1; j < k; j++) {

                actual += strarr[i + j];


            }

            if (actual.length() > bigString.length()) {
                bigString = actual;
            }

        }


        return bigString;
    }

    public static int greedy(int[] dice) {
        int sum = 0;
        for (int i = 1; i <= 6; i++) {
            int counter = 0;
            for (int s : dice) {
                if (s == i) counter++;


            }
            if (i == 1) {
                sum += (counter / 3) * 1000 + (counter % 3) * 100;
            } else if (i == 5) {
                sum += (counter / 3) * 500 + (counter % 3) * 50;
            } else {
                if (counter >= 3) sum += i * 100;
            }


        }


        return sum;
    }

    public static <T> List<T> josephusPermutation(final List<T> items, final int k) {
        int pos = 0;
        List<T> res = new ArrayList<T>();
        while (!items.isEmpty()) {
            pos = (pos - 1 + k) % items.size();
            res.add(items.get(pos));
            items.remove(pos);


        }


        return res;
    }

    public static double solution(int[] arr1, int[] arr2) {
        int sum = 0;
        for (int i = 0; i < arr1.length; i++) {
            sum += Math.abs(arr1[i] - arr2[i]) * Math.abs(arr1[i] - arr2[i]);

        }
        return (double) sum / arr1.length;
    }

    public static String makeReadable(int seconds) {
        // Do something
        int hh = seconds / 3600;
        seconds = seconds % 3600;
        int mm = seconds / 60;
        int sec = seconds % 60;


        return String.format("%02d:%02d:%02d", hh, mm, sec);
    }

    public static String stripComments(String text, String[] commentSymbols) {
        String[] x1 = text.split("\n");

        for (String s : commentSymbols) {
            for (int i = 0; i < x1.length; i++) {
                if (x1[i].contains(s)) {
                    x1[i] = (x1[i].substring(0, x1[i].indexOf(s))).trim();
                }

            }

        }
        String x = "";
        for (int i = 0; i < x1.length; i++) {

            if (i == x1.length - 1) x += x1[i].stripTrailing();
            else x += x1[i].stripTrailing() + "\n";


        }


        return x;
    }

    public static String rot13(String message) {

        //A(65)---->Z(90)
        //a(97)------>z(122)
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            int a = message.charAt(i);
            if (a >= 65 && a <= 90) {
                a = a <= 77 ? a + 13 : a - 13;
                res.append((char) a);

            } else if (a >= 97 && a <= 122) {
                a = a <= 109 ? a + 13 : a - 13;
                res.append((char) a);

            } else {
                res.append(message.charAt(i));

            }


        }

        return res.toString();
    }

    public static String rearrenge(String s)

    public static void main(String[] args) {
        System.out.println(rot13("This is my first ROT13 excercise!"));
    }
}
