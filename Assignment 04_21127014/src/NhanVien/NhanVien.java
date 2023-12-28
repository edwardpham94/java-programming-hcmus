package NhanVien;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class NhanVien {
    String maNV;
    String fullName;

    String phone;

    NhanVien(){
        maNV = "000000";
        fullName = "000000";
        phone = "000000";
    }

    NhanVien(String a, String b, String c){
        maNV = a;
        fullName = b;
        phone = c;
    }

    NhanVien getNVInput() {
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        System.out.println("Loai Nhan Vien");
        System.out.println("1. Nhan Vien San Xuat");
        System.out.println("2. Nhan Vien Van Phong");
        System.out.print("Nhap loai nhan vien can them : ");
        option = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        NhanVien tmp = new NhanVien();
        String a, b, c;
        int d, e;
        System.out.println("Nhap Ma Nhan Vien :");
        a = scanner.nextLine();
        System.out.println("Nhap Ho Ten : ");
        b = scanner.nextLine();
        System.out.println("Nhap Dien Thoai : ");
        c = scanner.nextLine();

        if (option == 1){
            System.out.println("Nhap so luong theo ngay : ");
            d = scanner.nextInt();
            System.out.println("Nhap so ngay lam trong thang : ");
            e = scanner.nextInt();
            tmp = new NVSanXuat(a, b, c, d, e);
        }

        if (option == 2){
            System.out.println("Nhap Luong Nhan Vien: ");
            d = scanner.nextInt();
            tmp = new NVVanPhong(a, b, c, d);
        }

        return tmp;
    }

    @Override
    public String toString() {
        return "Nhan Vien - MaNV: " + maNV + ", HoTen: " + fullName + ", SDT: " + phone;
    }

    void listNV(List<NhanVien> listNV) {
        System.out.println("\n\t*** DANH SACH TAT CA NHAN VIEN ***");

        for (NhanVien i : listNV) {
            System.out.println(i);
        }
    }
    void getListNVVanPhong(List<NhanVien> listNV) {
        System.out.println("\n\t*** DANH SACH NHAN VIEN VAN PHONG ***");
        for (NhanVien i : listNV) {
            if (i instanceof NVVanPhong) {
                System.out.println(i);
            }
        }
    }

    void getListNVSanXuat(List<NhanVien> listNV) {
        System.out.println("\n\t*** DANH SACH NHAN VIEN SAN XUAT ***");
        for (NhanVien i : listNV) {
            if (i instanceof NVSanXuat) {
                System.out.println(i);
            }
        }
    }

    void getListNVWithXInName(List<NhanVien> listNV, String x) {
        System.out.println("\n\t*** DANH SACH NHAN VIEN FULLNAME CO x  ***");
        for (NhanVien i : listNV) {
            if ((i.fullName).indexOf(x) != -1) {
                System.out.println(i);
            }
        }
    }

    void displayLuongNV(List<NhanVien> listNV){
        System.out.println("\n\t*** DANH SACH LUONG CUA NHAN VIEN THEO THANG ***");
        for (NhanVien i : listNV) {
            System.out.print(i.maNV + "\t" + String.format("%12s", i.fullName) + "\t");
            if (i instanceof NVVanPhong){
                System.out.print(String.format("%20s", ((NVVanPhong) i).luong));
            }
            if (i instanceof NVSanXuat) {
                System.out.print(String.format("%12s", ((NVSanXuat) i).luongHour * ((NVSanXuat) i).dayWorking));
            }
            System.out.println();
        }
    }

    void listMaxLuong(List<NhanVien> listNV){
        System.out.println("\n\t*** DANH SACH NHAN VIEN CO LUONG CAO NHAT ***");
        double maxLuong = 0;
        for(NhanVien i : listNV){
            if (i instanceof NVVanPhong){
                if (((NVVanPhong) i).luong > maxLuong){
                    maxLuong = ((NVVanPhong) i).luong;
                }
            }
            if (i instanceof NVSanXuat) {
                double salary = ((NVSanXuat) i).dayWorking*((NVSanXuat) i).luongHour ;
                if ( salary > maxLuong){
                    maxLuong = salary;
                }
            }
        }

        for (NhanVien i : listNV) {
            if (i instanceof NVVanPhong){
                if (((NVVanPhong) i).luong == maxLuong){
                    System.out.println(i);
                }
            }
            if (i instanceof NVSanXuat) {
                double salary = ((NVSanXuat) i).dayWorking*((NVSanXuat) i).luongHour ;
                if ( salary == maxLuong){
                    System.out.println(i);
                }
            }
        }
    }

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
