public class PlinkoGame {

    /**
     * Play a round of Plinko.
     * Run directly in the console using the following syntax and args:
     * java PlinkoGame row col start_col
     */
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Please use the following syntax: java PlinkoGame <row> <col> <start_col>");
            System.exit(0);
        }

        try {
            int row = Integer.parseInt(args[0]);
            int col = Integer.parseInt(args[1]);
            int start = Integer.parseInt(args[2]);

            PlinkoGame game = new PlinkoGame();
            String[][] board = game.generateBoard(row, col);
            game.dropChip(board, start);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Please choose a column within your range, starting at 1.");
        }
        catch (Exception e) {
            System.out.println("Please use integers as parameters.");
        }
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
        System.out.println("Board: ");
        printBoard(board);
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
        System.out.println();
    }

    /**
     * Drop the chip into the board at a given column.
     */
    public void dropChip(String[][] board, int col) {
        int row = 0;
        col--; // decrement column so if user wants the first column, its actually col 0.

        while (row < board.length) {
            // if chip hits a Left pin, move Left (unless you can't)
            if (board[row][col] == "L" && col > 0) {
                moveChip(board, row, col--);
            }
            // if chip hits a Right pin, move Right (unless you can't)
            else if (board[row][col] == "R" && col < board[row].length - 1) {
                moveChip(board, row, col++);
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
        // revert back to original value
        board[row][col] = temp;
    }

}
