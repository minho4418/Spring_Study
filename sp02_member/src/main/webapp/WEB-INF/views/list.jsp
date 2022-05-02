<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	if ('${msg}' != '')
		alert('${msg}');

</script>
</head>
<body>
<%-- 	${mlist} --%>
	<h2>회원리스트</h2>
	<button onclick="location.href='/spring/list'">조회</button>
	<button onclick="location.href='/spring/join'">가입</button>
	<table border="1">
		<tr>
			<th>이메일</th>
			<th>비밀번호</th>
			<th>이름</th>
		</tr>
		<c:forEach var="member" items="${mlist}">
			<tr>
				<td> <a href="/spring/modify?email=${member.email}">${member.email}</a> </td>
				<td>${member.passwd}</td>
				<td>${member.name}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>