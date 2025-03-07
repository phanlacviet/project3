package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.QLChungCuDAO;
import model.CanHo;

/**
 * Servlet implementation class UpdateCanHo
 */
@WebServlet("/Backend/CanHo/UpdateCanHo")
public class UpdateCanHo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private QLChungCuDAO qlchungcu;
	
    public UpdateCanHo() {
        super();
    }
    public void init() {
    	qlchungcu = new QLChungCuDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idCanHoParam = request.getParameter("idCanHo");
        
        // Kiểm tra nếu tham số hợp lệ
        if (idCanHoParam != null && !idCanHoParam.trim().isEmpty()) {
            try {
                int idCanHo = Integer.parseInt(idCanHoParam); // Cố gắng chuyển ID thành số nguyên
                CanHo canho = qlchungcu.getIdCanHo(idCanHo);
                if (canho != null) {
                    request.setAttribute("CanHo", canho); // Truyền đối tượng CanHo vào JSP
                    RequestDispatcher dispatcher = request.getRequestDispatcher("UpdateCanHo.jsp");
                    dispatcher.forward(request, response);
                } else {
                    // Nếu không tìm thấy ID, chuyển hướng hoặc hiển thị thông báo lỗi
                    response.sendError(HttpServletResponse.SC_NOT_FOUND, "Căn hộ không tồn tại");
                }
            } catch (NumberFormatException e) {
                // Nếu ID không thể chuyển thành số nguyên, gửi lỗi
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID căn hộ không hợp lệ");
            }
        } else {
            // Nếu ID bị thiếu hoặc rỗng, gửi lỗi
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID căn hộ không được cung cấp");
        }
    }



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idCanHoParam = request.getParameter("idCanHo");
        String tenCH = request.getParameter("tenCH");
        String dienTichParam = request.getParameter("dienTich");
        String giaParam = request.getParameter("gia");
        String trangThaiparam = request.getParameter("trangThai");

        // Kiểm tra nếu tham số hợp lệ
        if (idCanHoParam != null && !idCanHoParam.trim().isEmpty() &&
            tenCH != null && !tenCH.trim().isEmpty() &&
            dienTichParam != null && !dienTichParam.trim().isEmpty() &&
            giaParam != null && !giaParam.trim().isEmpty()) {
            
            try {
                int idCanHo = Integer.parseInt(idCanHoParam);
                int dienTich = Integer.parseInt(dienTichParam);
                double gia = Double.parseDouble(giaParam);

                CanHo updatedCanHo = new CanHo(idCanHo, tenCH, dienTich, gia, false, false); // Trang thái giả sử là `true`

                // Cập nhật thông tin căn hộ vào cơ sở dữ liệu
                qlchungcu.updateCanHo(updatedCanHo);

                // Chuyển hướng về danh sách căn hộ sau khi cập nhật thành công
                response.sendRedirect("BangCanHo.jsp");

            } catch (NumberFormatException e) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Dữ liệu không hợp lệ");
            }
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Thông tin cập nhật không đầy đủ");
        }
	}

}
