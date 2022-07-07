<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새 게시물 작성</title>
</head>
<body>
		<form action="<c:url value="/board/write" />"method="POST">
			<table border="1">
				<tr>
						<th>카테고리</th>
						<td><input name="cate"></td>
				</tr>
				<tr>
						<th>제목</th>
						<td><input name="title"></td>
				</tr>
				<tr>
						<th>내용</th>
						<td><input name="content"></td>
				</tr>
			</table>
			<div>
					<input type="submit" value="뒤로가기">
					<input type="submit" value="수정완료">
			</div>
		</form>

</body>
</html>