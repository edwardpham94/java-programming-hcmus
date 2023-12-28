package TamGiac;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.sql.SQLOutput;

public class TamGiac {
    MyPoint p1, p2, p3;

    public TamGiac() {
        p1 = new MyPoint(0, 0);
        p2 = new MyPoint(0, 0);
        p3 = new MyPoint(0, 0);
    }

    public TamGiac(MyPoint a, MyPoint b, MyPoint c) {
        p1 = new MyPoint(a.point_x, a.point_y);
        p2 = new MyPoint(b.point_x, b.point_y);
        p3 = new MyPoint(c.point_x, c.point_y);
    }

    public void showListTamGiac() {
        System.out.println("******************************** TAM GIAC ****************************");
        System.out.println("1. Tam Giac Thuong");
        System.out.println("2. Tam Giac Can");
        System.out.println("3. Tam Giac Vuong");
    }

    public double chuViTamGiac() {
        double canh1 = p1.getDistance(p2);
        double canh2 = p1.getDistance(p3);
        double canh3 = p2.getDistance(p3);
        return (canh1 + canh2 + canh3);
    }

    public double tongChuVi(List<TamGiac> listTG) {
        double sumChuVi = 0.0;
        for (TamGiac tg : listTG) {
            double chuVi = tg.chuViTamGiac();
            sumChuVi = sumChuVi + chuVi;
        }
        return sumChuVi;
    }

    public double dienTichTamGiac() {
        double canh1 = p1.getDistance(p2);
        double canh2 = p1.getDistance(p3);
        double canh3 = p2.getDistance(p3);
        double p = this.chuViTamGiac();
        return Math.sqrt((p * (p - canh1) * (p - canh2) * (p - canh3)));
    }

    @Override
    public String toString() {
        return "TamGiac [p1=" + p1 + ", p2=" + p2 + ", p3=" + p3 + "]";
    }

    public MyPoint trongTamTamGiac() {
        double centroid_x = (p1.point_x + p2.point_x + p3.point_x) / 3;
        double centroid_y = (p1.point_y + p2.point_y + p3.point_y) / 3;
        return new MyPoint(centroid_x, centroid_y);
    }

    public TamGiac maxChuViTamGiac(List<TamGiac> listTG) {
        TamGiac tmp = new TamGiac();
        double maxTG = 0;
        for (TamGiac i : listTG) {
            if (i.chuViTamGiac() > maxTG) {
                maxTG = i.chuViTamGiac();
            }
        }
        for (TamGiac i : listTG) {
            if (i.chuViTamGiac() == maxTG)
                tmp = i;
        }
        return tmp;
    }

    public TamGiac minChuViTamGiac(List<TamGiac> listTG) {
        TamGiac tmp = new TamGiac();
        double minTG = Double.MIN_VALUE;
        for (TamGiac i : listTG) {
            if (i.chuViTamGiac() < minTG) {
                minTG = i.chuViTamGiac();
            }
        }
        for (TamGiac i : listTG) {
            if (i.chuViTamGiac() == minTG)
                tmp = i;
        }
        return tmp;
    }

    public void listTamGiac(List<TamGiac> listTG){
        System.out.println("DANH SACH TAM GIAC CO TRONG MANG LA : ");
        for (TamGiac i : listTG){
            System.out.println(i);
        }
    }

    public MyPoint getPointInput(Scanner scanner) {
        System.out.print("Nhap x and y : ");
        double x = scanner.nextDouble();
        double y = scanner.nextDouble();
        return new MyPoint(x, y);
    }
    public TamGiac inputTamGiac(){
        Scanner scanner = new Scanner(System.in);
        TamGiac tmp = new TamGiac();
        tmp.showListTamGiac();
        System.out.println("0. Exit");
        int option = 1;

        System.out.println("Nhap loai tam giac : ");
        option = scanner.nextInt();

        if (option != 0) {
            System.out.println("Nhap diem 1:");
            MyPoint point1 = getPointInput(scanner);

            System.out.println("Nhap diem 2:");
            MyPoint point2 = getPointInput(scanner);

            System.out.println("Nhap diem 3:");
            MyPoint point3 = getPointInput(scanner);

            switch (option){
                case 1: {
                    tmp = new TamGiacThuong(point1, point2, point3);
                }
                case 2: {
                    tmp = new TamGiacCan(point1, point2, point3);

                }
                case 3: {
                    tmp = new TamGiacVuong(point1, point2, point3);
                }
            }
        }
        scanner.close();
        return tmp;
    }

    public void chuViTGLessX(List<TamGiac> listTG, double x) {
        System.out.println("Cac Tam Giac co Chu Vi nho hon " + x + " : ");
        for (TamGiac i : listTG) {
            if (i.chuViTamGiac() < x) {
                System.out.print("\t");
                System.out.println(i);
            }
        }
    }

    public void trongTamInList(List<TamGiac> listTG){
        System.out.println("Trong tam cac tam giac trong List : ");
        for (TamGiac i : listTG){
            System.out.println("\t" + i + " co trong tam : " + i.trongTamTamGiac());
        }
    }

}



