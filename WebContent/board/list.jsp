<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*,beeat.board.model.BoardDTO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<style>
	td {text-align : left}
	</style>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />		
		<title>[BeEat] Main</title>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
		<link href="https://fonts.googleapis.com/css?family=Do+Hyeon|Dokdo|East+Sea+Dokdo|Gaegu|Gamja+Flower|Poor+Story&display=swap" rel="stylesheet">
		<link rel="stylesheet" href="./css/layout.css" />
		<link rel="stylesheet" href="./css/board/list.css" />
		
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
						<li> <a href="board.do">뽐내기</a> </li>
					</ul>
				</div>
			</div>
			
			<!-- content -->
			<div id="content">
				<center>
					<h1>당신의 맛집을 자랑하세요!</h1>
					
					<c:if test="${memberDTO ne null}">
	                	<h3><a href="board.do?method=insertF">글쓰기</a></h3>
	                </c:if>
					
					
					<!-- list null -->
					<c:if test="${boardList.size() == 0}">
				   <table>
				   <tr>
				   <td>데이터가 하나도 없음</td>
				   </tr>
					</table>
					 </c:if>				
					
					<!-- list not null -->
					<c:forEach items="${boardList}" var="boardList">
					<table>
					  <tr>
						<td rowspan="3">
							<a href="board.do?method=content&b_code=${boardList.b_code}">
								<img src="./imgs/board/${boardList.b_img1}" alt="${boardList.b_img1}" 
								width="400" height="300">
							</a>
						</td>
						<td>${boardList.b_title}</td>
					  </tr>
					  <tr>
						<td>${boardList.email}</td>
					  </tr>
					  <tr>
						<td>${boardList.b_content}</td>
					  </tr>
					</table>
					<hr style="border: solid 1px black;">
					  </c:forEach>
					
				</center>
			</div>
			<!-- footer -->
			<div id="footer">
				푸터
			</div>
		</div>
	</body>
</html>