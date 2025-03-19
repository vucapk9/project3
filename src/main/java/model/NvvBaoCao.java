package model;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class NvvBaoCao {
    private int maBaoCao;
    private Date ngayBaoCao;
    private int maThietBi;
    private String tinhTrangHienTai;
    private String ghiChu;

    public int getMaBaoCao() {
        return maBaoCao;
    }

    public void setMaBaoCao(int maBaoCao) {
        this.maBaoCao = maBaoCao;
    }

    public Date getNgayBaoCao() {
        return ngayBaoCao;
    }

    public void setNgayBaoCao(Date ngayBaoCao) {
        this.ngayBaoCao = ngayBaoCao;
    }

    public int getMaThietBi() {
        return maThietBi;
    }

    public void setMaThietBi(int maThietBi) {
        this.maThietBi = maThietBi;
    }

    public String getTinhTrangHienTai() {
        return tinhTrangHienTai;
    }

    public void setTinhTrangHienTai(String tinhTrangHienTai) {
        this.tinhTrangHienTai = tinhTrangHienTai;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

	public void setMaNguoiDung(int int1) {
		// TODO Auto-generated method stub
		
	}

	public void setNgayTao(Timestamp timestamp) {
		// TODO Auto-generated method stub
		
	}

	public void setNoiDung(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setTieuDe(String string) {
		// TODO Auto-generated method stub
		
	}

	public String getNoiDung() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getTieuDe() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getMaNguoiDung() {
		// TODO Auto-generated method stub
		return 0;
	}
}
