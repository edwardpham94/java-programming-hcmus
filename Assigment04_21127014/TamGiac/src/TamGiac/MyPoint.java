package TamGiac;

public class MyPoint {
    double point_x, point_y;

    public MyPoint(double a, double b) {
        point_x = a;
        point_y = b;
    }

    public double getPoint_x() {
        return point_x;
    }

    public double getPoint_y() {
        return point_y;
    }

    @Override
    public String toString() {
        return "(" + point_x + "," + point_y + ")";
    }

    public double getDistance(MyPoint tmp) {
        double dx = this.point_x - tmp.point_x;
        double dy = this.point_y - tmp.point_y;
        return Math.sqrt(dx*dx + dy*dy);
    }

}

