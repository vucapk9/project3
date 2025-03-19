package dao;

import java.sql.*;
import java.util.*;
import model.NvvNhaCungCap;
import utils.DatabaseConnection;

public class NvvNhaCungCapdao {
    public List<NvvNhaCungCap> getAll() {
        List<NvvNhaCungCap> list = new ArrayList<>();
        String sql = "SELECT * FROM NvvNhaCungCap";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new NvvNhaCungCap(
                    rs.getInt("MaNhaCungCap"),
                    rs.getString("TenNhaCungCap"),
                    rs.getString("DiaChi"),
                    rs.getString("SoDienThoai"),
                    rs.getString("Email")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean insert(NvvNhaCungCap ncc) {
        String sql = "INSERT INTO NvvNhaCungCap (TenNhaCungCap, DiaChi, SoDienThoai, Email) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, ncc.getTenNhaCungCap());
            ps.setString(2, ncc.getDiaChi());
            ps.setString(3, ncc.getSoDienThoai());
            ps.setString(4, ncc.getEmail());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return false;
    }

	public NvvNhaCungCap getById(int maNhaCungCap) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean update(NvvNhaCungCap nhaCungCap) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(int maNhaCungCap) {
		// TODO Auto-generated method stub
		return false;
	}
}
