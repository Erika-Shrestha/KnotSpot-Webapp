<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Knot spot</title>

<!-- This connects to setting.css file -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/setting.css">


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
	<%@ include file="navigation.jsp" %>
	<section class="home">
	  <h2>Appearance</h2>
	  <div class="first-div">
	  	<div class="sub-div-one">
		    <div>Company logo
		    	<p>Update your company logo</p>
		    </div>
		    <div class="sub-div-two">
		      <img src="${pageContext.request.contextPath}/resources/companylogo.png" alt="company-logo" class="company-logo">
		      <button>Replace logo</button>
		      <button class="remove-btn">Remove</button>
		    </div>
	    </div>
	    <div class="sub-div-three">
	      <div>Brand logo
	      	<p>Select your brand color</p>
	      </div>
	      <div class="color-selector">
			  <div class="color-circle selected" style="background-color: #fde047;"></div>
			  <div class="color-circle" style="background-color: #facc15;"></div>
			  <div class="color-circle" style="background-color: #4ade80;"></div>
			  <div class="color-circle" style="background-color: #d8b4fe;"></div>
		  </div>
	    </div>
	  </div>
	
	  <div class="sec-div">
	    <div class="sub-sec-one">
	      <div>Transparent sidebar
	      	<p>Make the sidebar transparent</p>
	      </div>
	      <label class="toggle-switch">
		  	<input type="checkbox" checked>
		  	<span class="slider"></span>
		  </label>
	    </div>
	    
		<form action="${pageContext.request.contextPath}/setting" method="post">
		    <div class="third-div">
		      <div>Cookies time to live
		      	<p>Set a cookie time</p>
		      </div>
		      <select name="cookieLife" onchange="this.form.submit()">
		        <option value="1" ${selectedCookieLife == 1 ? 'selected' : ''}>1 day</option>
			    <option value="2" ${selectedCookieLife == 2 ? 'selected' : ''}>2 days</option>
			    <option value="3" ${selectedCookieLife == 3 ? 'selected' : ''}>3 days</option>
		      </select>
		    </div>
	    </form>
	  </div>
	</section>
</body>
</html>