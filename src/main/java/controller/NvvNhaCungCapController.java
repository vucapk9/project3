package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/NvvNhaCungCapController")
public class NvvNhaCungCapController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private NvvNhaCungCapRepository nhaCungCapRepo;
    
    public void init() {
        nhaCungCapRepo = new NvvNhaCungCapRepository();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<NvvNhaCungCap> nhaCungCaps = ( nhaCungCapRepo).getAll();
        request.setAttribute("nhaCungCaps", nhaCungCaps);
        request.getRequestDispatcher("/nhaCungCap.jsp").forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        
        if ("add".equals(action)) {
            String tenNhaCungCap = request.getParameter("tenNhaCungCap");
            String diaChi = request.getParameter("diaChi");
            String soDienThoai = request.getParameter("soDienThoai");
            String email = request.getParameter("email");
            NvvNhaCungCap ncc = new NvvNhaCungCap();
            ncc.setTenNhaCungCap(tenNhaCungCap);
            ncc.setDiaChi(diaChi);
            ncc.setSoDienThoai(soDienThoai);
            ncc.setEmail(email);
            nhaCungCapRepo.insert(ncc);
        } else if ("update".equals(action)) {
            int maNhaCungCap = Integer.parseInt(request.getParameter("maNhaCungCap"));
            String tenNhaCungCap = request.getParameter("tenNhaCungCap");
            String diaChi = request.getParameter("diaChi");
            String soDienThoai = request.getParameter("soDienThoai");
            String email = request.getParameter("email");
            NvvNhaCungCap ncc = new NvvNhaCungCap();
            ncc.setMaNhaCungCap(maNhaCungCap);
            ncc.setTenNhaCungCap(tenNhaCungCap);
            ncc.setDiaChi(diaChi);
            ncc.setSoDienThoai(soDienThoai);
            ncc.setEmail(email);
            nhaCungCapRepo.update(ncc);
        } else if ("delete".equals(action)) {
            int maNhaCungCap = Integer.parseInt(request.getParameter("maNhaCungCap"));
            nhaCungCapRepo.delete(maNhaCungCap);
        }
        response.sendRedirect("/NvvNhaCungCapController");
    }
}