package controller;

import model.NvvThietBi;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/NvvGioHangServlet")
public class NvvGioHangServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Map<Integer, NvvThietBi> gioHang = (Map<Integer, NvvThietBi>) session.getAttribute("gioHang");

        if (gioHang == null) {
            gioHang = new HashMap<>();
        }

        int maThietBi = Integer.parseInt(request.getParameter("maThietBi"));
        String tenThietBi = request.getParameter("tenThietBi");
        int soLuong = Integer.parseInt(request.getParameter("soLuong"));

        if (gioHang.containsKey(maThietBi)) {
            gioHang.get(maThietBi).setSoLuong(gioHang.get(maThietBi).getSoLuong() + soLuong);
        } else {
            gioHang.put(maThietBi, new NvvThietBi(maThietBi, tenThietBi, soLuong, tenThietBi, tenThietBi, tenThietBi, soLuong, soLuong, soLuong));
        }

        session.setAttribute("gioHang", gioHang);
        response.sendRedirect("nvv_giohang.jsp");
    }
}
