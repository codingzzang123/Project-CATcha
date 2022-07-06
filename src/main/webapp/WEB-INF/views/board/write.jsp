<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html><head><title>새 게시물 작성</title></head>
<body>
		<form:form commandName="boardVo" method="POST">
			<table border="1">
				<tr>
						<th><form:label path="cate">카테고리</form:label></th>
						<td><form:input path="cate"/>
						<form:errors path="cate"/></td>
				</tr>
				<tr>
						<th><form:label path="title">제목을 입력해 주십시오.</form:label></th>
						<td><form:input path="title"/>
						<form:errors path="title"/></td>
				</tr>
				<tr>
						<th><form:label path="content">내용을 입력해주세요.</form:label></th>
						<td><form:input path="content"/>
						<form:errors path="content"/></td>
				</tr>
			</table>
			<div>
					<input type="submit" value="취소">
					<input type="submit" value="등록">
			</div>
		</form:form>

</body>
</html>