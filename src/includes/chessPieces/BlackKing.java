package includes.chessPieces;

import java.io.FileNotFoundException;

import includes.chessBoard.ChessBoard;

public class BlackKing extends King {

    public BlackKing() throws FileNotFoundException {
       super();
        super.setFinalSpritePath("\\b_King.png");
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
