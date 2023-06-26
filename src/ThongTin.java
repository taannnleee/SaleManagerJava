import javax.naming.ldap.Control;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;
import java.awt.Robot;
import java.util.Random;
import static java.awt.SystemColor.control;
import static java.lang.Thread.sleep;

public class ThongTin {
    public static void ThongTinNhom(int space )  {
        String line="";
        for(int i=0;i<space;i++)
        {
            line+=" ";
        }

        System.out.println(line+"╔=============================╗");
        System.out.println(line+"║            Nhom 12          ║");
        System.out.println(line+"║Le Tan               21110296║");
        System.out.println(line+"║Pham Quoc Trung      21110336║");
        System.out.println(line+"╚=============================╝");
    }

    public static void DungManHinh() throws IOException {
        System.out.println("Enter To Continue...");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
    }
}