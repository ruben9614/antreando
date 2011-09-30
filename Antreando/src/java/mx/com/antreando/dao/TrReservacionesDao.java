/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.antreando.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import mx.com.antreando.dao.factory.DaoFactory;
import mx.com.antreando.dao.sql.SQL;
import mx.com.antreando.dto.IBaseDto;
import mx.com.antreando.dto.TrReservacionesDto;

/**
 *
 * @author Arizmendi
 */
public class TrReservacionesDao implements IBaseDao{


    public List<IBaseDto> selectAll() {
        ArrayList<IBaseDto> arreglo = new ArrayList();
        TrReservacionesDto trReservaciones = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DaoFactory.createConnection();
            ps = con.prepareStatement(SQL.trReservacionesSelectAll);
            rs = ps.executeQuery();
            while(rs.next()){
                trReservaciones= new TrReservacionesDto();
                trReservaciones.setIdReservacion(rs.getInt("ID_RESERVACION"));
                trReservaciones.setFecha(rs.getDate("FECHA"));
                trReservaciones.setNumMesas(rs.getInt("NUM_MESAS"));
                trReservaciones.setIdUsuarioR(rs.getInt("ID_USUARIOR"));
                trReservaciones.setIdAntroR(rs.getInt("ID_ANTROR"));
                arreglo.add(trReservaciones);
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        finally{
            DaoFactory.closeConnection(con, ps, rs);
        }
        return arreglo;
    }


    public IBaseDto selectById(Integer id) {
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        TrReservacionesDto trReservaciones = null;
        try{
            con = DaoFactory.createConnection();
            ps = con.prepareStatement(SQL.trReservacionesSelectById);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()){
                trReservaciones= new TrReservacionesDto();
                trReservaciones.setIdReservacion(rs.getInt("ID_RESERVACION"));
                trReservaciones.setFecha(rs.getDate("FECHA"));
                trReservaciones.setNumMesas(rs.getInt("NUM_MESAS"));
                trReservaciones.setIdUsuarioR(rs.getInt("ID_USUARIOR"));
                trReservaciones.setIdAntroR(rs.getInt("ID_ANTROR"));
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }finally{
            DaoFactory.closeConnection(con, ps, rs);
        }
            return trReservaciones;
    }


    public int insert(IBaseDto dto) {
        Connection con = null;
        PreparedStatement ps = null;
        int exito = 0;
        TrReservacionesDto trReservaciones = null;
        try{
            con = DaoFactory.createConnection();
            ps = con.prepareStatement(SQL.trReservacionesInsert);
            trReservaciones = (TrReservacionesDto)dto;
            ps.setDate(1, trReservaciones.getFecha());
            ps.setInt(2, trReservaciones.getNumMesas());
            ps.setInt(3, trReservaciones.getIdUsuarioR());
            ps.setInt(4, trReservaciones.getIdAntroR());
            ps.setInt(5, trReservaciones.getIdReservacion());
            exito = ps.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
        DaoFactory.closeConnection(con, ps);
        }
        return exito;
    }


    public int updateById(IBaseDto dto) {
        Connection con = null;
        PreparedStatement ps = null;
        int exito = 0;
        TrReservacionesDto trReservaciones = null;
        try{
            con = DaoFactory.createConnection();
            ps = con.prepareStatement(SQL.trReservacionesUpdateById);
            trReservaciones = (TrReservacionesDto)dto;
            ps.setDate(1, trReservaciones.getFecha());
            ps.setInt(2, trReservaciones.getNumMesas());
            ps.setInt(3, trReservaciones.getIdUsuarioR());
            ps.setInt(4, trReservaciones.getIdAntroR());
            ps.setInt(5, trReservaciones.getIdReservacion());
            exito = ps.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            DaoFactory.closeConnection(con, ps);
        }return exito;
    }


    public int deleteById(Integer id) {
        Connection con = null;
        PreparedStatement ps = null;
        int exito = 0;
        try{
            con = DaoFactory.createConnection();
            ps = con.prepareStatement(SQL.trReservacionesDeleteById);
            ps.setInt(1, id);
            exito = ps.executeUpdate();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        finally{
            DaoFactory.closeConnection(con, ps);
        }
        return exito;
    }
    
}
