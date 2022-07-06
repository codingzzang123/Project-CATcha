<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<link href="${pageContext.request.contextPath}/resources/css/hosun/main.css" rel="stylesheet"/>
<title>test</title>

	

</head>
<body>
	<jsp:include page="/WEB-INF/views/templates/navbar.jsp"></jsp:include>
	
	<section class="css-7klu3x">
		<div class="css-pbseb6-StyledHomeListTitleRow">
			<div class="row mt-2">
	        	<div class="col-lg-6">
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
	        	<div class="col-lg-2 text-center"></div>
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
	        					<th>7</th>
	        					<th>63</th>
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
	
	
	
</body>
</html>