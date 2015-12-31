$(document).ready(function() {

	disableTab();
	checkuser();
	forgotpassword();
	onkeyupcode();
	resend();
	change();
	// forgotpasswordSubmit();
	ajax();
});

function ajax() {

	$(document).ajaxStart(function() {

		NProgress.start();

	});

	$(document).ajaxStop(function() {

		NProgress.done();

	});
}

function isValidEmail(email) {
	filter = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
	if (filter.test(email)) {
		return true;
	} else {
		return false;
	}
}

function change() {
	$(".change_email_link").click(function(e) {
		window.location = window.location.href;
	});
}

function disableTab() {
	$(".disabled").click(function(e) {
		e.preventDefault();
		return false;
	});

	$("#password").val('');
}

function resend() {
	$("#resend").click(function(e) {
		sendVerificationCode();
		$("#forgot_password_textbox").focus();
	});
}

function onkeyupcode() {
	var ready = true;
	$("input#verification_code_textbox").on("keyup", function(event) {
		if (this.value.length == this.getAttribute('maxlength')) {
			verify();
		}
	});
}

function verify() {

	$.ajax({
		url : "verifySmsOrEmail?emailOrMobile="
				+ $("#emailmobile_textbox").val() + "&code="
				+ $("#verification_code_textbox").val(),
		method : 'GET',
		contentType : "application/json; charset=utf-8",
		success : function(data) {
			if (data === "success") {
				$("#wrong").hide();
				$("#tick").show();
				$("#verification_code_textbox").attr("disabled", "disabled");
				$("#resend").remove();
				$("#forgot_password_textbox").prop("disabled", false);
				$("#forgot_password_textbox").focus();
			} else if (data === "failure") {
				$("#wrong").show();
				$("#tick").hide();
			}
		}
	});
}

function forgotpassword() {
	$("#forgot_password").click(function(e) {
		sendVerificationCode();
		forgotPasswordAfterProcess();
	});
}

function forgotPasswordAfterProcess() {
	$("#verification_destination").html($("#emailmobile_textbox").val());
	$("#email_and_password_div").hide();
	$("#forgot_password_div").show();
	$("#verification_code_textbox").val('');
	$("#forgot_password_textbox").val('');
	$("#verification_code_textbox").focus();
	$("#forgot_password_textbox").prop("disabled", "disabled");
	$("#emailOrMobile_hidden").val($("#emailmobile_textbox").val());
}

function checkuser() {
	$(".checkuser").submit(
			function(e) {
				e.preventDefault();

				if (!isValidInput()) {
					$("#login_failed_message").html(
							"Please enter your email or mobile number");
					$("#login_failed_message").show();
					return;
				}

				$("#login_failed_message").hide();
				$("#login_failed_message").html('');

				$("#verification_code_textbox").prop("disabled", false);
				$("#change_link_div").show();
				$("#loggedin_as_label").html($("#emailmobile_textbox").val());

				if (isEmpty($("#password").val())) {
					isUserExists();
				} else {
					login();
				}
			});
}

function isValidInput() {

	var validInput = false;
	var input = $("#emailmobile_textbox").val();

	if (isValidEmail(input)) {
		validInput = true;
	} else if (!isNaN(input) && input.length > 9) {
		validInput = true;
	}

	return validInput;
}

function login() {
	$.ajax({
		url : "login",
		method : 'POST',
		contentType : "application/json",
		data : getLoginInput(),
		success : function(data) {
			var message = "";
			if (data === "notregistered") {
				message = "Incorrect password. Please try again."
			} else if (data === "false") {
				message = "Invalid password. Please try again."
			} else if (data == "true") {
				window.location = window.location.href;
			}
			$("#login_failed_message").html(message);
			$("#login_failed_message").show();
		}
	});
}

function getLoginInput() {
	var login = {
		emailOrMobile : $("#emailmobile_textbox").val(),
		password : $("#password").val()
	}

	return JSON.stringify(login);
}

function sendVerificationCode() {
	$.ajax({
		url : "sendVerificationCodeForEmailOrMobile?emailOrMobile="
				+ $("#emailmobile_textbox").val(),
		method : 'GET',
		contentType : "application/json; charset=utf-8",
		success : function(data) {
			if (data === "verificationcodesent") {

			}
		}
	});
}

function isUserExists() {
	$.ajax({
		url : "isUserExists",
		method : 'POST',
		contentType : "application/json; charset=utf-8",
		data : $("#emailmobile_textbox").val(),
		success : function(data) {
			if (data === "true") {
				$("#emailmobile_textbox").hide();
				$("#password").val('');
				$("#password").show();
				$("#password").focus();
				$("#forgot_password").show();
				$("#password").prop("required", true);
			} else if (data === "false") {
				sendVerificationCode();
				forgotPasswordAfterProcess();
			}
		}
	});
}

function getInput() {
	var input = {
		emailOrMobile : $("#emailmobile_textbox").val()
	};

	return input;
}

function isEmpty(str) {
	return (!str || 0 === str.length);
}
