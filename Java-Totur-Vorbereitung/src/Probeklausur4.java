import java.util.Arrays;

public class Probeklausur4 {


    public static String maskify(String str) {
        if (str.length() <= 4) return str;
        String res = "";
        for (int i = 0; i < str.length() - 4; i++) {
            res = res + '#';

        }
        for (int i = str.length() - 4; i < str.length(); i++) {
            res = res + str.charAt(i);

        }

        return res;
    }

    public static String getMiddle(String word) {
        //Code goes here!
        String res = "";
        if (word.length() % 2 == 0) {
            res += word.charAt((word.length() / 2) - 1);
            res += word.charAt((word.length() / 2));
        }
        if (word.length() % 2 != 0) {
            res += word.charAt((word.length() / 2));
        }
        return res;
    }

    public static String[] towerBuilder(int nFloors) {
        String[] res = new String[nFloors];
        if (nFloors == 0) return null;


        for (int i = 0; i < nFloors; i++) {
            res[i] = " ".repeat(nFloors - i - 1)
                    + "*".repeat(i * 2 + 1)
                    + " ".repeat(nFloors - i - 1);

        }


        return res;

    }

    public static String[] towerBuilder1(int n) {
        String[] tower = new String[n];
        for (int i = 0; i < n; i++) {
            char[] floor = new char[2 * n - 1];
            Arrays.fill(floor, ' ');
            for (int j = n - i - 1; j < n + i; j++) {
                floor[j] = '*';
            }
            tower[i] = new String(floor);
        }
        return tower;
    }

    public static boolean isNarcissistic(int number) {
        String as = Integer.toString(number);
        int summe = 0;
        for (int i = 0; i < as.length(); i++) {
            summe += Math.pow(Double.parseDouble("" + as.charAt(i)), (double) as.length());


        }

        return summe == number;
    }

    public static boolean isNarcissistic1(int number) {
        int length = 0;
        int sum = 0;
        int num = number;
        while (num > 0) {
            length++;
            num /= 10;
        }
        num = number;

        while (num > 0) {
            sum += Math.pow(num % 10, length);
            num /= 10;

        }

        return sum == number;
    }

    public static boolean comp(int[] a, int[] b) {
        int[] bigger;
        int[] smaller;
        if (a.length >= b.length) {
            bigger = Arrays.copyOf(a, a.length);
            smaller = Arrays.copyOf(b, b.length);

        } else {
            bigger = Arrays.copyOf(b, b.length);
            smaller = Arrays.copyOf(a, a.length);

        }


        outer:
        for (int i = 0;i<bigger.length; i++) {

            inner:
            for (int j = 0; j < smaller.length; j++) {
                if (bigger[i] % smaller[j] == 0) {
                    continue outer;
                }

            }

            return false;


        }

        return true;


    }


    public static void main(String[] args) {
        int[] a = new int[]{121, 144, 19, 161, 19, 144, 19, 11};
        int[] b = new int[]{121, 14641, 20736, 361, 25921, 361, 20736, 361};

        System.out.println(comp(a, b));
        
    }
}
