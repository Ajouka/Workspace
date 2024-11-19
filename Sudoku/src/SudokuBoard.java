public class SudokuBoard {

    // Zwei-dimensionale Array zur Darstellung des Sudoku-Boards
    private final int[][] Board;

    // Konstruktor, der die Board-Array initialisiert
    public SudokuBoard(int[][] board) {
        this.Board = board;
    }

    // Methode zum Abrufen des Werts einer bestimmten Zelle
    public int getCell(int row, int col) {
        return Board[row][col];
    }

    // Methode zum Setzen eines Werts in einer bestimmten Zelle
    public void setCell(int row, int col, int value) {
        Board[row][col] = value;
    }

    // Methode, die prüft, ob eine bestimmte Zelle leer ist
    public boolean isEmpty(int row, int col) {
        return Board[row][col] == 0;
    }

    // Methode zum Drucken des gesamten Boards


    public void print() {
        for (int[] ints : Board) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}