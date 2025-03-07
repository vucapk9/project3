<%@ page import="dao.NvvThietBidao, model.NvvThietBi" %>
<%
    if ("POST".equalsIgnoreCase(request.getMethod())) {
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

        NvvThietBidao thietBiDAO = new NvvThietBidao();
        thietBiDAO.insert(tb);
        
        response.sendRedirect("thietbi.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Thêm Thiết Bị</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-4">
        <h2 class="text-center">Thêm Thiết Bị</h2>
        <form method="post">
            <div class="mb-3">
                <label class="form-label">Tên Thiết Bị</label>
                <input type="text" name="tenThietBi" class="form-control" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Mã Danh Mục</label>
                <input type="number" name="maDanhMuc" class="form-control">
            </div>
            <div class="mb-3">
                <label class="form-label">Mô Tả</label>
                <input type="text" name="moTa" class="form-control">
            </div>
            <div class="mb-3">
                <label class="form-label">Tiêu Chuẩn</label>
                <input type="text" name="tieuChuan" class="form-control">
            </div>
            <div class="mb-3">
                <label class="form-label">Tình Trạng</label>
                <input type="text" name="tinhTrang" class="form-control">
            </div>
            <div class="mb-3">
                <label class="form-label">Số Lượng</label>
                <input type="number" name="soLuong" class="form-control">
            </div>
            <div class="mb-3">
                <label class="form-label">Mã Nhà Cung Cấp</label>
                <input type="number" name="maNhaCungCap" class="form-control">
            </div>
            <button type="submit" class="btn btn-success">Thêm</button>
            <a href="thietbi.jsp" class="btn btn-secondary">Hủy</a>
        </form>
    </div>
</body>
</html>
