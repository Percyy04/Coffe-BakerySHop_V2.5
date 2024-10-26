<%-- 
    Document   : loginpage
    Created on : Sep 25, 2024, 2:15:16 PM
    Author     : Tam Peo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="LoginServlet" method="post">
            <input type="text" name="txtemail"/>
            </br>
            <input type="password" name="txtpassword"/>
            </br>
            <input type="submit" value="login"/>
        </form>
        <p><%
                String msg = (String)request.getAttribute("ERROR");
                if(msg != null){
                    out.print(msg);
                }
            %>
        </p>
    </body>
</html>
