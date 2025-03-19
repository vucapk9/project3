<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="model.NvvNguoiDung" %>
<html>
<head>
    <title>Danh Sách Người Dùng</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-4">
        <h2 class="text-center">Danh Sách Người Dùng</h2>
        <a href="nvv_nguoidung_edit.jsp" class="btn btn-success mb-3">Thêm Người Dùng</a>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>Mã Người Dùng</th>
                    <th>Tên Đăng Nhập</th>
                    <th>Họ Tên</th>
                    <th>Vai Trò</th>
                    <th>Hành Động</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<NvvNguoiDung> nguoiDungList = (List<NvvNguoiDung>) request.getAttribute("nguoiDungList");
                    if (nguoiDungList != null) {
                        for (NvvNguoiDung user : nguoiDungList) {
                %>
                <tr>
                    <td><%= user.getMaNguoiDung() %></td>
                    <td><%= user.getTenDangNhap() %></td>
                    <td><%= user.getHoTen() %></td>
                    <td><%= user.getVaiTro() %></td>
                    <td>
                        <a href="nvv_nguoidung_edit.jsp?id=<%= user.getMaNguoiDung() %>" class="btn btn-warning btn-sm">Sửa</a>
                        <a href="nguoidung?action=delete&id=<%= user.getMaNguoiDung() %>" class="btn btn-danger btn-sm" onclick="return confirm('Bạn có chắc chắn muốn xóa?');">Xóa</a>
                    </td>
                </tr>
                <%
                        }
                    }
                %>
            </tbody>
        </table>
    </div>
</body>
</html>
