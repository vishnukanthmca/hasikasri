<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Join yy</title>




<link rel="stylesheet" href="css/style.css">

<link href="resources/assets/register/css/style.css" rel="stylesheet">


</head>

<body>

	<div class="wrapper">
		<div class="container">
			<h1>Welcome</h1>
			<c:if test="${userExists}">
				<div id="error_message">
					User already exists.Please login. <a id="anchor" href="home">Go
						to login page</a>
				</div>
			</c:if>
			<form class="form" action="register" method="post">
				<input type="text" id="name" placeholder="Mobile" name="mobile"
					class="numeric-only" required title="Mobile no" pattern=".{10,}"
					maxlength="10"> <input id="email" name="email" type="email"
					placeholder="Email" required title="Email"> <input
					type="password" id="password" placeholder="Password"
					name="password" pattern=".{3,}" required title="Min 3 characters">
				<button type="submit" id="login-button">Join</button>
			</form>
		</div>
		<ul class="bg-bubbles">
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
		</ul>
	</div>
	<script src="resources/assets/register/js/jquery-2.1.4.min.js"></script>
	<script src="resources/assets/register/js/index.js"></script>




</body>
</html>
