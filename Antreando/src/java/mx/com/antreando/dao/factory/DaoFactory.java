/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.antreando.dao.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Arizmendi
 */
public class DaoFactory {
    
    private static String nombreBD = "antreando";
    private static String cadenaConexion = "jdbc:mysql://127.0.0.1:3306/"+nombreBD;
    private static String usuario = "root";
    private static String password = "toor";


    public static Connection createConnection(){
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(cadenaConexion, usuario, password);
            System.out.println("Conexión exitosa");
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Conexión fallida");
            return null;
        }
        return con;
    }

    /**
     * closeConnection
     * Método que cierra la conexion a la base de datos
     * @param con
     */
    public static void closeConnection(Connection con){
        if(con != null){
            try {
                con.close();
                con = null;
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * closeConnection
     * Método que cierra la conexión a la base de datos y el recurso de PreparedStatement
     * @param con
     * @param ps
     */
    public static void closeConnection(Connection con, PreparedStatement ps){
        try{
                if(ps != null){
                    ps.close();
                    ps = null;
                }
                if(con != null){
                    con.close();//mandamos llamar el metodo de cerrar conexion
                    con = null;
                }
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
    }

    /**
     * closeConnection
     * Método que cierra la conexión a la base de datos, el PreparedStatement y el ResultSet
     * para no dejar objetos en la memoria
     * @param con
     * @param ps
     * @param rs
     */
    public static void closeConnection(Connection con, PreparedStatement ps, ResultSet rs){
        try{
                if(rs != null){
                    rs.close();
                    rs = null;
                }
                if(ps != null){
                    ps.close();
                    ps = null;
                }
                if(con != null){
                    con.close();//mandamos llamar el metodo de cerrar conexion
                    con = null;
                }
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
    }
    
}
