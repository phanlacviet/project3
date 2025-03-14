package controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.PLVQLChungCuDAO;
import model.PLVThongBao;

@WebServlet("/Backend/ThongBao/PLVAddThongBao")
public class PLVAddThongBao extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public PLVAddThongBao() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html; charset=UTF-8");
        String tieuDe = request.getParameter("tieuDe");
        String noiDung = request.getParameter("noiDung");

        if (tieuDe == null || tieuDe.trim().isEmpty() || noiDung == null || noiDung.trim().isEmpty()) {
            request.setAttribute("message", "Vui lòng nhập đầy đủ thông tin!");
            request.getRequestDispatcher("AddThongBaoChung.jsp").forward(request, response);
            return;
        }

        
        PLVThongBao thongBao = new PLVThongBao(0, tieuDe, noiDung, new Date(), false);
        
        
        PLVQLChungCuDAO dao = new PLVQLChungCuDAO();
        boolean isSuccess = dao.addThongBao(thongBao);

        if (isSuccess) {
            response.sendRedirect("QuanLyThongBao.jsp");
        } else {
            request.setAttribute("message", "Có lỗi xảy ra, vui lòng thử lại!");
            request.getRequestDispatcher("AddThongBaoChung.jsp").forward(request, response);
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html; charset=UTF-8");
		RequestDispatcher dispatcher = request.getRequestDispatcher("AddThongBaoChung.jsp");
        dispatcher.forward(request, response);
	}
}
