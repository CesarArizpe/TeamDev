package includes.chessPieces;

import java.io.FileNotFoundException;

import includes.chessBoard.ChessBoard;

public class BlackBishop extends Bishop {

    public BlackBishop() throws FileNotFoundException {
        super();
        super.setFinalSpritePath("\\b_Bishop.png");
        super.loadImageView(super.getFinalSpritePath());
    }

   @Override
    public boolean isValidMove(ChessBoard chessBoard, includes.chessBoard.GridSpace currentSpace) {
        if(currentSpace.getCurrentPiece() == null) return true;
        if(currentSpace.getCurrentPiece() != null
            && super.isWhitePiece(currentSpace)) return true;
        return false;
    }
    
}
