<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="DAO.PLVQLChungCuDAO, model.PLVThanhVien, java.util.List, java.text.DecimalFormat" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><%= request.getAttribute("pageTitle") %> - Phan Lạc Việt</title>
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/Frontend/css/Frontend.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
    <style>
        
    </style>
</head>
<body>
    <!-- Navbar -->
    <div class="navbar navbar-inverse navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">
                
                <a href="#" class="navbar-brand">Phan Lạc Việt</a>
            </div>
            <div class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    
                    
                    <%
                        // Check if the user is logged in (using session attribute)
                        Object user = session.getAttribute("PLvMember");
                        if (user != null) {
                            out.print("<li class=\"dropdown\">");
                            out.print("<a href=\"#\" class=\"nav-link\"> " + "<i class=\"fa-solid fa-user\"></i>" + "</a>");
                            out.print("<div class=\"dropdown-content\">");
                            out.print("<a href=\"" + request.getContextPath() + "/Frontend/ThongTin.jsp\">Thông tin cá nhân</a>");
                            out.print("<a href=\"" + request.getContextPath() + "/ChangePassword\">Đổi mật khẩu</a>");
                            out.print("<a href=\"" + request.getContextPath() + "/Frontend/ThongBao.jsp\">Thông báo</a>");
                            out.print("<a href=\"" + request.getContextPath() + "/Frontend/ThanhToan.jsp\">Thanh toán</a>");
                            out.print("<a href=\"" + request.getContextPath() + "/Frontend/DichVu.jsp\">Dịch vụ đăng ký</a>");
                            out.print("<a href=\"" + request.getContextPath() + "/Frontend/PhanAnh\">Phản ánh</a>");
                            out.print("<a href=\"" + request.getContextPath() + "/PLVLogout\">Đăng xuất</a>");
                            out.print("</div>");
                            out.print("</li>");
                        } else {
                            out.print("<li><a href=\"" + request.getContextPath() + "/Frontend/Login.jsp\" class=\"nav-link\">Đăng nhập</a></li>");
                        }
                    %>
                    <li><a href="<%= request.getContextPath() %>/Frontend/TrangChu.jsp">Trang chủ</a></li>
                    <li><a href="<%= request.getContextPath() %>/Frontend/CanHo.jsp">Căn hộ</a></li>
                    <li><a href="<%= request.getContextPath() %>/contact">Contact</a></li>
                    
                </ul>
            </div>
        </div>
    </div>
</body>
</html>