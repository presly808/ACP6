<%--
  Created by IntelliJ IDEA.
  User: serhii
  Date: 21.06.15
  Time: 12:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login page</title>
</head>
<body>
   <form method="post" action="/${APP_URL}/login">
     Id   : <input name="id" type="text"><br>
     Name : <input name="name" type="text"><br>
     <input type="submit">
   </form>
</body>
</html>
