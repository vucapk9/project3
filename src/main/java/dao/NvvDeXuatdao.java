package dao;

import model.NvvDeXuat;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NvvDeXuatdao {
    private Connection conn;

    public NvvDeXuatdao(Connection conn) {
        this.conn = conn;
    }

    public List<NvvDeXuat> getAllDeXuat() {
        List<NvvDeXuat> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM nvvdexuat";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new NvvDeXuat(
                    rs.getInt("MaDeXuat"),
                    rs.getString("TenThietBi"),
                    rs.getString("MoTa"),
                    rs.getString("TrangThai"),
                    rs.getDate("NgayGui")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean addDeXuat(NvvDeXuat deXuat) {
        try {
            String sql = "INSERT INTO nvvdexuat (TenThietBi, MoTa, TrangThai, NgayGui) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, deXuat.getTenThietBi());
            ps.setString(2, deXuat.getMoTa());
            ps.setString(3, deXuat.getTrangThai());
            ps.setDate(4, deXuat.getNgayGui());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
