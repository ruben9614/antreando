/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.antreando.dto;

import java.sql.Date;
import java.util.List;

/**
 *
 * @author Arizmendi
 */
public class TcPromocionesDto implements IBaseDto{
    
    private Integer idPromociones;
    private String descripcion;
    private Date fecha;
    private Integer idAntroP;
    private List<IBaseDto> listaPromociones;
    
    
    public TcPromocionesDto(){
        this(null);
    }
    public TcPromocionesDto(Integer idPromociones){
        this(null,null,null,null);
    }
    public TcPromocionesDto(Integer idPromociones,String descripcion,Date fecha, Integer idAntroP){
        setIdPromociones(idPromociones);
        setDescripcion(descripcion);
        setFecha(fecha);
        setIdAntroP(idAntroP);
    }

    /**
     * @return the idPromociones
     */
    public Integer getIdPromociones() {
        return idPromociones;
    }

    /**
     * @param idPromociones the idPromociones to set
     */
    public void setIdPromociones(Integer idPromociones) {
        this.idPromociones = idPromociones;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the idAntroP
     */
    public Integer getIdAntroP() {
        return idAntroP;
    }

    /**
     * @param idAntroP the idAntroP to set
     */
    public void setIdAntroP(Integer idAntroP) {
        this.idAntroP = idAntroP;
    }

    /**
     * @return the listaPromociones
     */
    public List<IBaseDto> getListaPromociones() {
        return listaPromociones;
    }
}
