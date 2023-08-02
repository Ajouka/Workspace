import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
            }
            else if (i == 5) {
                sum += (counter / 3) * 500 + (counter % 3) * 50;
            } else {
                if (counter >= 3) sum += i * 100;
            }


        }


        return sum;
    }
    public static <T> List<T> josephusPermutation(final List<T> items, final int k) {
        List<T> res=new LinkedList<>();





        return res;
    }

    public static void main(String[] args) {
        //String [] arr= {"ejjjjmmtthh", "zxxuueeg", "aanlljrrrxx", "dqqqaaabbb", "oocccffuucccjjjkkkjyyyeehh"};
        //System.out.println(longestConsec(arr,3));
        int[] dice = {1, 1, 1, 1, 1};
        int sum = 0;
        for (int i = 1; i <= 6; i++) {
            int counter = 0;
            for (int s : dice) {
                if (s == i) counter++;


            }
            System.out.println(counter);
            if (i == 1) {
                sum =sum+ ((counter / 3) * 1000) + ((counter % 3) * 100);


            }
            else if (i == 5) {
                sum += (counter / 3) * 500 + (counter % 3) * 50;

            } else {
                if (counter >= 3) sum += i * 100;

            }


        }
        System.out.println(sum);

    }
}
