<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정</title>
</head>
<body>
<h2>Title of Board</h2>
	<form method="POST" action="<c:url value="/board/list" />">					
		<table border="1">	
			<tr>	
				<td>카테고리</td>
				<td>
					<input type="text" name="cate" placeholder="${boardVo.cate }">
				</td>
			</tr>	
			<tr>	
				<td>제목</td>
				<td>
					<input type="text" name="title" placeholder="${boardVo.title }">
				</td>
			</tr>	
			<tr>
				<td>내용</td>
				<td>
					<input type="text" name="content" placeholder=">${boardVo.content }">
				</td>
			</tr>
		</table>
			<div>
				<td><input type="button" value="뒤로가기"  onclick="goBack();" ></td>
				
				
				<td>
					<a href="<c:url value='/board/edit/${boardVo.no }'/>">
						<button type="button">수정완료</button>
					</a>
				</td>
			</div>
		</form>
	</body>
</body>
</html>