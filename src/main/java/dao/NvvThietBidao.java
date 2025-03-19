package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.NvvThietBi;

public class NvvThietBidao {
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

    // Lấy danh sách tất cả thiết bị
    public List<NvvThietBi> getAll() {
        List<NvvThietBi> list = new ArrayList<>();
        String sql = "SELECT * FROM NvvThietBi";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                NvvThietBi tb = new NvvThietBi(
                    rs.getInt("MaThietBi"),
                    rs.getString("TenThietBi"),
                    rs.getInt("MaDanhMuc"),
                    rs.getString("MoTa"),
                    rs.getString("TieuChuan"),
                    rs.getString("TinhTrang"),
                    rs.getInt("SoLuong"),
                    rs.getInt("MaNhaCungCap"),0
                );
                list.add(tb);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // Thêm thiết bị mới
    public boolean insert(NvvThietBi tb) {
        String sql = "INSERT INTO NvvThietBi (TenThietBi, MaDanhMuc, MoTa, TieuChuan, TinhTrang, SoLuong, MaNhaCungCap) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, tb.getTenThietBi());
            ps.setInt(2, tb.getMaDanhMuc());
            ps.setString(3, tb.getMoTa());
            ps.setString(4, tb.getTieuChuan());
            ps.setString(5, tb.getTinhTrang());
            ps.setInt(6, tb.getSoLuong());
            ps.setInt(7, tb.getMaNhaCungCap());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return false;
    }

    // Cập nhật thông tin thiết bị
    public boolean update(NvvThietBi tb) {
        String sql = "UPDATE NvvThietBi SET TenThietBi=?, MaDanhMuc=?, MoTa=?, TieuChuan=?, TinhTrang=?, SoLuong=?, MaNhaCungCap=? WHERE MaThietBi=?";
        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, tb.getTenThietBi());
            ps.setInt(2, tb.getMaDanhMuc());
            ps.setString(3, tb.getMoTa());
            ps.setString(4, tb.getTieuChuan());
            ps.setString(5, tb.getTinhTrang());
            ps.setInt(6, tb.getSoLuong());
            ps.setInt(7, tb.getMaNhaCungCap());
            ps.setInt(8, tb.getMaThietBi());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return false;
    }

    // Xóa thiết bị theo ID
    public boolean delete(int maThietBi) {
        String sql = "DELETE FROM NvvThietBi WHERE MaThietBi=?";
        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, maThietBi);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return false;
    }

    // Lấy thiết bị theo ID
    public NvvThietBi getById(int maThietBi) {
        String sql = "SELECT * FROM NvvThietBi WHERE MaThietBi=?";
        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, maThietBi);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new NvvThietBi(
                    rs.getInt("MaThietBi"),
                    rs.getString("TenThietBi"),
                    rs.getInt("MaDanhMuc"),
                    rs.getString("MoTa"),
                    rs.getString("TieuChuan"),
                    rs.getString("TinhTrang"),
                    rs.getInt("SoLuong"),
                    rs.getInt("MaNhaCungCap"),0
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
