package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.NvvThietBidao;
import model.NvvThietBi;

@WebServlet("/NvvThietBiServlet")
public class NvvThietBiServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private NvvThietBidao thietBiDAO;

    @Override
    public void init() {
        thietBiDAO = new NvvThietBidao();
    }

    @Override
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
            case "insert":
                insertThietBi(request, response);
                break;
            case "delete":
                deleteThietBi(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "update":
                updateThietBi(request, response);
                break;
            default:
                listThietBi(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        doGet(request, response);
    }

    private void listThietBi(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        List<NvvThietBi> listThietBi = thietBiDAO.getAll();
        request.setAttribute("listThietBi", listThietBi);
        request.getRequestDispatcher("nvv_thietbi_list.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        request.getRequestDispatcher("nvv_thietbi_form.jsp").forward(request, response);
    }

    private void insertThietBi(HttpServletRequest request, HttpServletResponse response) 
            throws IOException {
        try {
            String tenThietBi = request.getParameter("tenThietBi");
            int maDanhMuc = Integer.parseInt(request.getParameter("maDanhMuc"));
            String moTa = request.getParameter("moTa");
            String tieuChuan = request.getParameter("tieuChuan");
            String tinhTrang = request.getParameter("tinhTrang");
            int soLuong = Integer.parseInt(request.getParameter("soLuong"));
            int maNhaCungCap = Integer.parseInt(request.getParameter("maNhaCungCap"));

            NvvThietBi thietBi = new NvvThietBi(0, tenThietBi, maDanhMuc, moTa, tieuChuan, tinhTrang, soLuong, maNhaCungCap, maNhaCungCap );
            thietBiDAO.insert(thietBi);

            response.sendRedirect("NvvThietBiServlet?action=list");
        } catch (NumberFormatException e) {
            e.printStackTrace();
            response.sendRedirect("nvv_thietbi_form.jsp?error=InvalidInput");
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        int maThietBi = Integer.parseInt(request.getParameter("maThietBi"));
        NvvThietBi existingThietBi = thietBiDAO.getById(maThietBi);
        request.setAttribute("thietBi", existingThietBi);
        request.getRequestDispatcher("nvv_thietbi_form.jsp").forward(request, response);
    }

    private void updateThietBi(HttpServletRequest request, HttpServletResponse response) 
            throws IOException {
        try {
            int maThietBi = Integer.parseInt(request.getParameter("maThietBi"));
            String tenThietBi = request.getParameter("tenThietBi");
            int maDanhMuc = Integer.parseInt(request.getParameter("maDanhMuc"));
            String moTa = request.getParameter("moTa");
            String tieuChuan = request.getParameter("tieuChuan");
            String tinhTrang = request.getParameter("tinhTrang");
            int soLuong = Integer.parseInt(request.getParameter("soLuong"));
            int maNhaCungCap = Integer.parseInt(request.getParameter("maNhaCungCap"));

            NvvThietBi thietBi = new NvvThietBi(maThietBi, tenThietBi, maDanhMuc, moTa, tieuChuan, tinhTrang, soLuong, maNhaCungCap, maNhaCungCap);
            thietBiDAO.update(thietBi);

            response.sendRedirect("NvvThietBiServlet?action=list");
        } catch (NumberFormatException e) {
            e.printStackTrace();
            response.sendRedirect("nvv_thietbi_form.jsp?error=InvalidInput");
        }
    }

    private void deleteThietBi(HttpServletRequest request, HttpServletResponse response) 
            throws IOException {
        int maThietBi = Integer.parseInt(request.getParameter("maThietBi"));
        thietBiDAO.delete(maThietBi);
        response.sendRedirect("NvvThietBiServlet?action=list");
    }
}
