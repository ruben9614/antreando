<%-- 
    Document   : bienvenido
    Created on : 21/09/2011, 08:38:00 AM
    Author     : Arizmendi
--%>

<%@page import="mx.com.antreando.dao.factory.DaoFactory"%>
<%@page import="mx.com.antreando.dao.TrUsuariosDao"%>
<%@page import="mx.com.antreando.dto.TrUsuariosDto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script language="JavaScript" type="text/javascript">
            function validarUsuario(){
                alert("No identificado");
                location.href="../index.jsp";
            }
        </script>
    </head>
    <body>
        <%
        String user = request.getParameter("usr");
        String pass = request.getParameter("pwd");
        TrUsuariosDto usuarioDto = new TrUsuariosDto();
        usuarioDto.setNombUsuario(user);
        usuarioDto.setContraseña(pass);
        TrUsuariosDao usuarioDao = new TrUsuariosDao();
        usuarioDto = (TrUsuariosDto)usuarioDao.selectLogin(usuarioDto);
        if(usuarioDto != null){
        %>
        <table>
            <tr>
                <td>
                    Bienvenido
                </td>
            </tr>
            <tr>
                <td>
                    <%= user %>
                </td>
            </tr>
        </table>
        <%
         }else{
            %>
            <script>
                validarUsuario();
            </script>
         <% } %>
        
        
        
        
        
    </body>
</html>
