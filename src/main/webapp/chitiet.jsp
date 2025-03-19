<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Chi Tiết Sản Phẩm</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
    <div class="container mt-5">
        <div class="row">
            <div class="col-md-6">
                <% 
                    String productId = request.getParameter("id");
                    if (productId != null) {
                        try {
                            Class.forName("com.mysql.cj.jdbc.Driver");
                            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/quanlytrangthietbimamnon_nvv2210900081", "root", "password");
                            String query = "SELECT * FROM NvvSanPham WHERE id = ?";
                            PreparedStatement pstmt = conn.prepareStatement(query);
                            pstmt.setInt(1, Integer.parseInt(productId));
                            ResultSet rs = pstmt.executeQuery();
                            if (rs.next()) {
                %>
                <img src="images/<%= rs.getString("hinhAnh") %>" class="img-fluid" alt="<%= rs.getString("tenSanPham") %>">
            </div>
            <div class="col-md-6">
                <h2><%= rs.getString("tenSanPham") %></h2>
                <p><strong>Giá:</strong> <%= rs.getString("gia") %> đ</p>
                <p><strong>Mô tả:</strong> <%= rs.getString("moTa") %></p>
                <a href="muahang.jsp?id=<%= productId %>" class="btn btn-success">Mua ngay</a>
                <% 
                            } else {
                                out.println("<p class='text-danger'>Không tìm thấy sản phẩm!</p>");
                            }
                            conn.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                            out.println("<p class='text-danger'>Lỗi khi lấy dữ liệu!</p>");
                        }
                    } else {
                        out.println("<p class='text-danger'>ID sản phẩm không hợp lệ!</p>");
                    }
                %>
            </div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
