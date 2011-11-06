<%-- 
    Document   : capaOpciones
    Created on : 3/11/2011, 06:21:41 PM
    Author     : Arizmendi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script language="JavaScript" type="text/javascript">
            function validarAgregar(){
                if(document.frmBienvenido.cmbOpciones.value == 1){
                    alert('vas a agregar usuario');
                }
            }
        </script>
    </head>
    <body onload="parent.loadSourceFinish('capaOpciones');">
    <% 
    int dato = 0;
    String opcion = request.getParameter("dato");
    dato = Integer.parseInt(opcion);
    if(dato == 1){
    %>
       <table>
        <tr></tr>

        <tr>
            <th colspan="3"> Datos Generales </th>
        </tr>

        <tr>
            <td> Nombre </td>
            <td> <input type="text"> </td>
        </tr>

        <tr>
            <td> Apellido Paterno </td>
            <td> <input type="text"> </td>
        </tr>

        <tr>
            <td> Apellido Materno </td>
            <td> <input type="text"> </td>
        </tr>

        <tr>
            <td> Fecha de Nacimiento </td>
            <td> <input type="text"> </td>
        </tr>

        <tr>
            <td> Email </td>
            <td> <input type="text"> </td>
        </tr>

        <tr>
            <td> Nombre de usuario </td>
            <td> <input type="text"> </td>
        </tr>

        <tr>
            <td> Contraseña </td>
            <td> <input type="text"> </td>
        </tr>

        <tr>
            <td> Confirmar Contraseña</td>
            <td> <input type="text"> </td>
        </tr>

        <tr>
            <td> Tipo de usuario </td>
        <td>
            <select name="cmbOpciones" id="cmbOpciones">
                <option value="0">-Seleccione-</option>
                <option value="1">Administrador</option>
                <option value="2">Dueño Antro</option>
            </select>
        </td>   
        </tr>
        <tr>
            <td> <input type="button" name="btnRegistrar" value="Registrar" onclick="validarAgregar();"> </td>
        </tr>
            <% 
            }
            if(dato == 2){
            %>
        <tr>
            <th colspan="2"> Teclee el num de usuario a borrar </th>
        </tr>

        <tr>
        <td> Num del empleado </td>
        <td> <input type="text"> </td>
        </tr>

        <tr>
        <td> <input type="button" name="btnBorrar" value="Eliminar"> </td>
        </tr>

            <% 
            }
            if(dato == 3){
            %>

        <tr>
        <th colspan="3"> Teclee el num del empleado para cambiar datos </th>
        </tr>

        <tr>
        <td> Numero de Empleado  <input type="text"> </td>
        </tr>

        <tr>
            <th colspan="2"> 
                <input type="button" name="btnBuscar" value="Buscar" onclick=""></input> 
            </th>
        </tr>
            <% 
            }
            %>

        </table>
    </body>
</html>
