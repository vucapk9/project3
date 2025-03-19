<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.NvvNguoiDung" %>
<%
    String action = "add";
    NvvNguoiDung user = (NvvNguoiDung) request.getAttribute("nguoiDung");
    if (user != null) {
        action = "edit";
    }
%>
<html>
<head>
    <title><%= (user == null) ? "Thêm Người Dùng" : "Sửa Người Dùng" %></title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-4">
        <h2 class="text-center"><%= (user == null) ? "Thêm Người Dùng" : "Sửa Người Dùng" %></h2>
        <form action="nguoidung" method="post">
            <input type="hidden" name="action" value="<%= action %>">
            <input type="hidden" name="maNguoiDung" value="<%= (user != null) ? user.getMaNguoiDung() : "" %>">

            <div class="mb-3">
                <label class="form-label">Tên Đăng Nhập</label>
                <input type="text" name="tenDangNhap" class="form-control" value="<%= (user != null) ? user.getTenDangNhap() : "" %>" required>
            </div>

            <div class="mb-3">
                <label class="form-label">Mật Khẩu</label>
                <input type="password" name="matKhau" class="form-control" value="<%= (user != null) ? user.getMatKhau() : "" %>" required>
            </div>

            <div class="mb-3">
                <label class="form-label">Họ Tên</label>
                <input type="text" name="hoTen" class="form-control" value="<%= (user != null) ? user.getHoTen() : "" %>" required>
            </div>

            <div class="mb-3">
                <label class="form-label">Vai Trò</label>
                <select name="vaiTro" class="form-control">
                    <option value="Admin" <%= (user != null && user.getVaiTro().equals("Admin")) ? "selected" : "" %>>Admin</option>
                    <option value="User" <%= (user != null && user.getVaiTro().equals("User")) ? "selected" : "" %>>User</option>
                    <option value="Mod" <%= (user != null && user.getVaiTro().equals("Mod")) ? "selected" : "" %>>Mod</option>
                </select>
            </div>

            <button type="submit" class="btn btn-primary">Lưu</button>
            <a href="nvv_nguoidung_list.jsp" class="btn btn-secondary">Hủy</a>
        </form>
    </div>
</body>
</html>
