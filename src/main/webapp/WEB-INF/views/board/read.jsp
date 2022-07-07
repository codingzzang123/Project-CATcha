<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${boardVo.NO}번 게시물</title>
</head>
<body>
<h2>${boardVo.NO}번 게시물</h2>
<table>
	<tr><td>제목</td>
	<td><input type="text" id="title" name="title" value="${boardVo.title }"disabled="disabled"/></td>
	<td>조회 수 : %{boardVo.views}</td>
	</tr>
	<tr><td>내용</td>
	<td><textarea id="content" name="content" disabled="disabled">$boardVo.content }</textarea></td>
	</tr>
	<tr><td>작성자</td>
	<td><input type="text" id="name" name="name" value="${boardVo.name }" disabled="disabled"/></td>
	<td>작성 날짜 : <fmt:formatDate value="${boardVo.regdate }" pattern="yyyy-MM-dd"/></td>
	</tr>
	
</table>
	<div>
		<a href="<c:url value="/board/list" />">뒤로가기</a>
		<a href="<c:url value="/board/edit/${boardVo.seq }"/>">수정 완료</a>
	</div>

</body>
</html>