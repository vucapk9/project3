<%@ page import="java.util.List, model.NvvNguoiDung, dao.NvvNguoiDungdao" %>
<%
    NvvNguoiDungdao userDAO = new NvvNguoiDungdao();
    List<NvvNguoiDung> list = userDAO.getAll();
%>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quản lý Người Dùng</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-4">
        <h2 class="text-center">Danh Sách Người Dùng</h2>
        <table class="table table-bordered table-striped">
            <thead class="table-dark">
                <tr>
                    <th>ID</th>
                    <th>Tên Đăng Nhập</th>
                    <th>Mật Khẩu</th>
                    <th>Vai Trò</th>
                    <th>Hành động</th>
                </tr>
            </thead>
            <tbody>
                <% if (list != null && !list.isEmpty()) {
                    for (NvvNguoiDung user : list) { %>
                        <tr>
                            <td><%= user.getMaNguoiDung() %></td>
                            <td><%= user.getTenDangNhap() %></td>
                            <td>******</td> <!-- Không hiển thị mật khẩu trực tiếp -->
                            <td><%= user.getVaiTro() %></td>
                            <td>
                                <a href="sua-nguoidung.jsp?id=<%= user.getMaNguoiDung() %>" class="btn btn-warning btn-sm">Sửa</a>
                                <a href="nguoidung.jsp?action=delete&id=<%= user.getMaNguoiDung() %>" class="btn btn-danger btn-sm" onclick="return confirm('Bạn có chắc muốn xóa?');">Xóa</a>
                            </td>
                        </tr>
                <% } } else { %>
                    <tr>
                        <td colspan="5" class="text-center">Không có dữ liệu người dùng</td>
                    </tr>
                <% } %>
            </tbody>
        </table>
    </div>
</body>
</html>
