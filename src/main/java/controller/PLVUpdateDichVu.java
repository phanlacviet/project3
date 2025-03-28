package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.PLVQLChungCuDAO;
import model.PLVDichVu;

@WebServlet("/Backend/DichVu/PLVUpdateDichVu")
public class PLVUpdateDichVu extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private PLVQLChungCuDAO qlchungcu;

    public PLVUpdateDichVu() {
        super();
    }
    public void init() {
    	qlchungcu = new PLVQLChungCuDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idDichVuParam = request.getParameter("idDichVu");
        
        if (idDichVuParam != null && !idDichVuParam.trim().isEmpty()) {
            try {
                int idDichVu = Integer.parseInt(idDichVuParam);
                PLVDichVu dichvu = qlchungcu.getDichVuById(idDichVu);
                if (dichvu != null) {
                    request.setAttribute("DichVu", dichvu);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/Backend/DichVu/UpdateDichVu.jsp");
                    dispatcher.forward(request, response);
                } else {
                    response.sendError(HttpServletResponse.SC_NOT_FOUND, "Dịch vụ không tồn tại");
                }
            } catch (NumberFormatException e) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID dịch vụ không hợp lệ");
            }
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID dịch vụ không được cung cấp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idDichVuParam = request.getParameter("idDichVu");
        String tenDV = request.getParameter("tenDV");
        String giaThueParam = request.getParameter("giaThue");

        if (idDichVuParam != null && !idDichVuParam.trim().isEmpty() &&
            tenDV != null && !tenDV.trim().isEmpty() &&
            giaThueParam != null && !giaThueParam.trim().isEmpty()) {
            
            try {
                int idDichVu = Integer.parseInt(idDichVuParam);
                int giaThue = Integer.parseInt(giaThueParam);

                PLVDichVu dichvu = new PLVDichVu(idDichVu, tenDV, giaThue, false);
                qlchungcu.UpdateDichVu(dichvu);
                
                response.sendRedirect("BangDichVu.jsp");
            } catch (NumberFormatException e) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Dữ liệu không hợp lệ");
            }
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Thông tin cập nhật không đầy đủ");
        }
    }
}