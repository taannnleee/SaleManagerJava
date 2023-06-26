interface IDanhSachSanPham
{
    public  SanPham FindByID(String id);
    public  void AddLastNoDuplicate(SanPham product);
    public  void WriteFile(String fileName);
    public  int CheckNumberProduct(SanPham temp);
    public  DanhSachSanPham MinimumNumberOfProducts();
    public  DanhSachSanPham MaximumNumberOfProducts();
    public  DanhSachSanPham ProductQuantityMoreThan100();
    public DanhSachSanPham FindExpiredProducts(ThoiGian today);
    public  void SortByNumberOfProduct();
    public  DanhSachSanPham FindByDate(ThoiGian dayStart, ThoiGian dayEnd);
}
