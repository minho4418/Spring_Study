<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/includeFile.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${path}/resources/js/productAdd.js"></script>
</head>
<body>
	<%@ include file="../header.jsp" %>
	
	<h2>상품등록</h2>
	<form id="frmProductAdd" action="${path}/product/add" method="post">
		<table>
			<tr>
				<th>상품코드</th>
				<td><input type="text" name="pcode" id="pcode" > </td>
			</tr>
			<tr>
				<th>상품명</th>
				<td><input type="text" name="pname" id="pname"> </td>
			</tr>
			<tr>
				<th>단가</th>
				<td><input type="number" name="price" id="price"> </td>
			</tr>
			<tr>
				<td colspan="2">
					<button onclick="addCheck(event)">등록</button>
					<button type="reset">취소</button>
				</td>
			</tr>
			
		
		</table>
	
	
	</form>
</body>
</html>