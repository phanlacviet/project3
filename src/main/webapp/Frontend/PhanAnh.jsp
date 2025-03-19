<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="model.PLVThanhVien" %>
<%@ page import="javax.servlet.http.HttpSession" %>

<%
    HttpSession sessionUser = request.getSession();
    PLVThanhVien thanhVien = (PLVThanhVien) sessionUser.getAttribute("PLvMember");
    String taiKhoanTV = thanhVien.getPLVtaiKhoanTV();
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Phản ánh</title>
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/Frontend/css/PhanAnh.css">
</head>
<body class="body-phananh">
    <jsp:include page="HeaderFrontend.jsp"/>
    <div class="container-phananh">
        <h2 class="h2-phananh">Gửi phản ánh</h2>
        <form action="PLVThemPhanAnh" method="post" class="form-phananh">
            <input type="hidden" name="taiKhoanTV" value="<%= taiKhoanTV %>">
            <div class="form-group">
                <label for="noiDung">Nội dung phản ánh:</label>
                <textarea id="noiDung" name="noiDung" rows="5" required></textarea>
            </div>
            <div class="form-group">
                <button type="submit">Gửi phản ánh</button>
            </div>
        </form>
    </div>
	    <%
	    String success = request.getParameter("success");
	    String error = request.getParameter("error");
		%>
		
		<% if (success != null && success.equals("true")) { %>
		    <div class="success-message">Phản ánh đã được gửi thành công!</div>
		<% } %>
		
		<% if (error != null && error.equals("true")) { %>
		    <div class="error-message">Có lỗi xảy ra khi gửi phản ánh. Vui lòng thử lại!</div>
		<% } %>
</body>
</html>