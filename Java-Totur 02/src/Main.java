import java.util.Arrays;

public class Main {

    public static double[][] transpose(double[][] v) {
        if (v == null || v.length == 0 || v[0].length == 0) {
            return new double[0][0];
        }
        int m = v.length;
        int n = v[0].length;
        double[][] result = new double[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[j][i] = v[i][j];
            }
        }
        return result;
    }

    public static double[] matrixMalVektor(double[][] a, double[] b) {
        if (a == null || a.length == 0 || a[0].length == 0 || b == null || b.length == 0) {
            return new double[0];
        }
        double[] result = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = skal(a[i], b);
        }
        return result;
    }

    public static double skal(double[] x, double[] y) {
        if (x == null || y == null || x.length != y.length) {
            return 0;
        }
        return skalHelper(x, y, 0);
    }

    private static double skalHelper(double[] x, double[] y, int index) {
        if (index >= x.length) {
            return 0;
        }
        return x[index] * y[index] + skalHelper(x, y, index + 1);
    }


    public static void main(String[] args) {

       double[][] v={{3,2,1},{5,1,1},{1,1,2}};
       double[] v1={2,2,2};
        System.out.println(Arrays.toString(matrixMalVektor(v, v1)));


        System.out.println("Hello world!");
    }




}