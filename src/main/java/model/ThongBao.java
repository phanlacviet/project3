package model;

import java.util.Date;

public class ThongBao {
    private int idThongBao;
    private String tieuDe;
    private String noiDung;
    private Date ngayGui;
    private boolean isDeleted;

    public ThongBao() {}

    public ThongBao(int idThongBao, String tieuDe, String noiDung, Date ngayGui, boolean isDeleted) {
        this.idThongBao = idThongBao;
        this.tieuDe = tieuDe;
        this.noiDung = noiDung;
        this.ngayGui = ngayGui;
        this.isDeleted = isDeleted;
    }

    public int getIdThongBao() {
        return idThongBao;
    }

    public void setIdThongBao(int idThongBao) {
        this.idThongBao = idThongBao;
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
