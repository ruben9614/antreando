/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.antreando.dao.factory;


import java.util.ListResourceBundle;
import java.util.ResourceBundle;
import mx.com.antreando.dao.IBaseDao;

/**
 *
 * @author Arizmendi
 */
public class DaoFactory {
    
        public static IBaseDao getDao(String tabla){
        try{
        Class clase = Class.forName(getClase(tabla));
        return (IBaseDao)clase.newInstance();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
    private static String getClase(String llave){
        String definicion=null;
        try{
            ResourceBundle datos = ListResourceBundle.getBundle("origenDao");
            definicion=datos.getString(llave);
        }catch(Exception e){
            e.printStackTrace();
        }
        return definicion;
    }
    
    
}
