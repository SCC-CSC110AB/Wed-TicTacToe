package wed.tictactoe;

/**
 *
 * @author john
 */
public class GameBoard {
    public static final int BOARD_SIZE = 3;
    
    private BoardToken[][] boardState;
    private boolean isPlayerOnesTurn;
    
    public GameBoard() {
        boardState = new BoardToken[BOARD_SIZE][BOARD_SIZE];
        isPlayerOnesTurn = true;
        
        for (int i = 0; i < boardState.length; i++) {
            for (int j = 0; j < boardState[i].length; j++) {
                boardState[i][j] = BoardToken.createEmptyToken();
            }
        }
    }
    
    public void placeToken(BoardToken token, int row, int col) {
        boardState[row][col] = token;
        isPlayerOnesTurn = !isPlayerOnesTurn;
    }
    
    public boolean isSpotOpen(int row, int col) {
        BoardToken token = boardState[row][col];
        
        return token.equals(BoardToken.createEmptyToken());
    }
    
    public String toString() {
        String result = "\n";
        
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (i != 0) {
                result += "-+-+-\n";
            }
            
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (j != 0) {
                    result += "|";
                }
                
                result += boardState[i][j];
            }
            
            result += "\n";
        }
        
        return result + "\n";
    }
    
    public BoardToken getWinnerToken() {
        return BoardToken.createEmptyToken();
    }
    
    public boolean isGameOver() {
        return false;
    }
    
    public boolean getIsPlayerOnesTurn() {
        return this.isPlayerOnesTurn;
    }
}
