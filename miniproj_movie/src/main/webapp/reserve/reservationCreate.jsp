<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>예매 create 화면입니다</h1>
<form action="../reservationCreate"> 
	<label for="name">티켓번호</label>
	<input id="seatId" type="text" name="seatId"><br>
	<input type="hidden" id="userName" type="text" name="userName" value="${user.id}"><br>
	<input type="submit" value="예매">
	<input type="reset" value="취소">
</form>
</body>
</html>