package service;

import java.util.List;
import dao.NvvThietBidao;
import model.NvvThietBi;

public class NvvThietBiService {
    private NvvThietBidao thietBiDAO;

    public NvvThietBiService() {
        thietBiDAO = new NvvThietBidao();
    }

    public List<NvvThietBi> getAll() {
        return thietBiDAO.getAll();
    }

    public NvvThietBi getById(int maThietBi) {
        return thietBiDAO.getById(maThietBi);
    }

    public boolean insert(NvvThietBi thietBi) {
        return thietBiDAO.insert(thietBi);
    }

    public boolean update(NvvThietBi thietBi) {
        return thietBiDAO.update(thietBi);
    }

    public boolean delete(int maThietBi) {
        return thietBiDAO.delete(maThietBi);
    }
}
