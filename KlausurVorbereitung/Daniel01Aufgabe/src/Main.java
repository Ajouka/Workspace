import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] arr1 = {4, 5, 6, 7, 8, 9};
        int[] arr2 = {1, 4, 5, 7, 8};
        int[] intersection = intersection(arr1, arr2, arr1.length - 1, arr2.length - 1);
        Geheim x = new Geheim("abcd");
        x.input();
        x.output();
    }

    public static List<Integer> funktion(int n, int k) {
        LinkedList<Integer> persons = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            persons.add(i);
        }

        List<Integer> lastTwo = new ArrayList<>();
        int index = 0;
        while (persons.size() > 2) {
            index = (index + k - 1) % persons.size(); // -1, weil wir bei 0 anfangen zu zählen
            persons.remove(index);
        }
        lastTwo.addAll(persons);
        return lastTwo;
    }


    public static int[] intersection(int[] arr1, int[] arr2, int m, int n) {
        if (m < 0 || n < 0) {
            return new int[0];
        } else if (arr1[m] == arr2[n]) {
            int[] temp = intersection(arr1, arr2, m - 1, n - 1);
            int[] result = Arrays.copyOf(temp, temp.length + 1);
            result[temp.length] = arr1[m];
            return result;
        } else if (arr1[m] > arr2[n]) {
            return intersection(arr1, arr2, m - 1, n);
        } else {
            return intersection(arr1, arr2, m, n - 1);
        }
    }
}

