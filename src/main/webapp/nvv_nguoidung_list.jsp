<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List, model.NvvNguoiDung" %>
<jsp:useBean id="nguoiDungService" class="service.NvvNguoiDungService" scope="request"/>
<%
    List<NvvNguoiDung> nguoiDungList = nguoiDungService.getAll();
%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Danh Sách Người Dùng</title>
    
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            background-color: #f8f9fa;
        }
        .container {
            margin-top: 30px;
        }
    </style>
</head>
<body>

<div class="container">
    <h2 class="text-center text-primary">📋 Danh Sách Người Dùng</h2>
    
    <!-- Nút thêm mới -->
    <div class="mb-3">
        <a href="nvv_nguoidung_form.jsp" class="btn btn-primary">➕ Thêm Mới</a>
    </div>

    <!-- Bảng hiển thị danh sách người dùng -->
    <div class="table-responsive">
        <table class="table table-bordered table-striped text-center">
            <thead class="table-dark">
                <tr>
                    <th>ID</th>
                    <th>Họ Tên</th>
                    <th>Email</th>
                    <th>Vai Trò</th>
                    <th>Hành Động</th>
                </tr>
            </thead>
           <tbody>
    <% for (NvvNguoiDung nd : nguoiDungList) { %>
        <tr>
            <td><%= nd.getMaNguoiDung() %></td>  <%-- Đổi getId() thành getMaNguoiDung() nếu cần --%>
            <td><%= nd.getHoTen() %></td>
            <td><%= nd.getEmail() %></td>
            <td><%= nd.getVaiTro() %></td>
            <td>
                <a href="NvvNguoiDungServlet?action=edit&id=<%= nd.getMaNguoiDung() %>" class="btn btn-warning btn-sm">✏ Sửa</a>
                <a href="NvvNguoiDungServlet?action=delete&id=<%= nd.getMaNguoiDung() %>" class="btn btn-danger btn-sm" onclick="return confirm('Bạn có chắc muốn xóa?')">🗑 Xóa</a>
            </td>
        </tr>
    <% } %>
</tbody>

        </table>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
