<%-- 
    Document   : ViewCart
    Created on : Oct 2, 2024, 12:56:04 PM
    Author     : Tam Peo
--%>

<%@page import="java.util.HashMap"%>
<%@page import="dto.Item"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
            function warning(){
                var ans = window.confirm("Are you sure?");
                if(ans) return true;
                return false;
            }
        </script>
    </head>
    <body>
        <p><a href="Home.jsp">HOME | 
                <a href="loginpage.jsp">LOGIN</a></p>
        <a href="ViewCart.jsp">View Cart</a>
        <form action="SearchServlet">
            <input type="text" name="txtsearch" value="<%= (request.getParameter("msg")) != null ? (request.getParameter("msg")) : ""%>"/>
            <input type="submit" value="Go"/>
        </form>
    </p>

    //lay cart from session
    <%
        HashMap<Item, Integer> cart = (HashMap) session.getAttribute("cart");
        if (cart == null) {
            out.print("Your cart is empty");
        } else {

    %>

    <h1>Thong tin gio hang</h1>
    <table>
        <tr>
            <th>NAME</th>
            <th>QUANTITY</th>
            <th>PRICE</th>
            <th>IMAGE</th>
            <th>ACTION</th>
        </tr>
        <%  int sum = 0;
            for (Item it : cart.keySet()) {
                sum = sum + cart.get(it) * it.getPrice(); // so luong * gia tien + sum ban dau
        %>
        <tr> 
            <form action="EditCartServlet">
                <input type="hidden" value="<%= it.getId() %>" name="txtitemid"/>
                <td><%= it.getName()%></td>
                <td><input type="number" value="<%= cart.get(it)%>" min="1" name="txtquantity"/></td> //nhap input
                <td><%= it.getPrice()%></td>  
                <td><img src="<%= it.getImagepath()%>" width="100" height="100" /></td>  
                <td>
                    <input type="submit" value="remove" name="btn" onclick="return warning()"/>
                    <input type="submit" value="update quantity" name="btn"/>
                </td>  
            </form>
        </tr>
    <%
        }
    %>
    </table>
    <form action="SaveCartServlet">
        <input type="hidden" value="<%= sum %>" name="txttotal"/>
        <h4>Total Money: <%= sum%> VND</h4>
        <input type="submit" value="Hoan Thanh ORDER" />
    </form>  
    <%}%>
    </body>
</html>
