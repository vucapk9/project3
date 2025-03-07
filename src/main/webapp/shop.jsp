<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="model.NvvThietBi" %>
<%@ page import="controller.NvvThietBiRepository" %>

<%
    NvvThietBiRepository repo = new NvvThietBiRepository();
    List<NvvThietBi> list = repo.getAll();
%>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quản lý Thiết Bị</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-4">
        <h2 class="text-center">Danh sách mua hàng</h2>
        <div class="row">
           
             
            <!-- Mẫu sản phẩm -->
            <div class="col-md-4 mb-4">
                <div class="card">
                    <img src="img/thietbi1.jpg" class="card-img-top" alt="Thiết bị">
                    <div class="card-body">
                        <h5 class="card-title">Bàn nhựa gấp chân sắt</h5>
                        <p class="card-text">Giá: <strong>215.000đ</strong></p>
                        <button class="btn btn-primary" onclick="xemChiTiet('Bàn nhựa gấp chân sắt', '215.000đ')">Chi tiết</button>
                        <button class="btn btn-success" onclick="muaHang()">Mua hàng</button>
                    </div>
                </div>
            </div>
            
            <!-- Thêm nhiều sản phẩm tương tự -->
            <div class="col-md-4 mb-4">
                <div class="card">
                    <img src="img/thietbi2.jpg" class="card-img-top" alt="Thiết bị">
                    <div class="card-body">
                        <h5 class="card-title">Bàn mặt gỗ gấp chân sắt</h5>
                        <p class="card-text">Giá: <strong>345.000đ</strong></p>
                        <button class="btn btn-primary" onclick="xemChiTiet('Bàn mặt gỗ gấp chân sắt', '345.000đ')">Chi tiết</button>
                        <button class="btn btn-success" onclick="muaHang()">Mua hàng</button>
                    </div>
                </div>
            </div>
            
            <div class="col-md-4 mb-4">
                <div class="card">
                    <img src="img/thietbi3.jpg" class="card-img-top" alt="Thiết bị">
                    <div class="card-body">
                        <h5 class="card-title">Bàn nhựa đúc hình chữ nhật</h5>
                        <p class="card-text">Giá: <strong>950.000đ</strong></p>
                        <button class="btn btn-primary" onclick="xemChiTiet('Bàn nhựa đúc hình chữ nhật', '950.000đ')">Chi tiết</button>
                        <button class="btn btn-success" onclick="muaHang()">Mua hàng</button>
                    </div>
                </div>
            </div>
            
            <div class="col-md-4 mb-4">
                <div class="card">
                    <img src="img/thietbi4.jpg" class="card-img-top" alt="Thiết bị">
                    <div class="card-body">
                        <h5 class="card-title">Giường lưới mầm non</h5>
                        <p class="card-text">Giá: <strong>155.000đ</strong></p>
                        <button class="btn btn-primary" onclick="xemChiTiet('Giường lưới mầm non', '155.000đ')">Chi tiết</button>
                        <button class="btn btn-success" onclick="muaHang()">Mua hàng</button>
                    </div>
                </div>
            </div>
            
            <div class="col-md-4 mb-4">
                <div class="card">
                    <img src="img/thietbi5.jpg" class="card-img-top" alt="Thiết bị">
                    <div class="card-body">
                        <h5 class="card-title">Bàn ghế tròn mầm non</h5>
                        <p class="card-text">Giá: <strong>580.000đ</strong></p>
                        <button class="btn btn-primary" onclick="xemChiTiet('Bàn ghế tròn mầm non', '580.000đ')">Chi tiết</button>
                        <button class="btn btn-success" onclick="muaHang()">Mua hàng</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
        </div>
    </div>

    <script>
        function xemChiTiet() {
            alert("Xem chi tiết sản phẩm");
        }
        function muaHang() {
            alert("Sản phẩm đã được thêm vào giỏ hàng");
        }
    </script>
</body>
</html>


<!-- Modal Sửa -->
<div class="modal fade" id="editModal">
    <div class="modal-dialog">
        <form id="editForm">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Sửa Thiết Bị</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                </div>
                <div class="modal-body">
                    <input type="hidden" name="maThietBi" id="editId">
                    <input type="text" class="form-control mb-2" name="tenThietBi" id="editTen">
                    <input type="text" class="form-control mb-2" name="moTa" id="editMoTa">
                    <input type="text" class="form-control mb-2" name="tieuChuan" id="editTieuChuan">
                    <input type="number" class="form-control mb-2" name="soLuong" id="editSoLuong">
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-success">Cập Nhật</button>
                </div>
            </div>
        </form>
    </div>
</div>

<script>
$(document).ready(function() {
    // Gán dữ liệu vào form sửa
    $(".editBtn").click(function() {
        $("#editId").val($(this).data("id"));
        $("#editTen").val($(this).data("ten"));
        $("#editMoTa").val($(this).data("mota"));
        $("#editTieuChuan").val($(this).data("tieuchuan"));
        $("#editSoLuong").val($(this).data("soluong"));
    });

    // Xóa thiết bị
    $(".deleteBtn").click(function() {
        let id = $(this).data("id");
        if (confirm("Bạn có chắc chắn muốn xóa?")) {
            window.location.href = "thietbiController?action=delete&id=" + id;
        }
    });
});
</script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
