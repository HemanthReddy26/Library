<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*" %>
    <%@page import="com.hcl.library.beans.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display page</title>
</head>
<body>
<h1>Display Book Details</h1>
<a href="welcome.jsp" ><button>Home</button></a>
<%if(request.getAttribute("list")!=null){ %>
<%List<Book> bookList = (ArrayList<Book>)request.getAttribute("list"); %>
<table border="1" cellspacing="0" cellpadding="5">
<tr><th>Id</th>
<th>Title</th>
<th>Author</th>
<th>Price</th></tr>
<%for(Book book:bookList){ %>
<tr><td><%=book.getId() %></td>
<td><%=book.getTitle() %></td>
<td><%=book.getAuthor()%></td>
<td><%=book.getPrice()%></td>
<td><a href="fill?id=<%=+book.getId()%>"><button>update </button></td>
<td><a href="delete?id=<%=+book.getId()%>"><button type="submit">delete</button></a></td>
</tr>
<%} %>
</table>
<%} %>
<% if(request.getAttribute("message")!=null){ %>
<%=request.getAttribute("message") %>
<%} %>

</body>
</html>