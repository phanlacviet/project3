<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/Backend/css/Add.css">
<body>
<jsp:include page="/Backend/RightLayout.jsp" />
<div class="form-container">
    <h2>Thêm dịch vụ mới</h2>
    <form action="PLVAddDichVu" method="POST">
        <div class="form-group">
            <label for="tenDV">Tên dịch vụ:</label>
            <input type="text" id="tenDV" name="tenDV" required>
            <i class="fa-solid fa-file-signature"></i>
        </div>

        <div class="form-group">
            <label for="giaThue">Giá:</label>
            <input type="text" id="giaThue" name="giaThue" required>
            <i class="fa-solid fa-address-book"></i>
        </div>
        <input type="submit" value="Thêm dịch vụ">
    </form>

    <a href="BangDichVu.jsp" class="back-link">Trở Về Danh Sách Dịch Vụ</a>
</div>

    
    <div class="error-message">
        <c:if test="${not empty errorMessage}">
            ${errorMessage}
        </c:if>
    </div>
</body>
</html>