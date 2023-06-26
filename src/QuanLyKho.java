import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class QuanLyKho {

    public static int Run() {
        DanhSachSanPham productList = SanPhamTrongKho.productList;
        DanhSachSanPham tempList = new DanhSachSanPham(100);
        SanPham tempProduct;
        ThoiGian today;
        String tempName;
        int index;
        int sum;
        int choose = 100;
        while (true)
        {
            System.out.flush();
            System.out.println("=========================MENU==========================\n");
            System.out.println("| 1. In san pham trong kho                              |\n");
            System.out.println("| 2. Them san pham vao kho                              |\n");
            System.out.println("| 3. Chen mot san pham vao vi tri chon truoc            |\n");
            System.out.println("| 4. Tim kiem san pham theo ID                          |\n");
            System.out.println("| 5. Tim kiem san pham theo ten                         |\n");
            System.out.println("| 6. Sap xep san pham theo so luong san pham trong kho  |\n");
            System.out.println("| 7. In san pham het han                                |\n");
            System.out.println("| 8. Tong so luong san pham trong kho                   |\n");
            System.out.println("| 9. Tim so luong cua mot san pham                      |\n");
            System.out.println("|10. Danh sach san pham co so luong nhieu hon 100       |\n");
            System.out.println("|11. San pham co so luong nhieu nhat                    |\n");
            System.out.println("|12. San pham co so luong it nhat                       |\n");
            System.out.println("|13. Xuat so luong san pham theo ten                    |\n");
            System.out.println("|14. Xuat phieu                                         |\n");
            System.out.println("|15. Doi ten san pham                                   |\n");
            System.out.println("|16. Tro ve                                             |\n");
            System.out.println("|any key. Quit app                                      |\n");
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
            System.out.println();
            Scanner sc = new Scanner(System.in);
            switch (choose)
            {
                case 1:
                    System.out.println("---------------------------------------------------Result-----------------------------------------");
                    productList.Print();
                    break;
                case 2:
                    tempProduct = new SanPham();
                    tempProduct.nhap();
                    if (productList.ItemAlreadyExists(tempProduct) == true)
                    {
                        productList.Print();
                    }
                    else
                    {
                        productList.AddLast(tempProduct);
                        System.out.println("---------------------------------------------------Result-----------------------------------------");
                        productList.Print();
                    }
                    break;
                case 3:
                    tempProduct = new SanPham();
                    System.out.println("Location Add Products");
                    index = sc.nextInt();
                    System.out.println("Product Information");
                    tempProduct.nhap();
                    if (productList.ItemAlreadyExists(tempProduct) == true)
                    {
                        productList.Print();
                    }
                    else
                    {
                        productList.AddItem(index, tempProduct);
                        System.out.println("---------------------------------------------------Result-----------------------------------------");
                        productList.Print();
                    }
                    break;
                case 4:
                    tempProduct = new SanPham();
                    System.out.println("Enter product ID");
                    tempProduct.setiID(sc.nextLine());
                    tempProduct = productList.SearchItemByID(tempProduct);
                    System.out.println("---------------------------------------------Result---------------------------------");
                    if (tempProduct == null)
                        System.out.println("Khong tim thay san san pham");
                    else
                    {
                        tempProduct.xuat();
                    }
                    break;
                case 5:
                    tempProduct = new SanPham();
                    System.out.println("Enter product name ");
                    tempProduct.setsTensp( sc.nextLine());
                    String name = tempProduct.getsTensp();
                    tempList = productList.SearchItemByName(name);
                    System.out.println("---------------------------------------------------Result-----------------------------------------");
                    if (tempList == null)
                        System.out.println("Khong tim thay san pham");
                    else
                    {
                        tempList.Print();
                    }
                    break;
                case 6:
                    productList.SortByNumberOfProduct();
                    productList.Print();
                    break;
                case 7:
                    today = new ThoiGian();
                    //today.NgayHienTai();
                    ThoiGian today2 = new ThoiGian();
                    //today2.ThoiGian(today.NgayHienTai());
                    tempList = productList.FindExpiredProducts(today2.ThoiGian(today.NgayHienTai()));
                    if (tempList.IsEmpty())
                        System.out.println("Khong co san pham nao het han");
                    else
                    {
                        tempList.Print();
                    }
                    break;
                case 8:
                    sum = productList.TotalGoods();
                    System.out.println(sum);
                    break;
                case 9:
                    tempProduct = new SanPham();
                    System.out.println("Enter product ID : ");
                    tempProduct.setiID( sc.nextLine());
                    int tam = productList.CheckNumberProduct(tempProduct);
                    System.out.println(tam);
                    break;
                case 10:
                    tempList = new DanhSachSanPham(100); ;
                    tempList = productList.ProductQuantityMoreThan100();
                    if (tempList == null)
                        System.out.println("khong tim thay san pham");
                    else
                    {
                        tempList.Print();
                    }
                    break;
                case 11:
                    tempList = new DanhSachSanPham(100); ;
                    tempList = productList.MaximumNumberOfProducts();
                    if (tempList == null)
                        System.out.println("khong tim thay san pham");
                    else
                    {
                        tempList.Print();
                    }
                    break;
                case 12:
                    tempList = new DanhSachSanPham(100); ;
                    tempList = productList.MinimumNumberOfProducts();
                    if (tempList == null)
                        System.out.println("Khong tim thay san pham");
                    else
                    {
                        tempList.Print();
                    }
                    break;
                case 13:
                    tempProduct = new SanPham();
                    System.out.println("Enter product name ");
                    tempProduct.setsTensp(sc.nextLine());
                    String name1 =tempProduct.getsTensp();
                    tempProduct = productList.QuantityOfAProduct(name1);
                    System.out.println("---------------------------------------------------Result-----------------------------------------");
                    if (tempProduct == null)
                        System.out.println("Khong tim thay san pham");
                    else
                    {
                        System.out.println(tempProduct.getiSoluong());
                    }
                    break;
                case 14:
                    System.out.println("Enter file name: ");
                    tempName = sc.nextLine();
                    productList.WriteFile(tempName);
                    System.out.println("Thanh cong");
                    productList.Print();
                    break;
                case 15:
                    System.out.println("Ten can thay the");
                    String ten = sc.nextLine();
                    System.out.println("Nhap vi tri can thay the");
                    int vt = sc.nextInt();
                    productList.setValue(vt,ten);
                    productList.Print();
                    break;
                case 16:
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
