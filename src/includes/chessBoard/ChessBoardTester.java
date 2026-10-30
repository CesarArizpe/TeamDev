package includes.chessBoard;

import includes.chessPieces.Piece;
import javafx.scene.paint.Color;

public class ChessBoardTester {
    private GridSpace [][] board;
    private Piece activePiece;

    public ChessBoardTester(){
        this.board = new GridSpace[8][8];

        boolean whiteSpace = true;
        int xpos = 20;
        int ypos = 169;
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                this.board[i][j] = new GridSpace(xpos, ypos, 
                    whiteSpace == true ? Color.rgb(180, 180, 180) : Color.rgb(70, 70, 70)
                    , j, i);
                xpos += 64;
                whiteSpace = !whiteSpace;
            }
            whiteSpace = !whiteSpace;
            ypos += 64;
            xpos = 20;
        }
        this.activePiece = null;
    }

    public GridSpace[][] getBoard() { return this.board; }
    public Piece getActivePiece() { return this.activePiece; }

    public void setActivePiece(Piece piece) { this.activePiece = piece;}

    public void addPiece(int gridX, int gridY, Piece piece){
        piece.setXPos(this.board[gridX][gridY].getPieceXPos());
        piece.setYPos(this.board[gridX][gridY].getPieceYPos());
        piece.setGridSpace(this.board[gridX][gridY]);
        
        this.board[gridX][gridY].setCurrentPiece(piece);
    }

    public void movePiece(GridSpace oldSpace, GridSpace newSpace, Piece piece){
        oldSpace.setCurrentPiece(null);
        piece.setXPos(newSpace.getPieceXPos());
        piece.setYPos(newSpace.getPieceYPos());
        piece.setGridX(newSpace.getGridX());
        piece.setGridY(newSpace.getGridY());

        this.board[newSpace.getGridX()][newSpace.getGridY()].setCurrentPiece(piece);
        this.activePiece = null;
    }
    
}
