<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page import="model.NvvBaoCao" %>
<%
    NvvBaoCao baoCao = (NvvBaoCao) request.getAttribute("baoCao");
    boolean isEdit = (baoCao != null);
%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title><%= isEdit ? "Chỉnh sửa báo cáo" : "Thêm báo cáo mới" %></title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-4">
        <h2 class="mb-4"><%= isEdit ? "Chỉnh sửa báo cáo" : "Thêm báo cáo mới" %></h2>
        
        <form action="NvvBaoCaoServlet" method="post">
            <input type="hidden" name="action" value="<%= isEdit ? "update" : "insert" %>">
            <% if (isEdit) { %>
                <input type="hidden" name="maBaoCao" value="<%= baoCao.getMaBaoCao() %>">
            <% } %>

            <div class="mb-3">
                <label for="tieuDe" class="form-label">Tiêu đề:</label>
                <input type="text" class="form-control" id="tieuDe" name="tieuDe" required 
                       value="<%= isEdit ? baoCao.getTieuDe() : "" %>">
            </div>

            <div class="mb-3">
                <label for="noiDung" class="form-label">Nội dung:</label>
                <textarea class="form-control" id="noiDung" name="noiDung" rows="5" required><%= isEdit ? baoCao.getNoiDung() : "" %></textarea>
            </div>

            <div class="mb-3">
                <label for="maNguoiDung" class="form-label">Mã người dùng:</label>
                <input type="number" class="form-control" id="maNguoiDung" name="maNguoiDung" required 
                       value="<%= isEdit ? baoCao.getMaNguoiDung() : "" %>">
            </div>

            <button type="submit" class="btn btn-success"><%= isEdit ? "Cập nhật" : "Lưu báo cáo" %></button>
            <a href="NvvBaoCaoServlet?action=list" class="btn btn-secondary">Hủy</a>
        </form>
    </div>
</body>
</html>
