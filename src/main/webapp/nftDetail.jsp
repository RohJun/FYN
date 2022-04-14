<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<title>FYN - nftDetail</title>
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
				class="display-3 text-white text-uppercase mb-3 animated slideInDown">NFT's
				Title</h1>
			<nav aria-label="breadcrumb animated slideInDown">
				<ol class="breadcrumb justify-content-center text-uppercase mb-0">
					<li class="breadcrumb-item"><a class="text-white"
						href="main.do">Home</a></li>
					<li class="breadcrumb-item text-primary active" aria-current="page">NFT
						Details</li>
				</ol>
			</nav>
		</div>
	</div>
	<!-- Page Header End -->


	<!-- NFT Detail Start -->
	<div class="container-xxl py-5">
		<div class="container">
			<div class="row g-0">
				<div class="col-lg-6 wow fadeIn" data-wow-delay="0.1s">
					<div class="h-100">
						<img class="img-fluid h-100" src="${nftData.nftPic}" alt="">
					</div>
				</div>
				<div class="col-lg-6 wow fadeIn" data-wow-delay="0.5s">
					<div
						class="bg-secondary h-100 d-flex flex-column justify-content-center p-5">
						<p class="d-inline-flex bg-dark text-primary py-1 px-4 me-auto">Our
							Product</p>
						<h1 class="text-uppercase mb-4">${nftData.nftTitle }</h1>
						<div>
							<div class="d-flex justify-content-between border-bottom py-2">
								<h6 class="text-uppercase mb-0">Updated</h6>
								<span class="text-uppercase">${nftData.nftRegDate}</span>
							</div>
							<div class="d-flex justify-content-between border-bottom py-2">
								<h6 class="text-uppercase mb-0">Price</h6>
								<span class="text-uppercase">${nftData.nftPrice}</span>
							</div>
							<c:if test="${nftData.nftStatus==0 }">
								<div class="d-flex justify-content-between py-2">
									<h6 class="text-uppercase mb-0"></h6>
									<a class="text-uppercase text-primary"
										href="purchaseMember.do?memId=${member.memId }&purchasePrice=${nftData.nftPrice}&nftId=${nftData.nftId}">Purchase</a>
								</div>
								<div class="d-flex justify-content-between py-2">
									<h6 class="text-uppercase mb-0"></h6>
									<form action="addCart.do" method="post">
										<input type="hidden" name="memId" value=${member.memId }>
										<input type="hidden" name="memName" value=${member.memName }>
										<input type="hidden" name="nftId" value=${nftData.nftId }>
										<input type="hidden" name="nftTitle"
											value=${nftData.nftTitle }> <input type="hidden"
											name="nftPrice" value=${nftData.nftPrice }> <input
											type="submit" class="text-uppercase text-primary"
											style="background-color: #191c24;" value="Add Cart"></input>
									</form>
								</div>
							</c:if>

							<c:if test="${nftData.nftStatus==1 }">
								<div class="d-flex justify-content-between py-2">
									<h6 class="text-uppercase mb-0"></h6>
									<a class="text-uppercase text-primary">SOLD</a>
								</div>
							</c:if>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- NFT Detail End -->
	<!-- REply Start -->
	<div class="container-xxl py-5">
		<div class="container">
			<div class="text-center mx-auto mb-5 wow fadeInUp"
				data-wow-delay="0.1s" style="max-width: 600px;">
				<p class="d-inline-block bg-secondary text-primary py-1 px-4">Comments</p>
				<h1 class="text-uppercase">What Our Clients Say!</h1>
			</div>
			<div class="owl-carousel testimonial-carousel wow fadeInUp"
				data-wow-delay="0.1s">
				<c:forEach var="reply" items="${replyDatas}">
					<div class="testimonial-item text-center"
						data-dot="<img class='img-fluid' src='img/testimonial-1.jpg' alt=''>">
						<h4 class="text-uppercase">Comment By : ${reply.memName}</h4>
						<p class="text-primary">Title : ${reply.repTitle }</p>
						<span class="fs-5"> ${reply.repContent }</span>
						<p class="text-primary">Upload Date : ${reply.repRegDate }</p>

					</div>
					
				</c:forEach>
			</div>
		</div>
	</div>
	<!-- Reply End -->
	<!-- Write Reply Start -->
	<c:if test="${member.memId != null}">
		<div class="container-xxl py-5">
			<div class="container">
				<div class="text-center mx-auto mb-5 wow fadeInUp"
					data-wow-delay="0.1s" style="max-width: 600px;">
					<p class="d-inline-block bg-secondary text-primary py-1 px-4">Comments</p>
					<h1 class="text-uppercase">Write Your Own Comment</h1>
				</div>

				<form method="post" action="addReply.do">
					<input type="hidden" name="memId" value="${member.memId}">
					<input type="hidden" name="memName" value="${member.memName }">
					<input type="hidden" name="nftId" value="${nftData.nftId }">
					<div class="row g-3">
						<div class="col-md-6">
							<div class="form-floating">
								<input type="text" class="form-control bg-transparent"
									id="repTitle" placeholder="Title" name="repTitle"> <label
									for="repTitle">Title</label>
							</div>
						</div>
						<div class="col-12">
							<div class="form-floating">
								<textarea class="form-control bg-transparent"
									placeholder="Leave a message here" id="message"
									style="height: 100px" name="repContent"></textarea>
								<label for="message">Content</label>
							</div>
						</div>
						<div class="col-12">
							<input class="btn btn-primary w-100 py-3" type="submit"
								value="Submit"></input>
						</div>
					</div>
				</form>
			</div>
		</div>
	</c:if>
	<!-- Reply End -->




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