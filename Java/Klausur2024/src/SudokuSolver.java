public class SudokuSolver {

    public boolean solveSudoku(int[][] board) {

        return solve(board,0,0);
    }

    private boolean solve(int[][] board, int row, int col) {
        if (row ==9)return true;
        if (col ==9) return solve(board,row+1,col);
        if (board[row][col]!=0) return solve(board,row,col+1);

        for (int i=0; i<=9; i++) {





        }
return true;
    }

}
