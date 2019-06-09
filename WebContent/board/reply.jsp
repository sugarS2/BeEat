<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />		
		<title>[BeEat] Sign Up</title>
		<link href="https://fonts.googleapis.com/css?family=Do+Hyeon|Dokdo|East+Sea+Dokdo|Gaegu|Gamja+Flower|Poor+Story&display=swap" rel="stylesheet">
		<link rel="stylesheet" href="../css/signup.css" />
		<script>
			function on()
			{
				reply.submit;
				//window.opener.location.href="board.do?method=content&b_code=${replyContent.b_code}";
				//self.close();
			}
		</script>
		<script src=".js/board/reply.js"></script>
	</head>
	<body>
		<center>
			<!-- signupWrapper -->
			<div class="limiter">
				<div class="loginWrapper">
					<!-- logo -->
					<div class="logo">
						<a href="main.do"><img src="./imgs/logo.png" /></a>
					</div>
					<form class="reply_form" name="reply" id="reply_form" method="post" action="board.do?method=insertReRe">
						<table>
							<tr>
								<th>작성자</th>
								<th>내용</th>
								<th>작성일자</th>
							</tr>
							<tr>
								<input type="hidden" name="br_refer" value="${replyContent.br_refer}">
								<input type="hidden" name="br_lev" value="${replyContent.br_lev}">
								<input type="hidden" name="br_order" value="${replyContent.br_order}">
								<input type="hidden" name="b_code" value="${replyContent.b_code}">
								<input type="hidden" name="email" value="${replyContent.email}">
								<td>${replyContent.name}</td>
								<td>${replyContent.br_content}</td>
								<td>${replyContent.br_date}</td>
						</table>
						<label for="br_content">내 용</label> <br/>
						<input type="br_content" name="br_content" id="br_content" placeholder="내용을 입력해주세요."/> <br/>
						
						<!-- <form id="close"> -->
						<center><button onclick="on()">입 력</button><button type="reset">취 소</button></center>
						<!-- </form> -->
					</form>
				</div>
			</div>
		</center>
	</body>
</html>