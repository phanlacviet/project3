package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.PLVQLChungCuDAO;

/**
 * Servlet implementation class DeleteCanHo
 */
@WebServlet("/Backend/CanHo/PLVDeleteCanHo")
public class PLVDeleteCanHo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private PLVQLChungCuDAO qlchungcu;
    
    public void init() {
    	qlchungcu = new PLVQLChungCuDAO();    }
    public PLVDeleteCanHo() {
        super();
        // TODO Auto-generated constructor stub
    }

	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int ID = Integer.parseInt(request.getParameter("idCanHo"));
        String action = request.getParameter("action"); 

        if ("delete".equals(action)) {
            qlchungcu.deleteCanHo(ID); 
        } else if ("restore".equals(action)) {
            qlchungcu.restoreCanHo(ID); 
        }

        response.sendRedirect("BangCanHo.jsp");
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
