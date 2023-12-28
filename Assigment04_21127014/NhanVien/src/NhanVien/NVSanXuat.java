package NhanVien;

public class NVSanXuat extends NhanVien {
    int luongHour;
    int dayWorking;

    public NVSanXuat(){
        super();
        luongHour = 0;
        dayWorking = 0;
    }

    public NVSanXuat(String a, String b, String c, int d, int e){
        super(a, b, c);
        luongHour = d;
        dayWorking = e;
    }

    @Override
    public String toString() {
        return "Nhan vien San xuat - " + "MaNV: " + maNV + ", HoTen: " + fullName + ", SDT: " + phone + ", Luong/Day: " + luongHour + ", Dates: " + dayWorking;
    }
}
