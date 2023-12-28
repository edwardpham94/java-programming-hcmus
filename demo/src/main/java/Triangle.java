public class Triangle {
    private MyPoint point1;
    private MyPoint point2;
    private MyPoint point3;

    public Triangle(MyPoint a, MyPoint b, MyPoint c) {
        point1 = a;
        point2 = b;
        point3 = c;
    }

    public static void main(String[] str) {
        MyPoint a = new MyPoint(0, 0);
        MyPoint b = new MyPoint(3, 0);
        MyPoint c = new MyPoint(0, 4);

        Triangle tria = new Triangle(a, b, c);
        System.out.println(tria.getTriangleType());
    }

    public String getTriangleType() {
        if (point1.getX() == point2.getX() && point1.getX() == point3.getX()) {
            return "Equilateral Triangle";
        } else if (point1.getX() == point2.getX() || point1.getX() == point3.getX() || point2.getX() == point3.getX()) {
            return "Isosceles Triangle";
        } else {
            return "Scalene Triangle";
        }
    }
}
