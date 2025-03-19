<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="model.PLVThanhVien" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="DAO.PLVQLChungCuDAO, java.util.List, java.util.ArrayList, java.util.Collections, model.PLVDichVu,model.PLVThongBao,model.PLVPhanAnh ,model.PLVThongBaoCaNhan, model.PLVThanhVien" %>
<%
    HttpSession sessionUser = request.getSession();
    PLVThanhVien thanhVien = (PLVThanhVien) sessionUser.getAttribute("PLvMember");

    if (thanhVien == null) {
        response.sendRedirect(request.getContextPath() + "/Frontend/Login.jsp");
        return;
    }

    String taiKhoanTV = thanhVien.getPLVtaiKhoanTV();
    String hoTen = thanhVien.getPLVhoTen();
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Trang chủ - Cư dân</title>
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/Frontend/css/trangchu.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
</head>
<body class="body-trangchu">
    <jsp:include page="HeaderFrontend.jsp"/>
    
    <div class="container-trangchu">
        <!-- Phần chào mừng -->
        <section class="welcome-section">
            <h1>Xin chào, <%= hoTen %>!</h1>
            <p>Chào mừng bạn đến với hệ thống quản lý chung cư. Dưới đây là các thông tin và tính năng dành cho bạn.</p>
        </section>

        <%
		    PLVQLChungCuDAO dao = new PLVQLChungCuDAO();
		    List<PLVThongBao> danhSachThongBao = dao.getTop3ThongBaoMoiNhat();
		%>
		
		<section class="notifications-section">
		    <h2>Thông báo chung mới nhất</h2>
		    <div class="notification-list">
		        <% for (PLVThongBao thongBao : danhSachThongBao) { %>
		            <div class="notification-item">
		                <i class="fas fa-bell notification-icon"></i>
		                <div class="notification-content">
		                    <h3><%= thongBao.getPLVtieuDe() %></h3>
		                    <p><%= thongBao.getPLVnoiDung() %></p>
		                    <p class="notification-date">Ngày: <%= thongBao.getPLVngayGui() %></p>
		                </div>
		            </div>
		        <% } %>
		    </div>
		</section>

        <%
		    List<PLVDichVu> danhSachDichVu = dao.getDichVuDaDangKyByTaiKhoanTV(taiKhoanTV);
		%>
		
		<section class="services-section">
		    <h2>Dịch vụ đã đăng ký</h2>
		    <div class="service-list">
		        <% for (PLVDichVu dichVu : danhSachDichVu) { %>
		            <div class="service-item">
		                <i class="fas fa-concierge-bell service-icon"></i>
		                <h3><%= dichVu.getPLVtenDV() %></h3>
		                <p>Giá thuê: <%= String.format("%,d", dichVu.getPLVgiaThue()) %> VNĐ</p>
		            </div>
		        <% } %>
		    </div>
		</section>

        <%
	    List<PLVPhanAnh> danhSachPhanAnh = dao.getTop3PhanAnhMoiNhatByTaiKhoanTV(taiKhoanTV);
		%>
		
		<section class="feedbacks-section">
		    <h2>Phản ánh gần đây</h2>
		    <div class="feedback-list">
		        <% for (PLVPhanAnh phanAnh : danhSachPhanAnh) { %>
		            <div class="feedback-item">
		                <i class="fas fa-comments feedback-icon"></i>
		                <div class="feedback-content">
		                    
		                    <p><%= phanAnh.getPLVnoiDung() %></p>
		                    <p class="feedback-date">Ngày: <%= phanAnh.getPLVngayGui() %></p>
		                </div>
		            </div>
		        <% } %>
		    </div>
		</section>

        <!-- Phần liên hệ -->
        <section class="contact-section">
            <h2>Liên hệ với ban quản lý</h2>
            <p>Nếu bạn có bất kỳ câu hỏi hoặc cần hỗ trợ, vui lòng liên hệ:</p>
            <div class="contact-info">
                <p><i class="fas fa-phone"></i> 0123 456 789</p>
                <p><i class="fas fa-envelope"></i> support@chungcu.com</p>
                <p><i class="fas fa-map-marker-alt"></i> 123 Đường ABC, Quận XYZ, TP. HCM</p>
            </div>
        </section>
    </div>

    <!-- Footer -->
    <footer class="footer-trangchu">
        <p>&copy; 2023 Hệ thống quản lý chung cư. Bản quyền thuộc về Phan Lạc Việt.</p>
    </footer>
</body>
</html>