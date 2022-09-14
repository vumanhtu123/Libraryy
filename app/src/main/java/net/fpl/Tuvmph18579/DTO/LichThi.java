package net.fpl.Tuvmph18579.DTO;

public class LichThi {
    private int maLichThi;
    private String thoiGian;
    private int maMon;

    public LichThi(int maLichThi, String thoiGian, int maMon) {
        this.maLichThi = maLichThi;
        this.thoiGian = thoiGian;
        this.maMon = maMon;
    }

    public LichThi() {
    }

    public int getMaLichThi() {
        return maLichThi;
    }

    public void setMaLichThi(int maLichThi) {
        this.maLichThi = maLichThi;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }

    public int getMaMon() {
        return maMon;
    }

    public void setMaMon(int maMon) {
        this.maMon = maMon;
    }
}