package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.PLVQLChungCuDAO;
import model.PLVDichVu;

@WebServlet("/Backend/DichVu/PLVGetDichVuChuaDangKy")
public class PLVGetDichVuChuaDangKy extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String taiKhoanTV = request.getParameter("taiKhoanTV");

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

 
        if (taiKhoanTV == null || taiKhoanTV.trim().isEmpty()) {
            out.write("<option value=''>-- Chọn tài khoản trước --</option>");
            return;
        }


        PLVQLChungCuDAO dao = new PLVQLChungCuDAO();
        List<PLVDichVu> danhSachDichVu = dao.getDichVuChuaDangKyByTaiKhoanTV(taiKhoanTV);

        if (danhSachDichVu.isEmpty()) {
            out.write("<option value=''>-- Không có dịch vụ --</option>");
        } else {
            for (PLVDichVu dichVu : danhSachDichVu) {
                out.write("<option value='" + dichVu.getPLVidDichVu() + "'>");
                out.write(dichVu.getPLVtenDV() + " - " + dichVu.getPLVgiaThue() + " VNĐ");
                out.write("</option>");
            }
        }
    }
}
