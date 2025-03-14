package controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.PLVQLChungCuDAO;
import model.PLVThongBaoCaNhan;

@WebServlet("/Backend/ThongBao/PLVAddThongBaoCaNhan")
public class PLVAddThongBaoCaNhan extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public PLVAddThongBaoCaNhan() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
        request.getRequestDispatcher("AddThongBaoCaNhan.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
        String taiKhoanTV = request.getParameter("taiKhoanTV");
        String tieuDe = request.getParameter("tieuDe");
        String noiDung = request.getParameter("noiDung");

        if (taiKhoanTV != null && !taiKhoanTV.isEmpty() && tieuDe != null && noiDung != null) {
            PLVThongBaoCaNhan thongBao = new PLVThongBaoCaNhan();
            thongBao.setPLVtaiKhoanTV(taiKhoanTV);
            thongBao.setPLVtieuDe(tieuDe);
            thongBao.setPLVnoiDung(noiDung);
            thongBao.setPLVngayGui(Date.valueOf(LocalDate.now()));
            thongBao.setDeleted(false);

            PLVQLChungCuDAO dao = new PLVQLChungCuDAO();
            dao.AddThongBaoCaNhan(thongBao);

            response.sendRedirect("QuanLyThongBaoCaNhan.jsp");
        } else {
            response.getWriter().write("Vui lòng nhập đầy đủ thông tin!");
        }
    }
}
