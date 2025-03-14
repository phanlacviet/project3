<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="DAO.PLVQLChungCuDAO, java.util.List, model.PLVThanhVien, model.PLVDichVu" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Chọn Thành Viên & Dịch Vụ</title>
    <link rel="stylesheet" type="text/css" href="../css/addDVDK.css">
    <script>
        function loadDichVu() {
            var taiKhoanTV = document.getElementById("taiKhoanTV").value;
            var xhr = new XMLHttpRequest();
            xhr.open("GET", "PLVGetDichVuChuaDangKy?taiKhoanTV=" + encodeURIComponent(taiKhoanTV), true);
            xhr.onreadystatechange = function () {
                if (xhr.readyState === 4 && xhr.status === 200) {
                    document.getElementById("dichVuList").innerHTML = xhr.responseText;
                }
            };
            xhr.send();
        }
    </script>
    
</head>
<body>
<jsp:include page="/Backend/RightLayout.jsp" />
<h2>Chọn Thành Viên & Dịch Vụ</h2>

<% 
    PLVQLChungCuDAO dao = new PLVQLChungCuDAO();
    List<PLVThanhVien> danhSachThanhVien = dao.getAllThanhVien();
%>

<form action="PLVAddDichVuDK" method="post">
    <!-- Danh sách tài khoản -->
    <label for="taiKhoanTV">Chọn tài khoản:</label>
    <select id="taiKhoanTV" name="taiKhoanTV" onchange="loadDichVu()">
        <option value="">-- Chọn tài khoản --</option>
        <% for (PLVThanhVien tv : danhSachThanhVien) { %>
            <option value="<%= tv.getPLVtaiKhoanTV() %>"><%= tv.getPLVtaiKhoanTV() %></option>
        <% } %>
    </select>

    <br><br>

    <!-- Danh sách dịch vụ chưa đăng ký -->
    <label for="dichVuList">Dịch vụ chưa đăng ký:</label>
    <select id="dichVuList" name="idDichVu">
        <option value="">-- Chọn dịch vụ --</option>
    </select>

    <br><br>
    <input type="submit" value="Thêm dịch vụ">
</form>

</body>
</html>
