package model;

public class PLVDichVu {
    private int PLVidDichVu;
    private String PLVtenDV;
    private int PLVgiaThue;
    private boolean PLVisDeleted;

    public PLVDichVu() {}

    public PLVDichVu(int PLVidDichVu, String PLVtenDV, int PLVgiaThue, boolean PLVisDeleted) {
        this.PLVidDichVu = PLVidDichVu;
        this.PLVtenDV = PLVtenDV;
        this.PLVgiaThue = PLVgiaThue;
        this.PLVisDeleted = PLVisDeleted;
    }

    public int getPLVidDichVu() {
        return PLVidDichVu;
    }

    public void setPLVidDichVu(int PLVidDichVu) {
        this.PLVidDichVu = PLVidDichVu;
    }

    public String getPLVtenDV() {
        return PLVtenDV;
    }

    public void setPLVtenDV(String PLVtenDV) {
        this.PLVtenDV = PLVtenDV;
    }

    public int getPLVgiaThue() {
        return PLVgiaThue;
    }

    public void setPLVgiaThue(int PLVgiaThue) {
        this.PLVgiaThue = PLVgiaThue;
    }

    public boolean PLVisDeleted() {
        return PLVisDeleted;
    }

    public void setDeleted(boolean PLVisDeleted) {
        this.PLVisDeleted = PLVisDeleted;
    }
}
