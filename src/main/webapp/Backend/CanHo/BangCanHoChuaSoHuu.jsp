<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="DAO.PLVQLChungCuDAO, model.PLVCanHo,model.PLVThanhVienCanHo ,java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh Sách Căn Hộ</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        .container {
            width: 80%;
            margin: 20px auto;
        }
        .summary {
            display: flex;
            justify-content: space-around;
            margin-bottom: 20px;
        }
        .summary div {
            background: #f5f5f5;
            padding: 15px;
            border-radius: 10px;
            text-align: center;
            width: 45%;
            font-size: 18px;
            font-weight: bold;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 10px;
            text-align: center;
        }
        th {
            background: #f0f0f0;
        }
    </style>
</head>
<body>

    <!-- Include RightLayout.jsp -->
    <jsp:include page="/Backend/RightLayout.jsp" />
    <div class="container">
        <h2>Danh Sách Căn Hộ Chưa Sở Hữu</h2>

        <%
            // Khởi tạo DAO
            PLVQLChungCuDAO dao = new PLVQLChungCuDAO();
            
            // Lấy danh sách tất cả căn hộ
            List<PLVCanHo> listCanHo = dao.getCanHoChuaSoHuu();
        %>
        <a href="BangCanHo.jsp">Quay lại</a>
        <table>
            <tr>
                <th>ID</th>
                <th>Tên Căn Hộ</th>
                <th>Diện Tích</th>
                <th>Giá</th>
            </tr>
            <%
                for (PLVCanHo canho : listCanHo) {
            %>
            <tr>
                <td><%= canho.getPLVIdCanHo() %></td>
                <td><%= canho.getPLVTenCH() %></td>
                <td><%= canho.getPLVDienTich() %> m²</td>
                <td><%= canho.getPLVGia() %> VNĐ</td>
            </tr>
            <%
                }
            %>
        </table>
    </div>

</body>
</html>
