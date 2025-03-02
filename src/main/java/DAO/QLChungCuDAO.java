package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.CanHo;
public class QLChungCuDAO {
	private String url = "jdbc:mysql://localhost:3306/phanlacviet_2210900079_project3";
    private String username = "root";
    private String password = "";
    public Connection connect() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("Không tìm thấy Driver MySQL", e);
        }
        return DriverManager.getConnection(url, username, password);
    }
    public List<CanHo> getCanHoChuaSoHuu(){
    	List<CanHo> listcanHoChuaSoHuu = new ArrayList<>();
    	String query = "Select *From canho Where trangThai=0";
    	try (Connection connection = connect();
    		PreparedStatement stmt = connection.prepareStatement(query);
    		ResultSet rs = stmt.executeQuery()) {
    		while (rs.next()) {
    			int idCanHo = rs.getInt("idCanHo");
    			String tenCH = rs.getString("tenCH");
    			int dienTich = rs.getInt("dienTich");
    			int gia = rs.getInt("gia");
    			
    			CanHo canho = new CanHo(idCanHo,tenCH,dienTich,gia);
    			listcanHoChuaSoHuu.add(canho);
    		}
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    	return listcanHoChuaSoHuu;
    } 
}
