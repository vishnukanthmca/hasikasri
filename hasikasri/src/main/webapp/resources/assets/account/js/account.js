$(document).ready(function() {

	profile();
	update();
	verifyMobile();

});

function update() {
	$('#update').click(function(evt) {

		evt.preventDefault();

		var oldmobile = $("#backup_mobile").val();
		var newmobile = $("#mobile_textbox").val();

		console.log(oldmobile + " " + newmobile);

		if (oldmobile != newmobile) {
			sendSms();
		}
	});
}

function profile() {
	$("#change_password_label").click(function(e) {
		$("#password_fields").toggle(500);
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
				$("#verification_code_label").show();
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

function getMobileVerifyInput() {
	var input = {
		mobile : $("#mobile_textbox").val(),
		code : $("#mobile_verificationcode").val()
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
				}
			}
		});
	});
}
