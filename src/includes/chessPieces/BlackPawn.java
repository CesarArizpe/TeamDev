package includes.chessPieces;
import java.io.FileNotFoundException;

import includes.chessBoard.GridSpace;
import includes.chessBoard.ChessBoard;

public class BlackPawn extends Pawn {
    public BlackPawn() throws FileNotFoundException{
        super();
        super.loadImageView( super.getSpritePath() + "\\b_Pawn.png");
    }

    @Override 
    public GridSpace[] getAvailableMoves(ChessBoard chessboard){
        GridSpace[] availableMoves = new GridSpace[5];
        int moveCounter = 0;
        if(super.getGridY() + 1 < 9 && chessboard.getBoard()[super.getGridY() + 1][super.getGridX()].getCurrentPiece() == null){
            availableMoves[moveCounter] = chessboard.getBoard()[super.getGridY() + 1][super.getGridX()];
            moveCounter += 1;
        }
        if(super.isFirstMove() && super.getGridY() + 2 < 9 && chessboard.getBoard()[super.getGridY() + 2][super.getGridX()].getCurrentPiece() == null){
            availableMoves[moveCounter] = chessboard.getBoard()[super.getGridY() + 2][super.getGridX()];
            moveCounter += 1;
        }

        return availableMoves;
    }
}
