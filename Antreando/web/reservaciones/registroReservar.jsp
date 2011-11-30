<%-- 
    Document   : bienvenido
    Created on : 3/11/2011, 06:00:03 PM
    Author     : Arizmendi
--%>

<%@page import="mx.com.antreando.dto.TrAntroDto"%>
<%@page import="java.util.Iterator"%>
<%@page import="mx.com.antreando.dto.IBaseDto"%>
<%@page import="java.util.List"%>
<%@page import="mx.com.antreando.dao.TrAntroDao"%>
<%@page import="mx.com.antreando.dao.factory.DaoFactory"%>
<%@page import="mx.com.antreando.dao.TrUsuariosDao"%>
<%@page import="mx.com.antreando.dto.TrUsuariosDto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Antreando</title>
        <script language="JavaScript" type="text/javascript">
          ns4 = (document.layers)? true:false
          ie4 = (document.all)? true:false

          function loadSource(id,nestref, url, parametros) {
            url= url+ parametros;
            if (ns4) {
              var lyr = (nestref)? eval('document.'+nestref+'.document.'+id) : document.layers[id]
              lyr.load(url,lyr.clip.width)
            }
            else
              if (ie4) {
                bufferCapa.document.location = url
              }; // if
          }

          function loadSourceFinish(id) {
            if (ie4) document.all[id].innerHTML = bufferCapa.document.body.innerHTML
          }
          
          var fechaV = /(\d{4})-(?:(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-2])|(0[1-9]|' . '[1-2][0-9]|3[0-2])-(0[1-9]|1[0-2]))/;
          function validarReservacion(fecha,mesas,idAntro){
              if(document.frmRegistroReservar.cmbAntro.value==0){
                  alert("Selecciona establecimiento");
              }else{
                  if(!fechaV.test(document.frmRegistroReservar.txtFecha.value)){
                      alert("Fecha incorrecta");
                  }else{
                      if(document.frmRegistroReservar.txtMesas.value==""){
                          alert("Mesas a reservar");
                      }else{
                          if(document.frmRegistroReservar.txtMesas.value==0){
                              alert("Mesas a reservar");
                          }else{
                              location.href="agregarReservar.jsp?txtFecha="+fecha+"&amp;"+"txtMesas="+mesas+"&amp;"+"idAntro="+idAntro;
                          }
                      }
                  }
              }
              
          }
        </script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../recursos/css/style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="../recursos/css/coin-slider.css" />
<script type="text/javascript" src="../recursos/js/cufon-yui.js"></script>
<script type="text/javascript" src="../recursos/js/droid_sans_400-droid_sans_700.font.js"></script>
<script type="text/javascript" src="../recursos/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="../recursos/js/script.js"></script>
<script type="text/javascript" src="../recursos/js/coin-slider.min.js"></script>
</head>
<body>
<div class="main">
  <div class="header">
    <div class="header_resize">
      <div class="menu_nav">
        <ul>
          <li class="active"><a href="index.html"><span>Home</span></a></li>
          <li><a href="#"><span>¿Quienes somos?</span></a></li>

          <li><a href="contact.html"><span>Contacto</span></a></li>
        </ul>
      </div>
      <div class="logo">
        <h1><a href="index.html">   <span>    </span> <small>¡VETE DE ANTRO!</small></a></h1>
      </div>
      <div class="clr"></div>
      <div class="slider">
          <div id="coin-slider"> <a href="#"><img src="../recursos/images/slide1.jpg" width="940" height="310" alt="" /> </a> <a href="#"><img src="../recursos/images/slide2.jpg" width="940" height="310" alt="" /> </a> <a href="#"><img src="../recursos/images/slide3.jpg" width="940" height="310" alt="" /> </a> </div>
        <div class="clr"></div>
      </div>
      <div class="clr"></div>
    </div>
  </div>
  <div class="content">
    <div class="content_resize">
      <div class="mainbar">
          
        <div class="article">
        <form name="frmRegistroReservar">
            <IFRAME STYLE="display:none" NAME="bufferCapa"></IFRAME>
            <%
            session.getAttribute("idUsuario");
            TrAntroDao antroDao = (TrAntroDao)DaoFactory.getDao("tr_antro");
            List<IBaseDto> lista = antroDao.selectAll();
            %>
        <table>
            <tr>
                <th colspan="2">
                    Bienvenido usuario: <%= session.getAttribute("usuario") %>
                </th>
            </tr>
                <tr>
                    <td>
                        Antro
                    </td>
                    <td>
                        <select name="cmbAntro">
                            <option value="0">-Selecciona-</option>
                            <%
                            for(Iterator i=lista.listIterator(); i.hasNext();){
                                TrAntroDto antroDto = (TrAntroDto)i.next();
                            %>
                            <option value="<%=antroDto.getIdAntro()%>"><%=antroDto.getNombre()%></option>
                            <% } %>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        Fecha
                    </td>
                    <td>
                        <input type="text" name="txtFecha"></input>(AAAA-MM-DD)
                    </td>
                </tr>
                <tr>
                    <td>
                        Cantidad de mesas
                    </td>
                    <td>
                        <input type="text" name="txtMesas" value="1" enabled="false"></input>
                    </td>
                </tr>
                <tr>
                    <th colspan="2">
                        <input type="button" name="btnAceptar" value="Aceptar" onclick="validarReservacion(document.frmRegistroReservar.txtFecha.value, document.frmRegistroReservar.txtMesas.value, document.frmRegistroReservar.cmbAntro.value);"></input>
                    </th>
                </tr>
        </table>    
    </form>
        </div>	
      </div>
      <div class="sidebar">
        <div class="gadget">
          <h2 class="star"><span></span>Menu</h2>
          <div class="clr"></div>
          <ul class="sb_menu">
            <li><a href="../index.html">Home</a></li>
            <li><a href="../index.html">Cerrar sesi&oacute;n</a></li>
            <li><a href="reservaciones/registroReservar.jsp">Reservar</a></li>
            <li><a href="#">Blog</a></li>
          </ul>
          <h2 class="star"><span></span>Conocenos</h2>
            <ul class="sb_menu">
            <li><a href="#">Quiénes somos</a></li>
            <li><a href="#">Misión y visión</a></li>
            <li><a href="#">Políticas</a></li>
            <li><a href="#">Valores</a></li>
          </ul>
        </div>
      </div>
	  
	  

	  
      <div class="clr"></div>
    </div>
  </div>
 
 
 
 
  <div class="footer">
    <div class="footer_resize">
      <p class="lf">&copy; Copyright <a href="#">Equipo 1</a>.</p>
      <p class="rf">Design by Team 1 <a href="http://www.dreamtemplate.com/">Vamonos de antro...</a></p>
      <div style="clear:both;"></div>
    </div>
  </div>
</div>
</body>
</html>