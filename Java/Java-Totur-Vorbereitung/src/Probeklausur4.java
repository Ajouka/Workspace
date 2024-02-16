import java.util.*;

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
        HashSet<Integer> a1 = new HashSet<Integer>();
        for (int i : a) {
            a1.add(i);
        }
        HashSet<Integer> b1 = new HashSet<Integer>();
        for (int i : b) {
            b1.add(i);
        }



        HashSet<Integer> bigger = new HashSet<>();
        HashSet<Integer> smaller = new HashSet<>();
        if (a1.size() > b1.size()) {
            bigger = a1;
            smaller = b1;
        } else {
            bigger = b1;
            smaller = a1;
        }



        outer:
        for (int i : bigger) {

            inner:
            for (int j : smaller) {
                if (i == j * j) {

                    continue outer;
                }

            }

            return false;


        }

        //return true;

        return true;
    }

    public static int[] sortArray(int[] array) {
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> odds = new ArrayList<>();
        int[] res = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                odds.add(array[i]);
                pos.add(i);

            }
        }
        Comparator<Integer> cmp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }

        };
        odds.sort(cmp);
        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            if (pos.contains(i)) {
                res[i] = odds.get(counter);
                counter++;
                continue;
            }
            res[i] = array[i];


        }

        return res;
    }

    public static int[] sortArray1(int[] array) {

        ArrayList<Integer> odds = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                odds.add(array[i]);


            }
        }
        Collections.sort(odds);


        for (int i = 0, j = 0; i < odds.size(); i++, j++) {
            while (array[j] % 2 == 0) {
                j++;
            }
            array[j] = odds.get(i);


        }

        return array;
    }

    public static int[] arrayDiff(int[] a, int[] b) {
        // Your code here
        ArrayList<Integer> a1 = new ArrayList<>();
        for (int i : a) a1.add(i);
        ArrayList<Integer> b1 = new ArrayList<>();
        for (int j : b) b1.add(j);

        a1.removeAll(b1);


        return a1.stream().mapToInt(e->e).toArray();
    }
    public static String createPhoneNumber(int[] numbers) {
        // Your code here!

        return String.format("+(%d%d%d) %d%d%d-%d%d%d%d",numbers[0],numbers[1],numbers[2],numbers[3],numbers[4],numbers[5],numbers[6],numbers[7],numbers[8],numbers[9]);

    }

    public static void main(String[] args) {
        int[] a = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int[] b = {9, 8, 7, 6, 5};


        System.out.println(Arrays.toString(arrayDiff(a, b)));
        System.out.println(createPhoneNumber(a));



    }
}
