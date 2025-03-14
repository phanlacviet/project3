package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import DAO.PLVQLChungCuDAO;
import model.PLVThanhVien;

@WebServlet("/Frontend/PLVLogin")
public class PLVLogin extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String taiKhoanTV = request.getParameter("taiKhoanTV");
        String matKhau = request.getParameter("matKhau");

        PLVQLChungCuDAO dao = new PLVQLChungCuDAO();
        PLVThanhVien thanhVien = dao.checkLogin(taiKhoanTV, matKhau);

        if (thanhVien != null) {
            HttpSession session = request.getSession();
            session.setAttribute("PLvMember", thanhVien);
            response.sendRedirect("CanHo.jsp");
        } else {
            request.setAttribute("errorMessage", "Tài khoản hoặc mật khẩu không đúng");
            request.getRequestDispatcher("/Frontend/Login.jsp").forward(request, response);
        }
    }
}