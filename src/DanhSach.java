import java.lang.reflect.Array;
import java.util.ArrayList;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.lang.reflect.Array;
public abstract class DanhSach<E> {


    protected Object[] list_;
    protected  int iSize;
    protected  int iGioiHan;

    // Constructor
    public DanhSach(int iGioiHan)
    {
        list_= new Object[iGioiHan];
        this.iSize = 0;
        this.iGioiHan = iGioiHan;
    }

    public E[] getList_() {
        return (E[]) list_;
    }

    public void setList_(E[] list_) {
        this.list_ = list_;
    }

    public int getiSize() {
        return iSize;
    }

    public void setiSize(int iSize) {
        this.iSize = iSize;
    }

    public int getiGioiHan() {
        return iGioiHan;
    }

    public void setiGioiHan(int iGioiHan) {
        this.iGioiHan = iGioiHan;
    }

    public boolean IsEmpty()
    {
        return iSize == 0;
    }


    public boolean isFull()
    {
        return this.iSize >= iGioiHan;
    }
    protected boolean IsValidIndex(int index)
    {
        return index >= 0 && index < this.iSize;
    }
    public abstract void AddItem(int index, E item);
    public abstract E Get(int index);
    public abstract void AddLast(E item);
    public abstract void AddRange(DanhSach<E> sourceList);
    public abstract void RemoveItem(int index);
    public abstract void Print();
    public abstract E SearchItem(E item);
    public abstract int IndexOf(E item);
}
