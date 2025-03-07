package model;

public class CanHo {
    private int idCanHo;
    private String tenCH;
    private int dienTich;
    private double gia;
    private boolean trangThai;
    private boolean isDeleted;

    public CanHo() {}

    public CanHo(int idCanHo, String tenCH, int dienTich, double gia, boolean trangThai, boolean isDeleted) {
        this.idCanHo = idCanHo;
        this.tenCH = tenCH;
        this.dienTich = dienTich;
        this.gia = gia;
        this.trangThai=trangThai;
        this.isDeleted=isDeleted;
    }

    public int getIdCanHo() {
        return idCanHo;
    }

    public void setIdCanHo(int idCanHo) {
        this.idCanHo = idCanHo;
    }

    public String getTenCH() {
        return tenCH;
    }

    public void setTenCH(String tenCH) {
        this.tenCH = tenCH;
    }

    public int getDienTich() {
        return dienTich;
    }

    public void setDienTich(int dienTich) {
        this.dienTich = dienTich;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }
    public boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }
    public boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsdeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
}
