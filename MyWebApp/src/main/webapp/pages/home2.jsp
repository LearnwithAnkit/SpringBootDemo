<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>My JSP Page</title>
</head>
<body>
<header>
    <h1>Welcome ${name}</h1>
</header>

<nav>
    <ul>
        <li><a href="index.jsp">Home</a></li>
        <li><a href="about.jsp">About</a></li>
        <li><a href="contact.jsp">Contact</a></li>
    </ul>
</nav>

<main>
    <h2>Content Goes Here</h2>

    <!-- Embedded JSP code -->
    <%-- This is a JSP comment --%>
    <%
        String message = "Hello, JSP!";
        out.println("<p>" + message + "</p>");
    %>
</main>

<footer>
    <p>&copy; 2023 My JSP Page</p>
</footer>
</body>
</html>
