import java.util.Arrays;

public class SlitherlinkSolver {

    private final int[][] puzzle;
    private final int[][] horizontalLines;
    private final int[][] verticalLines;
    private final int n, m;

    public SlitherlinkSolver(int[][] puzzle) {
        this.puzzle = puzzle;
        this.n = puzzle.length;
        this.m = puzzle[0].length;
        this.horizontalLines = new int[n + 1][m];
        this.verticalLines = new int[n][m + 1];
    }

    // Prüft, ob die aktuelle Lösung alle Bedingungen erfüllt
    private boolean isValid() {
        // Überprüft, ob die Anzahl der Linien um jede Zahl korrekt ist
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (puzzle[i][j] != -1) {
                    int count = horizontalLines[i][j] + horizontalLines[i + 1][j]
                            + verticalLines[i][j] + verticalLines[i][j + 1];
                    if (count != puzzle[i][j]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    // Versucht, den Slitherlink mit Backtracking zu lösen
    public boolean solve() {
        return backtrack(0, 0);
    }

    private boolean backtrack(int i, int j) {
        if (i == n && j == m + 1) {
            return isValid();
        }
        if (j == m + 1) {
            return backtrack(i + 1, 0);
        }

        // Versuche, eine Linie horizontal oder vertikal zu setzen
        horizontalLines[i][j] = 1;
        if (backtrack(i, j + 1)) return true;
        horizontalLines[i][j] = 0;

        verticalLines[i][j] = 1;
        if (backtrack(i, j + 1)) return true;
        verticalLines[i][j] = 0;

        return false;
    }

    // Gibt die Lösung aus
    public void printSolution() {

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(horizontalLines[i][j] == 1 ? "+" : ".");
            }
            System.out.println();
            if (i < n) {
                for (int j = 0; j <= m; j++) {
                    System.out.print(verticalLines[i][j] == 1 ? "|" : " ");
                }
                System.out.println();
            }
        }

    }


}
