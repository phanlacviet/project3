<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="model.CanHo" %>
<%@ page import="DAO.QLChungCuDAO" %>

<%
    // Lấy danh sách căn hộ chưa sở hữu từ DAO
    QLChungCuDAO dao = new QLChungCuDAO();
    List<CanHo> danhSachCanHo = dao.getCanHoChuaSoHuu();
%>

<jsp:include page="HeaderFrontend.jsp">
    <jsp:param name="pageTitle" value="Danh Sách Căn Hộ Chưa Sở Hữu" />
</jsp:include>

<div class="container" style="padding-top: 70px;"> <!-- Để tránh bị che bởi navbar cố định -->
    <h2 style="text-align: center;">Danh Sách Căn Hộ Chưa Sở Hữu</h2>

    <table style="width: 80%; border-collapse: collapse; margin: 20px auto;">
        <tr>
            <th style="border: 1px solid black; padding: 10px; background-color: #f2f2f2;">ID Căn Hộ</th>
            <th style="border: 1px solid black; padding: 10px; background-color: #f2f2f2;">Tên Căn Hộ</th>
            <th style="border: 1px solid black; padding: 10px; background-color: #f2f2f2;">Diện Tích (m²)</th>
            <th style="border: 1px solid black; padding: 10px; background-color: #f2f2f2;">Giá (VNĐ)</th>
        </tr>

        <% for (CanHo canHo : danhSachCanHo) { %>
            <tr>
                <td style="border: 1px solid black; padding: 10px; text-align: center;"><%= canHo.getIdCanHo() %></td>
                <td style="border: 1px solid black; padding: 10px; text-align: center;"><%= canHo.getTenCH() %></td>
                <td style="border: 1px solid black; padding: 10px; text-align: center;"><%= canHo.getDienTich() %></td>
                <td style="border: 1px solid black; padding: 10px; text-align: center;"><%= String.format("%,.0f", canHo.getGia()) %></td>
            </tr>
        <% } %>
    </table>
</div>

<jsp:include page="FooterFrontend.jsp" />
