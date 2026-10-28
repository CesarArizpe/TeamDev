package includes.chessPieces;
import java.io.FileNotFoundException;

import includes.chessBoard.GridSpace;
import includes.chessBoard.ChessBoard;

public class BlackPawn extends WhitePawn {
    public BlackPawn() throws FileNotFoundException{
        super();
        super.loadImageView( super.getSpritePath() + "\\b_Pawn.png");
    }

    @Override 
    public GridSpace[] getAvailableMoves(ChessBoard chessboard){
        GridSpace[] availableMoves = new GridSpace[5];
        int moveCounter = 0;
        if(chessboard.getBoard()[super.getGridX() + 1][super.getGridY()].getCurrentPiece() == null){
            System.out.println("nothing detected");
            availableMoves[moveCounter] = chessboard.getBoard()[super.getGridX() + 1][super.getGridY()];
            moveCounter += 1;
        }
        if(super.isFirstMove() && chessboard.getBoard()[super.getGridX() + 1][super.getGridY()].getCurrentPiece() == null){
            availableMoves[moveCounter] = chessboard.getBoard()[super.getGridX() + 2][super.getGridY()];
            moveCounter += 1;
        }

        return availableMoves;
    }
}
