package model;

import java.util.Date;

public class PLVDichVuDangKy {
    private int PLVidDichVuDK;
    private String PLVtaiKhoanTV;
    private int PLVidDichVu;
    private Date PLVngayDK;
    private boolean PLVisDeleted;

    public PLVDichVuDangKy() {}

    public PLVDichVuDangKy(int PLVidDichVuDK, String PLVtaiKhoanTV, int PLVidDichVu, Date PLVngayDK, boolean PLVisDeleted) {
        this.PLVidDichVuDK = PLVidDichVuDK;
        this.PLVtaiKhoanTV = PLVtaiKhoanTV;
        this.PLVidDichVu = PLVidDichVu;
        this.PLVngayDK = PLVngayDK;
        this.PLVisDeleted = PLVisDeleted;
    }

    public int getPLVidDichVuDK() {
        return PLVidDichVuDK;
    }

    public void setPLVidDichVuDK(int PLVidDichVuDK) {
        this.PLVidDichVuDK = PLVidDichVuDK;
    }

    public String getPLVtaiKhoanTV() {
        return PLVtaiKhoanTV;
    }

    public void setPLVtaiKhoanTV(String PLVtaiKhoanTV) {
        this.PLVtaiKhoanTV = PLVtaiKhoanTV;
    }

    public int getPLVidDichVu() {
        return PLVidDichVu;
    }

    public void setPLVidDichVu(int PLVidDichVu) {
        this.PLVidDichVu = PLVidDichVu;
    }

    public Date getPLVngayDK() {
        return PLVngayDK;
    }

    public void setPLVngayDK(Date PLVngayDK) {
        this.PLVngayDK = PLVngayDK;
    }

    public boolean PLVisDeleted() {
        return PLVisDeleted;
    }

    public void setDeleted(boolean PLVisDeleted) {
        this.PLVisDeleted = PLVisDeleted;
    }
}
