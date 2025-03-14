<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="DAO.PLVQLChungCuDAO, model.PLVDichVu, model.PLVDichVuDangKy,java.util.List, java.text.DecimalFormat" %>
    
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
        <h2>Danh Sách Dịch vụ đã được đăng ký</h2>
        <%
       		PLVQLChungCuDAO dao = new PLVQLChungCuDAO();
            List<PLVDichVuDangKy> listdichvudangky = dao.getAllDichVuDangKy();
        %>
        <a href="AddDichVuDangKy.jsp"><button>Thêm dịch vụ <i class="fa-solid fa-arrow-up-from-bracket"></i></button></a>
        <table>
		    <tr>
		        <th>ID Dịch Vụ DK <i class="fa-solid fa-circle-info"></i></th>
		        <th>Tài Khoản <i class="fa-solid fa-circle-user"></i></th>
		        <th>ID Dịch Vụ <i class="fa-solid fa-circle-info"></i></th>
		        <th>Tên dịch vụ <i class="fa-solid fa-file-signature"></i></th>
		        <th>Giá thuê <i class="fa-solid fa-money-bill"></i></th>
		    </tr>
		    <%
		        for (PLVDichVuDangKy dichvudangky : listdichvudangky) {
		        	PLVDichVu dv = dao.getDichVuById(dichvudangky.getPLVidDichVu());
		        	
		    %>
		    <tr>
		        <td><%= dichvudangky.getPLVidDichVuDK() %></td>
		        <td><%= dichvudangky.getPLVtaiKhoanTV() %></td>
		        <td><%= dichvudangky.getPLVidDichVu() %></td>
		        <td><%= dv.getPLVtenDV()  %></td>
		        <td><%= dv.getPLVgiaThue()  %></td>
		    </tr>
		    <%
		        }
		    %>
		</table>

    </div>
</body>
</html>