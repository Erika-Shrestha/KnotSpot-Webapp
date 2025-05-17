<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Knot Spot</title>

<!-- This connects to venuemanagement.css file -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/venuemanagement.css">


<!-- This gives access to google font "inter" -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Inter:wght@100..900&family=JetBrains+Mono:ital,wght@0,100..800;1,100..800&family=Roboto:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">

<!-- This gives access to font awesome icons -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
</head>
<body>
	<%@ include file="navigation.jsp" %>
	<section class="home">
		<div class="search-con">
			<!-- This is for notification bell -->
			<a href="#" class="notify-link"><i class="fa-solid fa-bell icon"></i></a>
		</div>
		<div class="venue-title">
			<label>Venue Details</label>
		</div>
		<div class="filters">
			<form action="${pageContext.request.contextPath}/management" method="get">
			<div class="search-con search">
				<input type="text" placeholder="search venues..." name="search_bar">
				<input type="hidden" name="action" value="search">
				<i class="fa-solid fa-magnifying-glass"></i>
				<i class="fa-solid fa-magnifying-glass"></i>
			</div>
			</form>
			<form action="${pageContext.request.contextPath}/management" method="get">
			<div class="sort">
			<input type="hidden" name="action" value="sort">
    			<select class="sort combo" name="sort_bar" onchange="this.form.submit()" required>
       				<option value="" selected>Filter</option>
       				<option value="ASC" ${sortValue == 'ASC' ? 'selected' : ''}>Ascending</option>
       				<option value="DESC" ${sortValue == 'DESC' ? 'selected' : ''}>Descending</option>
    			</select>
			</div>
			</form>
			<button class="add-btn" id="openCreate"><i class="fa-solid fa-plus"></i></button>
		</div>
		<div class="table-container">
		  <table class="venue-table">
		    <thead>
		      <tr>
		        <th><input type="checkbox"></th>
		        <th>ID</th>
		        <th>Venue</th>
		        <th>Location</th>
		        <th>Contact Info</th>
		        <th>Capacity</th>
		        <th>Amenities</th>
		        <th>Date</th>
		        <th>Type</th>
		        <th>Status</th>
		        <th>Actions</th>
		      </tr>
		    </thead>
		    <tbody>
		    <c:choose>
			<c:when test="${not empty searchVenueList}">
			<c:forEach var="searchVenue" items="${searchVenueList}">
		      <tr>
		        <td><img src="${pageContext.request.contextPath}/resources/${searchVenue.venuePic}" alt="Venue Image" class="venues"></td>
		        <td><c:out value='${searchVenue.venueId}'/></td>
		        <td><c:out value='${searchVenue.name}'/></td>
		        <td><c:out value='${searchVenue.address}'/></td>
		        <td><c:out value='${searchVenue.contactNumber}'/></td>
		        <td><c:out value='${searchVenue.capacity}'/></td>
		        <td><c:out value='${searchVenue.amenities}'/></td>
		        <td><c:out value='${searchVenue.registeredDate}'/></td>
		        <td><c:out value='${searchVenue.type}'/></td>
		        <td><span class="badge high"><c:out value='${searchVenue.status}'/></span></td>
		        <td class="actions">
    				<form action="${pageContext.request.contextPath}/management" method="get">
				        <input type="hidden" name="action" value="edit">
				        <input type="hidden" name="venue_id" value="${searchVenue.venueId}">
				        <button type="submit" class="edit-btn"><i class="fas fa-pen"></i></button>
				    </form>
  					<button><i class="fas fa-eye" onclick="openPanel()"></i></button>
  					<form action="${pageContext.request.contextPath}/management" method="post" onsubmit="return confirm('Are you sure you want to delete this venue?');">
  						<input type="hidden" name="action" value="delete">
  						<input type="hidden" name="venue_id" value="<c:out value='${searchVenue.venueId}'/>">
    					<button type="submit"><i class="fas fa-trash"></i></button>
		        	</form>
		        </td>
		      </tr>
		    </c:forEach>
		    </c:when>
		    <c:when test="${not empty sortVenueList}">
			<c:forEach var="sortVenue" items="${sortVenueList}">
		      <tr>
		        <td><img src="${pageContext.request.contextPath}/resources/${sortVenue.venuePic}" alt="Venue Image" class="venues"></td>
		        <td><c:out value='${sortVenue.venueId}'/></td>
		        <td><c:out value='${sortVenue.name}'/></td>
		        <td><c:out value='${sortVenue.address}'/></td>
		        <td><c:out value='${sortVenue.contactNumber}'/></td>
		        <td><c:out value='${sortVenue.capacity}'/></td>
		        <td><c:out value='${sortVenue.amenities}'/></td>
		        <td><c:out value='${sortVenue.registeredDate}'/></td>
		        <td><c:out value='${sortVenue.type}'/></td>
		        <td><span class="badge high"><c:out value='${sortVenue.status}'/></span></td>
		        <td class="actions">
    				<form action="${pageContext.request.contextPath}/management" method="get">
				        <input type="hidden" name="action" value="edit">
				        <input type="hidden" name="venue_id" value="${sortVenue.venueId}">
				        <button type="submit" class="edit-btn"><i class="fas fa-pen"></i></button>
				    </form>
  					<button><i class="fas fa-eye" onclick="openPanel()"></i></button>
  					<form action="${pageContext.request.contextPath}/management" method="post" onsubmit="return confirm('Are you sure you want to delete this venue?');">
  						<input type="hidden" name="action" value="delete">
  						<input type="hidden" name="venue_id" value="<c:out value='${sortVenue.venueId}'/>">
    					<button type="submit"><i class="fas fa-trash"></i></button>
		        	</form>
		        </td>
		      </tr>
		    </c:forEach>
		    </c:when>
  			<c:otherwise>
		    <c:forEach var="venue" items="${listVenue}">
		      <tr>
		        <td><img src="${pageContext.request.contextPath}/resources/${venue.venuePic}" alt="Venue Image" class="venues"></td>
		        <td><c:out value='${venue.venueId}'/></td>
		        <td><c:out value='${venue.name}'/></td>
		        <td><c:out value='${venue.address}'/></td>
		        <td><c:out value='${venue.contactNumber}'/></td>
		        <td><c:out value='${venue.capacity}'/></td>
		        <td><c:out value='${venue.amenities}'/></td>
		        <td><c:out value='${venue.registeredDate}'/></td>
		        <td><c:out value='${venue.type}'/></td>
		        <td><span class="badge high"><c:out value='${venue.status}'/></span></td>
		        <td class="actions">
    				<form action="${pageContext.request.contextPath}/management" method="get">
				        <input type="hidden" name="action" value="edit">
				        <input type="hidden" name="venue_id" value="${venue.venueId}">
				        <button type="submit" class="edit-btn"><i class="fas fa-pen"></i></button>
				    </form>
  					<button><i class="fas fa-eye" onclick="openPanel()"></i></button>
  					<form action="${pageContext.request.contextPath}/management" method="post" onsubmit="return confirm('Are you sure you want to delete this venue?');">
  						<input type="hidden" name="action" value="delete">
  						<input type="hidden" name="venue_id" value="<c:out value='${venue.venueId}'/>">
    					<button type="submit"><i class="fas fa-trash"></i></button>
		        	</form>
		        </td>
		      </tr>
		    </c:forEach>
		    </c:otherwise>
  			</c:choose>
		    </tbody>
		  </table>
		</div>
		<div id="viewPanel" class="view-panel">
		  <div class="panel-content">
		    <span class="close-btn" onclick="closePanel()">&times;</span>
		    <h2>Edit Venue</h2>
		    <p>Editing content goes here...</p>
		  </div>
		</div>
	</section>
	
	<div class="modal-container" id="modal-container-add">
		<div class="modal">
		<h1>Venue Detail</h1>
		<form action="${pageContext.request.contextPath}/management" method="post" class="form-grid" id="venue-form" enctype="multipart/form-data">
			<input type="hidden" name="action" value="create">
			<div>
			<c:if test="${not empty nameError}">
				<label class="errorDisplay name">${nameError}</label>
			</c:if>
			<input type="text" name="venue_name" placeholder="venue name" value="${venueName}">
			</div>
			<div>
			<c:if test="${not empty addressError}">
				<label class="errorDisplay email">${addressError}</label>
			</c:if>
				<input type="text" name="address" placeholder ="address" value="${address}">
			</div>
			<div>
				<input type="text" name="city" placeholder="city" value="${city}">
			</div>
			<div>
			<c:if test="${not empty contactError}">
				<label class="errorDisplay email">${contactError}</label>
			</c:if>
			<c:if test="${not empty contactDuplicate}">
				<label class="errorDisplay contact">${contactDuplicate}</label>
			</c:if>
			<input type="text" name="contact" placeholder="phone number" value="${contact}">
			</div>
			<div>
				<div class="input-box">
				<select name="capacity" required>
					<option value="" disabled selected>Select capacity</option>
					<option value="50" ${capacity == '50' ? 'selected' : ''}>50</option>
					<option value="100" ${capacity == '100' ? 'selected' : ''}>100</option>
					<option value="150" ${capacity == '150' ? 'selected' : ''}>150</option>
					<option value="200" ${capacity == '200' ? 'selected' : ''}>200</option>
					<option value="250" ${capacity == '250' ? 'selected' : ''}>250</option>
					<option value="500" ${capacity == '500' ? 'selected' : ''}>500</option>
				</select>
			</div>
			</div>
			<div>
			<c:if test="${not empty amenitiesError}">
				<label class="errorDisplay email">${amenitiesError}</label>
			</c:if>
				<input type="text" name="amenities" placeholder="Amenities" value="${amenities}">
			</div>
			<div class="input-box">
				<select class="type" name="venue_type" required>
					<option value="" disabled>Type</option>
					<option value="Ballroom" ${type == 'Ballroom' ? 'selected' : ''}>Ballroom</option>
					<option value="Banquet Hall" ${type == 'Banquet Hall' ? 'selected' : ''}>Banquet Hall</option>
				</select>
			</div>
			
			<div class="input-box">
				<select class="status" name="status" required>
					<option value="" disabled>Status</option>
					<option value="Available" ${status == 'Available' ? 'selected' : ''}>Available</option>
					<option value="Non-Available" ${status == 'Non-Available' ? 'selected' : ''}>Non-Available</option>
				</select>
			</div>
			<div class="file-con">
				  <label class="file-label" for="file-upload">Upload Image</label>
				  <input type="file" id="file-upload" class="file-box" name="venue_image" value="${image}"/>
			</div>
			<button type="submit">Submit</button>
		</form>
		<button id="closeCreate">Close</button>
		</div>
	</div>
	
	<div class="modal-container" id="modal-container-edit">
		<div class="modal">
		<h1>Venue Detail</h1>
			<form action="${pageContext.request.contextPath}/management" method="post" enctype="multipart/form-data" onsubmit="return confirm('Are you sure you want to update this venue?');">
				<input type="hidden" name="action" value="update">
				<input type="hidden" name="venue_id" value="${selectedVenue.venueId}">
				<div>
				<c:if test="${not empty nameError}">
					<label class="errorDisplay name">${nameError}</label>
				</c:if>
				<input type="text" name="venue_name" placeholder ="name" value="${selectedVenue.name}">
				</div>
				<div>
				<c:if test="${not empty addressError}">
					<label class="errorDisplay name">${addressError}</label>
				</c:if>
				<input type="text" name="address" placeholder ="address" value="${selectedVenue.address}">
				</div>
				<input type="text" name="city" placeholder="city" value="${selectedVenue.city}">
				<div>
				<c:if test="${not empty contactError}">
					<label class="errorDisplay email">${contactError}</label>
				</c:if>
				<c:if test="${not empty contactDuplicate}">
					<label class="errorDisplay contact">${contactDuplicate}</label>
				</c:if>
				<input type="text" name="contact" placeholder="phone number" value="${selectedVenue.contactNumber}">
				</div>
				<div class="input-box">
					<select name="capacity" required>
						<option value="" disabled selected>Select capacity</option>
						<option value="50" ${selectedVenue.capacity == '50' ? 'selected' : ''}>50</option>
						<option value="100" ${selectedVenue.capacity == '100' ? 'selected' : ''}>100</option>
						<option value="150" ${selectedVenue.capacity== '150' ? 'selected' : ''}>150</option>
						<option value="200" ${selectedVenue.capacity == '200' ? 'selected' : ''}>200</option>
						<option value="250" ${selectedVenue.capacity == '250' ? 'selected' : ''}>250</option>
						<option value="500" ${selectedVenue.capacity == '500' ? 'selected' : ''}>500</option>
					</select>
				</div>
				<div>
				<c:if test="${not empty amenitiesError}">
					<label class="errorDisplay name">${amenitiesError}</label>
				</c:if>
				<input type="text" name="amenities" placeholder="Amenities" value="${selectedVenue.amenities}">
				</div>
				<div class="input-box">
	              	<select class="type" name="venue_type" required>
	                	<option value="" disabled>Type</option>
	                	<option value="Ballroom" ${selectedVenue.type == 'Ballroom' ? 'selected' : ''}>Ballroom</option>
	                	<option value="Banquet Hall" ${selectedVenue.type == 'Banquet Hall' ? 'selected' : ''}>Banquet Hall</option>
	              	</select>
            	</div>
            	<div class="input-box">
                	<select class="status" name="status" required>
                    	<option value="" disabled>Status</option>
                    	<option value="Available" ${selectedVenue.status == 'Available' ? 'selected' : ''}>Available</option>
                    	<option value="Non-Available" ${selectedVenue.status == 'Non-Available' ? 'selected' : ''}>Non-Available</option>
                	</select>
            	</div>
				<div class="file-con">
				  <input type="file" id="file-upload" class="file-box" name="venue_image"/>
				</div>
				<button type="submit">Save changes</button>
			</form>
			<form action="${pageContext.request.contextPath}/management" method="get">
            	<button type="submit" id="closeEdit">Close</button>
        	</form>
		</div>
	</div>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/javascript/venuemanagement.js"></script>
	<script>
        <c:if test="${not empty selectedVenue}">
            document.getElementById('modal-container-edit').classList.add('show');
        </c:if>
    </script>
    <c:if test="${showCreateModal}">
	    <script>
	        window.addEventListener('DOMContentLoaded', () => {
	            document.getElementById('modal-container-add')?.classList.add('show');
	        });
	    </script>
	</c:if>
	<c:if test="${showEditModal}">
	    <script>
	        window.addEventListener('DOMContentLoaded', () => {
	            document.getElementById('modal-container-edit')?.classList.add('show');
	        });
	    </script>
	</c:if>
</body>
</html>