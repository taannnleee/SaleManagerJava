import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public  class DanhSachBanHang extends DanhSach<BanHang>{
    public DanhSachBanHang(int iGioiHan)
    {
        super(iGioiHan);
    }
    // Them nhan vien vao vi tri bat ky
    @Override
    public void AddItem(int index, BanHang item)
    {
        if (super.getiSize() >= getiGioiHan()) return;
        for (int i = super.getiSize(); i > index; i--)
        {
            super.list_[i] = super.list_[i - 1];
        }
        super.list_[index] = item;
    }
    // Them nhan vien vao vi tri sau cung
    @Override
    public void AddLast(BanHang item)
    {
        if (super.iSize >= iGioiHan) return;
        super.list_[super.iSize++] = item;
    }
    // Them mot danh sach nhan vien vao cuoi
    @Override
    public void AddRange(DanhSach<BanHang> sourceList)
    {
        for (int i = 0; i < sourceList.getiSize(); i++)
            AddLast(sourceList.Get(i));
    }
    // Xuat ra nhan vien voi chi so index
    @Override
    public BanHang Get(int index)
    {
        if (!IsValidIndex(index))
            return null;
        else return (BanHang) super.list_[index];
    }
    // Tim chi so cua nhan vien bang id
    @Override
    public int IndexOf(BanHang item)
    {
        for (int i = 0; i < super.getiSize(); i++)
            if (item.IsEquals((BanHang)super.list_[i]))
                return i;
        return -1;
    }
    //Nhap thong tin mot danh sach nhan vien voi so luong nhap tu ban phim
    public void Input()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so luong nhan vien: ");
        int tmp = sc.nextInt();
        for (int i = 0; i < tmp; i++)
        {
            this.Input();
        }
    }
    @Override
    public  void Print() {
        System.out.printf("%-15s%-20s%-25s%-30s%-35s%6s\n", "ID", "Ten", "Gioi tinh", "Ngay sinh","Dia chi", "Luong");
        for (int i = 0; i < super.getiSize(); i++) {
            System.out.printf("%-15s%-20s%-25s%-30s%-35s%6s\n", ((BanHang)list_[i]).getsID(), ((BanHang)list_[i]).getsTen(), ((BanHang)list_[i]).getsGioiTinh()
                    , ((BanHang)list_[i]).getdNgaySinh().layThoiGian(),((BanHang)list_[i]).getsDiaChi(), ((BanHang)list_[i]).getiLuong());
        }
    }
    // Xoa nhan vien o chi so index
    @Override
    public void RemoveItem(int index)
    {
        for (int i = index; i < super.getiSize(); i++)
            super.list_[i] = super.list_[i + 1];
        super.iSize--;
    }
    // Tim xem nhan vien mang Id/ ten co trong danh sach
    @Override
    public BanHang SearchItem(BanHang item)
    {
        for (int i = 0; i < super.getiSize(); i++)
            if (item.equals(super.list_[i]))
                return (BanHang) super.list_[i];
        return null;
    }
    public BanHang SearchItemByID(BanHang item)
    {
        BanHang temp = null;
        for (int i = 0; i < iSize; i++)
            if (item.IsEquals((BanHang)list_[i]))
            {
                temp = (BanHang) list_[i];
                break;
            }
        return temp;
    }
    public DanhSachBanHang SearchSaleByName(String name)
    {
        DanhSachBanHang tempList = new DanhSachBanHang(100);
        BanHang banHang = new BanHang();
        for (int i = 0; i < iSize; i++)
        {
            String list = ((BanHang)list_[i]).sTen;
            if (list == name)
                tempList.AddLast((BanHang) list_[i]);
        }
        if (tempList.iSize == 0) return null;
        else
        {
            return tempList;
        }
    }
    public void SortBySalary()
    {
        for (int i = 1; i < iSize; i++)
        {
            BanHang t = (BanHang) list_[i];
            int j = i - 1;
            while (j >= 0 && t.getiLuong() > ((BanHang)list_[j]).getiLuong())
            {
                list_[j + 1] = list_[j];
                j--;
            }
            list_[j + 1] = t;
        }
    }
    public int TotalSales()
    {
        int sum = 0;
        for (int i = 0; i < getiSize(); i++)
        {
            sum ++;
        }
        return sum;
    }
    public DanhSachBanHang MaximumNumberOfSalary()
    {
        DanhSachBanHang temp = new DanhSachBanHang(100);
        BanHang max = (BanHang) list_[0];
        for (int i = 1; i < iSize; i++)
        {
            if (((BanHang)list_[i]).getiLuong() > max.getiLuong())
            {
                max = (BanHang) list_[i];
            }
        }
        temp.AddLast(max);
        if (temp.iSize == 0) return null;
        return temp;
    }
    public DanhSachBanHang MinimumNumberOfSalary()
    {
        DanhSachBanHang temp = new DanhSachBanHang(100);
        BanHang min = (BanHang) list_[0];
        for (int i = 1; i < iSize; i++)
        {
            if (((BanHang)list_[i]).getiLuong() < min.getiLuong())
            {
                min = (BanHang) list_[i];
            }
        }
        temp.AddLast(min);
        if (temp.iSize == 0) return null;
        return temp;
    }
    public DanhSachBanHang SalaryMoreThan(int luong)
    {
        DanhSachBanHang temp = new DanhSachBanHang(100);
        for (int i = 1; i < iSize; i++)
            if (((BanHang)list_[i]).getiLuong() > luong)
                temp.AddLast((BanHang) list_[i]);
        if (temp.iSize == 0) return null;
        return temp;
    }
    public void WriteFile(String fileName)
    {
        File file = new File(fileName);
        FileWriter fw = null;
        try {
            fw = new FileWriter(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        PrintWriter pw = new PrintWriter(fw);
        BanHang banHang;
        for (int i = 0; i < iSize; i++)
        {
            banHang = (BanHang) list_[i];
            pw.print(banHang.getsID() +";");
            pw.print(banHang.getsTen()+";");
            pw.print(banHang.getsGioiTinh()+";");
            pw.print(banHang.getdNgaySinh().layThoiGian()+";");
            pw.print(banHang.getsDiaChi()+";");
            pw.println(banHang.getiLuong()+".");
        }
        pw.close();
    }

}

