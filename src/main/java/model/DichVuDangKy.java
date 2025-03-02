package model;

import java.util.Date;

public class DichVuDangKy {
    private int idDichVuDK;
    private String taiKhoanTV;
    private int idDichVu;
    private Date ngayDK;
    private boolean isDeleted;

    public DichVuDangKy() {}

    public DichVuDangKy(int idDichVuDK, String taiKhoanTV, int idDichVu, Date ngayDK, boolean isDeleted) {
        this.idDichVuDK = idDichVuDK;
        this.taiKhoanTV = taiKhoanTV;
        this.idDichVu = idDichVu;
        this.ngayDK = ngayDK;
        this.isDeleted = isDeleted;
    }

    public int getIdDichVuDK() {
        return idDichVuDK;
    }

    public void setIdDichVuDK(int idDichVuDK) {
        this.idDichVuDK = idDichVuDK;
    }

    public String getTaiKhoanTV() {
        return taiKhoanTV;
    }

    public void setTaiKhoanTV(String taiKhoanTV) {
        this.taiKhoanTV = taiKhoanTV;
    }

    public int getIdDichVu() {
        return idDichVu;
    }

    public void setIdDichVu(int idDichVu) {
        this.idDichVu = idDichVu;
    }

    public Date getNgayDK() {
        return ngayDK;
    }

    public void setNgayDK(Date ngayDK) {
        this.ngayDK = ngayDK;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
}
