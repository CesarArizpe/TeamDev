
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
import includes.chessPieces.SelectionManager;
import includes.chessPieces.WhitePawn;
import includes.chessPieces.BlackPawn;
import includes.chessPieces.Thing;

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
        SelectionManager selectionManager = new SelectionManager(chessBoard, root);

        selectionManager.drawGrid(chessBoard, root);

        // drawDots(root); 
        // GridSpace space = chessBoard.getBoard()[6][0];
        // Piece whitePawn = new WhitePawn();
        // Piece blackPawn = new BlackPawn();

        // selectionManager.addPiece(chessBoard, whitePawn, 0, 6, root);
        // selectionManager.addPiece(chessBoard, blackPawn, 0, 1, root);

        Button toggleTurnButton = new Button("chessBoard.Toggle Turn-Based Play");
        // toggleTurnButton.setPrefHeight(30);
        // toggleTurnButton.setPrefWidth(70);
        toggleTurnButton.setLayoutX(20 + 512);
        toggleTurnButton.setLayoutY(screenHeight - 512 - 256);
        
        toggleTurnButton.setOnAction(event -> {
            chessBoard.toggleTurnBased();
            System.out.println("TURN BASED : " + chessBoard.isTurnBased());
        });


        root.getChildren().add(toggleTurnButton);

        Rectangle selectionRect = new Rectangle(572, 343, 288, 48);
        selectionRect.setFill(Color.rgb(70, 70, 70));
        root.getChildren().add(selectionRect);

        Rectangle selectionRect2 = new Rectangle(572, 439, 288, 48);
        selectionRect2.setFill(Color.rgb(70, 70, 70));
        root.getChildren().add(selectionRect2);
        chessBoard.spacesWithPieces();


        // root.getChildren().add(selectionManager.getSelectionGenerator().getHitbox());
        // root.getChildren().add(selectionManager.getSelectionGenerator().getImageView());

        root.getChildren().add(selectionManager.getOverlay());

        Scene scene = new Scene(root, screenWidth, screenHeight, Color.GREY);
        root.setStyle("-fx-background-color: grey;");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
