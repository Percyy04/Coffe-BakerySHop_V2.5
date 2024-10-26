<%-- 
    Document   : Dashboard
    Created on : Sep 25, 2024, 1:47:53 PM
    Author     : Tam Peo
--%>

<%@page import="dto.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Account user = (Account) session.getAttribute("loginUser");
        %>
        <h2>
            <% if (user != null) {
                    out.print("Welcome " + user.getFullname() + " comeback");
                } else {
                    request.setAttribute("ERROR", "invalid login");
                    request.getRequestDispatcher("loginpage.jsp").forward(request, response);
                }
            %>
        </h2>
        <h1>Dashboard</h1>
        <p><a href='GetItemServlet_M'>Manage Items</p>
    </body>
</html>
