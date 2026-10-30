import javafx.stage.Stage;
import physicsClasses.Logo;
import physicsClasses.Vec2;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.scene.layout.Pane;
import javafx.geometry.VPos;



public class TestBoxPhysics extends Application{
    private double screenWidth = 500;
    private double screenHeight = 500;


    public void start(Stage stage){
        Text text = new Text();
        text.setText("This is a test");

        text.setTextAlignment(TextAlignment.CENTER);
        text.setTextOrigin(VPos.CENTER);

        Pane root = new Pane();
        root.setPrefSize(screenWidth, screenHeight);

        
        Logo logo = new Logo(new Vec2(screenWidth / 2 - 50, screenHeight / 2 - 20), new Vec2(5, 5), 100, 40, Color.RED);
        root.getChildren().add(logo.getHitbox());
        root.getChildren().add(text);

        System.out.println(logo.getVelYComp());
        
        AnimationTimer timer = new AnimationTimer() {
            @Override 
            public void handle(long now){
                updateLogoPos(logo, root);

                text.setX(logo.getXPos() + (logo.getWidth() / 2) - text.layoutBoundsProperty().get().getWidth() / 2);
                text.setY(logo.getYPos() + logo.getHeight() / 2);
            }
        };

        timer.start();

        Scene scene = new Scene(root, screenWidth, screenHeight);
        stage.setScene(scene);
        stage.setTitle("2D Physics");
        stage.show();

    }

    public static void main(String[] args){
        launch(args);
    }

    public void updateLogoPos(Logo logo, Pane root){
        logo.setXPos(logo.getVelXComp() + logo.getXPos());
        logo.setYPos(logo.getVelYComp() + logo.getYPos());
        System.out.println(logo.getVelYComp() + " + " + logo.getYPos());

        if(logo.getXPos() < 0 ){
            logo.setXPos(0);
            logo.setVelXComp(logo.getVelXComp() * -1);
        }
        if(logo.getXPos() + logo.getWidth() > root.getWidth()){
            logo.setXPos(root.getWidth() - logo.getWidth());
            logo.setVelXComp(logo.getVelXComp() * -1);
        }
        if(logo.getYPos() < 0 ){
            logo.setYPos(0);
            logo.setVelYComp(logo.getVelYComp() * -1);
        }
        if(logo.getYPos() + logo.getHeight() > root.getHeight()){
            logo.setYPos(root.getHeight() - logo.getHeight());
            logo.setVelYComp(logo.getVelYComp() * -1);
        }

        logo.setHitboxXPos(logo.getXPos());
        logo.setHitboxYPos(logo.getYPos());
    }
}