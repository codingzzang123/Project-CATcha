<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script>
/* function contentsView(contentsNum){
	let f = document.createElement('form');
	let obj;
	obj = document.createElement('input');
	obj.setAttribute('type','hidden');
	obj.setAttribute('id','contentsNum');
	obj.setAttribute('value', contentsNum);
	
	f.appendChild(obj);
	f.setAttribute('method','post');
	f.setAttribute('action', '/media/content');
	document.body.appendChild(f);
	f.submit();
} */
</script>
<style type="text/css">
	.wraper > div {
	background-color:blue;
	border: 1px black solid;
	}
	.wraper > div:nth-child(odd){
	background-color:indianred;
	float:left;
	}
	.wraper{
	display:grid;
	}
	li {list-style-type:none; float:left;}
</style>
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/templates/navbar.jsp"></jsp:include>
<br><br><br>
<h3> 정렬바 </h3>
<div class="sort">
Movie
<form:form modelAttribute="scmd">
	<select name="category" id="category">
		<option value="popularity.desc" ${category == '"popularity.desc"' ? 'selected="selected"':''}>인기도 내림차순</option>
		<option value="popularity.asc" ${category == '"popularity.asc"' ? 'selected="selected"':''}>인기도 오름차순</option>
		<option value="vote_average.desc" ${category == '"vote_average.desc"'?'selected="selected"':''}>평점 내림차순</option>
		<option value="vote_average.asc" ${category == '"vote_average.asc"'?'selected="selected"':''}>평점 오름차순</option>
	</select>
	<br>
	<input type="submit" value="확인">
</form:form>
</div>
<br><br><br>
<h3>데이터 뽑힐 부분!!</h3>
<br>
<div class="wraper">

     <c:forEach var="movieList" begin="0" end="19" step="1" items="${movieList}">
         <div class="divContent1">
         <a href="<c:url value='/movie/content/${movieList.contentsNum}'/>">
			<img src="https://image.tmdb.org/t/p/original${movieList.posterPath }" width="100" height="100">
  			<br>${movieList.title }
  			<br><fmt:formatDate value="${movieList.releaseDate }" pattern="yyyy-MM-dd" />
  		</a>
		  </div>
    </c:forEach>
</div>  

<div class="paging">
<form:form modelAttribute="page" id="page">
<select name="page" id="page">

<option value="${page}">${page}</option>
<option value="${page+1}">${page+1}</option>
</select>
<input type="submit" value="이동">
</form:form>
	</div>

</body>


</html>