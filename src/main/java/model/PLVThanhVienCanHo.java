package model;

import java.util.Date;

public class PLVThanhVienCanHo {
    private int PLVidTVCH;
    private String PLVtaiKhoanTV;
    private int PLVidCanHo;
    private Date PLVngayMua;
    private boolean PLVisDeleted;

    public PLVThanhVienCanHo() {}

    public PLVThanhVienCanHo(int PLVidTVCH, String PLVtaiKhoanTV, int PLVidCanHo, Date PLVngayMua, boolean PLVisDeleted) {
        this.PLVidTVCH = PLVidTVCH;
        this.PLVtaiKhoanTV = PLVtaiKhoanTV;
        this.PLVidCanHo = PLVidCanHo;
        this.PLVngayMua = PLVngayMua;
        this.PLVisDeleted = PLVisDeleted;
    }

    public int getPLVidTVCH() {
        return PLVidTVCH;
    }

    public void setPLVidTVCH(int PLVidTVCH) {
        this.PLVidTVCH = PLVidTVCH;
    }

    public String getPLVtaiKhoanTV() {
        return PLVtaiKhoanTV;
    }

    public void setPLVtaiKhoanTV(String PLVtaiKhoanTV) {
        this.PLVtaiKhoanTV = PLVtaiKhoanTV;
    }

    public int getPLVidCanHo() {
        return PLVidCanHo;
    }

    public void setPLVidCanHo(int PLVidCanHo) {
        this.PLVidCanHo = PLVidCanHo;
    }

    public Date getPLVngayMua() {
        return PLVngayMua;
    }

    public void setPLVngayMua(Date PLVngayMua) {
        this.PLVngayMua = PLVngayMua;
    }

    public boolean PLVisDeleted() {
        return PLVisDeleted;
    }

    public void setDeleted(boolean PLVisDeleted) {
        this.PLVisDeleted = PLVisDeleted;
    }
}
