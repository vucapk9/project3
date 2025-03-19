package service;

import dao.NvvNguoiDungdao;
import model.NvvNguoiDung;
import java.util.List;

public class NvvNguoiDungService {
    private NvvNguoiDungdao nguoiDungDAO;

    public NvvNguoiDungService(NvvNguoiDungdao nguoiDungDAO) {
        this.nguoiDungDAO = nguoiDungDAO;
    }

    public List<NvvNguoiDung> getAllNguoiDung() {
        return nguoiDungDAO.getAllNguoiDung();
    }

    public NvvNguoiDung getNguoiDungById(int id) {
        return nguoiDungDAO.getNguoiDungById(id);
    }

    public boolean addNguoiDung(NvvNguoiDung nguoiDung) {
        return nguoiDungDAO.addNguoiDung(nguoiDung);
    }

    public boolean updateNguoiDung(NvvNguoiDung nguoiDung) {
        return nguoiDungDAO.updateNguoiDung(nguoiDung);
    }

    public boolean deleteNguoiDung(int id) {
        return nguoiDungDAO.deleteNguoiDung(id);
    }
}
