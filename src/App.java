
import javafx.stage.Stage;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.scene.layout.Pane;
import javafx.geometry.VPos;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import includes.chessBoard.ChessBoard;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;


public class App extends Application{
    private double screenWidth = 900;
    private double screenHeight = 850;

    public void start(Stage stage) throws FileNotFoundException{
        stage.setTitle("Anynymous");
        // Image image = new Image(new FileInputStream("C:\\Users\\Cesar\\Programming\\Java\\Chess\\ChessApp\\src\\includes\\sprites\\chessBoard.png"));
        // ImageView imageView = new ImageView(image);

        // imageView.setX(20);
        // imageView.setY(125);

        // imageView.setFitHeight(600);
        // imageView.setFitWidth(600);

        // imageView.setPreserveRatio(true);

        Pane root = new Pane();
        root.setPrefWidth(screenWidth);
        root.setPrefHeight(screenHeight);

        ChessBoard chessBoard = new ChessBoard();

       drawGrid(chessBoard, root);

        drawDots(root); 



        Scene scene = new Scene(root, screenWidth, screenHeight, Color.GREY);
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
                root.getChildren().add(chessBoard.getBoard()[i][j].getGridRect());
            }
        }
    }
}