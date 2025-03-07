<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/Backend/RightLayout.jsp" />
    <h2>Cập nhật dịch vụ</h2>
    <form action="UpdateDichVu" method="post">
        <input type="hidden" name="idDichVu" value="${DichVu.idDichVu}">
        <label for="tenCH">Tên Căn Hộ:</label>
        <input type="text" name="tenDV" id="tenDV" value="${DichVu.tenDV}" required><br>
        <label for="gia">Giá:</label>
        <input type="text" name="giaThue" id="giaThue" value="${DichVu.giaThue}" required><br>
        <button type="submit">Cập Nhật</button>
    </form>
    <br>
    <a href="${pageContext.request.contextPath}/BangDichVu.jsp">Về Trang Danh Sách</a>
</body>
</html>