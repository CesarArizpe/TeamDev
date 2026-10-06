
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Paint;
// import javafx.scene.text.Text;
import javafx.scene.text.*;
import javafx.scene.layout.Pane;
import javafx.geometry.VPos;


public class App extends Application{

    public void start(Stage primartStage){
        primartStage.setTitle("Anynymous");
        // Text text = new Text(250, 250, "This is a test hahaha");
        Text text = new Text();
        text.setText("This is a test ");

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
        root.getChildren().add(circle);


        Scene scene = new Scene(root, 500, 500);
        primartStage.setScene(scene);
        primartStage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}