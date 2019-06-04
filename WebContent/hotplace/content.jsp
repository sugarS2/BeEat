<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />		
		<title>[BeEat] HotPlace List</title>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
		<link href="https://fonts.googleapis.com/css?family=Do+Hyeon|Dokdo|East+Sea+Dokdo|Gaegu|Gamja+Flower|Poor+Story&display=swap" rel="stylesheet">
		<link rel="stylesheet" href="./css/layout.css?ver=1.2" />
		<link rel="stylesheet" href="./css/hotplace/content.css?ver=1.2" />
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
		<script src="./js/hotplace/list.js"></script>
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
					<!-- 로그인한 사용자가 없는 경우 -->
					<c:if test="${dto eq null}">
						<a href="member.do?method=signinF" id="signin">로그인</a> 
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="member.do?method=signupF" id="signup">회원가입</a>
					</c:if>
					<!-- 사용자가 로그인한 경우 -->
					<c:if test="${dto ne null}">
						${dto.email}님 접속
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="member.do?method=logout" id="logout">로그아웃</a>
						<!-- 관리자가 로그인한 경우 -->
						<c:if test="${dto.email eq 'admin'}">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<a href="member.do?method=admin" id="admin">회원관리</a>
						</c:if>
					</c:if>
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
						<li> <a href="main.do">메인</a> </li>
						<li> <a href="hotplace.do?method=list">맛집 찾기</a> </li>
						<li> <a href="#">뽐내기</a> </li>
					</ul>
				</div>
			</div>
			
			<!-- content -->
			<div id="content">
				<div class="content-border">
					<center>
						<!-- 이미지 -->
						<div class="imgList">
							<ul>
								<c:if test="${dto.h_img1 ne null}"> <li><img class="img" src="./imgs/${dto.h_img1}" alt="${dto.h_img1}"></li> </c:if>
								<c:if test="${dto.h_img2 ne null}"> <li><img class="img" src="./imgs/${dto.h_img2}" alt="${dto.h_img2}"></li> </c:if>
								<c:if test="${dto.h_img3 ne null}"> <li><img class="img" src="./imgs/${dto.h_img3}" alt="${dto.h_img3}"></li> </c:if>
							</ul>
						</div>
						<!-- 가게명, 평점, 조회수, 답글 수  -->
						<div class="place-info">
							<div class="h_name">${dto.h_name}</div>
							<div class="h_grade">평점 : ${dto.h_grade}</div>
							<div class="h_replyCount">답글수</div>
						</div>
						
						<div class="place-info-detail">
							가게에 대한 자세한 정보
							<table>
								<tr> <td>주소</td> <td>${dto.loc_addr1} ${dto.loc_addr2} ${dto.h_address}</td> </tr>
								<tr> <td>전화번호</td> <td>${dto.h_tel}</td> </tr>
								<tr> <td>음식 종류</td> <td>${dto.c_name}</td> </tr>
								<tr> <td>영업시간</td> <td>${dto.h_time}</td> </tr>
								<tr> <td>메뉴</td> <td>${dto.h_menu}</td> </tr>
							</table>
						</div>
					</center>
				</div>
			</div>
			
			<!-- footer -->
			<div id="footer">
				푸터
			</div>
		</div>
		
		
	</body>
</html>