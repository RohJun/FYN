<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<title>FYN - My Page</title>
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
				class="display-3 text-white text-uppercase mb-3 animated slideInDown">Our
				Barber</h1>
			<nav aria-label="breadcrumb animated slideInDown">
				<ol class="breadcrumb justify-content-center text-uppercase mb-0">
					<li class="breadcrumb-item"><a class="text-white"
						href="main.do">Home</a></li>
					<li class="breadcrumb-item"><a class="text-white">MY
							PAGES</a></li>
					<li class="breadcrumb-item text-primary active" aria-current="page">myPage</li>
				</ol>
			</nav>
		</div>
	</div>
	<!-- Page Header End -->


	<!-- Team Start -->
	<div class="container-fluid">
		<div class="row h-100 align-items-center justify-content-center"
			style="min-height: 100vh;">
			<div class="col-12 col-sm-8 col-md-6 col-lg-5 col-xl-4">
				<div class="bg-secondary rounded p-4 p-sm-5 my-4 mx-3">
					<div class="d-flex align-items-center justify-content-between mb-3">
						<a href="index.html" class="">
							<h3 class="text-primary">
								<i class="fa fa-user-edit me-2"></i>FYN
							</h3>
						</a>
						<h3>Your Information</h3>
					</div>
					<form action="updateMember.do" method="post">
						<div class="form-floating mb-3">
							<input type="text" class="form-control" id="floatingText"
								name="memId" placeholder="${member.memId }" value="${member.memId }" readonly style="background-color:#191c24"> 
								
								<label
								for="floatingText">ID</label>
						</div>

						<div class="form-floating mb-4">
							<input type="password" class="form-control" id="floatingPassword"
								name="memPassword" placeholder="Password" value="${member.memPassword }" style="background-color:#191c24"> <label
								for="floatingPassword">Password</label>
						</div>
						<div class="form-floating mb-3">
							<input type="text" class="form-control" id="floatingInput"
								name="memName" placeholder="name@example.com"value="${member.memName }" style="background-color:#191c24"> <label
								for="floatingInput">Name</label>
						</div>
						<div class="form-floating mb-3">
							<input type="email" class="form-control" id="floatingInput"
								name="memEmail" placeholder="name@example.com" value="${member.memEmail }" style="background-color:#191c24"> <label
								for="floatingInput">Email</label>
						</div>
						<div class="form-floating mb-3">
							<input type="text" class="form-control" id="floatingInput"
								name="memPhone" placeholder="name@example.com" value="${member.memPhone }" style="background-color:#191c24"> <label
								for="floatingInput">PhoneNumber</label>
						</div>
						<div class="form-floating mb-3">
							<input type="text" class="form-control" id="floatingInput"
								name="memMoney" placeholder="name@example.com" value="${member.memMoney }" style="background-color:#191c24"> <label
								for="floatingInput">Money</label>
						</div>
						<button type="submit" class="btn btn-primary py-3 w-50 mb-4">Update</button>
						<a class="btn btn-primary py-3 w-50 mb-4" href="deleteMember.do?memId=${member.memId }">Withdrawal</a>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- Team End -->


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