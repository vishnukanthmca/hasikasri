<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en" class="no-js">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,700,600'
	rel='stylesheet' type='text/css'>

<link href="resources/assets/account/css/accountreset.css"
	rel="stylesheet">

<link href="resources/assets/account/css/accountstyle.css"
	rel="stylesheet">

<!-- Resource style -->
<script src="resources/assets/account/js/modernizr.js"></script>
<!-- Modernizr -->

<title>My Account</title>
</head>
<body>
	<header class="cd-main-header">
		<h1>Animated Sign Up Flow</h1>
	</header>

	<ul class="cd-pricing">
		<li><header class="cd-pricing-header">
				<h2>Profile</h2>

				<!-- <div class="cd-price">
					<span></span> <span></span>
				</div> -->
			</header> <!-- .cd-pricing-header -->

			<div class="cd-pricing-features">
				<ul>
					<li class="available"><em>${user.mobile }</em></li>
					<li class="available"><em>${user.email }</em></li>
					<c:if test="${user.username == null}">
						<li class="unavailable"><em>add username</em></li>
					</c:if>
					<c:if test="${user.username != null}">
						<li class="available"><em>${user.username }</em></li>
					</c:if>
					<c:if test="${user.name == null}">
						<li class="unavailable"><em>add name</em></li>
					</c:if>
					<c:if test="${user.name != null}">
						<li class="available"><em>${user.name }</em></li>
					</c:if>
				</ul>
			</div> <!-- .cd-pricing-features --> <footer class="cd-pricing-footer">
				<a href="#0">EDIT</a>
			</footer> <!-- .cd-pricing-footer --></li>

		<li><header class="cd-pricing-header">
				<h2>Popular</h2>

				<div class="cd-price">
					<span>$19.99</span> <span>month</span>
				</div>
			</header> <!-- .cd-pricing-header -->

			<div class="cd-pricing-features">
				<ul>
					<li class="available"><em>Feature 1</em></li>
					<li class="available"><em>Feature 2</em></li>
					<li><em>Feature 3</em></li>
					<li><em>Feature 4</em></li>
				</ul>
			</div> <!-- .cd-pricing-features --> <footer class="cd-pricing-footer">
				<a href="#0">Select</a>
			</footer> <!-- .cd-pricing-footer --></li>

		<li><header class="cd-pricing-header">
				<h2>Premier</h2>

				<div class="cd-price">
					<span>$29.99</span> <span>month</span>
				</div>
			</header> <!-- .cd-pricing-header -->

			<div class="cd-pricing-features">
				<ul>
					<li class="available"><em>Feature 1</em></li>
					<li class="available"><em>Feature 2</em></li>
					<li class="available"><em>Feature 3</em></li>
					<li class="available"><em>Feature 4</em></li>
				</ul>
			</div> <!-- .cd-pricing-features --> <footer class="cd-pricing-footer">
				<a href="#0">Select</a>
			</footer> <!-- .cd-pricing-footer --></li>
	</ul>
	<!-- .cd-pricing -->

	<div class="cd-form">

		<div class="cd-plan-info">
			<!-- content will be loaded using jQuery - according to the selected plan -->
		</div>

		<div class="cd-more-info">
			<h3>
				Need help?
				</h4>
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
		</div>

		<form class="form" name="form">
			<fieldset>
				<legend>Account Info</legend>

				<div class="half-width">
					<label for="userName">Mobile</label> <input type="text"
						id="mobile_textbox" value="${user.mobile }" placeholder="Mobile"
						name="mobile" class="numeric-only" required title="Mobile no"
						pattern=".{10,}" maxlength="10">
				</div>

				<div class="half-width">
					<label for="userEmail">Email</label> <input type="email"
						id="email_textbox" name="userEmail">
				</div>
				<div id="change_password_div">
					<label id="change_password_label">Change password</label>
				</div>
				<div id="password_fields">
					<div class="half-width">
						<label for="userPassword">Old Password</label> <input
							type="password" id="userPassword" name="userPassword">
					</div>
					<div class="half-width">
						<label for="userPasswordRepeat">New Password</label> <input
							type="password" id="userPasswordRepeat" name="userPasswordRepeat">
					</div>
				</div>
				<div class="half-width">
					<label for="userName">Name</label> <input type="text" id="userName"
						name="userName">
				</div>
				<!-- <div class="half-width">
					<label for="userEmail">Username</label> <input type="email"
						id="userEmail" name="userEmail">
				</div>
 -->

			</fieldset>

			<fieldset>
				<legend>Payment Method</legend>

				<div id="verification_code_label">
					<table id="mobile_verification_heading">
						<tr>
							<td colspan="2"><label>Enter verification code sent
									to mobile</label></td>
						</tr>
					</table>
					<table>
						<tr>
							<td class="verify_mobile"><input type="text"
								id="mobile_verificationcode"></td>
							<td class="verify_mobile"><button id="verify_mobile_button">Verify</button></td>
						</tr>
					</table>
					<table id="resend_table">
						<tr>
							<td><a id="resend_code">Resend</a></td>
							<td><label id="mobile_verification_code_incorrect"
								class="error_message">Incorrect verification code.
									Please type it again.</label></td>
						</tr>
					</table>
				</div>

				<div class="cd-credit-card">
					<div>
						<p class="half-width">
							<label for="cardNumber">Card Number</label> <input type="text"
								id="cardNumber" name="cardNumber">
						</p>

						<p class="half-width">
							<label>Expiration date</label> <b> <span class="cd-select">
									<select name="card-expiry-month" id="card-expiry-month">
										<option value="1">1</option>
										<option value="1">2</option>
										<option value="1">3</option>
										<option value="1">4</option>
										<option value="1">5</option>
										<option value="1">6</option>
										<option value="1">7</option>
										<option value="1">8</option>
										<option value="1">9</option>
										<option value="1">10</option>
										<option value="1">11</option>
										<option value="1">12</option>
								</select>
							</span> <span class="cd-select"> <select name="card-expiry-year"
									id="card-expiry-year">
										<option value="2015">2015</option>
										<option value="2015">2016</option>
										<option value="2015">2017</option>
										<option value="2015">2018</option>
										<option value="2015">2019</option>
										<option value="2015">2020</option>
								</select>
							</span>
							</b>
						</p>

						<p class="half-width">
							<label for="cardCvc">Card CVC</label> <input type="text"
								id="cardCvc" name="cardCvc">
						</p>
					</div>
				</div>
				<!-- .cd-credit-card -->
			</fieldset>

			<fieldset>
				<div>
					<button type="submit" value="UPDATE" id="update">UPDATE</button>
				</div>
			</fieldset>
		</form>

		<a href="#0" class="cd-close"></a>
	</div>
	<!-- .cd-form -->

	<div class="cd-overlay"></div>
	<!-- shadow layer -->
	<script src="resources/assets/register/js/jquery-2.1.4.min.js"></script>
	<script src="resources/assets/account/js/velocity.min.js"></script>
	<script src="resources/assets/account/js/main.js"></script>
	<script src="resources/assets/account/js/account.js"></script>
	<!-- Resource jQuery -->
	<input type="hidden" value="${user.mobile }" id="backup_mobile" />
	<input type="hidden" value="${user.email }" id="backup_email" />
</body>
</html>