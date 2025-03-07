package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.NvvNguoiDung;

public class NvvNguoiDungdao {
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
 // Đăng ký người dùng
    public boolean insertUser(NvvNguoiDung user) {
        String sql = "INSERT INTO NvvNguoiDung (tenDangNhap, matKhau, vaiTro) VALUES (?, ?, ?)";
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user.getTenDangNhap());
            stmt.setString(2, user.getMatKhau());
            stmt.setString(3, user.getVaiTro());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Đăng nhập người dùng
    public NvvNguoiDung loginUser(String tenDangNhap, String matKhau) {
        String sql = "SELECT * FROM NvvNguoiDung WHERE tenDangNhap = ? AND matKhau = ?";
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, tenDangNhap);
            stmt.setString(2, matKhau);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    NvvNguoiDung user = new NvvNguoiDung();
                    user.setMaNguoiDung(rs.getInt("maNguoiDung"));
                    user.setTenDangNhap(rs.getString("tenDangNhap"));
                    user.setVaiTro(rs.getString("vaiTro"));
                    return user;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public List<NvvNguoiDung> getAll() {
        List<NvvNguoiDung> list = new ArrayList<>();
        String sql = "SELECT * FROM NvvNguoiDung";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                NvvNguoiDung nd = new NvvNguoiDung();
                nd.setMaNguoiDung(rs.getInt("maNguoiDung"));
                nd.setTenDangNhap(rs.getString("tenDangNhap"));
                nd.setMatKhau(rs.getString("matKhau"));
                nd.setVaiTro(rs.getString("vaiTro"));
                list.add(nd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}