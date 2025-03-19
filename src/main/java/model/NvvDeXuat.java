package model;

import java.sql.Date;

public class NvvDeXuat {
    private int maDeXuat;
    private String tenThietBi;
    private String moTa;
    private String trangThai;
    private Date ngayGui;

    public NvvDeXuat() {}

    public NvvDeXuat(int maDeXuat, String tenThietBi, String moTa, String trangThai, Date ngayGui) {
        this.maDeXuat = maDeXuat;
        this.tenThietBi = tenThietBi;
        this.moTa = moTa;
        this.trangThai = trangThai;
        this.ngayGui = ngayGui;
    }

    public int getMaDeXuat() { return maDeXuat; }
    public void setMaDeXuat(int maDeXuat) { this.maDeXuat = maDeXuat; }

    public String getTenThietBi() { return tenThietBi; }
    public void setTenThietBi(String tenThietBi) { this.tenThietBi = tenThietBi; }

    public String getMoTa() { return moTa; }
    public void setMoTa(String moTa) { this.moTa = moTa; }

    public String getTrangThai() { return trangThai; }
    public void setTrangThai(String trangThai) { this.trangThai = trangThai; }

    public Date getNgayGui() { return ngayGui; }
    public void setNgayGui(Date ngayGui) { this.ngayGui = ngayGui; }
}
