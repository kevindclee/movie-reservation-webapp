<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="memberAdd">
		*아이디:<input type="text" name="id" id="id" >
		<span id="result" style="color:red"></span><br>
		*비밀번호:<input type="text" name="passwd" id="passwd" ><br>
		<span id="result2" style="color:red" ></span>
		<br>
		<input type="submit" value="회원가입">
		<input type="reset" value="취소">
	</form>
</body>
</html>