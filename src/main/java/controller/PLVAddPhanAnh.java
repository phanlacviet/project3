package controller;

import DAO.PLVQLChungCuDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Backend/PhanAnh/PLVAddPhanAnh")
public class PLVAddPhanAnh extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public PLVAddPhanAnh() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html; charset=UTF-8");
        request.getRequestDispatcher("AddPhanAnh.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html; charset=UTF-8");
        String taiKhoanTV = request.getParameter("taiKhoanTV");
        String noiDung = request.getParameter("noiDung");

        PLVQLChungCuDAO dao = new PLVQLChungCuDAO();
        boolean success = dao.addPhanAnh(taiKhoanTV, noiDung);

        if (success) {
            response.sendRedirect("QuanLyPhanAnh.jsp");
        } else {
            response.getWriter().println("Lỗi khi thêm phản ánh.");
        }
    }
}
