package includes.chessPieces;


import includes.chessBoard.ChessBoard;
import includes.chessBoard.GridSpace;

public abstract class Rook extends Piece {

    public Rook(){
        super();
    }

    @Override
    public GridSpace[] getAvailableMoves(ChessBoard chessBoard) {
        GridSpace[] availableMoves = new GridSpace[28];
        int moveCounter = 0;
        GridSpace currentSpace = null;

        // CHECK UP MOVES
        int spacesToCheck = super.getGridY() - 1;
        while(spacesToCheck > -1){
            currentSpace = chessBoard.getBoard()[spacesToCheck][super.getGridX()];
            
            if(currentSpace.getCurrentPiece() != null
            && isValidMove(chessBoard, currentSpace)){
                availableMoves[moveCounter] = currentSpace;
                moveCounter += 1;
                break;
            }else if(currentSpace.getCurrentPiece() != null
            && !isValidMove(chessBoard, currentSpace)){
                break;
            }else{
                availableMoves[moveCounter] = currentSpace;
                moveCounter += 1;
                spacesToCheck -= 1;
            }
        }
        
        // CHECK DOWN MOVES
        spacesToCheck = super.getGridY() + 1;
        while(spacesToCheck < 8){
            currentSpace = chessBoard.getBoard()[spacesToCheck][super.getGridX()];
            
            if(currentSpace.getCurrentPiece() != null
            && isValidMove(chessBoard, currentSpace)){
                availableMoves[moveCounter] = currentSpace;
                moveCounter += 1;
                break;
            }else if(currentSpace.getCurrentPiece() != null
            && !isValidMove(chessBoard, currentSpace)){
                break;
            }else{
                availableMoves[moveCounter] = currentSpace;
                moveCounter += 1;
                spacesToCheck += 1;
            }
            
        }
        
        // CHECK LEFT MOVES
        spacesToCheck = super.getGridX() - 1;
        while(spacesToCheck > -1){
            currentSpace = chessBoard.getBoard()[super.getGridY()][spacesToCheck];
            
            if(currentSpace.getCurrentPiece() != null
            && isValidMove(chessBoard, currentSpace)){
                availableMoves[moveCounter] = currentSpace;
                moveCounter += 1;
                break;
            }else if(currentSpace.getCurrentPiece() != null
            && !isValidMove(chessBoard, currentSpace)){
                break;
            }else{
                availableMoves[moveCounter] = currentSpace;
                moveCounter += 1;
                spacesToCheck -= 1;
            }
        }
        
        // CHECK RIGHT MOVES
        spacesToCheck = super.getGridX() + 1;
        while(spacesToCheck < 8){
            currentSpace = chessBoard.getBoard()[super.getGridY()][spacesToCheck];
            
            if(currentSpace.getCurrentPiece() != null
            && isValidMove(chessBoard, currentSpace)){
                availableMoves[moveCounter] = currentSpace;
                moveCounter += 1;
                break;
            }else if(currentSpace.getCurrentPiece() != null
            && !isValidMove(chessBoard, currentSpace)){
                break;
            }else{
                availableMoves[moveCounter] = currentSpace;
                moveCounter += 1;
                spacesToCheck += 1;
            }
            
        }
        
        return availableMoves;
    }
    
    public abstract boolean isValidMove(ChessBoard chessBoard, GridSpace currentSpace);
}
