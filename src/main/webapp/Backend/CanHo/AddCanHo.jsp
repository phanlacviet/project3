<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
        @import url('https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css');
body {
    font-family: Arial, sans-serif;
    background: linear-gradient(to right, #74ebd5, #acb6e5);
    margin: 0;
    padding: 0;
}

/* Điều chỉnh lại layout chính */
.container {
    max-width: 1200px;
    margin: 20px auto; /* Tránh bị đè lên header */
    padding: 20px;
}

/* Tiêu đề */
h2 {
    color: #333;
    font-size: 28px;
    text-align: center;
    margin-bottom: 20px;
    font-weight: bold;
}

/* Form container */
.form-container {
    width: 400px;
    background: white;
    padding: 25px;
    border-radius: 12px;
    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
    transition: transform 0.3s ease-in-out;
    position: relative;
    margin: 40px auto; /* Tránh đè header */
}

.form-container:hover {
    transform: scale(1.02);
}

/* Nhóm input */
.form-group {
    display: flex;
    align-items: center;
    margin-bottom: 15px;
    position: relative;
}

.form-group label {
    font-size: 16px;
    font-weight: 600;
    min-width: 120px;
}

.form-group input {
    flex: 1;
    padding: 10px 40px 10px 12px;
    border: 1px solid #ddd;
    border-radius: 6px;
    font-size: 16px;
    transition: 0.3s;
}

.form-group input:focus {
    border-color: #007bff;
    outline: none;
    box-shadow: 0 0 5px rgba(0, 123, 255, 0.5);
}

/* Icon input */
.form-group i {
    position: absolute;
    right: 12px;
    color: #777;
    font-size: 18px;
}

/* Nút submit */
input[type="submit"] {
    width: 100%;
    background-color: #007bff;
    color: white;
    border: none;
    cursor: pointer;
    font-size: 18px;
    font-weight: bold;
    padding: 12px;
    border-radius: 6px;
    transition: background 0.3s, transform 0.2s;
}

input[type="submit"]:hover {
    background-color: #0056b3;
    transform: translateY(-2px);
}

/* Nút quay lại */
.back-link {
    display: block;
    margin-top: 15px;
    padding: 12px 20px;
    font-size: 16px;
    font-weight: bold;
    color: white;
    background: #28a745;
    border-radius: 6px;
    text-decoration: none;
    transition: background 0.3s, transform 0.2s;
    text-align: center;
}

.back-link:hover {
    background: #218838;
    transform: translateY(-2px);
}

/* Hiển thị thông báo lỗi */
.error-message {
    color: red;
    text-align: center;
    margin-top: 10px;
}

    </style>
</head>
<body>
	<div class="form-container">
    <h2>Thêm căn hộ mới</h2>
    <form action="AddCanHo" method="POST">
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