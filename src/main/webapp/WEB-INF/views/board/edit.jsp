<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정</title>
</head>
<body>
		<form:form commandName="boardVo" method="POST">
			<table border="1">
				<tr>
						<th><form:label path="cate">카테고리</form:label></th>
						<td><form:input path="cate"/>
						<form:errors path="cate"/></td>
				</tr>
				<tr>
						<th><form:label path="title">제목</form:label></th>
						<td><form:input path="title"/>
						<form:errors path="title"/></td>
				</tr>
				<tr>
						<th><form:label path="content">내용</form:label></th>
						<td><form:input path="content"/>
						<form:errors path="content"/></td>
				</tr>
			</table>
			<div>
					<a href="<c:url value="/board/list/${boardVo.seq }"/>">뒤로가기</a>
					<a href="<c:url value="/board/detail/${boardVo.seq }"/>">"수정</a>
					<a href="<c:url value="/board/list/${boardVo.seq }"/>">삭제</a>
			</div>
		</form:form>

</body>
</html>