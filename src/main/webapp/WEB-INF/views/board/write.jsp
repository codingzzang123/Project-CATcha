<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html><head><title>새 글 작성</title></head>
<body>
<h2>Title of Board 📝</h2>
	<form method="POST" action="<c:url value="/board/list" />">		
			<table border="1"> 
				 <tr><b>카테고리</b>
						<tr><input type="radio" name="cate" value="일반" checked>일반</tr>
						<tr><input type="radio" name="cate" value="영화" checked>영화</tr>
						<tr><input type="radio" name="cate" value="TV" checked>TV</tr>
				</tr>
				<tr><td><b>제목</b></td>
						<td><input type="text" name= "title" />
						
				</tr>
				<tr><td><b>내용</b></td>
						<td><input type="text" name= "content" />
						
				</tr> 
				<tr>
				<td><input type="submit" value="취소"></td> 
				<td><input type="submit" value="등록"></td>
			</table>
	</form>
</body>
</html>