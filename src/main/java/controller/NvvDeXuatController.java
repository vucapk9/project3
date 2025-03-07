package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.NvvDeXuat;

@WebServlet("/NvvDeXuatController")
public class NvvDeXuatController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private NvvDeXuatRepository deXuatRepo;
    
    public void init() {
        deXuatRepo = new NvvDeXuatRepository();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<NvvDeXuat> deXuats = deXuatRepo.getAll();
        request.setAttribute("deXuats", deXuats);
        request.getRequestDispatcher("/deXuat.jsp").forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        
        if ("add".equals(action)) {
            String tenThietBi = request.getParameter("tenThietBi");
            String moTa = request.getParameter("moTa");
            
            NvvDeXuat dx = new NvvDeXuat();
            dx.setTenThietBi(tenThietBi);
            dx.setMoTa(moTa);
            
            deXuatRepo.insert(dx);
        }
        response.sendRedirect("/NvvDeXuatController");
    }
}
