import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class QuanLyNhanVien {
    public static int Run() {
        DanhSachBanHang DSNhanVien = NhanVienCuaHang.staff;
        Nguoi giamdoc = new GiamDoc("GD01","Tran Thanh Cong","nam",new ThoiGian(19,02,20043,12,12,12), "Tra Vinh","0776506179",100000000,80);// tinh da hinh
        BanHang temp = new BanHang();
        DanhSachBanHang tempList = new DanhSachBanHang(DSNhanVien.iGioiHan);
        ThoiGian Time = new ThoiGian();
        String id;
        int index;
        String tempName;
        int choose = -100;
        while (true) {
            System.out.flush();
            System.out.println("==============================MENU==============================");
            System.out.println("|...........................|Nhan vien|.........................|");
            System.out.println("|   1. In danh sach nhan vien                                   |");
            System.out.println("|   2. Them nhan vien vao cuoi danh sach                        |");
            System.out.println("|   3. Them vao danh sach nhan vien                             |");
            System.out.println("|   4. Tim thong tin nhan vien theo id                          |");
            System.out.println("|   5. Tim thong nhan vien theo ten                             |");
            System.out.println("|   6. Sap xep nhan vien ban hang theo luong                    |");
            System.out.println("|   7. In tong so luong nhan vien                               |");
            System.out.println("|   8. In nhan vien co luong cao hon muc nhap                   |");
            System.out.println("|   9. Nhan vien co luong cao nhat                              |");
            System.out.println("|  10. Nhan vien co luong thap nhat                             |");
            System.out.println("|  11. Xuat file nhan vien                                      |");
            System.out.println("|  12. Thong Tin Giam Doc Cua Cua Hang                          |");
            System.out.println("|  13. TroVe                                                    |");
            System.out.println("|  14. Thoat                                                    |");
            System.out.println("==============================MENU==============================");
            System.out.println("Nhap so: ");
            try {
                Scanner sc = new Scanner(System.in);
                choose = sc.nextInt();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            Scanner sc = new Scanner(System.in);
            switch (choose) {
                case 1:
                    System.out.println(".......................................In danh sach nhan vien....................................");

                    DSNhanVien.Print();
                    System.out.println(".................................................................................................");
                    break;
                case 2:
                    System.out.println("...............................Them mot nhan vien vao cuoi danh sach.............................");
                    System.out.println("Chen thong tin nhan vien");
                    temp = new BanHang();
                    temp.Input();
                    System.out.println(".................................................................................................");
                    DSNhanVien.AddLast(temp);
                    System.out.println("Hoan thanh....");
                    System.out.println(".................................................................................................");
                    break;
                case 3:
                    tempList = new DanhSachBanHang(DSNhanVien.iGioiHan);
                    System.out.println("....................................Them danh sach nhan vien.....................................");
                    System.out.println("Nhap so luong nhan vien");
                    int no = sc.nextInt();
                    for (int i = 0; i < no; i++)
                    {
                        System.out.println("No:  " + (i + 1));
                        temp = new BanHang();
                        System.out.println(".............................................................................................");
                        temp.Input();
                        System.out.println(".............................................................................................");
                        tempList.AddLast(temp);
                    }
                    DSNhanVien.AddRange(tempList);
                    System.out.println("Hoan thanh...");
                    System.out.println(".................................................................................................");
                    break;
                case 4:
                    temp = new BanHang();

                    System.out.println("nhap id nhan vien");
                    temp.sID = sc.nextLine();
                    temp = DSNhanVien.SearchItemByID(temp);
                    System.out.println("---------------------------------------------Result---------------------------------");
                    if (temp == null)
                        System.out.println("Khong tim thay id nhan vien");
                    else
                    {
                        temp.Print();
                    }
                    break;
                case 5:
                    temp = new BanHang();
                    System.out.println("Nhap ten nhan vien: ");
                    temp.sTen = sc.nextLine();
                    String name = temp.sTen;
                    tempList = DSNhanVien.SearchSaleByName(name);
                    System.out.println("---------------------------------------------Result---------------------------------");
                    if (tempList == null)
                        System.out.println("Khong tim thay ten nhan vien");
                    else
                        tempList.Print();
                    break;
                case 6:
                    System.out.println("................................Sap xep nhan vien theo luong.................................");
                    DSNhanVien.SortBySalary();
                    DSNhanVien.Print();
                    System.out.println(".................................................................................................");
                    break;
                case 7:
                    System.out.println("Tong so nhan vien: ");
                    int sum = DSNhanVien.TotalSales();
                    System.out.println(sum);
                    break;
                case 8:
                    System.out.println("Nhan vien co luong cao hon: ");
                    int luong = sc.nextInt();
                    tempList = DSNhanVien.SalaryMoreThan(luong);
                    if(tempList == null)
                        System.out.println("Khong tim thay nhan vien");
                    else
                    {
                        tempList.Print();
                    }
                    break;
                case 9:
                    System.out.println("Nhan vien co luong cao nhat: ");
                    tempList = DSNhanVien.MaximumNumberOfSalary();
                    if(tempList == null)
                        System.out.println("Khong tim thay nhan vien");
                    else
                    {
                        tempList.Print();
                    }
                    break;
                case 10:
                    System.out.println("Nhan vien co luong thap nhat: ");
                    tempList = DSNhanVien.MinimumNumberOfSalary();
                    if (tempList == null)
                        System.out.println("Khong tim thay nhan vien");
                    else
                    {
                        tempList.Print();
                    }
                    break;
                case 11:
                    System.out.println("Enter file name: ");
                    tempName = sc.nextLine();
                    System.out.println(tempName);
                    DSNhanVien.WriteFile(tempName);
                    System.out.println("Thanh cong");
                    DSNhanVien.Print();
                    break;
                case  12:
                    System.out.println("===================ThongTinGiamDoc===============");
                    giamdoc.Print();
                    break;
                case 13:
                    return 1;
                case 14:
                    return 10;
                default:
                    break;
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