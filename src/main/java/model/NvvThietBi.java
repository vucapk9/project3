package model;

public class NvvThietBi {
    private int maThietBi;
    private String tenThietBi;
    private int maDanhMuc;
    private String moTa;
    private String tieuChuan;
    private String tinhTrang;
    private int soLuong;
    private int maNhaCungCap;
    private double gia;

    public NvvThietBi() {}

    public NvvThietBi(int maThietBi, String tenThietBi, int maDanhMuc, String moTa, String tieuChuan, String tinhTrang, int soLuong, int maNhaCungCap, double gia) {
        this.maThietBi = maThietBi;
        this.tenThietBi = tenThietBi;
        this.maDanhMuc = maDanhMuc;
        this.moTa = moTa;
        this.tieuChuan = tieuChuan;
        this.tinhTrang = tinhTrang;
        this.soLuong = soLuong;
        this.maNhaCungCap = maNhaCungCap;
        this.gia = gia;
    }

    public int getMaThietBi() { return maThietBi; }
    public void setMaThietBi(int maThietBi) { this.maThietBi = maThietBi; }

    public String getTenThietBi() { return tenThietBi; }
    public void setTenThietBi(String tenThietBi) { this.tenThietBi = tenThietBi; }

    public int getMaDanhMuc() { return maDanhMuc; }
    public void setMaDanhMuc(int maDanhMuc) { this.maDanhMuc = maDanhMuc; }

    public String getMoTa() { return moTa; }
    public void setMoTa(String moTa) { this.moTa = moTa; }

    public String getTieuChuan() { return tieuChuan; }
    public void setTieuChuan(String tieuChuan) { this.tieuChuan = tieuChuan; }

    public String getTinhTrang() { return tinhTrang; }
    public void setTinhTrang(String tinhTrang) { this.tinhTrang = tinhTrang; }

    public int getSoLuong() { return soLuong; }
    public void setSoLuong(int soLuong) { this.soLuong = soLuong; }

    public int getMaNhaCungCap() { return maNhaCungCap; }
    public void setMaNhaCungCap(int maNhaCungCap) { this.maNhaCungCap = maNhaCungCap; }

    public double getGia() { return gia; }
    public void setGia(double gia) { this.gia = gia; }
}
