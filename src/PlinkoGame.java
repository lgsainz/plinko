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
        String chip = "o";
        int row = 0;

        System.out.println(board.length);

        while (row < board.length) {
//            System.out.println("before: " + board[row][col] + row);

            if (board[row][col] == "L" && col > 0) {
                board[row][col] = chip;
                col--;
            }
            else if (board[row][col] == "R" && col < board[row].length - 1) {
                board[row][col] = chip;
                col++;
            }
            else {
                board[row][col] = chip;
            }
            printBoard(board);
            System.out.println();
            row++;

//            System.out.println("after: " + board[row][col] + row);
//            System.out.println(col);
        }
    }

}
