package physicsClasses;

import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

public class Logo {
    private Vec2 position;
    private Vec2 velocity;
    private double width;
    private double height;
    private Rectangle hitbox;
    private Color color;

    public Logo(){
        this.position = null;
        this.velocity = null;
        this.width = 0;
        this.height = 0;
        this.hitbox = new Rectangle();
        this.color = Color.BLACK;
    }
    public Logo(Vec2 pos, Vec2 vel, double width, double height, Color color){
        this.position = pos;
        this.velocity = vel;
        this.width = width;
        this.height = height;
        this.hitbox = new Rectangle(width, height);
    }

    public void setXPos(double xpos){ this.position.setXComp(xpos); }
    public void setYPos(double ypos){ this.position.setYComp(ypos); }
    public void setVelXComp(double xcomp){ this.velocity.setXComp(xcomp); }
    public void setVelYComp(double ycomp){ this.velocity.setYComp(ycomp); }
    public void setWidth(double width){ this.width = width; }
    public void setHeight(double height){ this.height = height; } 
    public void setColor(Color color){ this.color = color; }

    public double getXPos(){ return this.position.getXComp(); }
    public double getYPos(){ return this.position.getYComp(); }
    public double getVelXComp(){ return this.velocity.getXComp(); }
    public double getVelYComp(){ return this.velocity.getYComp(); }
    public double getWidth(){ return this.width; }
    public double getHeight(){ return this.height; }
    public Rectangle getHitbox(){ return this.hitbox; }
    public Color getColor(){ return this.color; }

    
        
}
