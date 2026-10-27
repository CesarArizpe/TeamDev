package includes.chessBoard;
// import javafx.scene.shape.Rectangle;

import javafx.scene.paint.Color;

public class ChessBoard {
    private GridSpace [][] board;

    public ChessBoard(){
        board = new GridSpace[8][8];

        boolean whiteSpace = true;
        int xpos = 20;
        int ypos = 169;
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                board[i][j] = new GridSpace(xpos, ypos, whiteSpace == true ? Color.WHITE : Color.BLACK);
                xpos += 64;
                whiteSpace = !whiteSpace;
            }
            whiteSpace = !whiteSpace;
            ypos += 64;
            xpos = 20;
        }
    }

    public GridSpace[][] getBoard() { return this.board; }
    
    
}
