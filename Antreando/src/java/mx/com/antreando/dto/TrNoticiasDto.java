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
public class TrNoticiasDto implements IBaseDto{
    
    private Integer idNoticia;
    private Date fechaCreacion;
    private Date fechaInicio;
    private Date fechaFin;
    private String descripcion;
    private String rutaImagen;
    private Integer idAntroN;
    private List<IBaseDto> listaNoticias;
    
    public TrNoticiasDto(){
        this(null);
    }
    public TrNoticiasDto(Integer idNoticia){
        this(null,null,null,null,null,null,null);
    }
    public TrNoticiasDto(Integer idNoticia,Date fechaCreacion,Date fechaInicio,Date fechaFin,String descripcion,String rutaImagen,Integer idAntroN){
        setIdAntroN(idAntroN);
        setFechaCreacion(fechaCreacion);
        setFechaInicio(fechaInicio);
        setFechaFin(fechaFin);
        setDescripcion(descripcion);
        setRutaImagen(rutaImagen);
        setIdAntroN(idAntroN);
    }

    /**
     * @return the idNoticia
     */
    public Integer getIdNoticia() {
        return idNoticia;
    }

    /**
     * @param idNoticia the idNoticia to set
     */
    public void setIdNoticia(Integer idNoticia) {
        this.idNoticia = idNoticia;
    }

    /**
     * @return the fechaCreacion
     */
    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     * @param fechaCreacion the fechaCreacion to set
     */
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    /**
     * @return the fechaInicio
     */
    public Date getFechaInicio() {
        return fechaInicio;
    }

    /**
     * @param fechaInicio the fechaInicio to set
     */
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * @return the fechaFin
     */
    public Date getFechaFin() {
        return fechaFin;
    }

    /**
     * @param fechaFin the fechaFin to set
     */
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
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
     * @return the rutaImagen
     */
    public String getRutaImagen() {
        return rutaImagen;
    }

    /**
     * @param rutaImagen the rutaImagen to set
     */
    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    /**
     * @return the idAntroN
     */
    public Integer getIdAntroN() {
        return idAntroN;
    }

    /**
     * @param idAntroN the idAntroN to set
     */
    public void setIdAntroN(Integer idAntroN) {
        this.idAntroN = idAntroN;
    }

    /**
     * @return the listaNoticias
     */
    public List<IBaseDto> getListaNoticias() {
        return listaNoticias;
    }
    
    
}
