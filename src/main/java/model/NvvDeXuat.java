package model;

import java.util.Date;

public class NvvDeXuat {
    private int maDeXuat;
    private String tenThietBi;
    private String moTa;
    private String trangThai;
    private Date ngayGui;

    public int getMaDeXuat() {
        return maDeXuat;
    }

    public void setMaDeXuat(int maDeXuat) {
        this.maDeXuat = maDeXuat;
    }

    public String getTenThietBi() {
        return tenThietBi;
    }

    public void setTenThietBi(String tenThietBi) {
        this.tenThietBi = tenThietBi;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public Date getNgayGui() {
        return ngayGui;
    }

    public void setNgayGui(Date ngayGui) {
        this.ngayGui = ngayGui;
    }

	public void setNoiDung(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setMaDeXuat(java.sql.Date date) {
		// TODO Auto-generated method stub
		
	}
}
