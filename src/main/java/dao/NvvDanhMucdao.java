package dao;

import java.sql.*;
import java.util.*;
import model.NvvDanhMuc;
import utils.DatabaseConnection;

public class NvvDanhMucdao {
    public List<NvvDanhMuc> getAll() {
        List<NvvDanhMuc> list = new ArrayList<>();
        String sql = "SELECT * FROM NvvDanhMuc";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new NvvDanhMuc(rs.getInt("MaDanhMuc"), rs.getString("TenDanhMuc"), sql));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean insert(NvvDanhMuc dm) {
        String sql = "INSERT INTO NvvDanhMuc (TenDanhMuc) VALUES (?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, dm.getTenDanhMuc());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return false;
    }

	public NvvDanhMuc getById(int maDanhMuc) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean update(NvvDanhMuc danhMuc) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(int maDanhMuc) {
		// TODO Auto-generated method stub
		return false;
	}
}
