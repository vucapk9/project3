package service;

import model.NvvLienHe;
import utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class NvvLienHeService {
    public void themLienHe(NvvLienHe lienHe) {
        String sql = "INSERT INTO NvvLienHe (ho_ten, email, so_dien_thoai, noi_dung) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, lienHe.getHoTen());
            stmt.setString(2, lienHe.getEmail());
            stmt.setString(3, lienHe.getSoDienThoai());
            stmt.setString(4, lienHe.getNoiDung());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
