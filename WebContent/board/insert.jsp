<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />		
		<title>[BeEat] Board List</title>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
		<link href="https://fonts.googleapis.com/css?family=Do+Hyeon|Dokdo|East+Sea+Dokdo|Gaegu|Gamja+Flower|Poor+Story&display=swap" rel="stylesheet">
		<link rel="stylesheet" href="./css/layout.css?ver=1" />
		<link rel="stylesheet" href="./css/board/insert.css?ver=1" />
		
		<script type="text/javascript" src="https://code.jquery.com/jquery-3.1.1.min.js"></script> 
		<script type="text/javascript" src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script> 
		<script src="./js/board/insert.js?ver=1.1"></script>
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
						<li> <a href="./main.do">메인</a> </li>
						<li> <a href="./hotplace.do?method=list">맛집 찾기</a> </li>
						<li> <a href="./board.do">뽐내기</a> </li>
					</ul>
				</div>
			</div>
			
			<!-- content -->
			<div id="content">
				<div class="content-border">
					<center>
						<div class="insert-title"> 글쓰기 </div>
						<form name="insert-form" class="insert-form" id="insert-form" method="post" enctype="multipart/form-data" action="./board.do?method=insert">
							<table class="insert-table">
								<tr>
									<th>제목</th> 
									<td><input type="text" name="b_title" id="b_title" class="b_title" /></td>
								</tr>
								<tr>
									<th>업종</th> 
									<td>
										<select name="c_code">
											<c:forEach items="${categoryList}" var="categoryDTO">
												<option value="${categoryDTO.c_code}"> ${categoryDTO.c_name} </option>
											</c:forEach>
										</select>
									</td>
								</tr>
								<tr>
									<th>내용</th> 
									<td>
										<textarea name="b_content" id="b_content" class="b_content"></textarea>
									</td>
								</tr>
								<tr>
									<th>대표 이미지1</th> 
									<td><input type="file" name="b_img1" id="b_img1" class="b_img1" accept="jpg"/></td>
								</tr>
								<tr>
									<th>대표 이미지2</th> 
									<td><input type="file" name="b_img2" id="b_img2" class="b_img2" /></td>
								</tr>
								<tr>
									<th>대표 이미지3</th> 
									<td><input type="file" name="b_img3" id="b_img3" class="b_img3" /></td>
								</tr>
								<tr>
									<th>작성자</th> 
									<td>
										<input type="text" name="email" id="email" class="email" value="${memberDTO.email}" readonly />
									</td>
								</tr>
								<tr>
									<td colspan="2" class="btnWrapper">
										<button type="submit" class="btn">추가</button>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<button type="reset" class="btn">다시 작성</button>
									</td>
								</tr>
							</table>
						</form>
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