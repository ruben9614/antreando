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
import mx.com.antreando.dto.ForoTemasDto;
import mx.com.antreando.dto.IBaseDto;

/**
 *
 * @author Adriana
 */
public class ForoTemasDao implements IBaseDao{

    @Override
    public List<IBaseDto> selectAll() {
        ArrayList<IBaseDto> arreglo = new ArrayList();
        ForoTemasDto foroTemas = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DaoGeneral.createConnection();
            ps = con.prepareStatement(SQL.ForoTemasSelectAll);
            rs = ps.executeQuery();
            while(rs.next()){
                foroTemas= new ForoTemasDto();
                foroTemas.setIdForoTemas(rs.getInt("IDFOROTEMAS"));
                foroTemas.setTitulo(rs.getString("TITULO"));
                foroTemas.setPregunta(rs.getString("PREGUNTA"));
                foroTemas.setComentario(rs.getString("COMENTARIO"));
                foroTemas.setFecha(rs.getDate("FECHA"));
                foroTemas.setIdUsuarioFT(rs.getInt("ID_USUARIOFT"));
                arreglo.add(foroTemas);
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
        ForoTemasDto foroTemas = null;
        try{
            con = DaoGeneral.createConnection();
            ps = con.prepareStatement(SQL.ForoTemasSelectById);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()){
                foroTemas= new ForoTemasDto();
                foroTemas.setIdForoTemas(rs.getInt("IDFOROTEMAS"));
                foroTemas.setTitulo(rs.getString("TITULO"));
                foroTemas.setPregunta(rs.getString("PREGUNTA"));
                foroTemas.setComentario(rs.getString("COMENTARIO"));
                foroTemas.setFecha(rs.getDate("FECHA"));
                foroTemas.setIdUsuarioFT(rs.getInt("ID_USUARIOFT"));
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }finally{
            DaoGeneral.closeConnection(con, ps, rs);
        }
            return foroTemas;
    }

    @Override
    public int insert(IBaseDto dto) {
        Connection con = null;
        PreparedStatement ps = null;
        int exito = 0;
        ForoTemasDto foroTemas = null;
        try{
            con = DaoGeneral.createConnection();
            ps = con.prepareStatement(SQL.ForoTemasInsert);
            foroTemas= (ForoTemasDto)dto;
            ps.setString(1, foroTemas.getTitulo());
            ps.setString(2, foroTemas.getPregunta());
            ps.setString(3, foroTemas.getComentario());
            ps.setDate(4, foroTemas.getFecha());
            ps.setInt(5, foroTemas.getIdUsuarioFT());
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
        ForoTemasDto foroTemas = null;
        try{
            con = DaoGeneral.createConnection();
            ps = con.prepareStatement(SQL.ForoTemasUpdateById);
            foroTemas = (ForoTemasDto)dto;
            ps.setString(1, foroTemas.getTitulo());
            ps.setString(2, foroTemas.getPregunta());
            ps.setString(3, foroTemas.getComentario());
            ps.setDate(4, foroTemas.getFecha());
            ps.setInt(5, foroTemas.getIdUsuarioFT());
            ps.setInt(6, foroTemas.getIdForoTemas());
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
            ps = con.prepareStatement(SQL.ForoTemasDeleteById);
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
