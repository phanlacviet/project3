<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="DAO.PLVQLChungCuDAO, java.util.List, java.util.ArrayList, java.util.Collections, model.PLVThongBao, model.PLVThongBaoCaNhan, model.PLVThanhVien" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thông Báo</title>
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/Frontend/css/thongbao.css">
</head>
<body class="body-thongbao">
    <jsp:include page="HeaderFrontend.jsp"/>

    <div class="container-thongbao">
        <h2>Danh Sách Thông Báo</h2>

        <%
            
            HttpSession sessionUser = request.getSession();
            PLVThanhVien thanhVien = (PLVThanhVien) sessionUser.getAttribute("PLvMember");

            if (thanhVien != null) {
                String taiKhoanTV = thanhVien.getPLVtaiKhoanTV();

                PLVQLChungCuDAO dao = new PLVQLChungCuDAO();

                
                List<PLVThongBao> danhSachThongBao = dao.getAllThongBao();

                List<PLVThongBaoCaNhan> danhSachThongBaoCaNhan = dao.getAllThongBaoCaNhanByTaiKhoanTV(taiKhoanTV);

                
                List<Object> danhSachTatCaThongBao = new ArrayList<>();
                danhSachTatCaThongBao.addAll(danhSachThongBao);
                danhSachTatCaThongBao.addAll(danhSachThongBaoCaNhan);

             
                Collections.sort(danhSachTatCaThongBao, (a, b) -> {
                    if (a instanceof PLVThongBao && b instanceof PLVThongBao) {
                        return ((PLVThongBao) b).getPLVngayGui().compareTo(((PLVThongBao) a).getPLVngayGui());
                    } else if (a instanceof PLVThongBaoCaNhan && b instanceof PLVThongBaoCaNhan) {
                        return ((PLVThongBaoCaNhan) b).getPLVngayGui().compareTo(((PLVThongBaoCaNhan) a).getPLVngayGui());
                    } else if (a instanceof PLVThongBao && b instanceof PLVThongBaoCaNhan) {
                        return ((PLVThongBaoCaNhan) b).getPLVngayGui().compareTo(((PLVThongBao) a).getPLVngayGui());
                    } else {
                        return ((PLVThongBao) b).getPLVngayGui().compareTo(((PLVThongBaoCaNhan) a).getPLVngayGui());
                    }
                });

         
                for (Object tb : danhSachTatCaThongBao) {
        %>
            <div class="thongbao">
                <div class="ngay-gui">
                    <% if (tb instanceof PLVThongBao) { %>
                        <%= ((PLVThongBao) tb).getPLVngayGui() %>
                    <% } else { %>
                        <%= ((PLVThongBaoCaNhan) tb).getPLVngayGui() %>
                    <% } %>
                </div>
                <div class="tieu-de">
                    <% if (tb instanceof PLVThongBao) { %>
                        <%= ((PLVThongBao) tb).getPLVtieuDe() %>
                    <% } else { %>
                        <%= ((PLVThongBaoCaNhan) tb).getPLVtieuDe() %>
                    <% } %>
                </div>
                <div class="noi-dung">
                    <% if (tb instanceof PLVThongBao) { %>
                        <%= ((PLVThongBao) tb).getPLVnoiDung() %>
                    <% } else { %>
                        <%= ((PLVThongBaoCaNhan) tb).getPLVnoiDung() %>
                    <% } %>
                </div>
            </div>
        <% 
                }
            } else {
        %>
            <p class="message">Vui lòng đăng nhập để xem thông báo.</p>
        <% } %>
    </div>
</body>
</html>
