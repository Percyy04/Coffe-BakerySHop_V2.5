<%-- 
    Document   : Itempage_M
    Created on : Sep 25, 2024, 1:51:36 PM
    Author     : Tam Peo
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="dto.Item"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            ArrayList<Item> list_1 = (ArrayList<Item>) request.getAttribute("list1");
            ArrayList<Item> list_2 = (ArrayList<Item>) request.getAttribute("list2");
            if (list_1 != null) {
        %>
        <h1>Danh sách sản phẩm đang bán</h1>

        <table>
            <%        for (Item t : list_1) {%>
            <tr>
                <td><%= t.getId()%></td>
                <td><%= t.getName()%></td>
                <td><%= t.getPrice()%></td>
                <td><%= t.getStatus()%></td>
                <td><%= t.getImagepath()%></td>
                <td>
                    <a href='#'>Edit</a> 
                    <a href='#'>Delete</a>
                </td>
            </tr>
            <%}%>    
        </table>
    

<!--        if(list_2 != null){
        out.print("<h1>Danh sách sản phẩm đang bán</h1>");

        out.print("<table>");
            for (Item t : list_2) {
            out.print("<tr>");
                out.print("<td>"+ t.getId() +"</td>");
                out.print("<td>"+ t.getName() +"</td>");
                out.print("<td>"+ t.getPrice() +"</td>");
                out.print("<td>"+ t.getStatus() +"</td>");
                out.print("<td>"+ t.getImagepath() +"</td>");
                out.print("<td><a href='#'>Edit</a>      <a href='#'>Delete</a></td>");
                out.print("</tr>");
            }
            out.print("</table>");
        }-->
        <h3>Tạo sản phẩm mới</h3>
        <form action = 'InsertItemServlet_M'>

            <input type='text' name='txtname' placeholder='Enter Name'>
            <input type='number' name='txtprice' min='1'>
            <select name='txtstatus'>
                <option value='1'>Active</option>
                <option value='0'>Banned</option>
            </select>
            <input type='file' name='txtfilename'>
            <input type='submit' value='Insert'>

        </form>
        
   
    </body>
</html>
