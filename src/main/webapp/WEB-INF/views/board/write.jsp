<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html><head><title>새 글 작성</title></head>
<body>
<h2>새 글 작성</h2>
	<form:form commandName="boardVo" method="POST">		
			<table border="1">
				<tr><td>카테고리</td>
						<th><form:label path="cate">카테고리</form:label></th>
						<td><form:input path="cate"/>
						<form:errors path="cate"/><td>
				</tr>
				<tr><td>제목</td>
						<th><form:label path="title">제목</form:label></th>
						<td><form:input path="title"/>
						<form:errors path="title"/><td>
				</tr>
				<tr><td>내용</td>
						<th><form:label path="content">내용</form:label></th>
						<td><form:input path="content"/>
						<form:errors path="content"/><td>
				</tr>
				<tr>
				<td>
				<button type="reset">취소</button>
				<button type="submit">등록</button>
			</table>
	</form:form>
</body>
</html>