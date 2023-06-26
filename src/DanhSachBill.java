import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class DanhSachBill extends DanhSach<Bill>{
    public DanhSachBill(int iGioiHan)
    {
        super(iGioiHan);
    }

    @Override
    public void AddItem(int index, Bill item)
    {
        if (super.iSize >= iGioiHan) return;
        for (int i = super.iSize; i > index; i--)
        {
            super.list_[i] = super.list_[i - 1];
        }
        iSize++;
        super.list_[index] = item;
    }

    @Override
    public void AddLast(Bill item)
    {
        if (iSize >= iGioiHan) return;
        list_[iSize++] = item;
    }

    public void AddFirst(Bill item)
    {
        if (iSize >= iGioiHan) return;
        iSize++;
        for (int i = iSize; i > 1; i--)
        {
            list_[i] = list_[i - 1];
        }
        list_[1] = item;
    }

    @Override
    public void AddRange(DanhSach<Bill> sourceList)
    {
        for (int i = 0; i < sourceList.iSize; i++)
        {
            if (iSize >= iGioiHan)
                return;
            else
                list_[iSize++] = sourceList.Get(i);
        }
    }
    @Override
    public Bill Get(int index) {
        if (!IsValidIndex(index)) return null;
        else
            return (Bill) list_[index];
    }

    @Override
    public  void RemoveItem(int index)
    {
        for (int i = index; i < iSize; i++)
        {
            list_[i] = list_[i + 1];
        }
        iSize--;
    }

    public Bill SearchItemByID(Bill item)
    {
        Bill temp = null;
        for (int i = 0; i < iSize; i++)
        {
            if (item.IsEqual((Bill) list_[i]))
            {
                temp = (Bill) list_[i];
                break;
            }
        }
        return temp;
    }

    public DanhSachBill SearchItemByName(String name)
    {
        DanhSachBill temp = new DanhSachBill(100);
        Bill product = new Bill();
        for (int i = 0; i < iSize; i++)
        {
            String list = ((Bill)list_[i]).getnTensp();
            if (list.equals(name) || list.equalsIgnoreCase(name))
            {
                temp.AddLast((Bill) list_[i]);
            }
        }
        if (temp.iSize == 0) return null;
        return temp;
    }

    public Bill QuantityOfAProduct(String name)
    {
        int tam = 0;
        Bill product = new Bill();
        for (int i = 0; i < super.iSize; i++)
        {
            String list = ((Bill)super.list_[i]).getnTensp();
            if(list.equals(name)||list.equalsIgnoreCase(name))
            {
                product = (Bill) super.list_[i];
                tam++;
                break;
            }
        }
        if (tam == 0) return null;
        return product;
    }

    public boolean ItemAlreadyExists(Bill item)
    {
        DanhSachBill temp = new DanhSachBill(100);
        for (int i = 0; i < iSize; i++)
        {
            if (item.IsEqual((Bill) list_[i]))
            {
                ((Bill)list_[i]).setiSoluong(((Bill)list_[i]).getiSoluong() + item.getiSoluong());
                return true;
            }
        }
        return false;
    }

    public DanhSachBill FindByDate(ThoiGian dayStart, ThoiGian dayEnd)
    {
        DanhSachBill temp = new DanhSachBill(100);
        for (int i = 0; i < super.iSize; i++)
        {
            if(ThoiGian.lonHonHoacBang(((Bill)list_[i]).gettNgayhethan(),dayStart) && ThoiGian.NhoHonHoacBang(((Bill)list_[i]).gettNgayhethan(),dayEnd))
            {
                temp.AddLast((Bill) list_[i]);
            }
        }
        if (temp.iSize == 0) return null;
        return temp;
    }
    @Override
    public int IndexOf(Bill item)
    {
        for (int i = 0; i < super.iSize; i++)
            if (item.IsEqual((Bill) super.list_[i]))
                return i;
        return -1;
    }

    public void SortByNumberOfProduct()
    {
        for (int i = 1; i < super.iSize; i++)
        {
            Bill t = (Bill) list_[i];
            int j = i - 1;
            while (j >= 0 && t.getiSoluong() > ((Bill)list_[j]).getiSoluong())
            {
                list_[j + 1] = list_[j];
                j--;
            }
            list_[j + 1] = t;
        }
    }

    public DanhSachBill FindExpiredProducts(ThoiGian today)
    {
        DanhSachBill temp = new DanhSachBill(100);
        for (int i = 0; i < super.iSize; i++)
            if (ThoiGian.lonHonHoacBang(today,((Bill)list_[i]).gettNgayhethan()))
                temp.AddLast((Bill) list_[i]);
        return temp;
    }

    public int TotalGoods()
    {
        int sum = 0;
        for (int i = 0; i < super.iSize; i++)
        {
            sum += ((Bill)list_[i]).getiSoluong();
        }
        return sum;
    }

    public DanhSachBill ProductQuantityMoreThan100()
    {
        DanhSachBill temp = new DanhSachBill(100);
        for (int i = 0; i < super.iSize; i++)
        {
            if (((Bill)super.list_[i]).getiSoluong() > 100)
            {
                temp.AddLast((Bill) list_[i]);
            }
        }
        return temp;
    }

    public DanhSachBill MaximumNumberOfProducts()
    {
        DanhSachBill temp = new DanhSachBill(100);
        Bill max = (Bill) super.list_[0];
        for (int i = 1; i < super.iSize; i++)
        {
            if (((Bill)super.list_[i]).getiSoluong() > max.getiSoluong())
            {
                max = (Bill) super.list_[i];

            }
        }
        temp.AddLast(max);
        if (temp.getiSize() == 0) return null;
        return temp;
    }

    public DanhSachBill MinimumNumberOfProducts()
    {
        DanhSachBill temp = new DanhSachBill(100);
        Bill min = (Bill) super.list_[0];
        for (int i = 1; i < super.iSize; i++)
        {
            if (((Bill)super.list_[i]).getiSoluong() < min.getiSoluong())
            {
                min = (Bill) super.list_[i];

            }
        }
        temp.AddLast(min);
        if (temp.getiSize() == 0) return null;
        return temp;
    }

    public int CheckNumberProduct(Bill temp)
    {
        int sum = 0;
        for (int i = 0; i < super.iSize; i++)
        {
            if (temp.IsEqual((Bill) super.list_[i]))
            {
                sum = ((Bill)list_[i]).getiSoluong();
                break;
            }
        }
        return sum;
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
        Bill product;
        for (int i = 0; i < iSize; i++)
        {
            product = (Bill) list_[i];
            pw.print(product.getnID()+";");
            pw.print(product.getnTensp()+";");
            pw.print(product.getiSoluong()+";");
            pw.print(product.gettNgaynhap().layThoiGian()+";");
            pw.print(product.gettNgayhethan().layThoiGian()+";");
            pw.println(product.getiGiatien()+".");
        }
        pw.close();
    }
    public void AddLastNoDuplicate(Bill product)
    {
        if (FindByID(product.getnID()) != null)
        {
            System.out.println("Trung lap");
            return;
        }
        AddLast(product);
    }

    public Bill FindByID(String id)
    {
        Bill product = null;
        for (int i = 0; i < super.iSize; i++)
        {
            product = Get(i);
            if(id.equals(product.getnID()))
                return product;
        }
        return null;
    }

    @Override
    public  void Print()
    {
        System.out.printf("%-15s%-20s%-25s%-30s%-35s%6s\n", "ID","Name","NumberOfProduct","DayStartedUsing","DateExpires","Price");
        for (int i = 0; i < super.getiSize(); i++)
        {
            System.out.printf("%-15s%-20s%-25s%-30s%-35s%6s\n",((Bill)list_[i]).getnID(),((Bill)list_[i]).getnTensp(),((Bill)list_[i]).getiSoluong()
                    ,((Bill)list_[i]).gettNgaynhap().layThoiGian(),((Bill)list_[i]).gettNgayhethan().layThoiGian(),((Bill)list_[i]).getiGiatien());
        }

    }
    @Override
    public Bill SearchItem(Bill item) {
        for(int i=0; i<super.iSize;i++)
        {
            if (item.IsEqual((Bill) super.list_[i]))
                return (Bill) super.list_[i];
        }
        return null;
    }

    public void UpdateItem(Bill tempBill)
    {

        int quantity = tempBill.getiSoluong();
        DanhSachSanPham productList = SanPhamTrongKho.productList;

        SanPham tempSP = productList.FindByID(tempBill.getnID());

        if (tempSP != null)
        {
            tempSP.setiSoluong(tempSP.getiSoluong()-quantity);
        }

    }

}
