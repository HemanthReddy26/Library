<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome page</title>
</head>
<body style="background-color:skyblue;">
<h1 align="center">Welcome To Library Management System</h1>
<table align="center">
    <tr>
    <td><a href="add.jsp"><button>Add Book</button></a></td>
    <td><a href="display"><button>Display Details</button></a></td>
    </tr>
</table>
<div align="center">
<%if(request.getAttribute("message")!=null){ %>
<%=request.getAttribute("message")%>
<%} %>
</div>
</body>
</html>