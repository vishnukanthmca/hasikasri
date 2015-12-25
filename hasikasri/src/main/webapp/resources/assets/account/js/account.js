$(document).ready(function() {

	$('#edit_profile_div').click(function(e) {

		$("#myModal").modal('show');
	});

	showMobileTextbox();
	updateMobile();
	cancelMobileUpdate();
	verifyMobile();

	showEmailTextbox();
	updateEmail();
	cancelEmailUpdate();
	verifyEmail();

	showPasswordsTextBox();
	cancelPasswordChange();
});

function showPasswordsTextBox() {
	$("#update_password").click(function(e) {
		$(this).hide();
		hideAllEmail();
		hideAllMobile();

		$("#passwords_textboxes").show();
	});
}

function cancelMobileUpdate() {
	$("#cancel_update_mobile_button").click(function(e) {
		e.preventDefault();

		hideAllEmail();
		hideAllMobile();
	});
}

function showMobileTextbox() {
	$("#edit_mobile").click(function(e) {
		$("#mobile_label").hide();
		$("#mobile_textbox").show();
		$("#update_mobile_button").show();
		$("#cancel_update_mobile_button").show();
		$(this).hide();
		hideAllEmail();
	});
}

function updateMobile() {
	$('form').submit(function(evt) {

		evt.preventDefault();

		$("#new_mobile").html($("#mobile_textbox").val());
		$("#mobile_verificationcode").val('');

		var oldmobile = $("#backup_mobile").val();
		var newmobile = $("#mobile_textbox").val();

		if (oldmobile != newmobile) {
			$("#verify_mobile_message").show();
			sendSms();
		}

	});
}

function sendSms() {
	$.ajax({
		url : 'sendSms',
		method : 'GET',
		data : getMobileInput(),
		success : function(data) {
			if (data === "unauthorized") {
				window.location = "home";
			} else if (data === "verificationcodesent") {
				// $("#verification_code_labeinal").show();
			} else if (data === "failed") {

			}
		}
	});
}

function getMobileInput() {
	var input = {
		mobile : $("#mobile_textbox").val()
	};
	return input;
}

function verifyMobile() {
	$("#verify_mobile_button").click(function(e) {
		e.preventDefault();
		$.ajax({
			url : 'verifyMobile',
			method : 'GET',
			data : getMobileVerifyInput(),
			success : function(data) {
				console.log(data);
				if (data === "success") {
					window.location.href = "myaccount";
				} else if (data === "verificationcodesent") {
					$("#verification_code_label").show();
				} else if (data === "malfunctioned") {
					window.location.href = "home";
				} else if (data === "success") {
					widow.location.href = widow.location.href;
				} else if (data === "failed") {
					hideAllMobile();
				}
			}
		});
	});
}

function getMobileVerifyInput() {
	var input = {
		mobile : $("#mobile_textbox").val(),
		code : $("#mobile_verificationcode").val()
	};
	return input;
}

function hideAllMobile() {
	$("#mobile_label").show();
	$("#mobile_textbox").hide();
	$("#update_mobile_button").hide();
	$("#cancel_update_mobile_button").hide();
	$("#edit_mobile").show();
	$("#verify_mobile_message").hide();
	$("#passwords_textboxes").hide();

	$("#mobile_textbox").val($("#backup_mobile").val());

}

$(document).on('keyup', '.numeric-only', function(event) {

	var v = this.value;
	if ($.isNumeric(v) === false) {
		// chop off the last char entered
		this.value = this.value.slice(0, -1);
	}
});

// email

function showEmailTextbox() {
	$("#edit_email").click(function(e) {
		$("#email_label").hide();
		$("#email_textbox").show();
		$("#update_email_button").show();
		$("#cancel_update_email_button").show();
		$(this).hide();
		hideAllMobile();
	});
}

function updateEmail() {
	$('form').submit(function(evt) {

		evt.preventDefault();

		$("#new_email").html($("#email_textbox").val());
		$("#email_verificationcode").val('');

		var oldemail = $("#backup_email").val();
		var newemail = $("#email_textbox").val();

		if (oldemail != newemail) {
			$("#verify_email_message").show();
			sendEmail();
		}

	});
}

function cancelEmailUpdate() {
	$("#cancel_update_email_button").click(function(e) {
		e.preventDefault();
		hideAllMobile();
		hideAllEmail();
	});
}

function hideAllEmail() {
	$("#email_label").show();
	$("#email_textbox").hide();
	$("#update_email_button").hide();
	$("#cancel_update_email_button").hide();
	$("#edit_email").show();
	$("#verify_email_message").hide();
	$("#passwords_textboxes").hide();

	$("#email_textbox").val($("#backup_email").val());
}

function verifyEmail() {
	$("#verify_email_button").click(function(e) {
		e.preventDefault();
		$.ajax({
			url : 'verifyEmail',
			method : 'GET',
			data : getEmailVerifyInput(),
			success : function(data) {
				console.log(data);
				if (data === "success") {
					window.location.href = "myaccount";
				} else if (data === "verificationcodesent") {
					$("#verification_code_label").show();
				} else if (data === "malfunctioned") {
					window.location.href = "home";
				} else if (data === "success") {
					widow.location.href = widow.location.href;
				} else if (data === "failed") {
					hideAllEmail();
				}
			}
		});
	});
}
function getEmailVerifyInput() {
	var input = {
		email : $("#email_textbox").val(),
		code : $("#email_verificationcode").val()
	};
	return input;
}

function sendEmail() {
	$.ajax({
		url : 'sendEmail',
		method : 'GET',
		data : getEmailInput(),
		success : function(data) {
			if (data === "unauthorized") {
				window.location = "home";
			} else if (data === "verificationcodesent") {
				// $("#verification_code_label").show();
			} else if (data === "failed") {

			}
		}
	});
}

function getEmailInput() {
	var input = {
		email : $("#email_textbox").val()
	};
	return input;
}

function cancelPasswordChange() {
	$("#cancel_change_password_button").click(function(e) {
		e.preventDefault();
		hideAllMobile();
		hideAllEmail();
		$("#update_password").show();
	});
}
