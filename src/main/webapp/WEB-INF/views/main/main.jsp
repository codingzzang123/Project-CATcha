<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="${pageContext.request.contextPath}/resources/js/hosun/jquery-3.6.0.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/hosun/main.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/hosun/scroll.js"></script>

<link href="${pageContext.request.contextPath}/resources/css/hosun/main.css" rel="stylesheet"/>
<title>Main Page</title>

</head>
<body>
	<jsp:include page="/WEB-INF/views/templates/navbar.jsp"></jsp:include>
	<c:set var="Image_URL" value="https://image.tmdb.org/t/p/original"/>
	
	
	<section class="css-7klu3x" id="wrapper">
		<section class="new_index">
		<div class="css-header css-lufi3b">
			<div class="css-pbseb6-StyledHomeListTitleRow">
				<p class="css-header-Font1">Welcome.</p>
				<p class="css-header-Font2">Millions of movies, TV shows and people to discover. Explore now.</p>
				<div class="search-container">
				
					<!-- 검색 -->
					<form action="<c:url value="/search"/>" method="get" onsubmit="return submit()">
				    	<input class="search-input" type="text" name="query" 
				    		value="${query }" placeholder="     Search for Movie, TV ">
				    </form>
				    
					    <script>
						    function submit(){
						    	let val = $("input[name='query']").val();
						        searchForm.find("input[name='query']").val(val);
						        
						        if(val != null){
						        	return true;
						        }else{
						        	return false;
						        }
						    }
					    </script>
					    
				</div>
			</div>
		</div>
		</section>
	    <!-- 현재 상영중인 영화 -->
	    <div class="css-lufi3b">
	        <div class="css-pbseb6-StyledHomeListTitleRow">
	            <p class="css-16qa0p7">현재 상영중인 영화</p>
	        </div>
	        <div class="css-1qq59e8">
	            <div class="css-1kd6k5d">
	                <div class="css-9dnzub scroll">
	                    <div class="css-174lxc3">
	                        <div class="css-119xxd7">
	                            <ul class="css-1ya1z7z-VisualUl">
	                                <li class="css-8y23cj">
	                                    <c:forEach var="nowPlay" begin="0" end="19" step="1" items="${nowPlay}"> 
	                                        <a href="<c:url value='/movie/content/${nowPlay.id }'/>">
	                                            <div class="css-1qmeemv">
	                                                <div class="css-1rdb949-StyledLazyLoadingImage ezcopuc0">
	                                                    <img src="${Image_URL }${nowPlay.poster_path }" class="css-qhzw1o-StyledImg ezcopuc1">
	                                                </div>
	                                            </div>
	                                            <div class="css-ixy093">
	                                                <div class="css-5yuqaa">${nowPlay.title }</div>
	                                                <div class="css-1rxwuxd">
	                                                    <fmt:formatDate value="${vote_average.nowPlay }" pattern="yyyy-MM-dd" />
	                                                </div>
	                                                <div class="average css-xgmur2">
	                                                    <span>평균</span>
	                                                    <svg width="12" height="10" viewBox="0 0 12 10" xmlns="http://www.w3.org/2000/svg" fill="#555765" class="css-1g90l0x">
	                                                        <path fill-rule="evenodd" clip-rule="evenodd" d="M6 8.02L3.14233 9.91131C2.91094 10.0644 2.61352 9.84836 2.68767 9.58097L3.60334 6.27872L0.921531 4.14536C0.704379 3.97262 0.817982 3.62299 1.0952 3.61087L4.51878 3.46128L5.719 0.251483C5.81619 -0.00842059 6.18381 -0.00842094 6.281 0.251483L7.48122 3.46128L10.9048 3.61087C11.182 3.62299 11.2956 3.97262 11.0785 4.14536L8.39666 6.27872L9.31233 9.58097C9.38648 9.84836 9.08906 10.0644 8.85767 9.91131L6 8.02Z"></path>
	                                                    </svg>
	                                                    <span>
	                                                    	${nowPlay.vote_average }
	                                                    </span>
	                                                </div>
	                                                <div class="css-u4moi6">
	                                                	개봉일 : ${nowPlay.release_date }
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
	    
	    <!-- 인기있는 영화 -->
	    <div class="css-lufi3b">
	        <div class="css-pbseb6-StyledHomeListTitleRow">
	            <p class="css-16qa0p7">인기있는 영화</p>
	        </div>
	        <div class="css-1qq59e8">
	            <div class="css-1kd6k5d">
	                <div class="css-9dnzub scroll">
	                    <div class="css-174lxc3">
	                        <div class="css-119xxd7">
	                            <ul class="css-1ya1z7z-VisualUl">
	                                <li class="css-8y23cj">
	                                    <c:forEach var="popular" begin="0" end="19" step="1" items="${popular}"> 
	                                        <a href="<c:url value='/movie/content/${popular.id }'/>">
	                                            <div class="css-1qmeemv">
	                                                <div class="css-1rdb949-StyledLazyLoadingImage ezcopuc0">
	                                                    <img src="${Image_URL }${popular.poster_path }" class="css-qhzw1o-StyledImg ezcopuc1">
	                                                </div>
	                                            </div>
	                                            <div class="css-ixy093">
	                                                <div class="css-5yuqaa">${popular.title }</div>
	                                                
	                                                <div class="average css-xgmur2">
	                                                    <span>평균</span>
	                                                    <svg width="12" height="10" viewBox="0 0 12 10" xmlns="http://www.w3.org/2000/svg" fill="#555765" class="css-1g90l0x">
	                                                        <path fill-rule="evenodd" clip-rule="evenodd" d="M6 8.02L3.14233 9.91131C2.91094 10.0644 2.61352 9.84836 2.68767 9.58097L3.60334 6.27872L0.921531 4.14536C0.704379 3.97262 0.817982 3.62299 1.0952 3.61087L4.51878 3.46128L5.719 0.251483C5.81619 -0.00842059 6.18381 -0.00842094 6.281 0.251483L7.48122 3.46128L10.9048 3.61087C11.182 3.62299 11.2956 3.97262 11.0785 4.14536L8.39666 6.27872L9.31233 9.58097C9.38648 9.84836 9.08906 10.0644 8.85767 9.91131L6 8.02Z"></path>
	                                                    </svg>
	                                                    <span>
	                                                        ${Math.ceil((popular.vote_average)/2*10)/10}
	                                                    </span>
	                                                </div>
	                                                <div class="css-u4moi6">
	                                                	개봉일 : ${popular.release_date }
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
	    
	    <!-- 평점 높은 영화 -->
	    <div class="css-lufi3b">
	        <div class="css-pbseb6-StyledHomeListTitleRow">
	            <p class="css-16qa0p7">높은 평점 영화</p>
	        </div>
	        <div class="css-1qq59e8">
	            <div class="css-1kd6k5d">
	                <div class="css-9dnzub scroll">
	                    <div class="css-174lxc3">
	                        <div class="css-119xxd7">
	                            <ul class="css-1ya1z7z-VisualUl">
	                                <li class="css-8y23cj">
	                                    <c:forEach var="highLate" begin="0" end="19" step="1" items="${highLate}"> 
	                                        <a href="<c:url value='/movie/content/${highLate.id }'/>">
	                                            <div class="css-1qmeemv">
	                                                <div class="css-1rdb949-StyledLazyLoadingImage ezcopuc0">
	                                                    <img src="${Image_URL }${highLate.poster_path }" class="css-qhzw1o-StyledImg ezcopuc1">
	                                                </div>
	                                            </div>
	                                            <div class="css-ixy093">
	                                                <div class="css-5yuqaa">${highLate.title }</div>
	                                                
	                                                <div class="average css-xgmur2">
	                                                    <span>평균</span>
	                                                    <svg width="12" height="10" viewBox="0 0 12 10" xmlns="http://www.w3.org/2000/svg" fill="#555765" class="css-1g90l0x">
	                                                        <path fill-rule="evenodd" clip-rule="evenodd" d="M6 8.02L3.14233 9.91131C2.91094 10.0644 2.61352 9.84836 2.68767 9.58097L3.60334 6.27872L0.921531 4.14536C0.704379 3.97262 0.817982 3.62299 1.0952 3.61087L4.51878 3.46128L5.719 0.251483C5.81619 -0.00842059 6.18381 -0.00842094 6.281 0.251483L7.48122 3.46128L10.9048 3.61087C11.182 3.62299 11.2956 3.97262 11.0785 4.14536L8.39666 6.27872L9.31233 9.58097C9.38648 9.84836 9.08906 10.0644 8.85767 9.91131L6 8.02Z"></path>
	                                                    </svg>
	                                                    <span>
	                                                        ${Math.ceil((highLate.vote_average)/2*10)/10}
	                                                    </span>
	                                                </div>
	                                                <div class="css-u4moi6">
	                                                	개봉일 : ${highLate.release_date }
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
	    
	    <!-- 하단 게시물 + 방문자 수 -->
	    <div class="css-pbseb6-StyledHomeListTitleRow">
			<div class="row mt-2">
	        	<div class="col-lg-7">
	        		<div class="css-pbseb6-StyledHomeListTitleRow">
	            		<p class="css-16qa0p7">최근 게시판 활동</p>
	       			</div>
	        		<table class="table table-striped table-hover mt-4">
						<thead>
			                <tr>
			                    <th scope="col">No</th>
			                    <th scope="col" style="margin-left:30px;">Title</th>
			                    <th scope="col" style="margin-left:50px;">Writer</th>
			                </tr>
			            </thead>
			            <tbody>
			            <c:forEach var="ls" items="${ ls}">
			            	<tr>
								<td>${ls.no }</td>
								<td>${ls.title }</td>
								<td>${ls.name }</td>
							</tr>
							</c:forEach>
			            </tbody>
					</table>
	        	</div>
	        	<div class="col-lg-1 text-center"></div>
	        	<div class="col-lg-4">
	        		<div class="css-pbseb6-StyledHomeListTitleRow">
	            		<p class="css-16qa0p7">Check out the visitors</p>
	       			</div>
	        		<table class="table table-striped table-hover mt-4">
	        			<thead>
	        				<tr>
	        					<th>Today</th>
	        					<th>Total</th>
	        				</tr>
	        				<tr>
	        					<th>${today }</th>
	        					<th>${total }</th>
	        				</tr>
	        			</thead>
	        		</table>
	        		<div>
	        		
	        			<div class="clock">
					        <div class="hour">
					            <div id="hr" class="hr"></div>
					        </div>
					        <div class="min">
					            <div id="mn" class="mn"></div>
					        </div>
					        <div class="sec">
					            <div id="sc" class="sc"></div>
					        </div>
					    </div>
					    <script src="${pageContext.request.contextPath}/resources/js/hosun/clock.js"></script>
	        		</div>
	        	</div>	
			</div>
		</div>
	</section>
	<br><br><br><br><br><br><br><br><br><br><br><br><br>
	<jsp:include page="/WEB-INF/views/templates/footer.jsp"></jsp:include>
</body>	
</html>