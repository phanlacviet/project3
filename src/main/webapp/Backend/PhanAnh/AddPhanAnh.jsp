<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="DAO.PLVQLChungCuDAO, java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thêm phản ánh</title>
    <link rel="stylesheet" type="text/css" href="../css/thongbao.css">
</head>
<body>
	<jsp:include page="/Backend/RightLayout.jsp" />
	<div class="container-add-thongbao">
	<h2>Thêm phản ánh</h2>
	
	<% 
	    PLVQLChungCuDAO dao = new PLVQLChungCuDAO();
	    List<String> danhSachTaiKhoanTV = dao.getAllTaiKhoanTV();
	%>
	
	<form action="PLVAddPhanAnh" method="post">
	    <label for="taiKhoanTV">Chọn tài khoản:</label>
	    <select id="taiKhoanTV" name="taiKhoanTV">
	        <% for (String taiKhoan : danhSachTaiKhoanTV) { %>
	            <option value="<%= taiKhoan %>"><%= taiKhoan %></option>
	        <% } %>
	    </select>
	
	    <br><br>
	    
	    <label for="noiDung">Nội dung phản ánh:</label>
	    <textarea id="noiDung" name="noiDung" required></textarea>
	
	    <br><br>
	    
	    <input type="submit" value="Gửi phản ánh">
	</form>
</div>
</body>
</html>
