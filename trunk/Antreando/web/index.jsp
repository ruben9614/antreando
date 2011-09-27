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
    </head>
    <body>
    <center>
        
        <form name="frmAcceso" onsubmit="return validaVacios();" action="paginas/login.jsp" method="post">
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
                        <input type="text" name="usr">
                    </td>
                </tr>
                <tr>
                    <th>
                        Contraseña:
                    </th>
                    <td>
                        <input type="password" name="pwd">
                    </td>
                </tr>
                <tr>
                    <th>
                        
                    </th>
                    <td colspan="2">
                        <input type="submit" name="btnAceptar" value="Enviar" onclick="validaVacios()">
                    </td>
                </tr>
            </table>
        </form>
        
        <script>
            function validaVacios(){
                if(document.frmAcceso.usr.value.lenght==0){
                    alert("Llenar usuario")
                    return 0;
                }
                if(document.frmAcceso.pwd.value.lenght==0){
                    alert("Llenar contraseña")
                    return 0;
                }
                
                document.frmAcceso.submit();
            }
        </script>
        
    </center> 
    </body>
</html>
