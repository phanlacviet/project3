<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="DAO.PLVQLChungCuDAO, java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thêm thông báo cá nhân</title>
      <link rel="stylesheet" type="text/css" href="../css/thongbao.css">
</head>
<body>
<jsp:include page="/Backend/RightLayout.jsp" />
<div class="container-add-thongbao">
    <h2>Thêm thông báo cá nhân</h2>

    <%
        PLVQLChungCuDAO dao = new PLVQLChungCuDAO();
        List<String> danhSachTaiKhoan = dao.getAllTaiKhoanTV();
    %>

    <form action="PLVAddThongBaoCaNhan" method="post">
        <label for="taiKhoanTV">Chọn người nhận:</label>
        <select id="taiKhoanTV" name="taiKhoanTV">
            <option value="">-- Chọn tài khoản --</option>
            <% for (String tk : danhSachTaiKhoan) { %>
                <option value="<%= tk %>"><%= tk %></option>
            <% } %>
        </select>

        <br><br>
        <label for="tieuDe">Tiêu đề:</label>
        <input type="text" id="tieuDe" name="tieuDe" required>

        <br><br>
        <label for="noiDung">Nội dung:</label>
        <textarea id="noiDung" name="noiDung" rows="5" required></textarea>

        <br><br>
        <input type="submit" value="Gửi thông báo">
    </form>
    </div>
</body>
</html>
