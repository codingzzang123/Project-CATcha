<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="${pageContext.request.contextPath}/resources/js/hosun/jquery-3.6.0.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/hosun/main.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/hosun/scroll.js"></script>
<%
	request.setCharacterEncoding("utf-8");
%>
<link href="${pageContext.request.contextPath}/resources/css/hosun/main.css" rel="stylesheet"/>
<style>
	
	h5{font-size:10px; padding:20px;}
	.category{}
	.category select{}
	
	.category select option{
		height:30px;
		line-height:30px;
		display:block;
		padding:0 20px;
		font-size:12px;
		color:#555;
	}
	.category select option:hover{background-color:yellowgreen; color:white;}
	
	.paginate {
		text-align:center;
		font-size: 14px;
	}
	
	.paginate a{
		border: 1px solid #ccc;
		color:#000;
		font-weight: 600;
		text-decoration: none;
		padding:3px 7px;
		margin-left: 3px;
		vertical-align: middle;
	}
	
	.paginate span {
		border: 1px solid #e28d8;
		color:#cb3536;
		font-weight: 600;
		text-decoration: none;
		padding: 3px 7px;
		margin-left: 3px;
		vertical-align: middle;
	}
	
	.paginate : first-child {
		margin-left: 0;
	}
	
	.container {
		width: 700px;
		margin: 30px auto;
	}

		
</style>
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/templates/navbar.jsp"></jsp:include>
<br><br><br>
<nav>
<div class="sort">
<h5>Movie</h5>
<form:form action="${pageContext.request.contextPath}/movie/list" modelAttribute="scmd">
	<select name="category" id="category">
		<option value="popularity.desc" <c:if test="${category eq 'popularity.desc'}">selected="selected"</c:if>>인기도 내림차순</option>
		<option value="popularity.asc" <c:if test="${category eq 'popularity.asc'}">selected="selected"</c:if>>인기도 오름차순</option>
		<option value="vote_average.desc" <c:if test="${category eq 'vote_average.desc'}">selected="selected"</c:if>>평점 내림차순</option>
		<option value="vote_average.asc" <c:if test="${category eq 'vote_average.asc'}">selected="selected"</c:if>>평점 오름차순</option>
	</select>
	<br>
	<input type="submit" value="확인">
</form:form>
</div>
</nav>
<br><br><br>

Movie List - ${category}
<div class="container">
	<div class="main-content">
	<c:forEach var="movieList" begin="0" end="19" step="1" items="${movieList}">
		<article class="component">
			<a href="<c:url value='/movie/content/${movieList.contentsNum}'/>">
 				<img src="https://image.tmdb.org/t/p/w200${movieList.posterPath}"> 
 					<div class="description">
 						<p>${movieList.title}</p>
 						<p>개봉일 :<fmt:formatDate value="${movieList.releaseDate}" pattern="yyyy.MM.dd"/></p>
 					</div>
			</a>
		</article>
	</c:forEach>
	</div>
</div>

<div class="container">
	<h3 style="text-align: center;">paging</h3>
	
	<div style="padding-top: 20px;">
		${paging}
	</div>
</div>
</body>
</html>