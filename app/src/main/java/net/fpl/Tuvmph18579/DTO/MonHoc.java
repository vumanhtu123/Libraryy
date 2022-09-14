package net.fpl.Tuvmph18579.DTO;

public class MonHoc {
    private int maMon;
    private String tenMon;
    private String anh;
    private float hocPhi;
    private String ngayBatDau;
    private String ngayKetThuc;
    private String tenKy;

    public MonHoc() {
    }

    public MonHoc(int maMon, String tenMon, String anh, float hocPhi, String ngayBatDau, String ngayKetThuc, String tenKy) {
        this.maMon = maMon;
        this.tenMon = tenMon;
        this.anh = anh;
        this.hocPhi = hocPhi;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.tenKy = tenKy;
    }

    public int getMaMon() {
        return maMon;
    }

    public void setMaMon(int maMon) {
        this.maMon = maMon;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public float getHocPhi() {
        return hocPhi;
    }

    public void setHocPhi(float hocPhi) {
        this.hocPhi = hocPhi;
    }

    public String getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(String ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public String getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(String ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public String getTenKy() {
        return tenKy;
    }

    public void setTenKy(String tenKy) {
        this.tenKy = tenKy;
    }
}
