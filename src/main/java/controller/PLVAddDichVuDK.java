package controller;

import DAO.PLVQLChungCuDAO;
import model.PLVThanhVien;
import model.PLVDichVu;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Backend/DichVu/PLVAddDichVuDK")
public class PLVAddDichVuDK extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public PLVAddDichVuDK() {
        super();
    }



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String taiKhoanTV = request.getParameter("taiKhoanTV");
        String idDichVu = request.getParameter("idDichVu");

        PLVQLChungCuDAO dao = new PLVQLChungCuDAO();
        boolean isAdded = dao.addDichVuToThanhVien(taiKhoanTV, Integer.parseInt(idDichVu));

        if (isAdded) {
            response.sendRedirect("DichVuDangKy.jsp");
        } else {
            response.sendRedirect("error.jsp");
        }
    }
}
