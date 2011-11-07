/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.antreando.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import mx.com.antreando.dao.general.DaoGeneral;
import mx.com.antreando.dao.sql.SQL;
import mx.com.antreando.dto.ForoRespuestasDto;
import mx.com.antreando.dto.IBaseDto;

/**
 *
 * @author Adriana
 */
public class ForoRespuestasDao implements IBaseDao{

    @Override
    public List<IBaseDto> selectAll() {
        ArrayList<IBaseDto> arreglo = new ArrayList();
        ForoRespuestasDto foroRespuestas = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DaoGeneral.createConnection();
            ps = con.prepareStatement(SQL.ForoRespuestasSelectAll);
            rs = ps.executeQuery();
            while(rs.next()){
                foroRespuestas= new ForoRespuestasDto();
                foroRespuestas.setIdForoRespuestas(rs.getInt("IDFORORESPUESTAS"));
                foroRespuestas.setMesaje(rs.getString("MESAJE"));
                foroRespuestas.setFecha(rs.getDate("FECHA"));
                foroRespuestas.setHora(rs.getTime("HORA"));
                foroRespuestas.setIdForoTemas(rs.getInt("IDFOROTEMAS"));
                foroRespuestas.setIdUsuarioFR(rs.getInt("ID_USUARIOFR"));
                arreglo.add(foroRespuestas);
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        finally{
            DaoGeneral.closeConnection(con, ps, rs);
        }
        return arreglo;
    }

    @Override
    public IBaseDto selectById(Integer id) {
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        ForoRespuestasDto foroRespuestas = null;
        try{
            con = DaoGeneral.createConnection();
            ps = con.prepareStatement(SQL.ForoRespuestasSelectById);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()){
                foroRespuestas = new ForoRespuestasDto();
                foroRespuestas.setIdForoRespuestas(id);
                foroRespuestas.setMesaje(rs.getString("MESAJE"));
                foroRespuestas.setFecha(rs.getDate("FECHA"));
                foroRespuestas.setHora(rs.getTime("HORA"));
                foroRespuestas.setIdForoTemas(rs.getInt("IDFOROTEMAS"));
                foroRespuestas.setIdUsuarioFR(rs.getInt("ID_USUARIOFR"));
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }finally{
            DaoGeneral.closeConnection(con, ps, rs);
        }
            return foroRespuestas;
    }

    @Override
    public int insert(IBaseDto dto) {
        Connection con = null;
        PreparedStatement ps = null;
        int exito = 0;
        ForoRespuestasDto foroRespuestas = null;
        try{
            con = DaoGeneral.createConnection();
            ps = con.prepareStatement(SQL.ForoRespuestasInsert);
            foroRespuestas = (ForoRespuestasDto)dto;
            ps.setString(1, foroRespuestas.getMesaje());
            ps.setDate(2, foroRespuestas.getFecha());
            ps.setTime(3, foroRespuestas.getHora());
            ps.setInt(4, foroRespuestas.getIdForoTemas());
            ps.setInt(5, foroRespuestas.getIdUsuarioFR());
            exito = ps.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
        DaoGeneral.closeConnection(con, ps);
        }
        return exito;
    }

    @Override
    public int updateById(IBaseDto dto) {
        Connection con = null;
        PreparedStatement ps = null;
        int exito = 0;
        ForoRespuestasDto foroRespuestas = null;
        try{
            con = DaoGeneral.createConnection();
            ps = con.prepareStatement(SQL.ForoRespuestasUpdateById);
            foroRespuestas = (ForoRespuestasDto)dto;
            ps.setString(1, foroRespuestas.getMesaje());
            ps.setDate(2, foroRespuestas.getFecha());
            ps.setTime(3, foroRespuestas.getHora());
            ps.setInt(4, foroRespuestas.getIdForoTemas());
            ps.setInt(5, foroRespuestas.getIdUsuarioFR());
            ps.setInt(6, foroRespuestas.getIdForoRespuestas());
            exito = ps.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            DaoGeneral.closeConnection(con, ps);
        }return exito;
    }

    @Override
    public int deleteById(Integer id) {
        Connection con = null;
        PreparedStatement ps = null;
        int exito = 0;
        try{
            con = DaoGeneral.createConnection();
            ps = con.prepareStatement(SQL.ForoRespuestasDeleteById);
            ps.setInt(1, id);
            exito = ps.executeUpdate();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        finally{
            DaoGeneral.closeConnection(con, ps);
        }
        return exito;
    }

    @Override
    public IBaseDto selectLogin(IBaseDto dto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
