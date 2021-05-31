<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert page</title>
</head>
<body>
<p align="center">Add Book details</p>
 <form action="add" method="post">
<table align="center" border="1" style="background-color:skyblue;">
        <tr><td>Enter Id:</td><td><input type="text" name="id" placeholder="Enter id"/></td></tr>
        <tr><td>Enter title:</td><td><input type="text" name="title" placeholder="Enter title"/></td></tr>
        <tr><td>Enter Author:</td><td><input type="text" name="author" placeholder="Enter author"/></td></tr>
        <tr><td>Enter Price:</td><td><input type="text" name="price" placeholder="Enter price"/></td></tr>
        <tr><td align="center" colspan="2"><input type=submit value="Save"></td></tr>
</table>
</form>
<div align="center">
<%if(request.getAttribute("message")!=null){ %>
<%=request.getAttribute("message")%>
<%} %>
</div>
</body>
</html>