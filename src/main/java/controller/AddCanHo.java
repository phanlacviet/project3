package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.QLChungCuDAO;
import model.CanHo;

/**
 * Servlet implementation class AddCanHo
 */
@WebServlet("/Backend/CanHo/AddCanHo")
public class AddCanHo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    private QLChungCuDAO qlchungcu;
    
    public void init() {
    	qlchungcu = new QLChungCuDAO();    }
    public AddCanHo() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tenCHStr = request.getParameter("tenCH");
		String dienTichStr = request.getParameter("dienTich");
		String giaStr = request.getParameter("gia");
            int dienTich = Integer.parseInt(dienTichStr.trim());
            int gia = Integer.parseInt(giaStr.trim());
            // Tạo đối tượng BanHang
            CanHo canho = new CanHo();
            canho.setTenCH(tenCHStr.trim());
            canho.setDienTich(dienTich);
            canho.setGia(gia);

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
