<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Checkout</title>

<link href="resources/assets/checkout/css/bootstrap.min.css"
	rel="stylesheet">
<link href="resources/assets/checkout/css/prettify.css" rel="stylesheet">
<link href="resources/assets/checkout/css/checkout.css" rel="stylesheet">
<link href="resources/assets/checkout/css/nprogress.css"
	rel="stylesheet">

</head>
<body>


	<!-- Fixed navbar -->
	<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">Project name</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse"></div>
		<!--/.nav-collapse -->
	</div>
	</nav>

	<div class="container">

		<div class="jumbotron">
			<div id="rootwizard" class="tabbable tabs-left">
				<ul>

					<li><a href="#tab1" data-toggle="tab">Review Order</a></li>
					<li class="disabled"><a href="#tab2" data-toggle="tab">Secure
							Payment</a></li>
				</ul>
				<div class="tab-content">
					<div class="tab-pane" id="tab1">
						<div class="panel panel-default" id="panel_overall">
							<!-- <div class="panel-heading" id="checkout_heading">
								<h3 class="panel-title">Please Identify yourself</h3>
							</div> -->
							<div class="panel-body">
								<!-- <h2 class="form-signin-heading">Please sign in</h2> -->
								<!-- <label for="inputEmail" class="sr-only">Email address or
							mobile no</label>  -->
								<c:if test="${user == null }">
									<div id="email_and_password_div">
										<form class="form-signin checkuser">
											<div id="login_failed_message"></div>
											<div id="change_link_div">
												<label id="loggedin_as_label"></label><img
													class="change_email_link"
													src="resources/assets/checkout/images/editsvg.png"
													height="20" width="20" />
											</div>
											<input type="text" id="emailmobile_textbox"
												class="form-control"
												placeholder="Email address or mobile number" required
												autofocus /> <input class="form-control"
												placeholder="Enter your password" value="" type="password"
												id="password" autofocus />
											<button id="continue_button"
												class="btn btn-lg btn-primary btn-block" type="submit">Continue</button>
											<a id="forgot_password">Forgot password?</a>
										</form>
									</div>
									<div id="forgot_password_div">
										<form class="form-signin forgot_pwd"
											action="changePasswordOnCheckout" method="post">
											<div class="row" id="verification_msg_div">
												Verification code sent to <span
													id="verification_destination"></span><span
													id="change_email"><img class="change_email_link"
													src="resources/assets/checkout/images/editsvg.png"
													height="20" width="20" /></span>
											</div>
											<div class="row">
												<div id="left">
													<input type="text" id="verification_code_textbox"
														class="form-control"
														placeholder="Enter the verification code" maxlength="4"
														required autofocus />
												</div>
												<div id="right">
													<img height="50"
														src="resources/assets/checkout/images/tick.png" id="tick" />
													<img height="50"
														src="resources/assets/checkout/images/wrong.jpg"
														id="wrong" />
												</div>
											</div>
											<div class="row">
												<a id="resend">Resend</a>
											</div>
											<div class="row">
												<input class="form-control" placeholder="Set a password"
													value="" name="newPassword" type="password"
													id="forgot_password_textbox" />
											</div>
											<div class="row">
												<button id="forgot_password_continue_button"
													class="btn btn-lg btn-primary btn-block" type="submit">Continue</button>
												<input type="hidden" name="emailOrMobile"
													id="emailOrMobile_hidden" />
											</div>
										</form>
									</div>
								</c:if>
								<c:if test="${user != null }">

								</c:if>
							</div>
						</div>


					</div>
					<div class="tab-pane" id="tab2">2</div>
				</div>
			</div>

		</div>
	</div>
	<!-- /container -->

	<script src="resources/assets/checkout/js/jquery-2.1.4.min.js"></script>
	<script src="resources/assets/checkout/js/bootstrap.min.js"></script>
	<script src="resources/assets/checkout/js/jquery.bootstrap.wizard.js"></script>
	<script src="resources/assets/checkout/js/prettify.js"></script>
	<script src="resources/assets/checkout/js/checkout.js"></script>
	<script src="resources/assets/checkout/js/nprogress.js"></script>
	<script>
		$(document).ready(function() {
			$('#rootwizard').bootstrapWizard({
				'tabClass' : 'nav nav-tabs'
			});
			window.prettyPrint && prettyPrint()
		});
	</script>

	<script>
		$('body').show();
		$('.version').text(NProgress.version);
		NProgress.start();
		setTimeout(function() {
			NProgress.done();
			$('.fade').removeClass('out');
		}, 1000);
	</script>

</body>
</html>