<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thêm Thành Viên</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
    <link rel="stylesheet" type="text/css" href="../BangDuLieu.css">
</head>
<body>
    <jsp:include page="/Backend/RightLayout.jsp" />
    <div class="container">
        <h2>Thêm Thành Viên</h2>
        <form action="PLVAddThanhVien" method="post">
            <label for="taiKhoanTV">Tài khoản:</label>
            <input type="text" id="taiKhoanTV" name="taiKhoanTV" required><br><br>
            <label for="matKhau">Mật khẩu:</label>
            <input type="password" id="matKhau" name="matKhau" required><br><br>
            <label for="hoTen">Họ tên:</label>
            <input type="text" id="hoTen" name="hoTen" required><br><br>
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required><br><br>
            <input type="submit" value="Thêm">
        </form>
    </div>
</body>
</html>