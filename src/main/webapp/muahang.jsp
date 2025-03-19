<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page import="javax.servlet.http.*" %>
<%@ page import="javax.servlet.*" %>

<%
    String id = request.getParameter("id");
    if (id == null || id.isEmpty()) {
        response.sendRedirect("home.jsp");
        return;
    }

    // Kết nối cơ sở dữ liệu
    String jdbcURL = "jdbc:mysql://localhost:3306/your_database";
    String dbUser = "root";
    String dbPassword = "password";

    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    String tenSanPham = "";
    String giaSanPham = "";
    String hinhAnh = "";

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
        String sql = "SELECT ten, gia, hinhanh FROM nvv_sanpham WHERE id = ?";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, id);
        rs = stmt.executeQuery();

        if (rs.next()) {
            tenSanPham = rs.getString("ten");
            giaSanPham = rs.getString("gia");
            hinhAnh = rs.getString("hinhanh");
        } else {
            response.sendRedirect("home.jsp");
            return;
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        if (rs != null) rs.close();
        if (stmt != null) stmt.close();
        if (conn != null) conn.close();
    }
%>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Mua Hàng - <%= tenSanPham %></title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<!-- Header -->
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <div class="container">
        <a class="navbar-brand" href="home.jsp">🏠 Quản Lý Thiết Bị</a>
    </div>
</nav>

<div class="container mt-5">
    <h2 class="text-center mb-4">🛒 Xác Nhận Đơn Hàng</h2>

    <div class="row">
        <!-- Thông tin sản phẩm -->
        <div class="col-md-6">
            <div class="card shadow">
                <img src="<%= hinhAnh %>" class="card-img-top" alt="<%= tenSanPham %>">
                <div class="card-body">
                    <h4 class="card-title"><%= tenSanPham %></h4>
                    <p class="text-danger fs-5"><strong>Giá: <%= giaSanPham %> đ</strong></p>
                </div>
            </div>
        </div>

        <!-- Form nhập thông tin -->
        <div class="col-md-6">
            <div class="card shadow p-4">
                <h5>📋 Nhập Thông Tin Giao Hàng</h5>
                <form action="NvvDatHangServlet" method="post">
                    <input type="hidden" name="idSanPham" value="<%= id %>">
                    <input type="hidden" name="tenSanPham" value="<%= tenSanPham %>">
                    <input type="hidden" name="giaSanPham" value="<%= giaSanPham %>">

                    <div class="mb-3">
                        <label class="form-label">👤 Họ và Tên</label>
                        <input type="text" name="hoTen" class="form-control" required>
                    </div>

                    <div class="mb-3">
                        <label class="form-label">📞 Số Điện Thoại</label>
                        <input type="text" name="soDienThoai" class="form-control" required>
                    </div>

                    <div class="mb-3">
                        <label class="form-label">📍 Địa Chỉ Nhận Hàng</label>
                        <input type="text" name="diaChi" class="form-control" required>
                    </div>

                    <button type="submit" class="btn btn-success w-100">
                        🛍 Đặt Hàng Ngay
                    </button>
                </form>
            </div>
        </div>
    </div>
</div>

<!-- Footer -->
<footer class="mt-5 bg-primary text-white text-center py-3">
    © 2025 Quản Lý Thiết Bị - Bản Quyền Thuộc Về Bạn
</footer>

</body>
</html>
