package TamGiac;

public class TamGiacCan extends TamGiac {
    TamGiacCan(){
        super();
    }

    public TamGiacCan(MyPoint a, MyPoint b, MyPoint c) {
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
        return "TamGiacCan [p1=" + p1 + ", p2=" + p2 + ", p3=" + p3 + "]";
    }
}
