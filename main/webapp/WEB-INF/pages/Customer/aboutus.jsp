<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- This connects to dashboard.css file -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/aboutus.css">

<!-- This gives access to google font "inter" -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Inter:wght@100..900&family=JetBrains+Mono:ital,wght@0,100..800;1,100..800&family=Roboto:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">

<!-- This gives access to font awesome icons -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
</head>
<body>
<header>
		<%@ include file="header.jsp" %>
	</header>
	<main class="about-main-container">
		<div class="top-div">
			<div class="sub-div-one">
				<h1>About</h1>
				<h2>Us</h2>
				<div class="first-img-con">
					<img class="venue-one" src="${pageContext.request.contextPath}/resources/aboutonevenue.jpg" alt="first-venue-image">
				</div>
			</div>
			<div class="sub-div-two">
				<div class="sec-img-con">
					<img class="venue-one" src="${pageContext.request.contextPath}/resources/abouttwovenue.jpg" alt="second-venue-image">
				</div>
				<div class="desc-div">
					<h1>Discover our journey</h1>
					<p>Founded in 2024 by Erika Shrestha, knotspot launched their first batch on the guiding principle of fostering 
					equitable opportunities in Nepal's labor market.</p>
				</div>
			</div>
		</div>
		<div class="mid-div">
		<p>More&nbsp;&nbsp;&nbsp;than&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="span-text" data-val="2000">0</span>customers&nbsp;&nbsp;&nbsp;served&nbsp;&nbsp;&nbsp;since&nbsp;&nbsp;&nbsp;2024&nbsp;&nbsp;&nbsp;</p>
		</div>
		<div class="bottom-div">
			<div class="mission-div">
				<div class="mission-img-con">
					<div class="mission-img">
						<img class="img-one" src="${pageContext.request.contextPath}/resources/missionimg.jpg" alt="third-venue-image">
					</div>
				</div>
				<div class="mission-txt">
					<h1>Our Mission</h1>
					<p>Our mission is to provide a budget friendly wedding experience to our customers through luxurious spaces.</p>
				</div>
			</div>
			<div class="vision-div">
				<div class="vision-txt">
					<h1>Our Vision</h1>
					<p>Our vision is to be a leading digital platform in the event industry through innovation, reliability and exceptional user experience.</p>
				</div>
				<div class="vision-img-con">
					<div class="vision-img">
						<img class="img-two" src="${pageContext.request.contextPath}/resources/visionimg.jpg" alt="fourth-venue-image">
					</div>
				</div>
			</div>
		</div>
	</main>
	<footer>
		<%@ include file="footer.jsp" %>
	</footer>
	
	<!-- This connects to dashboard.js file -->
<script type="text/javascript" src="${pageContext.request.contextPath}/javascript/aboutus.js"></script>
</body>
</body>
</html>