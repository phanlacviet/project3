package model;

public class PLVQuanTri {
    private int idQuanTri;
    private String taiKhoan;
    private String matKhau;
    private boolean isDeleted;

    public PLVQuanTri(int idQuanTri, String taiKhoan, String matKhau, boolean isDeleted) {
        this.idQuanTri = idQuanTri;
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
        this.isDeleted = isDeleted;
    }

    // Getter và Setter
    public int getIdQuanTri() {
        return idQuanTri;
    }

    public void setIdQuanTri(int idQuanTri) {
        this.idQuanTri = idQuanTri;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}