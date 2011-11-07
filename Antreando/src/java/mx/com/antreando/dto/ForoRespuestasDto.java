/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.antreando.dto;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

/**
 *
 * @author Adriana
 */
public class ForoRespuestasDto implements IBaseDto{
    
    private Integer idForoRespuestas;
    private String mesaje;
    private Date fecha;
    private Time hora;
    private Integer idForoTemas;
    private Integer idUsuarioFR;
    private List<IBaseDto> listaForoRespuestas;
    
    public ForoRespuestasDto(){
        this(null);
    }
    public ForoRespuestasDto(Integer idForoRespuestas){
        this(null,null,null,null,null,null);
    }
    public ForoRespuestasDto(Integer idForoRespuestas, String mesaje, Date fecha, Time hora, Integer idForoTemas, Integer idUsuarioFR){
        setIdForoRespuestas(idForoRespuestas);
        setMesaje(mesaje);
        setFecha(fecha);
        setHora(hora);
        setIdForoTemas(idForoTemas);
        setIdUsuarioFR(idUsuarioFR);
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public Integer getIdForoRespuestas() {
        return idForoRespuestas;
    }

    public void setIdForoRespuestas(Integer idForoRespuestas) {
        this.idForoRespuestas = idForoRespuestas;
    }

    public Integer getIdForoTemas() {
        return idForoTemas;
    }

    public void setIdForoTemas(Integer idForoTemas) {
        this.idForoTemas = idForoTemas;
    }

    public Integer getIdUsuarioFR() {
        return idUsuarioFR;
    }

    public void setIdUsuarioFR(Integer idUsuarioFR) {
        this.idUsuarioFR = idUsuarioFR;
    }

    public String getMesaje() {
        return mesaje;
    }

    public void setMesaje(String mesaje) {
        this.mesaje = mesaje;
    }
    
    public List<IBaseDto> getlistaForoRespuestas() {
        return listaForoRespuestas;
    }
}
