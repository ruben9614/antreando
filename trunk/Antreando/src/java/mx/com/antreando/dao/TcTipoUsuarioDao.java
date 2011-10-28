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
import mx.com.antreando.dto.TcTipoUsuarioDto;

/**
 *
 * @author Arizmendi
 */
public class TcTipoUsuarioDao implements IBaseDao{

    
    public List<IBaseDto> selectAll() {
        ArrayList<IBaseDto> arreglo = new ArrayList();
        TcTipoUsuarioDto tcTipoUsuario = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //
            con = DaoFactory.createConnection();
            ps = con.prepareStatement(SQL.tcTipoUsuarioSelectAll);
            rs = ps.executeQuery();
            while(rs.next()){
                tcTipoUsuario= new TcTipoUsuarioDto();
                tcTipoUsuario.setIdTipoUsuario(rs.getInt("IDTC_TIPOUSUARIO"));
                tcTipoUsuario.setDescripcion(rs.getString("DESCRIPCION"));
                arreglo.add(tcTipoUsuario);
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
        TcTipoUsuarioDto tcTipoUsuario = null;
        try{
            con = DaoFactory.createConnection();
            ps = con.prepareStatement(SQL.tcTipoUsuarioSelectById);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()){
                tcTipoUsuario = new TcTipoUsuarioDto();
                tcTipoUsuario.setIdTipoUsuario(id);
                tcTipoUsuario.setDescripcion(rs.getString("DESCRIPCION"));
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }finally{
            DaoFactory.closeConnection(con, ps, rs);
        }
            return tcTipoUsuario;
        }


    public int insert(IBaseDto dto) {
        Connection con = null;
        PreparedStatement ps = null;
        int exito = 0;
        TcTipoUsuarioDto tcTipoUsuario = null;
        try{
            con = DaoFactory.createConnection();
            ps = con.prepareStatement(SQL.tcTipoUsuaioInsert);
            tcTipoUsuario = (TcTipoUsuarioDto)dto;
            ps.setString(1, tcTipoUsuario.getDescripcion());
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
        TcTipoUsuarioDto tcTipoUsuario = null;
        try{
            con = DaoFactory.createConnection();
            ps = con.prepareStatement(SQL.tcTipoUsuaioUpdateById);
            tcTipoUsuario = (TcTipoUsuarioDto)dto;
            ps.setString(1, tcTipoUsuario.getDescripcion());
            ps.setInt(2, tcTipoUsuario.getIdTipoUsuario());
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
            ps = con.prepareStatement(SQL.tcTipoUsuaioDeleteById);
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
