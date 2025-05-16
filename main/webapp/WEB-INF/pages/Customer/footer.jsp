<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<!-- This connects to dashboard.css file -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/footer.css">

<!-- This gives access to google font "inter" -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Inter:wght@100..900&family=JetBrains+Mono:ital,wght@0,100..800;1,100..800&family=Roboto:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">

<!-- This gives access to font awesome icons -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">

</head>
<body>
		<div class="footer">
			<div class="banner">
				<div class="group">
					<div class="text">
						<i class="fa-solid fa-circle"></i>
						<p>Our Company</p>
						<i class="fa-solid fa-circle"></i>
						<p>Join Our Community</p>
						<i class="fa-solid fa-circle"></i>
						<p>Documentation</p>
						<i class="fa-solid fa-circle"></i>
						<p>Newsletter</p>
						<i class="fa-solid fa-circle"></i>
						<p>How It Works</p>
						<i class="fa-solid fa-circle"></i>
						<p>Book Our Spot</p>
					</div>
					
					<div class=" text text2">
						<i class="fa-solid fa-circle"></i>
						<p>Our Company</p>
						<i class="fa-solid fa-circle"></i>
						<p>Join Our Community</p>
						<i class="fa-solid fa-circle"></i>
						<p>Documentation</p>
						<i class="fa-solid fa-circle"></i>
						<p>Newsletter</p>
						<i class="fa-solid fa-circle"></i>
						<p>How It Works</p>
						<i class="fa-solid fa-circle"></i>
						<p>Book Our Spot</p>
					</div>
				</div>
			</div>
			<div class="element-con">
				<div class="redirect-con">
					<div class="service-con">
						<div class="category-one">
							<h1>Company</h1>
							<ul>
								<li><a href="${pageContext.request.contextPath}/product">Products</a></li>
								<li><a href="${pageContext.request.contextPath}/blog">Blog</a></li>
								<li><a href="${pageContext.request.contextPath}/aboutUs">About Us</a></li>
							</ul>
						</div>
						<div class="category-two">
							<h1>Service</h1>
							<ul>
								<li><a href="${pageContext.request.contextPath}/contactUs">Contact Us</a></li>
								<li><a href="${pageContext.request.contextPath}/faq">FAQ</a></li>
							</ul>
						</div>
					</div>
					<div class="newsletter-con">
						<h1>Join Our Newsletter</h1>
                        <form class="footer-email-form" name="messageForm" onsubmit="validateForm()">

                            <input type="text" id="email" name="email" placeholder="Enter your email" required maxlength="50">
                            <button onclick="validateForm()">
                                <h2>Subscribe</h2>
                            </button>
                        </form>
					</div>
					<div class="map-con">
					<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3532.311687189527!2d85.3226614748013!3d27.70766122547878!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x39eb1908434cb3c5%3A0x1fdf1a6d41d2512d!2sIslington%20College!5e0!3m2!1sen!2snp!4v1739196956646!5m2!1sen!2snp" width="325" height="130" style="border:0; margin-top: 1rem;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
					</div>
				</div>
				<div class="social-con">
					<div class="app-con">
						<ul>
							<li><i class="fa-brands fa-facebook"></i></li>
							<li><i class="fa-brands fa-instagram"></i></li>
							<li><i class="fa-brands fa-twitter"></i></li>
							<li><i class="fa-brands fa-youtube"></i></li>
						</ul>
					</div>
					<div class="notice-con">
						<ul>
							<li>Terms</li>
							<li>Privacy</li>
							<li>Cookies</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
</body>
</html>