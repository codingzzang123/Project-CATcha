<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html><head><title>μ κΈ μμ±</title></head>
<body>
<h2>Title of Board π</h2>
	<form method="POST" action="<c:url value="/board/list" />">		
			<table border="1"> 
				 <tr><b>μΉ΄νκ³ λ¦¬</b>
						<tr><input type="radio" name="cate" value="μΌλ°" checked>μΌλ°</tr>
						<tr><input type="radio" name="cate" value="μν" checked>μν</tr>
						<tr><input type="radio" name="cate" value="TV" checked>TV</tr>
				</tr>
				<tr><td><b>μ λͺ©</b></td>
						<td><input type="text" name= "title" />
						
				</tr>
				<tr><td><b>λ΄μ©</b></td>
						<td><input type="text" name= "content" />
						
				</tr> 
				<tr>
				<td><input type="submit" value="μ·¨μ"></td> 
				<td><input type="submit" value="λ±λ‘"></td>
			</table>
	</form>
</body>
</html>