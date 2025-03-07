package dao;

import java.sql.*;
import java.util.*;
import model.*;

public class NvvDanhMucdao {
    private String url = "jdbc:mysql://localhost:3307/quanlytrangthietbimamnon_nvv2210900081"; 
    private String username = "root";
    private String password = ""; 

    public Connection connect() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("Không tìm thấy Driver MySQL", e);
        }
        return DriverManager.getConnection(url, username, password);
    }
    
    public List<NvvDanhMuc> getAll() {
        List<NvvDanhMuc> list = new ArrayList<>();
        String sql = "SELECT * FROM NvvDanhMuc";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                NvvDanhMuc dm = new NvvDanhMuc();
                dm.setMaDanhMuc(rs.getInt("maDanhMuc"));
                dm.setTenDanhMuc(rs.getString("tenDanhMuc"));
                list.add(dm);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public void insert(NvvDanhMuc dm) {
        String sql = "INSERT INTO NvvDanhMuc (tenDanhMuc) VALUES (?)";
        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, dm.getTenDanhMuc());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void update(NvvDanhMuc dm) {
        String sql = "UPDATE NvvDanhMuc SET tenDanhMuc=? WHERE maDanhMuc=?";
        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, dm.getTenDanhMuc());
            ps.setInt(2, dm.getMaDanhMuc());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void delete(int maDanhMuc) {
        String sql = "DELETE FROM NvvDanhMuc WHERE maDanhMuc=?";
        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, maDanhMuc);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}