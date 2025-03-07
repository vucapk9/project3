<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="dao.NvvNhaCungCapdao" %>
<%@ page import="controller.NvvNhaCungCap" %>

<%
    // Lấy danh sách nhà cung cấp từ database
    NvvNhaCungCapdao nhaCungCapDao = new NvvNhaCungCapdao();
    List<NvvNhaCungCap> danhSachNhaCungCap = nhaCungCapDao.getAll();
%>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Quản Lý Nhà Cung Cấp</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
    
<div class="container mt-5">
    <h2 class="mb-4 text-center">Danh Sách Nhà Cung Cấp</h2>

    <!-- Nút thêm nhà cung cấp -->
    <button class="btn btn-success mb-3" data-bs-toggle="modal" data-bs-target="#modalThemNCC">Thêm Nhà Cung Cấp</button>

    <!-- Bảng hiển thị danh sách nhà cung cấp -->
    <table class="table table-bordered">
        <thead class="table-dark">
            <tr>
                <th>Mã NCC</th>
                <th>Tên Nhà Cung Cấp</th>
                <th>Địa Chỉ</th>
                <th>Số Điện Thoại</th>
                <th>Hành động</th>
            </tr>
        </thead>
        <tbody>
            <% for (NvvNhaCungCap ncc : danhSachNhaCungCap) { %>
                
            <% } %>
        </tbody>
    </table>
</div>

<!-- Modal Thêm Nhà Cung Cấp -->
<div class="modal fade" id="modalThemNCC" tabindex="-1" aria-labelledby="modalThemNCCLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="modalThemNCCLabel">Thêm Nhà Cung Cấp</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form action="ThemNhaCungCapServlet" method="post">
                    <div class="mb-3">
                        <label class="form-label">Tên Nhà Cung Cấp</label>
                        <input type="text" class="form-control" name="tenNhaCungCap" required>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Địa Chỉ</label>
                        <input type="text" class="form-control" name="diaChi" required>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Số Điện Thoại</label>
                        <input type="text" class="form-control" name="soDienThoai" required>
                    </div>
                    <button type="submit" class="btn btn-primary w-100">Thêm</button>
                </form>
            </div>
        </div>
    </div>
</div>

</body>
</html>
