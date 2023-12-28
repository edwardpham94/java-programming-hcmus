package PhanSo;

public class PhanSo {
    int tuso, mauso;

    PhanSo() {
        tuso = 0;
        mauso = 1;
    }

    public PhanSo(int a, int b) {
        tuso = a;
        mauso = b;
    }

    public PhanSo congPhanSo(PhanSo a) {
        int tu = this.tuso * a.mauso + a.tuso * this.mauso;
        int mau = this.mauso * a.mauso;
        PhanSo ps = new PhanSo(tu, mau);
        ps.rutGonPS();
        return ps;
    }

    public PhanSo truPhanSo(PhanSo a) {
        int tu = this.tuso * a.mauso - a.tuso * this.mauso;
        int mau = this.mauso * a.mauso;
        PhanSo ps = new PhanSo(tu, mau);
        ps.rutGonPS();
        return ps;
    }

    public PhanSo nhanPhanSo(PhanSo a) {
        int tu = this.tuso * a.tuso;
        int mau = this.mauso * a.mauso;
        PhanSo ps = new PhanSo(tu, mau);
        ps.rutGonPS();
        return ps;
    }

    public PhanSo chiaPhanSo(PhanSo a) {
        int tu = this.tuso * a.mauso;
        int mau = this.mauso * a.tuso;
        PhanSo ps = new PhanSo(tu, mau);
        ps.rutGonPS();
        return ps;
    }

    private int calculateGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return calculateGCD(b, a % b);
    }

    public void rutGonPS() {
        int gcd = calculateGCD(tuso, mauso);
        tuso /= gcd;
        mauso /= gcd;
    }

    @Override
    public String toString() {
        return this.tuso + "/" + this.mauso;
    }


}
