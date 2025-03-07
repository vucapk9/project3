package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.NvvNguoiDungdao;
import model.NvvNguoiDung;


@WebServlet("/NguoiDungController")
public class NvvNguoiDungController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private NvvNguoiDungdao userDao = new NvvNguoiDungdao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String action = request.getParameter("action");
        
        if ("register".equals(action)) {
            String tenDangNhap = request.getParameter("tenDangNhap");
            String matKhau = request.getParameter("matKhau");
            String vaiTro = "user"; // Mặc định user

            NvvNguoiDung user = new NvvNguoiDung();
            user.setTenDangNhap(tenDangNhap);
            user.setMatKhau(matKhau);
            user.setVaiTro(vaiTro);

            boolean success = userDao.insertUser(user);
            if (success) {
                response.sendRedirect("login.jsp?msg=Đăng ký thành công, vui lòng đăng nhập!");
            } else {
                response.sendRedirect("register.jsp?error=Đăng ký thất bại!");
            }
        } 
        else if ("login".equals(action)) {
            String tenDangNhap = request.getParameter("tenDangNhap");
            String matKhau = request.getParameter("matKhau");

            NvvNguoiDung user = userDao.loginUser(tenDangNhap, matKhau);
            if (user != null) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                response.sendRedirect("index.jsp"); // Trang chính sau khi đăng nhập
            } else {
                response.sendRedirect("login.jsp?error=Sai tên đăng nhập hoặc mật khẩu!");
            }
        }
    }
}