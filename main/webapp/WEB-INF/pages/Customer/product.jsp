<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Knot spot</title>

<!-- This connects to home.css file -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/product.css">


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
		<section class="product-details-con">
		<form action="${pageContext.request.contextPath}/product" method="get">
			<div class="search-con">
				<input type="text" placeholder="search" name="search_bar">
				<button type="submit" class="search-btn">
            		<i class="fa-solid fa-magnifying-glass"></i>
        		</button>
        		<button type="submit" name="search_bar" value="">Clear Search</button>
			</div>
		</form>
		<div class="venue-div">
		<c:choose>
		<c:when test="${not empty searchVenueList}">
		<c:forEach var="searchVenue" items="${searchVenueList}">
			<div class="venue-card">
			  <img src="${pageContext.request.contextPath}/resources/${searchVenue.venuePic}" alt="Venue Image" class="venue-image">
			  <div class="venue-details">
			    <h3 class="venue-title">${searchVenue.name}</h3>
			    <p class="venue-description">${searchVenue.amenities}</p>
			    <p class="venue-price">${searchVenue.capacity}</p>
			    <button class="book-btn">Book Now</button>
			  </div>
			</div>
  		</c:forEach>
  		</c:when>
  		<c:otherwise>
  		<c:forEach var="venue" items="${listVenue}">
			<div class="venue-card">
			  <img src="${pageContext.request.contextPath}/resources/${venue.venuePic}" alt="Venue Image" class="venue-image">
			  <div class="venue-details">
			    <h3 class="venue-title">${venue.name}</h3>
			    <p class="venue-description">${venue.amenities}</p>
			    <p class="venue-price">${venue.capacity}</p>
			    <button class="book-btn">Book Now</button>
			  </div>
			</div>
  		</c:forEach>
  		</c:otherwise>
  		</c:choose>
  		</div>
		</section>
	</main>
</body>
</html>