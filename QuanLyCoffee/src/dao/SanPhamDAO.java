/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.Ket_Noi;
import entity.SanPham;
import java.sql.CallableStatement;
import java.sql.Connection;
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
public class SanPhamDAO {

    public boolean insertSanPham(SanPham s) {
        boolean bl = false;

        Connection con;
        PreparedStatement pstmt = null;
        con = Ket_Noi.open();
        try {
            pstmt = con.prepareStatement("insert into SanPham values (?,?,?,?,?)");
            pstmt.setString(1, s.getMaSanPham());
            pstmt.setString(2, s.getMaKieu());
            pstmt.setString(3, s.getTenSanPham());
            pstmt.setString(4, s.getKichCo());
            pstmt.setFloat(5, s.getGiaTien());

            int i = pstmt.executeUpdate();
            if (i > 0) {
                bl = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Ket_Noi.closeAll(con, pstmt, null);
        }

        return bl;
    }

    public List<SanPham> getAllSanPham() {
        List<SanPham> list = new ArrayList<>();

        Connection con;
        CallableStatement cstmt = null;
        ResultSet rs = null;

        con = Ket_Noi.open();

        try {
            cstmt = con.prepareCall("{call getAllSanPham}");
            rs = cstmt.executeQuery();
            while (rs.next()) {
                SanPham s = new SanPham();
                s.setMaSanPham(rs.getString("MaSanPham"));
                s.setTenKieu(rs.getString("TenKieu"));
                s.setTenSanPham(rs.getString("TenSanPham"));
                s.setKichCo(rs.getString("KichCo"));
                s.setGiaTien(rs.getFloat("GiaTien"));
                list.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Ket_Noi.closeAll(con, cstmt, rs);
        }

        return list;
    }

    public boolean updateSanPham(SanPham s) {
        boolean bl = false;

        Connection con;
        CallableStatement cstmt = null;
        con = Ket_Noi.open();

        try {
            cstmt = con.prepareCall("{call updateSanPham(?,?,?,?,?)}");
            cstmt.setString(1, s.getMaSanPham());
            cstmt.setString(2, s.getMaKieu());
            cstmt.setString(3, s.getTenSanPham());
            cstmt.setString(4, s.getKichCo());
            cstmt.setFloat(5, s.getGiaTien());
            int i = cstmt.executeUpdate();
            if (i > 0) {
                bl = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Ket_Noi.closeAll(con, cstmt, null);
        }
        return bl;
    }

    public boolean deleteSanPham(String masanpham) {
        boolean bl = false;

        Connection con;
        PreparedStatement pstmt = null;

        con = Ket_Noi.open();

        try {
            pstmt = con.prepareStatement("delete from SanPham where MaSanPham=?");
            pstmt.setString(1, masanpham);
            int i = pstmt.executeUpdate();
            if (i > 0) {
                bl = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Ket_Noi.closeAll(con, pstmt, null);
        }
        return bl;
    }

    public List<SanPham> timkiemSanPham(String tensanpham) {
        List<SanPham> list = new ArrayList<>();
        Connection con;
        CallableStatement cstmt = null;
        ResultSet rs = null;

        con = Ket_Noi.open();
        try {
            cstmt = con.prepareCall("{call timkiemSanPham(?)}");
            cstmt.setString(1, tensanpham);
            rs = cstmt.executeQuery();
            while (rs.next()) {
                SanPham s = new SanPham();
                s.setMaSanPham(rs.getString("MaSanPham"));
                s.setMaKieu(rs.getString("MaKieu"));
                s.setTenSanPham(rs.getString("TenSanPham"));
                s.setKichCo(rs.getString("KichCo"));
                s.setGiaTien(rs.getFloat("GiaTien"));
                list.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Ket_Noi.closeAll(con, cstmt, rs);
        }

        return list;
    }

}
