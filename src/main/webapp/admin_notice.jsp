<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<title>FYN - Admin Notices</title>
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
				<a href="index.html" class="navbar-brand d-flex d-lg-none me-4">
					<h2 class="text-primary mb-0">
						<i class="fa fa-user-edit"></i>
					</h2>
				</a> <a href="#" class="sidebar-toggler flex-shrink-0"> <i
					class="fa fa-bars"></i>
				</a>
				<form class="d-none d-md-flex ms-4">
					<input class="form-control bg-dark border-0" type="search"
						placeholder="Search">
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


			
			<div class="container-fluid pt-4 px-4">
				<div class="row g-4">
					<div class="col-sm-12 col-xl-6" style="width: 100%">
						<div class="bg-secondary rounded h-100 p-4">
							<h6 class="mb-4">FYN - Notices</h6>
							<c:forEach var="notice" items="${noticeDatas}">
							<div class="accordion accordion-flush" id="accordionFlushExample">
								
									<div class="accordion-item bg-transparent">
										<h2 class="accordion-header" id="headingOne">
											<button class="accordion-button" type="button" data-bs-toggle="collapse"
                                            data-bs-target="#collapseOne" aria-expanded="false"
                                            aria-controls="collapseOne">${notice.notTitle}</button>
										
										</h2>
										<div id="collapseOne" class="accordion-collapse collapse show"
                                        aria-labelledby="headingOne" data-bs-parent="#accordionExample">
                                        <div class="accordion-body">${notice.notContent}<br><small>Upload Date : ${notice.notRegDate }</small></div>
										</div>
									</div>
							</div>
							</c:forEach>
						</div>
					</div>




				</div>
			</div>


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