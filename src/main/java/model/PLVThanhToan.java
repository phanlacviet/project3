package model;

import java.util.Date;

public class PLVThanhToan {
    private int PLVidThanhToan;
    private String PLVtaiKhoanTV;
    private double PLVsoTien;
    private Date PLVngayThanhToan;
    private boolean PLVisDeleted;

    // Constructor không tham số
    public PLVThanhToan() {}

    // Constructor đầy đủ tham số
    public PLVThanhToan(int PLVidThanhToan, String PLVtaiKhoanTV, double PLVsoTien, Date PLVngayThanhToan, boolean PLVisDeleted) {
        this.PLVidThanhToan = PLVidThanhToan;
        this.PLVtaiKhoanTV = PLVtaiKhoanTV;
        this.PLVsoTien = PLVsoTien;
        this.PLVngayThanhToan = PLVngayThanhToan;
        this.PLVisDeleted = PLVisDeleted;
    }

    // Getter và Setter
    public int getPLVidThanhToan() {
        return PLVidThanhToan;
    }

    public void setPLVidThanhToan(int PLVidThanhToan) {
        this.PLVidThanhToan = PLVidThanhToan;
    }

    public String getPLVtaiKhoanTV() {
        return PLVtaiKhoanTV;
    }

    public void setPLVtaiKhoanTV(String PLVtaiKhoanTV) {
        this.PLVtaiKhoanTV = PLVtaiKhoanTV;
    }

    public double getPLVsoTien() {
        return PLVsoTien;
    }

    public void setPLVsoTien(double PLVsoTien) {
        this.PLVsoTien = PLVsoTien;
    }

    public Date getPLVngayThanhToan() {
        return PLVngayThanhToan;
    }

    public void setPLVngayThanhToan(Date PLVngayThanhToan) {
        this.PLVngayThanhToan = PLVngayThanhToan;
    }

    public boolean getPLVisDeleted() {
        return PLVisDeleted;
    }

    public void setPLVisDeleted(boolean PLVisDeleted) {
        this.PLVisDeleted = PLVisDeleted;
    }
}
