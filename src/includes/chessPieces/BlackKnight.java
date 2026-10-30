package includes.chessPieces;
import java.io.FileNotFoundException;
import includes.chessBoard.ChessBoard;
import includes.chessBoard.GridSpace;

public class BlackKnight extends Knight {
    
     public BlackKnight() throws FileNotFoundException {
        super();
        super.setFinalSpritePath("\\b_Knight.png");
        super.loadImageView(super.getFinalSpritePath());
    }

    @Override 
    public boolean isValidMove(ChessBoard chessBoard, GridSpace currentSpace){
        if(currentSpace.getCurrentPiece() == null) return true;
        if(currentSpace.getCurrentPiece() != null
            && super.isWhitePiece(currentSpace)) return true;
        return false;
    }
}
