package model;

import java.util.Date;

public class ThanhVienCanHo {
    private int idTVCH;
    private String taiKhoanTV;
    private int idCanHo;
    private Date ngayMua;
    private boolean isDeleted;

    public ThanhVienCanHo() {}

    public ThanhVienCanHo(int idTVCH, String taiKhoanTV, int idCanHo, Date ngayMua, boolean isDeleted) {
        this.idTVCH = idTVCH;
        this.taiKhoanTV = taiKhoanTV;
        this.idCanHo = idCanHo;
        this.ngayMua = ngayMua;
        this.isDeleted = isDeleted;
    }

    public int getIdTVCH() {
        return idTVCH;
    }

    public void setIdTVCH(int idTVCH) {
        this.idTVCH = idTVCH;
    }

    public String getTaiKhoanTV() {
        return taiKhoanTV;
    }

    public void setTaiKhoanTV(String taiKhoanTV) {
        this.taiKhoanTV = taiKhoanTV;
    }

    public int getIdCanHo() {
        return idCanHo;
    }

    public void setIdCanHo(int idCanHo) {
        this.idCanHo = idCanHo;
    }

    public Date getNgayMua() {
        return ngayMua;
    }

    public void setNgayMua(Date ngayMua) {
        this.ngayMua = ngayMua;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
}
