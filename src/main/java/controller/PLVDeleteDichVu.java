package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.PLVQLChungCuDAO;

@WebServlet("/Backend/DichVu/PLVDeleteDichVu")
public class PLVDeleteDichVu extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private PLVQLChungCuDAO qlchungcu;

    public void init() {
        qlchungcu = new PLVQLChungCuDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idDichVu = Integer.parseInt(request.getParameter("idDichVu"));
        String action = request.getParameter("action"); 

        if ("delete".equals(action)) {
            qlchungcu.deleteDichVu(idDichVu); 
        } else if ("restore".equals(action)) {
            qlchungcu.restoreDichVu(idDichVu); 
        }

        response.sendRedirect("BangDichVu.jsp"); 
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}