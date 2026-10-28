package includes.chessPieces;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import includes.chessBoard.GridSpace;
import includes.chessBoard.ChessBoard;


public abstract class Piece {
    private Rectangle hitbox;
    public int xpos;
    public int ypos;
    private final int width;
    private final int height;
    private int gridX;
    private int gridY;
    private ImageView imageView;
    private GridSpace currentGridSpace;
    private final boolean isWhitePiece;

    public Piece(){
        this.hitbox = new Rectangle(0, 0, 48, 48);
        this.hitbox.setFill(Color.rgb(0, 0, 0, 0));
        this.xpos = 0;
        this.ypos = 0;
        this.gridX = 0;
        this.gridY = 0;
        this.width = 48;
        this.height = 48;
        this.currentGridSpace = null;
        this.isWhitePiece = true;
    }

    public Rectangle getHitbox() { return this.hitbox; }
    public int getXPos() { return this.xpos; }
    public int getYPos() { return this.ypos; }
    public int getWidth() { return this.width; }
    public int getHeight() { return this.height; }
    public int getGridX() { return this.gridX; }
    public int getGridY() { return this.gridY; }
    public ImageView getImageView() { return this.imageView; }
    public GridSpace getGridSpace() { return this.currentGridSpace; }
    public boolean isWhite() { return this.isWhitePiece; }

    public void loadImageView(String filepath) throws FileNotFoundException{
        this.imageView = new ImageView(new Image(new FileInputStream(filepath)));
        this.imageView.setFitHeight(height);
        this.imageView.setFitWidth(width);
        this.currentGridSpace = null;
    }

    public void setGridSpace(GridSpace space) { 
        this.currentGridSpace = space;
        this.setGridX(space.getGridX());
        this.setGridY(space.getGridY());
     }
    public void setGridX(int gridX) { this.gridX = gridX; }
    public void setGridY(int gridY) { this.gridX = gridY; }

    public void setXPos(int xpos) { 
        this.xpos = xpos; 
        this.hitbox.setX(xpos);
        this.imageView.setX(xpos);
    }
    public void setYPos(int ypos) { 
        this.ypos = ypos; 
        this.hitbox.setY(ypos);
        this.imageView.setY(ypos);
    }

    public abstract GridSpace[] getAvailableMoves(ChessBoard chessboard);

}
