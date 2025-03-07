<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="DAO.QLChungCuDAO, model.ThanhVien, java.util.List, java.text.DecimalFormat" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
  	<link rel="stylesheet" type="text/css" href="../BangDuLieu.css">
</head>
<body>
<jsp:include page="/Backend/RightLayout.jsp" />
<div class="container">
        <h2>Danh Sách Căn Hộ</h2>
        <%
            QLChungCuDAO dao = new QLChungCuDAO();
            List<ThanhVien> listThanhVien = dao.getAllThanhVien();
        %>
        <a href="#"><button>Thêm thành viên <i class="fa-solid fa-arrow-up-from-bracket"></i></button></a>
        <table>
		    <tr>
		        <th>Tài khoản <i class="fa-solid fa-circle-user"></i></th>
		        <th>Mật khẩu <i class="fa-solid fa-star-of-life"></i></th>
		        <th>Họ Tên <i class="fa-solid fa-address-book"></i></th>
		        <th>Email <i class="fa-solid fa-envelope"></i></th>
		        <th>Trạng Thái Xóa <i class="fa-solid fa-trash"></i></th>
		        <th>Hành động <i class="fa-solid fa-arrow-pointer"></i></th>
		    </tr>
		    <%
		        for (ThanhVien thanhvien : listThanhVien) {
		        	boolean trangthai = thanhvien.isDeleted();
		    %>
		    <tr>
		        <td><%= thanhvien.getTaiKhoanTV() %></td>
		        <td><%= thanhvien.getMatKhau() %></td>
		        <td><%= thanhvien.getHoTen() %></td>
		        <td><%= thanhvien.getEmail() %></td>
		        <td>
		            <% if (trangthai) { %>
		                <span class="status-icon green"><i class="fa fa-check-circle"></i></span>
		            <% } else { %>
		                <span class="status-icon red"><i class="fa fa-times-circle"></i></span>
		            <% } %>
		        </td>
		        <td><a href="UpdateThanhVien?idCanHo=<%= thanhvien.getTaiKhoanTV() %>"><i class="fa-solid fa-pen-to-square"></i></a> | 	
		        	<a href="#"> <i class="fa-solid fa-trash"></i></a>
		        </td>
		    </tr>
		    <%
		        }
		    %>
		</table>

    </div>
</body>
</html>