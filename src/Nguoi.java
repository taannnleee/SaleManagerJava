import java.util.Scanner;

public abstract class Nguoi {
    protected String sID;
    protected String sTen;
    protected String sGioiTinh;
    protected ThoiGian dNgaySinh;
    protected String sDiaChi;
    protected String sSoDienThoai;
    // Constructor
    public Nguoi()
    {
        dNgaySinh = new ThoiGian(-1, -1, -1);
    }
    public Nguoi(String sID, String sTen, String sGioiTinh
            , ThoiGian dNgaySinh, String sDiaChi, String sSoDienThoai)
    {
        this.sID = sID;
        this.sTen = sTen;
        this.sGioiTinh = sGioiTinh;
        this.sDiaChi = sDiaChi;
        this.dNgaySinh = dNgaySinh;
        this.sSoDienThoai = sSoDienThoai;
    }
    // Destructor

    public String getsID() {
        return sID;
    }

    public void setsID(String sID) {
        this.sID = sID;
    }

    public String getsTen() {
        return sTen;
    }

    public void setsTen(String sTen) {
        this.sTen = sTen;
    }

    public String getsGioiTinh() {
        return sGioiTinh;
    }

    public void setsGioiTinh(String sGioiTinh) {
        this.sGioiTinh = sGioiTinh;
    }

    public ThoiGian getdNgaySinh() {
        return dNgaySinh;
    }

    public void setdNgaySinh(ThoiGian dNgaySinh) {
        this.dNgaySinh = dNgaySinh;
    }

    public String getsDiaChi() {
        return sDiaChi;
    }

    public void setsDiaChi(String sDiaChi) {
        this.sDiaChi = sDiaChi;
    }

    public String getsSoDienThoai() {
        return sSoDienThoai;
    }

    public void setsSoDienThoai(String sSoDienThoai) {
        this.sSoDienThoai = sSoDienThoai;
    }

    // Methods
    public void Input()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println(("ID: "));
        this.sID = sc.nextLine();
        System.out.println(("Ten: "));
        this.sTen = sc.nextLine();
        System.out.println(("Gioi Tinh: "));
        this.sGioiTinh = sc.nextLine();
        System.out.println("Nhap ngay sinh");
        System.out.print("{");
        dNgaySinh.nhap();
        System.out.print("}");
        System.out.println("Dia chi: ");
        sDiaChi = sc.nextLine();
        System.out.println("So dien thoai: ");
        sSoDienThoai = sc.nextLine();
    }
    public void Print()
    {
        System.out.println("ID: " + this.sID);
        System.out.println("Ten: " + this.sTen);
        System.out.println("GioiTinh: " + sGioiTinh);
        System.out.println("Ngay sinh: " + sDiaChi);
        System.out.println("So dien thoai: " + sSoDienThoai);
    }
    public abstract boolean IsEquals(Nguoi nguoi);
}