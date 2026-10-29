package includes.chessPieces;

import java.io.FileNotFoundException;
import includes.chessBoard.GridSpace;
import includes.chessBoard.ChessBoard;

public abstract class Pawn extends Piece {
   private boolean firstMove;

    public Pawn() throws FileNotFoundException{
        super();
        super.loadImageView(super.getSpritePath() + "\\w_Pawn.png");
        this.firstMove = true;
    }

    public boolean isFirstMove() { return this.firstMove; }
    public void toggleFirstMove() { this.firstMove = !this.firstMove; }

    public abstract GridSpace[] getAvailableMoves(ChessBoard chessboard);
}
