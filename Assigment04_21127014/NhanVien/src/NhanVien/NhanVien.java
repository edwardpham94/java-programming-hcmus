package NhanVien;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class NhanVien {
    public String maNV;
    public String fullName;

    public String phone;

    public NhanVien(){
        maNV = "000000";
        fullName = "000000";
        phone = "000000";
    }

    public NhanVien(String a, String b, String c){
        maNV = a;
        fullName = b;
        phone = c;
    }

    public NhanVien getNVInput() {
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

    public void listNV(List<NhanVien> listNV) {
        System.out.println("\n\t*** DANH SACH TAT CA NHAN VIEN ***");

        for (NhanVien i : listNV) {
            System.out.println(i);
        }
    }
    public void getListNVVanPhong(List<NhanVien> listNV) {
        System.out.println("\n\t*** DANH SACH NHAN VIEN VAN PHONG ***");
        for (NhanVien i : listNV) {
            if (i instanceof NVVanPhong) {
                System.out.println(i);
            }
        }
    }

    public void getListNVSanXuat(List<NhanVien> listNV) {
        System.out.println("\n\t*** DANH SACH NHAN VIEN SAN XUAT ***");
        for (NhanVien i : listNV) {
            if (i instanceof NVSanXuat) {
                System.out.println(i);
            }
        }
    }

    public void getListNVWithXInName(List<NhanVien> listNV, String x) {
        System.out.println("\n\t*** DANH SACH NHAN VIEN FULLNAME CO x  ***");
        for (NhanVien i : listNV) {
            if ((i.fullName).indexOf(x) != -1) {
                System.out.println(i);
            }
        }
    }

    public void displayLuongNV(List<NhanVien> listNV){
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

    public void listMaxLuong(List<NhanVien> listNV){
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


}
