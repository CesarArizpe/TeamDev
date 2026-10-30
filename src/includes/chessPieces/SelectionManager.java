package includes.chessPieces;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.HashMap;

import includes.chessBoard.ChessBoard;
import includes.chessBoard.GridSpace;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class SelectionManager{
    private int imageWidth;
    private int imageHeight;
    private String spritePath;
    private double offsetX;
    private double offsetY;
    private Map<String, SelectionGenerator> whiteSelectionGenerators;
    private Map<String, SelectionGenerator> blackSelectionGenerators;

    private Pane root;
    private Group overlay;

    public SelectionManager(ChessBoard chessBoard, Pane root) throws FileNotFoundException{
        this.imageHeight = this.imageWidth = 48;
        this.root = root;
        this.overlay = new Group();
        this.spritePath = System.getProperty("user.dir") + "\\src\\includes\\sprites";
        this.whiteSelectionGenerators = new HashMap<>();
        this.whiteSelectionGenerators.put("Pawn", new SelectionGenerator(572, 439, this.spritePath + "\\w_Pawn.png"));
        this.whiteSelectionGenerators.put("Knight", new SelectionGenerator(572 + 48, 439, this.spritePath + "\\w_Knight.png"));
        this.whiteSelectionGenerators.put("Bishop", new SelectionGenerator(572 + 48 * 2, 439, this.spritePath + "\\w_Bishop.png"));
        this.whiteSelectionGenerators.put("Rook", new SelectionGenerator(572 + 48 * 3, 439, this.spritePath + "\\w_Rook.png"));
        this.whiteSelectionGenerators.put("Queen", new SelectionGenerator(572 + 48 * 4, 439, this.spritePath + "\\w_Queen.png"));
        this.whiteSelectionGenerators.put("King", new SelectionGenerator(572 + 48 * 5, 439, this.spritePath + "\\w_King.png"));
        // this.whiteSelectionGenerators = new SelectionGenerator(572, 439, this.spritePath + "\\w_Pawn.png");
        this.blackSelectionGenerators = new HashMap<>();
        this.blackSelectionGenerators.put("Pawn", new SelectionGenerator(572, 343, this.spritePath + "\\b_Pawn.png"));
        this.blackSelectionGenerators.put("Knight", new SelectionGenerator(572 + 48, 343, this.spritePath + "\\b_Knight.png"));
        this.blackSelectionGenerators.put("Bishop", new SelectionGenerator(572 + 48 * 2, 343, this.spritePath + "\\b_Bishop.png"));
        this.blackSelectionGenerators.put("Rook", new SelectionGenerator(572 + 48 * 3, 343, this.spritePath + "\\b_Rook.png"));
        this.blackSelectionGenerators.put("Queen", new SelectionGenerator(572 + 48 * 4, 343, this.spritePath + "\\b_Queen.png"));
        this.blackSelectionGenerators.put("King", new SelectionGenerator(572 + 48 * 5, 343, this.spritePath + "\\b_King.png"));
        
        // this.root.getChildren().add(this.whi)
        setupAllDragHandlers(chessBoard);
    }

    public int getImageHeight() { return this.imageHeight; }
    public int getImageWidth() { return this.imageWidth; }
    public String getSpritePath() { return this.spritePath; }
    public Group getOverlay() { return this.overlay; }

    public Map<String, SelectionGenerator> getWhiteSelectionGenerators() { return this.whiteSelectionGenerators; }
    public Map<String, SelectionGenerator> getBlackSelectionGenerators() { return this.blackSelectionGenerators; }

    protected void setupAllDragHandlers(ChessBoard chessBoard){
        setupWhiteDragHandlers(chessBoard);
        setupBlackDragHandlers(chessBoard);

    }

    protected void setupWhiteDragHandlers(ChessBoard chessBoard){
        for(String key : this.whiteSelectionGenerators.keySet()){
            SelectionGenerator currentSelectionGenerator = this.whiteSelectionGenerators.get(key);
            this.overlay.getChildren().add(currentSelectionGenerator.getHitbox());
            this.overlay.getChildren().add(currentSelectionGenerator.getImageView());


            Rectangle hitbox = currentSelectionGenerator.getHitbox();
            
            hitbox.setOnMousePressed(event -> {
                offsetX = event.getX() - hitbox.getX();
                offsetY = event.getY() - hitbox.getY();
                chessBoard.toggleAllSpaces();
            });
            
            currentSelectionGenerator.getHitbox().setOnMouseDragged(event -> onMouseDraggedSelectionGenerator(event, chessBoard, currentSelectionGenerator));
            
            currentSelectionGenerator.getHitbox().setOnMouseClicked(event -> {
                try{
                    handleSelectionOptionClick(chessBoard, event, hitbox, currentSelectionGenerator) ;
                }catch (FileNotFoundException e){
                    e.printStackTrace();
                }
            });
            
            currentSelectionGenerator.getImageView().setOnMousePressed(event -> {
                offsetX = event.getX() - hitbox.getX();
                offsetY = event.getY() - hitbox.getY();
                chessBoard.toggleAllSpaces();
            });
            
            currentSelectionGenerator.getImageView().setOnMouseClicked(event ->  {
                try{
                    handleSelectionOptionClick(chessBoard, event, hitbox, currentSelectionGenerator) ;
                }catch (FileNotFoundException e){
                    e.printStackTrace();
                }
            });
    
            currentSelectionGenerator.getImageView().setOnMouseDragged(event -> onMouseDraggedSelectionGenerator(event, chessBoard, currentSelectionGenerator));
        }

    }
    
    protected void setupBlackDragHandlers(ChessBoard chessBoard){
        for(String key : this.blackSelectionGenerators.keySet()){
            SelectionGenerator currentSelectionGenerator = this.blackSelectionGenerators.get(key);
            this.overlay.getChildren().add(currentSelectionGenerator.getHitbox());
            this.overlay.getChildren().add(currentSelectionGenerator.getImageView());


            Rectangle hitbox = currentSelectionGenerator.getHitbox();
            
            hitbox.setOnMousePressed(event -> {
                offsetX = event.getX() - hitbox.getX();
                offsetY = event.getY() - hitbox.getY();
                chessBoard.toggleAllSpaces();
            });
            
            currentSelectionGenerator.getHitbox().setOnMouseDragged(event -> onMouseDraggedSelectionGenerator(event, chessBoard, currentSelectionGenerator));
            
            currentSelectionGenerator.getHitbox().setOnMouseClicked(event -> {
                try{
                    handleSelectionOptionClick(chessBoard, event, hitbox, currentSelectionGenerator) ;
                }catch (FileNotFoundException e){
                    e.printStackTrace();
                }
            });
            
            currentSelectionGenerator.getImageView().setOnMousePressed(event -> {
                offsetX = event.getX() - hitbox.getX();
                offsetY = event.getY() - hitbox.getY();
                chessBoard.toggleAllSpaces();
            });
            
            currentSelectionGenerator.getImageView().setOnMouseClicked(event ->  {
                try{
                    handleSelectionOptionClick(chessBoard, event, hitbox, currentSelectionGenerator) ;
                }catch (FileNotFoundException e){
                    e.printStackTrace();
                }
            });
    
            currentSelectionGenerator.getImageView().setOnMouseDragged(event -> onMouseDraggedSelectionGenerator(event, chessBoard, currentSelectionGenerator));
        }

    }

    protected void onMouseDraggedSelectionGenerator(javafx.scene.input.MouseEvent event, ChessBoard chessBoard, SelectionGenerator currentSelectionGenerator) {
        currentSelectionGenerator.getHitbox().setX(event.getSceneX() - offsetX);
        currentSelectionGenerator.getHitbox().setY(event.getSceneY() - offsetY);

        currentSelectionGenerator.getImageView().setX(currentSelectionGenerator.getHitbox().getX());
        currentSelectionGenerator.getImageView().setY(currentSelectionGenerator.getHitbox().getY());
        // chessBoard.checkOverlappingArea(this.whiteSelectionGenerators.getHitbox());
    }



    public void addPiece(
        ChessBoard chessBoard, Piece piece,
        int gridX, int gridY, Pane root) {

        chessBoard.addPiece(gridX, gridY, piece);

        Rectangle hitbox = piece.getHitbox();
        root.getChildren().add(hitbox);

        ImageView image = piece.getImageView();
        root.getChildren().add(image);

        hitbox.setOnMouseClicked(event -> {
            handlePieceClick(chessBoard, event, piece);
        });


        image.setOnMouseClicked(event -> {
            handlePieceClick(chessBoard, event, piece);
        });

    }

    public static void handlePieceClick(ChessBoard chessBoard, MouseEvent event, Piece piece){

        if(chessBoard.getActivePiece() != null && inAvailableMoves(chessBoard.getActivePiece().getAvailableMoves(chessBoard), piece)){
            System.out.println("IMPLEMENT CAPTURE");
            chessBoard.capturePiece(chessBoard.getActivePiece(), piece);
            chessBoard.spacesWithPieces();
            chessBoard.toggleActiveSpaces();
            if(chessBoard.isTurnBased()) chessBoard.toggleTurnWhite();
            return;
        }

        System.out.println("clicked");
        if(chessBoard.isTurnBased()){
            if(chessBoard.getActivePiece() == piece){
                chessBoard.toggleActiveSpaces();
                chessBoard.setActivePiece(null);
            }else if((chessBoard.getActivePiece() == null || chessBoard.getActivePiece() != piece) && isCorrectColorTurn(piece, chessBoard.isTurnWhite())){
                if(!piece.hasMoves(piece.getAvailableMoves(chessBoard))) return;
                else{
                    chessBoard.setActivePiece(piece);
                    chessBoard.toggleActiveSpaces();
                    System.out.println("BEFORE METHOD GRID X:" + piece.getGridX() + " Y: " + piece.getGridY());
                    chessBoard.toggleAvailableSpaces(piece.getAvailableMoves(chessBoard));
                }
            }
        }else{
            if(chessBoard.getActivePiece() == piece){
                chessBoard.toggleActiveSpaces();
                chessBoard.setActivePiece(null);
            }else if(chessBoard.getActivePiece() == null){
                if(!piece.hasMoves(piece.getAvailableMoves(chessBoard))) return;
                else{
                    chessBoard.setActivePiece(piece);
                    chessBoard.toggleActiveSpaces();
                    System.out.println("BEFORE METHOD GRID X:" + piece.getGridX() + " Y: " + piece.getGridY());
                    chessBoard.toggleAvailableSpaces(piece.getAvailableMoves(chessBoard));
                }
            }

        }
        if(piece.getIsDragging()) {
            chessBoard.toggleActiveSpaces();
            chessBoard.setActivePiece(null);
            piece.setIsDragging(false);

            GridSpace space = chessBoard.getClosestMove(piece.getAvailableMoves(chessBoard), piece.getHitbox());
            if(space != null){
                chessBoard.movePiece(piece.getGridSpace(), space, piece);
            }else {
                piece.setXPos(piece.getGridSpace().getPieceXPos());
                piece.setYPos(piece.getGridSpace().getPieceYPos());
            }

        }
        System.out.println("ACTIVE PIECE - " + chessBoard.getActivePiece() == null? "NULL" : chessBoard.getActivePiece());
        chessBoard.spacesWithPieces();


            // event.consume();
        }
        
        public static void handleHoverRectClick(ChessBoard chessBoard, MouseEvent event, Piece piece, GridSpace gridSpace){
            System.out.println("clicked hover rect");

        if(chessBoard.isTurnBased()){
            if(isCorrectColorTurn(chessBoard.getActivePiece(), chessBoard.isTurnWhite())){
                chessBoard.movePiece(chessBoard.getActivePiece().getGridSpace(), gridSpace, chessBoard.getActivePiece());
                chessBoard.toggleActiveSpaces();
                chessBoard.spacesWithPieces();
                chessBoard.toggleTurnWhite();
                
            }else{
                chessBoard.movePiece(chessBoard.getActivePiece().getGridSpace(), gridSpace, chessBoard.getActivePiece());
                chessBoard.toggleActiveSpaces();
                chessBoard.spacesWithPieces();
                chessBoard.toggleTurnWhite();
            }
            
        }else{
            if(chessBoard.getActivePiece() == piece){
                chessBoard.movePiece(chessBoard.getActivePiece().getGridSpace(), gridSpace, chessBoard.getActivePiece());
                chessBoard.toggleActiveSpaces();
            }else if(chessBoard.getActivePiece() == null || piece != chessBoard.getActivePiece()){
                chessBoard.setActivePiece(piece);
                chessBoard.toggleActiveSpaces();
                chessBoard.toggleAvailableSpaces(piece.getAvailableMoves(chessBoard));
            }
        }
    }

    public void handleSelectionOptionClick(ChessBoard chessBoard, MouseEvent event, Rectangle rect1, SelectionGenerator currentSelectionGenerator) throws FileNotFoundException{
        GridSpace space = chessBoard.getClosestGridSpace(rect1);
        chessBoard.toggleAllSpaces();
        System.out.println("click tetected");
        currentSelectionGenerator.returnToOriginalPos();

        if(space != null){ 
            System.out.println("CLOSEST SPACE X: " + space.getGridX() + " Y: " + space.getGridY());
            generateChessboardPiece(currentSelectionGenerator, chessBoard, space);
        }
        
    }

    public static boolean isWhitePiece(Piece piece){
        if(piece instanceof WhitePawn){
            return true;
        }
        return false;
    }

    public static boolean isCorrectColorTurn(Piece piece, boolean isWhiteTurn){
        if(piece.toString().contains("White") && isWhiteTurn){
            return true;
        }else if(piece.toString().contains("Black") && !isWhiteTurn){
            return true;
        }
        return false;
    }


    public void drawDots(Pane root){
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

    public void drawGrid(ChessBoard chessBoard, Pane root){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                GridSpace gridSpace = chessBoard.getBoard()[i][j];
                root.getChildren().add(gridSpace.getGridRect());
                root.getChildren().add(gridSpace.getHoverRect());
                gridSpace.getHoverRect().setVisible(false);
                gridSpace.getHoverRect().setMouseTransparent(true);

                gridSpace.getHoverRect().setOnMouseClicked(event -> {
                    handleHoverRectClick(chessBoard, event, chessBoard.getActivePiece(), gridSpace);
                    
                });
            }
        }
    }

    public void generateChessboardPiece(SelectionGenerator currentsSelectionGenerator, ChessBoard chessBoard, GridSpace space) throws FileNotFoundException{
        if(currentsSelectionGenerator.getSpritePath().contains("w_")){
            if(currentsSelectionGenerator.getSpritePath().contains("Pawn")){
                addPiece(chessBoard, new WhitePawn(), space.getGridX(), space.getGridY(), this.root);
            }
            if(currentsSelectionGenerator.getSpritePath().contains("Knight")){
                addPiece(chessBoard, new WhiteKnight(), space.getGridX(), space.getGridY(), this.root);
            }
            if(currentsSelectionGenerator.getSpritePath().contains("Bishop")){
                addPiece(chessBoard, new WhiteBishop(), space.getGridX(), space.getGridY(), this.root);
            }
            if(currentsSelectionGenerator.getSpritePath().contains("Rook")){
                addPiece(chessBoard, new WhiteRook(), space.getGridX(), space.getGridY(), this.root);
            }
            if(currentsSelectionGenerator.getSpritePath().contains("Queen")){
                addPiece(chessBoard, new WhiteQueen(), space.getGridX(), space.getGridY(), this.root);
            }
            if(currentsSelectionGenerator.getSpritePath().contains("King")){
                addPiece(chessBoard, new WhiteKing(), space.getGridX(), space.getGridY(), this.root);
            }
        }else{
            if(currentsSelectionGenerator.getSpritePath().contains("Pawn")){
                addPiece(chessBoard, new BlackPawn(), space.getGridX(), space.getGridY(), this.root);
            }
            if(currentsSelectionGenerator.getSpritePath().contains("Knight")){
                addPiece(chessBoard, new BlackKnight(), space.getGridX(), space.getGridY(), this.root);
            }
            if(currentsSelectionGenerator.getSpritePath().contains("Bishop")){
                addPiece(chessBoard, new BlackBishop(), space.getGridX(), space.getGridY(), this.root);
            }
            if(currentsSelectionGenerator.getSpritePath().contains("Rook")){
                addPiece(chessBoard, new BlackRook(), space.getGridX(), space.getGridY(), this.root);
            }
            if(currentsSelectionGenerator.getSpritePath().contains("Queen")){
                addPiece(chessBoard, new BlackQueen(), space.getGridX(), space.getGridY(), this.root);
            }
            if(currentsSelectionGenerator.getSpritePath().contains("King")){
                addPiece(chessBoard, new BlackKing(), space.getGridX(), space.getGridY(), this.root);
            }
        }
    }

    public static boolean inAvailableMoves(GridSpace[] availableMoves, Piece piece){
        for(GridSpace space : availableMoves){
            if (space != null && space.getCurrentPiece() == piece) return true;
        }
        return false;
    }
}