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
public class TrUsuariosDto implements IBaseDto{
    
    private Integer idUsuario;
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private Date fechaNac;
    private String email;
    private String nombUsuario;
    private String contraseña;
    private Integer idTipoUsuario;
    private List<IBaseDto> listaUsuarios;
    
    public TrUsuariosDto(){
        this(null);
    }
    public TrUsuariosDto(Integer idUsuario){
        this(null,null,null,null,null,null,null,null,null);
    }
    public TrUsuariosDto(Integer idUsuario,String nombre,String apellidoP,String apellidoM,Date fechaNac,String email,String nombUsuario,String contraseña,Integer idTipoUsuario){
        setIdUsuario(idUsuario);
        setNombUsuario(nombUsuario);
        setApellidoP(apellidoP);
        setApellidoM(apellidoM);
        setFechaNac(fechaNac);
        setEmail(email);
        setNombUsuario(nombUsuario);
        setContraseña(contraseña);
        setIdTipoUsuario(idTipoUsuario);
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
     * @return the apellidoP
     */
    public String getApellidoP() {
        return apellidoP;
    }

    /**
     * @param apellidoP the apellidoP to set
     */
    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    /**
     * @return the apellidoM
     */
    public String getApellidoM() {
        return apellidoM;
    }

    /**
     * @param apellidoM the apellidoM to set
     */
    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    /**
     * @return the fechaNac
     */
    public Date getFechaNac() {
        return fechaNac;
    }

    /**
     * @param fechaNac the fechaNac to set
     */
    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the nombUsuario
     */
    public String getNombUsuario() {
        return nombUsuario;
    }

    /**
     * @param nombUsuario the nombUsuario to set
     */
    public void setNombUsuario(String nombUsuario) {
        this.nombUsuario = nombUsuario;
    }

    /**
     * @return the contraseña
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * @param contraseña the contraseña to set
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
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
     * @return the listaUsuarios
     */
    public List<IBaseDto> getListaUsuarios() {
        return listaUsuarios;
    }
    
}
