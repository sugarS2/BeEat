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
					<!-- content-header -->
					<div class="hotplace-header">
						<!-- content-title -->
						<div class="hotplace-title">
							믿고 보는 맛집 리스트
						</div>
						
						<!-- 로그인한 경우에만 글쓰기 가능 -->
						<c:if test="${dto ne null}">
							<div class="hotplace-insert"><a href="hotplace.do?method=insertF">글 쓰 기</a></div>
						</c:if>
						
						<!-- hotplace-category -->
						<div class="hotplace-category">
							<ul>
								<c:forEach items="${categoryList}" var="categoryDTO">
									<li> <a href="#">${categoryDTO.c_name}</a> </li>
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
												<img class="list-item-img" src="./imgs/${hotplaceDTO.h_img1}" alt="${hotplaceDTO.h_img1}">
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
				푸터
			</div>
		</div>
		
		
	</body>
</html>