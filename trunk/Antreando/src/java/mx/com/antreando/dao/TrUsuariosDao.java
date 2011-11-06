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
import mx.com.antreando.dao.general.DaoGeneral;
import mx.com.antreando.dao.sql.SQL;
import mx.com.antreando.dto.IBaseDto;
import mx.com.antreando.dto.TrUsuariosDto;

/**
 *
 * @author Arizmendi
 */
public class TrUsuariosDao implements IBaseDao{

   
    public List<IBaseDto> selectAll() {
        ArrayList<IBaseDto> arreglo = new ArrayList();
        TrUsuariosDto trUsuarios = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DaoGeneral.createConnection();
            ps = con.prepareStatement(SQL.trUsuariosSelectAll);
            rs = ps.executeQuery();
            while(rs.next()){
                trUsuarios= new TrUsuariosDto();
                trUsuarios.setIdUsuario(rs.getInt("ID_USUARIO"));
                trUsuarios.setNombre(rs.getString("NOMBRE"));
                trUsuarios.setApellidoP(rs.getString("APELLIDO_P"));
                trUsuarios.setApellidoM(rs.getString("APELLIDO_M"));
                trUsuarios.setFechaNac(rs.getDate("FECHA_NAC"));
                trUsuarios.setEmail(rs.getString("EMAIL"));
                trUsuarios.setNombUsuario(rs.getString("NOMB_USUARIO"));
                trUsuarios.setContraseña(rs.getString("CONTRASEÑA"));
                trUsuarios.setIdTipoUsuario(rs.getInt("IDTC_TIPOUSUARIO"));
                arreglo.add(trUsuarios);
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


    public IBaseDto selectById(Integer id) {
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        TrUsuariosDto trUsuarios = null;
        try{
            con = DaoGeneral.createConnection();
            ps = con.prepareStatement(SQL.trUsuariosSelectById);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()){
                trUsuarios = new TrUsuariosDto();
                trUsuarios.setIdUsuario(rs.getInt("ID_USUARIO"));
                trUsuarios.setNombre(rs.getString("NOMBRE"));
                trUsuarios.setApellidoP(rs.getString("APELLIDO_P"));
                trUsuarios.setApellidoM(rs.getString("APELLIDO_M"));
                trUsuarios.setFechaNac(rs.getDate("FECHA_NAC"));
                trUsuarios.setEmail(rs.getString("EMAIL"));
                trUsuarios.setNombUsuario(rs.getString("NOMB_USUARIO"));
                trUsuarios.setContraseña(rs.getString("CONTRASEÑA"));
                trUsuarios.setIdTipoUsuario(rs.getInt("IDTC_TIPOUSUARIO"));
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }finally{
            DaoGeneral.closeConnection(con, ps, rs);
        }
            return trUsuarios;
    }


    public int insert(IBaseDto dto) {
        Connection con = null;
        PreparedStatement ps = null;
        int exito = 0;
        TrUsuariosDto trUsuarios = null;
        try{
            con = DaoGeneral.createConnection();
            ps = con.prepareStatement(SQL.trUsuariosInsert);
            trUsuarios = (TrUsuariosDto)dto;
            ps.setString(1, trUsuarios.getNombre());
            ps.setString(2, trUsuarios.getApellidoP());
            ps.setString(3, trUsuarios.getApellidoM());
            ps.setDate(4, trUsuarios.getFechaNac());
            ps.setString(5, trUsuarios.getEmail());
            ps.setString(6, trUsuarios.getNombUsuario());
            ps.setString(7, trUsuarios.getContraseña());
            ps.setInt(8, trUsuarios.getIdTipoUsuario());
            exito = ps.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            DaoGeneral.closeConnection(con, ps);
        }
        return exito;
    }


    public int updateById(IBaseDto dto) {
        Connection con = null;
        PreparedStatement ps = null;
        int exito = 0;
        TrUsuariosDto trUsuarios = null;
        try{
            con = DaoGeneral.createConnection();
            ps = con.prepareStatement(SQL.trUsuariosUpdateById);
            trUsuarios = (TrUsuariosDto)dto;
            ps.setString(1, trUsuarios.getNombre());
            ps.setString(2, trUsuarios.getApellidoP());
            ps.setString(3, trUsuarios.getApellidoM());
            ps.setDate(4, trUsuarios.getFechaNac());
            ps.setString(5, trUsuarios.getEmail());
            ps.setString(6, trUsuarios.getNombUsuario());
            ps.setString(7, trUsuarios.getContraseña());
            ps.setInt(8, trUsuarios.getIdTipoUsuario());
            ps.setInt(9, trUsuarios.getIdUsuario());
            exito = ps.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            DaoGeneral.closeConnection(con, ps);
        }return exito;
    }


    public int deleteById(Integer id) {
        Connection con = null;
        PreparedStatement ps = null;
        int exito = 0;
        try{
            con = DaoGeneral.createConnection();
            ps = con.prepareStatement(SQL.trUsuariosDeleteById);
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

    
    public IBaseDto selectLogin(IBaseDto dto) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        TrUsuariosDto usuarioDto =null;
        try{
            usuarioDto=(TrUsuariosDto)dto;
            con = DaoGeneral.createConnection();
            ps = con.prepareStatement("SELECT NOMB_USUARIO, CONTRASEÑA FROM TR_USUARIOS WHERE NOMB_USUARIO=? AND CONTRASEÑA=?");
            ps.setString(1, usuarioDto.getNombUsuario());
            ps.setString(2, usuarioDto.getContraseña());
            rs = ps.executeQuery();
            if(rs.first()){
                usuarioDto = new TrUsuariosDto();
                usuarioDto.setNombUsuario(rs.getString("NOMB_USUARIO"));
                usuarioDto.setContraseña(rs.getString("CONTRASEÑA"));
            }
            else{
                usuarioDto = null;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        finally{
            DaoGeneral.closeConnection(con, ps, rs);
        }
        
        return usuarioDto;
    }
    
}
