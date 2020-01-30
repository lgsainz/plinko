public class PlinkoGame {

    /**
     * Play a round of Plinko.
     */
    public static void main(String[] args) {
        generateBoard(5,5);
//        dropPin(2);
    }

    /**
     * Generate new board of dimensions row x col with alternating L, R.
     */
    public static void generateBoard(int rows, int cols) {
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
    }

    /**
     * Print the board to the console.
     */
    public static void printBoard(String[][] board) {
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
    public static void dropPin(String[][] board, int col) {

    }

}
