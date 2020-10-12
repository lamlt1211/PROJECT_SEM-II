/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.Ket_Noi;
import entity.Ban;
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
public class BanDAO {

    public boolean insertBan(Ban bn) {
        boolean bl = false;

        Connection con;
        PreparedStatement pstmt = null;

        con = Ket_Noi.open();
        try {
            pstmt = con.prepareStatement("insert into Ban values (?,?,?)");
            pstmt.setInt(1, bn.getMaBan());
            pstmt.setString(2, bn.getTenBan());
            pstmt.setBoolean(3, bn.isTrangThai());
            int i = pstmt.executeUpdate();
            if (i > 0) {
                bl = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BanDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Ket_Noi.closeAll(con, pstmt, null);
        }

        return bl;
    }

    public List<Ban> getAllBan() {
        List<Ban> list = new ArrayList<>();

        Connection con;
        CallableStatement cstmt = null;
        ResultSet rs = null;

        con = Ket_Noi.open();
        try {
            cstmt = con.prepareCall("{call getAllBan}");
            rs = cstmt.executeQuery();
            while (rs.next()) {
                Ban bn = new Ban();
                bn.setMaBan(rs.getInt("MaBan"));
                bn.setTenBan(rs.getString("TenBan"));
                bn.setTrangThai(rs.getBoolean("TrangThai"));
                list.add(bn);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BanDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Ket_Noi.closeAll(con, cstmt, rs);
        }
        return list;
    }

    public List<Ban> getBanById(String MaBan) {
        List<Ban> list = new ArrayList<>();

        Connection con;
        CallableStatement cstmt = null;
        ResultSet rs = null;

        con = Ket_Noi.open();
        try {
            cstmt = con.prepareCall("{call getBanById(?)}");
            cstmt.setString(1, MaBan);
            rs = cstmt.executeQuery();
            while (rs.next()) {
                Ban bn = new Ban();
                bn.setMaBan(rs.getInt("MaBan"));
                bn.setTenBan(rs.getString("TenBan"));
                bn.setTrangThai(rs.getBoolean("TrangThai"));
                list.add(bn);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BanDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Ket_Noi.closeAll(con, cstmt, rs);
        }
        return list;
    }

    public boolean deleteBan(String MaBan) {
        boolean bl = false;

        Connection con;
        PreparedStatement pstmt = null;

        con = Ket_Noi.open();

        try {
            pstmt = con.prepareStatement("delete from Ban where MaBan=?");
            pstmt.setString(1, MaBan);
            int i = pstmt.executeUpdate();
            if (i > 0) {
                bl = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BanDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Ket_Noi.closeAll(con, pstmt, null);
        }

        return bl;
    }

    public boolean updateBan(Ban b) {
        boolean bl = false;

        Connection con;
        CallableStatement cstmt = null;
        con = Ket_Noi.open();

        try {
            cstmt = con.prepareCall("{call updateBan(?,?,?)}");
            cstmt.setInt(1, b.getMaBan());
            cstmt.setString(2, b.getTenBan());
            cstmt.setBoolean(3, b.isTrangThai());
            int i = cstmt.executeUpdate();
            if (i > 0) {
                bl = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BanDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Ket_Noi.closeAll(con, cstmt, null);
        }
        return bl;
    }
}
