import javafx.stage.Stage;
import physicsClasses.Logo;
import physicsClasses.Vec2;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.layout.Pane;

public class TestBoxClickAndDrag extends Application{

    private double screenWidth = 500;
    private double screenHeight = 500;

    @Override 
    public void start(Stage stage){
        Pane root = new Pane();

        Logo logo = new Logo(new Vec2(screenWidth / 2 - 50, screenHeight / 2 - 20), new Vec2(5, 5), 100, 40, Color.RED);

        root.getChildren().add(logo.getHitbox());
        Scene scene = new Scene(root, screenWidth, screenHeight);
        stage.setScene(scene);
        stage.setTitle("2D Physics");
        stage.show();
    }
    
}
