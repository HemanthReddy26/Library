<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*" %>
    <%@page import="com.hcl.library.beans.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update page</title>
</head>
<body>
<p align="center">Update Book details</p>
<%List<Book> list=(ArrayList<Book>)request.getAttribute("list"); %>
<%for(Book book:list){ %>
<form action="update">
<table align="center" border="2" style="background-color:skyblue;">
       <tr><td>Enter Id:</td><td><input disabled type="text" name="id" value="<%=book.getId()%>"/></td></tr>
        <tr><td>Enter title:</td><td><input type="text" name="title" value="<%=book.getTitle()%>"/></td></tr>
        <tr><td>Enter Author:</td><td><input type="text" name="author" value="<%=book.getAuthor()%>"/></td></tr>
        <tr><td>Enter Price:</td><td><input type="text" name="price" value="<%=book.getPrice() %>"/></td></tr>
        <tr><td align="center" colspan="2"><input type=submit value="update"></td></tr>
</table>
</form>
<%} %>
</body>
</html>