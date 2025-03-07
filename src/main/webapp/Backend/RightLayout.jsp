<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Layout Navbar</title>
    
    <style>
        /* Đặt nền màu trắng */
        body {
            background-color: white;
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
        }

        /* Thanh nav */
        .navbar {
            background-color: #333;
            overflow: hidden;
            display: flex;
            justify-content: space-around;
            align-items: center;
            padding: 14px 20px;
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            z-index: 1000; /* Đảm bảo thanh nav ở trên cùng */
        }

        .navbar a {
            text-decoration: none;
            color: white;
            padding: 12px 16px;
            text-align: center;
            font-size: 16px;
            transition: 0.3s;
            border-radius: 5px;
        }

        /* Hiệu ứng hover */
        .navbar a:hover {
            background-color: #ddd;
            color: black;
        }

        /* Cung cấp khoảng trống cho nội dung phía dưới thanh navbar */
        body {
            padding-top: 60px; /* Điều chỉnh khoảng cách để tránh nội dung bị che khuất */
        }
    </style>
</head>
<body>

    <!-- Thanh điều hướng (Navbar) -->
    <div class="navbar">
        <a href="../CanHo/BangCanHo.jsp">Căn Hộ</a>
        <a href="../DichVu/BangDichVu.jsp">Dịch Vụ</a>
        <a href="../ThanhVien/BangThanhVien.jsp">Thành Viên</a>
        <a href="../DichVu/DichVuDangKy.jsp">Dịch Vụ Đăng ký</a>
        <a href="#">Gửi xe</a>
        <a href="#">Thông Báo</a>
        <a href="#">Thông Báo Cá Nhân</a>
        <a href="#">Phản Ánh</a>
    </div>

</body>
</html>
