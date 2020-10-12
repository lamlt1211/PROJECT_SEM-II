/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.Ket_Noi;
import entity.NhanVien;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lam Chuot
 */
public class NhanVienDAO {

    public boolean insertNhanVien(NhanVien n) {
        boolean bl = false;

        Connection con;
        PreparedStatement pstmt = null;
        con = Ket_Noi.open();
        try {
            pstmt = con.prepareStatement("insert into NhanVien values (?,?,?,?,?,?,?,?,?)");
            pstmt.setString(1, n.getMaNhanVien());
            pstmt.setString(2, n.getUsername());
            pstmt.setString(3, n.getPassword());
            pstmt.setString(4, n.getTenNhanVien());
            pstmt.setDate(5, new Date(n.getNgaySinh().getTime()));
            pstmt.setBoolean(6, n.isGioiTinh());
            pstmt.setString(7, n.getDiaChi());
            pstmt.setString(8, n.getSoDienThoai());
            pstmt.setBoolean(9, n.isGR_name());
            int i = pstmt.executeUpdate();
            if (i > 0) {
                bl = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Ket_Noi.closeAll(con, pstmt, null);
        }

        return bl;
    }

    public List<NhanVien> getAllNhanVien() {
        List<NhanVien> list = new ArrayList<>();

        Connection con;
        CallableStatement cstmt = null;
        ResultSet rs = null;

        con = Ket_Noi.open();

        try {
            cstmt = con.prepareCall("{call getAllNhanVien}");
            rs = cstmt.executeQuery();
            while (rs.next()) {
                NhanVien s = new NhanVien();
                s.setMaNhanVien(rs.getString("MaNhanVien"));
                s.setUsername(rs.getString("Username"));
                s.setPassword(rs.getString("Password"));
                s.setTenNhanVien(rs.getString("TenNhanVien"));
                s.setNgaySinh(rs.getDate("NgaySinh"));
                s.setGioiTinh(rs.getBoolean("GioiTinh"));
                s.setDiaChi(rs.getString("DiaChi"));
                s.setSoDienThoai(rs.getString("SoDienThoai"));
                s.setGR_name(rs.getBoolean("GR_name"));
                list.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Ket_Noi.closeAll(con, cstmt, rs);
        }

        return list;
    }

    public boolean updateNhanVien(NhanVien n) {
        boolean bl = false;

        Connection con;
        CallableStatement cstmt = null;
        con = Ket_Noi.open();
        try {
            cstmt = con.prepareCall("{call updateNhanVien(?,?,?,?,?,?,?,?,?)}");
            cstmt.setString(1, n.getMaNhanVien());
            cstmt.setString(2, n.getUsername());
            cstmt.setString(3, n.getPassword());
            cstmt.setString(4, n.getTenNhanVien());
            cstmt.setDate(5, new Date(n.getNgaySinh().getTime()));
            cstmt.setBoolean(6, n.isGioiTinh());
            cstmt.setString(7, n.getDiaChi());
            cstmt.setString(8, n.getSoDienThoai());
            cstmt.setBoolean(9, n.isGR_name());
            int i = cstmt.executeUpdate();
            if (i > 0) {
                bl = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Ket_Noi.closeAll(con, cstmt, null);
        }

        return bl;
    }

    public boolean deleteNhanVien(String manhanvien) {
        boolean bl = false;

        Connection con;
        PreparedStatement pstmt = null;

        con = Ket_Noi.open();

        try {
            pstmt = con.prepareStatement("delete from NhanVien where MaNhanVien=?");
            pstmt.setString(1, manhanvien);

            int i = pstmt.executeUpdate();
            if (i > 0) {
                bl = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            Ket_Noi.closeAll(con, pstmt, null);
        }
        return bl;
    }

}
