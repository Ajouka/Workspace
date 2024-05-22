public class SudokuSolver {

    public boolean solveSudoku(int[][] board) {

        return solve(board,0,0);
    }

    private boolean solve(int[][] board, int row, int col) {
        if (row ==9)return true;
        if (col ==9) return solve(board,row+1,0);
        if (board[row][col]!=0) return solve(board,row,col+1);

        for (int i=1; i<=9; i++) {
            if (isSafe(board,row,col,i)) {
                board[row][col]=i;
                if(solve(board,row,col+1)) return true;
                board[row][col]=0;

            }




        }
        return false;
    }

    private boolean isSafe(int[][] board, int row, int col, int num) {


        for( int i=0; i<9; i++) {
            if (board[row][i]==num) return false;

        }
        for (int i=0; i<9; i++) {
            if (board[i][col]==num) return false;
        }
        int startRow = row -row%3;
        int startCol = col -col%3;

        for (int i=startRow; i<startRow+3; i++) {
            for (int j=startCol; j<startCol+3; j++) {
                if (board[i][j]==num) return false;
            }
        }
        return true;
    }
    public void printBoard(int[][] board) {
        for (int r = 0; r < 9; r++) {
            for (int d = 0; d < 9; d++) {
                System.out.print(board[r][d]);
                System.out.print(" ");
            }
            System.out.print("\n");
        }
    }


}