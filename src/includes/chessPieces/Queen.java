package includes.chessPieces;
import java.io.FileNotFoundException;
import includes.chessBoard.ChessBoard;
import includes.chessBoard.GridSpace;

public abstract class Queen extends Piece {
    public Queen() throws FileNotFoundException{
        super();
    }

    @Override 
    public GridSpace[] getAvailableMoves(ChessBoard chessBoard){
        GridSpace[] availableMoves = new GridSpace[28];
        int moveCounter = 0;
        GridSpace currentSpace = null;

        // CHECK UP MOVES
        int xSpacesToCheck = super.getGridY() - 1;
        int ySpacesToCheck = 0;
        while(xSpacesToCheck > -1){
            currentSpace = chessBoard.getBoard()[xSpacesToCheck][super.getGridX()];
            
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
                xSpacesToCheck -= 1;
            }
        }

        // CHECK DOWN MOVES
        xSpacesToCheck = super.getGridY() + 1;
        while(xSpacesToCheck < 8){
            currentSpace = chessBoard.getBoard()[xSpacesToCheck][super.getGridX()];
            
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
                xSpacesToCheck += 1;
            }
            
        }

        // CHECK LEFT MOVES
        xSpacesToCheck = super.getGridX() - 1;
        while(xSpacesToCheck > -1){
            currentSpace = chessBoard.getBoard()[super.getGridY()][xSpacesToCheck];
            
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
                xSpacesToCheck -= 1;
            }
        }

        // CHECK RIGHT MOVES
        xSpacesToCheck = super.getGridX() + 1;
        while(xSpacesToCheck < 8){
            currentSpace = chessBoard.getBoard()[super.getGridY()][xSpacesToCheck];
            
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
                xSpacesToCheck += 1;
            }
            
        }

        // CHECK TOP RIGHT DIAGONAL
        xSpacesToCheck = super.getGridX() + 1;
        ySpacesToCheck = super.getGridY() - 1;
        while(xSpacesToCheck < 8 && ySpacesToCheck > -1){
            currentSpace = chessBoard.getBoard()[ySpacesToCheck][xSpacesToCheck];

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
                xSpacesToCheck += 1;
                ySpacesToCheck -= 1;
            }
        }

        // CHECK TOP LEFT DIAGONAL
        xSpacesToCheck = super.getGridX() - 1;
        ySpacesToCheck = super.getGridY() - 1;
        while(xSpacesToCheck > -1 && ySpacesToCheck > -1){
            currentSpace = chessBoard.getBoard()[ySpacesToCheck][xSpacesToCheck];

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
                xSpacesToCheck -= 1;
                ySpacesToCheck -= 1;
            }
        }
        
        // CHECK BOTTOM RIGHT DIAGONAL
        xSpacesToCheck = super.getGridX() + 1;
        ySpacesToCheck = super.getGridY() + 1;
        while(xSpacesToCheck < 8 && ySpacesToCheck < 8){
            currentSpace = chessBoard.getBoard()[ySpacesToCheck][xSpacesToCheck];

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
                xSpacesToCheck += 1;
                ySpacesToCheck += 1;
            }
        }
        
        // CHECK BOTTOM LEFT DIAGONAL
        xSpacesToCheck = super.getGridX() - 1;
        ySpacesToCheck = super.getGridY() + 1;
        while(xSpacesToCheck > -1 && ySpacesToCheck < 8){
            currentSpace = chessBoard.getBoard()[ySpacesToCheck][xSpacesToCheck];

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
                xSpacesToCheck -= 1;
                ySpacesToCheck += 1;
            }
        }


        return availableMoves;
    }

    @Override 
    public abstract boolean isValidMove(ChessBoard chessBoard, GridSpace currentSpace);
}
