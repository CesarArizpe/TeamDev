package physicsClasses;

import java.lang.Math;

public class Vec2 {
    private double xcomp;
    private double ycomp;
    private double vel;

    public Vec2(){
        xcomp = 0;
        ycomp = 0;
        vel = 0;
    }

    public Vec2(double xcomp, double ycomp, double vel){
        this.xcomp = xcomp;
        this.ycomp= ycomp;
        this.vel = vel;
    }

    public void setXComp(double xcomp){ this.xcomp = xcomp; }
    public void setYComp(double ycomp ){ this.ycomp = ycomp; }
    public void setVel(double vel){ this.vel = vel; }

    public double getXComp(){ return xcomp;}
    public double getYComp(){ return ycomp;}
    public double getVel(){ return vel;}

    

}
