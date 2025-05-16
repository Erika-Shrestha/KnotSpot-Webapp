<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Knot spot</title>
<!-- This connects to swiper js file -->
<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.css">
<!-- This connects to home.css file -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/home.css">


<!-- This gives access to google font "inter" -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Inter:wght@100..900&family=JetBrains+Mono:ital,wght@0,100..800;1,100..800&family=Roboto:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" >
<link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">

<!-- This gives access to font awesome icons -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">

</head>
<body>
	<header class="header-con">
		<%@ include file="header.jsp" %>
	</header>
	<main class="container">
		<section class="video-scroll-section">
			<div class="scroll-container">
				<video preload="metadata" id="scrollVideo" playsinline>
					<source src="${pageContext.request.contextPath}/resources/homepge.mp4" type="video/mp4">
				</video>
			</div>
			<div class="scroll-down">
				<p>Scroll down</p>
				<i class="fa-solid fa-computer-mouse"></i>
			</div>
			<div class="blur-con">
				<h1 class="blurShow one">Where</h1>
				<h1 class="blurShow two">Every</h1>
				<h1 class="blurShow three">Knot</h1>
				<h1 class="blurShow four">Ties A</h1>
				<h1 class="blurShow five">Beautiful</h1>
				<h1 class="blurShow six">Memories</h1>
			</div>
			<div class="intro-con">
				<h1 class="autoShow"><span>This is not just an ordinary event planners</span>
				<span class="paragraph-span">Since 2020,  Knot spot has blended tradition and innovations to serve our customers with unique experience. 
				Guided by “Wed me good” we offer luxurious service, and Nepal's signature warmth for a truly memorable wedding experience.</span></h1>
				<button class="about-us-btn">Know more</button>
			</div>
			<div class="img-box">
				<img src="${pageContext.request.contextPath}/resources/companybatch.png" class="autoRotate rotate">
			</div>
		</section>
		<div class="space"></div>
		<section class="recommend-con">
			<div class="line"></div>
			<div class="card one">
				<div class="image-wrapper">
					<img src="${pageContext.request.contextPath}/resources/cat-one.jpg" alt="test_image">
				</div>
				<div class="rec-desc one" data-index="1">
					<h1>Most Visited Ones</h1>
					<p>Get to our most loved venues</p>
				</div>
				<button class="view-btn one">View</button>
			</div>
			<div class="card two">
				<div class="image-wrapper">
					<img src="${pageContext.request.contextPath}/resources/cat-two.jpg" alt="test_image">
				</div>
				<div class="rec-desc two" data-index="2">
					<h1>Most Visited Ones</h1>
					<p>Get to our most loved venues</p>
				</div>
				<button class="view-btn two">View</button>
			</div>
			<div class="card three">
				<div class="image-wrapper">
					<img src="${pageContext.request.contextPath}/resources/cat-three.jpg" alt="test_image">
				</div>
				<div class="rec-desc three" data-index="3">
					<h1>Most Visited Ones</h1>
					<p>Get to our most loved venues</p>
				</div>
				<button class="view-btn three">View</button>
			</div>
		</section>
		<div class="space"></div>
		<section class="venue-con">
			<div class="venue-con-title">
				<h1>Featured Products</h1>
				<button class="view-all-btn">View All</button>
			</div>
			<div class="container swiper">
				<div class="slider-wrapper">
					<div class="card-list swiper-wrapper">
					<c:forEach var="venue" items="${listVenue}">
						<div class="card-item swiper-slide">
							<img src="${pageContext.request.contextPath}/resources/${venue.venuePic}" alt="test_image" class="venue-img">
							<h2 class="venue-name">${venue.name}</h2>
							<p class="venue-desc">${venue.amenities}</p>
							<button class="venue-button">View</button>
						</div>
					</c:forEach>
					</div>
					<div class="swiper-pagination"></div>
					<div class="swiper-slide-button swiper-button-prev"></div>
  					<div class="swiper-slide-button swiper-button-next"></div>
				</div>
			</div>
		</section>
		<section class="blog-con">
			<div class="blog-heading">
				<h1><span>Browse</span> and <span>Read</span></h1>
				<h2>Latest <span>Stuff</span></h2>
			</div>
			<div class="blog-container">
				<div class="blog-card">
					<article class="blog-article">
						<img src="${pageContext.request.contextPath}/resources/blogthree.jpg" alt="test_image" class="blog-img">
						<div class="blog-data">
							<span class="blog-description">Top Religious Weddings in the History with Luxurious Venues</span>
							<h2 class="blog-title">Worldwide Weddings</h2>
							<a href="#" class="blog-btn">Read More</a>
						</div>
					</article>
					
					<article class="blog-article mid">
						<img src="${pageContext.request.contextPath}/resources/blogone.png" alt="test_image" class="blog-img">
						<div class="blog-data">
							<span class="blog-description">Top Religious Weddings in the History with Luxurious Venues</span>
							<h2 class="blog-title">Worldwide Weddings</h2>
							<a href="#" class="blog-btn">Read More</a>
						</div>
					</article>
					
					<article class="blog-article">
						<img src="${pageContext.request.contextPath}/resources/blogfour.jpg" alt="test_image" class="blog-img">
						<div class="blog-data">
							<span class="blog-description">Top Religious Weddings in the History with Luxurious Venues</span>
							<h2 class="blog-title">Worldwide weddings</h2>
							<a href="#" class="blog-btn">Read More</a>
						</div>
					</article>
				</div>
			</div>
		</section>
	</main>
	<footer>
		<%@ include file="footer.jsp" %>
	</footer>
	<!-- This connects to swiper js javascript -->
	<script src="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/javascript/home.js"></script>
</body>
</html>