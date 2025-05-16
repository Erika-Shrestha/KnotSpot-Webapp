<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
				<ul>
                  <li><a href="">Bookings</a></li>
                  <li><a href="">Bill & Payment</a></li>
                  <li><a href="">Account</a></li>
                  <li><a href="">Return & Refunds</a></li>
                  <li><a href="">Others</a></li>
                </ul>
                <div class="ques-ans">
                	<div class="ques">
                		<i class="fa-solid fa-circle-minus"></i>
                		<h1>How does the site work ?</h1>
                	</div>
                	<div class="ques">
                		<i class="fa-solid fa-circle-minus"></i>
                		<h1>Do you serve my area ?</h1>
                	</div>
                	<div class="ques">
                		<i class="fa-solid fa-circle-minus"></i>
                		<h1>What if the venue is unavailable ?</h1>
                	</div>
                	<div class="ques">
                		<i class="fa-solid fa-circle-minus"></i>
                		<h1>How do i refund after cancellation ?</h1>
                	</div>
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