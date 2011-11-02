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
import mx.com.antreando.dto.TcPromocionesDto;
import mx.com.antreando.dto.TrNoticiasDto;

/**
 *
 * @author Arizmendi
 */
public class TrNoticiasDao implements IBaseDao{


    public List<IBaseDto> selectAll() {
        ArrayList<IBaseDto> arreglo = new ArrayList();
        TrNoticiasDto trNoticias = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DaoGeneral.createConnection();
            ps = con.prepareStatement(SQL.trNoticiasSelectAll);
            rs = ps.executeQuery();
            while(rs.next()){
                trNoticias= new TrNoticiasDto();
                trNoticias.setIdNoticia(rs.getInt("ID_NOTICIAS"));
                trNoticias.setFechaCreacion(rs.getDate("FECHA_CREACION"));
                trNoticias.setFechaInicio(rs.getDate("FECHA_INICIO"));
                trNoticias.setFechaFin(rs.getDate("FECHA_FIN"));
                trNoticias.setDescripcion(rs.getString("DESCRIPCION"));
                trNoticias.setRutaImagen(rs.getString("RUTA_IMAGEN"));
                trNoticias.setIdAntroN(rs.getInt("ID_ANTRON"));
                arreglo.add(trNoticias);
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
        TrNoticiasDto trNoticias = null;
        try{
            con = DaoGeneral.createConnection();
            ps = con.prepareStatement(SQL.trNoticiasSelectById);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()){
                trNoticias= new TrNoticiasDto();
                trNoticias.setIdNoticia(rs.getInt("ID_NOTICIAS"));
                trNoticias.setFechaCreacion(rs.getDate("FECHA_CREACION"));
                trNoticias.setFechaInicio(rs.getDate("FECHA_INICIO"));
                trNoticias.setFechaFin(rs.getDate("FECHA_FIN"));
                trNoticias.setDescripcion(rs.getString("DESCRIPCION"));
                trNoticias.setRutaImagen(rs.getString("RUTA_IMAGEN"));
                trNoticias.setIdAntroN(rs.getInt("ID_ANTRON"));
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }finally{
            DaoGeneral.closeConnection(con, ps, rs);
        }
            return trNoticias;
    }


    public int insert(IBaseDto dto) {
        Connection con = null;
        PreparedStatement ps = null;
        int exito = 0;
        TrNoticiasDto trNoticias = null;
        try{
            con = DaoGeneral.createConnection();
            ps = con.prepareStatement(SQL.trNoticiasInsert);
            trNoticias = (TrNoticiasDto)dto;
            ps.setDate(1, trNoticias.getFechaCreacion());
            ps.setDate(2, trNoticias.getFechaInicio());
            ps.setDate(3, trNoticias.getFechaFin());
            ps.setString(4, trNoticias.getDescripcion());
            ps.setString(5, trNoticias.getRutaImagen());        
            ps.setInt(6, trNoticias.getIdAntroN());
            ps.setInt(7, trNoticias.getIdNoticia());
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
        TrNoticiasDto trNoticias = null;
        try{
            con = DaoGeneral.createConnection();
            ps = con.prepareStatement(SQL.trNoticiasUpdateById);
            trNoticias = (TrNoticiasDto)dto;
            ps.setDate(1, trNoticias.getFechaCreacion());
            ps.setDate(2, trNoticias.getFechaInicio());
            ps.setDate(3, trNoticias.getFechaFin());
            ps.setString(4, trNoticias.getDescripcion());
            ps.setString(5, trNoticias.getRutaImagen());        
            ps.setInt(6, trNoticias.getIdAntroN());
            ps.setInt(7, trNoticias.getIdNoticia());
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
            ps = con.prepareStatement(SQL.trNoticiasDeleteById);
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
