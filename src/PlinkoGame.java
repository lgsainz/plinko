public class PlinkoGame {

    /**
     * Play a round of Plinko.
     */
    public static void main(String[] args) {
        PlinkoGame game = new PlinkoGame();
        String[][] board = game.generateBoard(5,5);
        game.dropChip(board, 1);
    }

    /**
     * Generate new board of dimensions row x col with alternating L, R.
     */
    public String[][] generateBoard(int rows, int cols) {
        String[][] board = new String[rows][cols];
        boolean toggle = true;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                toggle = !toggle;
                if (toggle) {
                    board[i][j] = "L";
                }
                else {
                    board[i][j] = "R";
                }
            }
        }
        printBoard(board);
        System.out.println();
        return board;
    }

    /**
     * Print the board to the console.
     */
    public void printBoard(String[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Drop the pin into the board at a given column.
     */
    public void dropChip(String[][] board, int col) {
        int row = 0;

        while (row < board.length) {
            // if chip hits a Left pin, move Left (unless you can't)
            if (board[row][col] == "L" && col > 0) {
                moveChip(board, row, col);
                col--;
            }
            // if chip hits a Right pin, move Right (unless you can't)
            else if (board[row][col] == "R" && col < board[row].length - 1) {
                moveChip(board, row, col);
                col++;
            }
            // if you can't move left/right, then drop down a row
            else {
                moveChip(board, row, col);
            }
            row++;
        }
    }

    /**
     * Helper method; sets the chip at the current position, and then reverts back to
     * original value as the chip moves to the next row.
     */
    public void moveChip(String[][] board, int row, int col) {
        String chip = "o";
        // hold temp value L/R
        String temp = board[row][col];
        // set chip
        board[row][col] = chip;
        printBoard(board);
        System.out.println();
        // revert back to original value
        board[row][col] = temp;
    }

}
