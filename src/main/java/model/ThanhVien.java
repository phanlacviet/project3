package model;

public class ThanhVien {
    private String taiKhoanTV;
    private String matKhau;
    private String hoTen;
    private String email;
    private boolean isDeleted;

    public ThanhVien() {}

    public ThanhVien(String taiKhoanTV, String matKhau, String hoTen, String email, boolean isDeleted) {
        this.taiKhoanTV = taiKhoanTV;
        this.matKhau = matKhau;
        this.hoTen = hoTen;
        this.email = email;
        this.isDeleted = isDeleted;
    }

    public String getTaiKhoanTV() {
        return taiKhoanTV;
    }

    public void setTaiKhoanTV(String taiKhoanTV) {
        this.taiKhoanTV = taiKhoanTV;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
}
