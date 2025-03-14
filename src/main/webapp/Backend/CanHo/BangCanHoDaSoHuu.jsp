<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="DAO.PLVQLChungCuDAO, model.PLVThanhVienCanHo, model.PLVCanHo,java.util.List ,java.text.DecimalFormat" %>
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
        <h2>Danh Sách Căn Hộ Chưa Sở Hữu</h2>

        <%
            // Khởi tạo DAO
            PLVQLChungCuDAO dao = new PLVQLChungCuDAO();
            
        	PLVCanHo ch = new PLVCanHo();
            DecimalFormat formatter = new DecimalFormat("#,###");
            // Lấy danh sách tất cả căn hộ
            List<PLVThanhVienCanHo> listCanHo = dao.getCanHoDaSoHuu();
        %>
        <a href="BangCanHo.jsp"><button>Quay lại</button></a>
        <table>
            <tr>
                <th>Tài khoản <i class="fa-solid fa-circle-user"></i></th>
                <th>Id Căn hộ <i class="fa fa-building"></i></th>
                <th>Ngày mua <i class="fa-solid fa-calendar-days"></i></th>
                <th>Tên căn hộ <i class="fa fa-building"></i></th>
                <th>Giá <i class="fa fa-dollar-sign"></i></th>
            </tr>
            <%
                for (PLVThanhVienCanHo canho : listCanHo) {
                	int id=canho.getPLVidCanHo();
                	ch = dao.getIdCanHo(id);
                	String formattedGia = formatter.format(ch.getPLVGia());
            %>
            <tr>
                <td><%= canho.getPLVtaiKhoanTV() %></td>
                <td><%= canho.getPLVidCanHo() %></td>
                <td><%= canho.getPLVngayMua() %></td>
                <td><%= ch.getPLVTenCH() %></td>
                <td><%= formattedGia %> VNĐ</td>
            </tr>
            <%
                }
            %>
        </table>
    </div>

</body>
</html>
