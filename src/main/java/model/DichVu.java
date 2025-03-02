package model;

public class DichVu {
    private int idDichVu;
    private String tenDV;
    private int giaThue;
    private boolean isDeleted;

    public DichVu() {}

    public DichVu(int idDichVu, String tenDV, int giaThue, boolean isDeleted) {
        this.idDichVu = idDichVu;
        this.tenDV = tenDV;
        this.giaThue = giaThue;
        this.isDeleted = isDeleted;
    }

    public int getIdDichVu() {
        return idDichVu;
    }

    public void setIdDichVu(int idDichVu) {
        this.idDichVu = idDichVu;
    }

    public String getTenDV() {
        return tenDV;
    }

    public void setTenDV(String tenDV) {
        this.tenDV = tenDV;
    }

    public int getGiaThue() {
        return giaThue;
    }

    public void setGiaThue(int giaThue) {
        this.giaThue = giaThue;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
}
