package dao;

import java.sql.*;
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

    // Lấy danh sách tất cả người dùng
    public List<NvvNguoiDung> getAll() {
        List<NvvNguoiDung> list = new ArrayList<>();
        String sql = "SELECT * FROM NvvNguoiDung";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                NvvNguoiDung user = new NvvNguoiDung(
                    rs.getInt("MaNguoiDung"),
                    rs.getString("TenDangNhap"),
                    rs.getString("MatKhau"),
                    rs.getString("HoTen"),
                    rs.getString("Email"),
                    rs.getString("SoDienThoai"),
                    rs.getString("VaiTro")
                );
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // Thêm người dùng mới
    public boolean insert(NvvNguoiDung user) {
        String sql = "INSERT INTO NvvNguoiDung (TenDangNhap, MatKhau, HoTen, Email, SoDienThoai, VaiTro) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, user.getTenDangNhap());
            ps.setString(2, user.getMatKhau());
            ps.setString(3, user.getHoTen());
            ps.setString(4, user.getEmail());
            ps.setString(5, user.getSoDienThoai());
            ps.setString(6, user.getVaiTro());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return false;
    }

    // Cập nhật thông tin người dùng
    public boolean update(NvvNguoiDung user) {
        String sql = "UPDATE NvvNguoiDung SET TenDangNhap=?, MatKhau=?, HoTen=?, Email=?, SoDienThoai=?, VaiTro=? WHERE MaNguoiDung=?";
        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, user.getTenDangNhap());
            ps.setString(2, user.getMatKhau());
            ps.setString(3, user.getHoTen());
            ps.setString(4, user.getEmail());
            ps.setString(5, user.getSoDienThoai());
            ps.setString(6, user.getVaiTro());
            ps.setInt(7, user.getMaNguoiDung());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return false;
    }

    // Xóa người dùng theo ID
    public boolean delete(int maNguoiDung) {
        String sql = "DELETE FROM NvvNguoiDung WHERE MaNguoiDung=?";
        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, maNguoiDung);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return false;
    }

    // Lấy người dùng theo ID
    public NvvNguoiDung getById(int maNguoiDung) {
        String sql = "SELECT * FROM NvvNguoiDung WHERE MaNguoiDung=?";
        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, maNguoiDung);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new NvvNguoiDung(
                    rs.getInt("MaNguoiDung"),
                    rs.getString("TenDangNhap"),
                    rs.getString("MatKhau"),
                    rs.getString("HoTen"),
                    rs.getString("Email"),
                    rs.getString("SoDienThoai"),
                    rs.getString("VaiTro")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}