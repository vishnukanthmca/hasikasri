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
<link href="resources/assets/checkout/css/jquery.mThumbnailScroller.css"
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
								<c:if test="${user != null}">
									<c:if test="${addresses == 'nil' }">
										<button id="add_address_button"
											class="btn btn-lg btn-primary btn-block" type="button">Add
											Address</button>
									</c:if>
									<c:if test="${addresses != 'nil' }">
										<div id="current_address_div">
											<div id="current_address_text">
												Your item(s) will be delivered to this address
												<hr />
											</div>
											<div id="current_address__display_div">
												<table>
													<tr>
														<td></td>
													</tr>
												</table>
												<div>
													<span id="name_text">${addresses[0].name }</span>
												</div>
												<div>${addresses[0].address }</div>
												<div>${addresses[0].pincode }</div>
												<div>${addresses[0].country }</div>
												<div>${addresses[0].mobile }</div>
												<div id="change_address">Change delivery address</div>
											</div>
										</div>
									</c:if>
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
	<c:if test="${user == null }">
		<script src="resources/assets/checkout/js/checkout_login.js"></script>
	</c:if>
	<script src="resources/assets/checkout/js/checkout.js"></script>
	<script src="resources/assets/checkout/js/nprogress.js"></script>
	<script src="resources/assets/checkout/js/jquery.mThumbnailScroller.js"></script>
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

	<c:if test="${addresses == 'nil' }">
		<script>
			$(document).ready(function() {
				$("#address_modal").modal('show');
			});
		</script>
	</c:if>

	<div id="address_modal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content" id="modal_content">
				<div class="modal-body">
					<div class="row" id="address_modal_row">
						<div class="col-lg-12">
							<form class="form-signin add_address_form" id="add_address_form"
								method="POST" action="addAddress">
								<div class="row address_control">
									<table>
										<tr>
											<td class="label_left"><label class="add_address_label"
												for="pincode">Pincode</label></td>
											<td width="70%"><input
												class="form-control text_box_address" type="text"
												name="pincode" id="pincode" required /></td>
										</tr>
									</table>
								</div>

								<div class="row address_control">
									<table>
										<tr>
											<td class="label_left"><label class="add_address_label"
												for="name">Name</label></td>
											<td width="70%"><input
												class="form-control text_box_address" type="text"
												name="name" id="name" required /></td>
										</tr>
									</table>
								</div>
								<div class="row address_control">
									<table>
										<tr>
											<td class="label_left"><label class="add_address_label"
												for="address">Address</label></td>
											<td width="70%"><textarea
													class="form-control text_box_address" name="address"
													id="address" required></textarea></td>
										</tr>
									</table>
								</div>
								<div class="row address_control">
									<table>
										<tr>
											<td class="label_left"><label class="add_address_label"
												for="landmark">Landmark</label></td>
											<td width="70%"><input
												class="form-control text_box_address" type="text"
												name="landmark" id="landmark" placeholder="(Optional)" /></td>
										</tr>
									</table>
								</div>
								<div class="row address_control">
									<table>
										<tr>
											<td class="label_left"><label class="add_address_label"
												for="mobile">Mobile</label></td>
											<td width="70%"><div class="input-group">
													<span class="input-group-addon" id="mobile">+91</span> <input
														type="text" name="mobile" class="form-control"
														id="mobile_textbox" aria-describedby="basic-addon1"
														required>
												</div></td>
										</tr>
									</table>
								</div>
								<div class="row address_control">
									<table>
										<tr>
											<td class="label_left">&nbsp;</td>
											<td width="70%" align="right"><div class="input-group">
													<button id="add_address_submit"
														class="btn btn-lg btn-primary btn-block" type="submit">Add</button>
												</div></td>
										</tr>
									</table>
								</div>
							</form>
						</div>
					</div>
					<div class="row">
						<c:if test="${addresses != 'nil' }">
							<div class="col-lg-12" id="right_address_list">

								<div id="content-1" class="content">
									<ul>
										<c:forEach var="address" items="${addresses }">
											<li><div class="individual_address">
													<div class="deliver_here">
														<button
															class="btn btn-lg btn-primary btn-block deliver_here_button"
															type="button">Deliver Here</button>
													</div>
													<div class="name_div_ind">
														<table>
															<tr>
																<td class="td_addr"><span id="name_text">${address.name }</span></td>
																<td class="td_addr">
																	<div>
																		<img id="edit_address"
																			src="resources/assets/checkout/images/editsvg.png"
																			height="20" width="20" />
																	</div>
																	<div>
																		<img id="edit_address"
																			src="resources/assets/checkout/images/editsvg.png"
																			height="20" width="20" />
																	</div>
																</td>
															</tr>
														</table>
													</div>
													<div class="address_div_ind">${address.address }</div>
													<div>${address.pincode }</div>
													<div class="country_div_ind">${address.country }</div>
													<div class="mobile_div_ind">${address.mobile }</div>
												</div></li>
										</c:forEach>
									</ul>
								</div>

							</div>
						</c:if>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script>
		(function($) {
			$(window).load(function() {

				$("#content-1").mThumbnailScroller({
					type : "click-50",
					theme : "buttons-out"
				});

			});
		})(jQuery);
	</script>
</body>
</html>