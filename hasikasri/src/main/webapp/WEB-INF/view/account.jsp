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
				<legend>Profile</legend>
				<div id="main_container">
					<div class="row">
						<div class="half-width" id="mobile_div">
							<label id="mobile_label">${user.mobile }</label> <input
								type="text" id="mobile_textbox" value="${user.mobile }"
								placeholder="Mobile" name="mobile" class="numeric-only" required
								title="Mobile no" pattern=".{10,}" maxlength="10">
						</div>
						<div class="half-width">
							<a id="edit_mobile">Edit</a>
							<button type="submit" id="update_mobile_button">UPDATE</button>
							<button type="submit" id="cancel_update_mobile_button">CANCEL</button>
						</div>
					</div>
					<div id="verify_mobile_message">
						<div>
							<div class="verify_mobile_message_text">
								<span> Verification code sent to <span id="new_mobile"></span></span>
							</div>
							<div class="half-width"></div>
						</div>
						<div class="row">
							<div class="half-width">
								<input type="text" id="mobile_verificationcode">
							</div>
							<div class="half-width">
								<button id="verify_mobile_button">Verify</button>
							</div>
						</div>

					</div>
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