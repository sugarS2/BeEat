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
						<li> <a href="board.do">뽐내기</a> </li>
						<li> <a href="https://www.mangoplate.com/eat_deals" target="_blank">EAT딜(예정)</a> </li>
					</ul>
				</div>
			</div>
			
			<!-- content -->
			<div id="content">
				<div class="content-border">
					<center>
						<!-- board-header -->
						<div class="board-header">
							<!-- board-title -->
							<div class="board-title">당신의 맛집을 자랑하세요!</div>
							
							<!-- 로그인한 경우에만 글쓰기 가능 -->
							<c:if test="${memberDTO ne null}">
								<div class="board-insert"><a href="board.do?method=insertF"> <span class="plus">+</span> 글 쓰 기</a></div>
							</c:if>
						</div>

						<!-- list null -->
						<c:if test="${boardList.size() == 0}">
							<table>
								<tr>
									<td>데이터가 하나도 없음</td>
								</tr>
							</table>
						</c:if>

						<!-- list not null -->
						<div class="boardList">
							<ul>
								<c:forEach items="${boardList}" var="boardDTO"> 
									<a href="board.do?method=content&b_code=${boardDTO.b_code}">
										<li class="board-list-item">
											<div class="item-wrapper">
												<div class="b_img1"><img src="./imgs/board/${boardDTO.b_img1}" alt="${boardDTO.b_img1}" /></div>
												<div class="item-info-wrapper">
													<div class="b_title">" ${boardDTO.b_title} "</div> <br/><br/>
													<div class="b_content">${boardDTO.b_content}</div> <br/>
													<span class="name">${boardDTO.name}  &nbsp; | &nbsp; </span> <span class="b_date"> ${boardDTO.b_date} </span>
													
												</div>
											</div>
										</li>
									</a>
									<hr style="border:2px solid #efefef;"/>
								</c:forEach>
							</ul>
						</div>
						
					</center>
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