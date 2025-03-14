<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="DAO.PLVQLChungCuDAO, model.PLVThanhVien, java.util.List, java.text.DecimalFormat" %>
 
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
        <h2>Danh Sách Thành Viên</h2>
        <%
        	PLVQLChungCuDAO dao = new PLVQLChungCuDAO();
            List<PLVThanhVien> listThanhVien = dao.getAllThanhVien();
        %>
        <a href="AddThanhVien.jsp"><button>Thêm thành viên <i class="fa-solid fa-arrow-up-from-bracket"></i></button></a>
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
		        for (PLVThanhVien thanhvien : listThanhVien) {
		        	boolean trangthai = thanhvien.PLVisDeleted();
		    %>
		    <tr>
		        <td><%= thanhvien.getPLVtaiKhoanTV() %></td>
		        <td><%= thanhvien.getPLVmatKhau() %></td>
		        <td><%= thanhvien.getPLVhoTen() %></td>
		        <td><%= thanhvien.getPLVemail() %></td>
		        <td>
		            <% if (trangthai) { %>
		                <span class="status-icon green"><i class="fa fa-check-circle"></i></span>
		            <% } else { %>
		                <span class="status-icon red"><i class="fa fa-times-circle"></i></span>
		            <% } %>
		        </td>
		        <td><a href="PLVUpdateThanhVien?taiKhoanTV=<%= thanhvien.getPLVtaiKhoanTV() %>"><i class="fa-solid fa-pen-to-square"></i></a> | 	
		        	<a href="PLVDeleteThanhVien?taiKhoanTV=<%= thanhvien.getPLVtaiKhoanTV() %>&action=delete"> 
				        <i class="fa-solid fa-trash"></i>
				    </a> | 
				    <a href="PLVDeleteThanhVien?taiKhoanTV=<%= thanhvien.getPLVtaiKhoanTV() %>&action=restore"> 
				        <i class="fa-solid fa-window-restore"></i>
				    </a>
		        </td>
		    </tr>
		    <%
		        }
		    %>
		</table>

    </div>
</body>
</html>