public class NhanVienCuaHang {
    public static DanhSachBanHang staff = Init();
    private static DanhSachBanHang Init()
    {
        DanhSachBanHang list_ = new DanhSachBanHang(100);
        list_.AddLast(new BanHang("NV001","Trung","Nam", new ThoiGian(16,5,2003,1,1,1), "Binh Phuoc", "0869876430",15000000));
        list_.AddLast(new BanHang("NV002","Tan","Nam", new ThoiGian(15,7,2003,1,1,1), "Binh Phuoc", "0869876430",5000000));
        list_.AddLast(new BanHang("NV003","Thien","Nam", new ThoiGian(12,2,2003,1,1,1), "Binh Phuoc", "0869876430",5000000));
        list_.AddLast(new BanHang("NV004","Thanh","Nam", new ThoiGian(16,6,2003,1,1,1), "Binh Phuoc", "0869876430",2000000));
        return list_;
    }
}
