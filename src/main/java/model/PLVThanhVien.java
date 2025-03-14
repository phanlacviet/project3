package model;

public class PLVThanhVien {
    private String PLVtaiKhoanTV;
    private String PLVmatKhau;
    private String PLVhoTen;
    private String PLVemail;
    private boolean PLVisDeleted;

    public PLVThanhVien() {}

    public PLVThanhVien(String PLVtaiKhoanTV, String PLVmatKhau, String PLVhoTen, String PLVemail, boolean PLVisDeleted) {
        this.PLVtaiKhoanTV = PLVtaiKhoanTV;
        this.PLVmatKhau = PLVmatKhau;
        this.PLVhoTen = PLVhoTen;
        this.PLVemail = PLVemail;
        this.PLVisDeleted = PLVisDeleted;
    }

    public String getPLVtaiKhoanTV() {
        return PLVtaiKhoanTV;
    }

    public void setPLVtaiKhoanTV(String PLVtaiKhoanTV) {
        this.PLVtaiKhoanTV = PLVtaiKhoanTV;
    }

    public String getPLVmatKhau() {
        return PLVmatKhau;
    }

    public void setPLVmatKhau(String PLVmatKhau) {
        this.PLVmatKhau = PLVmatKhau;
    }

    public String getPLVhoTen() {
        return PLVhoTen;
    }

    public void setPLVhoTen(String PLVhoTen) {
        this.PLVhoTen = PLVhoTen;
    }

    public String getPLVemail() {
        return PLVemail;
    }

    public void setPLVemail(String PLVemail) {
        this.PLVemail = PLVemail;
    }

    public boolean PLVisDeleted() {
        return PLVisDeleted;
    }

    public void setDeleted(boolean PLVisDeleted) {
        this.PLVisDeleted = PLVisDeleted;
    }
}
