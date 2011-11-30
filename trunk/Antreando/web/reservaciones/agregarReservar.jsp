<%-- 
    Document   : agregarReservar
    Created on : 16/11/2011, 06:14:20 PM
    Author     : Arizmendi
--%>

<%@page import="mx.com.antreando.dao.factory.DaoFactory"%>
<%@page import="mx.com.antreando.dao.TrReservacionesDao"%>
<%@page import="mx.com.antreando.dto.TrReservacionesDto"%>
<%@page import="java.sql.Date"%>
<%@page import="mx.com.antreando.dao.general.DaoGeneral"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
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
        String fechaR = request.getParameter("txtFecha");
        Integer mesasR = Integer.parseInt(request.getParameter("txtMesas"));
        Integer idAntroR = Integer.parseInt(request.getParameter("idAntro"));
        Integer idUsuarioR = (Integer)session.getAttribute("idUsuario");
        }catch(Exception ex){
        %>
        <script> alert("Error al realizar reservación"); location.href="registroReservar.jsp"; </script>
        <% } %>
        <%
        //SELECT SUM(R.NUM_MESAS)
        //FROM TR_RESERVACIONES R
        //WHERE ID_ANTROR=3
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        int cantidadActualMesas=0;
        int cantidadMesasAntro=0;
        //AQUI VAMOS A SACAR EL NUMERO DE MESAS QUE YA ESTAN OCUPADAS EN EL DIA SELECCIONADO Y EL ANTRO SELECCIONADO PREVIAMENTE
        try{
            String fechaR = request.getParameter("txtFecha");
            Integer mesasR = Integer.parseInt(request.getParameter("txtMesas"));
            Integer idAntroR = Integer.parseInt(request.getParameter("idAntro"));
            Integer idUsuarioR = (Integer)session.getAttribute("idUsuario");
            con = DaoGeneral.createConnection();
            ps = con.prepareStatement("SELECT SUM(R.NUM_MESAS) FROM TR_RESERVACIONES R WHERE ID_ANTROR=? AND FECHA=?");
            ps.setInt(1,idAntroR);
            ps.setDate(2,Date.valueOf(fechaR));
            rs = ps.executeQuery();
            while(rs.next()){
                cantidadActualMesas = rs.getInt(1);
            }
            System.out.println(cantidadActualMesas);
        }catch(Exception e){
            %>
            <script> alert("Error"); location.href="../bienvenido.jsp" </script>
            <%
        }
        finally{
            DaoGeneral.closeConnection(con, ps, rs);
        }
        //**AQUI VAMOS A SACAR EL NUMERO DE MESAS DISPONIBLES DEL ANTRO
        try{
            Integer idAntroR = Integer.parseInt(request.getParameter("idAntro"));
            con = DaoGeneral.createConnection();
            ps = con.prepareStatement("SELECT MESAS_DISP FROM TR_ANTRO WHERE ID_ANTRO=?");
            ps.setInt(1,idAntroR);
            rs = ps.executeQuery();
            while(rs.next()){
                cantidadMesasAntro = rs.getInt(1);
            }
            System.out.println(cantidadMesasAntro);
        }catch(Exception e){
            %>
            <script> alert("Error"); location.href="../bienvenido.jsp" </script>
            <%
        }
        finally{
            DaoGeneral.closeConnection(con, ps, rs);
        }
        //EMPEZAMOS LA VALIDACION DE LA RESERVACION!!!!!!
        String fechaR = request.getParameter("txtFecha");
        Integer mesasR = Integer.parseInt(request.getParameter("txtMesas"));
        Integer idAntroR = Integer.parseInt(request.getParameter("idAntro"));
        Integer idUsuarioR = (Integer)session.getAttribute("idUsuario");
        if( (mesasR+cantidadActualMesas)<cantidadMesasAntro ){
        //agregas    
            TrReservacionesDto reservaDto = new TrReservacionesDto();
            reservaDto.setFecha(Date.valueOf(fechaR));
            reservaDto.setNumMesas(mesasR);
            reservaDto.setIdUsuarioR(idUsuarioR);
            reservaDto.setIdAntroR(idAntroR);
            TrReservacionesDao reservaDao = (TrReservacionesDao)DaoFactory.getDao("tr_reservaciones");
            int éxito = reservaDao.insert(reservaDto);
            if(éxito==1){ %>
            <script> alert("Reservación exitosa"); location.href="../bienvenido.jsp"; </script>
           <% }else{System.out.println("Error");}
        }
               else{
        %>
        <script> alert("La cantidad de mesas no se puede reservar,\n intente con una menor cantidad"); location.href="registroReservar.jsp"; </script>
        <% } %>
        
    </body>
</html>
