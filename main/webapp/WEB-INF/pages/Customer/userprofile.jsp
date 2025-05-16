<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Knot Spot</title>
<!-- This connects to profile.css file -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/userprofile.css">

<!-- This gives access to google font "inter" -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Inter:wght@100..900&family=JetBrains+Mono:ital,wght@0,100..800;1,100..800&family=Roboto:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">
<!-- This gives access to font awesome icons -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
</head>
<body>
	<main class="container">
		<div class="arrow"><a href="${pageContext.request.contextPath}/home"><i class="fa-solid fa-arrow-left"></i>My Profile</a></div>
		<div class="user-con">
			<form action="${pageContext.request.contextPath}/profile" method="post" enctype="multipart/form-data">
				<div class="fst-sub-con">
					<img src="${pageContext.request.contextPath}/resources/${userModel.profilePic}" alt="user-img" class="user-img">
					<div class="buttons">
						<div class="upload-file">
							<c:if test="${not empty venue_pictureError}">
								<label class="errorDisplay email">${venue_pictureError}</label>
							</c:if>
							<label class="change-btn" for="file-upload">Change picture</label>
				  			<input type="file" id="file-upload" class="file-box" name="profile_image"/>
			  			</div>
						<button class="del-btn">Delete picture</button>
					</div>
					<p>At least 800 x 800 px recommended.<br>JPG or PNG is allowed</p>
				</div>
				<div class="sec-sub-con">
					<div class="detail-row light">
					<c:if test="${not empty firstnameError}">
						<label class="errorDisplay name">${firstnameError}</label>
					</c:if>
					<c:if test="${not empty lastnameError}">
						<label class="errorDisplay name">${lastnameError}</label>
					</c:if>
					  <div class="field">Name</div><div class="colon">:</div><div class="input-name">
						<input type="text" name="first_name" value="${userModel.firstName}"/><input type="text" name="last_name" value="${userModel.lastName}"/></div>
					</div>
					<div class="detail-row white">
					  <div class="field">Role</div><div class="colon">:</div><div class="inputs"><input type="text" name="role_id" value="${userModel.roleName}" readonly/></div>
					</div>
					<div class="detail-row light">
					<div class="field">Email</div><div class="colon">:</div><div class="inputs">
					<c:if test="${not empty emailError}">
						<label class="errorDisplay email">${emailError}</label>
					</c:if>
					<c:if test="${not empty emailDuplicate}">
        				<label class="errorDisplay email">${emailDuplicate}</label>
    				</c:if>
					<input type="email" name="email" value="${userModel.email}"/></div>
					</div>
					<div class="detail-row white">
					  <div class="field">Contact</div><div class="colon">:</div><div class="inputs">
					  	<c:if test="${not empty contactError}">
							<label class="errorDisplay contact">${contactError}</label>
					  	</c:if>
						<c:if test="${not empty contactDuplicate}">
							<label class="errorDisplay contact">${contactDuplicate}</label>
						</c:if>
					  <input type="tel" name="contact_no" value="${userModel.contactNumber}"/></div>
					</div>
					<div class="detail-row light">
					  <div class="field">Gender</div><div class="colon">:</div><div class="inputs"><input type="text" name="gender" value="${userModel.gender}"/></div>
					</div>
					<div class="detail-row white">
					<c:if test="${not empty usernameError}">
						<label class="errorDisplay username">${usernameError}</label>
					</c:if>
					<c:if test="${not empty usernameDuplicate}">
						<label class="errorDisplay username">${usernameDuplicate}</label>
					</c:if>
					  <div class="field">Username</div><div class="colon">:</div><div class="inputs"><input type="text" name="username" value="${userModel.username}"/></div>
					</div>
				</div>
				<div class="thd-sub-con">
					<button class="cancel-btn">Cancel</button>
	      			<button type="submit" class="save-btn">Save changes</button>
				</div>
			</form>
		</div>
	</main>
</body>
</html>