<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng ký</title>
<link rel="stylesheet" type="text/css" href="css/DKDN.css">
</head>
<body>
<jsp:include page="HeaderFrontend.jsp"/>
	<h2>Đăng ký</h2>
    <form action="Register" method="post">
        <label for="taiKhoanTV">Tài khoản:</label>
        <input type="text" id="taiKhoanTV" name="taiKhoanTV" required><br><br>
        <label for="matKhau">Mật khẩu:</label>
        <input type="password" id="matKhau" name="matKhau" required><br><br>
        <label for="hoTen">Họ tên:</label>
        <input type="text" id="hoTen" name="hoTen" required><br><br>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br><br>
        <input type="submit" value="Đăng ký">
    </form>
<jsp:include page="FooterFrontend.jsp" />
</body>
</html>