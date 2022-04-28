<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<title>FYN - Cart</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="" name="keywords">
<meta content="" name="description">

<!-- Favicon -->
<link href="img/Favicon.ico" rel="icon">

<!-- Google Web Fonts -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500&family=Oswald:wght@600&display=swap"
	rel="stylesheet">

<!-- Icon Font Stylesheet -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css"
	rel="stylesheet">

<!-- Libraries Stylesheet -->
<link href="lib/animate/animate.min.css" rel="stylesheet">
<link href="lib/owlcarousel/assets/owl.carousel.min.css"
	rel="stylesheet">

<!-- Customized Bootstrap Stylesheet -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Template Stylesheet -->
<link href="css/style.css" rel="stylesheet">
</head>

<body>
	<!-- Spinner Start -->
	<div id="spinner"
		class="show bg-dark position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
		<div class="spinner-grow text-primary"
			style="width: 3rem; height: 3rem;" role="status">
			<span class="sr-only">Loading...</span>
		</div>
	</div>
	<!-- Spinner End -->


	<!-- Navbar Start -->
	<jsp:include page="common/navbar.jsp"></jsp:include>
	<!-- Navbar End -->


	<!-- Page Header Start -->
	<div class="container-fluid page-header py-5 mb-5 wow fadeIn"
		data-wow-delay="0.1s">
		<div class="container text-center py-5">
			<h1
				class="display-3 text-white text-uppercase mb-3 animated slideInDown">Your
				Cart</h1>
			<nav aria-label="breadcrumb animated slideInDown">
				<ol class="breadcrumb justify-content-center text-uppercase mb-0">
					<li class="breadcrumb-item"><a class="text-white"
						href="main.jsp">Home</a></li>
					<li class="breadcrumb-item"><a class="text-white">My
							Pages</a></li>
					<li class="breadcrumb-item text-primary active" aria-current="page">Cart</li>
				</ol>
			</nav>
		</div>
	</div>
	<!-- Page Header End -->


	<!-- Cart List Start -->
	<div class="container-xxl py-5">
		<div class="container">
			<div class="text-center mx-auto mb-5 wow fadeInUp"
				data-wow-delay="0.1s" style="max-width: 600px;">
				<p class="d-inline-block bg-secondary text-primary py-1 px-4">
					Cart</p>
				<h1 class="text-uppercase">${member.memName }'s  Cart</h1>
			</div>
			<div class="row g-4">
			<c:if test="${fn:length(cartDatas)==0}">
				<h1 class="text-uppercase" style=margin:center>Cart is Empty</h1>
			</c:if>
			<c:forEach var="cart" items="${cartDatas }">
				<div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.1s">

					<div
						class="service-item position-relative overflow-hidden bg-secondary d-flex h-100 p-5 ps-0">
						
							<div class="ps-4">
								<h3 class="text-uppercase mb-3">${cart.nftTitle }</h3>
								<p>PRICE : ${cart.nftPrice }</p>
								<a class="text-uppercase text-primary"
									href="purchaseCart.do?memId=${cart.memId }&nftId=${cart.nftId}">Purchase</a>
							</div>
							<a class="btn btn-square" href="nftDetail.do?nftId=${cart.nftId }">Details</a>
						
					</div>

				</div>
				</c:forEach>
			</div>
		</div>
	</div>
	<!-- Cart List End -->


	<!-- Footer Start -->
	<jsp:include page="common/footer.jsp"></jsp:include>
	<!-- Footer End -->


	<!-- Back to Top -->
	<a href="#" class="btn btn-primary btn-lg-square back-to-top"><i
		class="bi bi-arrow-up"></i></a>


	<!-- JavaScript Libraries -->
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
	<script src="lib/wow/wow.min.js"></script>
	<script src="lib/easing/easing.min.js"></script>
	<script src="lib/waypoints/waypoints.min.js"></script>
	<script src="lib/owlcarousel/owl.carousel.min.js"></script>

	<!-- Template Javascript -->
	<script src="js/main.js"></script>
</body>

</html>