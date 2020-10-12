/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.Ket_Noi;
import entity.KieuSanPham;
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
public class KieuSanPhamDAO {

    public boolean insertKieuSanPham(KieuSanPham k) {
        boolean bl = false;

        Connection con;
        PreparedStatement pstmt = null;

        con = Ket_Noi.open();

        try {
            pstmt = con.prepareStatement("insert into KieuSanPham values (?,?,?)");
            pstmt.setString(1, k.getMaKieu());
            pstmt.setString(2, k.getTenKieu());
            pstmt.setString(3, k.getKichCo());
            int i = pstmt.executeUpdate();
            if (i > 0) {
                bl = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(KieuSanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Ket_Noi.closeAll(con, pstmt, null);
        }
        return bl;

    }

    public List<KieuSanPham> getAllKieuSanPham() {
        List<KieuSanPham> list = new ArrayList<>();

        Connection con;
        CallableStatement cstmt = null;
        ResultSet rs = null;

        con = Ket_Noi.open();

        try {
            cstmt = con.prepareCall("{call getAllKieuSanPham}");
            rs = cstmt.executeQuery();
            while (rs.next()) {
                KieuSanPham ksp = new KieuSanPham();
                ksp.setMaKieu(rs.getString("MaKieu"));
                ksp.setTenKieu(rs.getString("TenKieu"));
                ksp.setKichCo(rs.getString("KichCo"));
                list.add(ksp);

            }
        } catch (SQLException ex) {
            Logger.getLogger(KieuSanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Ket_Noi.closeAll(con, cstmt, rs);
        }

        return list;
    }

    public boolean updateKieuSanPham(KieuSanPham k) {
        boolean bl = false;

        Connection con;
        CallableStatement cstmt = null;

        con = Ket_Noi.open();

        try {
            cstmt = con.prepareCall("{call updateKieuSanPham(?,?,?)}");
            cstmt.setString(1, k.getMaKieu());
            cstmt.setString(2, k.getTenKieu());
            cstmt.setString(3, k.getKichCo());
            int i = cstmt.executeUpdate();
            if (i > 0) {
                bl = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(KieuSanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Ket_Noi.closeAll(con, cstmt, null);
        }
        return bl;

    }

    public boolean deleteKieuSanPham(String makieu) {
        boolean bl = false;

        Connection con;
        PreparedStatement pstmt = null;

        con = Ket_Noi.open();

        try {
            pstmt = con.prepareStatement("delete from KieuSanPham where MaKieu=?");
            pstmt.setString(1, makieu);
            int i = pstmt.executeUpdate();
            if (i > 0) {
                bl = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(KieuSanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Ket_Noi.closeAll(con, pstmt, null);
        }

        return bl;
    }
}
