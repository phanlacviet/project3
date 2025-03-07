<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="DAO.QLChungCuDAO, model.DichVu, model.DichVuDangKy,java.util.List, java.text.DecimalFormat" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
  	<link rel="stylesheet" type="text/css" href="../BangDuLieu.css">
</head>
<body>
<jsp:include page="/Backend/RightLayout.jsp" />
<div class="container">
        <h2>Danh Sách Dịch vụ</h2>
        <%
            QLChungCuDAO dao = new QLChungCuDAO();
            List<DichVuDangKy> listdichvudangky = dao.getAllDichVuDangKy();
        %>
        <table>
		    <tr>
		        <th>ID Dịch Vụ DK <i class="fa-solid fa-circle-info"></i></th>
		        <th>Tài Khoản <i class="fa-solid fa-circle-user"></i></th>
		        <th>ID Dịch Vụ <i class="fa-solid fa-circle-info"></i></th>
		        <th>Tên dịch vụ <i class="fa-solid fa-file-signature"></i></th>
		        <th>Giá thuê <i class="fa-solid fa-money-bill"></i></th>
		    </tr>
		    <%
		        for (DichVuDangKy dichvudangky : listdichvudangky) {
		        	DichVu dv = dao.getDichVuById(dichvudangky.getIdDichVu());
		        	
		    %>
		    <tr>
		        <td><%= dichvudangky.getIdDichVuDK() %></td>
		        <td><%= dichvudangky.getTaiKhoanTV() %></td>
		        <td><%= dichvudangky.getIdDichVu() %></td>
		        <td><%= dv.getTenDV()  %></td>
		        <td><%= dv.getGiaThue()  %></td>
		    </tr>
		    <%
		        }
		    %>
		</table>

    </div>
</body>
</html>