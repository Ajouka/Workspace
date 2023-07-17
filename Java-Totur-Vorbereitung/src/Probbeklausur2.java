public class Probbeklausur2 {
    public static boolean pruefeMatrix(int[][] matrix) {
        int test = 0;
        for (int i = 0; i < matrix.length; i++) {
            test += matrix[0][i];
        }
        for (int i = 1; i < matrix.length; i++) {
            int zeile = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                zeile += matrix[i][j];
            }
            if (zeile != test) return false;

        }
        for (int j = 0; j < matrix[0].length; j++) {
            int spalte = 0;
            for (int i = 0; i < matrix.length; i++) {
                spalte += matrix[i][j];
            }
            if (spalte != test) return false;

        }
        return true;

    }

    public static String verschoenere(String s) {
        return s.replaceAll(" +", " ");
    }


    public static void main(String[] args) {
        System.out.println(verschoenere("Tarek Ajouka     13years old"));
        int[][] x = new int[][]{{1, 2, 3}, {2, 3, 1}, {3, 1, 2}};
        System.out.println(pruefeMatrix(x));


    }

}
