<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="model.PLVThanhVien" %>
<%@ page import="javax.servlet.http.HttpSession" %>

<%
    HttpSession sessionUser = request.getSession();
    PLVThanhVien thanhVien = (PLVThanhVien) sessionUser.getAttribute("PLvMember");

    // Kiểm tra xem người dùng đã đăng nhập chưa
    if (thanhVien == null) {
        response.sendRedirect(request.getContextPath() + "/Frontend/Login.jsp");
        return; // Dừng xử lý tiếp
    }

    String taiKhoanTV = thanhVien.getPLVtaiKhoanTV();
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đổi mật khẩu</title>
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/Frontend/css/doimatkhau.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
</head>
<body class="body-doimatkhau">
    <jsp:include page="HeaderFrontend.jsp"/>
    
    <div class="container-doimatkhau">
        <h2>Đổi mật khẩu</h2>
        <form action="PLVDoiMatKhau" method="post" class="form-doimatkhau">
            <input type="hidden" name="taiKhoanTV" value="<%= taiKhoanTV %>">
            
            <div class="form-group">
                <label for="matKhauCu">Mật khẩu cũ:</label>
                <input type="password" id="matKhauCu" name="matKhauCu" required>
            </div>
            
            <div class="form-group">
                <label for="matKhauMoi">Mật khẩu mới:</label>
                <input type="password" id="matKhauMoi" name="matKhauMoi" required>
            </div>
            
            <div class="form-group">
                <label for="nhapLaiMatKhauMoi">Nhập lại mật khẩu mới:</label>
                <input type="password" id="nhapLaiMatKhauMoi" name="nhapLaiMatKhauMoi" required>
            </div>
            
            <div class="form-group">
                <button type="submit" id="btnDoiMatKhau" disabled>Đổi mật khẩu</button>
            </div>
        </form>
        <%
	    String success = request.getParameter("success");
	    String error = request.getParameter("error");
		%>
		
		<% if (success != null && success.equals("true")) { %>
		    <div class="success-message">Đổi mật khẩu thành công!</div>
		<% } %>
		
		<% if (error != null && error.equals("true")) { %>
		    <div class="error-message">Mật khẩu cũ không đúng. Vui lòng thử lại!</div>
		<% } %>
    </div>

    <script>
        const matKhauMoi = document.getElementById("matKhauMoi");
        const nhapLaiMatKhauMoi = document.getElementById("nhapLaiMatKhauMoi");
        const btnDoiMatKhau = document.getElementById("btnDoiMatKhau");

        function kiemTraMatKhau() {
            if (matKhauMoi.value === nhapLaiMatKhauMoi.value && matKhauMoi.value !== "") {
                btnDoiMatKhau.disabled = false;
            } else {
                btnDoiMatKhau.disabled = true;
            }
        }

        matKhauMoi.addEventListener("input", kiemTraMatKhau);
        nhapLaiMatKhauMoi.addEventListener("input", kiemTraMatKhau);
    </script>
    
</body>
</html>