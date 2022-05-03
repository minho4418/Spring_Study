<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/includeFile.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	if ('${msg}' != '')
		alert('${msg}');

	function modifyCheck(e) {
		e.preventDefault();
		const pcode = document.getElementById('pcode');
		const pname = document.getElementById('pname');
		const price = document.getElementById('price');
		console.log(pcode);
		console.log(pname);
		console.log(price);
		
		if (pcode.value ==''){
			pcode.focus();
			alert('상품코드 입력!');
			return ;
		}else if (pname.value ==''){
			pname.focus();
			alert('상품명 입력!');
			return ;
		}else if (price.value ==''){
			price.focus();
			alert('단가를 입력!');
			return ;
		}
		
		document.getElementById('frmProductModify').submit();
	}
	//삭제버튼 클릭시
	function deleteCheck(e) {
		e.preventDefault();
		const pcode = document.getElementById('pcode').value;
		console.log(pcode);
		if (confirm('삭제하시겠습니까?')){
			location.href = '${path}/product/remove?pcode='+pcode;
		}
		
	}
</script>
</head>
<body>
	<%@ include file="../header.jsp" %>
	
	<h2>상품수정</h2>
	<form id="frmProductModify" action="${path}/product/modify" method="post">
		<table>
			<tr>
				<th>상품코드</th>
				<td><input type="text" name="pcode" id="pcode" value="${product.pcode}" readonly> </td>
			</tr>
			<tr>
				<th>상품명</th>
				<td><input type="text" name="pname" id="pname" value="${product.pname}"> </td>
			</tr>
			<tr>
				<th>단가</th>
				<td><input type="number" name="price" id="price" value="${product.price}"> </td>
			</tr>
			<tr>
				<th>등록일자</th>
				<td><fmt:formatDate value="${product.regidate}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
			</tr>

			<tr>
				<td colspan="2">
					<button onclick="modifyCheck(event)">수정</button>
					<button type="reset">취소</button>
					<button onclick="deleteCheck(event)">삭제</button>
				</td>
			</tr>
			
		
		</table>
	
	
	</form>
</body>
</html>