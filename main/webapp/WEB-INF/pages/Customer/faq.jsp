<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Knot spot</title>
<!-- This connects to dashboard.css file -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/faq.css">

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
	<main class="faq-main-con">
		<div class="top-con">
			<h2>Help Center</h2>
			<h1>Customer Care</h1>
			<div class="search-con">
				<input type="text" placeholder="How can we help you?">
				<i class="fa-solid fa-magnifying-glass"></i>
			</div>
		</div>
		<div class="ques-con">
				<ul class="heading-ul">
                  <li><a href="">Bookings</a></li>
                  <li><a href="">Bill & Payment</a></li>
                  <li><a href="">Account</a></li>
                  <li><a href="">Return & Refunds</a></li>
                  <li><a href="">Others</a></li>
                </ul>
                <div class="ques-ans">
                	<ul class="accordion">
                		<li>
                			<input type="radio" name="accordion" id="first" checked>
                			<label for="first">How does the site work ?</label>
                			<div class="content">
                				<p>Knot Spot allows users to browse, book, and manage venue reservations for events. You can search venues by location, date, and type of event.</p>
                			</div>
                		</li>
                		<li>
                			<input type="radio" name="accordion" id="second">
                			<label for="second">Do you serve my area ?</label>
                			<div class="content">
                				<p>We currently serve major cities and nearby regions. Enter your city in the search bar to see available venues in your area.</p>
                			</div>
                		</li>
                		<li>
                			<input type="radio" name="accordion" id="third">
                			<label for="third">What if the venue is unavailable ?</label>
                			<div class="content">
                				<p>If a venue is booked or unavailable, our system will suggest other venues with similar features and capacity on your chosen date.</p>
                			</div>
                		</li>
                		<li>
                			<input type="radio" name="accordion" id="fourth">
                			<label for="fourth">Can I change my booking date?</label>
                			<div class="content">
                				<p>Refunds can be requested through sending emails with proper screenshot. Once a cancellation is confirmed, refunds are processed within 5–7 business days.</p>
                			</div>
                		</li>
                		<li>
                			<input type="radio" name="accordion" id="fifth">
                			<label for="fifth">How does the site work ?</label>
                			<div class="content">
                				<p>Yes, you can change your booking date from your account. Just go to 'My Bookings' and choose a new date.</p>
                			</div>
                		</li>
                	</ul>
                </div>
		</div>
		 <div class="bottom-con">
            <h1>Still Have A Question ?</h1>
            <p>Can’t find the answer you are looking for ? Please chat to our friendly team.</p>
            <button class="go-info-btn" type="submit" class="btn">Get In Touch</button>
         </div>
	</main>
	<footer>
		<%@ include file="footer.jsp" %>
	</footer>
</body>
</html>