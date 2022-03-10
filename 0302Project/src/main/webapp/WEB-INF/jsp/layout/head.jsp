<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title></title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<style>
@import url('https://fonts.googleapis.com/icon?family=Material+Icons');
.login{
padding-right:100px;
}
.dropdown {
	position: relative;
	display: inline-block;
	padding-right:100px;
}

.dropbtn_icon {
	font-family: 'Material Icons';
}

.dropbtn {
	border: 1px solid rgb(37, 37, 37);
	border-radius: 4px;
	background-color: #f5f5f5;
	font-weight: 400;
	color: rgb(37, 37, 37);
	padding: 12px;
	width: 200px;
	text-align: left;
	cursor: pointer;
	font-size: 12px;
}

.dropdown-content {
	display: none;
	position: absolute;
	z-index: 1; /*다른 요소들보다 앞에 배치*/
	font-weight: 400;
	background-color: #f9f9f9;
	min-width: 200px;
}

.dropdown-content a {
	display: block;
	text-decoration: none;
	color: rgb(37, 37, 37);
	font-size: 12px;
	padding: 12px 20px;
}

.dropdown-content a:hover {
	background-color: #ececec
}

.dropdown:hover .dropdown-content {
	display: block;
}
</style>
</head>
<body>
	<!-- Header -->
	<nav class="navbar navbar-expand-lg navbar-light shadow">
		<div
			class="container d-flex justify-content-between align-items-center">

			<a class="navbar-brand text-success logo h1 align-self-center"
				href="main.do"> 예담문고 </a>

			<button class="navbar-toggler border-0" type="button"
				data-bs-toggle="collapse" data-bs-target="#templatemo_main_nav"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div
				class="align-self-center collapse navbar-collapse flex-fill  d-lg-flex justify-content-lg-between"
				id="templatemo_main_nav">
				<div class="flex-fill">
					<ul
						class="nav navbar-nav d-flex justify-content-between mx-lg-auto">
						<li class="nav-item"><a class="nav-link" href="bookStorePaging.do">BOOK STORE</a>
						</li>
						<li class="nav-item"><a class="nav-link" href="event.do">EVENT</a>
						</li>
						<li class="nav-item"><a class="nav-link" href="about.do">THIS
								COMPANY</a></li>
						<li class="nav-item"><a class="nav-link" href="faq.do">FAQ</a>
						</li>
					</ul>
				</div>

				<c:if test="${not empty id }">
					<div class="dropdown">
						<button class="dropbtn">
							<span class="dropbtn_icon"></span>${member.uName}
						</button>
						<div class="dropdown-content">
							<a href="#">My Page</a>
							 <a href="memberLoginOut.do">Logout</a>
						</div>
					</div>
				</c:if>
			</div>
			<c:if test="${empty id }">
				<div class="login">
					<a href="memberLoginForm.do" class="btn btn-sm btn-primary">Login</a>
				</div>
				<div class="topbar-divider d-none d-sm-block"></div>
			</c:if>

			<div>
				<a class="nav-icon position-relative text-decoration-none" href="#">
					<span
					class="position-absolute top-0 left-0 translate-middle badge rounded-pill bg-light text-dark">장바구니</span>
				</a>
			</div>
		</div>



	</nav>
	<!-- Close Header -->
</body>
</html>
