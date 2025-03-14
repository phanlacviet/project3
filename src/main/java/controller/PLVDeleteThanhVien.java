package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.PLVQLChungCuDAO;

@WebServlet("/Backend/ThanhVien/PLVDeleteThanhVien")
public class PLVDeleteThanhVien extends HttpServlet {
private PLVQLChungCuDAO qlchungcu;
    
    public void init() {
    	qlchungcu = new PLVQLChungCuDAO();    }
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String taiKhoanTV = request.getParameter("taiKhoanTV");
        String action = request.getParameter("action");

        if ("delete".equals(action)) {
        	qlchungcu.deleteThanhVien(taiKhoanTV);
        } else if ("restore".equals(action)) {
        	qlchungcu.restoreThanhVien(taiKhoanTV);
        }

        response.sendRedirect("BangThanhVien.jsp");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}