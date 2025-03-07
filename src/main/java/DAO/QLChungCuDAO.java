package DAO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.CanHo;
import model.ThanhVien;
import model.ThanhVienCanHo;
import model.DichVu;
import model.DichVuDangKy;
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
    			boolean trangThai = rs.getBoolean("trangThai");
    			boolean isDeleted = rs.getBoolean("isDeleted");
    			CanHo canho = new CanHo(idCanHo,tenCH,dienTich,gia,trangThai,isDeleted);
    			listcanHoChuaSoHuu.add(canho);
    		}
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    	return listcanHoChuaSoHuu;
    }
    public List<ThanhVienCanHo> getCanHoDaSoHuu(){
    	List<ThanhVienCanHo> listcanHoDaSoHuu = new ArrayList<>();
    	String query = "Select *From thanhviencanho";
    	try (Connection connection = connect();
    		PreparedStatement stmt = connection.prepareStatement(query);
    		ResultSet rs = stmt.executeQuery()) {
    		while (rs.next()) {
    			int idTVCH = rs.getInt("idTVCH");
    			String taiKhoanTV = rs.getString("taiKhoanTV");
    			int idCanHo = rs.getInt("idCanHo");
    			Date ngayMua = rs.getDate("ngayMua");
    			boolean isDeleted = rs.getBoolean("isDeleted");
    			ThanhVienCanHo canho = new ThanhVienCanHo(idTVCH,taiKhoanTV,idCanHo,ngayMua,isDeleted);
    			listcanHoDaSoHuu.add(canho);
    		}
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    	return listcanHoDaSoHuu;
    }
    public List<CanHo> getAllCanHo(){
    	List<CanHo> listCanHo = new ArrayList<>();
    	String query = "Select *From canho";
    	try (Connection connection = connect();
    		PreparedStatement stmt = connection.prepareStatement(query);
    		ResultSet rs = stmt.executeQuery()) {
    		while (rs.next()) {
    			int idCanHo = rs.getInt("idCanHo");
    			String tenCH = rs.getString("tenCH");
    			int dienTich = rs.getInt("dienTich");
    			int gia = rs.getInt("gia");
    			int trangThaiInt = rs.getInt("trangThai"); // Đọc giá trị dưới dạng int
                boolean trangThai = (trangThaiInt == 1);
    			boolean isDeleted = rs.getBoolean("isDeleted");
    			CanHo canho = new CanHo(idCanHo,tenCH,dienTich,gia,trangThai,isDeleted);
    			listCanHo.add(canho);
    		}
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    	return listCanHo;
    }
    public int getSoCanHoChuaSoHuu() {
    	int soluong = 0;
        String query = "{CALL proc_so_luong_can_ho_chua_so_huu(?)}";

        try (Connection connection = connect();
             CallableStatement stmt = connection.prepareCall(query)) {
            
            stmt.registerOutParameter(1, java.sql.Types.INTEGER); 
            stmt.execute(); 
            soluong = stmt.getInt(1);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return soluong;
    }
    public int getSoCanHoDaSoHuu() {
    	int soluong = 0;
        String query = "{CALL proc_so_luong_can_ho_da_so_huu(?)}";

        try (Connection connection = connect();
             CallableStatement stmt = connection.prepareCall(query)) {
            
            stmt.registerOutParameter(1, java.sql.Types.INTEGER);
            stmt.execute();
            soluong = stmt.getInt(1);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return soluong;
    }
    public void AddCanHo(CanHo canho) {
    	String query="Insert into canho(tenCH,dienTich,gia) value(?,?,?)";
    	try (Connection connection = connect();
                PreparedStatement stmt = connection.prepareStatement(query)) {
               stmt.setString(1, canho.getTenCH());
               stmt.setInt(2, canho.getDienTich());
               stmt.setDouble(3, canho.getGia());
               stmt.executeUpdate();
           } catch (SQLException e) {
               System.out.println("Lỗi khi thêm hàng hóa: " + e.getMessage());
               e.printStackTrace();
           }
    }
	public CanHo getIdCanHo(int idCanHo) {
		String query = "SELECT * FROM canho WHERE idCanHo = ?";
		try (Connection connection = connect();
	             PreparedStatement stmt = connection.prepareStatement(query)) {
	            stmt.setInt(1, idCanHo);
	            try (ResultSet rs = stmt.executeQuery()) {
	                if (rs.next()) {
	                	int idCanHo1 = rs.getInt("idCanHo");
	        			String tenCH = rs.getString("tenCH");
	        			int dienTich = rs.getInt("dienTich");
	        			int gia = rs.getInt("gia");
	        			int trangThaiInt = rs.getInt("trangThai"); // Đọc giá trị dưới dạng int
	                    boolean trangThai = (trangThaiInt == 1);
	        			boolean isDeleted = rs.getBoolean("isDeleted");
	        			return new CanHo(idCanHo1,tenCH,dienTich,gia,trangThai,isDeleted);
	              
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		return null;
	}
	public void updateCanHo(CanHo canho) {
	    String query = "UPDATE canho SET tenCH = ?, dienTich = ?, gia = ?, trangThai = ? WHERE idCanHo = ?";
	    try (Connection connection = connect();
	         PreparedStatement stmt = connection.prepareStatement(query)) {
	        
	        stmt.setString(1, canho.getTenCH());
	        stmt.setInt(2, canho.getDienTich());
	        stmt.setDouble(3, canho.getGia());
	        stmt.setBoolean(4, canho.getTrangThai());
	        stmt.setInt(5, canho.getIdCanHo());
	        
	        stmt.executeUpdate();
	    } catch (SQLException e) {
	        System.out.println("Lỗi khi cập nhật căn hộ: " + e.getMessage());
	        e.printStackTrace();
	    }
	}
	public List<ThanhVien> getAllThanhVien() {
		List<ThanhVien> listThanhVien = new ArrayList<>();
    	String query = "Select *From thanhvien";
    	try (Connection connection = connect();
    		PreparedStatement stmt = connection.prepareStatement(query);
    		ResultSet rs = stmt.executeQuery()) {
    		while (rs.next()) {
    			String taiKhoanTV = rs.getString("taiKhoanTV");
    			String matKhau = rs.getString("matKhau");
    			String hoTen = rs.getString("hoTen");
    			String email = rs.getString("email");
    			boolean isDeleted = rs.getBoolean("isDeleted");
    			ThanhVien thanhvien = new ThanhVien(taiKhoanTV,matKhau,hoTen,email,isDeleted);
    			listThanhVien.add(thanhvien);
    		}
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    	return listThanhVien;
	}
	public List<DichVu> getAllDichVu() {
		List<DichVu> listDichVu = new ArrayList<>();
    	String query = "Select *From dichvu";
    	try (Connection connection = connect();
    		PreparedStatement stmt = connection.prepareStatement(query);
    		ResultSet rs = stmt.executeQuery()) {
    		while (rs.next()) {
    			int idDichVu = rs.getInt("idDichVu");
    			String tenDV = rs.getString("tenDV");
    			int giaThue = rs.getInt("giaThue");
    			boolean isDeleted = rs.getBoolean("isDeleted");
    			DichVu dichvu = new DichVu(idDichVu,tenDV,giaThue,isDeleted);
    			listDichVu.add(dichvu);
    		}
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    	return listDichVu;
	}
	public void AddDichVu(DichVu dichvu) {
		String query="Insert into dichvu(tenDV,giathue) value(?,?)";
    	try (Connection connection = connect();
                PreparedStatement stmt = connection.prepareStatement(query)) {
               stmt.setString(1, dichvu.getTenDV());
               stmt.setInt(2, dichvu.getGiaThue());
               stmt.executeUpdate();
           } catch (SQLException e) {
               System.out.println("Lỗi khi thêm hàng hóa: " + e.getMessage());
               e.printStackTrace();
           }
	}
	public void UpdateDichVu(DichVu dichvu) {
		String sql = "UPDATE DichVu SET tenDV = ?, giaThue = ? WHERE idDichVu = ?";
		try (Connection connection = connect();
	         PreparedStatement stmt = connection.prepareStatement(sql)) {

	        stmt.setString(1, dichvu.getTenDV());
	        stmt.setInt(2, dichvu.getGiaThue());
	        stmt.setInt(3, dichvu.getIdDichVu());

	        stmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	public DichVu getDichVuById(int idDichVu) {
	    String query = "SELECT * FROM dichvu WHERE idDichVu = ?";
	    try (Connection connection = connect();
	         PreparedStatement stmt = connection.prepareStatement(query)) {
	        stmt.setInt(1, idDichVu);
	        try (ResultSet rs = stmt.executeQuery()) {
	            if (rs.next()) {
	                int idDichVu1 = rs.getInt("idDichVu");
	                String tenDV = rs.getString("tenDV");
	                int giaThue = rs.getInt("giaThue");
	                boolean IsDeleted = rs.getBoolean("IsDeleted");
	                return new DichVu(idDichVu1, tenDV, giaThue, IsDeleted);
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return null;
	}
	public List<DichVuDangKy> getAllDichVuDangKy() {
		List<DichVuDangKy> listDichVuDangKy = new ArrayList<>();
    	String query = "Select *From dichvudangky";
    	try (Connection connection = connect();
    		PreparedStatement stmt = connection.prepareStatement(query);
    		ResultSet rs = stmt.executeQuery()) {
    		while (rs.next()) {
    			int idDichVuDK = rs.getInt("idDichVuDK");
    			String taiKhoanTV = rs.getString("taiKhoanTV");
    			int idDichVu = rs.getInt("idDichVu");
    			Date ngayDK = rs.getDate("ngayDK");
    			boolean isDeleted = rs.getBoolean("isDeleted");
    			DichVuDangKy dichvudangky = new DichVuDangKy(idDichVuDK,taiKhoanTV,idDichVu,ngayDK,isDeleted);
    			listDichVuDangKy.add(dichvudangky);
    		}
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    	return listDichVuDangKy;
	}
	public ThanhVien checkLogin(String taiKhoanTV, String matKhau) {
        String query = "SELECT * FROM thanhvien WHERE taiKhoanTV = ? AND matKhau = ?";
        try (Connection connection = connect();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, taiKhoanTV);
            stmt.setString(2, matKhau);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String hoTen = rs.getString("hoTen");
                    String email = rs.getString("email");
                    boolean isDeleted = rs.getBoolean("isDeleted");
                    return new ThanhVien(taiKhoanTV, matKhau, hoTen, email, isDeleted);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
	public boolean register(ThanhVien thanhVien) {
        String query = "INSERT INTO thanhvien (taiKhoanTV, matKhau, hoTen, email) VALUES (?, ?, ?, ?)";
        try (Connection connection = connect();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, thanhVien.getTaiKhoanTV());
            stmt.setString(2, thanhVien.getMatKhau());
            stmt.setString(3, thanhVien.getHoTen());
            stmt.setString(4, thanhVien.getEmail());
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
