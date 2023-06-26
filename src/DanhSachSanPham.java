
import java.io.*;
public class DanhSachSanPham extends DanhSach<SanPham> implements IDanhSachSanPham
{

    public DanhSachSanPham(int iGioiHan)
    {
        super(iGioiHan);
    }

    @Override
    public void AddItem(int index, SanPham item)
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
    public SanPham Get(int index) {
        if (!IsValidIndex(index)) return null;
        else
            return (SanPham) list_[index];
    }

    @Override
    public void AddLast(SanPham item)
    {
        if (iSize >= iGioiHan) return;
        list_[iSize++] = item;
    }

    public void AddFirst(SanPham item)
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
    public void AddRange(DanhSach<SanPham> sourceList)
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
    public  void RemoveItem(int index)
    {
        for (int i = index; i < iSize; i++)
        {
            list_[i] = list_[i + 1];
        }
        iSize--;
    }

    public SanPham SearchItemByID(SanPham item)
    {
        SanPham temp = null;
        for (int i = 0; i < iSize; i++)
        {
            if (item.IsEqual((SanPham) list_[i]))
            {
                temp = (SanPham) list_[i];
                break;
            }
        }
        return temp;
    }

    public DanhSachSanPham SearchItemByName(String name)
    {
        DanhSachSanPham temp = new DanhSachSanPham(100);
        SanPham product = new SanPham();
        for (int i = 0; i < iSize; i++)
        {
            String list = ((SanPham)list_[i]).getsTensp();
            if (list.equals(name) || list.equalsIgnoreCase(name))
            {
                temp.AddLast((SanPham) list_[i]);
            }
        }
        if (temp.iSize == 0) return null;
        return temp;
    }

    public SanPham QuantityOfAProduct(String name)
    {
        int tam = 0;
        SanPham product = new SanPham();
        for (int i = 0; i < super.iSize; i++)
        {
            String list = ((SanPham)super.list_[i]).getsTensp();
            if(list.equals(name)||list.equalsIgnoreCase(name))
            {
                product = (SanPham) super.list_[i];
                tam++;
                break;
            }
        }
        if (tam == 0) return null;
        return product;
    }

    public boolean ItemAlreadyExists(SanPham item)
    {
        DanhSachSanPham temp = new DanhSachSanPham(100);
        for (int i = 0; i < iSize; i++)
        {
            if (item.IsEqualProduct((SanPham) list_[i]))
            {
                ((SanPham)list_[i]).setiSoluong(((SanPham)list_[i]).getiSoluong() + item.getiSoluong());
                return true;
            }
        }
        return false;
    }

    public DanhSachSanPham FindByDate(ThoiGian dayStart, ThoiGian dayEnd)
    {
        DanhSachSanPham temp = new DanhSachSanPham(100);
        for (int i = 0; i < super.iSize; i++)
        {
            if(ThoiGian.lonHonHoacBang(((SanPham)list_[i]).gettNgayhethan(),dayStart) && ThoiGian.NhoHonHoacBang(((SanPham)list_[i]).gettNgayhethan(),dayEnd))
            {
                temp.AddLast((SanPham) list_[i]);
            }
        }
        if (temp.iSize == 0) return null;
        return temp;
    }
    @Override
    public int IndexOf(SanPham item)
    {
        for (int i = 0; i < super.iSize; i++)
            if (item.IsEqual((SanPham) super.list_[i]))
                return i;
        return -1;
    }

    public void SortByNumberOfProduct()
    {
        for (int i = 1; i < super.iSize; i++)
        {
            SanPham t = (SanPham) list_[i];
            int j = i - 1;
            while (j >= 0 && t.getiSoluong() > ((SanPham)list_[j]).getiSoluong())
            {
                list_[j + 1] = list_[j];
                j--;
            }
            list_[j + 1] = t;
        }
    }

    public DanhSachSanPham FindExpiredProducts(ThoiGian today)
    {
        DanhSachSanPham temp = new DanhSachSanPham(100);
        for (int i = 0; i < super.iSize; i++)
            if (ThoiGian.lonHonHoacBang(today,((SanPham)list_[i]).gettNgayhethan()))
                temp.AddLast((SanPham) list_[i]);
        return temp;
    }

    public int TotalGoods()
    {
        int sum = 0;
        for (int i = 0; i < super.iSize; i++)
        {
            sum += ((SanPham)list_[i]).getiSoluong();
        }
        return sum;
    }

    public DanhSachSanPham ProductQuantityMoreThan100()
    {
        DanhSachSanPham temp = new DanhSachSanPham(100);
        for (int i = 0; i < super.iSize; i++)
        {
            if (((SanPham)super.list_[i]).getiSoluong() > 100)
            {
                temp.AddLast((SanPham) list_[i]);
            }
        }
        return temp;
    }

    public DanhSachSanPham MaximumNumberOfProducts()
    {
        DanhSachSanPham temp = new DanhSachSanPham(100);
        SanPham max = (SanPham) super.list_[0];
        for (int i = 1; i < super.iSize; i++)
        {
            if (((SanPham)super.list_[i]).getiSoluong() > max.getiSoluong())
            {
                max = (SanPham) super.list_[i];

            }
        }
        temp.AddLast(max);
        if (temp.getiSize() == 0) return null;
        return temp;
    }

    public DanhSachSanPham MinimumNumberOfProducts()
    {
        DanhSachSanPham temp = new DanhSachSanPham(100);
        SanPham min = (SanPham) super.list_[0];
        for (int i = 1; i < super.iSize; i++)
        {
            if (((SanPham)super.list_[i]).getiSoluong() < min.getiSoluong())
            {
                min = (SanPham) super.list_[i];

            }
        }
        temp.AddLast(min);
        if (temp.getiSize() == 0) return null;
        return temp;
    }

    public int CheckNumberProduct(SanPham temp)
    {
        int sum = 0;
        for (int i = 0; i < super.iSize; i++)
        {
            if (temp.IsEqual((SanPham) super.list_[i]))
            {
                sum = ((SanPham)list_[i]).getiSoluong();
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
        SanPham product;
        for (int i = 0; i < iSize; i++)
        {
            product = (SanPham) list_[i];
            pw.print(product.getiID()+";");
            pw.print(product.getsTensp()+";");
            pw.print(product.getiSoluong()+";");
            pw.print(product.gettNgaynhap().layThoiGian()+";");
            pw.print(product.gettNgayhethan().layThoiGian()+";");
            pw.println(product.getiGiatien()+".");
        }
        pw.close();
    }
    public void AddLastNoDuplicate(SanPham product)
    {
        if (FindByID(product.getiID()) != null)
        {
            System.out.println("Trung lap");
            return;
        }
        AddLast(product);
    }

    public SanPham FindByID(String id)
    {
        SanPham product = null;
        for (int i = 0; i < super.iSize; i++)
        {
            product = Get(i);
            if(id.equals(product.getiID()))
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
            System.out.printf("%-15s%-20s%-25s%-30s%-35s%6s\n",((SanPham)list_[i]).getiID(),((SanPham)list_[i]).getsTensp(),((SanPham)list_[i]).getiSoluong()
                    ,((SanPham)list_[i]).gettNgaynhap().layThoiGian(),((SanPham)list_[i]).gettNgayhethan().layThoiGian(),((SanPham)list_[i]).getiGiatien());
        }

    }
    @Override
    public SanPham SearchItem(SanPham item) {
        for(int i=0; i<super.iSize;i++)
        {
            if (item.IsEqual((SanPham) super.list_[i]))
                return (SanPham) super.list_[i];
        }
        return null;
    }

    public  SanPham getValue(int vt)
    {
        return (SanPham) list_[vt];
    }
    public void setValue(int vt, String value)
    {
        ((SanPham)list_[vt]).setsTensp(value);
    }


}