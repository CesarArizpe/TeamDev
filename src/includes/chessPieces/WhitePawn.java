package includes.chessPieces;

import java.io.FileNotFoundException;
import includes.chessBoard.GridSpace;
import includes.chessBoard.ChessBoard;

public class WhitePawn extends Pawn {

    public WhitePawn() throws FileNotFoundException{
        super();
        super.loadImageView(super.getSpritePath() + "\\w_Pawn.png");
    }

    public GridSpace[] getAvailableMoves(ChessBoard chessboard){
        GridSpace[] availableMoves = new GridSpace[5];
        int moveCounter = 0;
        if(super.getGridY() - 1 > -1 && chessboard.getBoard()[super.getGridY() - 1][super.getGridX()].getCurrentPiece() == null){
            availableMoves[moveCounter] = chessboard.getBoard()[super.getGridY() - 1][super.getGridX()];
            moveCounter += 1;
        }
        if(super.isFirstMove() && super.getGridY() - 2 > -1 && chessboard.getBoard()[super.getGridY() - 2][super.getGridX()].getCurrentPiece() == null){
            availableMoves[moveCounter] = chessboard.getBoard()[super.getGridY() - 2][super.getGridX()];
            moveCounter += 1;
        }

        return availableMoves;
    }
}
