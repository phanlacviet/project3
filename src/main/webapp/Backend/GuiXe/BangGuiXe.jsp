<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="DAO.PLVQLChungCuDAO, java.util.List, model.PLVGuiXe" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh Sách Gửi Xe</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
    <link rel="stylesheet" type="text/css" href="../BangDuLieu.css">
</head>
<body>
    <jsp:include page="/Backend/RightLayout.jsp" />
    <div class="container">
        <h2>Danh Sách Gửi Xe</h2>
        <table border="1" >
            <thead>
                <tr>
                    <th>ID Xe</th>
                    <th>Tài Khoản TV</th>
                    <th>Biển Số Xe</th>
                    <th>Ngày Gửi</th>
                    <th>Trạng Thái</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    PLVQLChungCuDAO dao = new PLVQLChungCuDAO();
                    List<PLVGuiXe> danhSachXe = dao.getAllDanhSachXe();
                    for (PLVGuiXe xe : danhSachXe) {
                %>
                <tr>
                    <td><%= xe.getPLVidXe() %></td>
                    <td><%= xe.getPLVtaiKhoanTV() %></td>
                    <td><%= xe.getPLVbienXoXe() %></td>
                    <td><%= xe.getPLVngayGui() %></td>
                    <td><%= xe.PLVisDeleted() ? "Đã Xóa" : "Hoạt Động" %></td>
                </tr>
                <% } %>
            </tbody>
        </table>
    </div>
</body>
</html>
