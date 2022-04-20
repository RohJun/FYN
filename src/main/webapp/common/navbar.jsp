<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<nav
		class="navbar navbar-expand-lg bg-secondary navbar-dark sticky-top py-lg-0 px-lg-5 wow fadeIn"
		data-wow-delay="0.1s">
		<a href="main.do" class="navbar-brand ms-4 ms-lg-0">
			<h1 class="mb-0 text-primary text-uppercase">
				<i class="fa-solid fa-handshake"></i>  FYN
			</h1>
		</a>
		<button type="button" class="navbar-toggler me-4"
			data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarCollapse">
			<div class="navbar-nav ms-auto p-4 p-lg-0">
				<a href="main.do" class="nav-item nav-link">Home</a> 
				<a href="aboutpage.do" class="nav-item nav-link">About</a>
				<a href="notice.do" class="nav-item nav-link">Notice</a>
				<a href="chat.jsp" class="nav-item nav-link">Chat</a>
				<!-- 회원전용 비회원 표시 X 회원 표시 O (장바구니, 마이페이지) -->
				<c:if test="${member.memId != null }">
				<div class="nav-item dropdown">
					<a href="#" class="nav-link dropdown-toggle active"
						data-bs-toggle="dropdown">My Pages</a>
					<div class="dropdown-menu m-0">
						<a href="myPage.jsp" class="dropdown-item">My Page</a> 
						<a href="myCart.do?memId=${member.memId }" class="dropdown-item">My Cart</a>
					</div>
				</div>
				</c:if>
			</div>
			<c:if test="${member.memId != null}">
			<a href="signOut.do"
				class="btn btn-primary rounded-0 py-2 px-lg-4 d-none d-lg-block">Sign Out
				<i class="fa fa-arrow-right ms-3"></i>
			</a>
			</c:if>
			<!-- 비회원 로그인/회원가입버튼  회원 로그인 후 로그아웃 버튼으로 변경-->
			<c:if test="${member.memId eq null}">
			<a href="signIn.jsp"
				class="btn btn-primary rounded-0 py-2 px-lg-4 d-none d-lg-block">Sign In/Sign
				Up<i class="fa fa-arrow-right ms-3"></i>
			</a>
			</c:if>
		</div>
	</nav>
</body>
</html>