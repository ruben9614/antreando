/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package loginPhone;

import java.sql.*;
import mx.com.antreando.dao.general.DaoGeneral;
import mx.com.antreando.dao.sql.SQL;
import mx.com.antreando.dto.TrUsuariosDto;

/**
 *
 * @author Arizmendi
 */
public class LoginPhone {
    
    public int insert(String nombreX,String appX,String apmX,String emailX,String usrX,String pwdX) {
        Connection con = null;
        PreparedStatement ps = null;
        int exito = 0;
        TrUsuariosDto trUsuarios = null;
        try{
            con = DaoGeneral.createConnection();
            ps = con.prepareStatement(SQL.trUsuariosInsert);
            trUsuarios = new TrUsuariosDto();
            ps.setString(1, nombreX);
            ps.setString(2, appX);
            ps.setString(3, apmX);
            ps.setDate(4, Date.valueOf("2011-01-01"));
            ps.setString(5, emailX);
            ps.setString(6, usrX);
            ps.setString(7, pwdX);
            ps.setInt(8, 3);
            exito = ps.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            DaoGeneral.closeConnection(con, ps);
        }
        return exito;
    }
    
}
