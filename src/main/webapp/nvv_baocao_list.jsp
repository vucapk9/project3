<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="model.NvvBaoCao" %>
<%
    List<NvvBaoCao> listBaoCao = (List<NvvBaoCao>) request.getAttribute("listBaoCao");
%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Danh sách báo cáo</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-4">
        <h2 class="mb-4">Danh sách báo cáo</h2>
        <a href="NvvBaoCaoServlet?action=new" class="btn btn-success mb-3">Thêm Báo Cáo</a>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>#</th>
                    <th>Tiêu đề</th>
                    <th>Nội dung</th>
                    <th>Ngày tạo</th>
                    <th>Mã người dùng</th>
                    <th>Hành động</th>
                </tr>
            </thead>
            <tbody>
                <% if (listBaoCao != null) { 
                    for (NvvBaoCao baoCao : listBaoCao) { %>
                        <tr>
                            <td><%= baoCao.getMaBaoCao() %></td>
                            <td><%= baoCao.getTieuDe() %></td>
                            <td><%= baoCao.getNoiDung() %></td>
                           
                            
                            <td>
                                <a href="NvvBaoCaoServlet?action=edit&id=<%= baoCao.getMaBaoCao() %>" class="btn btn-primary btn-sm">Sửa</a>
                                <a href="NvvBaoCaoServlet?action=delete&id=<%= baoCao.getMaBaoCao() %>" class="btn btn-danger btn-sm" onclick="return confirm('Bạn có chắc chắn muốn xóa?');">Xóa</a>
                            </td>
                        </tr>
                    <% }
                } else { %>
                    <tr>
                        <td colspan="6" class="text-center">Không có báo cáo nào.</td>
                    </tr>
                <% } %>
            </tbody>
        </table>
    </div>
</body>
</html>
s