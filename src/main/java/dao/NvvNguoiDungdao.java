package dao;

import model.NvvNguoiDung;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NvvNguoiDungdao {
    private Connection conn;

    public NvvNguoiDungdao(Connection conn) {
        this.conn = conn;
    }

    // Lấy danh sách tất cả người dùng
    public List<NvvNguoiDung> getAllNguoiDung() {
        List<NvvNguoiDung> list = new ArrayList<>();
        String sql = "SELECT * FROM nvvnguoidung";

        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                NvvNguoiDung user = new NvvNguoiDung(
                    rs.getInt("MaNguoiDung"),
                    rs.getString("TenDangNhap"),
                    rs.getString("MatKhau"),
                    rs.getString("HoTen"),
                    rs.getString("VaiTro")
                );
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // Lấy người dùng theo ID
    public NvvNguoiDung getNguoiDungById(int id) {
        String sql = "SELECT * FROM nvvnguoidung WHERE MaNguoiDung = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new NvvNguoiDung(
                    rs.getInt("MaNguoiDung"),
                    rs.getString("TenDangNhap"),
                    rs.getString("MatKhau"),
                    rs.getString("HoTen"),
                    rs.getString("VaiTro")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Thêm người dùng
    public boolean addNguoiDung(NvvNguoiDung user) {
        String sql = "INSERT INTO nvvnguoidung (TenDangNhap, MatKhau, HoTen, VaiTro) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user.getTenDangNhap());
            stmt.setString(2, user.getMatKhau());
            stmt.setString(3, user.getHoTen());
            stmt.setString(4, user.getVaiTro());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Cập nhật người dùng
    public boolean updateNguoiDung(NvvNguoiDung user) {
        String sql = "UPDATE nvvnguoidung SET TenDangNhap=?, MatKhau=?, HoTen=?, VaiTro=? WHERE MaNguoiDung=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user.getTenDangNhap());
            stmt.setString(2, user.getMatKhau());
            stmt.setString(3, user.getHoTen());
            stmt.setString(4, user.getVaiTro());
            stmt.setInt(5, user.getMaNguoiDung());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Xóa người dùng
    public boolean deleteNguoiDung(int id) {
        String sql = "DELETE FROM nvvnguoidung WHERE MaNguoiDung=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
