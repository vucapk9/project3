<%@ page contentType="text/html; charset=UTF-8" %>
<%
    String action = request.getParameter("action");
    String id = request.getParameter("id");
    String tenThietBi = "", moTa = "", tieuChuan = "", tinhTrang = "";
    int soLuong = 1;

    if (id != null) {
        tenThietBi = "Tên thiết bị mẫu"; // Lấy từ DB nếu sửa
        moTa = "Mô tả thiết bị";
        tieuChuan = "Tiêu chuẩn ABC";
        tinhTrang = "Mới";
        soLuong = 10;
    }
%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title><%= (action != null && action.equals("edit")) ? "Sửa Thiết Bị" : "Thêm Mới Thiết Bị" %></title>
    
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
    <div class="container mt-5">
        <div class="card shadow">
            <div class="card-header bg-primary text-white">
                <h3 class="mb-0"><%= (action != null && action.equals("edit")) ? "Sửa Thiết Bị" : "Thêm Mới Thiết Bị" %></h3>
            </div>
            <div class="card-body">
                <form action="NvvThietBiServlet" method="post">
                    <input type="hidden" name="action" value="<%= action %>">
                    <input type="hidden" name="id" value="<%= id %>">

                    <div class="mb-3">
                        <label class="form-label">Tên Thiết Bị:</label>
                        <input type="text" class="form-control" name="tenThietBi" value="<%= tenThietBi %>" required>
                    </div>

                    <div class="mb-3">
                        <label class="form-label">Mô Tả:</label>
                        <textarea class="form-control" name="moTa" rows="3"><%= moTa %></textarea>
                    </div>

                    <div class="mb-3">
                        <label class="form-label">Tiêu Chuẩn:</label>
                        <input type="text" class="form-control" name="tieuChuan" value="<%= tieuChuan %>">
                    </div>

                    <div class="mb-3">
                        <label class="form-label">Tình Trạng:</label>
                        <input type="text" class="form-control" name="tinhTrang" value="<%= tinhTrang %>">
                    </div>

                    <div class="mb-3">
                        <label class="form-label">Số Lượng:</label>
                        <input type="number" class="form-control" name="soLuong" value="<%= soLuong %>" min="1">
                    </div>

                    <button type="submit" class="btn btn-success">💾 Lưu</button>
                    <a href="nvv_thietbi_list.jsp" class="btn btn-secondary">🔙 Quay lại</a>
                </form>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
