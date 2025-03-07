package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import controller.NvvNhaCungCap;

public class NvvNhaCungCapdao {
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
    public void insert(NvvNhaCungCap ncc) {
        String sql = "INSERT INTO NvvNhaCungCap (tenNhaCungCap, diaChi, soDienThoai, email) VALUES (?, ?, ?, ?)";
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, ncc.getTenNhaCungCap());
            stmt.setString(2, ncc.getDiaChi());
            stmt.setString(3, ncc.getSoDienThoai());
            stmt.setString(4, ncc.getEmail());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    public List<NvvNhaCungCap> getAll() {
        List<NvvNhaCungCap> list = new ArrayList<>();
        String sql = "SELECT * FROM NvvNhaCungCap";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                NvvNhaCungCap ncc = new NvvNhaCungCap();
                ncc.setMaNhaCungCap(rs.getInt("maNhaCungCap"));
                ncc.setTenNhaCungCap(rs.getString("tenNhaCungCap"));
                ncc.setDiaChi(rs.getString("diaChi"));
                ncc.setSoDienThoai(rs.getString("soDienThoai"));
                list.add(ncc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
