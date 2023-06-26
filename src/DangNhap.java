import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

interface check {
    public boolean Checkk(String tk, int mk);
}
public class DangNhap {
    public static int Run()
    {
        while(true)
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("Tài Khoản : ");
            String a = sc.nextLine();
            System.out.println("Mật Khẩu : ");
            int b = sc.nextInt();

            check temp = (tk,mk)->{

                if(tk.equals("tanle")&& mk==123123)
                {
                    return true;
                }return  false;
            };
            if(temp.Checkk(a,b)==true)
            {
                return 1;
            }
            else
            {
                System.out.println("Moi Nhap Lai ");
            }
        }
    }



}
