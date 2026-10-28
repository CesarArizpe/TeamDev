package includes.chessPieces;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import includes.chessBoard.GridSpace;
import javafx.scene.image.Image;
import includes.chessBoard.ChessBoard;

public class WhitePawn extends Piece {
   private boolean firstMove;

    public WhitePawn() throws FileNotFoundException{
        super();
        super.loadImageView("C:\\Users\\Cesar\\Programming\\Java\\Chess\\ChessApp\\src\\includes\\sprites\\w_Pawn.png");
        this.firstMove = true;
    }

    public boolean isFirstMove() { return this.firstMove; }
    public void toggleFirstMove() { this.firstMove = !this.firstMove; }

    public GridSpace[] getAvailableMoves(ChessBoard chessboard){
        GridSpace[] availableMoves = new GridSpace[5];
        int moveCounter = 0;
        if(chessboard.getBoard()[super.getGridX() - 1][super.getGridY()].getCurrentPiece() == null){
            availableMoves[moveCounter] = chessboard.getBoard()[super.getGridX() - 1][super.getGridY()];
            moveCounter += 1;
        }
        if(firstMove && chessboard.getBoard()[super.getGridX() - 1][super.getGridY()].getCurrentPiece() == null){
            availableMoves[moveCounter] = chessboard.getBoard()[super.getGridX() - 2][super.getGridY()];
            moveCounter += 1;
        }

        return availableMoves;
    }
}
