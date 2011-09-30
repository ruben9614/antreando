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
import mx.com.antreando.dto.TcCategoriaDto;

/**
 *
 * @author Arizmendi
 */
public class TcCategoriaDao implements IBaseDao{

    
    public List<IBaseDto> selectAll() {
        ArrayList<IBaseDto> arreglo = new ArrayList();
        TcCategoriaDto tcCategoria = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //
            con = DaoFactory.createConnection();
            ps = con.prepareStatement(SQL.tcCategoriaSelectAll);
            rs = ps.executeQuery();
            while(rs.next()){
                tcCategoria= new TcCategoriaDto();
                tcCategoria.setIdCategoria(rs.getInt("ID_CATEGORIA"));
                tcCategoria.setDescripcion(rs.getString("CARRERA"));
                arreglo.add(tcCategoria);
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
        TcCategoriaDto tcCategoria = null;
        try{
            con = DaoFactory.createConnection();
            ps = con.prepareStatement(SQL.tcCategoriaSelectById);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()){
                tcCategoria = new TcCategoriaDto();
                tcCategoria.setIdCategoria(id);
                tcCategoria.setDescripcion(rs.getString("DESCRIPCION"));
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }finally{
            DaoFactory.closeConnection(con, ps, rs);
        }
            return tcCategoria;
        }

    
    public int insert(IBaseDto dto) {
        Connection con = null;
        PreparedStatement ps = null;
        int exito = 0;
        TcCategoriaDto tcCategoria = null;
        try{
            con = DaoFactory.createConnection();
            ps = con.prepareStatement(SQL.tcCategoriaInsert);
            tcCategoria = (TcCategoriaDto)dto;
            ps.setString(1, tcCategoria.getDescripcion());
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
        TcCategoriaDto tcCategoria = null;
        try{
            con = DaoFactory.createConnection();
            ps = con.prepareStatement(SQL.tcCategoriaUpdateById);
            tcCategoria = (TcCategoriaDto)dto;
            ps.setString(1, tcCategoria.getDescripcion());
            ps.setInt(2, tcCategoria.getIdCategoria());
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
            ps = con.prepareStatement(SQL.tcCategoriaDeleteById);
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
