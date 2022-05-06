<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/includeFile.jsp" %>        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 자바스크립트 분리 -->
<script type="text/javascript" src="${path}/resources/js/salesList.js"></script>
</head>
<body>
	<%@ include file="../header.jsp" %>
	
	<h2>판매조회</h2>
	<div id="divFind">
		<select name="findkey" id="findkey" onclick="selectFind()">
			<option value="pname" <c:out value="${param.findkey=='pname'?'selected':''}"/>>상품명</option>
			<option value="sdate" <c:out value="${param.findkey=='sdate'?'selected':''}"/>>판매날짜</option>
		</select>
		<div id="divPname">
			<input type="text" name="findvalue" id="findvaluePname" value="${param.findvalue}">
		</div>
		<div id="divSdate" style="display:none">
			<input type="date" name="findvalue" id="findvalueSdate" value="${param.findvalue}">
		</div>
		<button onclick="salesList('${path}')">조회</button>
	</div>
	<hr>
	<%-- ${slist} --%>
	<table border="1">
		<tr>
			<th>판매날짜</th>
			<th>상품코드</th>
			<th>상품명</th>
			<th>단가</th>
			<th>수량</th>
			<th>판매금액</th>
			<th>판매일시</th>
		</tr>
		<c:forEach var="sales"  items="${slist}">
			<tr>
				<td>${sales.SDATE}</td>
				<td>${sales.PCODE}</td>
				<td><a href="${path}/sales/modify?seq=${sales.SEQ}">${sales.PNAME}</a></td>
				<td>${sales.PRICE}</td>
				<td>${sales.QTY}</td>
				<td>${sales.AMOUNT}</td>
				<td>${sales.REGIDATE}</td>
			</tr>
		</c:forEach>
	</table>
	
	
	
	
</body>
</html>