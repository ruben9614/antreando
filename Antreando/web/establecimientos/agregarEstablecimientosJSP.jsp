<%-- 
    Document   : agregarEstablecimientosJSP
    Created on : 14/11/2011, 10:44:57 PM
    Author     : Arizmendi
--%>

<%@page import="mx.com.antreando.dto.TrUsuariosDto"%>
<%@page import="mx.com.antreando.dao.TrUsuariosDao"%>
<%@page import="org.apache.catalina.ssi.SSICommand"%>
<%@page import="mx.com.antreando.dao.factory.DaoFactory"%>
<%@page import="mx.com.antreando.dto.TrAntroDto"%>
<%@page import="mx.com.antreando.dao.TrAntroDao"%>
<%@page import="com.sun.java.swing.plaf.windows.resources.windows"%>
<%@page import="com.sun.java.swing.plaf.windows.resources.windows"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        try{
        //Integer idZona= Integer.parseInt(request.getParameter("idZona"));
        //Integer idCategoria = Integer.parseInt(request.getParameter("idCategoria"));
        String nombre = request.getParameter("txtNombre");
        //System.out.println(idZona);
        //System.out.println(idCategoria);
        System.out.println(nombre);
        System.out.println(request.getParameter("txtCalle"));
        System.out.println(request.getParameter("txtNumero"));
        System.out.println(request.getParameter("txtColonia"));
        System.out.println(request.getParameter("txtHorario"));
        System.out.println(request.getParameter("txtMesas"));
        
        TrAntroDto antroDto = new TrAntroDto();
        antroDto.setNombre(request.getParameter("txtNombre"));
        antroDto.setCalle(request.getParameter("txtCalle"));
        antroDto.setNumero(Integer.parseInt(request.getParameter("txtNumero")));
        antroDto.setColonia(request.getParameter("txtColonia"));
        antroDto.setHorario(request.getParameter("txtHorario"));
        antroDto.setMesasDisp(Integer.parseInt(request.getParameter("txtMesas")));
        antroDto.setIdZona(Integer.parseInt(request.getParameter("idZona")));
        antroDto.setIdCategoria(Integer.parseInt(request.getParameter("idCategoria")));
        antroDto.setIdUsuario((Integer)(session.getAttribute("idUsuario")));
        TrAntroDao antroDao = (TrAntroDao)DaoFactory.getDao("tr_antro");
        int éxito = antroDao.insert(antroDto);
        if(éxito == 1){
        %>
        <script> alert("Establecimiento agregado"); location.href="../bienvenidoDuenio.jsp"; </script>
        <% }else{
                   }    
               }catch(Exception ex){
         %>
         <script> alert("Error al agregar establecimiento"); location.href="../bienvenidoDuenio.jsp"; </script>
         <% } %>
    </body>
</html>
