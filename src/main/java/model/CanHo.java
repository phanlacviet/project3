package model;

public class CanHo {
    private int idCanHo;
    private String tenCH;
    private int dienTich;
    private double gia;

    public CanHo() {}

    public CanHo(int idCanHo, String tenCH, int dienTich, double gia) {
        this.idCanHo = idCanHo;
        this.tenCH = tenCH;
        this.dienTich = dienTich;
        this.gia = gia;
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
}
