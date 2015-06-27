<%@include file="include.jsp"%>
<html>
<head>
    <title></title>
</head>
<body>

    <h1>Current user : ${currentUser.toString()}</h1>
    <br>
    <br>
    <c:forEach var="u" items="${users}">
        id : ${u.id} name : ${u.name} age : ${u.age} <br>
    </c:forEach>



</body>
</html>
