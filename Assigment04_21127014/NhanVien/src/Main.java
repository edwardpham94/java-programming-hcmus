import NhanVien.*;

import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        List<NhanVien> listNV = new ArrayList<NhanVien>();

        NVVanPhong tmp = new NVVanPhong("21127014", "Pham Hong Gia Bao", "0948885652", 500000000);
        listNV.add(tmp);

        NVSanXuat tmp1 = new NVSanXuat("21127011", "Ly Gia Han", "09488854782", 50000 , 10);
        listNV.add(tmp1);

        NVSanXuat tmp3 = new NVSanXuat("20127458", "Nguyen Nhat Nam", "0948844782", 10000 , 20);
        listNV.add(tmp3);

        NVVanPhong tmp2 = new NVVanPhong("21127003", "Phan Thanh An", "09488854782", 500000000);
        listNV.add(tmp2);

        // function 1
        tmp.listNV(listNV);
        // function 2
        listNV.add(tmp.getNVInput());
        // function 3
        tmp.getListNVVanPhong(listNV);
        // function 4
        tmp.getListNVSanXuat(listNV);
        // function 6
        tmp.displayLuongNV(listNV);
        // function 5
        tmp.getListNVWithXInName(listNV, "P");
        // function 7
        tmp.listMaxLuong(listNV);


    }
}