package controller;

import model.NvvNguoiDung;
import service.NvvNguoiDungService;
import dao.NvvNguoiDungdao;
import utils.DatabaseConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/nguoidung")
public class NvvNguoiDungServlet extends HttpServlet {
    private NvvNguoiDungService nguoiDungService;

    public void init() {
        Connection conn = null;
		try {
			conn = DatabaseConnection.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        nguoiDungService = new NvvNguoiDungService(new NvvNguoiDungdao(conn));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<NvvNguoiDung> list = nguoiDungService.getAllNguoiDung();
        request.setAttribute("nguoiDungList", list);
        request.getRequestDispatcher("nvv_nguoidung_list.jsp").forward(request, response);
    }
}
