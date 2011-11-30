<%-- 
    Document   : agregarCategoriaJSP
    Created on : 14/11/2011, 07:51:10 PM
    Author     : Arizmendi
--%>

<%@page import="mx.com.antreando.dao.factory.DaoFactory"%>
<%@page import="mx.com.antreando.dao.TcCategoriaDao"%>
<%@page import="mx.com.antreando.dto.TcCategoriaDto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        TcCategoriaDto categoriaDto = new TcCategoriaDto();
        categoriaDto.setDescripcion(request.getParameter("txtCategoria"));
        TcCategoriaDao categoriaDao = (TcCategoriaDao)DaoFactory.getDao("tc_categoria");
        int éxito = categoriaDao.insert(categoriaDto);
        if(éxito==1){
        %>
        <script> alert("Categoría agregada"); location.href="../bienvenidoAdmin.jsp"; </script>
        <%
          }else{
            %>
        <script> alert("Error al agregar categoría"); location.href="../bienvenidoAdmin.jsp"; </script>    
            <% } %>
    </body>
</html>
