<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />		
		<title>[BeEat] HotPlace Update</title>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
		<link href="https://fonts.googleapis.com/css?family=Do+Hyeon|Dokdo|East+Sea+Dokdo|Gaegu|Gamja+Flower|Poor+Story&display=swap" rel="stylesheet">
		<link rel="stylesheet" href="./css/layout.css?ver=1.1" />
		<link rel="stylesheet" href="./css/hotplace/update.css?ver=1.1" />
		
		<script type="text/javascript" src="https://code.jquery.com/jquery-3.1.1.min.js"></script> 
		<script type="text/javascript" src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script> 
		<script src="./js/hotplace/update.js"></script>
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
						<a href="./member.do?method=signinF" id="signin">로그인</a> 
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="./member.do?method=signupF" id="signup">회원가입</a>
					</c:if>
					<!-- 사용자가 로그인한 경우 -->
					<c:if test="${memberDTO ne null}">
						${memberDTO.name}님 접속
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="./member.do?method=logout" id="logout">로그아웃</a>
						<!-- 관리자가 로그인한 경우 -->
						<c:if test="${memberDTO.name eq 'admin'}">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<a href="./member.do?method=admin" id="admin">회원관리</a>
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
						<li> <a href="#">뽐내기</a> </li>
					</ul>
				</div>
			</div>
			
			<!-- content -->
			<div id="content">
				<div class="content-border">
					<center>
						<div class="update-title"> 글 수정 </div>
						<form name="update-form" class="update-form" id="update-form" method="post" enctype="multipart/form-data" action="./hotplace.do?method=update">
							<input type="hidden" name="h_code" id="h_code" class="h_code" value="${hotplaceDTO.h_code}"/>
							<input type="hidden" name="email" id="email" class="email" value="${memberDTO.email}" readonly />
							<table class="update-table">
								<tr>
									<th>매장명</th> 
									<td><input type="text" name="h_name" id="h_name" class="h_name" value="${hotplaceDTO.h_name}"/></td>
								</tr>
								<tr>
									<th>업종</th> 
									<td>
										<select name="c_code">
											<c:forEach items="${categoryList}" var="categoryDTO">
												<option value="${categoryDTO.c_code}" ${ categoryDTO.c_code==hotplaceDTO.c_code ? "selected" : " "}> ${categoryDTO.c_name} </option>
											</c:forEach>
										</select>
									</td>
								</tr>
								<tr>
									<th>지역</th> 
									<td>
										<select name="loc_code">
											<c:forEach items="${locList}" var="locDTO">
												<option value="${locDTO.loc_code}" ${ locDTO.loc_code==hotplaceDTO.loc_code ? "selected" : " "}> ${locDTO.loc_addr1} ${locDTO.loc_addr2} </option>
											</c:forEach>
										</select>
									</td>
								</tr>
								<tr>
									<th>상세주소</th> 
									<td><input type="text" name="h_address" id="h_address" class="h_address" value="${hotplaceDTO.h_address}"/></td>
								</tr>
								<tr>
									<th>매장 정보/소개</th> 
									<td>
										<textarea name="h_info" id="h_info" class="h_info">${hotplaceDTO.h_info}</textarea>
									</td>
								</tr>
								<tr>
									<th>전화번호</th> 
									<td><input type="text" name="h_tel" id="h_tel" class="h_tel" value="${hotplaceDTO.h_tel}"/></td>
								</tr>
								<tr>
									<th>운영시간</th> 
									<td><input type="text" name="h_time" id="h_time" class="h_time" value="${hotplaceDTO.h_time}" /></td>
								</tr>
								<tr>
									<th>대표 메뉴</th> 
									<td><input type="text" name="h_menu" id="h_menu" class="h_menu" value="${hotplaceDTO.h_menu}" /></td>
								</tr>
								<tr>
									<th>대표 이미지1</th> 
									<td><input type="file" name="h_img1" id="h_img1" class="h_img1" accept="jpg"/></td>
								</tr>
								<tr>
									<th>대표 이미지2</th> 
									<td><input type="file" name="h_img2" id="h_img2" class="h_img2" /></td>
								</tr>
								<tr>
									<th>대표 이미지3</th> 
									<td><input type="file" name="h_img3" id="h_img3" class="h_img3" /></td>
								</tr>
								<tr>
									<th>평점</th> 
									<td>
										<select name="h_grade">
										
											<% for(float i=0.0f; i<=5.0; i+=0.5){  %>
												<% pageContext.setAttribute("i", i);%>
												<c:set var="i" value="${pageScope.i}"/>
												<option value="<%= i %>" ${ i==hotplaceDTO.h_grade ? "selected" : " "}><%= i %></option>
											<% } %>
										</select>
									</td>
								</tr>
								<tr>
									<th>작성자</th> 
									<td>
										<input type="text" name="name" id="name" class="name" value="${memberDTO.name}" disabled />
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