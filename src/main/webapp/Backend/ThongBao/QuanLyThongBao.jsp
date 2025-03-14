<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="DAO.PLVQLChungCuDAO, java.util.List, model.PLVThongBao" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quản Lý Thông Báo</title>
    <link rel="stylesheet" type="text/css" href="../css/thongbao.css">
</head>
<body>
    <jsp:include page="/Backend/RightLayout.jsp" />
	
    <div class="container">
        <h2>Danh Sách Thông Báo</h2>
        <a href="AddThongBaoChung.jsp" class="nutadd"><button>Thêm thông báo</button></a>
        <%
            PLVQLChungCuDAO dao = new PLVQLChungCuDAO();
            List<PLVThongBao> danhSachThongBao = dao.getAllThongBao();
            for (PLVThongBao tb : danhSachThongBao) {
        %>
            <div class="thongbao">
                <div class="ngay-gui"><%= tb.getPLVngayGui() %></div>
                <div class="tieu-de"><%= tb.getPLVtieuDe() %></div>
                <div class="noi-dung"><%= tb.getPLVnoiDung() %></div>
            </div>
        <% } %>
    </div>
</body>
</html>
