package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.NvvNhaCungCapRepository;
import model.NvvNhaCungCap;

@WebServlet("/themNhaCungCap")
public class NvvThemNhaCungCapServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private NvvNhaCungCapRepository nhaCungCapRepo;

    public void init() {
        nhaCungCapRepo = new NvvNhaCungCapRepository();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Lấy dữ liệu từ form
        String tenNhaCungCap = request.getParameter("tenNhaCungCap");
        String diaChi = request.getParameter("diaChi");
        String soDienThoai = request.getParameter("soDienThoai");
        String email = request.getParameter("email");

        // Kiểm tra dữ liệu nhập vào
        if (tenNhaCungCap == null || tenNhaCungCap.trim().isEmpty() ||
            diaChi == null || diaChi.trim().isEmpty() ||
            soDienThoai == null || soDienThoai.trim().isEmpty() ||
            email == null || email.trim().isEmpty()) {
            request.setAttribute("error", "Vui lòng nhập đầy đủ thông tin!");
            request.getRequestDispatcher("nhaCungCap.jsp").forward(request, response);
            return;
        }

        // Tạo đối tượng Nhà Cung Cấp
        NvvNhaCungCap ncc = new NvvNhaCungCap();
        ncc.setTenNhaCungCap(tenNhaCungCap);
        ncc.setDiaChi(diaChi);
        ncc.setSoDienThoai(soDienThoai);
        ncc.setEmail(email);

        // Thêm vào database
        nhaCungCapRepo.insert(ncc);

        // Chuyển hướng về trang danh sách nhà cung cấp
        response.sendRedirect("NvvNhaCungCapController");
    }
}
