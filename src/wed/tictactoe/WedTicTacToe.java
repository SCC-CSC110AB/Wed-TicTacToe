package wed.tictactoe;

import java.util.Scanner;

/**
 *
 * @author john
 */
public class WedTicTacToe {

    public static boolean isRowOrColumnValid(int rowOrCol) {
        if (rowOrCol < 0 || rowOrCol >= GameBoard.BOARD_SIZE) {
            return false;
        }

        return true;
    }

    public static int[] getUserTokenPlacement(GameBoard board) {
        int[] result = new int[2];
        int row = 0;
        int col = 0;
        boolean isValid = false;
        Scanner stdin = new Scanner(System.in);

        do {
            if (board.getIsPlayerOnesTurn()) {
                System.out.println("Player 1's turn (X)");
            } else {
                System.out.println("Player 2's turn (O)");
            }

            try {
                System.out.println("Enter the row: ");
                row = stdin.nextInt();

                System.out.println("Enter the column: ");
                col = stdin.nextInt();

                if (isRowOrColumnValid(row)
                        && isRowOrColumnValid(col)
                        && board.isSpotOpen(row, col)) {
                    isValid = true;
                } else {
                    System.out.println("Invalid input, please try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input, please try again.");
                stdin.nextLine();
            }
        } while (isValid == false);

        result[0] = row;
        result[1] = col;

        return result;
    }

    public static void playGame() {
        GameBoard board = new GameBoard();

        do {
            int[] rowAndCol;
            int row;
            int col;
            BoardToken token;

            System.out.println(board);

            rowAndCol = getUserTokenPlacement(board);
            row = rowAndCol[0];
            col = rowAndCol[1];

            if (board.getIsPlayerOnesTurn()) {
                token = BoardToken.createXToken();
            } else {
                token = BoardToken.createOToken();
            }

            board.placeToken(token, row, col);

        } while (board.isGameOver() == false);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        boolean keepPlaying = true;

        System.out.println("Welcome to Tic-Tac-Toe!");

        do {
            char userResponse;
            playGame();
            
            System.out.println("Would you like to play again (y/n)?");
            userResponse = stdin.nextLine().charAt(0);
            
            switch (userResponse) {
                case 'y':
                case 'Y':
                    keepPlaying = true;
                    break;
                default:
                    keepPlaying = false;
            }
        } while (keepPlaying);
    }

}
