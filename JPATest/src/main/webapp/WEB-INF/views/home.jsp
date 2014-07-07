<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	${helloWorld}  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<c:choose>
	<c:when test="${pageContext.request.userPrincipal.name == null}">
                      <a href="login">login</a>
         </c:when>
         <c:otherwise>
                    Welcome : ${pageContext.request.userPrincipal.name} | <a href="logout">logout</a>
         </c:otherwise>
</c:choose>
</body>
</html>
