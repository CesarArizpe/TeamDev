package includes.chessBoard;

import includes.chessPieces.Piece;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

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
        piece.setXPos(currentSpace.getPieceXPos());
        piece.setYPos(currentSpace.getPieceYPos());
        piece.setGridX(currentSpace.getGridX());
        piece.setGridY(currentSpace.getGridY());
        piece.setGridSpace(currentSpace);
        currentSpace.setCurrentPiece(piece);
        
        this.board[gridY][gridX].setCurrentPiece(piece);
    }

    public void movePiece(GridSpace oldSpace, GridSpace newSpace, Piece piece){
        oldSpace.setCurrentPiece(null);
        piece.setXPos(newSpace.getPieceXPos());
        piece.setYPos(newSpace.getPieceYPos());
        piece.setGridX(newSpace.getGridX());
        piece.setGridY(newSpace.getGridY());
        piece.setGridSpace(newSpace);
        newSpace.setCurrentPiece(piece);

        // this.board[newSpace.getGridY()][newSpace.getGridX()].setCurrentPiece(piece);
        this.activePiece = null;
    }
    
    public void capturePiece(Piece piece, Piece capture){
        System.out.println("CAPTURE PIECE = " + capture);
        this.board[piece.getGridY()][piece.getGridX()].setCurrentPiece(null);
        this.board[capture.getGridY()][capture.getGridX()].setCurrentPiece(piece);
        System.out.println(piece.getGridX() + ", " + piece.getGridY() + " should be NULL");
        piece.setXPos(capture.getXPos());
        piece.setYPos(capture.getYPos());
        piece.setGridX(capture.getGridX());
        piece.setGridY(capture.getGridY());
        piece.setGridSpace(capture.getGridSpace());
        System.out.println("PIECE THAT CAPTURED - " + piece);
        System.out.println("X: " + piece.getGridX() + "Y: " + piece.getGridY());

        this.activePiece = null;
        // capture = null;

        Pane parent = (Pane) capture.getHitbox().getParent();

        parent.getChildren().removeAll(
            capture.getHitbox(),
            capture.getImageView()
        );

        capture.getHitbox().setVisible(false);
        capture.getHitbox().setMouseTransparent(true);
    }

    public void toggleAllSpaces(){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                GridSpace gridSpace = this.board[i][j];
                gridSpace.getHoverRect().setVisible(!gridSpace.getHoverRect().isVisible());
                gridSpace.getHoverRect().setMouseTransparent(!gridSpace.getHoverRect().isMouseTransparent());
                
            }
        }
    }
    
    public void toggleAvailableSpaces(GridSpace[] availablSpaces){
        for(GridSpace gridSpace : availablSpaces){
            if(gridSpace != null){
                gridSpace.getHoverRect().setVisible(!gridSpace.getHoverRect().isVisible());
                gridSpace.getHoverRect().setMouseTransparent(!gridSpace.getHoverRect().isMouseTransparent());
            }
        }
    }

    public void toggleActiveSpaces(){
         for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                GridSpace gridSpace = this.board[i][j];
                if(gridSpace.getHoverRect().isVisible()){
                    gridSpace.getHoverRect().setVisible(false);
                    gridSpace.getHoverRect().setMouseTransparent(true);
                }           
            }
        }
    }

    public void spacesWithPieces(){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                GridSpace gridSpace = this.board[i][j];
                if(gridSpace.getCurrentPiece() != null){
                    System.out.println("SPACE: X:" + gridSpace.getGridX() + " Y: " + gridSpace.getGridY());
                }     
            }
        }
    }

    public void checkOverlappingArea(Rectangle rect1){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                GridSpace gridSpace = this.board[i][j];
                
                System.out.println(overlappingArea(rect1, gridSpace.getHoverRect()));
            }
        }
    }

    public GridSpace getClosestGridSpace(Rectangle rect1){
        GridSpace space = null;
        double largestOverlappingArea = 0;
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                GridSpace currentSpace = this.board[i][j];
                double overlap = overlappingArea(rect1, currentSpace.getHoverRect());
                
                if(overlap > largestOverlappingArea){
                    largestOverlappingArea = overlap;
                    space = currentSpace;
                }
            }
        }
        return space;
    }

    public GridSpace getClosestMove(GridSpace[] availSpaces, Rectangle rect2){
        GridSpace space = null;
        double largestOverlappingArea = 0;

        for(int i = 0; i < 5; i++){
            if(availSpaces[i] != null){
                GridSpace currentSpace = availSpaces[i];
                double overlap = overlappingArea(currentSpace.getHoverRect(), rect2);
                if(overlap > largestOverlappingArea){
                    largestOverlappingArea = overlap;
                    space = currentSpace;
                }
            }
        }
        return space;
    }


    public double overlappingArea(Rectangle r1, Rectangle r2) {
        double left = Math.max(r1.getBoundsInParent().getMinX(),
                            r2.getBoundsInParent().getMinX());

        double right = Math.min(r1.getBoundsInParent().getMaxX(),
                                r2.getBoundsInParent().getMaxX());

        double top = Math.max(r1.getBoundsInParent().getMinY(),
                            r2.getBoundsInParent().getMinY());

        double bottom = Math.min(r1.getBoundsInParent().getMaxY(),
                                r2.getBoundsInParent().getMaxY());

        if (right <= left || bottom <= top) {
            return 0.0;
        }

        return (right - left) * (bottom - top);
    }
    
}
