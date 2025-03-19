package controller;

import dao.NvvBaoCaodao;
import model.NvvBaoCao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

@WebServlet("/NvvBaoCaoServlet")
public class NvvBaoCaoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private NvvBaoCaodao baoCaoDAO;

    public void init() {
        baoCaoDAO = new NvvBaoCaodao();
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
            case "insert":
                insertBaoCao(request, response);
                break;
            case "delete":
                deleteBaoCao(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "update":
                updateBaoCao(request, response);
                break;
            default:
                listBaoCao(request, response);
                break;
        }
    }

    private void listBaoCao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<NvvBaoCao> listBaoCao = baoCaoDAO.getAll();
        request.setAttribute("listBaoCao", listBaoCao);
        request.getRequestDispatcher("nvv_baocao_list.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("nvv_baocao_form.jsp").forward(request, response);
    }

    private void insertBaoCao(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String tieuDe = request.getParameter("tieuDe");
        String noiDung = request.getParameter("noiDung");
        int maNguoiDung = Integer.parseInt(request.getParameter("maNguoiDung"));

        NvvBaoCao baoCao = new NvvBaoCao();
        baoCao.setTieuDe(tieuDe);
        baoCao.setNoiDung(noiDung);
        baoCao.setNgayTao(new Timestamp(System.currentTimeMillis()));
        baoCao.setMaNguoiDung(maNguoiDung);

        baoCaoDAO.insert(baoCao);
        response.sendRedirect("NvvBaoCaoServlet");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        NvvBaoCao existingBaoCao = baoCaoDAO.getById(id);
        request.setAttribute("baoCao", existingBaoCao);
        request.getRequestDispatcher("nvv_baocao_form.jsp").forward(request, response);
    }

    private void updateBaoCao(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int maBaoCao = Integer.parseInt(request.getParameter("maBaoCao"));
        String tieuDe = request.getParameter("tieuDe");
        String noiDung = request.getParameter("noiDung");
        int maNguoiDung = Integer.parseInt(request.getParameter("maNguoiDung"));

        NvvBaoCao baoCao = new NvvBaoCao();
        baoCao.setMaBaoCao(maBaoCao);
        baoCao.setTieuDe(tieuDe);
        baoCao.setNoiDung(noiDung);
        baoCao.setMaNguoiDung(maNguoiDung);

        baoCaoDAO.update(baoCao);
        response.sendRedirect("NvvBaoCaoServlet");
    }

    private void deleteBaoCao(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        baoCaoDAO.delete(id);
        response.sendRedirect("NvvBaoCaoServlet");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
