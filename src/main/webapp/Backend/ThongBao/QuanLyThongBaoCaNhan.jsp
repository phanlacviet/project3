<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="DAO.PLVQLChungCuDAO, java.util.List, model.PLVThongBaoCaNhan" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quản lý thông báo cá nhân</title>
  <link rel="stylesheet" type="text/css" href="../css/thongbao.css">
</head>
<body>
    <jsp:include page="/Backend/RightLayout.jsp" />
    <div class="container">
    <h2>Danh sách thông báo cá nhân</h2>
	<a href="AddThongBaoCaNhan.jsp" class="nutadd"><button>Thêm thông báo</button></a>
    <% 
        PLVQLChungCuDAO dao = new PLVQLChungCuDAO();
        List<PLVThongBaoCaNhan> danhSachThongBao = dao.getAllThongBaoCaNhan();
        for (PLVThongBaoCaNhan tb : danhSachThongBao) { 
    %>
        <div class="thongbao">
            <div class="tieu-de"><%= tb.getPLVtieuDe() %></div>
            <div class="nguoi-nhan">Người nhận: <%= tb.getPLVtaiKhoanTV() %></div>
            <div class="noi-dung">Nội dung: <%= tb.getPLVnoiDung() %></div>
            <div class="ngay-gui"><%= tb.getPLVngayGui() %></div>
        </div>
    <% } %>
 </div>
</body>
</html>
