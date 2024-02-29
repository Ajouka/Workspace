import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr1 = {4, 5, 6, 7, 8, 1};
        int[] arr2 = {4, 5, 1, 7, 8};
        int[] intersection = intersection(arr1, arr2, arr1.length - 1, arr2.length - 1);

        System.out.println(Arrays.toString(intersection));
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

