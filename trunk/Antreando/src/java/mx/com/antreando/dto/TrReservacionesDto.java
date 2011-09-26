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
public class TrReservacionesDto implements IBaseDto{
    
    private Integer idReservacion;
    private Date fecha;
    private Integer numMesas;
    private Integer idUsuarioR;
    private Integer idAntroR;
    private List<IBaseDto> listaReservaciones;
    
    public TrReservacionesDto(){
        this(null);
    }
    public TrReservacionesDto(Integer idReservacion){
        this(null,null,null,null,null);
    }
    public TrReservacionesDto(Integer idReservacion,Date fecha,Integer numMesas,Integer idUsuarioR,Integer idAntroR){
        setIdReservacion(idReservacion);
        setFecha(fecha);
        setNumMesas(numMesas);
        setIdUsuarioR(idUsuarioR);
        setIdAntroR(idAntroR);
    }

    /**
     * @return the idReservacion
     */
    public Integer getIdReservacion() {
        return idReservacion;
    }

    /**
     * @param idReservacion the idReservacion to set
     */
    public void setIdReservacion(Integer idReservacion) {
        this.idReservacion = idReservacion;
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
     * @return the numMesas
     */
    public Integer getNumMesas() {
        return numMesas;
    }

    /**
     * @param numMesas the numMesas to set
     */
    public void setNumMesas(Integer numMesas) {
        this.numMesas = numMesas;
    }

    /**
     * @return the idUsuarioR
     */
    public Integer getIdUsuarioR() {
        return idUsuarioR;
    }

    /**
     * @param idUsuarioR the idUsuarioR to set
     */
    public void setIdUsuarioR(Integer idUsuarioR) {
        this.idUsuarioR = idUsuarioR;
    }

    /**
     * @return the idAntroR
     */
    public Integer getIdAntroR() {
        return idAntroR;
    }

    /**
     * @param idAntroR the idAntroR to set
     */
    public void setIdAntroR(Integer idAntroR) {
        this.idAntroR = idAntroR;
    }

    /**
     * @return the listaReservaciones
     */
    public List<IBaseDto> getListaReservaciones() {
        return listaReservaciones;
    }
    
}
