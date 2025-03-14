package model;

import java.util.Date;

public class PLVGuiXe {
    private int PLVidXe;
    private String PLVtaiKhoanTV;
    private String PLVbienXoXe;
    private Date PLVngayGui;
    private boolean PLVisDeleted;

    public PLVGuiXe() {}

    public PLVGuiXe(int PLVidXe, String PLVtaiKhoanTV, String PLVbienXoXe, Date PLVngayGui, boolean PLVisDeleted) {
        this.PLVidXe = PLVidXe;
        this.PLVtaiKhoanTV = PLVtaiKhoanTV;
        this.PLVbienXoXe = PLVbienXoXe;
        this.PLVngayGui = PLVngayGui;
        this.PLVisDeleted = PLVisDeleted;
    }

    public int getPLVidXe() {
        return PLVidXe;
    }

    public void setPLVidXe(int PLVidXe) {
        this.PLVidXe = PLVidXe;
    }

    public String getPLVtaiKhoanTV() {
        return PLVtaiKhoanTV;
    }

    public void setPLVtaiKhoanTV(String PLVtaiKhoanTV) {
        this.PLVtaiKhoanTV = PLVtaiKhoanTV;
    }

    public String getPLVbienXoXe() {
        return PLVbienXoXe;
    }

    public void setPLVbienXoXe(String PLVbienXoXe) {
        this.PLVbienXoXe = PLVbienXoXe;
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
