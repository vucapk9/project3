<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List, model.NvvThietBi, dao.NvvThietBidao" %>
<%
    NvvThietBidao thietBiDAO = new NvvThietBidao();
    List<NvvThietBi> list = thietBiDAO.getAll();

    // Xử lý xóa thiết bị
    String action = request.getParameter("action");
    if ("delete".equals(action)) {
        int id = Integer.parseInt(request.getParameter("id"));
        thietBiDAO.delete(id);
        response.sendRedirect("thietbi.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Quản lý Thiết Bị</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-4">
        <h2 class="text-center">Danh Sách Thiết Bị</h2>
        <a href="addThietBi.jsp" class="btn btn-primary mb-3">Thêm Thiết Bị</a>

        <table class="table table-bordered">
            <thead class="table-dark">
                <tr>
                    <th>ID</th>
                    <th>Tên Thiết Bị</th>
                    <th>Danh Mục</th>
                    <th>Mô Tả</th>
                    <th>Tiêu Chuẩn</th>
                    <th>Tình Trạng</th>
                    <th>Số Lượng</th>
                    <th>Nhà Cung Cấp</th>
                    <th>Hành động</th>
                </tr>
            </thead>
            <tbody>
                <% for (NvvThietBi tb : list) { %>
                    <tr>
                        <td><%= tb.getMaThietBi() %></td>
                        <td><%= tb.getTenThietBi() %></td>
                        <td><%= tb.getMaDanhMuc() %></td>
                        <td><%= tb.getMoTa() %></td>
                        <td><%= tb.getTieuChuan() %></td>
                        <td><%= tb.getTinhTrang() %></td>
                        <td><%= tb.getSoLuong() %></td>
                        <td><%= tb.getMaNhaCungCap() %></td>
                        <td>
                            <a href="editThietBi.jsp?id=<%= tb.getMaThietBi() %>" class="btn btn-warning btn-sm">Sửa</a>
                            <a href="thietbi.jsp?action=delete&id=<%= tb.getMaThietBi() %>" class="btn btn-danger btn-sm" onclick="return confirm('Bạn có chắc muốn xóa?');">Xóa</a>
                        </td>
                    </tr>
                <% } %>
            </tbody>
        </table>
    </div>
</body>
</html>
