<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">



</head>
<body>
<jsp:include page="/WEB-INF/views/templates/navbar.jsp"></jsp:include>
<div class="p-5 mb-4 bg-light rounded-3">
		<div class="container-fluid py-5">
	        <form method="post" action="<c:url value="/member/main"/>" >
	        	<div class="container mt-5 mb-5" style="width: 30%; font-weight: bold; font-size: 20px;">
	        		<h1><b>๋ก๊ทธ์ธ ๐</b></h1>
		            
		            <div class="mb-3 mt-5 form-group">
		                <label for="id">์์ด๋</label>
		                <input type="text" class="form-control" id="id" name="id" placeholder="์์ด๋๋ฅผ ์๋ ฅํด์ฃผ์ธ์." required oninput = "checkId()">
		                <div class="eheck_font" id="id_check"></div>
		            </div>
		            
		            <div class="mb-3 form-group">
		                <label for="pw">๋น๋ฐ๋ฒํธ</label>
		                <input class="form-control" type="password" placeholder="Enter Password" name="pw"  required class="pass" id=pass oninput="checkPw()">
		                <div class="eheck_font" id="pw_check"></div>
		            </div>
		            
					<div class="mb-3 form-group text-end">
					    <input type="submit" class="btn btn-dark" style="font-weight: bold; margin-left:3px;" value="๋ก๊ทธ์ธ"/>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>