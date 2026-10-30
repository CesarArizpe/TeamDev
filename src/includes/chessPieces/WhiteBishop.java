package includes.chessPieces;

import java.io.FileNotFoundException;

import includes.chessBoard.ChessBoard;

public class WhiteBishop extends Bishop {

    public WhiteBishop() throws FileNotFoundException {
        super();
        super.setFinalSpritePath("\\w_Bishop.png");
        super.loadImageView(super.getFinalSpritePath());
    }

    @Override
    public boolean isValidMove(ChessBoard chessBoard, includes.chessBoard.GridSpace currentSpace) {
        if(currentSpace.getCurrentPiece() == null) return true;
        if(currentSpace.getCurrentPiece() != null
            && super.isBlackPiece(currentSpace)) return true;
        return false;
    }
    
}
