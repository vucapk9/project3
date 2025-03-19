package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.NvvNhaCungCap;
import service.NvvNhaCungCapService;

@WebServlet("/NvvNhaCungCapServlet")
public class NvvNhaCungCapServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private NvvNhaCungCapService nhaCungCapService;

    public void init() {
        nhaCungCapService = new NvvNhaCungCapService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            listNhaCungCap(request, response);
        } else {
            switch (action) {
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    deleteNhaCungCap(request, response);
                    break;
                default:
                    listNhaCungCap(request, response);
                    break;
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("add".equals(action)) {
            insertNhaCungCap(request, response);
        } else if ("update".equals(action)) {
            updateNhaCungCap(request, response);
        }
    }

    private void listNhaCungCap(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<NvvNhaCungCap> nhaCungCaps = nhaCungCapService.getAll();
        request.setAttribute("nhaCungCaps", nhaCungCaps);
        request.getRequestDispatcher("nvv_nhacungcap_list.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int maNhaCungCap = Integer.parseInt(request.getParameter("id"));
        NvvNhaCungCap nhaCungCap = nhaCungCapService.getById(maNhaCungCap);
        request.setAttribute("nhaCungCap", nhaCungCap);
        request.getRequestDispatcher("nvv_nhacungcap_form.jsp").forward(request, response);
    }

    private void insertNhaCungCap(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String tenNhaCungCap = request.getParameter("tenNhaCungCap");
        String diaChi = request.getParameter("diaChi");
        String soDienThoai = request.getParameter("soDienThoai");
        String email = request.getParameter("email");

        NvvNhaCungCap nhaCungCap = new NvvNhaCungCap(0, tenNhaCungCap, diaChi, soDienThoai, email);
        nhaCungCapService.insert(nhaCungCap);
        response.sendRedirect("NvvNhaCungCapServlet");
    }

    private void updateNhaCungCap(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int maNhaCungCap = Integer.parseInt(request.getParameter("maNhaCungCap"));
        String tenNhaCungCap = request.getParameter("tenNhaCungCap");
        String diaChi = request.getParameter("diaChi");
        String soDienThoai = request.getParameter("soDienThoai");
        String email = request.getParameter("email");

        NvvNhaCungCap nhaCungCap = new NvvNhaCungCap(maNhaCungCap, tenNhaCungCap, diaChi, soDienThoai, email);
        nhaCungCapService.update(nhaCungCap);
        response.sendRedirect("NvvNhaCungCapServlet");
    }

    private void deleteNhaCungCap(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int maNhaCungCap = Integer.parseInt(request.getParameter("id"));
        nhaCungCapService.delete(maNhaCungCap);
        response.sendRedirect("NvvNhaCungCapServlet");
    }
}
