/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;

/**
 *
 * @author Lam Chuot
 */
public class NhanVien {

    private String MaNhanVien;
    private String Username;
    private String Password;
    private String TenNhanVien;
    private Date NgaySinh;
    private boolean GioiTinh;
    private String DiaChi;
    private String SoDienThoai;
    private boolean GR_name;

    public NhanVien() {
    }

    public NhanVien(String MaNhanVien, String Username, String Password, String TenNhanVien, Date NgaySinh, boolean GioiTinh, String DiaChi, String SoDienThoai, boolean GR_name) {
        this.MaNhanVien = MaNhanVien;
        this.Username = Username;
        this.Password = Password;
        this.TenNhanVien = TenNhanVien;
        this.NgaySinh = NgaySinh;
        this.GioiTinh = GioiTinh;
        this.DiaChi = DiaChi;
        this.SoDienThoai = SoDienThoai;
        this.GR_name = GR_name;
    }

    public String getMaNhanVien() {
        return MaNhanVien;
    }

    public void setMaNhanVien(String MaNhanVien) {
        this.MaNhanVien = MaNhanVien;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getTenNhanVien() {
        return TenNhanVien;
    }

    public void setTenNhanVien(String TenNhanVien) {
        this.TenNhanVien = TenNhanVien;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public boolean isGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(boolean GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getSoDienThoai() {
        return SoDienThoai;
    }

    public void setSoDienThoai(String SoDienThoai) {
        this.SoDienThoai = SoDienThoai;
    }

    public boolean isGR_name() {
        return GR_name;
    }

    public void setGR_name(boolean GR_name) {
        this.GR_name = GR_name;
    }

}
