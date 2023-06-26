import java.util.LinkedList;
import java.util.Scanner;

public class GiamDoc extends Nguoi {
    private int iLuong;
    private double iCoPhan;


    public int getiLuong() {
        return iLuong;
    }

    public void setiLuong(int iLuong) {
        this.iLuong = iLuong;
    }



    public double getiCoPhan() {
        return iCoPhan;
    }

    public void setiCoPhan(double iCoPhan) {
        this.iCoPhan = iCoPhan;
    }

    public GiamDoc(int iLuong, double iCoPhan) {
        this.iLuong = iLuong;
        this.iCoPhan = iCoPhan;
    }

    public GiamDoc(String sID, String sTen, String sGioiTinh, ThoiGian dNgaySinh, String sDiaChi, String sSoDienThoai, int iLuong, double iCoPhan) {
        super(sID, sTen, sGioiTinh, dNgaySinh, sDiaChi, sSoDienThoai);
        this.iLuong = iLuong;
        this.iCoPhan = iCoPhan;
    }

    public  GiamDoc()
    {}


    // Method
    @Override
    public void Input()
    {
        Scanner sc = new Scanner(System.in);
        super.Input();
        System.out.println("Luong: ");
        this.iLuong = sc.nextInt();
        System.out.println("CoPhan");
        this.iCoPhan = sc.nextDouble();
    }
    @Override
    public void Print()
    {
        super.Print();
        System.out.println("Luong: " + this.iLuong);
        System.out.println("CoPhan: "+this.iCoPhan+"%");
    }
    @Override
    public boolean IsEquals(Nguoi nguoi)
    {
        if (this.sID == nguoi.sID)
            return true;
        return false;
    }

}