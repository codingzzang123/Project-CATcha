<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-type" content="text/html; charset=UTF-8">
<title>목록</title>
</head>
<body>
<h2>게시물 목록</h2>
		<table border="1">
			<tr>
				<th>번호</th>
				<th>카테고리</th>
				<th>제목</th>
				<th>글쓴이</th>
				<th>작성일</th>
				<th>조회</th>
				<th>추천</th>	
			</tr>
			<c:forEach var="board" items="${boardlist }">
				<tr>
					<td>${board.no }</td>
					<td>${board.cate }</td>
					<td><a href="<c:url value="/board/read/${bo ard.no }"/>">
					${board.title }</a></td>
					<td>${board.name }</td>
					<td><fmt:formatDate value="${now }" pattern="yyyy-MM-dd"/></td>
					<td>${board.views }
					<td>${board.likes }</td>
				</tr>
			</c:forEach>
		</table>
		<a href="<c:url value="/board/write" />">게시물 작성</a>
</body>
</html>