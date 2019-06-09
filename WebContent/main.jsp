<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />		
		<title>[BeEat] Main</title>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
		<link href="https://fonts.googleapis.com/css?family=Jua|Do+Hyeon|Dokdo|East+Sea+Dokdo|Gaegu|Gamja+Flower|Poor+Story&display=swap" rel="stylesheet">
		<link rel="stylesheet" href="css/layout.css" />
		<link rel="stylesheet" href="css/main.css" />
	</head>
	<body>
		<div id="wrapper">
			<!-- header -->
			<div id="header">
				<!-- logo -->
				<div class="logo">
					<a href="main.do"><img src="./imgs/logo.png" /></a>
				</div>
				<!-- info -->
				<div class="info">
					<!-- 로그인한 사용자가 없는 경우 -->
					<c:if test="${memberDTO eq null}">
						<a href="member.do?method=signinF" id="signin">로그인</a> 
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="member.do?method=signupF" id="signup">회원가입</a>
					</c:if>
					<!-- 사용자가 로그인한 경우 -->
					<c:if test="${memberDTO ne null}">
						${memberDTO.name}님 접속
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="member.do?method=logout" id="logout">로그아웃</a>
						<!-- 관리자가 로그인한 경우 -->
						<c:if test="${memberDTO.name eq 'admin'}">
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
				<!-- 최고 맛집 top3 부분 -->
				<div class="top-list-wrap">
					<div class="top-list-title">
						<h2> "금주 top3 맛집" </h2>
					</div>
					<div class="top-list-imgs-wrap">
						<ul>
							<c:forEach items="${hotplaceList}" var="hotplaceDTO" > 
								<li>
									<a href="hotplace.do?method=content&h_code=${hotplaceDTO.h_code}">
										<img src="imgs/hotplace/${hotplaceDTO.h_img1}" class="top-list-imgs">
										<div class="h_name">${hotplaceDTO.h_name} (조회수 : ${hotplaceDTO.h_readnum})</div>
									</a>
								</li>
							</c:forEach>
						</ul>
					</div>
				</div>
			</div>
			
			<!-- footer -->
			<div id="footer">
				<div class="footer-info">
					<span class="projectName">BeEat &nbsp; | &nbsp;</span>
					<span class="projectInfo"> 개발자 : 김시욱, 정찬우 &nbsp;|&nbsp; 비트캠프119기 &nbsp;|&nbsp; JSP Project</span>
					<br/>
					<span class="cr">Copyright 2019.김시욱,정찬우. All rights reserved.</span>
				</div>
			</div>
		</div>
	</body>
</html>