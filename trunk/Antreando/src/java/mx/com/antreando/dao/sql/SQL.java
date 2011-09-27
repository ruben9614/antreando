/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.antreando.dao.sql;

/**
 *
 * @author Arizmendi
 */
public class SQL {
    
    //TcCategoria
    public static String tcCategoriaSelectAll="SELECT TC_CATEGORIA.ID_CATEGORIA,TC_CATEGORIA.DESCRIPCION FROM TC_CATEGORIA";
    public static String tcCategoriaSelectById="SELECT TC_CATEGORIA.ID_CATEGORIA,TC_CATEGORIA.DESCRIPCION FROM TC_CATEGORIA WHERE TC_CATEGORIA.ID_CATEGORIA = ?";
    public static String tcCategoriaInsert="INSERT INTO TC_CATEGORIA (DESCRIPCION) VALUES (?)";
    public static String tcCategoriaUpdateById="UPDATE TC_CATEGORIA SET DESCRIPCION = ? WHERE ID_CATEGORIA = ?";
    public static String tcCategoriaDeleteById="DELETE FROM TC_CATEGORIA WHERE ID_CATEGORIA = ?";
    
    //TcPromociones
    public static String tcPromocionesSelectAll="SELECT TC_PROMOCIONES.ID_PROMOCION,TC_PROMOCIONES.DESCRIPCION,TC_PROMOCIONES.FECHA,TC_PROMOCIONES.ID_ANTROP";
    public static String tcPromocionesSelectById="SELECT TC_PROMOCIONES.ID_PROMOCION,TC_PROMOCIONES.DESCRIPCION,TC_PROMOCIONES.FECHA,TC_PROMOCIONES.ID_ANTROP WHERE TC_PROMOCIONES.ID_PROMOCION = ?";
    public static String tcPromocionesInsert="INSERT INTO (DESCRIPCION,FECHA,ID_ANTROP) VALUES (?,?,?)";
    public static String tcPromocionesUpdateById="UPDATE TC_PROMOCIONES SET DESCRIPCION = ?,FECHA = ?, ID_ANTROP = ? WHERE ID_PROMOCION = ?";
    public static String tcPromocionesDeleteById="DELETE FROM TC_PROMOCIONES WHERE ID_PROMOCION = ?";
    
    //TcTipoUsuario
    public static String tcTipoUsuarioSelectAll="SELECT TC_TIPOUSUARIO.IDTC_TIPOUSUARIO,TC_TIPOUSUARIO.DESCRIPCION";
    public static String tcTipoUsuarioSelectById="SELECT TC_TIPOUSUARIO.IDTC_TIPOUSUARIO,TC_TIPOUSUARIO.DESCRIPCION WHERE TC_TIPOUSUARIO.IDTC_TIPOUSUARIO = ?";
    public static String tcTipoUsuaioInsert="INSERT INTO (DESCRIPCION) VALUES (?)";
    public static String tcTipoUsuaioUpdateById="UPDATE TC_TIPOUSUARIO SET DESCRIPCION = ? WHERE IDTC_TIPOUSUARIO = ?";
    public static String tcTipoUsuaioDeleteById="DELETE FROM TC_TIPOUSUARIO WHERE IDTC_TIPOUSUARIO = ?";
    
    //TcZona
    public static String tcZonaSelectAll="SELECT TC_ZONA.ID_ZONA, TC_ZONA.DESCRIPCION FROM TC_ZONA";
    public static String tcZonaSelectById="SELECT TC_ZONA.ID_ZONA, TC_ZONA.DESCRIPCION FROM TC_ZONA WHERE TC_ZONA.ID_ZONA = ?";
    public static String tcZonaInsert="INSERT INTO TC_ZONA (DESCRIPCION) VALUES (?)";
    public static String tcZonaUpdateById="UPDATE TC_ZONA SET DESCRIPCION = ? WHERE TC_ZONA.ID_ZONA = ?";
    public static String tcZonaDeleteById="DELETE FROM TC_ZONA WHERE ID_ZONA = ?";
    
    //TrAntro
    public static String trAntroSelectAll="SELECT TR_ANTRO.ID_ANTRO,TR_ANTRO.NOMBRE,TR_ANTRO.CALLE,TR_ANTRO.NUMERO,TR_ANTRO.COLONIA,TR_ANTRO.HORARIO,TR_ANTRO.MESAS_DISP,TR_ANTRO.ID_ZONA,TR_ANTRO.ID_CATEGORIA,TR_ANTRO.ID_USUARIO FROM TR_ANTRO";
    public static String trAntroSelectById="SELECT TR_ANTRO.ID_ANTRO,TR_ANTRO.NOMBRE,TR_ANTRO.CALLE,TR_ANTRO.NUMERO,TR_ANTRO.COLONIA,TR_ANTRO.HORARIO,TR_ANTRO.MESAS_DISP,TR_ANTRO.ID_ZONA,TR_ANTRO.ID_CATEGORIA,TR_ANTRO.ID_USUARIO FROM TR_ANTRO WHERE TR_ANTRO.ID_ANTRO = ?";
    public static String trAntroInsert="INSERT INTO TR_ANTRO (NOMBRE,CALLE,NUMERO,COLONIA,HORARIO,MESAS_DISP,ID_ZONA,ID_CATEGORIA,ID_USUARIO) VALUES (?,?,?,?,?,?,?,?,?)";
    public static String trAntroUpdateById="UPDATE TR_ANTRO SET NOMBRE=?,CALLE=?,NUMERO=?,COLONIA=?,HORARIO=?,MESAS_DISP=?,ID_ZONA=?,ID_CATEGORIA=?,ID_USUARIO=? WHERE ID_ANTRO=?";
    public static String trAntroDeleteById="DELETE FROM TR_ANTRO WHERE ID_ANTRO = ?";
    
    //TrNoticias
    public static String trNoticiasSelectAll="SELECT TR_NOTICIAS.ID_NOTICIAS,TR_NOTICIAS.FECHA_CREACION,TR_NOTICIAS.FECHA_INICIO,TR_NOTICIAS.FECHA_FIN,TR_NOTICIAS.DESCRIPCION,TR_NOTICIAS.RUTA_IMAGEN,TR_NOTICIAS.ID_ANTRON FROM TR_NOTICIAS";
    public static String trNoticiasSelectById="SELECT TR_NOTICIAS.ID_NOTICIAS,TR_NOTICIAS.FECHA_CREACION,TR_NOTICIAS.FECHA_INICIO,TR_NOTICIAS.FECHA_FIN,TR_NOTICIAS.DESCRIPCION,TR_NOTICIAS.RUTA_IMAGEN,TR_NOTICIAS.ID_ANTRON FROM TR_NOTICIAS WHERE TR_NOTICIAS.ID_NOTICIAS = ?";
    public static String trNoticiasInsert="INSERTO INTO TR_NOTICIAS (FECHA_CREACION,FECHA_INICIO,FECHA_FIN,DESCRIPCION,RUTA_IMAGEN,ID_ANTRON) VALUES (?,?,?,?,?,?)";
    public static String trNoticiasUpdateById="UPDATE TR_NOTICIAS SET FECHA_CREACION=?,FECHA_INICIO=?,FECHA_FIN=?,DESCRIPCION=?,RUTA_IMAGEN=?,ID_ANTRON=? WHERE ID_NOTICIAS=?";
    public static String trNoticiasDeleteById="DELETE FROM TR_NOTICIAS WHERE ID_NOTICIAS = ?";
    
    //TrReservaciones
    public static String trReservacionesSelectAll="SELECT TR_RESERVACIONES.ID_RESERVACION,TR_RESERVACIONES.FECHA,TR_RESERVACIONES.NUM_MESAS,ID_USUARIOR,TR_RESERVACIONES.ID_ANTROR FROM TR_RESERVACIONES";
    public static String treservacionesSelectById="SELECT TR_RESERVACIONES.ID_RESERVACION,TR_RESERVACIONES.FECHA,TR_RESERVACIONES.NUM_MESAS,ID_USUARIOR,TR_RESERVACIONES.ID_ANTROR FROM TR_RESERVACIONES WHERE TR_RESERVACIONES.ID_RESERVACION = ?";
    public static String trReservacionesInsert="INSERT INTO TR_RESERVACIONES (FECHA,NUM_MESAS,ID_USUARIOR,ID_ANTROR) VALUES (?,?,?,?)";
    public static String trReservacionesUpdateById="UPDATE TR_RESERVACIONES SET FECHA=?,NUM_MESAS=?,ID_USUARIOR=?,ID_ANTROR=? WHERE ID_RESERVACION=?";
    public static String trReservacionesDeleteById="DELETE FROM TR_RESERVACIONES WHERE ID_RESERVACION = ?";
    
    //TrUsuarios
    public static String trUsuariosSelectAll="SELECT TR_USUARIOS.ID_USUARIO,TR_USUARIOS.NOMBRE,TR_USUARIOS.APELLIDO_P,TR_USUARIOS.APELLIDO_M,TR_USUARIOS.FECHA_NAC,TR_USUARIOS.EMAIL,TR_USUARIOS.NOMB_USUARIO,TR_USUARIOS.CONTRASEÑA,TR_USUARIOS.IDTC_TIPOUSUARIO FROM TR_USUARIOS";
    public static String trUsuariosSelectById="SELECT TR_USUARIOS.ID_USUARIO,TR_USUARIOS.NOMBRE,TR_USUARIOS.APELLIDO_P,TR_USUARIOS.APELLIDO_M,TR_USUARIOS.FECHA_NAC,TR_USUARIOS.EMAIL,TR_USUARIOS.NOMB_USUARIO,TR_USUARIOS.CONTRASEÑA,TR_USUARIOS.IDTC_TIPOUSUARIO FROM TR_USUARIOS WHERE TR_USUARIOS.ID_USUARIO = ?";
    public static String trUsuariosInsert="INSERT INTO TR_USUARIOS (NOMBRE, APELLIDO_P, APELLIDO_M, FECHA_NAC, EMAIL, NOMB_USUARIO, CONTRASEÑA, IDTC_TIPOUSUARIO) VALUES (?,?,?,?,?,?,?,?)";
    public static String trUsuariosUpdateById="UPDATE TR_USUARIOS SET NOMBRE=?, APELLIDO_P=?, APELLIDO_M=?, FECHA_NAC=?, EMAIL=?, NOMB_USUARIO=?, CONTRASEÑA=?, IDTC_TIPOUSUARIO=? WHERE ID_USUARIO = ?";
    public static String trUsuariosDeleteById="DELETE FROM TR_USUARIOS WHERE ID_USUARIO = ?";
}
