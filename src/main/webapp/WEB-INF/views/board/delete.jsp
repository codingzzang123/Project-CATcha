<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>${bean.NO }번 게시물 삭제</h2>
<form action="delete_result">
<input type="hidden" id="NO" name="NO" value="${bean.NO }">
<table>
	<tr>
		<td>작성자</td>
		<td><input type="text" value="${bean.name }" disabled="disabled"/></td>
	</tr>
	<tr>
		<td>작성자 확인</td>
		<td><input type="text" id="NAME" name="NAME"></td>
	</tr>
	<tr>
		<td>
			<button type="submit">삭제</button>
		</td>
	</tr>
</table>
</form>
</body>
</html>