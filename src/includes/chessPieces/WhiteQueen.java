package includes.chessPieces;

import java.io.FileNotFoundException;

import includes.chessBoard.ChessBoard;

public class WhiteQueen extends Queen{

    public WhiteQueen() throws FileNotFoundException {
        super();
        super.setFinalSpritePath("\\w_Queen.png");
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
