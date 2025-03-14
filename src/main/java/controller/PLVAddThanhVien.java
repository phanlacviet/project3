package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.PLVQLChungCuDAO;
import model.PLVThanhVien;

@WebServlet("/Backend/ThanhVien/PLVAddThanhVien")
public class PLVAddThanhVien extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html; charset=UTF-8");
        String taiKhoanTV = request.getParameter("taiKhoanTV");
        String matKhau = request.getParameter("matKhau");
        String hoTen = request.getParameter("hoTen");
        String email = request.getParameter("email");

        PLVThanhVien thanhVien = new PLVThanhVien(taiKhoanTV, matKhau, hoTen, email, false);
        PLVQLChungCuDAO dao = new PLVQLChungCuDAO();
        dao.addThanhVien(thanhVien);

        response.sendRedirect("BangThanhVien.jsp");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html; charset=UTF-8");
		RequestDispatcher dispatcher = request.getRequestDispatcher("AddThanhVien.jsp");
        dispatcher.forward(request, response);
	}
}