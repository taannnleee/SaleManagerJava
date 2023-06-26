
public class Main {
    public static void main(String[] args) {
        ThongTin.ThongTinNhom(0);
        int chon = DangNhap.Run();
        while(true){
            switch (chon){
                case Constant.BACK_TO_PROGRAM:
                    chon = Menu.Run();
                    break;
                case Constant.MESSAGE_INTO_THE_STOCK:
                    chon = QuanLyKho.Run();
                    break;
                case Constant.MESSAGE_INTO_THE_STAFF:
                    chon = QuanLyNhanVien.Run();
                    break;
                case Constant.MESSAGE_INTO_THE_BILL:
                    chon = QuanLyBill.Run();
                    break;
                default:
                    System.out.println("Quit app");
                    return;
            }
        }
    }
}