<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="model.PLVCanHo" %>
<%@ page import="DAO.PLVQLChungCuDAO" %>

<%
    // Lấy danh sách căn hộ chưa sở hữu từ DAO
    PLVQLChungCuDAO dao = new PLVQLChungCuDAO();
    List<PLVCanHo> danhSachCanHo = dao.getCanHoChuaSoHuu();
%>

<jsp:include page="HeaderFrontend.jsp"/>
<div class="container" style="padding-top: 70px;">
    <h2 style="text-align: center;">Danh Sách Căn Hộ Chưa Sở Hữu</h2>

    <div class="canho-list">
        <% for (PLVCanHo canHo : danhSachCanHo) { %>
            <div class="canho-item">
                <img src="canho.jfif" alt="Căn hộ <%= canHo.getPLVIdCanHo() %>" class="canho-image">
                <div class="canho-info">
                    <h3><%= canHo.getPLVTenCH() %></h3>
                    <p>Diện tích: <%= canHo.getPLVDienTich() %> m²</p>
                    <p>Giá: <%= String.format("%,.0f", canHo.getPLVGia()) %> VNĐ</p>
                </div>
                <button class="dat-lich-button" onclick="window.location.href='<%= request.getContextPath() %>/DatLichMua?idCanHo=<%= canHo.getPLVIdCanHo() %>'">Đặt lịch mua</button>
            </div>
        <% } %>
    </div>
</div>

<jsp:include page="FooterFrontend.jsp" />