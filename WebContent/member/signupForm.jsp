<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />		
		<title>[BeEat] Sign UP</title>
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
							<img src="../imgs/BeEat_logo.png" />
						</a>
					</div>
					<form>
						<label for="email">Email</label> <br/>
						<input type="text" name="email" placeholder="Enter Email" required/> <br/>
						
						<label for="name">Name</label> <br/>
						<input type="text" name="name" placeholder="Enter Name" required/> <br/>
						
						<label for="pwd">Password</label> <br/>
						<input type="password" name="pwd" placeholder="Enter Password" required/> <br/>
						
						<label for="pwd-repeat">Repeat Password</label> <br/>
						<input type="password" name="pwd-repeat" placeholder="Repeat Password" required/> <br/>
						
						<center><button type="submit">가 입</button><button type="reset">취 소</button></center>
					</form>
					<div class="link_signinF"> Do you have already an account ? <b><a href="../member.do?method=signinF">Login here</a></b> </div>
				</div>
			</div>
		</center>
	</body>
</html>