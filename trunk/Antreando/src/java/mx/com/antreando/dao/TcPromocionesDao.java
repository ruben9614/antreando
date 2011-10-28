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
import mx.com.antreando.dto.TcPromocionesDto;

/**
 *
 * @author Arizmendi
 */
public class TcPromocionesDao implements IBaseDao{

    
    public List<IBaseDto> selectAll() {
        ArrayList<IBaseDto> arreglo = new ArrayList();
        TcPromocionesDto tcPromociones = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DaoFactory.createConnection();
            ps = con.prepareStatement(SQL.tcPromocionesSelectAll);
            rs = ps.executeQuery();
            while(rs.next()){
                tcPromociones= new TcPromocionesDto();
                tcPromociones.setIdPromociones(rs.getInt("ID_PROMOCION"));
                tcPromociones.setDescripcion(rs.getString("DESCRIPCION"));
                tcPromociones.setFecha(rs.getDate("FECHA"));
                tcPromociones.setIdAntroP(rs.getInt("ID_ANTROP"));
                arreglo.add(tcPromociones);
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
        TcPromocionesDto tcPromociones = null;
        try{
            con = DaoFactory.createConnection();
            ps = con.prepareStatement(SQL.tcPromocionesSelectById);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()){
                tcPromociones = new TcPromocionesDto();
                tcPromociones.setIdPromociones(id);
                tcPromociones.setDescripcion(rs.getString("DESCRIPCION"));
                tcPromociones.setFecha(rs.getDate("FECHA"));
                tcPromociones.setIdAntroP(rs.getInt("ID_ANTROP"));
                tcPromociones.setIdAntroP(id);
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }finally{
            DaoFactory.closeConnection(con, ps, rs);
        }
            return tcPromociones;
    }

    
    public int insert(IBaseDto dto) {
        Connection con = null;
        PreparedStatement ps = null;
        int exito = 0;
        TcPromocionesDto tcPromociones = null;
        try{
            con = DaoFactory.createConnection();
            ps = con.prepareStatement(SQL.tcPromocionesInsert);
            tcPromociones = (TcPromocionesDto)dto;
            ps.setString(1, tcPromociones.getDescripcion());
            ps.setDate(2, tcPromociones.getFecha());
            ps.setInt(3, tcPromociones.getIdAntroP());
            ps.setInt(4, tcPromociones.getIdPromociones());
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
        TcPromocionesDto tcPromociones = null;
        try{
            con = DaoFactory.createConnection();
            ps = con.prepareStatement(SQL.tcPromocionesUpdateById);
            tcPromociones = (TcPromocionesDto)dto;
            ps.setString(1, tcPromociones.getDescripcion());
            ps.setDate(2, tcPromociones.getFecha());
            ps.setInt(3, tcPromociones.getIdAntroP());
            ps.setInt(4, tcPromociones.getIdPromociones());
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
            ps = con.prepareStatement(SQL.tcPromocionesDeleteById);
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

    @Override
    public IBaseDto selectLogin(IBaseDto dto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


}
    

