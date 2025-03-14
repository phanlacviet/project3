<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="DAO.PLVQLChungCuDAO, model.PLVThanhVien" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cập Nhật Thành Viên</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
    <link rel="stylesheet" type="text/css" href="../css/Update.css">
</head>
<body>
    <jsp:include page="/Backend/RightLayout.jsp" />
    <div class="container">
        <h2>Cập Nhật Thành Viên</h2>
        <%
            String taiKhoanTV = request.getParameter("taiKhoanTV");
            PLVQLChungCuDAO dao = new PLVQLChungCuDAO();
            PLVThanhVien thanhVien = dao.getThanhVienById(taiKhoanTV);
        %>
        <form action="PLVUpdateThanhVien" method="post">
            <label for="taiKhoanTV">Tài khoản:</label>
            <input type="text" id="taiKhoanTV" name="taiKhoanTV" value="<%= thanhVien.getPLVtaiKhoanTV() %>" readonly><br><br>
            <label for="matKhau">Mật khẩu:</label>
            <input type="password" id="matKhau" name="matKhau" value="<%= thanhVien.getPLVmatKhau() %>" required><br><br>
            <label for="hoTen">Họ tên:</label>
            <input type="text" id="hoTen" name="hoTen" value="<%= thanhVien.getPLVhoTen() %>" required><br><br>
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" value="<%= thanhVien.getPLVemail() %>" required><br><br>
            <input type="submit" value="Cập nhật">
        </form>
    </div>
</body>
</html>