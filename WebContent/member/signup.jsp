<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />		
		<title>[BeEat] Sign Up</title>
		<link href="https://fonts.googleapis.com/css?family=Do+Hyeon|Dokdo|East+Sea+Dokdo|Gaegu|Gamja+Flower|Poor+Story&display=swap" rel="stylesheet">
		<link rel="stylesheet" href="../css/signup.css" />
	</head>
	<body>
		<center>
			<!-- signupWrapper -->
			<div class="limiter">
				<div class="loginWrapper">
					<div class="logo">
						<a href="../main.do">
							<img src="../imgs/logo.png" />
						</a>
					</div>
					<form class="validate_form" name="signup" id="validate_form" method="post" action="../member.do?method=signup">
						<label for="email">Email</label> <br/>
						<input type="email" name="email" id="email" placeholder="Enter Email"/> <br/>
						
						<label for="name">Name</label> <br/>
						<input type="text" name="name" id="name" placeholder="Enter Name"/> <br/>
						
						<label for="pwd">Password</label> <br/>
						<input type="password" name="pwd" id="pwd" placeholder="Enter Password"/> <br/>
						
						<label for="pwd_repeat">Repeat Password</label> <br/>
						<input type="password" name="pwd_repeat" id="pwd_repeat" placeholder="Repeat Password"/> <br/>
						
						<center><button type="submit">가 입</button><button type="reset">취 소</button></center>
					</form>
					<div class="link_signinF"> Do you have already an account ? <b><a href="../member.do?method=signinF">Login here</a></b> </div>
				</div>
			</div>
		</center>
		<script src="http://code.jquery.com/jquery-1.3.2.min.js" ></script>
		<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.0/jquery.validate.min.js" ></script>		
		<script src="../js/signup.js"></script>
	</body>
</html>