<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	//삭제버튼을 클릭했을때
	function removeCheck(e) {
		e.preventDefault();//기본이벤트 제거
		
		if (confirm('삭제하시겠습니까?')){
			location.href = '/spring/remove?email=${member.email}';
		}
	}

</script>
</head>
<body>
<%-- 	${member} --%>
	<h2>수정</h2>
	<form action="/spring/modify" method="post">
		<table border="1">
			<tr>
				<th>이메일</th>
				<td><input type="email" name="email" value="${member.email}"  readonly="readonly"> </td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="passwd" value="${member.passwd}">  </td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="name" value="${member.name}"> </td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button>수정</button>
					<button type="reset">취소</button>
					<button onclick="removeCheck(event)">삭제</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>