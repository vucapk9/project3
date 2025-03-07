package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.NvvNguoiDung;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        NvvNguoiDungdao userDao = new NvvNguoiDungdao();
        NvvNguoiDung user = userDao.checkLogin(username, password);

        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            response.sendRedirect("index.jsp");
        } else {
            request.setAttribute("error", "Tên đăng nhập hoặc mật khẩu sai!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}

    