<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cập Nhật Căn Hộ</title>
    
</head>
<body>
<jsp:include page="/Backend/RightLayout.jsp" />
    <h2>Cập Nhật Căn Hộ</h2>
    <form action="UpdateCanHo" method="post">
        <input type="hidden" name="idCanHo" value="${CanHo.idCanHo}">
        <label for="tenCH">Tên Căn Hộ:</label>
        <input type="text" name="tenCH" id="tenCH" value="${CanHo.tenCH}" required><br>
        <label for="dienTich">Diện Tích:</label>
        <input type="text" name="dienTich" id="dienTich" value="${CanHo.dienTich}" required><br>
        <label for="gia">Giá:</label>
        <input type="text" name="gia" id="gia" value="${CanHo.gia}" required><br>
        <input type="hidden" name="trangThai" value="${CanHo.trangThai}">
        <button type="submit">Cập Nhật</button>
    </form>
    <br>
    <a href="${pageContext.request.contextPath}/BangCanHo.jsp">Về Trang Danh Sách</a>
</body>
</html>
