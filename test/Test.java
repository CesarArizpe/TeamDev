import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.scene.layout.Pane;
import javafx.geometry.VPos;


public class Test extends Application{

    private long lastUpdate = 0;
    private final double targetDelta = 1. / 60.;


    public void start(Stage stage){
        stage.setTitle("Anynymous");
        // Text text = new Text(250, 250, "This is a test hahaha");
        Text text = new Text();
        text.setText("This is a test");

        text.setTextAlignment(TextAlignment.CENTER);
        text.setTextOrigin(VPos.CENTER);

        Pane root = new Pane(text);

        text.xProperty().bind(root.widthProperty().divide(2).subtract(text.layoutBoundsProperty().get().getWidth() / 2));
        text.yProperty().bind(root.heightProperty().divide(2));

        Circle circle = new Circle();
        circle.setCenterX(250);
        circle.setCenterY(250);
        circle.setRadius(1);
        // circle.fillProperty()
        circle.setFill(Color.RED);
        root.getChildren().add(circle);





        Scene scene = new Scene(root, 500, 500);
        stage.setScene(scene);
        stage.show();

        


    }

    public static void main(String[] args){
        launch(args);
    }
}