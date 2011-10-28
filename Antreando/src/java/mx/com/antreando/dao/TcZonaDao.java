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
import mx.com.antreando.dto.TcZonaDto;

/**
 *
 * @author Arizmendi
 */
public class TcZonaDao implements IBaseDao{

    public List<IBaseDto> selectAll() {
        ArrayList<IBaseDto> arreglo = new ArrayList();
        TcZonaDto tcZona = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //
            con = DaoFactory.createConnection();
            ps = con.prepareStatement(SQL.tcZonaSelectAll);
            rs = ps.executeQuery();
            while(rs.next()){
                tcZona= new TcZonaDto();
                tcZona.setIdZona(rs.getInt("ID_ZONA"));
                tcZona.setDescripcion(rs.getString("DESCRIPCION"));
                arreglo.add(tcZona);
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
        TcZonaDto tcZona = null;
        try{
            con = DaoFactory.createConnection();
            ps = con.prepareStatement(SQL.tcZonaSelectById);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()){
                tcZona = new TcZonaDto();
                tcZona.setIdZona(id);
                tcZona.setDescripcion(rs.getString("DESCRIPCION"));
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }finally{
            DaoFactory.closeConnection(con, ps, rs);
        }
            return tcZona;
        }


    public int insert(IBaseDto dto) {
        Connection con = null;
        PreparedStatement ps = null;
        int exito = 0;
        TcZonaDto tcZona = null;
        try{
            con = DaoFactory.createConnection();
            ps = con.prepareStatement(SQL.tcZonaInsert);
            tcZona = (TcZonaDto)dto;
            ps.setString(1, tcZona.getDescripcion());
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
        TcZonaDto tcZona = null;
        try{
            con = DaoFactory.createConnection();
            ps = con.prepareStatement(SQL.tcZonaUpdateById);
            tcZona = (TcZonaDto)dto;
            ps.setString(1, tcZona.getDescripcion());
            ps.setInt(2, tcZona.getIdZona());
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
            ps = con.prepareStatement(SQL.tcZonaDeleteById);
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
