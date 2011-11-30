<%-- 
    Document   : agregarUsuarioComun
    Created on : 3/11/2011, 07:15:14 PM
    Author     : Arizmendi
--%>

<%@page import="java.sql.Date"%>
<%@page import="mx.com.antreando.dao.factory.DaoFactory"%>
<%@page import="mx.com.antreando.dao.TrUsuariosDao"%>
<%@page import="mx.com.antreando.dto.TrUsuariosDto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alta usuarios</title>
        <script language="JavaScript" type="text/javascript">
            function usuarioEncontrado(){
                alert("Usuario agregado con éxito")
                location.href="../bienvenidoAdmin.jsp";
            }
        </script>
    </head>
    <body>
        <%
        try{
        TrUsuariosDto usuarioDto = new TrUsuariosDto();
        usuarioDto.setNombre(request.getParameter("txtNombre"));
        usuarioDto.setApellidoP(request.getParameter("txtApp"));
        usuarioDto.setApellidoM(request.getParameter("txtApm"));
        usuarioDto.setFechaNac(Date.valueOf(request.getParameter("txtFechaNac")));
        usuarioDto.setEmail(request.getParameter("txtEmail"));
        usuarioDto.setNombUsuario(request.getParameter("txtUsuario"));
        usuarioDto.setContraseña(request.getParameter("txtContra1"));
        usuarioDto.setIdTipoUsuario(2);
        TrUsuariosDao usuarioDao = (TrUsuariosDao)DaoFactory.getDao("tr_usuarios");
        int exito = usuarioDao.insert(usuarioDto);
        if(exito==1){
        %>
        <script>usuarioEncontrado();</script>
        <% }
           else{
               System.out.println("Error");
               }
         }catch(Exception ex){
        %>
        <script> alert("Error a agregar usuario"); location.href="../bienvenidoAdmin.jsp";</script>
        <% } %>
    </body>
</html>

