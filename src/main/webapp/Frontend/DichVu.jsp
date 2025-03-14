<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="model.PLVDichVu, model.PLVThanhVien" %>
<%@ page import="DAO.PLVQLChungCuDAO" %>
<%@ page import="javax.servlet.http.HttpSession" %>

<%
	HttpSession sessionUser = request.getSession();
	PLVThanhVien thanhVien = (PLVThanhVien) sessionUser.getAttribute("PLvMember");
	String taiKhoanTV = thanhVien.getPLVtaiKhoanTV();

    PLVQLChungCuDAO dao = new PLVQLChungCuDAO();
    List<PLVDichVu> danhSachDichVu = dao.getAllDichVu();
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dịch vụ - <%= taiKhoanTV %></title>
    <link rel="stylesheet" type="text/css" href="css/dichvu.css">
</head>
<body class="body-dichvu">
<jsp:include page="HeaderFrontend.jsp"/>
<div class="khoangtrong"></div>
    <div class="container-dichvu">
        <h2>Danh sách dịch vụ</h2>
        <div class="service-list">
            <%
                int count = 0;
                for (PLVDichVu dv : danhSachDichVu) {
                    boolean daDangKy = dao.CheckDangKyDichVu(dv.getPLVidDichVu(), taiKhoanTV);
            %>
            <div class="service-item">
                <img src="images/<%= dv.getPLVidDichVu() %>.jfif" alt="<%= dv.getPLVtenDV() %>">
                <h3><%= dv.getPLVtenDV() %></h3>
                <p><%= String.format("%,d", dv.getPLVgiaThue()) %> VNĐ</p>
                <form action="PLVDangKyDichVu" method="post">
                    <input type="hidden" name="idDichVu" value="<%= dv.getPLVidDichVu() %>">
                    <input type="hidden" name="taiKhoanTV" value="<%= taiKhoanTV %>">
                    <button type="submit" name="action" value="<%= daDangKy ? "huy" : "dangky" %>">
                        <%= daDangKy ? "Hủy đăng ký" : "Đăng ký" %>
                    </button>
                </form>
            </div>
            <%
                    count++;
                    if (count % 3 == 0) { %>
                        <div style="clear: both;"></div>
                    <% }
                }
            %>
        </div>
    </div>
</body>
</html>
