<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- This connects to contact.css file -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/contactus.css">

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
	<main class="main-container">
		<div class="description-con">
			<div class="all-head-con">
			<h1>Contact Us</h1>
			<h2>Email, call number, or complete the form for <br>inquiry</h2>
			<h3>info@knotspot.io</h3>
			<h4>977+ 9823733980</h4>
			</div>
			<div class="all-paragraph-con">
				<div class="customer-service">
					<h1>Customer Service</h1>
					<p>Our customer is our top priority<br> whom we support 24/7 through<br> our helpline.</p>
				</div>
				<div class="Feedback-sugg">
					<h1>Feedback And Suggestions</h1>
					<p>We are always open to your reviews for our wish to improve and grow more.</p>
				</div>
			</div>
		</div>
		<div class="input-con">
			<div class="input-form">
				<form class="contact-form">
					<h1>Get in Touch</h1>
					<h2>You can reach us anytime</h2>
					<div class="side-to-side-input">
						<div class="input-box">
						<input type="text" placeholder="First name*" required>
						<i class="fa-solid fa-user"></i>
						</div>
						<div class="add-input-box">
						<i class="fa-solid fa-plus"></i>
						</div>
						<div class="input-box">
						<input type="text" placeholder="Last name*" required>
						<i class="fa-solid fa-user"></i>
						</div>
					</div>
					<div class="up-down-input">
						<div class="input-box">
						<input type="email" placeholder="Email*" required>
						<i class="fa-solid fa-envelope"></i>
						</div>
						<div class="input-box">
						<input type="tel" placeholder="Contact name*" required>
						<i class="fa-solid fa-phone"></i>
						</div>
						<div class="area-box">
						<textarea name="message" rows="6" placeholder="How can we help you..." required></textarea>
						</div>
					</div>
					<button class="info-button" type="submit" class="btn">Submit</button>
				</form>
			</div>
		</div>
	</main>
	<footer>
		<%@ include file="footer.jsp" %>
	</footer>
</body>
</html>