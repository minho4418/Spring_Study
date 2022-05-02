<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	//메세지 창 띄우기
	if ('${msg}' != '')
		alert('${msg}');

	//가입버튼을 눌렀을때
	function joinCheck(e) {
		e.preventDefault(); //기본이벤트 제거
		const email = frmJoin.email;
		const passwd = frmJoin.passwd;
		const name = frmJoin.name;
		console.log(email);
		console.log(passwd);
		console.log(name);
		
		if (email.value==''){
			email.focus();
			alert('이메일을 입력해 주세요');
		}else if (passwd.value==''){
			passwd.focus();
			alert('비밀번호를 입력해 주세요');
		}else if (name.value==''){
			name.focus();
			alert('이름을 입력해 주세요');
		}else{
			frmJoin.submit();
		}
		
	}
	
	
	
	
</script>
</head>
<body>
	<h2>가입</h2>
	<form name="frmJoin" action="/spring/join" method="post">
		<table>
			<tr>
				<th>이메일</th>
				<td><input type="email" name="email"> </td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="passwd"> </td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="name"> </td>
			</tr>
			<tr>
				<td colspan="2">
					<button onclick="joinCheck(event)">가입</button>
					<button type="reset">취소</button>
				</td>
			</tr>
		</table>
	
	</form>
</body>
</html>