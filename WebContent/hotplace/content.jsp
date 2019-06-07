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
		<link rel="stylesheet" href="./css/layout.css?ver=1.1" />
		<link rel="stylesheet" href="./css/hotplace/content.css?ver=1.1" />
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
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
				<div class="content-border">
					<center>
						<!-- 이미지 -->
						<div class="imgList">
							<ul>
								<c:if test="${hotplaceDTO.h_img1 ne null}"> <li><img class="img" src="./imgs/hotplace/${hotplaceDTO.h_img1}" alt="${hotplaceDTO.h_img1}"></li> </c:if>
								<c:if test="${hotplaceDTO.h_img2 ne null}"> <li><img class="img" src="./imgs/hotplace/${hotplaceDTO.h_img2}" alt="${hotplaceDTO.h_img2}"></li> </c:if>
								<c:if test="${hotplaceDTO.h_img3 ne null}"> <li><img class="img" src="./imgs/hotplace/${hotplaceDTO.h_img3}" alt="${hotplaceDTO.h_img3}"></li> </c:if>
							</ul>
						</div>
						<!-- 가게명, 작성자, 평점, 조회수, 답글 수  -->
						<div class="place-info">
							<div class="h_name">${hotplaceDTO.h_name}</div>
							<div class="email">작성자 : ${hotplaceDTO.name}</div>
							<div class="h_grade">평점 : ${hotplaceDTO.h_grade}</div>
							<div class="h_replyCount">댓글수 : ${replyCount}</div>
							<div class="h_readnum">조회수 : ${hotplaceDTO.h_readnum}</div>
						</div>
						
						<!-- 가게에 대한 자세한 정보 -->
						<div class="place-info-detail">
							<table>
								<tr> <th>주소</th> <td class="totalAddr">${hotplaceDTO.loc_addr1} ${hotplaceDTO.loc_addr2} ${hotplaceDTO.h_address}</td> </tr>
								<tr> <th>전화번호</th> <td>${hotplaceDTO.h_tel}</td> </tr>
								<tr> <th>음식 종류</th> <td>${hotplaceDTO.c_name}</td> </tr>
								<tr> <th>영업시간</th> <td>${hotplaceDTO.h_time}</td> </tr>
								<tr> <th>메뉴</th> <td>${hotplaceDTO.h_menu}</td> </tr>
								<tr> <th>식당 소개</th> <td>${hotplaceDTO.h_info}</td> </tr>
							</table>
						</div>
						
						<!--  Daum Map -->
						<div id="daumMap"></div>
						
						<div class="h_date">업데이트 : ${hotplaceDTO.h_date}</div>
						
						<c:if test="${memberDTO.email eq hotplaceDTO.email}">
							<div class="btnGroup">
								<div class="insertBtn"><a href="hotplace.do?method=updateF&h_code=${hotplaceDTO.h_code}">수 정</a></div>
								<div class="deleteBtn"><a href="hotplace.do?method=delete&h_code=${hotplaceDTO.h_code}" onclick="return checkDelete();">삭 제</a></div>
							</div>
						</c:if>
						
						
						<div class="hotplace-reply">
							<div class="hotplace-reply-title">댓글</div>
							
							<!-- 댓글 입력창 (로그인 한 경우에만 댓글 입력가능하게) -->
							<c:if test="${memberDTO ne null}">
								<div class="hotplace-reply-input">
									<!-- method="post" action="h_reply.do?method=insert&h_code=${hotplaceDTO.h_code}" -->
									<form name="hotplace-reply-form">
										<label for="name" class="name"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ${memberDTO.name} &nbsp;&nbsp;▷ </label>
										<input type="hidden" name="h_code" value="${hotplaceDTO.h_code}" class="h_code"/>
										<input type="hidden" name="email" value="${memberDTO.email}" class="email"/>
										<input type="text" name="hr_content" class="hr_content" />
										<input type="button" value="댓 글 달 기" class="replyBtn" onclick="checkReplyBtn();" />
										<input type="hidden" value="취 소" class="resetBtn" onclick="changeReplyBtn();" />
									</form>
								</div>
							</c:if>
							
							<!-- 댓글 목록창 -->
							<div class="hotplace-reply-list">
								<table>
									<c:forEach items="${h_replyList}" var="h_replyDTO"> 
										<tr class="item">
											<td class="name"> ${h_replyDTO.name} &nbsp;&nbsp; | </td> 
											<td class="content">
												<div class="hr_date"> ${h_replyDTO.hr_date} </div>
												<span class="hr_content"> 
													${h_replyDTO.hr_content} 
													<c:if test="${h_replyDTO.name eq memberDTO.name}">
														<span class="replyBtnGroup" align="left">
															<span class="updateReplyBtn"><button type="button" onclick="updateReply(${h_replyDTO.hr_idx}, '${h_replyDTO.hr_content}');">수정</button></span>
															<span class="deleteReplyBtn"><button type="button" onclick="deleteReply(${h_replyDTO.hr_idx});">삭제</button></span>
														</span>
													</c:if>
												</span>
											</td>
										</tr>
									</c:forEach>
								</table>
							</div>
						</div>
					</center>
				</div>
			</div>
			
			<!-- footer -->
			<div id="footer">
				푸터
			</div>
		</div>
		
		<!-- Daum Map API -->
		<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=d30b5ae2dc0adb31cbd07f2eab3f254c&libraries=services,clusterer,drawing"></script>
		<script src="./js/hotplace/content.js"></script>
		<script src="./js/hotplace/delete.js"></script>
	</body>
</html>