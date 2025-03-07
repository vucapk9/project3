<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đăng Nhập</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h2>Đăng Nhập</h2>
        <% if (request.getParameter("error") != null) { %>
            <div class="alert alert-danger"><%= request.getParameter("error") %></div>
        <% } %>
        <% if (request.getParameter("msg") != null) { %>
            <div class="alert alert-success"><%= request.getParameter("msg") %></div>
        <% } %>
        <form action="NguoiDungController" method="post">
            <input type="hidden" name="action" value="login">
            <div class="mb-3">
                <label>Tên đăng nhập:</label>
                <input type="text" class="form-control" name="tenDangNhap" required>
            </div>
            <div class="mb-3">
                <label>Mật khẩu:</label>
                <input type="password" class="form-control" name="matKhau" required>
            </div>
            <button type="submit" class="btn btn-primary">Đăng Nhập</button>
            <a href="register.jsp">Chưa có tài khoản? Đăng ký</a>
        </form>
    </div>
</body>
</html>
