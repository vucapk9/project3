package controller;

import model.NvvLienHe;
import service.NvvLienHeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/NvvLienHeServlet")
public class NvvLienHeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private NvvLienHeService lienHeService;

    @Override
    public void init() throws ServletException {
        lienHeService = new NvvLienHeService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Nhận dữ liệu từ form
            String hoTen = request.getParameter("hoTen");
            String email = request.getParameter("email");
            String soDienThoai = request.getParameter("soDienThoai");
            String noiDung = request.getParameter("noiDung");

            // Kiểm tra dữ liệu nhập vào (Validation)
            if (hoTen == null || hoTen.isEmpty() || email == null || email.isEmpty() || soDienThoai == null || soDienThoai.isEmpty() || noiDung == null || noiDung.isEmpty()) {
                request.setAttribute("error", "Vui lòng điền đầy đủ thông tin.");
                request.getRequestDispatcher("lienhe.jsp").forward(request, response);
                return;
            }

            // Tạo đối tượng liên hệ
            NvvLienHe lienHe = new NvvLienHe(hoTen, email, soDienThoai, noiDung);

            // Lưu vào cơ sở dữ liệu
            lienHeService.themLienHe(lienHe);

            // Chuyển hướng về trang thành công
            response.sendRedirect("home.jsp?success=true");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("lienhe.jsp?error=Hệ thống gặp lỗi, vui lòng thử lại!");
        }
    }
}
