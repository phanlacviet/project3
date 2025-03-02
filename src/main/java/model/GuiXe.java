package model;

import java.util.Date;

public class GuiXe {
    private int idXe;
    private String taiKhoanTV;
    private String bienXoXe;
    private Date ngayGui;
    private boolean isDeleted;

    public GuiXe() {}

    public GuiXe(int idXe, String taiKhoanTV, String bienXoXe, Date ngayGui, boolean isDeleted) {
        this.idXe = idXe;
        this.taiKhoanTV = taiKhoanTV;
        this.bienXoXe = bienXoXe;
        this.ngayGui = ngayGui;
        this.isDeleted = isDeleted;
    }

    public int getIdXe() {
        return idXe;
    }

    public void setIdXe(int idXe) {
        this.idXe = idXe;
    }

    public String getTaiKhoanTV() {
        return taiKhoanTV;
    }

    public void setTaiKhoanTV(String taiKhoanTV) {
        this.taiKhoanTV = taiKhoanTV;
    }

    public String getBienXoXe() {
        return bienXoXe;
    }

    public void setBienXoXe(String bienXoXe) {
        this.bienXoXe = bienXoXe;
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
