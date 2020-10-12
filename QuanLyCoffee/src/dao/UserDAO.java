/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import GiaoDien.DangNhap;
import db.Ket_Noi;
import entity.NhanVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lam Chuot
 */
public class UserDAO {
    
    public boolean checkUser(String u, String p) {
        boolean bl = false;
        
        Connection con;
        PreparedStatement  pstmt;
        con = Ket_Noi.open();
        ResultSet rs = null;
        try {
            String sql = "select * from NhanVien WHERE [Username]='" + u + "' AND [Password]='" + p + "';";
            pstmt = con.prepareStatement(sql);
            
            rs = pstmt.executeQuery();
            if(rs.next()){
                
                bl = true;
                
                DangNhap.nv.setGR_name(rs.getBoolean("GR_name"));
                DangNhap.nv.setTenNhanVien(rs.getString("TenNhanVien"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Ket_Noi.closeAll(con, null, rs);
        }
        return bl;
    }
    
}
