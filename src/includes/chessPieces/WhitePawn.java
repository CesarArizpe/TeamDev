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


    public GridSpace[] getAvailableMoves(ChessBoard chessboard){
        GridSpace[] availableMoves = new GridSpace[5];
        int moveCounter = 0;
        if(super.getGridY() - 1 > -1 && chessboard.getBoard()[super.getGridY() - 1][super.getGridX()].getCurrentPiece() == null){
            availableMoves[moveCounter] = chessboard.getBoard()[super.getGridY() - 1][super.getGridX()];
            moveCounter += 1;
        }
        if(super.getGridY() == 6 && super.getGridY() - 2 > -1 && chessboard.getBoard()[super.getGridY() - 2][super.getGridX()].getCurrentPiece() == null){
            availableMoves[moveCounter] = chessboard.getBoard()[super.getGridY() - 2][super.getGridX()];
            moveCounter += 1;
        }
        if(super.getGridY() - 1 > -1 && super.getGridX() + 1 < 7 && isBlackPiece(chessboard.getBoard()[super.getGridY() - 1][super.getGridX() + 1])){
            availableMoves[moveCounter] = chessboard.getBoard()[super.getGridY() - 1][super.getGridX() + 1];
                        chessboard.getBoard()[super.getGridY() + 1][super.getGridX() + 1].getHoverRect().toFront();

            moveCounter += 1;
        }
        if(super.getGridY() - 1 > -1 && super.getGridX() - 1 > -1 && isBlackPiece(chessboard.getBoard()[super.getGridY() - 1][super.getGridX() -1])){
            availableMoves[moveCounter] = chessboard.getBoard()[super.getGridY() - 1][super.getGridX() - 1];
                        chessboard.getBoard()[super.getGridY() + 1][super.getGridX() + 1].getHoverRect().toFront();

            moveCounter += 1;
        }

        return availableMoves;
    }

    public static boolean isBlackPiece(GridSpace space){
        if(space.getCurrentPiece() != null && space.getCurrentPiece().getFinalSpritePath().contains("b_")) return true;
        return false;
    }
}   
