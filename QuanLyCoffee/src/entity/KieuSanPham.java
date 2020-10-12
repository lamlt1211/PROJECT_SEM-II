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
public class KieuSanPham {

    private String MaKieu;
    private String TenKieu;
    private String KichCo;

    public KieuSanPham() {
    }

    public KieuSanPham(String MaKieu, String TenKieu, String KichCo) {
        this.MaKieu = MaKieu;
        this.TenKieu = TenKieu;
        this.KichCo = KichCo;
    }

    public String getMaKieu() {
        return MaKieu;
    }

    public void setMaKieu(String MaKieu) {
        this.MaKieu = MaKieu;
    }

    public String getTenKieu() {
        return TenKieu;
    }

    public void setTenKieu(String TenKieu) {
        this.TenKieu = TenKieu;
    }

    public String getKichCo() {
        return KichCo;
    }

    public void setKichCo(String KichCo) {
        this.KichCo = KichCo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.TenKieu);
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
        final KieuSanPham other = (KieuSanPham) obj;
        if (!Objects.equals(this.TenKieu, other.TenKieu)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return TenKieu;
    }

}
