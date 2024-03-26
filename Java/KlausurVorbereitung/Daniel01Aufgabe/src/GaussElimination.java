public class GaussElimination {
    public static void main(String[]args){

        double[][] a = {
                {3, 2, -4, 3},
                {2, 3, 3, 15},
                {5, -3, 1, 14}
        };
        double[] b = {3, 15, 14};


gaussElimination(a,b);

    }
    public static void gaussElimination(double[][] A, double[] b) {
        int n = b.length;

        // Erzeugen der Zeilen-Stufen-Form
        for (int i = 0; i < n; i++) {
            // Suche nach dem maximalen Element in der aktuellen Spalte
            int maxRow = i;
            for (int k = i + 1; k < n; k++) {
                if (Math.abs(A[k][i]) > Math.abs(A[maxRow][i])) {
                    maxRow = k;
                }
            }

            // Tausche die maximale Zeile mit der aktuellen Zeile
            double[] temp = A[i];
            A[i] = A[maxRow];
            A[maxRow] = temp;

            double t = b[i];
            b[i] = b[maxRow];
            b[maxRow] = t;

            // Eliminiere die unteren Zeilen
            for (int k = i + 1; k < n; k++) {
                double factor = A[k][i] / A[i][i];
                b[k] -= factor * b[i];
                for (int j = i; j < n; j++) {
                    A[k][j] -= factor * A[i][j];
                }
            }
        }

        // Bestimmen des Lösungsvektors durch Rückwärtseinsetzen
        double[] solution = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            double sum = 0.0;
            for (int j = i + 1; j < n; j++) {
                sum += A[i][j] * solution[j];
            }
            solution[i] = (b[i] - sum) / A[i][i];
        }

        // Ausgabe der Lösung
        System.out.println("Lösungsvektor:");
        for (int i = 0; i < n; i++) {
            System.out.println("x" + (i + 1) + " = " + solution[i]);
        }
    }



}
