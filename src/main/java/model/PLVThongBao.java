package model;

import java.util.Date;

public class PLVThongBao {
    private int PLVidThongBao;
    private String PLVtieuDe;
    private String PLVnoiDung;
    private Date PLVngayGui;
    private boolean PLVisDeleted;

    public PLVThongBao() {}

    public PLVThongBao(int PLVidThongBao, String PLVtieuDe, String PLVnoiDung, Date PLVngayGui, boolean PLVisDeleted) {
        this.PLVidThongBao = PLVidThongBao;
        this.PLVtieuDe = PLVtieuDe;
        this.PLVnoiDung = PLVnoiDung;
        this.PLVngayGui = PLVngayGui;
        this.PLVisDeleted = PLVisDeleted;
    }

    public int getPLVidThongBao() {
        return PLVidThongBao;
    }

    public void setPLVidThongBao(int PLVidThongBao) {
        this.PLVidThongBao = PLVidThongBao;
    }

    public String getPLVtieuDe() {
        return PLVtieuDe;
    }

    public void setPLVtieuDe(String PLVtieuDe) {
        this.PLVtieuDe = PLVtieuDe;
    }

    public String getPLVnoiDung() {
        return PLVnoiDung;
    }

    public void setPLVnoiDung(String PLVnoiDung) {
        this.PLVnoiDung = PLVnoiDung;
    }

    public Date getPLVngayGui() {
        return PLVngayGui;
    }

    public void setPLVngayGui(Date PLVngayGui) {
        this.PLVngayGui = PLVngayGui;
    }

    public boolean PLVisDeleted() {
        return PLVisDeleted;
    }

    public void setDeleted(boolean PLVisDeleted) {
        this.PLVisDeleted = PLVisDeleted;
    }
}
