package includes.chessPieces;

import java.io.FileNotFoundException;
import includes.chessBoard.GridSpace;
import includes.chessBoard.ChessBoard;

public abstract class Pawn extends Piece {

    public Pawn() throws FileNotFoundException{
        super();
    }

    @Override 
    public abstract GridSpace[] getAvailableMoves(ChessBoard chessboard);
}
