package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.PLVQLChungCuDAO;

@WebServlet("/Frontend/PLVThemPhanAnh")
public class PLVThemPhanAnh extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public PLVThemPhanAnh() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
        String taiKhoanTV = request.getParameter("taiKhoanTV");
        String noiDung = request.getParameter("noiDung");
        PLVQLChungCuDAO dao = new PLVQLChungCuDAO();
        boolean result = dao.addPhanAnh(taiKhoanTV, noiDung);
        if (result) {
            response.sendRedirect(request.getContextPath() + "/Frontend/PhanAnh.jsp?success=true");
        } else {
            response.sendRedirect(request.getContextPath() + "/Frontend/PhanAnh.jsp?error=true");
        }
    }
}