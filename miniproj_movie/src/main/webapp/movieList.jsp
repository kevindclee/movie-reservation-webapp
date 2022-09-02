<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
  table {
    width: 100%;
    border: 1px solid black;
    border-collapse: collapse;
  }
  th, td {
    border: 1px solid black;
    padding: 10px;
  }
</style>
</head>
<body>

<table>
		<tr>
			<th>영화 id</th>
			<th>영화명</th>
			<th>영화가격</th>
		</tr>
	<c:forEach var="movie" items="${movieList}" varStatus="status">
		<tr>
			<td>${movie.id}</td>
	
			<td onClick="location.href='http://localhost:8090/miniproj_movie/movieInfo?movieid=${movie.id}'" style="cursor:pointer">${movie.name}</td>
	
			<td>${movie.price}</td>
		</tr>
	</c:forEach>
</table>
		
	<!-- <form action="listMovie">
		<input type="submit" value="영화불러오기">        
	</form>
	<form action="index.jsp">
		<input type="submit" value="메인화면">        
	</form> -->

</body>