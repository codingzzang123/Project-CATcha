<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<script src="${pageContext.request.contextPath}/resources/js/hosun/jquery-3.6.0.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/hosun/main.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/hosun/scroll.js"></script>

<title>컨텐츠 디테일 화면</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/templates/navbar.jsp"></jsp:include>
<br><br>
<img src="https://image.tmdb.org/t/p/w400${contents.posterPath}">
<br>
Title : ${contents.title}
<br>
Release Date : ${contents.releaseDate}
<br>
runtime : ${contents.runtime}
<br>
Genre : 
<c:forEach var="genres" items="${contents.ls}">
${genres.genreName}
</c:forEach>
<br>
Overview : ${contents.overview}
<br>
<c:forEach var="images" items="${imageList}">
	<img src="https://image.tmdb.org/t/p/w300${images}">
</c:forEach>
<br>주요 출연진<br>
<div>
	<c:forEach var="cast" begin="0" end="6" step="1" items="${cast}">
		<div class="css-1rdb949-StyledLazyLoadingImage ezcopuc0">
			<img src="https://image.tmdb.org/t/p/w200${cast.profilePath}"></div>
		<div class="css-5yuqaa">${cast.name }</div>
	</c:forEach>
</div>

<br>


</body>
</html>