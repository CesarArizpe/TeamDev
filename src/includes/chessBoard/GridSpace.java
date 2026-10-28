package includes.chessBoard;
import includes.chessPieces.Piece;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

public class GridSpace {
    private Rectangle gridRect;
    private Rectangle hoverRect;
    private final int width;
    private final int height;
    private final int xpos;
    private final int ypos;
    private final int gridX;
    private final int gridY;
    private final int pieceXPos;
    private final int pieceYPos;
    private Piece currentPiece;


    public GridSpace(int xpos, int ypos, Color color, int gridX, int gridY){
        this.width = this.height = 64;
        this.xpos = xpos;
        this.ypos = ypos;
        this.gridRect = new Rectangle(this.xpos, this.ypos, this.width, this.height);
        this.gridRect.setFill(color);
        this.pieceXPos = xpos + 8;
        this.pieceYPos = ypos + 8;
        this.currentPiece = null;
        this.hoverRect = new Rectangle(this.pieceXPos, this.pieceYPos, 48, 48);
        this.hoverRect.setFill(Color.rgb(0, 0, 255, .2));
        this.gridX = gridX;
        this.gridY = gridY;
    }

    public Rectangle getGridRect() { return this.gridRect; }
    public Rectangle getHoverRect() { return this.hoverRect; }
    public int getWidth() { return this.width; }
    public int getHeight() { return this.height; }
    public int getXPos() { return this.xpos; }
    public int getYPos() { return this.ypos; }
    public int getPieceXPos() { return this.pieceXPos; }
    public int getPieceYPos() { return this.pieceYPos; }
    public int getGridX() { return this.gridX; }
    public int getGridY() { return this.gridY; }
    public Piece getCurrentPiece() { return this.currentPiece; }

    public void setCurrentPiece(Piece piece) { this.currentPiece = piece; }


}
