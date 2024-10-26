<%-- 
    Document   : Home
    Created on : Sep 25, 2024, 2:12:32 PM
    Author     : Tam Peo
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="dto.Item"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="style.css">
<link
    rel="stylesheet"
    href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"
    integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA=="
    crossorigin="anonymous"
    referrerpolicy="no-referrer"
    />
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="header">
            <div class="left">
                <p><a href="GetItemServlet"><i class="fa-solid fa-house"></i></a></p> 
            </div>
            <form action="SearchServlet" class="search-box">
                <input placeholder="Search..." type="text" name="txtsearch" value="<%= (request.getParameter("msg")) != null ? (request.getParameter("msg")) : ""%>"/>
                <input type="submit" value="Go" />
            </form>
            <div class="right">
                <a href="ViewCart.jsp">View Cart</a> 
                <a href="ViewWishListServlet">WishList</a>
                <a href="loginpage.jsp">Login</a>
            </div>
        </div>
        <div class="item-conitainer">
            <%
                ArrayList<Item> list = (ArrayList<Item>) request.getAttribute("listitems");
                if (list != null) {
                    for (Item t : list) {
                        out.print("<div style='float: left; margin: 4%' class='list'>");
                        out.print("<img src='" + t.getImagepath() + "' width='100' height='100'/>");
                        out.print("<br/><span class='price'>Price: " + t.getPrice() + "</span>");
                        out.print("<br/><a href='AddToCartServlet?itemid=" + t.getId() + "' class='buy'>Đặt mua</a>");
                        out.print("<a href='addItemToWishList?itemid=" + t.getId() + "' class='wishlist'>Tim</a>");
                        out.print("</div>");
                    }
                }
            %>
        </div>
    </body>
</html>
