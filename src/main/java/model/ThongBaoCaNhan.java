package model;

import java.util.Date;

public class ThongBaoCaNhan {
    private int idTBCN;
    private String taiKhoanTV;
    private String tieuDe;
    private String noiDung;
    private Date ngayGui;
    private boolean isDeleted;

    public ThongBaoCaNhan() {}

    public ThongBaoCaNhan(int idTBCN, String taiKhoanTV, String tieuDe, String noiDung, Date ngayGui, boolean isDeleted) {
        this.idTBCN = idTBCN;
        this.taiKhoanTV = taiKhoanTV;
        this.tieuDe = tieuDe;
        this.noiDung = noiDung;
        this.ngayGui = ngayGui;
        this.isDeleted = isDeleted;
    }

    public int getIdTBCN() {
        return idTBCN;
    }

    public void setIdTBCN(int idTBCN) {
        this.idTBCN = idTBCN;
    }

    public String getTaiKhoanTV() {
        return taiKhoanTV;
    }

    public void setTaiKhoanTV(String taiKhoanTV) {
        this.taiKhoanTV = taiKhoanTV;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public Date getNgayGui() {
        return ngayGui;
    }

    public void setNgayGui(Date ngayGui) {
        this.ngayGui = ngayGui;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
}
