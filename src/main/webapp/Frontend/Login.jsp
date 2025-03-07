<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đăng nhập</title>
    <style>
        /* CSS cho phần đăng nhập */
        body{
        	margin-top:140px;
        }
        .tieude{
        	text-align: center;
        }
        .auth-container{
        max-width: 400px;
	    margin: 50px auto;
	    padding: 20px;
	    border: 1px solid #ccc;
	    border-radius: 5px;
	    background-color: #f9f9f9;
	    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	    }
	    .auth-container h2 {
		    text-align: center;
		    margin-bottom: 20px;
		    color: #333;
		}
		
		.auth-container form {
		    display: flex;
		    flex-direction: column;
		}
		.auth-container label {
    margin-bottom: 5px;
    font-weight: bold;
    color: #555;
}

.auth-container input[type="text"],
.auth-container input[type="password"],
.auth-container input[type="email"] {
    padding: 10px;
    margin-bottom: 15px;
    border: 1px solid #ccc;
    border-radius: 3px;
    font-size: 16px;
	}
	
	.auth-container input[type="submit"] {
	    padding: 10px;
	    background-color: #28a745;
	    color: white;
	    border: none;
	    border-radius: 3px;
	    font-size: 16px;
	    cursor: pointer;
	}
	
	.auth-container input[type="submit"]:hover {
	    background-color: #218838;
	}
	
	.error-message {
	    color: red;
	    text-align: center;
	    margin-bottom: 15px;
	}
    </style>
</head>
<body>
    <jsp:include page="HeaderFrontend.jsp"/>
    <div class="auth-container">
        <h2>Đăng nhập</h2>
        <form action="Login" method="post" class="">
            <label for="taiKhoanTV" class="">Tài khoản:</label>
            <input type="text" id="taiKhoanTV" name="taiKhoanTV" required  class="">
            <label for="matKhau" class="">Mật khẩu:</label>
            <input type="password" id="matKhau" name="matKhau" required class="">
            <input type="submit" value="Đăng nhập" class="">
        </form>
    </div>
	<jsp:include page="FooterFrontend.jsp" />
</body>
</html>