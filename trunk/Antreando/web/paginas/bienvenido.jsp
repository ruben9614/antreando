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
    <form name="frmBienvenido">
        <%
        String user = request.getParameter("usr");
        String pass = request.getParameter("pwd");
        TrUsuariosDto usuarioDto = new TrUsuariosDto();
        usuarioDto.setNombUsuario(user);
        usuarioDto.setContraseña(pass);
        TrUsuariosDao usuarioDao = (TrUsuariosDao)DaoFactory.getDao("tr_usuarios");
        usuarioDto = (TrUsuariosDto)usuarioDao.selectLogin(usuarioDto);
        if(usuarioDto != null){
        %>
        <table>
            <tr>
                <th colspan="2">
                    Bienvenido <%= user %>
                </th>
            </tr>
            <tr>
                <td>
                    Opciones usuarios:
                </td>
                <td>
                    <select name="cmbOpciones" id="cmbOpciones" onchange="">
                        <option value="0">-Seleccione-</option>
                        <option value="1">Alta</option>
                        <option value="2">Baja</option>
                        <option value="3">Cambio</option>
                    </select>
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
    
    </form>
    </body>
</html>
