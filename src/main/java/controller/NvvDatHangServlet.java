package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/NvvDatHangServlet")
public class NvvDatHangServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idSanPham = request.getParameter("idSanPham");
        String tenSanPham = request.getParameter("tenSanPham");
        String giaSanPham = request.getParameter("giaSanPham");
        String hoTen = request.getParameter("hoTen");
        String soDienThoai = request.getParameter("soDienThoai");
        String diaChi = request.getParameter("diaChi");

        String jdbcURL = "jdbc:mysql://localhost:3306/your_database";
        String dbUser = "root";
        String dbPassword = "password";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
            String sql = "INSERT INTO nvv_donhang (id_sanpham, ten_sanpham, gia, ho_ten, so_dien_thoai, dia_chi, trang_thai) VALUES (?, ?, ?, ?, ?, ?, 'Chờ Xử Lý')";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, idSanPham);
            stmt.setString(2, tenSanPham);
            stmt.setString(3, giaSanPham);
            stmt.setString(4, hoTen);
            stmt.setString(5, soDienThoai);
            stmt.setString(6, diaChi);
            stmt.executeUpdate();
            conn.close();

            response.sendRedirect("home.jsp?message=DatHangThanhCong");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("home.jsp?message=LoiDatHang");
        }
    }
}
