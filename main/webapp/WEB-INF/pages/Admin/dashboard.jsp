<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<!-- This connects to dashboard.css file -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/dashboard.css">

<!-- This connects to dashboard.js file -->
<script type="text/javascript" src="${pageContext.request.contextPath}/javascript/dashboard.js"></script>

<!-- This gives access to google font "inter" -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Inter:wght@100..900&family=JetBrains+Mono:ital,wght@0,100..800;1,100..800&family=Roboto:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">

<!-- This gives access to font awesome icons -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
</head>

<!-- Body stores the content for admin page -->
<body>

	<%@ include file="navigation.jsp" %>
	<section class="home">
	<h2>Welcome, ${userModel.firstName}</h2>
	  	<div class="dashboard">
	    <div>
	      <div class="cards">
	        <div class="card">
	          <div class="title">Total Revenue</div>
	          <div class="value">$45,678.90</div>
	          <div class="change">+20% month over month</div>
	        </div>
	        <div class="card dark">
	          <div class="value">2,405</div>
	          <div class="change">+33% month over month</div>
	        </div>
	        <div class="card">
	          <div class="title">Total Return of Investment</div>
	          <div class="value">$45,678.90</div>
	          <div class="change">+20% month over month</div>
	        </div>
	      </div>
	      
	      <div class="venues">
	        <h3>Venues</h3>
	        <table>
	          <thead>
	            <tr>
	           	  <th><input type="checkbox"></th>
	              <th>ID</th>
	              <th>Venue</th>
	              <th>Location</th>
	              <th>Contact Number</th>
	              <th>Capacity</th>
	              <th>Status</th>
	            </tr>
	          </thead>
	          <tbody>
              <c:forEach var="venue" items="${listVenue}">
		      	<tr>
		        <td><input type="checkbox"></td>
		        <td><c:out value='${venue.venueId}'/></td>
		        <td><c:out value='${venue.name}'/></td>
		        <td><c:out value='${venue.address}'/></td>
		        <td><c:out value='${venue.contactNumber}'/></td>
		        <td><c:out value='${venue.capacity}'/></td>
		        <td><span class="badge high"><c:out value='${venue.status}'/></span></td>
			    </tr>
			</c:forEach>
            </tbody>
	        </table>
	      </div>
	    </div>
	    <div class="right-section">
	      <div class="list">
	        <h4>Recent User Sign-Ups</h4>
	        <div class="list-item"><img src="${pageContext.request.contextPath}/resources/userpfp.jpg"><span>Helena - helena@gmail.com</span></div>
	        <div class="list-item"><img src="${pageContext.request.contextPath}/resources/missionimg.jpg"><span>Aamir - aamirhameed7@gmail.com</span></div>
	        <div class="list-item"><img src="${pageContext.request.contextPath}/resources/cat-one.jpg"><span>Bunu - bunu@gmail.com</span></div>
	      </div>
	      <div class="stats">
	        <h4>Customers</h4>
	        <div>200</div>
	      </div>
	      <div class="stats">
        	<h4>Total Revenue</h4>
        	<canvas id="revenueChart"></canvas>
      	  </div>
	    </div>
	  </div>

        
	</section>
	<script type="text/javascript" src="${pageContext.request.contextPath}/javascript/dashboard.js"></script>

</body>
</html>