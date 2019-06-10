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
		<link rel="stylesheet" href="./css/hotplace/list.css?ver=1.2" />
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
		<script src="./js/hotplace/list.js"></script>
		
		<!-- 검색기능 추가 -->
    	<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
		<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
		<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
		<script src="./js/search/search.js"></script>
		
		<!-- 아이콘 지정 -->
		<link rel="shortcut icon" href="./imgs/favicon.ico"/>
		<link rel="icon" href="./imgs/favicon.ico"/>
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
						<div class="col-8 col-md-8 col-lg-8">
							<form class="card card-sm border-0" method="post" action="search.do?method=search" onkeypress="if(window.event.keyCode == 13){javascript:search(this.value);}">
								<div class="card-body row no-gutters align-items-center">
									<div class="col">
										<input id="searchText" class="form-control form-control-lg form-control-borderless" type="text" placeholder="   업종, 식당 또는 주소 " name="searchText">
									</div>
									&nbsp;
									<div class="col-auto">
										<button class="btn btn-lg btn-warning" type="submit">&nbsp; 검 색  &nbsp;</button>
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
						<li> <a href="board.do?method=list">뽐내기</a> </li>
						<li> <a href="https://www.mangoplate.com/eat_deals" target="_blank">EAT딜(예정)</a> </li>
					</ul>
				</div>
			</div>
			
			<!-- content -->
			<div id="content">
				<div class="content-border">
					<!-- content-header -->
					<div class="hotplace-header">
						<!-- content-title -->
						<div class="hotplace-title">믿고 보는 맛집 리스트</div>
						
						<!-- <div class="hotplace-order">
							<select name="orderList" class="orderList">
								<option value="h_code">최신순</option>
								<option value="h_readnum">조회순</option>
								<option value="h_grade">별점순</option>
							</select>
						</div> -->
						
						<!-- 로그인한 경우에만 글쓰기 가능 -->
						<c:if test="${memberDTO ne null}">
							<div class="hotplace-insert"><a href="hotplace.do?method=insertF"> <span class="plus">+</span> 글 쓰 기</a></div>
						</c:if>
						
						<!-- hotplace-category -->
						<div class="hotplace-category">
							<ul>
								<li> 
									<a href="hotplace.do?method=list" class="categoryList" id="0">전체</a> 
								</li>
								<c:forEach items="${categoryList}" var="categoryDTO">
									<c:set value="${c_code==categoryDTO.c_code?'clicked':''}" var="check"/>
									<li class="${check}"> 
										<a href="hotplace.do?method=findByCategory&c_code=${categoryDTO.c_code}" id="${categoryDTO.c_code}">${categoryDTO.c_name}</a>
									</li>
								</c:forEach>
							</ul>
						</div>
					</div> <!-- content-header 끝 -->
					
					<!-- hotplace-list -->
					<div class="hotplace-list">
							<ul>
								<c:forEach items="${hotplaceList}" var="hotplaceDTO">
									<li>
										<a href="./hotplace.do?method=content&h_code=${hotplaceDTO.h_code}">
											<div class="list-item">
												<img class="list-item-img" src="./imgs/hotplace/${hotplaceDTO.h_img1}" alt="${hotplaceDTO.h_img1}">
												<div class="list-item-text">${hotplaceDTO.h_name}</div>
											</div>
										</a>
									</li>
								</c:forEach>
							</ul>
					</div> <!-- hotplace-list 끝 -->
					
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