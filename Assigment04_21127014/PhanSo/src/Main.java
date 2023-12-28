import PhanSo.PhanSo;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        PhanSo aps = new PhanSo(3, 9);
        PhanSo bps = new PhanSo(1, 5);
        aps.rutGonPS();

        System.out.println(aps + " + " + bps + " = " + aps.congPhanSo(bps));
        System.out.println(aps + " - " + bps + " = " + aps.truPhanSo(bps));
        System.out.println(aps + " * " + bps + " = " + aps.nhanPhanSo(bps));
        System.out.println(aps + " / " + bps + " = " + aps.chiaPhanSo(bps));
    }
}