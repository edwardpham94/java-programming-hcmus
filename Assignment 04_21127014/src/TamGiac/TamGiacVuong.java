package TamGiac;

public class TamGiacVuong extends TamGiac{
    TamGiacVuong() {
        super();
    }

    TamGiacVuong(MyPoint a, MyPoint b, MyPoint c) {
        super(a, b, c);
    }

    @Override
    public double chuViTamGiac() {
        return super.chuViTamGiac();
    }

    @Override
    double dienTichTamGiac() {
        return super.dienTichTamGiac();
    }

    @Override
    MyPoint trongTamTamGiac(){
        return super.trongTamTamGiac();
    }

    @Override
    public String toString() {
        return "TamGiacVuong [p1=" + p1 + ", p2=" + p2 + ", p3=" + p3 + "]";
    }
}
