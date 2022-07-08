<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	body{
		text-align:center;
	}
	nav{
		display: inline-block;
	}
	.test{width: 60px; height: 100px;}
	tr{vertical-align: middle;}
</style>
</head>
<body class="text-center">
	<jsp:include page="/WEB-INF/views/templates/navbar.jsp"></jsp:include>
	<c:set var="Image_URL" value="https://image.tmdb.org/t/p/original"/>
	<br><br><br>
	<span>🔎 Search by ${query }, SearchType : ${type }</span>
	
	
	<span>
		<a href="<c:url value='/search/movie?query=${query }&page=${page }'/>">
			<button>영화 : ${scd.movie }개</button>
		</a>
	</span>
	
	<span>
		<a href="<c:url value='/search/tv?query=${query }&page=${page }'/>">
			<button>TV : ${scd.tv }개</button>
		</a>
	</span>
	
	<span>
		<a href="<c:url value='/search/board?query=${query }&page=${page }'/>">
			<button>게시판 : ${scd.board }개</button>
		</a>
	</span>
	
	<br><br>
 	<c:choose>
 		<c:when test="${type eq 'b' }"> <!-- 게시판 -->
 			<table class="table table-hover">
				<thead>
				    <tr>
				      <th scope="col">글 번호</th>
				      <th scope="col">제목</th>
				      <th scope="col">작성자 </th>
				    </tr>
			  	</thead>
			  	<tbody>
			  		<c:forEach var="content" items="${content }">
				  		<tr>
				  			<td>${content.no }</td>
				  			<td>${content.title }</td>
				  			<td>${content.name }</td>
				  		</tr>
			  		</c:forEach>
			  	</tbody>
			</table>
 		</c:when>
 		
 		
 		<c:otherwise>
 			<table class="table table-hover">
				<thead>
				    <tr>
				      <th scope="col" class="center">포스터</th>
				      <th scope="col">제목</th>
				      <th scope="col">평점</th>
				      <th scope="col" style="width: 20%">개봉일 </th>
				    </tr>
			  	</thead>
			  	<tbody>
			  		<c:forEach var="content" items="${contents }">
			  			<tr>
			 				<td>
				 				<a href="<c:url value='/movie/content/${content.id }'/>">
									<img class="test" src="${Image_URL }${content.poster_path }">
								</a>
							</td>
			 				<td><a href="<c:url value='/movie/content/${content.id }'/>">${content.title }</a></td>
			 				<td>${Math.ceil((content.vote_average)/2*10)/10}</td>
			 				<td>${content.release_date }</td>
		 				</tr>
		 			</c:forEach>
			  	</tbody>
			</table>
 		</c:otherwise>
 	</c:choose>
	
	
	<nav aria-label="Page navigation example">
	  <ul class="pagination">
	  	
	  	<!-- 페이징 맨앞으로 버튼
	  	<li class="page-item"><a class="page-link" href="<c:url value='/search/movie?query=${query }&page=${now-1 }'/>">START</a></li> -->
	  	
	  	<!-- 페이징 << 버튼 -->
	  	<c:if test="${now ne 1 }">
	  		<c:choose>
    			<c:when test="${type eq 'm' }">
    				<li class="page-item"><a class="page-link" href="<c:url value='/search/movie?query=${query }&page=${now-1 }'/>">&laquo;</a></li>
    			</c:when>
    			<c:when test="${type eq 't' }">
    				<li class="page-item"><a class="page-link" href="<c:url value='/search/tv?query=${query }&page=${now-1 }'/>">&laquo;</a></li>
    			</c:when>
    			<c:otherwise>
    				<li class="page-item"><a class="page-link" href="<c:url value='/search/board?query=${query }&page=${now-1 }'/>">&laquo;</a></li>
    			</c:otherwise>
    		</c:choose>
  		</c:if>
  		
  		
	  	<!-- 페이징 블럭 번호  -->	
	  	<c:forEach begin="${blockStartNum }" end="${blockLastNum }" var="i">
	  		<c:choose>
    			<c:when test="${type eq 'm' }">
    				<c:choose>	
	    				<c:when test="${i eq now }">
	    					<li class="page-item active"><a class="page-link" href="<c:url value='/search/movie?query=${query }&page=${i }'/>">${i }</a></li>
	    				</c:when>
	    				<c:otherwise>
	    					<li class="page-item"><a class="page-link" href="<c:url value='/search/movie?query=${query }&page=${i }'/>">${i }</a></li>
	    				</c:otherwise>
    				</c:choose>
		    	</c:when>
		    	
		    	<c:when test="${type eq 't' }">
		    		<c:choose>
			    		<c:when test="${i eq now }">
	    					<li class="page-item active"><a class="page-link" href="<c:url value='/search/tv?query=${query }&page=${i }'/>">${i }</a></li>
	    				</c:when>
	    				<c:otherwise>
	    					<li class="page-item"><a class="page-link" href="<c:url value='/search/tv?query=${query }&page=${i }'/>">${i }</a></li>
	    				</c:otherwise>
    				</c:choose>
		    	</c:when>
		    	
		    	<c:otherwise>
		    		<c:choose>
			    		<c:when test="${i eq now }">
	    					<li class="page-item active"><a class="page-link" href="<c:url value='/search/board?query=${query }&page=${i }'/>">${i }</a></li>
	    				</c:when>
	    				<c:otherwise>
	    					<li class="page-item"><a class="page-link" href="<c:url value='/search/board?query=${query }&page=${i }'/>">${i }</a></li>
	    				</c:otherwise>
    				</c:choose>
		    	</c:otherwise>
		    </c:choose>
		</c:forEach>
		
		
		<!-- 페이징 >> 버튼 -->
		<c:if test="${now ne end }">
			<c:choose>
    			<c:when test="${type eq 'm' }">
    				<li class="page-item"><a class="page-link" href="<c:url value='/search/movie?query=${query }&page=${now+1 }'/>">&raquo;</a></li>
    			</c:when>
    			<c:when test="${type eq 't' }">
    				<li class="page-item"><a class="page-link" href="<c:url value='/search/tv?query=${query }&page=${now+1 }'/>">&raquo;</a></li>
    			</c:when>
    			<c:otherwise>
    				<li class="page-item"><a class="page-link" href="<c:url value='/search/board?query=${query }&page=${now+1 }'/>">&raquo;</a></li>
    			</c:otherwise>
    		</c:choose>
		</c:if>
		
		<!-- 페이징 맨뒤로 버튼 
	  	<li class="page-item"><a class="page-link" href="<c:url value='/search/movie?query=${query }&page=${now-1 }'/>">END</a></li>-->
	  		
	  </ul>
	</nav>
	
	
</body>
</html>