package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.PLVQLChungCuDAO;
import model.PLVDichVu;

/**
 * Servlet implementation class AddDichVu
 */
@WebServlet("/Backend/DichVu/PLVAddDichVu")
public class PLVAddDichVu extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    private PLVQLChungCuDAO qlchungcu;
    
    public void init() {
    	qlchungcu = new PLVQLChungCuDAO();    
    }
    public PLVAddDichVu() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		RequestDispatcher dispatcher = request.getRequestDispatcher("AddDichVu.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String tenDVStr = request.getParameter("tenDV");
		String giaStr = request.getParameter("giaThue");
            int gia = Integer.parseInt(giaStr.trim());
           
            PLVDichVu dichvu = new PLVDichVu();
            dichvu.setPLVtenDV(tenDVStr.trim());
            dichvu.setPLVgiaThue(gia);

            qlchungcu.AddDichVu(dichvu);
            response.sendRedirect("BangDichVu.jsp");
        
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
