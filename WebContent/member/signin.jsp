<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>[BeEat] Sign In</title>
		<link href="https://fonts.googleapis.com/css?family=Do+Hyeon|Dokdo|East+Sea+Dokdo|Gaegu|Gamja+Flower|Poor+Story&display=swap" rel="stylesheet">
		<link rel="stylesheet" href="../css/signin.css" />		
		<script src="http://code.jquery.com/jquery-1.3.2.min.js" ></script>
		<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.0/jquery.validate.min.js" ></script>	
		<script src="../js/signin.js"></script>
		
		<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
 	 	<meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width"/>
		<script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>
		
		<!-- 아이콘 지정 -->
		<link rel="shortcut icon" href="../imgs/favicon.ico"/>
		<link rel="icon" href="../imgs/favicon.ico"/>
	</head>
	<body>
		<center>
			<div class="limiter">
				<div class="loginWrapper">
					<div class="logo">
						<a href="../main.do">
							<img src="../imgs/logo.png" />
						</a>
					</div>
					<form name="signin" id="validate_form" method="post">
						<label for="email">Email</label> <br/>
						<input type="email" name="email" id="email" placeholder="Enter Email"/> <br/>

						<label for="pwd">Password</label> <br/>
						<input type="password" name="pwd" id="pwd" placeholder="Enter Password"/> <br/>
						
						<div class="error_msg"></div>
						<center><button type="button" onclick="check_user();">로그인</button><button type="reset">취 소</button></center>
					</form>
					
					<a id="kakao-login-btn"></a>
					<a href="http://developers.kakao.com/logout"></a> <br/>
					
					<div class="link_signinF"> Not a member? <b><a href="../member.do?method=signupF"> Sign up now</a></b> </div>
				</div>
			</div>
		</center>
		
		
		
		<script type='text/javascript'>
			//<![CDATA[
			// 사용할 앱의 JavaScript 키를 설정해 주세요.
			Kakao.init('f62086d0864e7eb60ffa1c2121e24bc3');

			// 카카오 로그인 버튼을 생성합니다.
			Kakao.Auth.createLoginButton({
				container : '#kakao-login-btn',
				success : function(authObj) {
					//alert(JSON.stringify(authObj));
					Kakao.API.request({
						url: '/v1/user/me',
			            success: function(res) {
			            	var signup = $.ajax({
			    				url:"../member.do?method=signup&kakao=kakao", 
			    				method:"POST", 
			    				dataType:"json",
			    				data:{"email":res.id+'@kakao.com', "name":res.properties['nickname'], "pwd":res.id},
			    				//async: false,
			    				success: function(response){
			    					alert(res.id);
			    					if(response=="true"){
				    					$.ajax({
					    					url:"../member.do?method=signin",
					    					type:"post",
					    					data: {"email":res.id+'@kakao.com', "pwd":res.id},
					    					success : function(result){
					    						if (result=="true") {
						    						alert('로그인 성공!');   
					    							location.href="../main.do";
					    						}else {
					    							alert('로그인 실패!');   
					    						}
					    					}
					    				});
			    					}
			    				}
			    			});
			            },
			            fail: function(error) {
			            	alert(JSON.stringify(error));
			            }
					});
				},
				fail : function(err) {
					alert(JSON.stringify(err));
				}
			});
			//
		</script>
	</body>
</html>