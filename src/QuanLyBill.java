import java.io.IOException;
import java.util.Scanner;

public class QuanLyBill
{
    public static int Run()  {
        DanhSachSanPham productList = SanPhamTrongKho.productList;
        DanhSachBill billList = BillTrongKho.billList;
        Bill tempBill = new Bill();
        DanhSachBill tempListBill = new DanhSachBill(100);
        int choose = 17;
        while (true)
        {
            System.out.flush();
            System.out.println("=========================MENU==========================\n");
            System.out.println("1.Kiem tra so luong hang ton trong kho                |\n");
            System.out.println("2.In Bill                                             |\n");
            System.out.println("3.Back                                                |\n");
            System.out.println("=========================MENU==========================\n");
            System.out.println("Choose: ");
            try
            {
                Scanner sc = new Scanner(System.in);
                choose = sc.nextInt();
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }

            switch (choose)
            {
                case 1:
                    productList.Print();
                    break;
                case 2:
                    tempBill.nhap();
                    System.out.println("==============================BILL================================================");
                    tempBill.xuat();
                    billList.AddLast(tempBill);
                    billList.UpdateItem(tempBill);
                    break;
                case 3:
                    return Constant.BACK_TO_PROGRAM;
                default:
                    return 100;
            }
            try {
                ThongTin.DungManHinh();
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}