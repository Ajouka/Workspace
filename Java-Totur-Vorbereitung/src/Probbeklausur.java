import java.util.Arrays;

public class Probbeklausur {

    public static class QuadratMatrix {
        private double[][] data;

        public void setData(int x, int y, double val) {
            data[x][y] = val;
        }

        public double getData(int x, int y) {

            return data[x][y];
        }

        public int matrixSize() {
            return this.data.length;
        }

        public QuadratMatrix(int n, double x) {
            if (n <= 0) throw new ArithmeticException("Matrixgroesse <=0");
            this.data = new double[n][n];
            for (int i = 0; i < n; i++) {
                data[i][i] = x;

            }

        }

        public QuadratMatrix(double[][] feld) {
            if (feld.length == 0) throw new ArithmeticException("Matrixgroesse <=0");

            this.data = new double[feld.length][feld.length];
            for (int i = 0; i < feld.length; i++) {
                if (feld[i].length != feld.length) throw new ArithmeticException("kein quadratmatrix");
                for (int j = 0; j < feld.length; j++) {
                    this.data[i][j] = feld[i][j];
                }
            }
        }

        public boolean isSymetrisch() {
            boolean isSym = true;
            for (int i = 0; i < data.length; i++) {
                for (int j = 0; j < data.length; j++) {
                    if (data[i][j] != data[j][i]) {
                        isSym = false;
                        break;
                    }
                }

            }


            return isSym;
        }

        @Override
        public String toString() {
            StringBuilder all = new StringBuilder();
            for (double[] x : data) {
                all.append(Arrays.toString(x));

            }
            return "QuadratMatrix{" +
                    "data=" +
                    all +
                    '}';
        }
    }


    public static int sucheAB(String[] text) {
        int counter = 0;
        for (int i = 0; i < text.length; i++) {
            for (int j = 0; j < text[i].length(); j++) {
                if (text[i].charAt(j) == 'a' && j != text[i].length() - 1 && text[i].charAt(j + 1) == 'b') counter++;

                if (j == text[i].length() - 1 && text[i].charAt(j) == 'a' && i != text.length - 1 && text[i + 1].charAt(0) == 'b')
                    counter++;

            }


        }


        return counter;
    }

    public static int sucheAB1(String[] text) {
        String gesamt = text[0];
        for (int i = 1; i < text.length; i++) gesamt += text[i];
        int counter = 0;
        for (int i = 0; i < gesamt.length() - 1; i++) {

            if (gesamt.charAt(i) == 'a' && gesamt.charAt(i + 1) == 'b')
                counter++;
        }
        return counter;
    }

    public static int ggt(int x, int y) {
        int res = 1;
        for (int i = 2; i <= Math.min(x, y); i++) {
            if (x % i == 0 && y % i == 0) res = i;

        }

        return res;
    }

    public static void main(String[] args) {
        double[][] feld = new double[][]{{1, 2, 3}, {2, 1, 3}, {1, 3, 3}};

        //String[] text = new String[]{"abtabareka", "bamjadaba", "absdfa", "bamjadaba"};
        //System.out.println(sucheAB(text));
        //System.out.println(sucheAB1(text));
        //System.out.println(ggt(35, 5));
        //QuadratMatrix x = new QuadratMatrix(4, 2);
        //System.out.println(x.toString());
        QuadratMatrix x=new QuadratMatrix(feld);
        System.out.println(x.isSymetrisch());


    }

}
