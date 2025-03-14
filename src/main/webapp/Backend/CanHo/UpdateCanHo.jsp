<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cập Nhật Căn Hộ</title>
        <link rel="stylesheet" type="text/css" href="../css/Update.css">
</head>
<body>
<jsp:include page="/Backend/RightLayout.jsp" />
<div class="container">
    <h2>Cập Nhật Căn Hộ</h2>
    <form action="PLVUpdateCanHo" method="post">
        <input type="hidden" name="idCanHo" value="${CanHo.PLVIdCanHo}">
		<input type="text" name="tenCH" id="tenCH" value="${CanHo.PLVTenCH}" required><br>
		<input type="text" name="dienTich" id="dienTich" value="${CanHo.PLVDienTich}" required><br>
		<input type="text" name="gia" id="gia" value="${CanHo.PLVGia}" required><br>
		<input type="hidden" name="trangThai" value="${CanHo.PLVTrangThai}">
        <button type="submit">Cập Nhật</button>
    </form>
    <br>
    <a href="${pageContext.request.contextPath}/BangCanHo.jsp">Về Trang Danh Sách</a>
        </div>
</body>
</html>
