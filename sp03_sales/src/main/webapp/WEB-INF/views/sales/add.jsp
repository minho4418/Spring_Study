<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/includeFile.jsp" %>        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	//수량*단가 => 가격 구하기
	function amountCal() {
		//선택된 옵션의 가격 가져오기
		const pcode = document.getElementById('pcode');
		var text = pcode.options[pcode.selectedIndex].text;
		console.log(text);
		var price = text.split(':')[2];
		console.log(price);
		
		//수량 가져오기
 		const qty = document.getElementById('qty').value;
		console.log(qty);

		//금액 세팅
		document.getElementById('amount').value = price * qty;
		
	}
	//판매등록버튼을 클릭했을때
	function addCheck(e) {
		e.preventDefault();
		
		const sdate = document.getElementById('sdate');
		const pcode = document.getElementById('pcode');
		const qty = document.getElementById('qty');
		const amount = document.getElementById('amount');
		if (sdate.value == '' ){
			sdate.focus();
			alert('판매날짜를 입력하세요!');
		}else if (pcode.value == '' ){
			pcode.focus();
			alert('상품을 선택하세요!');
		}else if (qty.value == '' ){
			qty.focus();
			alert('수량을 입력하세요!');
		}else if (amount.value == '' ){
			amount.focus();
			alert('금액을 입력하세요!');
		}else {
			
			document.getElementById('frmSalesAdd').submit();
		}
	}
	

</script>
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
					<button onclick="addCheck(event)">등록</button>
					<button type="reset">취소</button>
				</td>
			</tr>
			
		
		</table>
	
	</form>
</body>
</html>