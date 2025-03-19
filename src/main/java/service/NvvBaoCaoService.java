package service;

import dao.NvvBaoCaodao;
import model.NvvBaoCao;
import java.util.List;

public class NvvBaoCaoService {
    private NvvBaoCaodao baoCaoDAO;

    public NvvBaoCaoService() {
        this.baoCaoDAO = new NvvBaoCaodao();
    }

    public List<NvvBaoCao> getAllBaoCao() {
        return baoCaoDAO.getAll();
    }

    public NvvBaoCao getBaoCaoById(int maBaoCao) {
        return baoCaoDAO.getBaoCaoById(maBaoCao);
    }

    public boolean insertBaoCao(NvvBaoCao baoCao) {
        if (baoCao.getTieuDe().isEmpty() || baoCao.getNoiDung().isEmpty()) {
            return false; // Kiểm tra dữ liệu trước khi thêm
        }
        return baoCaoDAO.insertBaoCao(baoCao);
    }

    public boolean updateBaoCao(NvvBaoCao baoCao) {
        if (baoCao.getTieuDe().isEmpty() || baoCao.getNoiDung().isEmpty()) {
            return false; // Kiểm tra dữ liệu trước khi cập nhật
        }
        return baoCaoDAO.updateBaoCao(baoCao);
    }

    public boolean deleteBaoCao(int maBaoCao) {
        return baoCaoDAO.deleteBaoCao(maBaoCao);
    }
}
