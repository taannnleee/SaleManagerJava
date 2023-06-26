public class BillTrongKho
{
    public static DanhSachBill billList = Init();

    private static DanhSachBill Init()
    {
        DanhSachBill list_ = new DanhSachBill(100);
        list_.AddLast(new Bill("SP010", "May Say Toc", 15, new ThoiGian(1, 1, 2012, 20, 20, 30), new ThoiGian(9, 9, 2050, 15, 30, 0), 25000000));

        return list_;

    }
}
