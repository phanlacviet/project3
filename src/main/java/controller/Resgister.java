package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.QLChungCuDAO;
import model.ThanhVien;

@WebServlet("/Frontend/Register")
public class Resgister extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String taiKhoanTV = request.getParameter("taiKhoanTV");
        String matKhau = request.getParameter("matKhau");
        String hoTen = request.getParameter("hoTen");
        String email = request.getParameter("email");

        ThanhVien thanhVien = new ThanhVien(taiKhoanTV, matKhau, hoTen, email, false);

        QLChungCuDAO dao = new QLChungCuDAO();
        boolean isRegistered = dao.register(thanhVien);

        if (isRegistered) {
            response.sendRedirect("Login.jsp");
        } else {
            request.setAttribute("errorMessage", "Đăng ký thất bại. Vui lòng thử lại.");
            request.getRequestDispatcher("Register.jsp").forward(request, response);
        }
    }
}