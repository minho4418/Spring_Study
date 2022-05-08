<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/includeFile.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${path}/resources/js/memberJoin.js"></script>
</head>
<body>
	<h2>회원가입</h2>
	<form action="${path}/member/join" method="post" enctype="multipart/form-data">
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
				<th>비밀번호확인</th>
				<td><input type="password" id="passwdConfirm"> </td>
			</tr>			
			<tr>
				<th>이름</th>
				<td><input type="text" name="username"> </td>
			</tr>
			<tr>
				<th>우편번호</th>
				<td>
					<input type="text" name="zipcode" size="5">
					<button type="button">조회</button> 
				</td>
			</tr>
			<tr>
				<th>도로명주소</th>
				<td><input type="text" name="addrload" size="35"> </td>
			</tr>
			<tr>
				<th>상세주소</th>
				<td><input type="text" name="addrdetail" size="35"> </td>
			</tr>			
			<tr>
				<th>사진</th>
				<td><input type="file" name="filename"> </td>
			</tr>				
			<tr>
				<td colspan="2" align="center">
					<button>가입</button> 
					<button>취소</button>
				</td>
			</tr>	
				
		</table>
	
	</form>
	
</body>
</html>