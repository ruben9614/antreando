<%-- 
    Document   : index
    Created on : 7/09/2011, 07:55:27 PM
    Author     : Arizmendi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        
        <script language="JavaScript" type="text/javascript">
            function validaVacios(){
                if(document.frmAcceso.usr.value != null || document.frmAcceso.pwd.value != null){
                    document.frmAcceso.submit();
                }else{
                    alert("Llenar usuario");
                }
            }
        </script>
    </head>
    <body>
    <center>
        <form name="frmAcceso" action="paginas/bienvenido.jsp">
            <table>
                <tr>
                    <th colspan="2">
                        Acceso:
                    </th>
                </tr>
                <tr>
                    <th>
                        Usuario:
                    </th>
                    <td>
                        <input type="text" name="usr" id="usr">
                    </td>
                </tr>
                <tr>
                    <th>
                        Contraseña:
                    </th>
                    <td>
                        <input type="password" name="pwd" id="pwd">
                    </td>
                </tr>
                <tr>
                    <th>
                        
                    </th>
                    <td colspan="2">
                        <input type="button" name="btnAceptar" value="Entrar" onclick="validaVacios();">
                    </td>
                </tr>
            </table>
        </form>
    </center> 
    </body>
</html>
