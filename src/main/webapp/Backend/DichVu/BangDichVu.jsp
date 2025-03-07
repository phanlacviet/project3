<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="DAO.QLChungCuDAO, model.DichVu, java.util.List, java.text.DecimalFormat" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dịch vụ</title>
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
  	<link rel="stylesheet" type="text/css" href="../BangDuLieu.css">
</head>
<body>
<jsp:include page="/Backend/RightLayout.jsp" />
<div class="container">
        <h2>Danh Sách Dịch vụ</h2>
        <%
            QLChungCuDAO dao = new QLChungCuDAO();
            List<DichVu> listdichvu = dao.getAllDichVu();
        %>
        <a href="AddDichVu.jsp"><button>Thêm dịch vụ <i class="fa-solid fa-arrow-up-from-bracket"></i></button></a>
        <table>
		    <tr>
		        <th>ID Dịch Vụ <i class="fa-solid fa-circle-info"></i></th>
		        <th>Tên Dịch Vụ <i class="fa-solid fa-file-signature"></i></th>
		        <th>Giá Thuê <i class="fa-solid fa-address-book"></i></th>
		        <th>Trạng Thái Xóa <i class="fa-solid fa-trash"></i></th>
		        <th>Hành động <i class="fa-solid fa-arrow-pointer"></i></th>
		    </tr>
		    <%
		        for (DichVu dichvu : listdichvu) {
		        	boolean trangthai = dichvu.isDeleted();
		    %>
		    <tr>
		        <td><%= dichvu.getIdDichVu() %></td>
		        <td><%= dichvu.getTenDV() %></td>
		        <td><%= dichvu.getGiaThue() %></td>
		        <td>
		            <% if (trangthai) { %>
		                <span class="status-icon green"><i class="fa fa-check-circle"></i></span>
		            <% } else { %>
		                <span class="status-icon red"><i class="fa fa-times-circle"></i></span>
		            <% } %>
		        </td>
		        <td><a href="UpdateDichVu?idDichVu=<%= dichvu.getIdDichVu() %>"><i class="fa-solid fa-pen-to-square"></i></a> | 	
		        	<a href="#"> <i class="fa-solid fa-trash"></i></a>
		        </td>
		    </tr>
		    <%
		        }
		    %>
		</table>

    </div>
</body>
</html>