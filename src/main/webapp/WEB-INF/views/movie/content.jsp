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

<div class="css-lufi3b">
	        <div class="css-pbseb6-StyledHomeListTitleRow">
	            <p class="css-16qa0p7">주요 출연진</p>
	        </div>
	        <div class="css-1qq59e8">
	            <div class="css-1kd6k5d">
	                <div class="css-9dnzub scroll">
	                    <div class="css-174lxc3">
	                        <div class="css-119xxd7">
	                            <ul class="css-1ya1z7z-VisualUl">
	                                <li class="css-8y23cj">
	                                    <c:forEach var="cast" begin="0" end="19" step="1" items="${cast}">
	                                        <div class="css-1qmeemv">
	                                                <div class="css-1rdb949-StyledLazyLoadingImage ezcopuc0">
	                                                    <img src="https://image.tmdb.org/t/p/original${cast.profilePath}" width="100">
	                                                </div>
	                                            </div>
	                                            <div class="css-ixy093">
	                                                <div class="css-5yuqaa">${cast.name }</div>
	                                            </div>
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

<br>


</body>
</html>