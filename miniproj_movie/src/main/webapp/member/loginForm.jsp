<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="loginForm.css">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="login"> <!-- localhost:8090/mvc/add -->
		<div class = "login_area">
		  <p>
			<span class = "input-box">
				<label for = "userid">아이디</label>
				<input id="id" type="text" name="id" maxlength="50" placeholder="아이디 또는 이메일을 입력해주세요." title="입력태그"><br>
			</span>
			<span class = "input-box">
				<label for = "passwd">비밀번호</label>
				<input id="passwd" type="text" name="passwd" maxlength="15" placeholder="비밀번호를 입력해주세요." title="입력태그"><br>
			</span>
		  </p>
			<input type="hidden" name = "hidLoginType" id = "hidLoginType">
			<input type="submit" value="로그인">
			<!-- <button type="button" class="btn_login">로그인</button>   -->
		</div>      
	</form>
	
</body>
</html>