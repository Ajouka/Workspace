import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class Test {


    public static boolean isEverywhere(int[] a, int x) {
        for (int i = 0; i < a.length - 2; i++) {
            if (a[i] != x && a[i + 1] != x) return false;
        }

        return true;
    }

    public static int[] evenOdd(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i] % 2 == 0) {
                int key = a[i];
                int j = i - 1;
                while (j >= 0 && a[j] % 2 != 0) {
                    a[j + 1] = a[j];
                    --j;

                }
                a[j + 1] = key;

            } else continue;

        }
        return a;
    }


    public static int[] evenOdd3(int[] arr) {
        int[] b = new int[arr.length];
        int l = 0;
        int r = arr.length;
        for (int j : arr) {
            if (j % 2 == 0) {
                b[l] = j;
                l++;
            }

        }
        for (int j : arr) {
            if (j % 2 != 0) {
                b[l] = j;
                l++;
            }
        }
        return b;
    }

    public static class A {
        private int nummer;
        private String text;

        public A(int nummer, String text) {
            this.nummer = nummer;
            this.text = text;
        }

        @Override
        public String toString() {
            return "A{" +
                    "nummer=" + nummer +
                    ", text='" + text + '\'' +
                    '}';
        }



    }
    public static A[] compareOb(A[] arr){
        A[] b = new A[arr.length];
        int l = 0;

        for (A j : arr) {
            if (j.nummer % 2 == 0) {
                b[l] = j;
                l++;
            }

        }
        for (A j : arr) {
            if (j.nummer % 2 != 0) {
                b[l] = j;
                l++;
            }
        }
        return b;


    }

    public static void main(String[] args) {

        A[] arr = new A[]{new A(10, "abc"), new A(13, "abc"), new A(15, "abc"),
                new A(12, "abc"), new A(13, "abc"),
                new A(1, "abc"), new A(11, "abc"), new A(19, "abc"),
        new A(6,"abc"),
        new A(7,"abc")};



        System.out.println(Arrays.toString(compareOb(arr)));



        int[] x = {1, 1, 0, 1, 1, 1, 1, 2, 0, 0, 0, 1};
        System.out.println(Arrays.toString(x));
        System.out.println(Arrays.toString(evenOdd3(x)));


    }
}
