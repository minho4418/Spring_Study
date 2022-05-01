<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h2>회원가입</h2>
		<form action="/my/m20220427_05" method="post">
			이메일 <input type="email" name="email"> <br>
			비밀번호 <input type="password" name="passwd"> <br>
			이름 <input type="text" name="name"> <br>
			<button>가입</button>
		</form>
		<hr>
		${memInfo}
		
		
		
		
		
</body>
</html>