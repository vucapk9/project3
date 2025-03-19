<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Trang Chủ - Quản Lý Thiết Bị</title>
    
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    
    <style>
        .banner {
            background: url('https://source.unsplash.com/1600x500/?technology,education') no-repeat center center;
            background-size: cover;
            height: 400px;
            color: white;
            display: flex;
            align-items: center;
            justify-content: center;
            text-shadow: 2px 2px 8px rgba(0,0,0,0.5);
        }
        .card:hover {
            transform: scale(1.05);
            transition: 0.3s ease-in-out;
        }
    </style>
</head>
<body class="bg-light">

    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
        <div class="container">
            <a class="navbar-brand" href="home.jsp">🏠 Quản Lý Thiết Bị</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item"><a class="nav-link" href="nvv_thietbi_list.jsp">Thiết Bị</a></li>
                    <li class="nav-item"><a class="nav-link" href="nvv_danhmuc_list.jsp">Danh Mục</a></li>
                    <li class="nav-item"><a class="nav-link" href="nvv_nguoidung_list.jsp">Người Dùng</a></li>
                </ul>
            </div>
        </div>
    </nav>

    <!-- Banner -->
    <header class="banner">
        <div class="container text-center">
            <h1>Chào Mừng Đến Hệ Thống Quản Lý Thiết Bị</h1>
            <p>Quản lý thiết bị một cách dễ dàng và hiệu quả!</p>
            <a href="nvv_thietbi_list.jsp" class="btn btn-warning btn-lg">📂 Quản Lý Thiết Bị</a>
        </div>
    </header>

    <!-- Danh sách các chức năng -->
    <div class="container mt-5">
        <div class="row">
            <!-- Quản lý thiết bị -->
            <div class="col-md-4">
                <div class="card shadow">
                    <div class="card-body text-center">
                        <h5 class="card-title">📦 Quản Lý Thiết Bị</h5>
                        <p class="card-text">Thêm, sửa, xóa và theo dõi thiết bị.</p>
                        <a href="nvv_thietbi_list.jsp" class="btn btn-primary">Xem Chi Tiết</a>
                    </div>
                </div>
            </div>

            <!-- Quản lý danh mục -->
            <div class="col-md-4">
                <div class="card shadow">
                    <div class="card-body text-center">
                        <h5 class="card-title">📂 Quản Lý Danh Mục</h5>
                        <p class="card-text">Phân loại thiết bị theo danh mục.</p>
                        <a href="nvv_danhmuc_list.jsp" class="btn btn-success">Xem Chi Tiết</a>
                    </div>
                </div>
            </div>

            <!-- Quản lý người dùng -->
            <div class="col-md-4">
                <div class="card shadow">
                    <div class="card-body text-center">
                        <h5 class="card-title">👤 Quản Lý Người Dùng</h5>
                        <p class="card-text">Thêm, sửa, xóa thông tin người dùng.</p>
                        <a href="nvv_nguoidung_list.jsp" class="btn btn-danger">Xem Chi Tiết</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
 <!-- Danh sách sản phẩm -->
<div class="container mt-5">
    <h3 class="text-center mb-4">🛒 Sản Phẩm Nổi Bật</h3>
    <div class="row">
        <!-- Sản phẩm 1 -->
        <div class="col-md-4 mb-4">
            <div class="product-card">
                <img src="images/ghe.png" alt="Ghế nhựa">
                <h5 class="mt-2">Ghế nhựa màu xanh</h5>
                <p><strong>350.000đ</strong></p>
                <div class="btn-group">
                    <a href="chitiet.jsp?id=1" class="btn btn-info btn-custom">Chi tiết</a>
                    <a href="muahang.jsp?id=1" class="btn btn-success btn-custom">Mua hàng</a>
                </div>
            </div>
        </div>
        
        <!-- Sản phẩm 2 -->
        <div class="col-md-4 mb-4">
            <div class="product-card">
                <img src="images/ban.png" alt="Bàn nhựa">
                <h5 class="mt-2">Bàn nhựa đúc hình bán nguyệt</h5>
                <p><strong>1.050.000đ</strong></p>
                <div class="btn-group">
                    <a href="chitiet.jsp?id=2" class="btn btn-info btn-custom">Chi tiết</a>
                    <a href="muahang.jsp?id=2" class="btn btn-success btn-custom">Mua hàng</a>
                </div>
            </div>
        </div>
        
        <!-- Sản phẩm 3 -->
        <div class="col-md-4 mb-4">
            <div class="product-card">
                <img src="images/tu.png" alt="Tủ đồ chơi">
                <h5 class="mt-2">Tủ đựng đồ chơi trẻ em</h5>
                <p><strong>2.500.000đ</strong></p>
                <div class="btn-group">
                    <a href="chitiet.jsp?id=3" class="btn btn-info btn-custom">Chi tiết</a>
                    <a href="muahang.jsp?id=3" class="btn btn-success btn-custom">Mua hàng</a>
                </div>
            </div>
        </div>

        <!-- Sản phẩm 4 -->
        <div class="col-md-4 mb-4">
            <div class="product-card">
                <img src="images/cau-truot.png" alt="Cầu trượt">
                <h5 class="mt-2">Cầu trượt mini cho bé</h5>
                <p><strong>1.800.000đ</strong></p>
                <div class="btn-group">
                    <a href="chitiet.jsp?id=4" class="btn btn-info btn-custom">Chi tiết</a>
                    <a href="muahang.jsp?id=4" class="btn btn-success btn-custom">Mua hàng</a>
                </div>
            </div>
        </div>

        <!-- Sản phẩm 5 -->
        <div class="col-md-4 mb-4">
            <div class="product-card">
                <img src="images/bong-ro.png" alt="Bộ bóng rổ">
                <h5 class="mt-2">Bộ bóng rổ trẻ em</h5>
                <p><strong>950.000đ</strong></p>
                <div class="btn-group">
                    <a href="chitiet.jsp?id=5" class="btn btn-info btn-custom">Chi tiết</a>
                    <a href="muahang.jsp?id=5" class="btn btn-success btn-custom">Mua hàng</a>
                </div>
            </div>
        </div>

        <!-- Sản phẩm 6 -->
        <div class="col-md-4 mb-4">
            <div class="product-card">
                <img src="images/xich-du.png" alt="Xích đu">
                <h5 class="mt-2">Xích đu ngoài trời</h5>
                <p><strong>3.200.000đ</strong></p>
                <div class="btn-group">
                    <a href="chitiet.jsp?id=6" class="btn btn-info btn-custom">Chi tiết</a>
                    <a href="muahang.jsp?id=6" class="btn btn-success btn-custom">Mua hàng</a>
                </div>
            </div>
        </div>

        <!-- Sản phẩm 7 -->
        <div class="col-md-4 mb-4">
            <div class="product-card">
                <img src="images/xe-luon.png" alt="Xe lượn">
                <h5 class="mt-2">Xe lượn siêu tốc cho bé</h5>
                <p><strong>5.500.000đ</strong></p>
                <div class="btn-group">
                    <a href="chitiet.jsp?id=7" class="btn btn-info btn-custom">Chi tiết</a>
                    <a href="muahang.jsp?id=7" class="btn btn-success btn-custom">Mua hàng</a>
                </div>
            </div>
        </div>

        <!-- Sản phẩm 8 -->
        <div class="col-md-4 mb-4">
            <div class="product-card">
                <img src="images/nha-bong.png" alt="Nhà bóng">
                <h5 class="mt-2">Nhà bóng mini</h5>
                <p><strong>1.750.000đ</strong></p>
                <div class="btn-group">
                    <a href="chitiet.jsp?id=8" class="btn btn-info btn-custom">Chi tiết</a>
                    <a href="muahang.jsp?id=8" class="btn btn-success btn-custom">Mua hàng</a>
                </div>
            </div>
        </div>

        <!-- Sản phẩm 9 -->
        <div class="col-md-4 mb-4">
            <div class="product-card">
                <img src="images/be-boi.png" alt="Bể bơi hơi">
                <h5 class="mt-2">Bể bơi hơi cho bé</h5>
                <p><strong>2.200.000đ</strong></p>
                <div class="btn-group">
                    <a href="chitiet.jsp?id=9" class="btn btn-info btn-custom">Chi tiết</a>
                    <a href="muahang.jsp?id=9" class="btn btn-success btn-custom">Mua hàng</a>
                </div>
            </div>
        </div>

        <!-- Sản phẩm 10 -->
        <div class="col-md-4 mb-4">
            <div class="product-card">
                <img src="images/lap-rap.png" alt="Bộ lắp ráp">
                <h5 class="mt-2">Bộ lắp ráp sáng tạo</h5>
                <p><strong>850.000đ</strong></p>
                <div class="btn-group">
                    <a href="chitiet.jsp?id=10" class="btn btn-info btn-custom">Chi tiết</a>
                    <a href="muahang.jsp?id=10" class="btn btn-success btn-custom">Mua hàng</a>
                </div>
            </div>
        </div>
    </div>
</div>


<!-- Form Liên Hệ Lại Khách Hàng -->
<section class="mt-5">
    <div class="container">
        <h3 class="text-center mb-4">📧 Liên Hệ Lại Khách Hàng</h3>
        <p class="text-center">Nếu bạn đã mua hàng và cần hỗ trợ, hãy điền thông tin bên dưới, chúng tôi sẽ phản hồi sớm nhất.</p>

        <div class="row justify-content-center">
            <div class="col-md-8">
                <div class="card shadow">
                    <div class="card-body">
                        <form action="NvvLienHeServlet" method="post">
                            <!-- Tên khách hàng -->
                            <div class="mb-3">
                                <label class="form-label"><i class="fas fa-user"></i> Họ và Tên</label>
                                <input type="text" class="form-control" name="hoTen" placeholder="Nhập họ và tên" required>
                            </div>

                            <!-- Email -->
                            <div class="mb-3">
                                <label class="form-label"><i class="fas fa-envelope"></i> Email</label>
                                <input type="email" class="form-control" name="email" placeholder="Nhập email của bạn" required>
                            </div>

                            <!-- Số điện thoại -->
                            <div class="mb-3">
                                <label class="form-label"><i class="fas fa-phone"></i> Số Điện Thoại</label>
                                <input type="text" class="form-control" name="soDienThoai" placeholder="Nhập số điện thoại" required>
                            </div>

                            <!-- Nội dung phản hồi -->
                            <div class="mb-3">
                                <label class="form-label"><i class="fas fa-comment"></i> Nội Dung Phản Hồi</label>
                                <textarea class="form-control" name="noiDung" rows="4" placeholder="Nhập nội dung cần hỗ trợ" required></textarea>
                            </div>

                            <!-- Nút gửi -->
                            <div class="text-center">
                                <button type="submit" class="btn btn-success btn-lg">
                                    <i class="fas fa-paper-plane"></i> Gửi Yêu Cầu
                                </button>
                            </div>
                        </form>
                         
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
  <!-- Phần Liên Hệ -->
<section class="mt-5">
    <div class="container text-center">
        <h3 class="mb-4">📞 Liên Hệ Với Chúng Tôi</h3>
        <p>Theo dõi chúng tôi trên các nền tảng mạng xã hội!</p>
        
        <!-- Các Nút MXH -->
        <div class="d-flex justify-content-center gap-3 flex-wrap">
            <!-- Facebook -->
            <a href="https://www.facebook.com" target="_blank" class="btn btn-primary btn-lg">
                <i class="fab fa-facebook-f"></i> Facebook
            </a>

            <!-- Instagram -->
            <a href="https://www.instagram.com" target="_blank" class="btn btn-danger btn-lg">
                <i class="fab fa-instagram"></i> Instagram
            </a>

            <!-- TikTok -->
            <a href="https://www.tiktok.com" target="_blank" class="btn btn-dark btn-lg">
                <i class="fab fa-tiktok"></i> TikTok
            </a>

            <!-- YouTube -->
            <a href="https://www.youtube.com" target="_blank" class="btn btn-danger btn-lg">
                <i class="fab fa-youtube"></i> YouTube
            </a>

            <!-- Email -->
            <a href="mailto:contact@example.com" class="btn btn-success btn-lg">
                <i class="fas fa-envelope"></i> Gửi Email
            </a>
        </div>
    </div>
</section>

<!-- Thư viện Font Awesome để hiển thị icon -->
<script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>

    <!-- Footer -->
    <footer class="mt-5 bg-primary text-white text-center py-3">
        © 2025 Quản Lý Thiết Bị - Bản Quyền Thuộc Về Bạn
    </footer>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
