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
public class TcCategoriaDto implements IBaseDto{
    
    private Integer idCategoria;
    private String descripcion;
    private List<IBaseDto> listaCategorias; //Solo GET
    
    public TcCategoriaDto(){
        this(null);
    }
    public TcCategoriaDto(Integer idCategoria){
        this(null,null);
    }
    public TcCategoriaDto(Integer idCategoria, String descripcion){
        setIdCategoria(idCategoria);
        setDescripcion(descripcion);
    }

    /**
     * @return the idCategoria
     */
    public Integer getIdCategoria() {
        return idCategoria;
    }

    /**
     * @param idCategoria the idCategoria to set
     */
    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
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
     * @return the listaCategorias
     */
    public List<IBaseDto> getListaCategorias() {
        return listaCategorias;
    }
    
}
