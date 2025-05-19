<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Knot spot</title>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<!-- This connects to report.css file -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/report.css">

<!-- This gives access to google font "inter" -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Inter:wght@100..900&family=JetBrains+Mono:ital,wght@0,100..800;1,100..800&family=Roboto:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">

<!-- This gives access to font awesome icons -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
</head>
<body>
	<%@ include file="navigation.jsp" %>
	<section class="home">
		<h1>Sales Report</h1>
		<section class="sales-report">
        <div class="report-grid">
            <div class="chart-container">
                <div class="stats register">
        			<h4>Daily Registered Users</h4>
        			<canvas id="registerChart"></canvas>
		  		</div>
            </div>
            <div class="chart-container">
                <div class="stats register">
        			<h4>Portion of Registered Users</h4>
        			<canvas id="registerBar"></canvas>
		  		</div>
            </div>
        </div>
    </section>
	</section>
	<script type="text/javascript" src="${pageContext.request.contextPath}/javascript/report.js"></script>
	<script>
	  const registrationData = {
	    labels: [
	      <c:forEach var="row" items="${registrationGraph}" varStatus="status">
	        '${row[0]}'<c:if test="${!status.last}">, </c:if>
	      </c:forEach>
	    ],
	    counts: [
	      <c:forEach var="row" items="${registrationGraph}" varStatus="status">
	        ${row[1]}<c:if test="${!status.last}">, </c:if>
	      </c:forEach>
	    ]
	  };
	</script>
</body>
</html>