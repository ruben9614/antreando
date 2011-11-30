//GEN-BEGIN:Client
/**
 * This file is generated. Please do not change
 */
package agregarServicios;

import java.io.*;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * Invocation Gateways
 */
public class JavonGateways {

    /**
     *  This class implements the application server connectivity specific to the needs.
     *  loginPhone.LoginPhone
     */
    public static class agregarServicios_LoginPhoneinsert1Gateway implements InvocationAbstraction {

        /**
         *  This method performs the actual invocation of server functionality. It is
         *  used by the servlet to delegate functionality to external classes.
         *
         * @param input The stream from which we should read the parameters for the methods
         * @return The return value for the method NULL IS NOT SUPPORTED!!!!
         * @throws Exception  Thrown when a protocol error occurs
         */
        public Object invoke(HttpSession session, DataInput input) throws Exception {
            String nombreX = (String) Utility.readObject(input);
            String appX = (String) Utility.readObject(input);
            String apmX = (String) Utility.readObject(input);
            String emailX = (String) Utility.readObject(input);
            String usrX = (String) Utility.readObject(input);
            String pwdX = (String) Utility.readObject(input);

            loginPhone.LoginPhone instance = (loginPhone.LoginPhone) session.getAttribute("loginPhone.LoginPhone");
            if (instance == null) {
                instance = (loginPhone.LoginPhone) Class.forName("loginPhone.LoginPhone").newInstance();
                session.setAttribute("loginPhone.LoginPhone", instance);
            }
            return new Integer(instance.insert(nombreX, appX, apmX, emailX, usrX, pwdX));
        }

        public int[] getIds() {
            return new int[]{
                        5,
                        5,
                        5,
                        5,
                        5,
                        5
                    };
        }

        ;

        public int[] getReturnIds() {
            return new int[]{
                        2
                    };
        }
    ;

    }

    private static Object readObject(DataInput in) throws IOException {
        return Utility.readObject(in);
    }
}
//GEN-END:Client
