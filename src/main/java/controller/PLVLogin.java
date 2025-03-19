package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import DAO.PLVQLChungCuDAO;
import model.PLVQuanTri;
import model.PLVThanhVien;

@WebServlet("/Frontend/PLVLogin")
public class PLVLogin extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String taiKhoanTV = request.getParameter("taiKhoanTV");
        String matKhau = request.getParameter("matKhau");

        PLVQLChungCuDAO dao = new PLVQLChungCuDAO();

        // Kiểm tra đăng nhập từ bảng quantri trước
        PLVQuanTri quanTri = dao.checkLoginQuanTri(taiKhoanTV, matKhau);
        if (quanTri != null) {
            HttpSession session = request.getSession();
            session.setAttribute("PLvAdmin", quanTri);
            response.sendRedirect(request.getContextPath() + "/Backend/CanHo/BangCanHo.jsp"); // Chuyển hướng đến trang quản trị
            return;
        }

        // Nếu không phải quản trị, kiểm tra đăng nhập từ bảng thanhvien
        PLVThanhVien thanhVien = dao.checkLogin(taiKhoanTV, matKhau);
        if (thanhVien != null) {
            HttpSession session = request.getSession();
            session.setAttribute("PLvMember", thanhVien);
            response.sendRedirect("CanHo.jsp"); // Chuyển hướng đến trang thành viên
        } else {
            request.setAttribute("errorMessage", "Tài khoản hoặc mật khẩu không đúng");
            request.getRequestDispatcher("/Frontend/Login.jsp").forward(request, response);
        }
    }
}