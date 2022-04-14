<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<title>FYN - Admin</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="" name="keywords">
<meta content="" name="description">

<!-- Favicon -->
<link href="img/Favicon.ico" rel="icon">

<!-- Google Web Fonts -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600&family=Roboto:wght@500;700&display=swap"
	rel="stylesheet">

<!-- Icon Font Stylesheet -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css"
	rel="stylesheet">

<!-- Libraries Stylesheet -->
<link href="admin_lib/owlcarousel/assets/owl.carousel.min.css"
	rel="stylesheet">
<link
	href="admin_lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css"
	rel="stylesheet" />

<!-- Customized Bootstrap Stylesheet -->
<link href="admin_css/bootstrap.min.css" rel="stylesheet">

<!-- Template Stylesheet -->
<link href="admin_css/style.css" rel="stylesheet">
</head>

<body>
	<div class="container-fluid position-relative d-flex p-0">
		<!-- Spinner Start -->
		<div id="spinner"
			class="show bg-dark position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
			<div class="spinner-border text-primary"
				style="width: 3rem; height: 3rem;" role="status">
				<span class="sr-only">Loading...</span>
			</div>
		</div>
		<!-- Spinner End -->


		<!-- Sidebar Start -->
		<jsp:include page="admin_common/sidebar.jsp"></jsp:include>
		<!-- Sidebar End -->


		<!-- Content Start -->
		<div class="content">
			<!-- Navbar Start -->
			<nav
				class="navbar navbar-expand bg-secondary navbar-dark sticky-top px-4 py-0">
				<a href="adminMain.do" class="navbar-brand d-flex d-lg-none me-4">
					<h2 class="text-primary mb-0">
						<i class="fa fa-user-edit"></i>
					</h2>
				</a> <a href="#" class="sidebar-toggler flex-shrink-0"> <i
					class="fa fa-bars"></i>
				</a>
				<form class="d-none d-md-flex ms-4" method="post"
					action="adminSearch.do">
					<input class="form-control bg-dark border-0" type="search"
						placeholder="Search" name="searchText">
				</form>
				<div class="navbar-nav align-items-center ms-auto">

					<div class="nav-item dropdown">
						<a href="#" class="nav-link dropdown-toggle"
							data-bs-toggle="dropdown"> <i class="fa fa-bell me-lg-2"></i>
							<span class="d-none d-lg-inline-flex">Notifications</span>
						</a>
						<div
							class="dropdown-menu dropdown-menu-end bg-secondary border-0 rounded-0 rounded-bottom m-0">
							<a href="#" class="dropdown-item">
								<h6 class="fw-normal mb-0">Profile updated</h6> <small>15
									minutes ago</small>
							</a>
							<hr class="dropdown-divider">
							<a href="#" class="dropdown-item">
								<h6 class="fw-normal mb-0">New user added</h6> <small>15
									minutes ago</small>
							</a>
							<hr class="dropdown-divider">
							<a href="#" class="dropdown-item">
								<h6 class="fw-normal mb-0">Password changed</h6> <small>15
									minutes ago</small>
							</a>
							<hr class="dropdown-divider">
							<a href="#" class="dropdown-item text-center">See all
								notifications</a>
						</div>
					</div>
				</div>
			</nav>
			<!-- Navbar End -->


			<!-- FYN # Check Start -->
			<div class="container-fluid pt-4 px-4">
				<div class="row g-4">
					<div class="col-sm-6 col-xl-3">
						<div
							class="bg-secondary rounded d-flex align-items-center justify-content-between p-4">
							<i class="fa fa-user-group fa-3x text-primary"></i>
							<div class="ms-3">
								<p class="mb-2">Member #</p>
								<h6 class="mb-0">${fn:length(memDatas)}</h6>
							</div>
						</div>
					</div>
					<div class="col-sm-6 col-xl-3">
						<div
							class="bg-secondary rounded d-flex align-items-center justify-content-between p-4">
							<i class="fa fa-layer-group fa-3x text-primary"></i>
							<div class="ms-3">
								<p class="mb-2">NFT #</p>
								<h6 class="mb-0">${fn:length(nftDatas)}</h6>
							</div>
						</div>
					</div>
					<div class="col-sm-6 col-xl-3">
						<div
							class="bg-secondary rounded d-flex align-items-center justify-content-between p-4">
							<i class="fa fa-clipboard fa-3x text-primary"></i>
							<div class="ms-3">
								<p class="mb-2">Notice #</p>
								<h6 class="mb-0">${fn:length(notDatas)}</h6>
							</div>
						</div>
					</div>
					<div class="col-sm-6 col-xl-3">
						<div
							class="bg-secondary rounded d-flex align-items-center justify-content-between p-4">
							<i class="fa fa-comments fa-3x text-primary"></i>
							<div class="ms-3">
								<p class="mb-2">Reply #</p>
								<h6 class="mb-0">${fn:length(repDatas)}</h6>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- FYN # Check End -->


			<!-- Write Notice & Write NFT Start -->
			<div class="container-fluid pt-4 px-4">
				<div class="row g-4">
					<!-- Notice -->
					<div class="col-sm-12 col-xl-6">
						<div class="bg-secondary rounded h-100 p-4">
							<form action="adminInsertNotice.do" method="post">
								<h6 class="mb-4">New Notice</h6>
								<div class="form-floating mb-3">
									<input type="text" class="form-control" id="floatingInput"
										placeholder="Notice Title" name="notTitle"> <label
										for="floatingInput">Notice Title</label>
								</div>


								<div class="form-floating">
									<textarea class="form-control"
										placeholder="Leave a comment here" id="floatingTextarea"
										style="height: 150px;" name="notContent"></textarea>
									<label for="floatingTextarea">Content</label>
								</div>
								<button type="submit" class="btn btn-outline-primary m-2"
									style="align: right">Submit</button>
							</form>
						</div>

					</div>
					<!-- NFT -->
					<div class="col-sm-12 col-xl-6">
						<div class="bg-secondary rounded h-100 p-4">
							<form action="adminInsertNft.do" method="post" enctype="multipart/form-data">
								<h6 class="mb-4">New NFT</h6>
								<div class="form-floating mb-3">
									<input type="text" class="form-control" id="floatingInput"
										placeholder="Title" name="nftTitle"> <label for="floatingInput">NFT
										Title</label>
								</div>


								<div class="form-floating mb-3">
									<input type="text" class="form-control" id="floatingInput"
										placeholder="Title" name="nftPrice"> <label for="floatingInput">NFT
										Price</label>
								</div>
								<div class="mb-3">
									<label for="formFileSm" class="form-label">NFT Pic</label> <input
										class="form-control form-control-sm bg-dark" id="formFileSm"
										type="file" name="uploadFile">
								</div>
								<input type="submit" class="btn btn-outline-primary m-2" value="Submit">
							</form>
						</div>
					</div>
				</div>

			</div>
			<!-- Write Notice End -->





			<!-- Footer Start -->
			<jsp:include page="admin_common/footer.jsp"></jsp:include>
			<!-- Footer End -->
		</div>
		<!-- Content End -->


		<!-- Back to Top -->
		<a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i
			class="bi bi-arrow-up"></i></a>
	</div>

	<!-- JavaScript Libraries -->
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
	<script src="admin_lib/chart/chart.min.js"></script>
	<script src="admin_lib/easing/easing.min.js"></script>
	<script src="admin_lib/waypoints/waypoints.min.js"></script>
	<script src="admin_lib/owlcarousel/owl.carousel.min.js"></script>
	<script src="admin_lib/tempusdominus/js/moment.min.js"></script>
	<script src="admin_lib/tempusdominus/js/moment-timezone.min.js"></script>
	<script
		src="admin_lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js"></script>

	<!-- Template Javascript -->
	<script src="admin_js/main.js"></script>
</body>

</html>