package wed.tictactoe;

/**
 *
 * @author john
 */
public class BoardToken {
    private char token;
    
    public static BoardToken createEmptyToken() {
        return new BoardToken(' ');
    }
    
    public static BoardToken createXToken() {
        return new BoardToken('X');
    }
    
    public static BoardToken createOToken() {
        return new BoardToken('O');
    }
    
    private BoardToken(char token) {
        this.token = token;
    }
    
    public char getToken() {
        return this.token;
    }
    
    public boolean equals(BoardToken other) {
        return this.token == other.token;
    }
    
    public String toString() {
        return String.valueOf(this.token);
    }
}
