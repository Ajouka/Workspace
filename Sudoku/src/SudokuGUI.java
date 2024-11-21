import javax.swing.*;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SudokuGUI extends JFrame {
    private final JTextField[][] cells = new JTextField[9][9];

    public SudokuGUI() {
        setTitle("Sudoku Solver");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(9, 9));
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                cells[row][col] = new JTextField();
                cells[row][col].setHorizontalAlignment(JTextField.CENTER);

                PlainDocument doc = (PlainDocument) cells[row][col].getDocument();
                doc.setDocumentFilter(new DigitFilter());

                boardPanel.add(cells[row][col]);
            }
        }

        add(boardPanel, BorderLayout.CENTER);

        JButton solveButton = new JButton("Solve");
        solveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[][] board = new int[9][9];
                for (int row = 0; row < 9; row++) {
                    for (int col = 0; col < 9; col++) {
                        String text = cells[row][col].getText();
                        if (!text.isEmpty()) {
                            board[row][col] = Integer.parseInt(text);
                        } else {
                            board[row][col] = 0;
                        }
                    }
                }

                SudokuBoard sudokuBoard = new SudokuBoard(board);
                SudokuSolver solver = new SudokuSolver();
                if (solver.solveSudoku(sudokuBoard)) {
                    updateBoard(sudokuBoard);
                } else {
                    JOptionPane.showMessageDialog(null, "No solution exists");
                }
            }
        });

        add(solveButton, BorderLayout.SOUTH);
    }

    private void updateBoard(SudokuBoard board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                cells[row][col].setText(String.valueOf(board.getCell(row, col)));
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SudokuGUI gui = new SudokuGUI();
            gui.setVisible(true);
        });
    }
}