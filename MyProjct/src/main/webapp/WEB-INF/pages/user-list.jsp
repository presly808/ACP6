<%@include file="include.jsp"%>
<html>
<head>
    <title></title>
</head>
<body>

    <c:forEach var="u" items="${users}">
        id : ${u.id} email : ${u.email} fullname : ${u.fullName} <br>
    </c:forEach>

</body>
</html>
