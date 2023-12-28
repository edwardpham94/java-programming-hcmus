package TamGiac;

public class TamGiacThuong extends TamGiac {
    TamGiacThuong() {
        super();
    }

    public TamGiacThuong(MyPoint a, MyPoint b, MyPoint c) {
        super(a, b, c);
    }

    @Override
    public double chuViTamGiac() {
        return super.chuViTamGiac();
    }

    @Override
    public double dienTichTamGiac() {
        return super.dienTichTamGiac();
    }

    @Override
    public MyPoint trongTamTamGiac(){
        return super.trongTamTamGiac();
    }

    @Override
    public String toString() {
        return "TamGiacThuong [p1=" + p1 + ", p2=" + p2 + ", p3=" + p3 + "]";
    }
}
