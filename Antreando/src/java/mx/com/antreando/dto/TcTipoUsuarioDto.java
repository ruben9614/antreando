/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.antreando.dto;

import java.util.List;

/**
 *
 * @author Arizmendi
 */
public class TcTipoUsuarioDto implements IBaseDto{
    
    private Integer idTipoUsuario;
    private String descripcion;
    private List<IBaseDto> listaTipoUsuarios;
    
    public TcTipoUsuarioDto(){
        this(null);
    }
    public TcTipoUsuarioDto(Integer idTipoUsuario){
        this(null,null);
    }
    public TcTipoUsuarioDto(Integer idTipoUsuario, String descripcion){
        setIdTipoUsuario(idTipoUsuario);
        setDescripcion(descripcion);
    }

    /**
     * @return the idTipoUsuario
     */
    public Integer getIdTipoUsuario() {
        return idTipoUsuario;
    }

    /**
     * @param idTipoUsuario the idTipoUsuario to set
     */
    public void setIdTipoUsuario(Integer idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
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
     * @return the listaTipoUsuarios
     */
    public List<IBaseDto> getListaTipoUsuarios() {
        return listaTipoUsuarios;
    }
    
}
