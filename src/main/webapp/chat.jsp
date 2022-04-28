<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
				CHAT</h1>
			<nav aria-label="breadcrumb animated slideInDown">
				<ol class="breadcrumb justify-content-center text-uppercase mb-0">
					<li class="breadcrumb-item"><a class="text-white"
						href="main.jsp">Home</a></li>
					<li class="breadcrumb-item text-primary active" aria-current="page">Chat</li>
				</ol>
			</nav>
		</div>
	</div>
	<!-- Page Header End -->


	<!-- Chat  Start -->
	 <div class="bg-secondary text-center p-4">

        <button type="button" class="btn btn-outline-primary m-2" onclick="openSocket();">JOIN CHAT</button>
        <button type="button" class="btn btn-outline-primary m-2" onclick="closeSocket();">LEAVE CHAT</button>
    	<br/><br/><br/>
  		Your Message :  
        <input type="text" class="form-control" id="sender" value="${member.memId}" style="display: none;">
        <input type="text" class="form-control bg-transparent" id="messageinput">
        <button type="button" class="btn btn-outline-danger m-2" onclick="send();">SEND</button>
        
        <!-- <button type="button" onclick="javascript:clearText();">대화내용 지우기</button> -->
    </div>
    <!-- Server responses get written here -->
    <div class="bg-secondary text-left p-4" style=text-align:left>
    <div id="messages">
    </div>
    </div>
    <!-- websocket javascript -->
    <script type="text/javascript">
        var ws;
        var messages = document.getElementById("messages");
        
        function openSocket(){
            if(ws !== undefined && ws.readyState !== WebSocket.CLOSED ){
                writeResponse("WebSocket is already opened.");
                return;
            }
            //웹소켓 객체 만드는 코드
            //ws+내 프로젝트 host port 경로
            ws = new WebSocket("ws://localhost:8081/fyn/echo.do");
            
            //웹소켓 연결
            ws.onopen = function(event){
                if(event.data === undefined){
              		return;
                }
                writeResponse(event.data);
            };
            
            //메세지 전송
            ws.onmessage = function(event){
                console.log('writeResponse');
                console.log(event.data)
                writeResponse(event.data);
            };
            
            //웹소켓 끊기
            ws.onclose = function(event){
                writeResponse("LEAVE CHAT");
            }
            
        }
        
        function send(){
            var text = document.getElementById("messageinput").value+","+document.getElementById("sender").value;
            ws.send(text);
            text = "";
        }
        
        function closeSocket(){
            ws.close();
        }
        
        function writeResponse(text){
        	
            messages.innerHTML += "<br/>"+text;
        }

        function clearText(){
            console.log(messages.parentNode);
            messages.parentNode.removeChild(messages)
      	}
        
  </script>

	<!-- Chat  End -->


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