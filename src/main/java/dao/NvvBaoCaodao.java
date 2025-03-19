package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.NvvBaoCao;
import utils.DatabaseConnection;

public class NvvBaoCaodao {
    
    public List<NvvBaoCao> getAll() {
        List<NvvBaoCao> list = new ArrayList<>();
        String sql = "SELECT * FROM NvvBaoCao";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
             
            while (rs.next()) {
                NvvBaoCao bc = new NvvBaoCao();
                bc.setMaBaoCao(rs.getInt("MaBaoCao"));
                bc.setTieuDe(rs.getString("TieuDe"));
                bc.setNoiDung(rs.getString("NoiDung"));
                bc.setNgayTao(rs.getTimestamp("NgayTao"));
                bc.setMaNguoiDung(rs.getInt("MaNguoiDung"));
                list.add(bc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public NvvBaoCao getById(int id) {
        NvvBaoCao bc = null;
        String sql = "SELECT * FROM NvvBaoCao WHERE MaBaoCao = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
             
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                bc = new NvvBaoCao();
                bc.setMaBaoCao(rs.getInt("MaBaoCao"));
                bc.setTieuDe(rs.getString("TieuDe"));
                bc.setNoiDung(rs.getString("NoiDung"));
                bc.setNgayTao(rs.getTimestamp("NgayTao"));
                bc.setMaNguoiDung(rs.getInt("MaNguoiDung"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bc;
    }

    public void insert(NvvBaoCao baoCao) {
        String sql = "INSERT INTO NvvBaoCao (TieuDe, NoiDung, MaNguoiDung) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
             
            ps.setString(1, baoCao.getTieuDe());
            ps.setString(2, baoCao.getNoiDung());
            ps.setInt(3, baoCao.getMaNguoiDung());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(NvvBaoCao baoCao) {
        String sql = "UPDATE NvvBaoCao SET TieuDe = ?, NoiDung = ?, MaNguoiDung = ? WHERE MaBaoCao = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
             
            ps.setString(1, baoCao.getTieuDe());
            ps.setString(2, baoCao.getNoiDung());
            ps.setInt(3, baoCao.getMaNguoiDung());
            ps.setInt(4, baoCao.getMaBaoCao());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM NvvBaoCao WHERE MaBaoCao = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
             
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	public NvvBaoCao getBaoCaoById(int maBaoCao) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean insertBaoCao(NvvBaoCao baoCao) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updateBaoCao(NvvBaoCao baoCao) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteBaoCao(int maBaoCao) {
		// TODO Auto-generated method stub
		return false;
	}
}
