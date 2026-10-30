package includes.chessPieces;

import java.io.FileNotFoundException;
import includes.chessBoard.GridSpace;
import includes.chessBoard.ChessBoard;

public class WhitePawn extends Pawn {

    public WhitePawn() throws FileNotFoundException{
        super();
        super.setFinalSpritePath("\\w_Pawn.png");
        super.loadImageView(super.getFinalSpritePath());
    }

    @Override 
    public GridSpace[] getAvailableMoves(ChessBoard chessboard){
        GridSpace[] availableMoves = new GridSpace[28];
        int moveCounter = 0;
        if(super.getGridY() - 1 > -1 && chessboard.getBoard()[super.getGridY() - 1][super.getGridX()].getCurrentPiece() == null){
            availableMoves[moveCounter] = chessboard.getBoard()[super.getGridY() - 1][super.getGridX()];
            moveCounter += 1;
        }
        if(super.getGridY() == 6 && super.getGridY() - 2 > -1 && chessboard.getBoard()[super.getGridY() - 2][super.getGridX()].getCurrentPiece() == null){
            availableMoves[moveCounter] = chessboard.getBoard()[super.getGridY() - 2][super.getGridX()];
            moveCounter += 1;
        }
        if(super.getGridY() - 1 > -1 && super.getGridX() + 1 < 8 && super.isBlackPiece(chessboard.getBoard()[super.getGridY() - 1][super.getGridX() + 1])){
            availableMoves[moveCounter] = chessboard.getBoard()[super.getGridY() - 1][super.getGridX() + 1];
                        chessboard.getBoard()[super.getGridY() + 1][super.getGridX() + 1].getHoverRect();

            moveCounter += 1;
        }
        if(super.getGridY() - 1 > -1 && super.getGridX() - 1 > -1 && super.isBlackPiece(chessboard.getBoard()[super.getGridY() - 1][super.getGridX() -1])){
            availableMoves[moveCounter] = chessboard.getBoard()[super.getGridY() - 1][super.getGridX() - 1];
                        chessboard.getBoard()[super.getGridY() + 1][super.getGridX() + 1].getHoverRect();

            moveCounter += 1;
        }

        return availableMoves;
    }
    
    @Override 
    public boolean isValidMove(ChessBoard chessBoard, GridSpace currentSpace){
        if(currentSpace.getCurrentPiece() == null) return true;
        if(currentSpace.getCurrentPiece() != null
            && super.isBlackPiece(currentSpace)) return true;
        return false;
    }
}   
