import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
public class ThoiGian {
    private int iNgay;
    private int iThang;
    private int iNam;
    private int iGio;
    private int iPhut;
    private int iGiay;

    public int getiNgay() {
        return iNgay;
    }

    public void setiNgay(int iNgay) {

        if(CheckTime.CheckNgay(iNam, iThang, iNgay)==0)
            throw new RuntimeException();
        this.iNgay = iNgay;
    }

    public int getiThang() {
        return iThang;
    }

    public void setiThang(int iThang) {
        if(CheckTime.CheckThang(iThang)==0)
            throw new RuntimeException();
        this.iThang = iThang;
    }

    public int getiNam() {
        return iNam;
    }

    public void setiNam(int iNam) {
        if(CheckTime.CheckNam(iNam)==0)
            throw new RuntimeException();
        this.iNam = iNam;
    }

    public int getiGio() {
        return iGio;
    }

    public void setiGio(int iGio) {
        if(CheckTime.CheckGio(iGio)==0)
            throw new RuntimeException();
        this.iGio = iGio;
    }

    public int getiPhut() {
        return iPhut;
    }

    public void setiPhut(int iPhut) {
        if(CheckTime.CheckPhut(iPhut)==0)
            throw new RuntimeException();
        this.iPhut = iPhut;
    }

    public int getiGiay() {
        return iGiay;
    }

    public void setiGiay(int iGiay) {
        if(CheckTime.CheckGiay(iGiay)==0)
            throw new RuntimeException();
        this.iGiay = iGiay;
    }

    public ThoiGian()
    {

    }

    public ThoiGian(int iNgay, int iThang, int iNam)
    {
        this.iNgay = iNgay;
        this.iThang = iThang;
        this.iNam = iNam;
    }

    public ThoiGian(int iNgay, int iThang, int iNam, int iGio, int iPhut, int iGiay)
    {
        this.iNgay = iNgay;
        this.iThang = iThang;
        this.iNam = iNam;
        this.iGio = iGio;
        this.iPhut = iPhut;
        this.iGiay = iGiay;
    }

    public void nhap()
    {
        System.out.println("Day:");
        Scanner sc = new Scanner(System.in);
        int ngay = sc.nextInt();
        setiNgay(ngay);
        System.out.println("Thang:");
        int thang = sc.nextInt();
        setiThang(thang);
        System.out.println("Nam:");
        int nam = sc.nextInt();
        setiNam(nam);

        System.out.println("Gio:");
        int gio = sc.nextInt();
        setiNgay(gio);
        System.out.println("Phut:");
        int phut = sc.nextInt();
        setiThang(phut);
        System.out.println("Giay:");
        int giay = sc.nextInt();
        setiNam(giay);


    }

    public void xuat()
    {
        System.out.println("Day:" + this.iNgay);
        System.out.println("Thang:" + this.iThang);
        System.out.println("Nam:" + this.iNam);
        System.out.println("Gio:" + this.iGio);
        System.out.println("Phut:" + this.iPhut);
        System.out.println("Giay:" + this.iGiay);

    }

    public static boolean lonHon(ThoiGian a, ThoiGian b)
    {
        if (a.iNam > b.iNam) return true;
        if (a.iNam < b.iNam) return false;
        if (a.iThang > b.iThang) return true;
        if (a.iThang < b.iThang) return false;
        if (a.iNgay > b.iNgay) return true;
        if (a.iNgay < b.iNgay) return false;
        if(a.iGio > b.iGio) return true;
        if(b.iGio < b.iGio) return false;
        if (a.iPhut > b.iPhut) return true;
        if (a.iPhut < b.iPhut) return false;
        if (a.iGiay > b.iGiay) return true;
        if(a.iGiay < b.iGiay) return false;
        return false;
    }

    public static boolean lonHonHoacBang(ThoiGian a, ThoiGian b)
    {
        if (a.iNam > b.iNam) return true;
        if (a.iNam < b.iNam) return false;
        if (a.iThang > b.iThang) return true;
        if (a.iThang < b.iThang) return false;
        if (a.iNgay > b.iNgay) return true;
        if (a.iNgay < b.iNgay) return false;
        if(a.iGio > b.iGio) return true;
        if(b.iGio < b.iGio) return false;
        if (a.iPhut > b.iPhut) return true;
        if (a.iPhut < b.iPhut) return false;
        if (a.iGiay > b.iGiay) return true;
        if(a.iGiay < b.iGiay) return false;
        return true;
    }

    public static boolean NhoHon(ThoiGian a, ThoiGian b)
    {
        if (a.iNam < b.iNam) return true;
        if (a.iNam > b.iNam) return false;
        if (a.iThang < b.iThang) return true;
        if (a.iThang > b.iThang) return false;
        if (a.iNgay < b.iNgay) return true;
        if (a.iNgay > b.iNgay) return false;
        if (a.iGio < b.iGio) return true;
        if (b.iGio > b.iGio) return false;
        if (a.iPhut < b.iPhut) return true;
        if (a.iPhut > b.iPhut) return false;
        if (a.iGiay < b.iGiay) return true;
        if (a.iGiay > b.iGiay) return false;
        return false;
    }

    public static boolean NhoHonHoacBang(ThoiGian a, ThoiGian b)
    {
        if (a.iNam < b.iNam) return true;
        if (a.iNam > b.iNam) return false;
        if (a.iThang < b.iThang) return true;
        if (a.iThang > b.iThang) return false;
        if (a.iNgay < b.iNgay) return true;
        if (a.iNgay > b.iNgay) return false;
        if (a.iGio < b.iGio) return true;
        if (b.iGio > b.iGio) return false;
        if (a.iPhut < b.iPhut) return true;
        if (a.iPhut > b.iPhut) return false;
        if (a.iGiay < b.iGiay) return true;
        if (a.iGiay > b.iGiay) return false;
        return true;
    }



    public String layThoiGian()
    {
        int ngay = iNgay, thang = iThang, nam = iNam;
        int gio = iGio, phut = iPhut, giay = iGiay;
        String dateTime = "";
        if (ngay < 10)
            dateTime += ("0" + ngay);
        else
            dateTime += ngay;
        dateTime += "/";

        if (thang < 10)
            dateTime += ("0" + thang);
        else
            dateTime += thang;
        dateTime += "/";
        dateTime += nam;
        dateTime += " ";
        if (gio < 10)
            dateTime += ("0" + gio);
        else
            dateTime += gio;
        dateTime += ":";
        if (phut < 10)
            dateTime += ("0" + phut);
        else
            dateTime += phut;
        dateTime += ":";
        if (giay < 10)
            dateTime += ("0" + giay);
        else
            dateTime += giay;
        return dateTime;
    }

    public  String NgayHienTai()
    {

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        System.out.print("Ngay Hom nay la: ");
        System.out.println(formatter.format(date));
        return formatter.format(date);

    }

    public ThoiGian ThoiGian(String date)
    {
        int ngay = (((date.charAt(0)) - '0') * 10) + ((date.charAt(1)) - '0');
        int thang = (((date.charAt(3)) - '0') * 10) + ((date.charAt(4)) - '0');
        int nam = (((date.charAt(6) - '0') * 10 + (date.charAt(7) - '0')) * 10 +
                (date.charAt(8) - '0')) * 10 + (date.charAt(9) - '0');
        if (date.length() == 10)
            return new ThoiGian(ngay, thang, nam);
        int gio = (((date.charAt(11)) - '0') * 10) + ((date.charAt(12)) - '0');
        int phut = (((date.charAt(14)) - '0') * 10) + ((date.charAt(15)) - '0');
        int giay = (((date.charAt(17)) - '0') * 10) + ((date.charAt(18)) - '0');

        return new ThoiGian(ngay, thang, nam, gio, phut, giay);
    }

}
