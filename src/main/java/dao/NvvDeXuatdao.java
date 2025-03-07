package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.NvvDeXuat;

public class NvvDeXuatdao {
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
    
    public List<NvvDeXuat> getAll() {
        List<NvvDeXuat> list = new ArrayList<>();
        String sql = "SELECT * FROM NvvDeXuat";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                NvvDeXuat dx = new NvvDeXuat();
                dx.setMaDeXuat(rs.getInt("maDeXuat"));
                dx.setNoiDung(rs.getString("noiDung"));
                dx.setMaDeXuat(rs.getDate("ngayDeXuat"));
                list.add(dx);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}