<%@ page import="java.util.List" %>
<%@ page import="java.util.Arrays" %><%--
  Created by IntelliJ IDEA.
  User: peppe289
  Date: 3/23/24
  Time: 1:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Beer v3</title>
</head>
<body>
    <h1>Try this</h1>
    <%
        List<String> list = (List<String>) request.getAttribute("cose");
        for (String str : list) {
    %>
            <%= "<br>" + str%>
    <%
        }
    %>
</body>
</html>
