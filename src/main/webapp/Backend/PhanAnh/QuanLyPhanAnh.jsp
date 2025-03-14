<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="DAO.PLVQLChungCuDAO, java.util.List, model.PLVPhanAnh" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quản Lý Phản Ánh</title>
    <link rel="stylesheet" type="text/css" href="../css/thongbao.css">
</head>
<body>
    <jsp:include page="/Backend/RightLayout.jsp" />

    <div class="container">
        <h2>Danh Sách Phản Ánh</h2>
        <a href="AddPhanAnh.jsp" class="nutadd"><button>Thêm phản ánh</button></a>
        <%
            PLVQLChungCuDAO dao = new PLVQLChungCuDAO();
            List<PLVPhanAnh> danhSachPhanAnh = dao.getAllPhanAnh();
            for (PLVPhanAnh pa : danhSachPhanAnh) {
        %>
            <div class="thongbao">
                <div class="ngay-gui"><%= pa.getPLVngayGui() %></div>
                <div class="tieu-de"><%= pa.getPLVtaiKhoanTV() %></div>
                <div class="noi-dung"><%= pa.getPLVnoiDung() %></div>
            </div>
        <% } %>
    </div>
</body>
</html>
