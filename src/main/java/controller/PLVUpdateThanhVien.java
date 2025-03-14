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

@WebServlet("/Backend/ThanhVien/PLVUpdateThanhVien")
public class PLVUpdateThanhVien extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private PLVQLChungCuDAO qlchungcu;
    public void init() {
    	qlchungcu = new PLVQLChungCuDAO();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html; charset=UTF-8");
        String taikhoantvparam = request.getParameter("taiKhoanTV");
        
        if (taikhoantvparam != null && !taikhoantvparam.trim().isEmpty()) {
            try {
            	String taiKhoanTV = taikhoantvparam;
                PLVThanhVien thanhvien = qlchungcu.getThanhVienById(taiKhoanTV);
                if (thanhvien != null) {
                    request.setAttribute("DichVu", thanhvien);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/Backend/ThanhVien/UpdateThanhVien.jsp");
                    dispatcher.forward(request, response);
                } else {
                    response.sendError(HttpServletResponse.SC_NOT_FOUND, "Thành viên không tồn tại");
                }
            } catch (NumberFormatException e) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Tài khoản thành viên không hợp lệ");
            }
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Tài khoản thành viên không được cung cấp");
        }
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html; charset=UTF-8");
        String taiKhoanTV = request.getParameter("taiKhoanTV");
        String matKhau = request.getParameter("matKhau");
        String hoTen = request.getParameter("hoTen");
        String email = request.getParameter("email");

        PLVThanhVien thanhVien = new PLVThanhVien(taiKhoanTV, matKhau, hoTen, email, false);
        PLVQLChungCuDAO dao = new PLVQLChungCuDAO();
        dao.updateThanhVien(thanhVien);

        response.sendRedirect("BangThanhVien.jsp");
    }
}