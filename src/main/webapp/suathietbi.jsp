<%@ page import="dao.NvvThietBidao, model.NvvThietBi" %>
<%
    NvvThietBidao thietBiDAO = new NvvThietBidao();
    int id = Integer.parseInt(request.getParameter("id"));
    NvvThietBi tb = thietBiDAO.getAll().stream().filter(t -> t.getMaThietBi() == id).findFirst().orElse(null);

    if ("POST".equalsIgnoreCase(request.getMethod())) {
        tb.setTenThietBi(request.getParameter("tenThietBi"));
        tb.setMaDanhMuc(Integer.parseInt(request.getParameter("maDanhMuc")));
        tb.setMoTa(request.getParameter("moTa"));
        tb.setTieuChuan(request.getParameter("tieuChuan"));
        tb.setTinhTrang(request.getParameter("tinhTrang"));
        tb.setSoLuong(Integer.parseInt(request.getParameter("soLuong")));
        tb.setMaNhaCungCap(Integer.parseInt(request.getParameter("maNhaCungCap")));

        thietBiDAO.update(tb);
        response.sendRedirect("thietbi.jsp");
        return;
    }
%>
