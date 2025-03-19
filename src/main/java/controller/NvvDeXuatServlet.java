package controller;

import model.NvvDeXuat;
import service.NvvDeXuatService;
import dao.NvvDeXuatdao;
import utils.DatabaseConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/dexuat")
public class NvvDeXuatServlet extends HttpServlet {
    private NvvDeXuatService deXuatService;

    public void init() {
        Connection conn = null;
		try {
			conn = DatabaseConnection.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        deXuatService = new NvvDeXuatService(new NvvDeXuatdao(conn));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<NvvDeXuat> list = deXuatService.getAllDeXuat();
        request.setAttribute("deXuatList", list);
        request.getRequestDispatcher("nvv_dexuat_list.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tenThietBi = request.getParameter("tenThietBi");
        String moTa = request.getParameter("moTa");
        String trangThai = "Chờ duyệt"; // Mặc định
        Date ngayGui = new Date(System.currentTimeMillis());

        NvvDeXuat deXuat = new NvvDeXuat(0, tenThietBi, moTa, trangThai, ngayGui);
        deXuatService.addDeXuat(deXuat);
        response.sendRedirect("dexuat");
    }
}
