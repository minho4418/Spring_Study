<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/includeFile.jsp" %>        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 자바스크립트 분리 -->
<script type="text/javascript" src="${path}/resources/js/salesAdd.js"></script>
</head>
<body>
	<%@ include file="../header.jsp" %>
	<h2>판매등록</h2>
	<form action="${path}/sales/add" method="post" id="frmSalesAdd">
		<table>
			<tr>
				<th>판매일자</th>
				<td> <input type="date" name="sdate" id="sdate"> </td>
			</tr>
			<tr>
				<th>상품</th>
				<td> 
					<select name="pcode" id="pcode" onchange="amountCal()" >
						<c:forEach var="product" items="${plist}">
							<option value="${product.pcode}">${product.pcode}:${product.pname}:${product.price}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<th>판매수량</th>
				<td><input type="number" name="qty" id="qty" onchange="amountCal()" id="qty"> </td>
			</tr>
			<tr>
				<th>판매금액</th>
				<td><input type="number" name="amount" id="amount" > </td>
			</tr>	
			<tr>
				<td colspan="2" align="center">
					<button id = "btnAdd" onclick="addCheck(event)">등록</button>
					<button type="reset">취소</button>
				</td>
			</tr>
			
		
		</table>
	
	</form>
</body>
</html>