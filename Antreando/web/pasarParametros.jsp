<html>

<body>
    <h3> Hola <%=request.getParameter("seleccion") %> tu eres un <%=request.getParameter("seleccionPro") %> </h3>
    
    <% 
    String[] items = request.getParameterValues("numbers");
    for(int i = 0; i < items.length; i++)
    {
        out.println(items[i] + "<BR>");
    }
    %>
</body>
</html>