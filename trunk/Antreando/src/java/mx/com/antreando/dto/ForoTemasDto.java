/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.antreando.dto;

import java.sql.Date;
import java.util.List;

/**
 *
 * @author Adriana
 */
public class ForoTemasDto implements IBaseDto{
    
    private Integer idForoTemas;
    private String titulo;
    private String pregunta;
    private String comentario;
    private Date fecha;
    private Integer idUsuarioFT;
    private List<IBaseDto> listaForoTemas;
    
    public ForoTemasDto(){
        this(null);
    }
    public ForoTemasDto(Integer idForoTemas){
        this(null,null,null,null,null,null);
    }
    public ForoTemasDto(Integer idForoTemas, String titulo, String pregunta, String comentario, Date fecha, Integer idUsuarioFT){
        setIdForoTemas(idForoTemas);
        setTitulo(titulo);
        setPregunta(pregunta);
        setComentario(comentario);
        setFecha(fecha);
        setIdUsuarioFT(idUsuarioFT);
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getIdForoTemas() {
        return idForoTemas;
    }

    public void setIdForoTemas(Integer idForoTemas) {
        this.idForoTemas = idForoTemas;
    }

    public Integer getIdUsuarioFT() {
        return idUsuarioFT;
    }

    public void setIdUsuarioFT(Integer idUsuarioFT) {
        this.idUsuarioFT = idUsuarioFT;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public List<IBaseDto> getlistaForoTemas() {
        return listaForoTemas;
    }
}
