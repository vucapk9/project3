package service;

import java.util.List;

import dao.NvvNguoiDungdao;
import model.NvvNguoiDung;

public class NvvNguoiDungService {
    private NvvNguoiDungdao nguoiDungDAO;

    public NvvNguoiDungService() {
        nguoiDungDAO = new NvvNguoiDungdao();
    }

    public List<NvvNguoiDung> getAll() {
        return nguoiDungDAO.getAll();
    }

    public NvvNguoiDung getById(int maNguoiDung) {
        return nguoiDungDAO.getById(maNguoiDung);
    }

    public boolean insert(NvvNguoiDung nguoiDung) {
        return nguoiDungDAO.insert(nguoiDung);
    }

    public boolean update(NvvNguoiDung nguoiDung) {
        return nguoiDungDAO.update(nguoiDung);
    }

    public boolean delete(int maNguoiDung) {
        return nguoiDungDAO.delete(maNguoiDung);
    }

	public List<NvvNguoiDung> getAllNguoiDung() {
		// TODO Auto-generated method stub
		return null;
	}

	public NvvNguoiDung getNguoiDungById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void insertNguoiDung(NvvNguoiDung nguoiDung) {
		// TODO Auto-generated method stub
		
	}

	public void deleteNguoiDung(int id) {
		// TODO Auto-generated method stub
		
	}

	public void updateNguoiDung(NvvNguoiDung nguoiDung) {
		// TODO Auto-generated method stub
		
	}
}
