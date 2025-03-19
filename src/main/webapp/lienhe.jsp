<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Liên Hệ</title>
    
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="styles.css">
</head>
<body class="bg-light">
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card shadow">
                    <div class="card-header bg-primary text-white text-center">
                        <h3>📩 Liên Hệ Chúng Tôi</h3>
                    </div>
                    <div class="card-body">
                        <%-- Hiển thị thông báo lỗi hoặc thành công --%>
                        <% String error = request.getParameter("error"); %>
                        <% if (error != null) { %>
                            <div class="alert alert-danger"><%= error %></div>
                        <% } %>
                        
                        <% String success = request.getParameter("success"); %>
                        <% if (success != null) { %>
                            <div class="alert alert-success">✅ Gửi liên hệ thành công!</div>
                        <% } %>

                        <form action="NvvLienHeServlet" method="post">
                            <div class="mb-3">
                                <label class="form-label">Họ và Tên:</label>
                                <input type="text" class="form-control" name="hoTen" required>
                            </div>
                            
                            <div class="mb-3">
                                <label class="form-label">Email:</label>
                                <input type="email" class="form-control" name="email" required>
                            </div>
                            
                            <div class="mb-3">
                                <label class="form-label">Số Điện Thoại:</label>
                                <input type="text" class="form-control" name="soDienThoai" required>
                            </div>
                            
                            <div class="mb-3">
                                <label class="form-label">Nội Dung:</label>
                                <textarea class="form-control" name="noiDung" rows="4" required></textarea>
                            </div>

                            <button type="submit" class="btn btn-success w-100">📨 Gửi Liên Hệ</button>
                        </form>
                    </div>
                    <div class="card-footer text-center">
                        <p>Kết nối với chúng tôi:</p>
                        <a href="https://facebook.com" class="btn btn-primary me-2">📘 Facebook</a>
                        <a href="https://instagram.com" class="btn btn-danger me-2">📸 Instagram</a>
                        <a href="https://tiktok.com" class="btn btn-dark">🎵 TikTok</a>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
