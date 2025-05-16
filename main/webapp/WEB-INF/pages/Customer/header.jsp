<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- This connects to dashboard.css file -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/header.css">

<!-- This connects to dashboard.js file -->
<script type="text/javascript" src="${pageContext.request.contextPath}/javascript/header.js"></script>

<!-- This gives access to google font "inter" -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Inter:wght@100..900&family=JetBrains+Mono:ital,wght@0,100..800;1,100..800&family=Roboto:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">

<!-- This gives access to font awesome icons -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">

</head>
<body>
		<div class="header sticky">
			<div class="company-con">
			
				<div class="smalltab">
	                <input type="checkbox" id="check">
	                <label for="check">
	                    <i class="fa fa-bars" id="btn"></i>
	                    <i class="fas fa-times" id="cancel"></i>
	                </label>
	                <div class="div-sidebar">
	                    <ul class="sidebar-lists">
	                        <li class="side-menu-col">TYPES</li>
	                        <li><a href="${pageContext.request.contextPath}/product">Banquet Hall</a></li>
	                        <li><a href="${pageContext.request.contextPath}/product">Conference Room</a></li>
	                        <li><a href="${pageContext.request.contextPath}/product">Outdoor Seatings</a></li>
	                        <li><a href="${pageContext.request.contextPath}/product">Ballroom</a></li>
	                        <li><a href="${pageContext.request.contextPath}/product">Resort/Hotel</a></li>
	                        <li class="side-menu-col">NEW COLLECTION</li>
	                        <li><a href="${pageContext.request.contextPath}/product">Spring Collection</a></li>
	                        <li><a href="${pageContext.request.contextPath}/product">Autumn Collection</a></li>
	                        <li class="html-pages-lists top"><a href="${pageContext.request.contextPath}/blog">Blog</a></li>
	                        <li class="html-pages-lists"><a href="${pageContext.request.contextPath}/aboutUs">Our Journey</a></li>
	                        <li class="html-pages-lists"><a href="${pageContext.request.contextPath}/contactUs">Contact Us</a></li>
	                        <li class="html-pages-lists"><a href="${pageContext.request.contextPath}/faq">FAQs</a></li>
	            
	                    </ul>
	                </div>
	            </div>
				<div class="company-name">
					<img src="${pageContext.request.contextPath}/resources/companyicon.png" alt="company-logo" class="company-logo">
				</div>
			</div>
			<div class="navigation">
				<ul>
                  <li><a href="${pageContext.request.contextPath}/home">Home</a></li>
                  <li><a href="${pageContext.request.contextPath}/product">Product</a></li>
                  <li><a href="${pageContext.request.contextPath}/blog">Blog</a></li>
                  <li><a href="${pageContext.request.contextPath}/aboutUs">About us</a></li>
                  <li><a href="${pageContext.request.contextPath}/contactUs">Contact us</a></li>
                  <li><a href="${pageContext.request.contextPath}/faq">FAQ</a></li>
                </ul>
			</div>
			<nav>
			<div class="user-con">
				<a href="" class="favorite-icon"><i class="fa-regular fa-heart"></i></a>
				<!-- The image is to display the pop up message -->
				<img src="${pageContext.request.contextPath}/resources/${userModel.profilePic}" alt="user-profile" class="user-pic" onclick="toggleMenu()">
				
				<!-- This is pop-up wrapper to display user-profile -->
				<div class="menu-container" id="menu">
				<div class="menu">
				<div class="user-info">
				<img src="${pageContext.request.contextPath}/resources/${userModel.profilePic}" alt="user-profile">
				<h2>${userModel.firstName} ${userModel.lastName}</h2>
				</div>
				<hr>
				
				<a href="${pageContext.request.contextPath}/profile" class="menu-link">
				<i class="fa-solid fa-user"></i>
				<p>Edit Profile</p>
				<span>></span>
				</a>
				
				<a href="#" class="menu-link">
				<i class="fa-solid fa-gears"></i>
				<p>Settings & Privacy</p>
				<span>></span>
				</a>
				
				<a href="#" class="menu-link">
				<i class="fa-solid fa-circle-question"></i>
				<p>Help & Support</p>
				<span>></span>
				</a>
				
				<form action="${pageContext.request.contextPath}/logout" method="post" class="logout-form">
				  <button type="submit" class="menu-link logout-button" name="logout" value="logout">
				    <i class="fa-solid fa-right-from-bracket"></i>
				    <p>Logout</p>
				    <span>></span>
				  </button>
				</form>		
				
				</div>
				</div>
			</div>
			</nav>
		</div>
</body>
</html>