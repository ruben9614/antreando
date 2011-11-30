<%-- 
    Document   : agregarZonaJSP
    Created on : 14/11/2011, 07:50:39 PM
    Author     : Arizmendi
--%>

<%@page import="mx.com.antreando.dao.factory.DaoFactory"%>
<%@page import="mx.com.antreando.dao.TcZonaDao"%>
<%@page import="mx.com.antreando.dto.TcZonaDto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        TcZonaDto zonaDto = new TcZonaDto();
        zonaDto.setDescripcion(request.getParameter("txtZona"));
        TcZonaDao zonaDao = (TcZonaDao)DaoFactory.getDao("tc_zona");
        int éxito = zonaDao.insert(zonaDto);
        if(éxito==1){
        %>
        <script> alert("Zona agregada"); location.href="../bienvenidoAdmin.jsp"; </script>
        <%
               }else{
            %>
        <script> alert("Error al agregar zona"); location.href="../bienvenidoAdmin.jsp"; </script>    
            <% } %>
    </body>
</html>
