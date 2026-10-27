package includes.chessBoard;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

public class GridSpace {
    private Rectangle gridRect;
    // private Rectangle hoverRect;
    private final double width;
    private final double height;
    private final double xpos;
    private final double ypos;


    public GridSpace(double xpos, double ypos, Color color){
        this.width = this.height = 64;
        this.xpos = xpos;
        this.ypos = ypos;
        this.gridRect = new Rectangle(this.xpos, this.ypos, this.width, this.height);
        this.gridRect.setFill(color);
    }

    public Rectangle getGridRect() { return this.gridRect; }
    public double getWidth() { return this.width; }
    public double getHeight() { return this.height; }
    public double getXPos() { return this.xpos; }
    public double getYPos() { return this.ypos; }
}
