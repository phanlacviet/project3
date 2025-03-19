<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="model.PLVThanhVien, java.util.List, DAO.PLVQLChungCuDAO,model.PLVDichVu" %>
<%@ page import="javax.servlet.http.HttpSession" %>

<%
    HttpSession sessionUser = request.getSession();
    PLVThanhVien thanhVien = (PLVThanhVien) sessionUser.getAttribute("PLvMember");

    String taiKhoanTV = thanhVien.getPLVtaiKhoanTV();
    String hoTen = thanhVien.getPLVhoTen();
    String email = thanhVien.getPLVemail();

    PLVQLChungCuDAO dao = new PLVQLChungCuDAO();
    List<String> danhSachCanHo = dao.getCanHoDaSoHuuByTaiKhoanTV(taiKhoanTV);
    List<PLVDichVu> danhSachDichVu = dao.getDichVuDaDangKyByTaiKhoanTV(taiKhoanTV);
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thông tin cá nhân</title>
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/Frontend/css/ThongTin.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
</head>
<body class="body-thongtin">
    <jsp:include page="HeaderFrontend.jsp"/>
    <div class="container-thongtin">
        <div class="thongtin-box">
            <!-- Biểu tượng người dùng -->
            <div class="user-icon">
                <i class="fa-solid fa-circle-user"></i>
            </div>

            <!-- Thông tin cá nhân -->
            <div class="thongtin-item">
                <p class="thongtin-label">Tài khoản:</p>
                <p class="thongtin-value"><%= taiKhoanTV %></p>
            </div>

            <div class="thongtin-item">
                <p class="thongtin-label">Họ tên:</p>
                <p class="thongtin-value"><%= hoTen %></p>
            </div>

            <div class="thongtin-item">
                <p class="thongtin-label">Email:</p>
                <p class="thongtin-value"><%= email %></p>
            </div>

            <!-- Căn hộ đã sở hữu -->
            <div class="thongtin-item">
                <p class="thongtin-label">Căn hộ đã sở hữu:</p>
                <ul class="thongtin-list">
                    <% if (danhSachCanHo.isEmpty()) { %>
                        <li class="thongtin-value">Không có căn hộ nào.</li>
                    <% } else { %>
                        <% for (String canHo : danhSachCanHo) { %>
                            <li class="thongtin-value"><%= canHo %></li>
                        <% } %>
                    <% } %>
                </ul>
            </div>

            <!-- Dịch vụ đã đăng ký -->
            <div class="thongtin-item">
                <p class="thongtin-label">Dịch vụ đã đăng ký:</p>
                <ul class="thongtin-list">
                    <% if (danhSachDichVu.isEmpty()) { %>
                        <li class="thongtin-value">Không có dịch vụ nào.</li>
                    <% } else { %>
                        <% for (PLVDichVu dichVu : danhSachDichVu) { %>
                            <li class="thongtin-value"><%= dichVu.getPLVtenDV() %></li>
                        <% } %>
                    <% } %>
                </ul>
            </div>

            <div class="thongtin-item">
                <a href="<%= request.getContextPath() %>/Frontend/TrangChu.jsp" class="btn-home">Quay về trang chủ</a>
            </div>
        </div>
    </div>
</body>
</html>