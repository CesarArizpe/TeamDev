package includes.chessPieces;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import includes.chessBoard.ChessBoard;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public abstract class Thing {
    private int imageWidth;
    private int imageHeight;
    private String spritePath;
    

    public Thing() throws FileNotFoundException{
        this.imageHeight = this.imageWidth = 48;
        this.spritePath = System.getProperty("user.dir") + "\\src\\includes\\sprites";
        this.loadImageView(this.spritePath);
        // this.whitePawnHitbox = new Rectangle(572, 439, 48, 48);
        // this.whitePawnHitbox.setFill(Color.rgb(0, 0, 0, 0));
        // this.whitePawnHitbox.setFill(Color.RED);
        // this.whitePawnImageView.setX(572);
        // this.whitePawnImageView.setY(439);
    }

    public int getImageHeight() { return this.imageHeight; }
    public int getImageWidth() { return this.imageWidth; }
    public String getSpritePath() { return this.spritePath; }
    // public Rectangle getWhitePawnHitbox() { return this.whitePawnHitbox; }

    public void setWhitePawnHitboxHandler(ChessBoard chessBoard, Rectangle whitePawnHitbox, MouseEvent event){

    }

    protected abstract void setupDragHandlers(ChessBoard chessBoard);
    protected abstract void onMouseDragged(javafx.scene.input.MouseEvent event);
    public abstract void loadImageView(String filepath) throws FileNotFoundException;
    public abstract void setImageViewHandlers();
}
