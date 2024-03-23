<%@ page import="org.example.cookies.CookiesData" %><%--
  Created by IntelliJ IDEA.
  User: peppe289
  Date: 3/23/24
  Time: 3:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Title</title>
  </head>
  <body>
  <%
      CookiesData cd = (CookiesData) request.getAttribute("cose");
  %>
  <h1>
      Ciao <%=cd.getName()%>
  </h1>
  <h2>
      numero di accessi <%=cd.getSession()%>
  </h2>

  </body>
</html>
