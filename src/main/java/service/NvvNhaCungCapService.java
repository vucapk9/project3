package service;

import java.util.List;

import dao.NvvNhaCungCapdao;
import model.NvvNhaCungCap;

public class NvvNhaCungCapService {
    private NvvNhaCungCapdao nhaCungCapDAO;

    public NvvNhaCungCapService() {
        nhaCungCapDAO = new NvvNhaCungCapdao();
    }

    public List<NvvNhaCungCap> getAll() {
        return nhaCungCapDAO.getAll();
    }

    public NvvNhaCungCap getById(int maNhaCungCap) {
        return nhaCungCapDAO.getById(maNhaCungCap);
    }

    public boolean insert(NvvNhaCungCap nhaCungCap) {
        return nhaCungCapDAO.insert(nhaCungCap);
    }

    public boolean update(NvvNhaCungCap nhaCungCap) {
        return nhaCungCapDAO.update(nhaCungCap);
    }

    public boolean delete(int maNhaCungCap) {
        return nhaCungCapDAO.delete(maNhaCungCap);
    }
}
