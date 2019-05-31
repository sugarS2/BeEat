<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>[BeEat] Sign In</title>
		<link href="https://fonts.googleapis.com/css?family=Do+Hyeon|Dokdo|East+Sea+Dokdo|Gaegu|Gamja+Flower|Poor+Story&display=swap" rel="stylesheet">
		<link rel="stylesheet" href="../css/signin.css" />		
	</head>
	<body>
		<center>
			<div class="limiter">
				<div class="loginWrapper">
					<div class="logo">
						<a href="../main.do">
							<img src="../imgs/BeEat_logo.png" />
						</a>
					</div>
					<form name="signin" id="validate_form" method="post" action="../member.do?method=signin">
						<label for="email">Email</label> <br/>
						<input type="email" name="email" id="email" placeholder="Enter Email"/> <br/>

						<label for="pwd">Password</label> <br/>
						<input type="password" name="pwd" id="pwd" placeholder="Enter Password"/> <br/>

						<center><button type="submit">로그인</button><button type="reset">취 소</button></center>
					</form>
					<div class="link_signinF"> Not a member? <b><a href="../member.do?method=signupF"> Sign up now</a></b> </div>
				</div>
			</div>
		</center>
		<script src="http://code.jquery.com/jquery-1.3.2.min.js" ></script>
		<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.0/jquery.validate.min.js" ></script>		
		<script src="../js/signin.js"></script>
	</body>
</html>