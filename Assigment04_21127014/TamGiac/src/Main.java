import TamGiac.TamGiac;
import java.util.ArrayList;
import java.util.List;
import TamGiac.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        List<TamGiac> listTG = new ArrayList<TamGiac>();
        MyPoint a = new MyPoint(0, 2);
        MyPoint b = new MyPoint(4, 0);
        MyPoint c = new MyPoint(4, 2);
        TamGiacThuong tg = new TamGiacThuong(a, b, c);
        listTG.add(tg);

        MyPoint a1 = new MyPoint(1, 2);
        MyPoint b1 = new MyPoint(4, 1);
        MyPoint c1 = new MyPoint(6, -4);
        TamGiacVuong tg1 = new TamGiacVuong(a1, b1, c1);
        listTG.add(tg1);

        MyPoint a2 = new MyPoint(1, 2);
        MyPoint b2 = new MyPoint(0, 4);
        MyPoint c2 = new MyPoint(6, -4);
        TamGiacCan tg2 = new TamGiacCan(a2, b2, c2);
        listTG.add(tg2);

        // function 1
        tg.listTamGiac(listTG);
        // function 2
        listTG.add(tg.inputTamGiac());
        // function 3
        System.out.println("Tong chu vi cac Tam Giac: " + String.format("%.2f", tg.tongChuVi(listTG)));
        // function 4
        System.out.println("Max Chu Vi : " + tg.maxChuViTamGiac(listTG));
        // function 5
        System.out.println("Min Chu Vi : " + tg.minChuViTamGiac(listTG));
        // function 6
        tg.chuViTGLessX(listTG, 20.0);
        // function 7
        tg.trongTamInList(listTG);


    }
}