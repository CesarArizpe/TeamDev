package includes.chessPieces;

import java.io.FileNotFoundException;

import includes.chessBoard.ChessBoard;
import includes.chessBoard.GridSpace;

public abstract class Knight extends Piece{

    public Knight() throws FileNotFoundException{
        super();
    }

    @Override 
    public GridSpace[] getAvailableMoves(ChessBoard chessBoard){

        GridSpace currentSpace = super.getGridSpace();
        GridSpace[] availableMoves = new GridSpace[28];

        int moveCounter = 0;

        // CHECK UP MOVES
        if(currentSpace.getGridY() - 2 > -1){
            // CHECK UP AND LEFT MOVE
            if(currentSpace.getGridX() - 1 > -1 && isValidMove(chessBoard, chessBoard.getBoard()[currentSpace.getGridY() - 2][currentSpace.getGridX() - 1])){
                availableMoves[moveCounter] = chessBoard.getBoard()[currentSpace.getGridY() - 2][currentSpace.getGridX() - 1];
                moveCounter += 1;
            }
            // CHECK UP AND RIGHT MOVE
            if(currentSpace.getGridX() + 1 < 8 && isValidMove(chessBoard, chessBoard.getBoard()[currentSpace.getGridY() - 2][currentSpace.getGridX() + 1])){
                availableMoves[moveCounter] = chessBoard.getBoard()[currentSpace.getGridY() - 2][currentSpace.getGridX() + 1];
                moveCounter += 1;
            }
        }
        // CHECK DOWN MOVES
        if(currentSpace.getGridY() + 2 < 8){
            // CHECK DOWN AND LEFT MOVE
            if(currentSpace.getGridX() - 1 > -1 && isValidMove(chessBoard, chessBoard.getBoard()[currentSpace.getGridY() + 2][currentSpace.getGridX() - 1])){
                availableMoves[moveCounter] = chessBoard.getBoard()[currentSpace.getGridY() + 2][currentSpace.getGridX() - 1];
                moveCounter += 1;
            }
            // CHECK DOWN AND RIGHT MOVE
            if(currentSpace.getGridX() + 1 < 8 && isValidMove(chessBoard, chessBoard.getBoard()[currentSpace.getGridY() + 2][currentSpace.getGridX() + 1])){
                availableMoves[moveCounter] = chessBoard.getBoard()[currentSpace.getGridY() + 2][currentSpace.getGridX() + 1];
                moveCounter += 1;
            }
        }

        // CHECK LEFT MOVES
        if(currentSpace.getGridX() - 2 > -1){
            // CHECK LEFT AND UP
            if(currentSpace.getGridY() - 1 > -1 && isValidMove(chessBoard, chessBoard.getBoard()[currentSpace.getGridY() - 1][ currentSpace.getGridX() - 2])){
                availableMoves[moveCounter] = chessBoard.getBoard()[currentSpace.getGridY() - 1][ currentSpace.getGridX() - 2];
                moveCounter += 1;
            }
            // CHECK LEFT AND DOWN
            if(currentSpace.getGridY() + 1 < 8 && isValidMove(chessBoard, chessBoard.getBoard()[currentSpace.getGridY() + 1][ currentSpace.getGridX() - 2])){
                availableMoves[moveCounter] = chessBoard.getBoard()[currentSpace.getGridY() + 1][ currentSpace.getGridX() - 2];
                moveCounter += 1;
            }

        }
        // CHECK RIGHT MOVES
        if(currentSpace.getGridX() + 2 < 8){
            // CHECK RIGHT AND UP
            if(currentSpace.getGridY() - 1 > -1 && isValidMove(chessBoard, chessBoard.getBoard()[currentSpace.getGridY() - 1][ currentSpace.getGridX() + 2])){
                availableMoves[moveCounter] = chessBoard.getBoard()[currentSpace.getGridY() - 1][ currentSpace.getGridX() + 2];
                moveCounter += 1;
            }
            // CHECK RIGHT AND DOWN
            if(currentSpace.getGridY() + 1 < 8 && isValidMove(chessBoard, chessBoard.getBoard()[currentSpace.getGridY() + 1][ currentSpace.getGridX() + 2])){
                availableMoves[moveCounter] = chessBoard.getBoard()[currentSpace.getGridY() + 1][ currentSpace.getGridX() + 2];
                moveCounter += 1;
            }

        }
        return availableMoves;
    }
  
    @Override 
    public abstract boolean isValidMove(ChessBoard chessBoard, GridSpace currentSpace);
}