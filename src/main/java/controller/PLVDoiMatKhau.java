package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.PLVQLChungCuDAO;

@WebServlet("/Frontend/PLVDoiMatKhau")
public class PLVDoiMatKhau extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public PLVDoiMatKhau() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String taiKhoanTV = request.getParameter("taiKhoanTV");
        String matKhauCu = request.getParameter("matKhauCu");
        String matKhauMoi = request.getParameter("matKhauMoi");
        PLVQLChungCuDAO dao = new PLVQLChungCuDAO();
        boolean result = dao.doiMatKhau(taiKhoanTV, matKhauCu, matKhauMoi);
        if (result) {
            response.sendRedirect(request.getContextPath() + "/Frontend/DoiMatKhau.jsp?success=true");
        } else {
            response.sendRedirect(request.getContextPath() + "/Frontend/DoiMatKhau.jsp?error=true");
        }
    }
}