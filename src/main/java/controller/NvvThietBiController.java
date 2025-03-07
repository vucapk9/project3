package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.NvvThietBi;

@WebServlet("/NvvThietBiController")
public class NvvThietBiController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private NvvThietBiRepository thietBiRepo;
    
    public void init() {
        thietBiRepo = new NvvThietBiRepository();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<NvvThietBi> thietBis = thietBiRepo.getAll();
        request.setAttribute("thietBis", thietBis);
        request.getRequestDispatcher("/thietBi.jsp").forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        
        if ("add".equals(action)) {
            String tenThietBi = request.getParameter("tenThietBi");
            int maDanhMuc = Integer.parseInt(request.getParameter("maDanhMuc"));
            String moTa = request.getParameter("moTa");
            String tieuChuan = request.getParameter("tieuChuan");
            String tinhTrang = request.getParameter("tinhTrang");
            int soLuong = Integer.parseInt(request.getParameter("soLuong"));
            int maNhaCungCap = Integer.parseInt(request.getParameter("maNhaCungCap"));
            
            NvvThietBi tb = new NvvThietBi();
            tb.setTenThietBi(tenThietBi);
            tb.setMaDanhMuc(maDanhMuc);
            tb.setMoTa(moTa);
            tb.setTieuChuan(tieuChuan);
            tb.setTinhTrang(tinhTrang);
            tb.setSoLuong(soLuong);
            tb.setMaNhaCungCap(maNhaCungCap);
            
            thietBiRepo.insert(tb);
        } else if ("update".equals(action)) {
            int maThietBi = Integer.parseInt(request.getParameter("maThietBi"));
            String tenThietBi = request.getParameter("tenThietBi");
            int maDanhMuc = Integer.parseInt(request.getParameter("maDanhMuc"));
            String moTa = request.getParameter("moTa");
            String tieuChuan = request.getParameter("tieuChuan");
            String tinhTrang = request.getParameter("tinhTrang");
            int soLuong = Integer.parseInt(request.getParameter("soLuong"));
            int maNhaCungCap = Integer.parseInt(request.getParameter("maNhaCungCap"));
            
            NvvThietBi tb = new NvvThietBi();
            tb.setMaThietBi(maThietBi);
            tb.setTenThietBi(tenThietBi);
            tb.setMaDanhMuc(maDanhMuc);
            tb.setMoTa(moTa);
            tb.setTieuChuan(tieuChuan);
            tb.setTinhTrang(tinhTrang);
            tb.setSoLuong(soLuong);
            tb.setMaNhaCungCap(maNhaCungCap);
            
            thietBiRepo.update(tb);
        } else if ("delete".equals(action)) {
            int maThietBi = Integer.parseInt(request.getParameter("maThietBi"));
            thietBiRepo.delete(maThietBi);
        }
        response.sendRedirect("/NvvThietBiController");
    }
}