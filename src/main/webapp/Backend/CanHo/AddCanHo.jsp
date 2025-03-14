<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/Backend/css/Add.css">
</head>
<body>
<jsp:include page="/Backend/RightLayout.jsp" />
	<div class="form-container">
    <h2>Thêm căn hộ mới</h2>
    <form action="PLVAddCanHo" method="POST">
        <div class="form-group">
            <label for="tenCH">Tên căn hộ:</label>
            <input type="text" id="tenCH" name="tenCH" required>
            <i class="fa fa-building"></i>
        </div>

        <div class="form-group">
            <label for="dienTich">Diện tích:</label>
            <input type="text" id="dienTich" name="dienTich" required>
            <i class="fa fa-ruler"></i>
        </div>

        <div class="form-group">
            <label for="gia">Giá:</label>
            <input type="text" id="gia" name="gia" required>
            <i class="fa fa-dollar-sign"></i>
        </div>

        <input type="submit" value="Thêm căn hộ">
    </form>

    <a href="BangCanHo.jsp" class="back-link">Trở Về Danh Sách Căn hộ</a>
</div>

    
    <div class="error-message">
        <c:if test="${not empty errorMessage}">
            ${errorMessage}
        </c:if>
    </div>
</body>
</html>