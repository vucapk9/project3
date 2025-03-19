<%@ page contentType="text/html; charset=UTF-8" %>
<%
    String action = request.getParameter("action");
    String tenDanhMuc = "";
    String id = request.getParameter("id");
    if (id != null) {
        tenDanhMuc = "Tên danh mục mẫu"; // Lấy từ CSDL nếu sửa
    }
%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title><%= (action != null && action.equals("edit")) ? "Sửa Danh Mục" : "Thêm Mới Danh Mục" %></title>
    
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <style>
        body {
            background-color: #f8f9fa;
        }
        .form-container {
            max-width: 500px;
            margin: auto;
            margin-top: 50px;
            padding: 20px;
            background: white;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
    </style>
</head>
<body>

<div class="container">
    <div class="form-container">
        <h3 class="text-center text-primary">
            <%= (action != null && action.equals("edit")) ? "✏ Sửa Danh Mục" : "➕ Thêm Mới Danh Mục" %>
        </h3>
        <form action="NvvDanhMucServlet" method="post">
            <input type="hidden" name="action" value="<%= action %>">
            <input type="hidden" name="id" value="<%= id %>">

            <div class="mb-3">
                <label class="form-label">Tên Danh Mục:</label>
                <input type="text" class="form-control" name="tenDanhMuc" value="<%= tenDanhMuc %>" required>
            </div>

            <div class="d-flex justify-content-between">
                <button type="submit" class="btn btn-success">💾 Lưu</button>
                <a href="nvv_danhmuc_list.jsp" class="btn btn-secondary">🔙 Quay lại</a>
            </div>
        </form>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
