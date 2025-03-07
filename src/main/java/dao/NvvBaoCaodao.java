package dao;

import java.sql.*;
import java.util.*;
import model.*;

public class NvvBaoCaodao {
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
    
    public List<NvvBaoCao> getAll() {
        List<NvvBaoCao> list = new ArrayList<>();
        String sql = "SELECT * FROM NvvBaoCao";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                NvvBaoCao bc = new NvvBaoCao();
                bc.setMaBaoCao(rs.getInt("maBaoCao"));
                bc.setTieuDe(rs.getString("tieuDe"));
                bc.setNoiDung(rs.getString("noiDung"));
                bc.setNgayBaoCao(rs.getDate("ngayBaoCao"));
                list.add(bc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public void insert(NvvBaoCao bc) {
        String sql = "INSERT INTO NvvBaoCao (tieuDe, noiDung, ngayBaoCao) VALUES (?, ?, ?)";
        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, bc.getTieuDe());
            ps.setString(2, bc.getNoiDung());
            ps.setDate(3, new java.sql.Date(bc.getNgayBaoCao().getTime()));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}