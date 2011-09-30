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
public class TcZonaDto implements IBaseDto{
    
    private Integer idZona;
    private String descripcion;
    private List<IBaseDto> listaZonas;
    
    public TcZonaDto(){
        this(null);
    }
    public TcZonaDto(Integer idZona){
        this(null,null);
    }
    public TcZonaDto(Integer idZona, String descripcion){
        setIdZona(idZona);
        setDescripcion(descripcion);
    }

    /**
     * @return the idZona
     */
    public Integer getIdZona() {
        return idZona;
    }

    /**
     * @param idZona the idZona to set
     */
    public void setIdZona(Integer idZona) {
        this.idZona = idZona;
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
     * @return the listaZonas
     */
    public List<IBaseDto> getListaZonas() {
        return listaZonas;
    }
    
}
