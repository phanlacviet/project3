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
import model.PLVCanHo;
import model.PLVThanhVien;
import model.PLVThanhVienCanHo;
import model.PLVDichVu;
import model.PLVDichVuDangKy;
import model.PLVGuiXe;
import model.PLVPhanAnh;
import model.PLVThanhToan;
import model.PLVThongBao;
import model.PLVThongBaoCaNhan;
import model.PLVQuanTri;
public class PLVQLChungCuDAO {
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
    public List<PLVCanHo> getCanHoChuaSoHuu(){
    	List<PLVCanHo> listcanHoChuaSoHuu = new ArrayList<>();
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
    			PLVCanHo canho = new PLVCanHo(idCanHo,tenCH,dienTich,gia,trangThai,isDeleted);
    			listcanHoChuaSoHuu.add(canho);
    		}
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    	return listcanHoChuaSoHuu;
    }
    public List<PLVCanHo> getCanHoChuaSoHuuSapXep(String sapXep) {
        List<PLVCanHo> danhSachCanHo = new ArrayList<>();
        String query = "SELECT * FROM canho WHERE trangThai = 0";

        if (sapXep == null || sapXep.equals("reset")) {
            query += " ORDER BY idCanHo ASC";
        } else {
            switch (sapXep) {
                case "dienTichTang":
                    query += " ORDER BY dienTich ASC";
                    break;
                case "dienTichGiam":
                    query += " ORDER BY dienTich DESC";
                    break;
                case "giaTang":
                    query += " ORDER BY gia ASC";
                    break;
                case "giaGiam":
                    query += " ORDER BY gia DESC";
                    break;
                default:
                    query += " ORDER BY idCanHo ASC";
                    break;
            }
        }

        try (Connection connection = connect();
             PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                PLVCanHo canHo = new PLVCanHo(
                    rs.getInt("idCanHo"),
                    rs.getString("tenCH"),
                    rs.getInt("dienTich"),
                    rs.getInt("gia"),
                    rs.getBoolean("trangThai"),
                    rs.getBoolean("isDeleted")
                );
                danhSachCanHo.add(canHo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSachCanHo;
    }
    public List<PLVThanhVienCanHo> getCanHoDaSoHuu(){
    	List<PLVThanhVienCanHo> listcanHoDaSoHuu = new ArrayList<>();
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
    			PLVThanhVienCanHo canho = new PLVThanhVienCanHo(idTVCH,taiKhoanTV,idCanHo,ngayMua,isDeleted);
    			listcanHoDaSoHuu.add(canho);
    		}
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    	return listcanHoDaSoHuu;
    }
    public List<PLVCanHo> getAllCanHo(){
    	List<PLVCanHo> listCanHo = new ArrayList<>();
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
    			PLVCanHo canho = new PLVCanHo(idCanHo,tenCH,dienTich,gia,trangThai,isDeleted);
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
    public void AddCanHo(PLVCanHo canho) {
    	String query="Insert into canho(tenCH,dienTich,gia) value(?,?,?)";
    	try (Connection connection = connect();
                PreparedStatement stmt = connection.prepareStatement(query)) {
               stmt.setString(1, canho.getPLVTenCH());
               stmt.setInt(2, canho.getPLVDienTich());
               stmt.setDouble(3, canho.getPLVGia());
               stmt.executeUpdate();
           } catch (SQLException e) {
               System.out.println("Lỗi khi thêm hàng hóa: " + e.getMessage());
               e.printStackTrace();
           }
    }
	public PLVCanHo getIdCanHo(int idCanHo) {
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
	        			return new PLVCanHo(idCanHo1,tenCH,dienTich,gia,trangThai,isDeleted);
	              
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		return null;
	}
	public void updateCanHo(PLVCanHo canho) {
	    String query = "UPDATE canho SET tenCH = ?, dienTich = ?, gia = ?, trangThai = ? WHERE idCanHo = ?";
	    try (Connection connection = connect();
	         PreparedStatement stmt = connection.prepareStatement(query)) {
	        
	        stmt.setString(1, canho.getPLVTenCH());
	        stmt.setInt(2, canho.getPLVDienTich());
	        stmt.setDouble(3, canho.getPLVGia());
	        stmt.setBoolean(4, canho.getPLVTrangThai());
	        stmt.setInt(5, canho.getPLVIdCanHo());
	        
	        stmt.executeUpdate();
	    } catch (SQLException e) {
	        System.out.println("Lỗi khi cập nhật căn hộ: " + e.getMessage());
	        e.printStackTrace();
	    }
	}
	public List<PLVThanhVien> getAllThanhVien() {
		List<PLVThanhVien> listThanhVien = new ArrayList<>();
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
    			PLVThanhVien thanhvien = new PLVThanhVien(taiKhoanTV,matKhau,hoTen,email,isDeleted);
    			listThanhVien.add(thanhvien);
    		}
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    	return listThanhVien;
	}
	public List<PLVDichVu> getAllDichVu() {
		List<PLVDichVu> listDichVu = new ArrayList<>();
    	String query = "Select *From dichvu";
    	try (Connection connection = connect();
    		PreparedStatement stmt = connection.prepareStatement(query);
    		ResultSet rs = stmt.executeQuery()) {
    		while (rs.next()) {
    			int idDichVu = rs.getInt("idDichVu");
    			String tenDV = rs.getString("tenDV");
    			int giaThue = rs.getInt("giaThue");
    			boolean isDeleted = rs.getBoolean("isDeleted");
    			PLVDichVu dichvu = new PLVDichVu(idDichVu,tenDV,giaThue,isDeleted);
    			listDichVu.add(dichvu);
    		}
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    	return listDichVu;
	}
	public void AddDichVu(PLVDichVu dichvu) {
		String query="Insert into dichvu(tenDV,giathue) value(?,?)";
    	try (Connection connection = connect();
                PreparedStatement stmt = connection.prepareStatement(query)) {
               stmt.setString(1, dichvu.getPLVtenDV());
               stmt.setInt(2, dichvu.getPLVgiaThue());
               stmt.executeUpdate();
           } catch (SQLException e) {
               System.out.println("Lỗi khi thêm hàng hóa: " + e.getMessage());
               e.printStackTrace();
           }
	}
	public boolean addDichVuToThanhVien(String taiKhoanTV, int idDichVu) {
        String query = "INSERT INTO dichvudangky (taiKhoanTV, idDichVu, ngayDK, isDeleted) VALUES (?, ?, CURDATE(), 0)";
        
        try (Connection connection = connect();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, taiKhoanTV);
            stmt.setInt(2, idDichVu);

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
	public void UpdateDichVu(PLVDichVu dichvu) {
		String sql = "UPDATE DichVu SET tenDV = ?, giaThue = ? WHERE idDichVu = ?";
		try (Connection connection = connect();
	         PreparedStatement stmt = connection.prepareStatement(sql)) {

	        stmt.setString(1, dichvu.getPLVtenDV());
	        stmt.setInt(2, dichvu.getPLVgiaThue());
	        stmt.setInt(3, dichvu.getPLVidDichVu());

	        stmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	public PLVDichVu getDichVuById(int idDichVu) {
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
	                return new PLVDichVu(idDichVu1, tenDV, giaThue, IsDeleted);
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return null;
	}
	public boolean CheckDangKyDichVu(int idDichVu, String taiKhoanTV) {
	    String sql = "SELECT COUNT(*) FROM dichvudangky WHERE idDichVu = ? AND taiKhoanTV = ? AND isDeleted = 0";
	    try (Connection conn = connect();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {
	        stmt.setInt(1, idDichVu);
	        stmt.setString(2, taiKhoanTV);
	        ResultSet rs = stmt.executeQuery();
	        if (rs.next()) {
	            return rs.getInt(1) > 0;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return false;
	}
	public void dangKyDichVu(int idDichVu, String taiKhoanTV) {
	    String sql = "INSERT INTO dichvudangky (taiKhoanTV, idDichVu, ngayDK, isDeleted) VALUES (?, ?, CURDATE(), 0)";
	    try (Connection conn = connect();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {
	        stmt.setString(1, taiKhoanTV);
	        stmt.setInt(2, idDichVu);
	        stmt.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	public void huyDangKyDichVu(int idDichVu, String taiKhoanTV) {
	    String sql = "UPDATE dichvudangky SET isDeleted = 1 WHERE taiKhoanTV = ? AND idDichVu = ?";
	    try (Connection conn = connect();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {
	        stmt.setString(1, taiKhoanTV);
	        stmt.setInt(2, idDichVu);
	        stmt.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	public List<PLVDichVu> getDichVuChuaDangKyByTaiKhoanTV(String taiKhoanTV) {
	    List<PLVDichVu> danhSachDichVu = new ArrayList<>();
	    String query = "SELECT * FROM dichvu WHERE idDichVu NOT IN (SELECT idDichVu FROM dichvudangky WHERE taiKhoanTV = ?)";
	    
	    try (Connection connection = connect();
	         PreparedStatement stmt = connection.prepareStatement(query)) {
	        stmt.setString(1, taiKhoanTV);
	        try (ResultSet rs = stmt.executeQuery()) {
	            while (rs.next()) {
	                int idDichVu = rs.getInt("idDichVu");
	                String tenDV = rs.getString("tenDV");
	                int giaThue = rs.getInt("giaThue");
	                boolean isDeleted = rs.getBoolean("isDeleted");
	                
	                danhSachDichVu.add(new PLVDichVu(idDichVu, tenDV, giaThue, isDeleted));
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return danhSachDichVu; 
	}
	public List<PLVDichVuDangKy> getAllDichVuDangKy() {
		List<PLVDichVuDangKy> listDichVuDangKy = new ArrayList<>();
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
    			PLVDichVuDangKy dichvudangky = new PLVDichVuDangKy(idDichVuDK,taiKhoanTV,idDichVu,ngayDK,isDeleted);
    			listDichVuDangKy.add(dichvudangky);
    		}
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    	return listDichVuDangKy;
	}
	public PLVThanhVien checkLogin(String taiKhoanTV, String matKhau) {
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
                    return new PLVThanhVien(taiKhoanTV, matKhau, hoTen, email, isDeleted);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
	public PLVQuanTri checkLoginQuanTri(String taiKhoan, String matKhau) {
	    String query = "SELECT * FROM quantri WHERE taiKhoan = ? AND matKhau = ? AND isDeleted = 0";
	    try (Connection connection = connect();
	         PreparedStatement stmt = connection.prepareStatement(query)) {
	        stmt.setString(1, taiKhoan);
	        stmt.setString(2, matKhau);
	        try (ResultSet rs = stmt.executeQuery()) {
	            if (rs.next()) {
	                int idQuanTri = rs.getInt("idQuanTri");
	                boolean isDeleted = rs.getBoolean("isDeleted");
	                return new PLVQuanTri(idQuanTri, taiKhoan, matKhau, isDeleted);
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return null;
	}
	public boolean register(PLVThanhVien thanhVien) {
        String query = "INSERT INTO thanhvien (taiKhoanTV, matKhau, hoTen, email) VALUES (?, ?, ?, ?)";
        try (Connection connection = connect();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, thanhVien.getPLVtaiKhoanTV());
            stmt.setString(2, thanhVien.getPLVmatKhau());
            stmt.setString(3, thanhVien.getPLVhoTen());
            stmt.setString(4, thanhVien.getPLVemail());
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
	public void deleteCanHo(int iD) {
		String query = "Update canho set isDeleted = 1 WHERE idCanHo = ?";
        try (Connection connection = connect();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, iD);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	public void restoreCanHo(int iD) {
	    String query = "Update canho set isDeleted = 0 WHERE idCanHo = ?";
	    try (Connection connection = connect();
	         PreparedStatement stmt = connection.prepareStatement(query)) {
	        stmt.setInt(1, iD);
	        stmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	public void deleteDichVu(int idDichVu) {
	    String query = "UPDATE dichvu SET isDeleted = 1 WHERE idDichVu = ?";
	    try (Connection connection = connect();
	         PreparedStatement stmt = connection.prepareStatement(query)) {
	        stmt.setInt(1, idDichVu);
	        stmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	public void restoreDichVu(int idDichVu) {
	    String query = "UPDATE dichvu SET isDeleted = 0 WHERE idDichVu = ?";
	    try (Connection connection = connect();
	         PreparedStatement stmt = connection.prepareStatement(query)) {
	        stmt.setInt(1, idDichVu);
	        stmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	public void addThanhVien(PLVThanhVien thanhVien) {
	    String query = "INSERT INTO thanhvien (taiKhoanTV, matKhau, hoTen, email) VALUES (?, ?, ?, ?)";
	    try (Connection connection = connect();
	         PreparedStatement stmt = connection.prepareStatement(query)) {
	        stmt.setString(1, thanhVien.getPLVtaiKhoanTV());
	        stmt.setString(2, thanhVien.getPLVmatKhau());
	        stmt.setString(3, thanhVien.getPLVhoTen());
	        stmt.setString(4, thanhVien.getPLVemail());
	        stmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	public void updateThanhVien(PLVThanhVien thanhVien) {
	    String query = "UPDATE thanhvien SET matKhau = ?, hoTen = ?, email = ? WHERE taiKhoanTV = ?";
	    try (Connection connection = connect();
	         PreparedStatement stmt = connection.prepareStatement(query)) {
	        stmt.setString(1, thanhVien.getPLVmatKhau());
	        stmt.setString(2, thanhVien.getPLVhoTen());
	        stmt.setString(3, thanhVien.getPLVemail());
	        stmt.setString(4, thanhVien.getPLVtaiKhoanTV());
	        stmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	public void deleteThanhVien(String taiKhoanTV) {
	    String query = "UPDATE thanhvien SET isDeleted = 1 WHERE taiKhoanTV = ?";
	    try (Connection connection = connect();
	         PreparedStatement stmt = connection.prepareStatement(query)) {
	        stmt.setString(1, taiKhoanTV);
	        stmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	public void restoreThanhVien(String taiKhoanTV) {
	    String query = "UPDATE thanhvien SET isDeleted = 0 WHERE taiKhoanTV = ?";
	    try (Connection connection = connect();
	         PreparedStatement stmt = connection.prepareStatement(query)) {
	        stmt.setString(1, taiKhoanTV);
	        stmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	public PLVThanhVien getThanhVienById(String taiKhoanTV) {
	    String query = "SELECT * FROM thanhvien WHERE taiKhoanTV = ?";
	    try (Connection connection = connect();
	         PreparedStatement stmt = connection.prepareStatement(query)) {
	        stmt.setString(1, taiKhoanTV);
	        try (ResultSet rs = stmt.executeQuery()) {
	            if (rs.next()) {
	                String matKhau = rs.getString("matKhau");
	                String hoTen = rs.getString("hoTen");
	                String email = rs.getString("email");
	                boolean isDeleted = rs.getBoolean("isDeleted");
	                return new PLVThanhVien(taiKhoanTV, matKhau, hoTen, email, isDeleted);
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return null;
	}
	public List<String> getAllTaiKhoanTV() {
		List<String> listTaiKhoanTV = new ArrayList<>();
    	String query = "Select taiKhoanTV From thanhvien";
    	try (Connection connection = connect();
    		PreparedStatement stmt = connection.prepareStatement(query);
    		ResultSet rs = stmt.executeQuery()) {
    		while (rs.next()) {
    			String taikhoan = rs.getString("taiKhoanTV");
    			listTaiKhoanTV.add(taikhoan);
    		}
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    	return listTaiKhoanTV;
	}
	public List<PLVGuiXe> getAllDanhSachXe(){
		List<PLVGuiXe> dsxe = new ArrayList<>();
		String query = "Select *from guixe";
		try (Connection connection = connect();
	    		PreparedStatement stmt = connection.prepareStatement(query);
	    		ResultSet rs = stmt.executeQuery()) {
	    		while (rs.next()) {
	    			int idXe = rs.getInt("idXe");
	    			String taiKhoanTV = rs.getString("taiKhoanTV");
	    			String bienXoXe = rs.getString("bienXoXe");
	    			Date ngayGui = rs.getDate("ngayGui");
	    			boolean isDeleted = rs.getBoolean("isDeleted");
	    			PLVGuiXe guixe = new PLVGuiXe(idXe,taiKhoanTV,bienXoXe,ngayGui,isDeleted);
	    			dsxe.add(guixe);
	    		}
	    	} catch (SQLException e) {
	    		e.printStackTrace();
	    	}
	    	return dsxe;
	}
	public List<PLVThongBao> getAllThongBao() {
        List<PLVThongBao> danhSachThongBao = new ArrayList<>();
        String query = "SELECT * FROM thongbao WHERE isDeleted = 0 ORDER BY idThongBao DESC";
        
        try (Connection connection = connect();
             PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                int idThongBao = rs.getInt("idThongBao");
                String tieuDe = rs.getString("tieuDe");
                String noiDung = rs.getString("noiDung");
                Date ngayGui = rs.getDate("ngayGui");
                boolean isDeleted = rs.getBoolean("isDeleted");

                PLVThongBao thongBao = new PLVThongBao(idThongBao, tieuDe, noiDung, ngayGui, isDeleted);
                danhSachThongBao.add(thongBao);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSachThongBao;
    }
	public boolean addThongBao(PLVThongBao thongBao) {
        String query = "INSERT INTO thongbao (tieuDe, noiDung, ngayGui, isDeleted) VALUES (?, ?, CURDATE(), 0)";
        
        try (Connection connection = connect();
             PreparedStatement stmt = connection.prepareStatement(query)) {
             
            stmt.setString(1, thongBao.getPLVtieuDe());
            stmt.setString(2, thongBao.getPLVnoiDung());

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
	public List<PLVThongBaoCaNhan> getAllThongBaoCaNhan() {
	    List<PLVThongBaoCaNhan> danhSachThongBao = new ArrayList<>();
	    String query = "SELECT * FROM thongbaocanhan WHERE isDeleted = 0 ORDER BY idTBCN DESC";
	    
	    try (Connection connection = connect();
	         PreparedStatement stmt = connection.prepareStatement(query);
	         ResultSet rs = stmt.executeQuery()) {
	        
	        while (rs.next()) {
	            PLVThongBaoCaNhan tb = new PLVThongBaoCaNhan(
	                rs.getInt("idTBCN"),
	                rs.getString("taiKhoanTV"),
	                rs.getString("tieuDe"),
	                rs.getString("noiDung"),
	                rs.getDate("ngayGui"),
	                rs.getBoolean("isDeleted")
	            );
	            danhSachThongBao.add(tb);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return danhSachThongBao;
	}
	public List<PLVThongBaoCaNhan> getAllThongBaoCaNhanByTaiKhoanTV(String taiKhoanTV) {
	    List<PLVThongBaoCaNhan> danhSach = new ArrayList<>();
	    String sql = "SELECT * FROM thongbaocanhan WHERE taiKhoanTV = ? AND isDeleted = 0";

	    try (Connection connection = connect();
		         PreparedStatement stmt = connection.prepareStatement(sql)) {

	        stmt.setString(1, taiKhoanTV);
	        ResultSet rs = stmt.executeQuery();

	        while (rs.next()) {
	            PLVThongBaoCaNhan tb = new PLVThongBaoCaNhan();
	            tb.setPLVidTBCN(rs.getInt("idTBCN"));
	            tb.setPLVtaiKhoanTV(rs.getString("taiKhoanTV"));
	            tb.setPLVtieuDe(rs.getString("tieuDe"));
	            tb.setPLVnoiDung(rs.getString("noiDung"));
	            tb.setPLVngayGui(rs.getDate("ngayGui"));
	            danhSach.add(tb);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return danhSach;
	}
	public void AddThongBaoCaNhan(PLVThongBaoCaNhan thongBao) {
	    String query = "INSERT INTO thongbaocanhan (taiKhoanTV, tieuDe, noiDung, ngayGui, isDeleted) VALUES (?, ?, ?, CURDATE(), 0)";
	    
	    try (Connection connection = connect();
	         PreparedStatement stmt = connection.prepareStatement(query)) {
	        
	        stmt.setString(1, thongBao.getPLVtaiKhoanTV());
	        stmt.setString(2, thongBao.getPLVtieuDe());
	        stmt.setString(3, thongBao.getPLVnoiDung());
	        
	        stmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	public List<PLVPhanAnh> getAllPhanAnh() {
        List<PLVPhanAnh> list = new ArrayList<>();
        String query = "SELECT * FROM PhanAnh WHERE isDeleted = 0";
        try (Connection connection = connect();
             PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                PLVPhanAnh phanAnh = new PLVPhanAnh(
                    rs.getInt("idPhanAnh"),
                    rs.getString("taiKhoanTV"),
                    rs.getString("noiDung"),
                    rs.getDate("ngayGui"),
                    rs.getBoolean("isDeleted")
                );
                list.add(phanAnh);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean addPhanAnh(String taiKhoanTV, String noiDung) {
        String query = "INSERT INTO PhanAnh (taiKhoanTV, noiDung, ngayGui, isDeleted) VALUES (?, ?, CURDATE(), 0)";
        try (Connection connection = connect();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, taiKhoanTV);
            stmt.setString(2, noiDung);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public List<PLVThanhToan> getAllThanhToanByTaiKhoanTV(String taiKhoanTV) {
        List<PLVThanhToan> danhSach = new ArrayList<>();
        String sql = "SELECT * FROM thanhtoan WHERE taiKhoanTV = ? ORDER BY ngayThanhToan DESC";

        try (Connection connection = connect();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, taiKhoanTV);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                PLVThanhToan tt = new PLVThanhToan();
                tt.setPLVidThanhToan(rs.getInt("idThanhToan"));
                tt.setPLVtaiKhoanTV(rs.getString("taiKhoanTV"));
                tt.setPLVsoTien(rs.getDouble("soTien"));
                tt.setPLVngayThanhToan(rs.getDate("ngayThanhToan"));
                tt.setPLVisDeleted(rs.getBoolean("isDeleted"));

                danhSach.add(tt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return danhSach;
    }
    public List<String> getCanHoDaSoHuuByTaiKhoanTV(String taiKhoanTV) {
        List<String> danhSachCanHo = new ArrayList<>();
        String query = "SELECT c.tenCH FROM thanhviencanho t JOIN canho c ON t.idCanHo = c.idCanHo WHERE t.taiKhoanTV = ? AND t.isDeleted = 0";
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, taiKhoanTV);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                danhSachCanHo.add(rs.getString("tenCH"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return danhSachCanHo;
    }
    public List<PLVDichVu> getDichVuDaDangKyByTaiKhoanTV(String taiKhoanTV) {
        List<PLVDichVu> danhSachDichVu = new ArrayList<>();
        String query = "SELECT d.* FROM dichvudangky dv JOIN dichvu d ON dv.idDichVu = d.idDichVu WHERE dv.taiKhoanTV = ? AND dv.isDeleted = 0";

        try (Connection connection = connect();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, taiKhoanTV);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                PLVDichVu dichVu = new PLVDichVu(
                    rs.getInt("idDichVu"),
                    rs.getString("tenDV"),
                    rs.getInt("giaThue"),
                    rs.getBoolean("isDeleted")
                );
                danhSachDichVu.add(dichVu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSachDichVu;
    }
    public List<PLVThongBao> getTop3ThongBaoMoiNhat() {
        List<PLVThongBao> danhSachThongBao = new ArrayList<>();
        String query = "SELECT * FROM thongbao WHERE isDeleted = 0 ORDER BY ngayGui DESC LIMIT 3";

        try (Connection connection = connect();
             PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                PLVThongBao thongBao = new PLVThongBao(
                    rs.getInt("idThongBao"),
                    rs.getString("tieuDe"),
                    rs.getString("noiDung"),
                    rs.getDate("ngayGui"),
                    rs.getBoolean("isDeleted")
                );
                danhSachThongBao.add(thongBao);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSachThongBao;
    }
    public List<PLVPhanAnh> getTop3PhanAnhMoiNhatByTaiKhoanTV(String taiKhoanTV) {
        List<PLVPhanAnh> danhSachPhanAnh = new ArrayList<>();
        String query = "SELECT * FROM phananh WHERE taiKhoanTV = ? AND isDeleted = 0 ORDER BY ngayGui DESC LIMIT 3";

        try (Connection connection = connect();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, taiKhoanTV);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                PLVPhanAnh phanAnh = new PLVPhanAnh(
                    rs.getInt("idPhanAnh"),
                    rs.getString("taiKhoanTV"),
                    rs.getString("noiDung"),
                    rs.getDate("ngayGui"),
                    rs.getBoolean("isDeleted")
                );
                danhSachPhanAnh.add(phanAnh);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSachPhanAnh;
    }
    public boolean doiMatKhau(String taiKhoanTV, String matKhauCu, String matKhauMoi) {
        String queryCheck = "SELECT * FROM thanhvien WHERE taiKhoanTV = ? AND matKhau = ?";
        String queryUpdate = "UPDATE thanhvien SET matKhau = ? WHERE taiKhoanTV = ?";

        try (Connection connection = connect();
             PreparedStatement stmtCheck = connection.prepareStatement(queryCheck);
             PreparedStatement stmtUpdate = connection.prepareStatement(queryUpdate)) {
            stmtCheck.setString(1, taiKhoanTV);
            stmtCheck.setString(2, matKhauCu);
            ResultSet rs = stmtCheck.executeQuery();

            if (!rs.next()) {
                return false;
            }
            stmtUpdate.setString(1, matKhauMoi);
            stmtUpdate.setString(2, taiKhoanTV);

            int rowsAffected = stmtUpdate.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
