<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="DAO.QLChungCuDAO, model.ThanhVienCanHo, model.CanHo,java.util.List ,java.text.DecimalFormat" %>
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
            QLChungCuDAO dao = new QLChungCuDAO();
            
            CanHo ch = new CanHo();
            DecimalFormat formatter = new DecimalFormat("#,###");
            // Lấy danh sách tất cả căn hộ
            List<ThanhVienCanHo> listCanHo = dao.getCanHoDaSoHuu();
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
                for (ThanhVienCanHo canho : listCanHo) {
                	int id=canho.getIdCanHo();
                	ch = dao.getIdCanHo(id);
                	String formattedGia = formatter.format(ch.getGia());
            %>
            <tr>
                <td><%= canho.getTaiKhoanTV() %></td>
                <td><%= canho.getIdCanHo() %></td>
                <td><%= canho.getNgayMua() %></td>
                <td><%= ch.getTenCH() %></td>
                <td><%= formattedGia %> VNĐ</td>
            </tr>
            <%
                }
            %>
        </table>
    </div>

</body>
</html>
