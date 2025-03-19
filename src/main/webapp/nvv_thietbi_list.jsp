<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List, model.NvvThietBi" %>
<jsp:useBean id="thietBiService" class="service.NvvThietBiService" scope="request"/>
<%
    List<NvvThietBi> thietBiList = thietBiService.getAll();
%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Danh Sách Thiết Bị</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-4">
        <h2 class="mb-3 text-center">Danh Sách Thiết Bị</h2>
        
        <!-- Nút thêm thiết bị -->
        <div class="mb-3">
            <a href="nvv_thietbi_form.jsp" class="btn btn-primary">➕ Thêm Mới</a>
        </div>

        <!-- Bảng thiết bị -->
        <table class="table table-striped table-bordered">
            <thead class="table-dark">
                <tr>
                    <th>Mã Thiết Bị</th>
                    <th>Tên Thiết Bị</th>
                    <th>Mô Tả</th>
                    <th>Tiêu Chuẩn</th>
                    <th>Tình Trạng</th>
                    <th>Số Lượng</th>
                    <th>Hành Động</th>
                </tr>
            </thead>
            <tbody>
                <% for (NvvThietBi tb : thietBiList) { %>
                    <tr>
                        <td><%= tb.getMaThietBi() %></td>
                        <td><%= tb.getTenThietBi() %></td>
                        <td><%= tb.getMoTa() %></td>
                        <td><%= tb.getTieuChuan() %></td>
                        <td><%= tb.getTinhTrang() %></td>
                        <td><%= tb.getSoLuong() %></td>
                        <td>
                            <a href="NvvThietBiServlet?action=edit&id=<%= tb.getMaThietBi() %>" class="btn btn-warning btn-sm">✏ Sửa</a>
                            <a href="NvvThietBiServlet?action=delete&id=<%= tb.getMaThietBi() %>" class="btn btn-danger btn-sm" onclick="return confirm('Bạn có chắc muốn xóa?')">🗑 Xóa</a>
                        </td>
                    </tr>
                <% } %>
            </tbody>
        </table>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
