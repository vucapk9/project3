package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.*;


@WebServlet("/NvvDanhMucController")
public class NvvDanhMucController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private NvvDanhMucRepository danhMucRepo;
    
    public void init() {
        danhMucRepo = new NvvDanhMucRepository();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<NvvDanhMuc> danhMucs = danhMucRepo.getAll();
        request.setAttribute("danhMucs", danhMucs);
        request.getRequestDispatcher("/danhMuc.jsp").forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        
        if ("add".equals(action)) {
            String tenDanhMuc = request.getParameter("tenDanhMuc");
            NvvDanhMuc dm = new NvvDanhMuc();
            dm.setTenDanhMuc(tenDanhMuc);
            danhMucRepo.insert(dm);
        } else if ("update".equals(action)) {
            int maDanhMuc = Integer.parseInt(request.getParameter("maDanhMuc"));
            String tenDanhMuc = request.getParameter("tenDanhMuc");
            NvvDanhMuc dm = new NvvDanhMuc();
            dm.setMaDanhMuc(maDanhMuc);
            dm.setTenDanhMuc(tenDanhMuc);
            danhMucRepo.update(dm);
        } else if ("delete".equals(action)) {
            int maDanhMuc = Integer.parseInt(request.getParameter("maDanhMuc"));
            danhMucRepo.delete(maDanhMuc);
        }
        response.sendRedirect("/NvvDanhMucController");
    }
}