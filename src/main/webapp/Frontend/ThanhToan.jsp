<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="DAO.PLVQLChungCuDAO, java.util.List, model.PLVThanhToan, model.PLVThanhVien,java.text.DecimalFormat" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh Sách Thanh Toán</title>
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/Frontend/css/thongbao.css">
</head>
<body class="body-thongbao">
    <jsp:include page="HeaderFrontend.jsp"/>

    <div class="container-thongbao">
        <h2>Hóa đơn thanh toán</h2>

        <%
            // Lấy thông tin tài khoản từ session
            HttpSession sessionUser = request.getSession();
            PLVThanhVien thanhVien = (PLVThanhVien) sessionUser.getAttribute("PLvMember");

            if (thanhVien != null) {
                String taiKhoanTV = thanhVien.getPLVtaiKhoanTV();

                PLVQLChungCuDAO dao = new PLVQLChungCuDAO();
                List<PLVThanhToan> danhSachThanhToan = dao.getAllThanhToanByTaiKhoanTV(taiKhoanTV);
                DecimalFormat decimalFormat = new DecimalFormat("#,### VNĐ");
                if (danhSachThanhToan != null && !danhSachThanhToan.isEmpty()) {
                    for (PLVThanhToan tt : danhSachThanhToan) {
        %>
                        <div class="thongbao">
                            <div class="id-thanh-toan">Mã TT: <%= tt.getPLVidThanhToan() %></div>
                            <div class="ngay-gui"><%= tt.getPLVngayThanhToan() %></div>
                           	<div class="tieu-de">Số tiền: <%= decimalFormat.format(tt.getPLVsoTien()) %></div>
                        </div>
        <%
                    }
                } else {
        %>
                    <p class="message">Không có lịch sử thanh toán nào.</p>
        <%
                }
            } 
        %>
    </div>

    <jsp:include page="FooterFrontend.jsp"/>
</body>
</html>
