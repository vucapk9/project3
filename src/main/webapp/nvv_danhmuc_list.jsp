<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List, model.NvvDanhMuc" %>
<jsp:useBean id="danhMucService" class="service.NvvDanhMucService" scope="request"/>
<%
    List<NvvDanhMuc> danhMucList = danhMucService.getAll();
%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Danh Sách Danh Mục</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <style>
        body {
            background-color: #f8f9fa;
        }
        .table-container {
            max-width: 800px;
            margin: auto;
            background: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
    </style>
</head>
<body>

<div class="container mt-4">
    <div class="table-container">
        <div class="d-flex justify-content-between align-items-center mb-3">
            <h3 class="text-primary">📂 Danh Sách Danh Mục</h3>
            <a href="nvv_danhmuc_form.jsp" class="btn btn-primary">➕ Thêm mới</a>
        </div>

        <table class="table table-bordered table-hover shadow">
            <thead class="table-dark">
                <tr>
                    <th class="text-center">Mã Danh Mục</th>
                    <th>Tên Danh Mục</th>
                    <th class="text-center">Hành Động</th>
                </tr>
            </thead>
            <tbody>
                <% for (NvvDanhMuc dm : danhMucList) { %>
                    <tr>
                        <td class="text-center"><%= dm.getMaDanhMuc() %></td>
                        <td><%= dm.getTenDanhMuc() %></td>
                        <td class="text-center">
                            <a href="NvvDanhMucServlet?action=edit&id=<%= dm.getMaDanhMuc() %>" class="btn btn-warning btn-sm">✏ Sửa</a>
                            <a href="NvvDanhMucServlet?action=delete&id=<%= dm.getMaDanhMuc() %>" class="btn btn-danger btn-sm" onclick="return confirm('Bạn có chắc chắn muốn xóa?');">🗑 Xóa</a>
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
