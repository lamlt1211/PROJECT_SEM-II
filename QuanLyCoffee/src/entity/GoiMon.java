/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Lam Chuot
 */
public class GoiMon {
    private int MaBan;
    private String MaKieu;
    private String MaSanPham;
    private int Soluong;
    private String KichCo;
    private Float GiaTien;

    public GoiMon() {
    }

    public GoiMon(int MaBan, String MaKieu, String MaSanPham, int Soluong, String KichCo, Float GiaTien) {
        this.MaBan = MaBan;
        this.MaKieu = MaKieu;
        this.MaSanPham = MaSanPham;
        this.Soluong = Soluong;
        this.KichCo = KichCo;
        this.GiaTien = GiaTien;
    }

    public int getMaBan() {
        return MaBan;
    }

    public void setMaBan(int MaBan) {
        this.MaBan = MaBan;
    }

    public String getMaKieu() {
        return MaKieu;
    }

    public void setMaKieu(String MaKieu) {
        this.MaKieu = MaKieu;
    }

    public String getMaSanPham() {
        return MaSanPham;
    }

    public void setMaSanPham(String MaSanPham) {
        this.MaSanPham = MaSanPham;
    }

    public int getSoluong() {
        return Soluong;
    }

    public void setSoluong(int Soluong) {
        this.Soluong = Soluong;
    }

    public String getKichCo() {
        return KichCo;
    }

    public void setKichCo(String KichCo) {
        this.KichCo = KichCo;
    }

    public Float getGiaTien() {
        return GiaTien;
    }

    public void setGiaTien(Float GiaTien) {
        this.GiaTien = GiaTien;
    }
    

}
