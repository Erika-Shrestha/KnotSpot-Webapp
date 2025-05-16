<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Knot spot</title>

<!-- This connects to home.css file -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/blog.css">


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
	<main>
		<div class="header-insight">
        <h1>INSIGHT<span><i class="fa-solid fa-star"></i></span>INSIGHT</h1>
    </div>
    <div class="container">
        <div class="main-content">
            <div class="post">
                <img src="${pageContext.request.contextPath}/resources/blogfour.jpg" alt="test_image" class="blog-img">
                <div class="post-content">
                    <p>Erika Shrestha - 20 Jan 2024</p>
                    <h2>Top Religious Weddings in the History with Luxurious Venues</h2>
                    <a href="#">RESEARCH</a>
                </div>
            </div>
        </div>
        <div class="sidebar">
            <h3>Other featured posts</h3>
            <div class="post">
                <div class="post-content">
                    <p>Erika Shrestha - 20 Jan 2024</p>
                    <h2>Top Religious Weddings in the History with Luxurious Venues</h2>
                    <a href="#">RESEARCH</a>
                </div>
            </div>
            <div class="post">
                <div class="post-content">
                    <p>Erika Shrestha - 20 Jan 2024</p>
                    <h2>Top Religious Weddings in the History with Luxurious Venues</h2>
                    <a href="#">RESEARCH</a>
                </div>
            </div>
        </div>
    </div>
    <div class="all-posts">
        <h3>ALL BLOG POSTS</h3>
        <div class="posts-grid">
            <div class="post">
                <img src="${pageContext.request.contextPath}/resources/blogone.png" alt="test_image" class="blog-img">
                <div class="post-content">
                    <p>Erika Shrestha - 20 Jan 2024</p>
                    <h2>Top Religious Weddings in the History with Luxurious Venues</h2>
                    <a href="#">RESEARCH</a>
                </div>
            </div>
            <div class="post">
                <img src="${pageContext.request.contextPath}/resources/blogthree.jpg" alt="test_image" class="blog-img">
                <div class="post-content">
                    <p>Erika Shrestha - 20 Jan 2024</p>
                    <h2>Top Religious Weddings in the History with Luxurious Venues</h2>
                    <a href="#">RESEARCH</a>
                </div>
            </div>
            <div class="post">
                <img src="${pageContext.request.contextPath}/resources/cat-one.jpg" alt="test_image" class="blog-img">
                <div class="post-content">
                    <p>Erika Shrestha - 20 Jan 2024</p>
                    <h2>Top Religious Weddings in the History with Luxurious Venues</h2>
                    <a href="#">RESEARCH</a>
                </div>
            </div>
        </div>
    </div>
	</main>
	<footer>
		<%@ include file="footer.jsp" %>
	</footer>
</body>
</html>