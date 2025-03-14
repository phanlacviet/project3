package model;

import java.util.Date;

public class PLVPhanAnh {
    private int PLVidPhanAnh;
    private String PLVtaiKhoanTV;
    private String PLVnoiDung;
    private Date PLVngayGui;
    private boolean PLVisDeleted;

    public PLVPhanAnh() {}

    public PLVPhanAnh(int PLVidPhanAnh, String PLVtaiKhoanTV, String PLVnoiDung, Date PLVngayGui, boolean PLVisDeleted) {
        this.PLVidPhanAnh = PLVidPhanAnh;
        this.PLVtaiKhoanTV = PLVtaiKhoanTV;
        this.PLVnoiDung = PLVnoiDung;
        this.PLVngayGui = PLVngayGui;
        this.PLVisDeleted = PLVisDeleted;
    }

    public int getPLVidPhanAnh() {
        return PLVidPhanAnh;
    }

    public void setPLVidPhanAnh(int PLVidPhanAnh) {
        this.PLVidPhanAnh = PLVidPhanAnh;
    }

    public String getPLVtaiKhoanTV() {
        return PLVtaiKhoanTV;
    }

    public void setPLVtaiKhoanTV(String PLVtaiKhoanTV) {
        this.PLVtaiKhoanTV = PLVtaiKhoanTV;
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

    public boolean getPLVisDeleted() {
        return PLVisDeleted;
    }

    public void setPLVisDeleted(boolean PLVisDeleted) {
        this.PLVisDeleted = PLVisDeleted;
    }
}