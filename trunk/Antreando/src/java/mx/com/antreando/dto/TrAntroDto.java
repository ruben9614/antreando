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
public class TrAntroDto implements IBaseDto{
    
    private Integer idAntro;
    private String nombre;
    private String calle;
    private Integer numero;
    private String colonia;
    private String horario;
    private Integer mesasDisp;
    private Integer idZona;
    private Integer idCategoria;
    private Integer idUsuario;
    private List<IBaseDto> listaAntros;
    
    
    public TrAntroDto(){
        this(null);
    }
    public TrAntroDto(Integer idAntro){
        this(null,null,null,null,null,null,null,null,null,null);
    }
    public TrAntroDto(Integer idAntro,String nombre,String calle,Integer numero,String colonia,String horario,Integer mesasDisp,Integer idZona,Integer idCategoria,Integer idUsuario){
        setIdAntro(idAntro);
        setNombre(nombre);
        setCalle(calle);
        setNumero(numero);
        setColonia(colonia);
        setHorario(horario);
        setMesasDisp(mesasDisp);
        setIdZona(idZona);
        setIdCategoria(idCategoria);
        setIdUsuario(idUsuario);
    }

    /**
     * @return the idAntro
     */
    public Integer getIdAntro() {
        return idAntro;
    }

    /**
     * @param idAntro the idAntro to set
     */
    public void setIdAntro(Integer idAntro) {
        this.idAntro = idAntro;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the calle
     */
    public String getCalle() {
        return calle;
    }

    /**
     * @param calle the calle to set
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     * @return the numero
     */
    public Integer getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    /**
     * @return the colonia
     */
    public String getColonia() {
        return colonia;
    }

    /**
     * @param colonia the colonia to set
     */
    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    /**
     * @return the horario
     */
    public String getHorario() {
        return horario;
    }

    /**
     * @param horario the horario to set
     */
    public void setHorario(String horario) {
        this.horario = horario;
    }

    /**
     * @return the mesasDisp
     */
    public Integer getMesasDisp() {
        return mesasDisp;
    }

    /**
     * @param mesasDisp the mesasDisp to set
     */
    public void setMesasDisp(Integer mesasDisp) {
        this.mesasDisp = mesasDisp;
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
     * @return the idUsuario
     */
    public Integer getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * @return the listaAntros
     */
    public List<IBaseDto> getListaAntros() {
        return listaAntros;
    }
    
}
