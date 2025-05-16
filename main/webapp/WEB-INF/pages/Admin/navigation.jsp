<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Knot Spot</title>

<!-- This connects to venuemanagement.css file -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/navigation.css">


<!-- This gives access to google font "inter" -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Inter:wght@100..900&family=JetBrains+Mono:ital,wght@0,100..800;1,100..800&family=Roboto:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100..900;1,100..900&family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">

<!-- This gives access to font awesome icons -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
</head>
<body class="nav-body">
	<nav class="side-bar close">
		<header>
			<div class="image-text">
				<span class="image">
					<img src="${pageContext.request.contextPath}/resources/companylogo.png" alt="company-logo" class="company-logo">
				</span>
				<div class="text header-text">
					<span class="name">Knotspot</span>
				</div>
			</div>
			<i class="fa fa-chevron-right toggle" aria-hidden="true"></i>
		</header>
		
		<div class="user-display">
			<img src="${pageContext.request.contextPath}/resources/${userModel.profilePic}" alt="user-profile" class="user-image">
			<h2>${userModel.firstName} ${userModel.lastName}</h2>
			<div class="review">
				<i class="fa fa-star" aria-hidden="true"></i>
				<p>4.8</p>
			</div>
		</div>
		
		<div class="menu-bar">
			<div class="menu">
				<ul class="menu-links">
					<li class="nav-link">
						<a href="#">
							<i class="fa fa-home icon" aria-hidden="true"></i>
							<span class="text nav-text">Dashboard</span>
						</a>
					</li>
					<li class="nav-link">
						<a href="${pageContext.request.contextPath}/management">
							<i class="fa fa-book icon" aria-hidden="true"></i>
							<span class="text nav-text">Venue Manager</span>
						</a>
					</li>
					<li class="nav-link">
						<a href="#">
							<i class="fa fa-calendar icon" aria-hidden="true"></i>
							<span class="text nav-text">Calendar</span>
						</a>
					</li>
					<li class="nav-link">
						<a href="#">
							<i class="fa fa-file-text icon" aria-hidden="true"></i>
							<span class="text nav-text">Report</span>
						</a>
					</li>
					<li class="nav-link">
						<a href="#">
							<i class="fa fa-cogs icon" aria-hidden="true"></i>
							<span class="text nav-text">System preference</span>
						</a>
					</li>
				</ul>
			</div>
			
			<div class="bottom-content">
				<ul class="menu-links">
				 <li class="nav-link">
					<form action="${pageContext.request.contextPath}/logout" method="post" class="logout-form">
						<a href="#">
							<button type="submit" class="menu-link logout-button" name="logout" value="logout">
							<i class="fa fa-sign-out icon" aria-hidden="true"></i>
							<span class="text nav-text">Logout</span>
							</button>
						</a>
					</form>
				</li>
					
					<li class="mode">
						<div class="moon-sun">
							<i class="fa fa-moon icon moon" aria-hidden="true"></i>
							<i class="fa fa-sun icon sun" aria-hidden="true"></i>
						</div>
						<span class="mode-text text">Dark Mode</span>
						
						<div class="toggle-switch">
							<span class="switch"></span>
						</div>
					</li>
				</ul>
			</div>
		</div>
	</nav>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/javascript/navigation.js"></script>
</body>
</html>