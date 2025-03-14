package model;

public class PLVCanHo {
    private int PLVidCanHo;
    private String PLVtenCH;
    private int PLVdienTich;
    private double PLVgia;
    private boolean PLVtrangThai;
    private boolean PLVisDeleted;

    public PLVCanHo() {}

    public PLVCanHo(int PLVidCanHo, String PLVtenCH, int PLVdienTich, double PLVgia, boolean PLVtrangThai, boolean PLVisDeleted) {
        this.PLVidCanHo = PLVidCanHo;
        this.PLVtenCH = PLVtenCH;
        this.PLVdienTich = PLVdienTich;
        this.PLVgia = PLVgia;
        this.PLVtrangThai=PLVtrangThai;
        this.PLVisDeleted=PLVisDeleted;
    }

    public int getPLVIdCanHo() {
        return PLVidCanHo;
    }

    public void setPLVIdCanHo(int PLVidCanHo) {
        this.PLVidCanHo = PLVidCanHo;
    }

    public String getPLVTenCH() {
        return PLVtenCH;
    }

    public void setPLVTenCH(String PLVtenCH) {
        this.PLVtenCH = PLVtenCH;
    }

    public int getPLVDienTich() {
        return PLVdienTich;
    }

    public void setPLVDienTich(int PLVdienTich) {
        this.PLVdienTich = PLVdienTich;
    }

    public double getPLVGia() {
        return PLVgia;
    }

    public void setPLVGia(double PLVgia) {
        this.PLVgia = PLVgia;
    }
    public boolean getPLVTrangThai() {
        return PLVtrangThai;
    }

    public void setPLVTrangThai(boolean PLVtrangThai) {
        this.PLVtrangThai = PLVtrangThai;
    }
    public boolean getPLVIsDeleted() {
        return PLVisDeleted;
    }

    public void setPLVIsdeleted(boolean PLVisDeleted) {
        this.PLVisDeleted = PLVisDeleted;
    }
}
