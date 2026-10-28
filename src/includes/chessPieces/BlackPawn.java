package includes.chessPieces;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import includes.chessBoard.GridSpace;
import includes.chessBoard.ChessBoard;

public class BlackPawn extends WhitePawn {
    public BlackPawn() throws FileNotFoundException{
        super();
        super.loadImageView("C:\\Users\\Cesar\\Programming\\Java\\Chess\\ChessApp\\src\\includes\\sprites\\b_Pawn.png");
    }

    @Override 
    public GridSpace[] getAvailableMoves(ChessBoard chessboard){
        GridSpace[] availableMoves = new GridSpace[5];
        int moveCounter = 0;
        if(chessboard.getBoard()[super.getGridX() + 1][super.getGridY()].getCurrentPiece() == null){
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
