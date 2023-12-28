import java.lang.Math.* ;

public class MyPoint {
    private double x;
    private double y;

    MyPoint(double a, double b){
        x = a;
        y = b;
    }

    double getX(){
        return this.x;
    }

    double getDistance(MyPoint a){
        return Math.sqrt((a.getX()-this.getX())*(a.getX()-this.getX()) + (a.getY() - this.getY())*(a.getY() - this.getY()));
    }

    double getY(){
        return this.y;
    }
}

