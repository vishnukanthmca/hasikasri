$(document).ready(function() {
	$(".disabled").click(function(e) {
		e.preventDefault();
		return false;
	});

	checkuser();
	forgotpassword();
	onkeyupcode();
	onfocus();
	resend();
	// forgotpasswordSubmit();
});

function resend() {
	$("#resend").click(function(e) {
		sendVerificationCode();
		$("#forgot_password_textbox").focus();
	});
}

function onfocus() {
	$("input#verification_code_textbox").is(":focus", function(e) {
		alert(' ');
	})
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
		$("#verification_destination").html($("#emailmobile_textbox").val());
		$("#email_and_password_div").hide();
		$("#forgot_password_div").show();
		$("#verification_code_textbox").val('');
		$("#forgot_password_textbox").val('');
		$("#verification_code_textbox").focus();
		$("#forgot_password_textbox").prop("disabled", "disabled");
		$("#emailOrMobile_hidden").val($("#emailmobile_textbox").val());
	});
}

function checkuser() {
	$(".checkuser").submit(function(e) {
		e.preventDefault();
		$("#verification_code_textbox").prop("disabled", false);
		isUserExists();
	});
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
	var isUserExist = false;
	$.ajax({
		url : "isUserExists",
		method : 'POST',
		contentType : "application/json; charset=utf-8",
		data : $("#emailmobile_textbox").val(),
		success : function(data) {
			if (data === "true") {
				isUserExist = true;
				$("#emailmobile_textbox").hide();
				$("#password").val('');
				$("#password").show();
				$("#password").focus();
				$("#forgot_password").show();
			}
		}
	});

	return isUserExist;
}

function getInput() {
	var input = {
		emailOrMobile : $("#emailmobile_textbox").val()
	};

	return input;
}
