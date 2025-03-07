package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.NvvBaoCao;

@WebServlet("/NvvBaoCaoController")
public class NvvBaoCaoController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private NvvBaoCaoRepository baoCaoRepo;
    
    public void init() {
        baoCaoRepo = new NvvBaoCaoRepository();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<NvvBaoCao> baoCaos = baoCaoRepo.getAll();
        request.setAttribute("baoCaos", baoCaos);
        request.getRequestDispatcher("/baoCao.jsp").forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        
        if ("add".equals(action)) {
            int maThietBi = Integer.parseInt(request.getParameter("maThietBi"));
            String tinhTrangHienTai = request.getParameter("tinhTrangHienTai");
            String ghiChu = request.getParameter("ghiChu");
            NvvBaoCao bc = new NvvBaoCao();
            bc.setMaThietBi(maThietBi);
            bc.setTinhTrangHienTai(tinhTrangHienTai);
            bc.setGhiChu(ghiChu);
            
            baoCaoRepo.insert(bc);
        }
        response.sendRedirect("/NvvBaoCaoController");
    }
}
