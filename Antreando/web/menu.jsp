<html>
<head>
<title> Prueba combobox </title> 
</head>
<body>
<center>
    
Selecciona:
	<form name="formulario1" method="post" action="pasarParametros.jsp">
            Nombre:
		<select name="seleccion">
			<option value="0">-Seleccionar-
			<option value="Ruben Hernandez"> Ruben Hernandez
			<option value="Laura Amador"> Laura Amador
			<option value="Martin Ortiz"> Martin Ortiz
		</select>
		<br><br>
                Ocupación:
		<select name="seleccionPro">
			<option value="0">-Seleccionar-
			<option value="Alumno"> Alumno
			<option value="Docente"> Docente
		</select>
		<br><br>
                
                <select name='numbers' multiple='multiple'>
                    <option value='1'>One</option> 
                    <option value='2'>Two</option> 
                    <option value='3'>Three</option> 
                    <option value='4'>Four</option> 
                    <option value='5'>Five</option> 
                </select>
                <br><br>
                <select name="combo">
                    <%
                        for(int i=1; i<=10; i++){
                    %>
                    <option value="<%=i%>"><%=i%></option>
                    <%
                                       }
                    %>
                </select>
                <br><br>                
		<input type="button" id="Envia" onclick="document.formulario1.submit();" value="Aceptar">
                
	</form>
</center>
</body>
</html>