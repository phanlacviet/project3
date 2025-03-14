<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="DAO.PLVQLChungCuDAO, model.PLVCanHo, java.util.List, java.text.DecimalFormat" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh Sách Căn Hộ</title>
 	<link rel="stylesheet" type="text/css" href="../BangDuLieu.css">
 	    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
 	
</head>
<body>
    <jsp:include page="/Backend/RightLayout.jsp" />
    <div class="container">
        <h2>Danh Sách Căn Hộ</h2>
        <%
        	PLVQLChungCuDAO dao = new PLVQLChungCuDAO();
            int soCanHoChuaSoHuu = dao.getSoCanHoChuaSoHuu();
            int soCanHoDaSoHuu = dao.getSoCanHoDaSoHuu();
            List<PLVCanHo> listCanHo = dao.getAllCanHo();
            DecimalFormat formatter = new DecimalFormat("#,###");
        %>
        <div class="summary">
            <a href="BangCanHoChuaSoHuu.jsp">
                <div style="color: green;">Căn hộ chưa sở hữu: <%= soCanHoChuaSoHuu %></div>
            </a>
            <a href="BangCanHoDaSoHuu.jsp">
                <div style="color: red;">Căn hộ đã sở hữu: <%= soCanHoDaSoHuu %></div>
            </a>
        </div>
        <a href="AddCanHo.jsp"><button>Thêm căn hộ</button></a>
        <table>
		    <tr>
		        <th>ID <i class="fa fa-id-badge"></i></th>
		        <th>Tên Căn Hộ <i class="fa fa-building"></i></th>
		        <th>Diện Tích <i class="fa fa-ruler"></i></th>
		        <th>Giá <i class="fa fa-dollar-sign"></i></th>
		        <th>Tình trạng sở hữu <i class="fa fa-info-circle"></i></th>
		        <th>Trạng thái xóa </th>
		        <th>Hành Động</th>
		    </tr>
		    <%
		        for (PLVCanHo canho : listCanHo) {
		            String formattedGia = formatter.format(canho.getPLVGia());
		            boolean trangThai = canho.getPLVTrangThai();
		            boolean trangThaixoa = canho.getPLVIsDeleted();
		    %>
		    <tr>
		        <td><%= canho.getPLVIdCanHo() %></td>
		        <td><%= canho.getPLVTenCH() %></td>
		        <td><%= canho.getPLVDienTich() %> m²</td>
		        <td><%= formattedGia %> VNĐ</td>
		        <td>
		            <% if (trangThai) { %>
		                <span class="status-icon green"><i class="fa fa-check-circle"></i></span>
		            <% } else { %>
		                <span class="status-icon red"><i class="fa fa-times-circle"></i></span>
		            <% } %>
		        </td>
		        <td>
		            <% if (trangThaixoa) { %>
		                <span class="status-icon green"><i class="fa fa-check-circle"></i></span>
		            <% } else { %>
		                <span class="status-icon red"><i class="fa fa-times-circle"></i></span>
		            <% } %>
		        </td>
		        <td><a href="PLVUpdateCanHo?idCanHo=<%= canho.getPLVIdCanHo() %>"><i class="fa-solid fa-pen-to-square"></i></a> | 	
		        	<a href="PLVDeleteCanHo?idCanHo=<%= canho.getPLVIdCanHo() %>&action=delete"> 
				        <i class="fa-solid fa-trash"></i>
				    </a> | 
				    <a href="PLVDeleteCanHo?idCanHo=<%= canho.getPLVIdCanHo() %>&action=restore"> 
				        <i class="fa-solid fa-window-restore"></i>
				    </a>
		        </td>
		    </tr>
		    <%
		        }
		    %>
		</table>

    </div>
</body>
</html>