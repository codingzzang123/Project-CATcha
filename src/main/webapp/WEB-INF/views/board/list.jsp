<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-type" content="text/html; charset=UTF-8">
<title>목록</title>
</head>
<body>
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
			<c:forEach var="board" items="${boardList }" varStatus="Loop">
				<tr>
					<td>${board.seq }</td>
					<td>${board.cate }</td>
					<td><a href="<c:url value="/board/read/${board.seq }"/>">
					${board.title }</a></td>
					<td>${board.writer }</td>
					<td>${board.regDate }</td>
					<td>${board.views }
					<td>${board.likes }</td>
				</tr>
			</c:forEach>
		</table>
		<a href="<c:url value="/board/write" />">게시물 작성</a>
</body>
</html>