<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="model.CanHo" %>
<%@ page import="DAO.QLChungCuDAO" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh Sách Căn Hộ Chưa Sở Hữu</title>
    <style>
        table {
            width: 80%;
            border-collapse: collapse;
            margin: 20px auto;
        }
        th, td {
            border: 1px solid black;
            padding: 10px;
            text-align: center;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>

    <h2 style="text-align: center;">Danh Sách Căn Hộ Chưa Sở Hữu</h2>

    <%
        QLChungCuDAO dao = new QLChungCuDAO();
        List<CanHo> danhSachCanHo = dao.getCanHoChuaSoHuu();
    %>

    <table>
        <tr>
            <th>ID Căn Hộ</th>
            <th>Tên Căn Hộ</th>
            <th>Diện Tích (m²)</th>
            <th>Giá (VNĐ)</th>
        </tr>

        <% for (CanHo canHo : danhSachCanHo) { %>
            <tr>
                <td><%= canHo.getIdCanHo() %></td>
                <td><%= canHo.getTenCH() %></td>
                <td><%= canHo.getDienTich() %></td>
                <td><%= String.format("%,.0f", canHo.getGia()) %></td>
            </tr>
        <% } %>

    </table>

</body>
</html>
