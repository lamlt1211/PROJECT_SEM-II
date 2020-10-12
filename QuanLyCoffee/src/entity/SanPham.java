/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Objects;

/**
 *
 * @author Lam Chuot
 */
public class SanPham {

    private String MaSanPham;
    private String MaKieu;
    private String TenSanPham;
    private String KichCo;
    private float GiaTien;
    private String tenKieu;

    public SanPham() {
    }

    public SanPham(String MaSanPham, String MaKieu, String TenSanPham, String KichCo, float GiaTien, String tenKieu) {
        this.MaSanPham = MaSanPham;
        this.MaKieu = MaKieu;
        this.TenSanPham = TenSanPham;
        this.KichCo = KichCo;
        this.GiaTien = GiaTien;
        this.tenKieu = tenKieu;
    }
    public SanPham(String MaSanPham, String MaKieu, String TenSanPham, String KichCo, float GiaTien) {
        this.MaSanPham = MaSanPham;
        this.MaKieu = MaKieu;
        this.TenSanPham = TenSanPham;
        this.KichCo = KichCo;
        this.GiaTien = GiaTien;
    }

    public String getMaSanPham() {
        return MaSanPham;
    }

    public void setMaSanPham(String MaSanPham) {
        this.MaSanPham = MaSanPham;
    }

    public String getMaKieu() {
        return MaKieu;
    }

    public void setMaKieu(String MaKieu) {
        this.MaKieu = MaKieu;
    }

    public String getTenSanPham() {
        return TenSanPham;
    }

    public void setTenSanPham(String TenSanPham) {
        this.TenSanPham = TenSanPham;
    }

    public String getKichCo() {
        return KichCo;
    }

    public void setKichCo(String KichCo) {
        this.KichCo = KichCo;
    }

    public float getGiaTien() {
        return GiaTien;
    }

    public void setGiaTien(float GiaTien) {
        this.GiaTien = GiaTien;
    }

    public String getTenKieu() {
        return tenKieu;
    }

    public void setTenKieu(String tenKieu) {
        this.tenKieu = tenKieu;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.TenSanPham);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SanPham other = (SanPham) obj;
        if (!Objects.equals(this.TenSanPham, other.TenSanPham)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return TenSanPham ;
    }

   
    
    

}