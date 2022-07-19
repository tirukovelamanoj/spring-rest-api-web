<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
	<head>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
		<title>REST API</title>
	</head>
	<body>
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<div class="container-fluid">
				<a class="navbar-brand" href="/">REST API MandS LEAP POC</a>
				<button class="btn btn-outline-danger d-flex" type="submit" onclick="location.href='/logout'">Logout</button>
			</div>
		</nav>
	
		<div class="container-fluid">
			<div class="row d-flex justify-content-center">
				<div class="col-auto border border-3 rounded m-3 p-3" style="width: 30%;">
					<form id="addOrupdate" method="POST">
						<div class="mb-3">
							<label for="hotelId" class="form-label">Hotel ID</label>
							<input type="text" class="form-control" id="hotelId" name="hotelId" placeholder="Hotel Id" aria-describedby="hotelIdNote" />
							<div id="hotelIdNote" class="form-text">Enter hotel Id only to update hotel details else leave blank</div>
						</div>
						<div class="mb-3">
							<label for="hotelName" class="form-label">Hotel Name</label>
							<input type="text" class="form-control" id="hotelName" name="hotelName" placeholder="Hotel Name" />
						</div>
						<div class="mb-3">
							<label for="hotelRating" class="form-label">Hotel Rating</label> 
							<input type="number" class="form-control" id="hotelRating" name="hotelRating" placeholder="Hotel rating" />
						</div>
						<div class="mb-3">
							<label for="hotelAddress" class="form-label">Hotel Address</label>
							<input type="text" class="form-control" id="hotelAddress" name="hotelAddress" placeholder="Hotel address" />
						</div>
						<div class="mb-3">
							<label for="hotelPinCode" class="form-label">Hotel Address Pincode</label>
							<input type="number" class="form-control" id="hotelPinCode" name="hotelPinCode" placeholder="Hotel address pincode" />
						</div>
						<div class="d-flex flex-row justify-content-between mb-3">
							<div><button type="button" class="btn btn-primary" onclick="addHotel()">Add details</button></div>
							<div><button type="button" class="btn btn-primary" onclick="updateHotel()">Update</button></div>
						</div>
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
					</form>
				</div>
		
				<div class="col-auto border border-3 rounded m-3 p-3" style="width: 40%;">
					<form id="getOrdelete" method="GET">
						<div class="input-group">
							<span class="input-group-text" id="hotelNameToSearch">@id</span>
							<input type="text" class="form-control" id="hotelIdToSearch" name="hotelIdToSearch" placeholder="Enter hotel ID to search" aria-describedby="getAllHotels" required>
						</div>
						<div id="getAllHotels" class="form-text mb-3">Enter 0 (zero) to get list of all hotels.</div>
						<div class="d-flex flex-row justify-content-between mb-3">
							<div><button type="button" class="btn btn-primary" onclick="getDetails()">Get details</button></div>
							<div><button type="button" class="btn btn-primary" onclick="deleteHotel()">Delete</button></div>
						</div>
					</form>
					<div class="border border-3 rounded mb-3 w-100 p-3" style="overflow: auto;height: 350px;" id="hotelDetails"><pre><code id="json-container"><%= (String) request.getAttribute("message") %></code></pre></div>
				</div>
			</div>	
		</div>
		<script>
			function getDetails() {
				var z = document.getElementById("getOrdelete");
				z.action = "/view";
				z.submit();
			}
			function deleteHotel() {
				var z = document.getElementById("getOrdelete");
				z.action = "/delete";
				z.submit();
			}
			function addHotel() {
				var z = document.getElementById("addOrupdate");
				z.action = "/add";
				z.submit();
			}
			function updateHotel() {
				var z = document.getElementById("addOrupdate");
				z.action = "/update";
				z.submit();
			}
		</script>
</body>
</html>