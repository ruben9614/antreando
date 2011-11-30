<%-- 
    Document   : bienvenido
    Created on : 3/11/2011, 06:00:03 PM
    Author     : Arizmendi
--%>

<%@page import="mx.com.antreando.dto.TcCategoriaDto"%>
<%@page import="mx.com.antreando.dao.TcCategoriaDao"%>
<%@page import="mx.com.antreando.dao.TcZonaDao"%>
<%@page import="mx.com.antreando.dto.TcZonaDto"%>
<%@page import="java.util.Iterator"%>
<%@page import="mx.com.antreando.dto.IBaseDto"%>
<%@page import="java.util.List"%>
<%@page import="mx.com.antreando.dao.factory.DaoFactory"%>
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
          
          function agregarEstablecimiento(nombre,calle,numero,colonia,horario,mesas,idZona,idCategoria){
              if(document.frmAgregarEstablecimiento.txtNombre.value == ""){
                  alert("Nombre");
              }
              else{
                  if(document.frmAgregarEstablecimiento.txtCalle.value == ""){
                      alert("Calle");
                  }else{
                      if(document.frmAgregarEstablecimiento.txtNumero.value == ""){
                          alert("Número");
                      }else{
                          if(document.frmAgregarEstablecimiento.txtColonia.value == ""){
                              alert("Colónia");
                          }else{
                              if(document.frmAgregarEstablecimiento.txtHorario.value == ""){
                                  alert("Horario");
                              }else{
                                  if(document.frmAgregarEstablecimiento.txtMesas.value == ""){
                                      alert("Mesas");
                                  }else{
                                      if(document.frmAgregarEstablecimiento.cmbZona.value == 0){
                                          alert("Zóna");
                                      }else{
                                          if(document.frmAgregarEstablecimiento.cmbCategoria.value == 0){
                                              alert("Categoría");
                                          }else{
                                              window.location='establecimientos/agregarEstablecimientosJSP.jsp?txtNombre='+nombre+"&amp;"+'txtCalle='+calle+"&amp;"+'txtNumero='+numero+"&amp;"+'txtColonia='+colonia+"&amp;"+'txtHorario='+horario+"&amp;"+'txtMesas='+mesas+"&amp;"+'idZona='+idZona+"&amp;"+'idCategoria='+idCategoria;
                                          }
                                      }
                                  }
                              }
                              
                          }
                      }
                  }
              }
              
          }
        </script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="recursos/css/style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="recursos/css/coin-slider.css" />
<script type="text/javascript" src="recursos/js/cufon-yui.js"></script>
<script type="text/javascript" src="recursos/js/droid_sans_400-droid_sans_700.font.js"></script>
<script type="text/javascript" src="recursos/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="recursos/js/script.js"></script>
<script type="text/javascript" src="recursos/js/coin-slider.min.js"></script>
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
          <div id="coin-slider"> <a href="#"><img src="recursos/images/slide1.jpg" width="940" height="310" alt="" /> </a> <a href="#"><img src="recursos/images/slide2.jpg" width="940" height="310" alt="" /> </a> <a href="#"><img src="recursos/images/slide3.jpg" width="940" height="310" alt="" /> </a> </div>
        <div class="clr"></div>
      </div>
      <div class="clr"></div>
    </div>
  </div>
  <div class="content">
    <div class="content_resize">
      <div class="mainbar">
          
        <div class="article">
            <form name="frmAgregarEstablecimiento" action="establecimientos/agregarEstablecimientosJSP.jsp" method="POST">
            <%
            HttpSession sesión = request.getSession();
            session.getAttribute("idUsuario");
            //Integer idUsuario = (Integer)session.getAttribute("idUsuario");
            TcZonaDao zonaDao = (TcZonaDao)DaoFactory.getDao("tc_zona");
            List<IBaseDto> lista = zonaDao.selectAll();
            TcCategoriaDao categoriaDao = (TcCategoriaDao)DaoFactory.getDao("tc_categoria");
            List<IBaseDto> listaCategorias = categoriaDao.selectAll();
            %>
            <IFRAME STYLE="display:none" NAME="bufferCapa"></IFRAME>
        <table>
            <tr>
                <th colspan="2">
                    Bienvenido due&ntilde;o <%= session.getAttribute("usuario") %>
                </th>
            </tr>
                <tr>
                    <td>
                        Nombre
                    </td>
                    <td>
                        <input type="text" name="txtNombre"></input>
                    </td>
                </tr>
                <tr>
                    <td>
                        Calle
                    </td>
                    <td>
                        <input type="text" name="txtCalle"></input>
                    </td>
                </tr>
                <tr>
                    <td>
                        N&uacute;mero
                    </td>
                    <td>
                        <input type="text" name="txtNumero"></input>
                    </td>
                </tr>
                <tr>
                    <td>
                        Colonia
                    </td>
                    <td>
                        <input type="text" name="txtColonia"></input>
                    </td>
                </tr>
                <tr>
                    <td>
                        Horario
                    </td>
                    <td>
                        <input type="text" name="txtHorario"></input>
                    </td>
                </tr>
                <tr>
                    <td>
                        Mesas disponibles
                    </td>
                    <td>
                        <input type="text" name="txtMesas"></input>
                    </td>
                </tr>
                <tr>
                    <td>
                        Z&oacute;na
                    </td>
                    <td>
                    <select name="cmbZona">
                        <option value="0">-Selecciona-</option>
                        <%
                        for(Iterator iterador = lista.listIterator(); iterador.hasNext(); ){
                        TcZonaDto zonaDto = (TcZonaDto)iterador.next();
                        %>
                        <option value="<%=zonaDto.getIdZona()%>"><%=zonaDto.getDescripcion()%></option>
                        <% } %>
                    </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        Categor&iacute;a
                    </td>
                    <td>
                        <select name="cmbCategoria">
                            <option value="0">-Selecciona-</option>
                            <%
                            for(Iterator iterador2 = listaCategorias.listIterator(); iterador2.hasNext(); ){
                            TcCategoriaDto categoriaDto = (TcCategoriaDto)iterador2.next();
                            %>
                            <option value="<%=categoriaDto.getIdCategoria()%>"><%=categoriaDto.getDescripcion()%></option>
                            <% } %>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="button" name="btnAceptar" value="Aceptar" onclick="agregarEstablecimiento(document.frmAgregarEstablecimiento.txtNombre.value,document.frmAgregarEstablecimiento.txtCalle.value,document.frmAgregarEstablecimiento.txtNumero.value,document.frmAgregarEstablecimiento.txtColonia.value,document.frmAgregarEstablecimiento.txtHorario.value,document.frmAgregarEstablecimiento.txtMesas.value,document.frmAgregarEstablecimiento.cmbZona.value, document.frmAgregarEstablecimiento.cmbCategoria.value);"></input>
                    </td>
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
            <li><a href="index.html">Home</a></li>
            <li><a href="index.html">Cerrar sesion</a></li>
            <li><a href="agregarEstablecimiento.jsp">Agregar establecimiento</a></li>
            <li><a href="#">Ver reservaciones</a></li>
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