package includes.chessPieces;
import java.io.FileNotFoundException;

import includes.chessBoard.GridSpace;
import includes.chessBoard.ChessBoard;

public class BlackPawn extends Pawn {
    public BlackPawn() throws FileNotFoundException{
        super.setFinalSpritePath("\\b_Pawn.png");
        super.loadImageView(super.getFinalSpritePath());
    }

    @Override 
    public GridSpace[] getAvailableMoves(ChessBoard chessboard){
        GridSpace[] availableMoves = new GridSpace[5];
        int moveCounter = 0;
        if(super.getGridY() + 1 < 8 && chessboard.getBoard()[super.getGridY() + 1][super.getGridX()].getCurrentPiece() == null){
            availableMoves[moveCounter] = chessboard.getBoard()[super.getGridY() + 1][super.getGridX()];
            moveCounter += 1;
        }
        if(super.getGridY() == 1 && super.getGridY() + 2 < 8 && chessboard.getBoard()[super.getGridY() + 2][super.getGridX()].getCurrentPiece() == null){
            availableMoves[moveCounter] = chessboard.getBoard()[super.getGridY() + 2][super.getGridX()];
            moveCounter += 1;
        }
        if(super.getGridY() + 1 < 8 && super.getGridX() + 1 < 7 && isWhitePiece(chessboard.getBoard()[super.getGridY() + 1][super.getGridX() + 1])){
            availableMoves[moveCounter] = chessboard.getBoard()[super.getGridY() + 1][super.getGridX() + 1];
            chessboard.getBoard()[super.getGridY() + 1][super.getGridX() + 1].getHoverRect().toFront();
            moveCounter += 1;
        }
        if(super.getGridY() + 1 < 8 && super.getGridX() - 1 > -1 && isWhitePiece(chessboard.getBoard()[super.getGridY() + 1][super.getGridX() -1])){
            availableMoves[moveCounter] = chessboard.getBoard()[super.getGridY() + 1][super.getGridX() - 1];
            chessboard.getBoard()[super.getGridY() + 1][super.getGridX() + 1].getHoverRect().toFront();
            moveCounter += 1;
        }

        return availableMoves;
    }

    public static boolean isWhitePiece(GridSpace space){
        if(space.getCurrentPiece() != null && space.getCurrentPiece().getFinalSpritePath().contains("w_")) return true;
        return false;
    }
}
