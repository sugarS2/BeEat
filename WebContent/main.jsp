<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />		
		<title>[BeEat] Main</title>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
		<link href="https://fonts.googleapis.com/css?family=Do+Hyeon|Dokdo|East+Sea+Dokdo|Gaegu|Gamja+Flower|Poor+Story&display=swap" rel="stylesheet">
		<link rel="stylesheet" href="css/layout.css" />
		<link rel="stylesheet" href="css/main.css" />
	</head>
	<body>
		<div id="wrapper">
			<!-- header -->
			<div id="header">
				<!-- logo -->
				<div class="logo">
					<a href="main.do">BeEat</a>
				</div>
				<!-- info -->
				<div class="info">
					<a href="#" id="signin">로그인</a> 
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="member.do?method=signupF" id="signup">회원가입</a>
				</div>
				<!-- search -->
				<div class="search">
					<div class="row justify-content-center">
						<div class="col-12 col-md-10 col-lg-8">
							<form class="card card-sm border-0" >
								<div class="card-body row no-gutters align-items-center">
									<div class="col">
										<input class="form-control form-control-lg form-control-borderless" type="search" placeholder="Search topics or keywords">
									</div>
									&nbsp;
									<div class="col-auto">
										<button class="btn btn-lg btn-warning" type="submit">Search</button>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
				<!-- nav -->
				<div class="nav">
					<ul>
						<li> <a href="#">메인</a> </li>
						<li> <a href="#">맛집 찾기</a> </li>
						<li> <a href="#">뽐내기</a> </li>
					</ul>
				</div>
			</div>
			
			<!-- content -->
			<div id="content">
				<!-- 최고 맛집 top3 부분 -->
				<div class="top-list-wrap">
					<div class="top-list-title">
						<h2> "금주 top3 맛집" </h2>
					</div>
					<div class="top-list-imgs-wrap">
						<ul>
							<li><img src="imgs/list1.jpg" class="top-list-imgs"></li>
							<li><img src="imgs/list2.jpg" class="top-list-imgs"></li>
							<li><img src="imgs/list3.jpg" class="top-list-imgs"></li>
						</ul>
					</div>
				</div>
			</div>
			
			<!-- footer -->
			<div id="footer">
				푸터
			</div>
		</div>
	</body>
</html>