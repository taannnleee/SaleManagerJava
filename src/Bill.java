import java.util.Scanner;

public class Bill  {
        private String nID;
        private String nTensp;
        private int iSoluong;
        private ThoiGian tNgaynhap;
        private ThoiGian tNgayhethan;
        private int iGiatien;

        public Bill()
        {
                this.tNgaynhap = new ThoiGian();
                this.tNgayhethan = new ThoiGian();
        }

        public Bill(String ID, String Tensp, int Soluong, ThoiGian Ngaynhap, ThoiGian Ngayhethan, int Giatien)
        {
                this.nID = ID;
                this.nTensp = Tensp;
                this.iSoluong = Soluong;
                this.tNgaynhap = Ngaynhap;
                this.tNgayhethan = Ngayhethan;
                this.iGiatien = Giatien;
        }



        public String getnID() {
                return nID;
        }

        public void setnID(String nID) {
                this.nID = nID;
        }

        public String getnTensp() {
                return nTensp;
        }

        public void setnTensp(String nTensp) {
                this.nTensp = nTensp;
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

        public void nhap() {
                Scanner sc = new Scanner(System.in);

                System.out.println("ID:");
                this.nID = sc.nextLine();
                System.out.println("Ten:");
                this.nTensp = sc.nextLine();
                System.out.println("So Luong:");
                this.iSoluong = sc.nextInt();
                System.out.println("Ngay Nhap Hang:");
                System.out.println("Ngay: ");
                this.tNgaynhap.setiNgay(sc.nextInt());
                System.out.println("Thang: ");
                this.tNgaynhap.setiThang(sc.nextInt());
                System.out.println("Nam: ");
                this.tNgaynhap.setiNam(sc.nextInt());
                System.out.println("Gio: ");
                this.tNgaynhap.setiGio(sc.nextInt());
                System.out.println("Phut: ");
                this.tNgaynhap.setiPhut(sc.nextInt());
                System.out.println("Giay: ");
                this.tNgaynhap.setiGiay(sc.nextInt());

                System.out.println("Ngay Het Han");
                System.out.println("Ngay: ");
                this.tNgayhethan.setiNgay(sc.nextInt());
                System.out.println("Thang: ");
                this.tNgayhethan.setiThang(sc.nextInt());
                System.out.println("Nam: ");
                this.tNgayhethan.setiNam(sc.nextInt());
                System.out.println("Gio: ");
                this.tNgayhethan.setiGio(sc.nextInt());
                System.out.println("Phut: ");
                this.tNgayhethan.setiPhut(sc.nextInt());
                System.out.println("Giay: ");
                this.tNgayhethan.setiGiay(sc.nextInt());
                System.out.println("Gia Tien");
                this.iGiatien = sc.nextInt();
        }


        public void xuat() {
                System.out.println("ID: " + this.nID);
                System.out.println("Ten: " + this.nTensp);
                System.out.println("So Luong: " + this.iSoluong);
                System.out.println("Ngay Nhap Hang: " + this.tNgaynhap.layThoiGian());
                System.out.println("Ngay Het Han: " + this.tNgayhethan.layThoiGian());
                System.out.println("Gia Tien: " + this.iGiatien);
        }

        public  boolean IsEqual(Bill sanpham)
        {
                if (this.nID == sanpham.nID)
                        return true;
                else
                        return false;
        }
}
