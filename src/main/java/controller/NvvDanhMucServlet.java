package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.NvvDanhMuc;
import service.NvvDanhMucService;

@WebServlet("/NvvDanhMucServlet")
public class NvvDanhMucServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private NvvDanhMucService danhMucService;

    public void init() {
        danhMucService = new NvvDanhMucService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        
        if (action == null) {
            listDanhMuc(request, response);
        } else {
            switch (action) {
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    deleteDanhMuc(request, response);
                    break;
                default:
                    listDanhMuc(request, response);
                    break;
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        
        if ("add".equals(action)) {
            insertDanhMuc(request, response);
        } else if ("update".equals(action)) {
            updateDanhMuc(request, response);
        }
    }

    private void listDanhMuc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<NvvDanhMuc> danhMucs = danhMucService.getAll();
        request.setAttribute("danhMucs", danhMucs);
        request.getRequestDispatcher("nvv_danhmuc_list.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int maDanhMuc = Integer.parseInt(request.getParameter("id"));
        NvvDanhMuc danhMuc = danhMucService.getById(maDanhMuc);
        request.setAttribute("danhMuc", danhMuc);
        request.getRequestDispatcher("nvv_danhmuc_form.jsp").forward(request, response);
    }

    private void insertDanhMuc(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String tenDanhMuc = request.getParameter("tenDanhMuc");
        NvvDanhMuc danhMuc = new NvvDanhMuc(0, tenDanhMuc, tenDanhMuc);
        danhMucService.insert(danhMuc);
        response.sendRedirect("NvvDanhMucServlet");
    }

    private void updateDanhMuc(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int maDanhMuc = Integer.parseInt(request.getParameter("maDanhMuc"));
        String tenDanhMuc = request.getParameter("tenDanhMuc");
        NvvDanhMuc danhMuc = new NvvDanhMuc(maDanhMuc, tenDanhMuc, tenDanhMuc);
        danhMucService.update(danhMuc);
        response.sendRedirect("NvvDanhMucServlet");
    }

    private void deleteDanhMuc(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int maDanhMuc = Integer.parseInt(request.getParameter("id"));
        danhMucService.delete(maDanhMuc);
        response.sendRedirect("NvvDanhMucServlet");
    }
}
