package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    
    public List<NvvThietBi> getAll() {
        List<NvvThietBi> list = new ArrayList<>();
        String sql = "SELECT * FROM NvvThietBi";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                NvvThietBi tb = new NvvThietBi();
                tb.setMaThietBi(rs.getInt("maThietBi"));
                tb.setTenThietBi(rs.getString("tenThietBi"));
                tb.setMaDanhMuc(rs.getInt("maDanhMuc"));
                tb.setMoTa(rs.getString("moTa"));
                tb.setTieuChuan(rs.getString("tieuChuan"));
                tb.setTinhTrang(rs.getString("tinhTrang"));
                tb.setSoLuong(rs.getInt("soLuong"));
                tb.setMaNhaCungCap(rs.getInt("maNhaCungCap"));
                list.add(tb);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public void insert(NvvThietBi tb) {
        String sql = "INSERT INTO NvvThietBi (tenThietBi, maDanhMuc, moTa, tieuChuan, tinhTrang, soLuong, maNhaCungCap) VALUES (?, ?, ?, ?, ?, ?, ?)";
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
    }
    
    public void update(NvvThietBi tb) {
        String sql = "UPDATE NvvThietBi SET tenThietBi=?, maDanhMuc=?, moTa=?, tieuChuan=?, tinhTrang=?, soLuong=?, maNhaCungCap=? WHERE maThietBi=?";
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
    }
    
    public void delete(int maThietBi) {
        String sql = "DELETE FROM NvvThietBi WHERE maThietBi=?";
        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, maThietBi);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}