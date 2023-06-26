import java.util.Scanner;

public class Menu {

    public static int Run()
    {
        int chon = -1000;
        while(true)
        {
            System.out.flush();
            System.out.println("Chon che do ma ban muon quan ly");
            System.out.println("[1] => Kho Hang ");
            System.out.println("[2] => Nhan Vien");
            System.out.println("[3] => Bill");
            System.out.println("[4].Thoat chuong trinh");
            try
            {
                Scanner sc = new Scanner(System.in);
                chon = Integer.valueOf(sc.nextLine());

            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
            }
            switch (chon)
            {
                case 1: return Constant.MESSAGE_INTO_THE_STOCK;
                case 2: return Constant.MESSAGE_INTO_THE_STAFF;
                case 3: return Constant.MESSAGE_INTO_THE_BILL;
                case 4: return Constant.OUT_APP;
                default:
                    System.out.println("Sai cu phap");
                    break;
            }
        }
    }
}
