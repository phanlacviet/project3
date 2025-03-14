<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đăng nhập</title>
    
</head>
<body>
    <jsp:include page="HeaderFrontend.jsp"/>
    <div class="auth-container">
        <h2>Đăng nhập</h2>
        <form action="PLVLogin" method="post" class="">
            <label for="taiKhoanTV" class="">Tài khoản:</label>
            <input type="text" id="taiKhoanTV" name="taiKhoanTV" required  class="">
            <label for="matKhau" class="">Mật khẩu:</label>
            <input type="password" id="matKhau" name="matKhau" required class="">
            <input type="submit" value="Đăng nhập" class="">
        </form>
    </div>
	<jsp:include page="FooterFrontend.jsp" />
</body>
</html>