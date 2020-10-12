/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.Ket_Noi;
import entity.KichCo;
import entity.KieuSanPham;
import java.sql.CallableStatement;
import java.sql.Connection;
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
public class KichCoDAO {

    public List<KichCo> getAllKichCo() {
        List<KichCo> list = new ArrayList<>();

        Connection con;
        CallableStatement cstmt = null;
        ResultSet rs = null;

        con = Ket_Noi.open();

        try {
            cstmt = con.prepareCall("{call getAllKichCo}");
            rs = cstmt.executeQuery();
            while (rs.next()) {
                KichCo kc = new KichCo();
                kc.setMakichco(rs.getInt("Kcid"));
                kc.setKichCo(rs.getString("KichCo"));
                list.add(kc);

            }
        } catch (SQLException ex) {
            Logger.getLogger(KichCoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Ket_Noi.closeAll(con, cstmt, rs);
        }

        return list;
    }
}
