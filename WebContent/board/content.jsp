<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />		
		<title>[BeEat] Board Content</title>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
		<link href="https://fonts.googleapis.com/css?family=Do+Hyeon|Dokdo|East+Sea+Dokdo|Gaegu|Gamja+Flower|Poor+Story&display=swap" rel="stylesheet">
		<link rel="stylesheet" href="./css/layout.css?ver=1.1" />
		<link rel="stylesheet" href="./css/board/content.css?ver=1.1" />
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
							<form class="card card-sm border-0" method="post" action="search.do">
								<div class="card-body row no-gutters align-items-center">
									<div class="col">
										<input class="form-control form-control-lg form-control-borderless" type="search" placeholder="Search topics or keywords" name="searchText">
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
						<li> <a href="board.do?method=list">뽐내기</a> </li>
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
								<c:if test="${boardDTO.b_img1 ne null}"> <li><img class="img" src="./imgs/board/${boardDTO.b_img1}" alt="${boardDTO.b_img1}"></li> </c:if>
								<c:if test="${boardDTO.b_img2 ne null}"> <li><img class="img" src="./imgs/board/${boardDTO.b_img2}" alt="${boardDTO.b_img2}"></li> </c:if>
								<c:if test="${boardDTO.b_img3 ne null}"> <li><img class="img" src="./imgs/board/${boardDTO.b_img3}" alt="${boardDTO.b_img3}"></li> </c:if>
							</ul>
						</div>
						<!-- 가게명, 평점, 조회수, 답글 수  -->
						<div class="place-info">
							<div class="b_title">${boardDTO.b_title}</div>
							<div class="b_replyCount">댓글수</div>
						</div>
						
						<!-- 가게에 대한 자세한 정보 -->
						<div class="place-info-detail">
							<table>
								<tr> <th>음식 종류</th> <td>${boardDTO.c_name}</td> </tr>
								<tr> <th>본 문</th> <td>${boardDTO.b_content}</td> </tr>
							</table>
						</div>
						
						<div class="h_date">업데이트 : ${boardDTO.b_date}</div>
						
						<div class="btnGroup">
						<c:if test="${boardDTO.email == memberDTO.email}">
							<div class="insertBtn">
							<a href="board.do?method=updateForm&b_code=${boardDTO.b_code}">수정</a>
							<a href="board.do?method=delete&b_code=${boardDTO.b_code}">삭제</a>
							</div>
						</c:if>
						</div>
					</center>
				</div>
			</div>
			<!-- 댓글부분 -->
			<center>
				<h3>댓글</h3>
				<form name="insert-form" class="insert-form" id="insert-form" method="post" action="./board.do?method=insertRe">
				<table class="reply-table">
					<tr>
						<td>내용</td> 
						<input type="hidden" name="b_code" value="${boardDTO.b_code}">
						<input type="hidden" name="email" value="${memberDTO.email}">
						<td><input type="text" name="br_content" id="br_content" class="br_content" placeholder="답글은 답글버튼을 눌러주세요."/></td>
						<td><button type="submit">작 성</button></td>
					</tr>
				</table>
				<table>
					<tr>
						<th>작성자</th>
						<th>내용</th>
						<th>작성일자</th>
					</tr>
					
					<c:forEach items="${replyList}" var="replyList">
						<div class="replyInput">
							<tr>
									<input type="hidden" name="br_refer" value="${replyList.br_refer}">
									<input type="hidden" name="br_lev" value="${replyList.br_lev}">
									<input type="hidden" name="br_order" value="${replyList.br_order}">
								<td>
								<c:if test="${replyList.br_lev > 0}">
								<img src="imgs/reply1.png">
								</c:if>
								${replyList.name}</td>
								<td>${replyList.br_content}</td>
								<td>${replyList.br_date}</td>
								<td>${replyList.br_refer}</td>
								<td>${replyList.br_lev}</td>
								<td>${replyList.br_order}</td>
								<td><input type="button" value="[답글]" class="inputReBtn" /></td>
								<!-- 댓쓴이와 동일인일시 수정삭제 가능 -->
								<c:if test="${replyList.email == memberDTO.email}">
								<td><a href="#" onclick="update()">[수정]</a></td>
								<td><a href="board.do?method=deleteRe&br_idx=${replyList.br_idx}&b_code=${replyList.b_code}">[삭제]</a></td>
								</c:if>
							</tr>
							<tr class="trHidden">
								<td><input type="hidden" name="name" class="name" placeholder="${memberDTO.name}" readonly/></td>
								<td><input type="hidden" name="br_content" class="br_content"/></td>
								<td><input type="hidden" value="작성" class="insertReRe" onclick="insertReRe();"/></td>
							</tr>
						</div>
					</c:forEach>
				</table>
			</center>
			<!-- footer -->
			<div id="footer">
				푸터
			</div>
		</div>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
		<!-- <script src="http://code.jquery.com/jquery-1.3.2.min.js" ></script>   -->   
	<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.0/jquery.validate.min.js" ></script>		
	<script src="./js/board/content.js"></script>
	</body>
</html>