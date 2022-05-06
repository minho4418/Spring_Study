<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/includeFile.jsp" %>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${path}/resources/js/salesModify.js"></script>
</head>
<body>
	<%@ include file="../header.jsp" %>
	
	<h2>판매수정</h2>
	<form action="${path}/sales/modify" method="post" id="frmSalesModify">
		<table>
			<tr>
				<th>순번</th>
				<td> <input type="text" name="seq" id="seq" value="${sales.seq}" readonly> </td>
			</tr>
			<tr>
				<th>판매일자</th>
				<td> <input type="date" name="sdate" id="sdate" value="${sales.sdate}"> </td>
			</tr>
			<tr>
				<th>상품</th>
				<td> 
					<select name="pcode" id="pcode" onchange="amountCal()" >
						<c:forEach var="product" items="${plist}">
							<option value="${product.pcode}" <c:out value="${sales.pcode==product.pcode?'selected':''}"/>>
								${product.pcode}:${product.pname}:${product.price}
							</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<th>판매수량</th>
				<td><input type="number" name="qty" id="qty" onchange="amountCal()" id="qty" value="${sales.qty}"> </td>
			</tr>
			<tr>
				<th>판매금액</th>
				<td><input type="number" name="amount" id="amount" value="${sales.amount}"> </td>
			</tr>	
			<tr>
				<td colspan="2" align="center">
					<button onclick="modifyCheck(event)">수정</button>
					<button type="reset">취소</button>
					<button onclick="removeCheck(event, '${path}')">삭제</button>
				</td>
			</tr>
		</table>
	
	</form>	
</body>
</html>