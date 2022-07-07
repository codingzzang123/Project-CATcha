<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10.10.1/dist/sweetalert2.all.min.js"></script>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>



<link href="${pageContext.request.contextPath}/resources/css/hosun/navbar.css" rel="stylesheet"/>
<link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/sweetalert2@10.10.1/dist/sweetalert2.min.css'>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link href="https://fonts.googleapis.com/css2?family=Source+Sans+Pro:wght@300&display=swap" rel="stylesheet">
<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>

<body>
    <nav class="navbar navbar-expand-lg navbar-light customNav"> 
        <div class="navbar__logo">
        	<a href="${pageContext.request.contextPath }/main">
            	<img src="${pageContext.request.contextPath }/resources/image/main/logo.jpg" height="42px;">
            </a>	
            	<span style="margin-left: 1em;">CATcha</span>
        </div>

        <ul class="navbar__menu navbar-nav me-auto customUl">
            <li><a class="nav-link active customLi" href="${pageContext.request.contextPath }/main"><b>Home</b></a></li>
            
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle customLi" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">Movie</a>
                <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <li><a class="dropdown-item fontKo" href="${pageContext.request.contextPath }/movie/list">인기</a></li>
                    <li><a class="dropdown-item fontKo" href="#">높은 평점</a></li>
                </ul>
           </li>
           
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle customLi" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">Tv</a>
                <ul class="dropdown-menu fontKo" aria-labelledby="navbarDropdown">
                    <li><a class="dropdown-item fontKo" href="${pageContext.request.contextPath }/tv/list">인기</a></li>
                    <li><a class="dropdown-item fontKo" href="#">높은 평점</a></li>
                </ul>
            </li>

            <li><a class="nav-link active customLi" href="${pageContext.request.contextPath }/board"><b>Board</b></a></li>
        </ul>
        <ul class="navbar__menu css-member">
            <li class="nav-link active">
                <form action="#">
                    <div class="search">
                        <input class="css-searchBar" type="text" placeholder="검색어 입력">
                        <input type="image" class="css-searchImg" src="https://s3.ap-northeast-2.amazonaws.com/cdn.wecode.co.kr/icon/search.png">   
                    </div>
                </form>
                <li class="nav-link active">
                    <a class="css-memberButton" href="${pageContext.request.contextPath }/member/login" >로그인</a>
                    <a class="css-memberButton" href="${pageContext.request.contextPath }/member/sign" >회원가입</a>
                </li>
            </li>
        </ul>
    </nav>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>
     