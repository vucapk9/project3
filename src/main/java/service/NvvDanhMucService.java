package service;

import java.util.List;
import dao.NvvDanhMucdao;
import model.NvvDanhMuc;

public class NvvDanhMucService {
    private NvvDanhMucdao danhMucDAO;

    public NvvDanhMucService() {
        danhMucDAO = new NvvDanhMucdao();
    }

    public List<NvvDanhMuc> getAll() {
        return danhMucDAO.getAll();
    }

    public NvvDanhMuc getById(int maDanhMuc) {
        return danhMucDAO.getById(maDanhMuc);
    }

    public boolean insert(NvvDanhMuc danhMuc) {
        return danhMucDAO.insert(danhMuc);
    }

    public boolean update(NvvDanhMuc danhMuc) {
        return danhMucDAO.update(danhMuc);
    }

    public boolean delete(int maDanhMuc) {
        return danhMucDAO.delete(maDanhMuc);
    }

	
}
