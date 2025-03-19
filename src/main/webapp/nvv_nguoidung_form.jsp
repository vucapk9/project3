<%@ page contentType="text/html; charset=UTF-8" %>
<%
    String action = request.getParameter("action");
    String id = request.getParameter("id");
    String hoTen = "", email = "", vaiTro = "user"; // Giá trị mặc định

    if (id != null) {
        hoTen = "Người dùng mẫu"; // Lấy từ DB nếu sửa
        email = "email@example.com";
        vaiTro = "admin";
    }
%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title><%= (action != null && action.equals("edit")) ? "Sửa Người Dùng" : "Thêm Mới Người Dùng" %></title>
    
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
    <div class="container mt-5">
        <div class="card shadow">
            <div class="card-header bg-primary text-white">
                <h3 class="mb-0"><%= (action != null && action.equals("edit")) ? "Sửa Người Dùng" : "Thêm Mới Người Dùng" %></h3>
            </div>
            <div class="card-body">
                <form action="NvvNguoiDungServlet" method="post">
                    <input type="hidden" name="action" value="<%= action %>">
                    <input type="hidden" name="id" value="<%= id %>">

                    <div class="mb-3">
                        <label class="form-label">Họ Tên:</label>
                        <input type="text" class="form-control" name="hoTen" value="<%= hoTen %>" required>
                    </div>

                    <div class="mb-3">
                        <label class="form-label">Email:</label>
                        <input type="email" class="form-control" name="email" value="<%= email %>" required>
                    </div>

                    <div class="mb-3">
                        <label class="form-label">Vai Trò:</label>
                        <select class="form-select" name="vaiTro">
                            <option value="admin" <%= "admin".equals(vaiTro) ? "selected" : "" %>>Admin</option>
                            <option value="user" <%= "user".equals(vaiTro) ? "selected" : "" %>>User</option>
                        </select>
                    </div>

                    <button type="submit" class="btn btn-success">💾 Lưu</button>
                    <a href="nvv_nguoidung_list.jsp" class="btn btn-secondary">🔙 Quay lại</a>
                </form>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
