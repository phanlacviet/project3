package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.QLChungCuDAO;
import model.DichVu;

/**
 * Servlet implementation class AddDichVu
 */
@WebServlet("/Backend/DichVu/AddDichVu")
public class AddDichVu extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    private QLChungCuDAO qlchungcu;
    
    public void init() {
    	qlchungcu = new QLChungCuDAO();    
    }
    public AddDichVu() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("AddDichVu.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tenDVStr = request.getParameter("tenDV");
		String giaStr = request.getParameter("giaThue");
            int gia = Integer.parseInt(giaStr.trim());
            // Tạo đối tượng BanHang
            DichVu dichvu = new DichVu();
            dichvu.setTenDV(tenDVStr.trim());
            dichvu.setGiaThue(gia);

            qlchungcu.AddDichVu(dichvu);
            response.sendRedirect("BangDichVu.jsp");
        
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
