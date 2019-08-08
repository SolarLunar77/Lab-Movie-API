<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Movies</title>
</head>
<body>

<h1>Welcome the Grand Circus Movie API Search!</h1>


<c:forEach var="i" items="${movies}">
		<p>${i.title} ${i.category}</p>
</c:forEach>



</body>
</html>