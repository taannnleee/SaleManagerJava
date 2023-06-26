import java.util.Scanner;

public class SanPham {
    private String sID;
    private String sTensp;
    private int iSoluong;
    private ThoiGian tNgaynhap;
    private ThoiGian tNgayhethan;
    private int iGiatien;

    public String getiID() {
        return sID;
    }

    public void setiID(String iID) {
        this.sID = iID;
    }

    public String getsTensp() {
        return sTensp;
    }

    public void setsTensp(String sTensp) {
        this.sTensp = sTensp;
    }

    public int getiSoluong() {
        return iSoluong;
    }

    public void setiSoluong(int iSoluong) {
        this.iSoluong = iSoluong;
    }

    public ThoiGian gettNgaynhap() {
        return tNgaynhap;
    }

    public void settNgaynhap(ThoiGian tNgaynhap) {
        this.tNgaynhap = tNgaynhap;
    }

    public ThoiGian gettNgayhethan() {
        return tNgayhethan;
    }

    public void settNgayhethan(ThoiGian tNgayhethan) {
        this.tNgayhethan = tNgayhethan;
    }

    public int getiGiatien() {
        return iGiatien;
    }

    public void setiGiatien(int iGiatien) {
        this.iGiatien = iGiatien;
    }

    public SanPham()
    {
        tNgaynhap = new ThoiGian();
        tNgayhethan = new ThoiGian();
    }

    public SanPham(String sID, String sTensp, int iSoluong, ThoiGian tNgaynhap, ThoiGian tNgayhethan, int iGiatien)
    {
        this.sID = sID;
        this.sTensp = sTensp;
        this.iSoluong = iSoluong;
        this.tNgaynhap = tNgaynhap;
        this.tNgayhethan = tNgayhethan;
        this.iGiatien = iGiatien;
    }

    public void nhap()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("ID:");
        this.sID = new String(sc.nextLine());
        System.out.println("Ten:");
        this.sTensp = new String(sc.nextLine());
        System.out.println("So Luong:");
        this.iSoluong = sc.nextInt();
        System.out.println("Ngay Nhap Hang:");
        System.out.print("Ngay: ");
        this.tNgaynhap.setiNgay(sc.nextInt());
        System.out.print("Thang: ");
        this.tNgaynhap.setiThang(sc.nextInt());
        System.out.print("Nam: ");
        this.tNgaynhap.setiNam(sc.nextInt());
        System.out.print("Gio: ");
        this.tNgaynhap.setiGio(sc.nextInt());
        System.out.print("Phut: ");
        this.tNgaynhap.setiPhut(sc.nextInt());
        System.out.print("Giay: ");
        this.tNgaynhap.setiGiay(sc.nextInt());

        System.out.println("Ngay Het Han");
        System.out.print("Ngay: ");
        this.tNgayhethan.setiNgay(sc.nextInt());
        System.out.print("Thang: ");
        this.tNgayhethan.setiThang(sc.nextInt());
        System.out.print("Nam: ");
        this.tNgayhethan.setiNam(sc.nextInt());
        System.out.print("Gio: ");
        this.tNgayhethan.setiGio(sc.nextInt());
        System.out.print("Phut: ");
        this.tNgayhethan.setiPhut(sc.nextInt());
        System.out.print("Giay: ");
        this.tNgayhethan.setiGiay(sc.nextInt());

        System.out.println("Gia Tien");
        this.iGiatien = sc.nextInt();
    }

    public void xuat()
    {
        System.out.println("ID: " + this.sID);
        System.out.println("Ten: " + this.sTensp);
        System.out.println("So Luong: " + this.iSoluong);
        System.out.println("Ngay Nhap Hang: " + this.tNgaynhap.layThoiGian());
        System.out.println("Ngay Het Han: " + this.tNgayhethan.layThoiGian());
        System.out.println("Gia Tien: " + this.iGiatien);
    }

    public boolean IsEqual(SanPham sanpham)
    {
        if ((this.sID.equals(sanpham.sID)||this.sID.equalsIgnoreCase(sanpham.sID)) )
            return true;
        else
            return false;
    }
    public boolean IsEqualProduct(SanPham sanpham)
    {
        if ((this.sID.equals(sanpham.sID)||this.sID.equalsIgnoreCase(sanpham.sID)) &&
                (this.sTensp.equals(sanpham.sTensp)||this.sTensp.equalsIgnoreCase(sanpham.sTensp))  )
            return true;
        return false;
    }


}
