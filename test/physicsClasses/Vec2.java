package physicsClasses;


public class Vec2 {
    private double xcomp;
    private double ycomp;

    public Vec2(){
        xcomp = 0;
        ycomp = 0;
    }

    public Vec2(double xcomp, double ycomp){
        this.xcomp = xcomp;
        this.ycomp= ycomp;
    }

    public void setXComp(double xcomp){ this.xcomp = xcomp; }
    public void setYComp(double ycomp ){ this.ycomp = ycomp; }

    public double getXComp(){ return xcomp;}
    public double getYComp(){ return ycomp;}
    public double getMagnitude(){ return Math.sqrt(Math.pow(xcomp, 2) + Math.pow(ycomp, 2));}

    

}
