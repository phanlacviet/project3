<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="model.PLVCanHo" %>
<%@ page import="DAO.PLVQLChungCuDAO" %>

<%
    String sapXep = request.getParameter("sapXep");
    PLVQLChungCuDAO dao = new PLVQLChungCuDAO();
    List<PLVCanHo> danhSachCanHo;

    if (sapXep != null) {
        danhSachCanHo = dao.getCanHoChuaSoHuuSapXep(sapXep);
    } else {
        danhSachCanHo = dao.getCanHoChuaSoHuu();
    }
%>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
<jsp:include page="HeaderFrontend.jsp"/>
<div class="container" style="padding-top: 70px;">
    <h2 style="text-align: center;">Danh Sách Căn Hộ Chưa Sở Hữu</h2>
    <form id="sapXepForm" method="get" action="CanHo.jsp">
        <div class="sap-xep-container">
            <label>
                <input type="radio" name="sapXep" value="dienTichTang"> Diện tích tăng dần
            </label>
            <label>
                <input type="radio" name="sapXep" value="dienTichGiam"> Diện tích giảm dần
            </label>
            <label>
                <input type="radio" name="sapXep" value="giaTang"> Giá tăng dần
            </label>
            <label>
                <input type="radio" name="sapXep" value="giaGiam"> Giá giảm dần
            </label>
            <button type="submit">Sắp xếp</button>
            <button type="button" onclick="resetSapXep()">Bỏ</button>
        </div>
    </form>
    <div class="canho-list">
        <% for (PLVCanHo canHo : danhSachCanHo) { %>
            <div class="canho-item">
                <img src="canho.jfif" alt="Căn hộ <%= canHo.getPLVIdCanHo() %>" class="canho-image">
                <div class="canho-info">
				    <h3><%= canHo.getPLVTenCH() %></h3>
				    <p class="dien-tich" style="display: flex; align-items: center; gap: 8px; font-size: 1.1rem; color: #007bff; margin-bottom: 8px;">
					    <i class="fas fa-ruler-combined"></i>
					    Diện tích: <%= canHo.getPLVDienTich() %> m²
					</p>
					<p class="gia" style="display: flex; align-items: center; gap: 8px; font-size: 1.1rem; color: #28a745; margin-bottom: 8px;">
					    <i class="fas fa-tag"></i>
					    Giá: <%= String.format("%,.0f", canHo.getPLVGia()) %> VNĐ
					</p>
				</div>
                <button class="dat-lich-button" onclick="window.location.href='<%= request.getContextPath() %>/DatLichMua?idCanHo=<%= canHo.getPLVIdCanHo() %>'">Đặt lịch mua</button>
            </div>
        <% } %>
    </div>
</div>

<jsp:include page="FooterFrontend.jsp" />
<script>
    function resetSapXep() {
        window.location.href = "CanHo.jsp";
    }
</script>