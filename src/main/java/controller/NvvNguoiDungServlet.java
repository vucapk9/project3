package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.NvvNguoiDung;
import service.NvvNguoiDungService;

@WebServlet("/NvvNguoiDungServlet")
public class NvvNguoiDungServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private NvvNguoiDungService nguoiDungService;
    
    public void init() {
        nguoiDungService = new NvvNguoiDungService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }
        switch (action) {
            case "new":
                showNewForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                deleteNguoiDung(request, response);
                break;
            default:
                listNguoiDung(request, response);
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "insert":
                insertNguoiDung(request, response);
                break;
            case "update":
                updateNguoiDung(request, response);
                break;
            default:
                listNguoiDung(request, response);
                break;
        }
    }

    private void listNguoiDung(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<NvvNguoiDung> danhSachNguoiDung = nguoiDungService.getAllNguoiDung();
        request.setAttribute("danhSachNguoiDung", danhSachNguoiDung);
        request.getRequestDispatcher("nvv_nguoidung_list.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("nvv_nguoidung_form.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        NvvNguoiDung existingUser = nguoiDungService.getNguoiDungById(id);
        request.setAttribute("nguoiDung", existingUser);
        request.getRequestDispatcher("nvv_nguoidung_form.jsp").forward(request, response);
    }

    private void insertNguoiDung(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String hoTen = request.getParameter("hoTen");
        String email = request.getParameter("email");
        String matKhau = request.getParameter("matKhau");
        String vaiTro = request.getParameter("vaiTro");
        
        NvvNguoiDung nguoiDung = new NvvNguoiDung(hoTen, email, matKhau, vaiTro);
        nguoiDungService.insertNguoiDung(nguoiDung);
        response.sendRedirect("NvvNguoiDungServlet");
    }

    private void updateNguoiDung(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String hoTen = request.getParameter("hoTen");
        String email = request.getParameter("email");
        String matKhau = request.getParameter("matKhau");
        String vaiTro = request.getParameter("vaiTro");
        
        NvvNguoiDung nguoiDung = new NvvNguoiDung(id, hoTen, email, matKhau, vaiTro);
        nguoiDungService.updateNguoiDung(nguoiDung);
        response.sendRedirect("NvvNguoiDungServlet");
    }

    private void deleteNguoiDung(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        nguoiDungService.deleteNguoiDung(id);
        response.sendRedirect("NvvNguoiDungServlet");
    }
}
