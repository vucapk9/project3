package service;

import dao.NvvDeXuatdao;
import model.NvvDeXuat;
import java.util.List;

public class NvvDeXuatService {
    private NvvDeXuatdao deXuatDAO;

    public NvvDeXuatService(NvvDeXuatdao deXuatDAO) {
        this.deXuatDAO = deXuatDAO;
    }

    public List<NvvDeXuat> getAllDeXuat() {
        return deXuatDAO.getAllDeXuat();
    }

    public boolean addDeXuat(NvvDeXuat deXuat) {
        return deXuatDAO.addDeXuat(deXuat);
    }
}
