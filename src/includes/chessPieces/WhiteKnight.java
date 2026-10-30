package includes.chessPieces;
import java.io.FileNotFoundException;
import includes.chessBoard.ChessBoard;
import includes.chessBoard.GridSpace;

public class WhiteKnight extends Knight{
    public WhiteKnight() throws FileNotFoundException {
        super();
        super.setFinalSpritePath("\\w_Knight.png");
        super.loadImageView(super.getFinalSpritePath());
    }

    @Override 
    public boolean isValidMove(ChessBoard chessBoard, GridSpace currentSpace){
        if(currentSpace.getCurrentPiece() == null) return true;
        if(currentSpace.getCurrentPiece() != null
            && super.isBlackPiece(currentSpace)) return true;
        return false;
    }
}
