<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thêm Thông Báo</title>
    <link rel="stylesheet" type="text/css" href="../css/thongbao.css">
</head>
<body>

    <jsp:include page="/Backend/RightLayout.jsp" />

    <div class="container-add-thongbao">
        <h2>Thêm Thông Báo</h2>

        <% if (request.getAttribute("message") != null) { %>
            <p class="message"><%= request.getAttribute("message") %></p>
        <% } %>

        <form action="PLVAddThongBao" method="post">
            <label for="tieuDe">Tiêu Đề:</label>
            <input type="text" id="tieuDe" name="tieuDe" required>

            <label for="noiDung">Nội Dung:</label>
            <textarea id="noiDung" name="noiDung" rows="5" required></textarea>

            <button type="submit">Gửi Thông Báo</button>
        </form>
    </div>

</body>
</html>
