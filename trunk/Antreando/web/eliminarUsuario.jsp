<%-- 
    Document   : eliminarUsuario
    Created on : 13/11/2011, 09:45:40 PM
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
    </head>
    <body>
        <%
        Integer idUser = Integer.parseInt(request.getParameter("idUsr"));
        TrUsuariosDao usuarioDao = (TrUsuariosDao)DaoFactory.getDao("tr_usuarios");
        int éxito = usuarioDao.deleteById(idUser);
        if(éxito == 0){
        %>
        <script> alert("Error al borrar usuario"); location.href="usuariosRegistrados.jsp"; </script>
        <% }else{ %>
        <script> alert("Usuario borrado"); location.href="usuariosRegistrados.jsp" </script>
        <% } %>
    </body>
</html>
