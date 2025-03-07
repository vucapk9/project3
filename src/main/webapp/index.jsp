<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.NvvNguoiDung" %>
<%
    // Kiểm tra xem người dùng đã đăng nhập hay chưa
    NvvNguoiDung user = (NvvNguoiDung) session.getAttribute("user");
%>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Trang Chủ - Quản Lý Thiết Bị</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    <style>
        body { font-family: Arial, sans-serif; }
        .banner {
            background: url('banner.jpg') no-repeat center center;
            background-size: cover;
            color: white;
            text-align: center;
            padding: 100px 20px;
        }
    </style>
</head>
<body>

<!-- Header -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="index.jsp">QL Thiết Bị</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item"><a class="nav-link" href="index.jsp">Trang Chủ</a></li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="danhmucDropdown" role="button" data-bs-toggle="dropdown">
                        Danh mục dự án
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="thietbi.jsp">Thiết bị mầm non</a></li>
                        <li><a class="dropdown-item" href="dochoi.jsp">Đồ chơi giáo dục</a></li>
                        <li><a class="dropdown-item" href="noithat.jsp">Nội thất lớp học</a></li>
                        <li><a class="dropdown-item" href="sanchoi.jsp">Sân chơi ngoài trời</a></li>
                    </ul>
                </li>

                <% if (user == null) { %>
                    <!-- Nếu chưa đăng nhập, hiển thị đăng nhập và đăng ký -->
                    <li class="nav-item"><a class="nav-link" href="login.jsp">Đăng Nhập</a></li>
                    <li class="nav-item"><a class="nav-link" href="register.jsp">Đăng Ký</a></li>
                <% } else { %>
                    <!-- Nếu đã đăng nhập, hiển thị tên và nút đăng xuất -->
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-bs-toggle="dropdown">
                           
                        </a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="profile.jsp">Thông tin cá nhân</a></li>
                            <li><a class="dropdown-item text-danger" href="logout.jsp">Đăng xuất</a></li>
                        </ul>
                    </li>
                <% } %>

                <li class="nav-item"><a class="nav-link" href="contact.jsp">Liên Hệ</a></li>
            </ul>
        </div>
    </div>
</nav>
 <!-- Bộ lọc và tìm kiếm -->
        <div class="row mb-3">
            <div class="col-md-4">
                <input type="text" class="form-control" placeholder="Tìm kiếm thiết bị...">
            </div>
            <div class="col-md-3">
                <select class="form-control">
                    <option>Chọn danh mục</option>
                    <option>Đồ chơi</option>
                    <option>Thiết bị mầm non</option>
                    <option>Khác</option>
                </select>
            </div>
            <div class="col-md-3">
                <select class="form-control">
                    <option>Sắp xếp theo</option>
                    <option>Giá tăng dần</option>
                    <option>Giá giảm dần</option>
                    <option>Mới nhất</option>
                </select>
            </div>
            <div class="col-md-2">
                <button class="btn btn-primary w-100">Lọc</button>
            </div>
        </div>
           <!-- Danh sách thiết bị -->
        <table class="table table-bordered">
            <thead class="table-dark">
                <tr>
                    <th>Hình ảnh</th>
                    <th>Tên thiết bị</th>
                    <th>Giá</th>
                    <th>Số lượng</th>
                    <th>Trạng thái</th>
                    <th>Hành động</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><img src="thietbi1.jpg" alt="Thiết bị 1" width="50"></td>
                    <td>Bộ cầu trượt mầm non</td>
                    <td>5,000,000đ</td>
                    <td>10</td>
                    <td><span class="badge bg-success">Còn hàng</span></td>
                    <td>
                        <button class="btn btn-warning btn-sm">Sửa</button>
                        <button class="btn btn-danger btn-sm">Xóa</button>
                    </td>
                </tr>
                <tr>
                    <td><img src="thietbi.jpg" alt="Thiết bị 2" width="50"></td>
                    <td>Nhà liên hoàn mini</td>
                    <td>12,000,000đ</td>
                    <td>5</td>
                    <td><span class="badge bg-warning">Sắp hết</span></td>
                    <td>
                        <button class="btn btn-warning btn-sm">Sửa</button>
                        <button class="btn btn-danger btn-sm">Xóa</button>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
</body>
    </div>
</nav>
<!-- Banner -->
<div class="banner">
    <h1>Hệ Thống Quản Lý Thiết Bị Mầm Non</h1>
    <p>Giúp bạn quản lý thiết bị nhanh chóng và hiệu quả</p>
</div>
<!-- Danh sách chức năng -->
<div class="container mt-5">
    <h2 class="text-center mb-4">Chức Năng Chính</h2>
    <div class="row">
        <div class="col-md-4">
            <div class="card feature-card">
                <div class="card-body text-center">
                    <h5 class="card-title">Quản lý thiết bị</h5>
                    <p class="card-text">Thêm, sửa, xóa và theo dõi tình trạng thiết bị.</p>
                    <a href="thietbi.jsp" class="btn btn-primary">Xem chi tiết</a>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card feature-card">
                <div class="card-body text-center">
                    <h5 class="card-title">Nhà cung cấp</h5>
                    <p class="card-text">Quản lý danh sách các nhà cung cấp thiết bị.</p>
                    <a href="nhacungcap.jsp" class="btn btn-primary">Xem chi tiết</a>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card feature-card">
                <div class="card-body text-center">
                    <h5 class="card-title">Báo cáo và Đề xuất</h5>
                    <p class="card-text">Theo dõi báo cáo và đề xuất thiết bị mới.</p>
                    <a href="baocao.jsp" class="btn btn-primary">Xem chi tiết</a>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Footer -->
<footer class="bg-dark text-white text-center py-3 mt-4">
    <p>&copy; 2025 Hệ Thống Quản Lý Thiết Bị. All Rights Reserved.</p>
</footer>

</body>
</html>
