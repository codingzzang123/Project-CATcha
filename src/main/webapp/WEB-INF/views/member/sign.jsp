<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
 <jsp:include page="/WEB-INF/views/templates/navbar.jsp"></jsp:include>
    
    <form action="login" method="post" enctype="multipart/form-data">
		아이디 : <input type="text" name="id" ><br>
		비밀번호 : <input type="password" name="pw" ><br>
		비밀번호 확인 : <input type="password" name="pwcheck" ><br>
		닉네임 : <input type="text" name="name" ><br>
		이메일 : <input type="email" name="email" ><br>
		프로필 사진 : <input type="file" name="file"><br>
		<input type="submit" value="확인">
	</form>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>