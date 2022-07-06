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
<script src="${pageContext.request.contextPath}/resources/js/hosun/jquery-3.6.0.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/hosun/main.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/hosun/scroll.js"></script>
<script>
/* function move(page,category) {
	var url = "/cat/movie/list";
	$("#pagenation").attr("action",url);
	$("#pagenation").attr("method","POST");
	
	if (!page) {
		page = 1;
	} else {
		page = movieList.page;
	}
	
	
	$("#pagenation").attr("page", page);
	
	
	$("#pagenation").attr("category", scmd.category);
	
	$("#pagenation").submit();
 */

</script>
<link href="${pageContext.request.contextPath}/resources/css/hosun/main.css" rel="stylesheet"/>
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/templates/navbar.jsp"></jsp:include>
<br><br><br>
<div class="sort">
Movie
<form:form modelAttribute="scmd">
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
<br><br><br>
<div class="css-lufi3b">
	        <div class="css-pbseb6-StyledHomeListTitleRow">
	            <p class="css-16qa0p7">Movie List - ${category}</p>
	        </div>
	        <div class="css-1qq59e8">
	            <div class="css-1kd6k5d">
	                <div class="css-9dnzub scroll">
	                    <div class="css-174lxc3">
	                        <div class="css-119xxd7">
	                            <ul class="css-1ya1z7z-VisualUl">
	                                <li class="css-8y23cj">
	                                    <c:forEach var="movieList" begin="0" end="19" step="1" items="${movieList}">
	                                        <a href="<c:url value='/movie/content/${movieList.contentsNum}'/>">
	                                            <div class="css-1qmeemv">
	                                                <div class="css-1rdb949-StyledLazyLoadingImage ezcopuc0">
	                                                    <img src="https://image.tmdb.org/t/p/original${movieList.posterPath }" class="css-qhzw1o-StyledImg ezcopuc1">
	                                                </div>
	                                            </div>
	                                            <div class="css-ixy093">
	                                                <div class="css-5yuqaa">${movieList.title }</div>
	                                                <div class="css-1rxwuxd">
	                                                    <fmt:formatDate value="${vote_average.nowPlay }" pattern="yyyy-MM-dd" />
	                                                </div>
	                                                <div class="css-u4moi6">
	                                                	개봉일 : ${movieList.releaseDate }
	                                                </div>
	                                            </div>
	                                        </a>
	                                    </c:forEach>
	                                </li>
	                            </ul>
	
	                        </div>
	                    </div>
	                </div>
	                <div class="css-148ng4f left" style="display: none;">
	                    <button type="button" class="css-vp7uyl" style="margin-bottom: 60px;">
	                        <img src="data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSIxMiIgaGVpZ2h0PSIxNiIgdmlld0JveD0iMCAwIDEyIDE2Ij4KICAgIDxnIGZpbGw9Im5vbmUiIGZpbGwtcnVsZT0iZXZlbm9kZCI+CiAgICAgICAgPHBhdGggZD0iTTAgMEgxMlYxNkgweiIgdHJhbnNmb3JtPSJyb3RhdGUoMTgwIDYgOCkiLz4KICAgICAgICA8cGF0aCBmaWxsPSIjMjkyQTMyIiBzdHJva2U9IiMyOTJBMzIiIHN0cm9rZS13aWR0aD0iLjM1IiBkPSJNMy40MjkgMTMuNDA5TDQuMzU0IDE0LjI1OCAxMC42OCA4LjQ2IDExLjE0MyA4LjAzNiA0LjM1NCAxLjgxMyAzLjQyOSAyLjY2MiA5LjI5MSA4LjAzNnoiIHRyYW5zZm9ybT0icm90YXRlKDE4MCA2IDgpIi8+CiAgICA8L2c+Cjwvc3ZnPgo=" alt="forward">
	                    </button>
	                </div>
	                <div class="css-147ng4f right">
	                    <button type="button" class="css-vp7uyl" style="margin-bottom: 60px;">
	                        <img src="data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSIxMiIgaGVpZ2h0PSIxNiIgdmlld0JveD0iMCAwIDEyIDE2Ij4KICAgIDxnIGZpbGw9Im5vbmUiIGZpbGwtcnVsZT0iZXZlbm9kZCI+CiAgICAgICAgPHBhdGggZD0iTTAgMEgxMlYxNkgweiIvPgogICAgICAgIDxwYXRoIGZpbGw9IiMyOTJBMzIiIHN0cm9rZT0iIzI5MkEzMiIgc3Ryb2tlLXdpZHRoPSIuMzUiIGQ9Ik0zLjQyOSAxMy40MDlMNC4zNTQgMTQuMjU4IDEwLjY4IDguNDYgMTEuMTQzIDguMDM2IDQuMzU0IDEuODEzIDMuNDI5IDIuNjYyIDkuMjkxIDguMDM2eiIvPgogICAgPC9nPgo8L3N2Zz4K" alt="forward">
	                    </button>
	                </div>
	            </div>
	        </div>
	    </div>
	    

<nav aria-label="Page navigation">

  <ul class="pagination">
    <li class="page-item">
      <a class="page-link" href="#" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
    <c:forEach var="i" begin="startPage" end="endPage">
    	<li class="page-item"><a class="page-link" id="pagenation" href="${pageContext.request.contextPath }/movie/list?page=${i}&category=${category}">${i }</a></li>
    </c:forEach>
    <li class="page-item">
      <a class="page-link" href="#" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
  </ul>
</nav>

</body>


</html>