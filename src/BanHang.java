import java.util.LinkedList;
import java.util.Scanner;

public class BanHang extends Nguoi {
    private int iLuong;
    private LinkedList<String> lDonHang;
    //properties


    public LinkedList<String> getlDonHang() {
        return lDonHang;
    }

    public void setlDonHang(LinkedList<String> lDonHang) {
        this.lDonHang = lDonHang;
    }

    public int getiLuong() {
        return iLuong;
    }

    public void setiLuong(int iLuong) {
        this.iLuong = iLuong;
    }

    // Constucter
    public BanHang()
    {
        super();
    }
    public BanHang(String id, String Ten, String GioiTinh,
                   ThoiGian NgaySinh, String DiaChi, String SoDienThoai,
                   int Luong)
    {
        super(id, Ten, GioiTinh, NgaySinh, DiaChi, SoDienThoai );
        this.iLuong = Luong;
    }

    public BanHang(String id, String Ten, String GioiTinh,
                   ThoiGian NgaySinh, String DiaChi, String SoDienThoai,
                   int Luong, LinkedList<String> DonHang)
    {
        super(id, Ten, GioiTinh, NgaySinh, DiaChi, SoDienThoai);
        this.iLuong = Luong;
        this.lDonHang = DonHang;
    }
    // Method
    @Override
    public void Input()
    {
        Scanner sc = new Scanner(System.in);
        super.Input();
        System.out.println("Luong: ");
        this.iLuong = sc.nextInt();
    }
    @Override
    public void Print()
    {
        super.Print();
        System.out.println("Luong: " + this.iLuong);
    }
    public boolean IsEquals(Nguoi nguoi)
    {
        if (this.sID == nguoi.sID)
            return true;
        return false;
    }

}