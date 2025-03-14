package model;

import java.util.Date;

public class PLVThongBaoCaNhan {
    private int PLVidTBCN;
    private String PLVtaiKhoanTV;
    private String PLVtieuDe;
    private String PLVnoiDung;
    private Date PLVngayGui;
    private boolean PLVisDeleted;

    public PLVThongBaoCaNhan() {}

    public PLVThongBaoCaNhan(int PLVidTBCN, String PLVtaiKhoanTV, String PLVtieuDe, String PLVnoiDung, Date PLVngayGui, boolean PLVisDeleted) {
        this.PLVidTBCN = PLVidTBCN;
        this.PLVtaiKhoanTV = PLVtaiKhoanTV;
        this.PLVtieuDe = PLVtieuDe;
        this.PLVnoiDung = PLVnoiDung;
        this.PLVngayGui = PLVngayGui;
        this.PLVisDeleted = PLVisDeleted;
    }

    public int getPLVidTBCN() {
        return PLVidTBCN;
    }

    public void setPLVidTBCN(int PLVidTBCN) {
        this.PLVidTBCN = PLVidTBCN;
    }

    public String getPLVtaiKhoanTV() {
        return PLVtaiKhoanTV;
    }

    public void setPLVtaiKhoanTV(String PLVtaiKhoanTV) {
        this.PLVtaiKhoanTV = PLVtaiKhoanTV;
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
