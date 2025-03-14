package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.PLVQLChungCuDAO;

@WebServlet("/Frontend/PLVDangKyDichVu")
public class PLVDangKyDichVu extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public PLVDangKyDichVu() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        int idDichVu = Integer.parseInt(request.getParameter("idDichVu"));
        String taiKhoanTV = request.getParameter("taiKhoanTV");
        String action = request.getParameter("action");

       
        PLVQLChungCuDAO dao = new PLVQLChungCuDAO();

      
        if ("dangky".equals(action)) {
            dao.dangKyDichVu(idDichVu, taiKhoanTV);
        } else if ("huy".equals(action)) {
            dao.huyDangKyDichVu(idDichVu, taiKhoanTV);
        }

        // Chuyển hướng người dùng trở lại trang dichvu.jsp
        response.sendRedirect(request.getContextPath() + "/Frontend/DichVu.jsp");
    }
}