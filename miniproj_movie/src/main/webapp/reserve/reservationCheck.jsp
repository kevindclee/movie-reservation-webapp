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
</head>
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
<body>
<h1>예약 조회 화면입니다.</h1>
	<table>
		<tr>
			<th>티켓 id</th>
			<th>티켓 시간 / 날짜</th>
			<th>좌석 id</th>
			<th>좌석명</th>
			<th>상영관 id</th>
			<th>movie id</th>
			<th>movie name</th>
			<th>movie price</th>
			<!-- <th>user user name</th>
			<th>user password</th> -->
		</tr>
	<c:forEach var="ticket" items="${ticketList}" varStatus="status">
		<tr>
			<td>${ticket.id}</td>
			<td>${ticket.timeStamp}</td>
			
			<td>${ticket.seat.id}</td>
			<td>${ticket.seat.name}</td>
			
			<td>${ticket.seat.auditorium.id}</td>
			
			<td>${ticket.seat.auditorium.movie.id}</td>
			<td>${ticket.seat.auditorium.movie.name}</td>
			<td>${ticket.seat.auditorium.movie.price}</td>
			
			<%-- <td>${ticket.user.name}</td>
			<td>${ticket.user.passwd}</td> --%>
		</tr>
	</c:forEach>
	</table>
	
	<form action="index.jsp">
		<input type="submit" value="메인화면">        
	</form>	
</body>
</html>