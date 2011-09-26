<%-- 
    Document   : login
    Created on : 20/09/2011, 07:09:13 PM
    Author     : Arizmendi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="java.sql.*" %>
<%@ page language="java" import="java.sql.*" errorPage="" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Connection conn = null;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/antreando","root", "toor");

            ResultSet rsdoLogin = null;
            PreparedStatement psdoLogin=null;

            String sUser=request.getParameter("usr");
            String sPassword=request.getParameter("pwd");
            String message="User login successfully ";
            String pagina = "index.jsp";

            try{
            String sqlOption="SELECT * FROM Tr_Usuarios where"
                            +" nomb_usuario=? and contraseña=?";

            psdoLogin=conn.prepareStatement(sqlOption);
            psdoLogin.setString(1,sUser);
            psdoLogin.setString(2,sPassword);

            rsdoLogin=psdoLogin.executeQuery();

            if(rsdoLogin.next())
            {
              String sUserName=rsdoLogin.getString("nombre")+" "+rsdoLogin.getString("apellido_p");

              //session.setAttribute("sUser",rsdoLogin.getString("sUser"));
              //session.setAttribute("iUserType",rsdoLogin.getString("iUserType"));
              //session.setAttribute("iUserLevel",rsdoLogin.getString("iUserLevel"));
              //session.setAttribute("sUserName",sUserName);
              pagina = "bienvenido.jsp";
              response.sendRedirect("bienvenido.jsp?error="+message);
            }
            else
            {
              message="No user or password matched" ;
              response.sendRedirect("login.jsp?error="+message);
            }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }


            /// close object and connection
            try{
                 if(psdoLogin!=null){
                     psdoLogin.close();
                 }
                 if(rsdoLogin!=null){
                     rsdoLogin.close();
                 }

                 if(conn!=null){
                  conn.close();
                 }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }

        %>

        <!--<form name="reenvio" action="<%=pagina%>" method="post"></form> -->
        
    </body>
</html>
