package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.PLVQLChungCuDAO;
import model.PLVCanHo;

/**
 * Servlet implementation class AddCanHo
 */
@WebServlet("/Backend/CanHo/PLVAddCanHo")
public class PLVAddCanHo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    private PLVQLChungCuDAO qlchungcu;
    
    public void init() {
    	qlchungcu = new PLVQLChungCuDAO();    }
    public PLVAddCanHo() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tenCHStr = request.getParameter("tenCH");
		String dienTichStr = request.getParameter("dienTich");
		String giaStr = request.getParameter("gia");
            int dienTich = Integer.parseInt(dienTichStr.trim());
            int gia = Integer.parseInt(giaStr.trim());
            
            PLVCanHo canho = new PLVCanHo();
            canho.setPLVTenCH(tenCHStr.trim());
            canho.setPLVDienTich(dienTich);
            canho.setPLVGia(gia);

            qlchungcu.AddCanHo(canho);
            response.sendRedirect("BangCanHo.jsp");
        
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("AddCanHo.jsp");
        dispatcher.forward(request, response);
	}

}
