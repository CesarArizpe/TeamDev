
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.layout.Pane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import includes.chessBoard.ChessBoard;
import includes.chessBoard.GridSpace;
import includes.chessPieces.Piece;
import includes.chessPieces.WhitePawn;
import includes.chessPieces.BlackPawn;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.Button;

public class ChessTester extends Application{
    private int screenWidth = 900;
    private int screenHeight = 850;

    public void start(Stage stage) throws FileNotFoundException{
        stage.setTitle("ChessTester.java");
        stage.getIcons().add(new Image(new FileInputStream(System.getProperty("user.dir") + "\\src\\includes\\sprites\\W_King.png")));
        stage.setResizable(false);
        System.out.println("This is CHESS TESTER");

        Pane root = new Pane();
        root.setPrefWidth(screenWidth);
        root.setPrefHeight(screenHeight);

        ChessBoard chessBoard = new ChessBoard(20, screenHeight / 2 - 256);

        drawGrid(chessBoard, root);

        // drawDots(root); 
        // GridSpace space = chessBoard.getBoard()[6][0];
        Piece whitePawn = new WhitePawn();
        Piece blackPawn = new BlackPawn();

        addPiece(chessBoard, whitePawn, 0, 6, root);
        addPiece(chessBoard, blackPawn, 0, 1, root);

        Button toggleTurnButton = new Button("Toggle Turn-Based Play");
        // toggleTurnButton.setPrefHeight(30);
        // toggleTurnButton.setPrefWidth(70);
        toggleTurnButton.setLayoutX(20 + 512);
        toggleTurnButton.setLayoutY(screenHeight - 512 - 256);
        
        toggleTurnButton.setOnAction(event -> {
            chessBoard.toggleTurnBased();
            System.out.println("TURN BASED : " + chessBoard.isTurnBased());
        });


        root.getChildren().add(toggleTurnButton);


        spacesWithPieces(chessBoard);

        Scene scene = new Scene(root, screenWidth, screenHeight, Color.GREY);
        root.setStyle("-fx-background-color: grey;");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args){
        launch(args);
    }


    public static void drawDots(Pane root){
        double xpos = 20;
        double ypos = 169;
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                root.getChildren().add(new Circle(xpos, ypos, 2, Color.RED));
                xpos += 64;
            }
            xpos = 20;
            ypos += 64;
        }
    }

    public static void drawGrid(ChessBoard chessBoard, Pane root){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                GridSpace gridSpace = chessBoard.getBoard()[i][j];
                root.getChildren().add(gridSpace.getGridRect());
                root.getChildren().add(gridSpace.getHoverRect());
                gridSpace.getHoverRect().setVisible(false);
                gridSpace.getHoverRect().setMouseTransparent(true);

                gridSpace.getHoverRect().setOnMouseClicked(event -> {

                    if(chessBoard.isTurnBased()){
                        if(isCorrectColorTurn(chessBoard.getActivePiece(), chessBoard.isTurnWhite())){
                            chessBoard.movePiece(chessBoard.getActivePiece().getGridSpace(), gridSpace, chessBoard.getActivePiece());
                            toggleActiveSpaces(chessBoard);
                            spacesWithPieces(chessBoard);
                            chessBoard.toggleTurnWhite();
                        }
                    }else{
                        chessBoard.movePiece(chessBoard.getActivePiece().getGridSpace(), gridSpace, chessBoard.getActivePiece());
                        toggleActiveSpaces(chessBoard);
                        spacesWithPieces(chessBoard);
                        chessBoard.toggleTurnWhite();
                    }
                });
            }
        }
    }

    public static void addPiece(
        ChessBoard chessBoard, Piece piece,
        int gridX, int gridY, Pane root) {

        chessBoard.addPiece(gridX, gridY, piece);

        Rectangle hitbox = piece.getHitbox();
        root.getChildren().add(hitbox);

        ImageView image = piece.getImageView();
        root.getChildren().add(image);

        hitbox.setOnMouseClicked(event -> {
            handlePieceClick(chessBoard, event, piece);
        });

        image.setOnMouseClicked(event -> {
            handlePieceClick(chessBoard, event, piece);
        });

    }

    public static void handlePieceClick(ChessBoard chessBoard, MouseEvent event, Piece piece){
        if(chessBoard.isTurnBased()){
            if(chessBoard.getActivePiece() == piece){
                toggleActiveSpaces(chessBoard);
                chessBoard.setActivePiece(null);
            }else if((chessBoard.getActivePiece() == null || chessBoard.getActivePiece() != piece) && isCorrectColorTurn(piece, chessBoard.isTurnWhite())){
                chessBoard.setActivePiece(piece);
                toggleActiveSpaces(chessBoard);
                System.out.println("BEFORE METHOD GRID X:" + piece.getGridX() + " Y: " + piece.getGridY());
                toggleAvailableSpaces(chessBoard, piece.getAvailableMoves(chessBoard));
            }
        }else{
            if(chessBoard.getActivePiece() == piece){
                toggleActiveSpaces(chessBoard);
                chessBoard.setActivePiece(null);
            }else if(chessBoard.getActivePiece() == null){
                chessBoard.setActivePiece(piece);
                toggleActiveSpaces(chessBoard);
                toggleAvailableSpaces(chessBoard, piece.getAvailableMoves(chessBoard));
            }
        }


       
        event.consume();
    }

    public static void toggleAllSpaces(ChessBoard chessBoard){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                GridSpace gridSpace = chessBoard.getBoard()[i][j];
                gridSpace.getHoverRect().setVisible(!gridSpace.getHoverRect().isVisible());
                gridSpace.getHoverRect().setMouseTransparent(!gridSpace.getHoverRect().isMouseTransparent());
                
            }
        }
    }
    
    public static void toggleAvailableSpaces(ChessBoard chessBoard, GridSpace[] availablSpaces){
        for(GridSpace gridSpace : availablSpaces){
            if(gridSpace != null){
                gridSpace.getHoverRect().setVisible(!gridSpace.getHoverRect().isVisible());
                gridSpace.getHoverRect().setMouseTransparent(!gridSpace.getHoverRect().isMouseTransparent());
            }
        }
    }

    public static void toggleActiveSpaces(ChessBoard chessBoard){
         for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                GridSpace gridSpace = chessBoard.getBoard()[i][j];
                if(gridSpace.getHoverRect().isVisible()){
                    gridSpace.getHoverRect().setVisible(false);
                    gridSpace.getHoverRect().setMouseTransparent(true);
                }           
            }
        }
    }

    public static void spacesWithPieces(ChessBoard chessBoard){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                GridSpace gridSpace = chessBoard.getBoard()[i][j];
                if(gridSpace.getCurrentPiece() != null){
                    System.out.println("SPACE: X:" + gridSpace.getGridX() + " Y: " + gridSpace.getGridY());
                }     
            }
        }
    }

    public static boolean isWhitePiece(Piece piece){
        if(piece instanceof WhitePawn){
            return true;
        }
        return false;
    }

    public static boolean isCorrectColorTurn(Piece piece, boolean isWhiteTurn){
        if(piece.toString().contains("White") && isWhiteTurn){
            return true;
        }else if(piece.toString().contains("Black") && !isWhiteTurn){
            return true;
        }
        return false;
    }

}
