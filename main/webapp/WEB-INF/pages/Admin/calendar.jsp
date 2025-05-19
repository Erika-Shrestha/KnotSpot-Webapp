<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Knot spot</title>
<!-- This connects to calendar.css file -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/calendar.css">

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
		<section class="tasks">
        	<h1>My Tasks</h1>
        	<div class="tabs">
           		<c:choose>
	               <c:when test="${activeSection == 'list'}">
	                   <a href="${pageContext.request.contextPath}/task?section=list" class="tab active">List</a>
	                   <a href="${pageContext.request.contextPath}/task?section=notify" class="tab">Notify</a>
	               </c:when>
	               <c:otherwise>
	                   <a href="${pageContext.request.contextPath}/task?section=list" class="tab">List</a>
	                   <a href="${pageContext.request.contextPath}/task?section=notify" class="tab active">Notify</a>
	               </c:otherwise>
	           	</c:choose>
	        </div>
	        <c:if test="${activeSection == 'list'}">
	            <div class="tab-content">
	                <p>10 Tasks</p>
	                <div class="task-section">
	                    <h3 class="todo">Todo</h3>
	                    <div class="task">
	                        <p>Add a new user registration to the system</p>
	                        <span>Due date: 20/12/2025</span>
	                    </div>
	                    <p class="add-task">+ Add Task</p>
	                </div>
	                <div class="task-section">
	                    <h3 class="in-progress">In progress</h3>
	                    <div class="task">
	                        <p>Profile update</p>
	                        <span>Due date: 20/12/2025</span>
	                    </div>
	                    <p class="add-task">+ Add Task</p>
	                </div>
	                <div class="task-section">
	                    <h3 class="done">Done</h3>
	                    <p class="add-task">+ Add Task</p>
	                </div>
	            </div>
	        </c:if>
	        <c:if test="${activeSection == 'notify'}">
	            <div class="tab-content">
	                <p>Notifications</p>
	                <div class="notification">
	                    <p>
	                    <span class="star">
	                    	<i class="fa-solid fa-star"></i>
	                    </span> A new user registration to the system
	                    </p>
	                </div>
	                <div class="notification">
	                    <p>
	                    <span class="star">
	                    	<i class="fa-solid fa-star"></i>
	                    </span> A venue has been added
	                    </p>
	                </div>
                	<div class="notification">
                    	<p>
                    	<span class="star">
                    		<i class="fa-solid fa-star"></i>
                    	</span> Your profile has been updated successfully
                    	</p>
                	</div>
            	</div>
        	</c:if>
    	</section>
	</section>
</body>
</html>