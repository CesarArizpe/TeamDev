package includes.chessBoard;

import includes.chessPieces.Piece;
import includes.chessPieces.WhitePawn;
import javafx.scene.paint.Color;

public class ChessBoard {
    private GridSpace [][] board;
    private Piece activePiece;
    private boolean turnWhite;
    private boolean turnBased;

    public ChessBoard(int originalXPos, int ypos){
        this.board = new GridSpace[8][8];
        this.turnWhite = true;
        this.turnBased = true;

        boolean whiteSpace = true;
        int xpos = originalXPos;
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
            xpos = originalXPos;
        }
        this.activePiece = null;
    }

    public GridSpace[][] getBoard() { return this.board; }
    public Piece getActivePiece() { return this.activePiece; }
    public boolean isTurnWhite() { return this.turnWhite; }
    public boolean isTurnBased() { return this.turnBased; }

    public void setActivePiece(Piece piece) { this.activePiece = piece;}
    public void toggleTurnWhite() { this.turnWhite = !this.turnWhite; }
    public void toggleTurnBased() { this.turnBased = !this.turnBased; }

    public void addPiece(int gridX, int gridY, Piece piece){
        GridSpace currentSpace = this.board[gridY][gridX];
        // piece.setXPos(currentSpace.getPieceXPos());
        // piece.setYPos(currentSpace.getPieceYPos());
        // System.out.println("ADDPIECE GRID X: " + gridX);
        // piece.setGridX(currentSpace.getGridX());
        // System.out.println("PIECE GRID X: " + piece.getGridX());
        // piece.setGridY(currentSpace.getGridY());
        // piece.setGridSpace(this.board[gridY][gridX]);
        piece.setXPos(currentSpace.getPieceXPos());
        piece.setYPos(currentSpace.getPieceYPos());
        piece.setGridX(currentSpace.getGridX());
        piece.setGridY(currentSpace.getGridY());
        piece.setGridSpace(currentSpace);
        
        this.board[gridY][gridX].setCurrentPiece(piece);
    }

    public void movePiece(GridSpace oldSpace, GridSpace newSpace, Piece piece){
        oldSpace.setCurrentPiece(null);
        piece.setXPos(newSpace.getPieceXPos());
        piece.setYPos(newSpace.getPieceYPos());
        piece.setGridX(newSpace.getGridX());
        piece.setGridY(newSpace.getGridY());
        if(piece instanceof WhitePawn pawn && pawn.isFirstMove()){ pawn.toggleFirstMove(); }

        this.board[newSpace.getGridY()][newSpace.getGridX()].setCurrentPiece(piece);
        this.activePiece = null;
    }
    
}
