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
import mx.com.antreando.dto.TrAntroDto;

/**
 *
 * @author Arizmendi
 */
public class TrAntroDao implements IBaseDao{

 
    public List<IBaseDto> selectAll() {
        ArrayList<IBaseDto> arreglo = new ArrayList();
        TrAntroDto trAntro = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DaoFactory.createConnection();
            ps = con.prepareStatement(SQL.trAntroSelectAll);
            rs = ps.executeQuery();
            while(rs.next()){
                trAntro= new TrAntroDto();
                trAntro.setIdAntro(rs.getInt("ID_ANTRO"));
                trAntro.setNombre(rs.getString("NOMBRE"));
                trAntro.setCalle(rs.getString("CALLE"));
                trAntro.setNumero(rs.getInt("NUMERO"));
                trAntro.setColonia(rs.getString("COLONIA"));
                trAntro.setHorario(rs.getString("HORARIO"));
                trAntro.setMesasDisp(rs.getInt("MESAS_DISP"));
                trAntro.setIdZona(rs.getInt("ID_ZONA"));
                trAntro.setIdCategoria(rs.getInt("ID_CATEGORIA"));
                trAntro.setIdUsuario(rs.getInt("ID_USUARIO"));
                arreglo.add(trAntro);
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
        TrAntroDto trAntro = null;
        try{
            con = DaoFactory.createConnection();
            ps = con.prepareStatement(SQL.trAntroSelectById);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()){
                trAntro = new TrAntroDto();
                trAntro.setIdAntro(id);
                trAntro.setNombre(rs.getString("NOMBRE"));
                trAntro.setCalle(rs.getString("CALLE"));
                trAntro.setNumero(rs.getInt("NUMERO"));
                trAntro.setColonia(rs.getString("COLONIA"));
                trAntro.setHorario(rs.getString("HORARIO"));
                trAntro.setMesasDisp(rs.getInt("MESAS_DISP"));
                trAntro.setIdZona(rs.getInt("ID_ZONA"));
                trAntro.setIdCategoria(rs.getInt("ID_CATEGORIA"));
                trAntro.setIdUsuario(rs.getInt("ID_USUARIO"));
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }finally{
            DaoFactory.closeConnection(con, ps, rs);
        }
            return trAntro;
        }


    public int insert(IBaseDto dto) {
        Connection con = null;
        PreparedStatement ps = null;
        int exito = 0;
        TrAntroDto trAntro = null;
        try{
            con = DaoFactory.createConnection();
            ps = con.prepareStatement(SQL.trAntroInsert);
            trAntro = (TrAntroDto)dto;
            ps.setString(1, trAntro.getNombre());
            ps.setString(2, trAntro.getCalle());
            ps.setInt(3, trAntro.getNumero());
            ps.setString(4, trAntro.getColonia());
            ps.setString(5, trAntro.getHorario());
            ps.setInt(6, trAntro.getMesasDisp());
            ps.setInt(7, trAntro.getIdZona());
            ps.setInt(8, trAntro.getIdCategoria());
            ps.setInt(9, trAntro.getIdUsuario());
            ps.setInt(10, trAntro.getIdAntro());
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
        TrAntroDto trAntro = null;
        try{
            con = DaoFactory.createConnection();
            ps = con.prepareStatement(SQL.trAntroUpdateById);
            trAntro = (TrAntroDto)dto;
            ps.setString(1, trAntro.getNombre());
            ps.setString(2, trAntro.getCalle());
            ps.setInt(3, trAntro.getNumero());
            ps.setString(4, trAntro.getColonia());
            ps.setString(5, trAntro.getHorario());
            ps.setInt(6, trAntro.getMesasDisp());
            ps.setInt(7, trAntro.getIdZona());
            ps.setInt(8, trAntro.getIdCategoria());
            ps.setInt(9, trAntro.getIdUsuario());
            ps.setInt(10, trAntro.getIdAntro());
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
            ps = con.prepareStatement(SQL.trAntroDeleteById);
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
