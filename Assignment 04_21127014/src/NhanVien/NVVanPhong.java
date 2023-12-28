package NhanVien;

public class NVVanPhong extends NhanVien {
    int luong;

    NVVanPhong(){
        super();
        luong = 0;
    }

    NVVanPhong(String a, String b, String c, int d){
        super(a, b, c);
        luong = d;
    }

    @Override
    public String toString() {
        return "Nhan Vien Van Phong - " +  "MaNV: " + maNV + ", HoTen: " + fullName + ", SDT: " + phone + ", Luong: " + luong;
    }

}
