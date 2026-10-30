package includes.chessPieces;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.paint.Color;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public class SelectionGenerator {
    private int imageWidth;
    private int imageHeight;
    private int originalXpos;
    private int originalYpos;
    private String spritePath;
    private Rectangle hitbox;
    private ImageView imageView;
    

    public SelectionGenerator(int xpos, int ypos, String filepath) throws FileNotFoundException{
        this.imageHeight = this.imageWidth = 48;
        this.hitbox = new Rectangle(xpos, ypos, this.imageWidth, this.imageHeight);
        this.hitbox.setFill(Color.rgb(0, 0, 0, 0));
        this.loadImageView(filepath);
        this.originalXpos = xpos;
        this.originalYpos = ypos;
        this.loadImageView(filepath);
        this.spritePath = filepath;

    }

    public String getSpritePath() { return this.spritePath; }
    public Rectangle getHitbox() { return this.hitbox; }
    public ImageView getImageView() { return this.imageView; }

    public void loadImageView(String filepath) throws FileNotFoundException{
        this.imageView = new ImageView(new Image(new FileInputStream(filepath)));
        this.imageView.setX(this.hitbox.getX());
        this.imageView.setY(this.hitbox.getY());
        this.imageView.setFitHeight(this.imageHeight);
        this.imageView.setFitWidth(this.imageWidth);
    }

    public void returnToOriginalPos(){
        this.hitbox.setX(this.originalXpos);
        this.hitbox.setY(this.originalYpos);

        this.imageView.setX(this.originalXpos);
        this.imageView.setY(this.originalYpos);
    }
}
