<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${boardVo.no}번 게시물</title>
</head>
<body>
	<h2>Title of Board</h2>
			
	<table border="1">	
		<tr>	
			<td>카테고리</td>
			<td>${boardVo.cate }></td>
		</tr>	
		<tr>	
			<td>제목</td>
			<td>${boardVo.title }></td>
		</tr>	
		<tr>
			<td>내용</td>
			<td>${boardVo.content }</td>
		</tr>
	</table>
		<div>
			<td><input type="button" value="뒤로가기"  onclick="goBack();" ></td>
			<td><input type="button" value="수정" onClick="location.href='/board/edit/${boardVo.no}';"></td>
			
			<td>
				<a href="<c:url value='/board/edit/${boardVo.no }'/>">
					<button type="button">수정2</button>
				</a>
			</td>
			
			<td><input type="button" value="삭제" onClick="location.href='/board/list';"></td>
		</div>
	
</body>
	<script>
		function nDelCheck(idx){
			var ans = confirm("삭제하시겠습니까?");
			if(ans){
				var query = {"idx" : idx};
				$.ajax({
					url : "${contextPath}/notify/nDelete",
					type : "get",
					success : function(data){
						location.reload();
					}
				});
			}
		}
		
		

	   function goBack(){
	      window.history.back();
	   }

		
	</script>
</html>