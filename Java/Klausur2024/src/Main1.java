public class Main1 {

    public static void main(String[] args) {
        int[][] puzzle = {
                {3, -1, 3},
                {2, 2, -1},
                {-1, 2, 3}
        };
        SlitherlinkSolver solver = new SlitherlinkSolver(puzzle);
        if (solver.solve()) {
            System.out.println("Lösung gefunden:");
            solver.printSolution();
        } else {
            System.out.println("Keine Lösung gefunden.");
        }
    }
}
