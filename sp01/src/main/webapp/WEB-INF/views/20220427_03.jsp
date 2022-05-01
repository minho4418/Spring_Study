<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>파라메터 넘기기</h2>
	<form action="/my/m20220427_03_param">
		아이디 <input type="text" name="userid"> <br>
		비밀번호 <input type="password" name="passwd" > <br>
		<button>전달</button>
	</form>
	<hr>
	${userid}
	${passwd}
</body>
</html>