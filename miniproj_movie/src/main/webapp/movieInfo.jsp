<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>

<body>
	<table>
		<tr>
			<th>영화명 &nbsp;</th>
			<th>상영관 id &nbsp;</th>
			<th>좌석최대 수</th>
		</tr>
	<c:forEach var="ms" items="${audList}" varStatus="status">
		<tr>
			<td>${ms.movie.name} &nbsp;</td>
			<td>${ms.id} &nbsp;</td>
			<td>${ms.maxSeatCount}</td>
		</tr>
	</c:forEach>		
	</table>
</body>
</html>