<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/includeFile.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="../header.jsp" %>
	
	<h2>상품리스트</h2>
	<form action="${path}/product/list">
		상품명 <input type="text" name="findvalue" value="${param.findvalue}">
		<button>조회</button>
	</form>
	<hr>
	
	<table border="1">
		<tr>
			<th>상품코드</th>
			<th>상품명</th>
			<th>단가</th>
			<th>등록일자</th>
		</tr>
		<c:forEach var="product" items="${plist}">
			<tr>
				<td>${product.pcode}</td>
				<td> <a href="${path}/product/modify?pcode=${product.pcode}">${product.pname}</a>  </td>
				<td>${product.price}</td>
				<td><fmt:formatDate value="${product.regidate}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
			</tr>	
		</c:forEach>
	</table>
	
	
	
	
	
</body>
</html>