$(document).ready(function() {

	showMobileTextbox();
	updateMobile();
	cancelMobileUpdate();
	verifyMobile();
});

function cancelMobileUpdate() {
	$("#cancel_update_mobile_button").click(function(e) {
		e.preventDefault();

		hideAll();
	});
}

function showMobileTextbox() {
	$("#edit_mobile").click(function(e) {
		$("#mobile_label").hide();
		$("#mobile_textbox").show();
		$("#update_mobile_button").show();
		$("#cancel_update_mobile_button").show();
		$(this).hide();
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
				// $("#verification_code_label").show();
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
					hideAll();
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

function hideAll() {
	$("#mobile_label").show();
	$("#mobile_textbox").hide();
	$("#update_mobile_button").hide();
	$("#cancel_update_mobile_button").hide();
	$("#edit_mobile").show();
	$("#verify_mobile_message").hide();

	$("#mobile_textbox").val($("#backup_mobile").val());

}

$(document).on('keyup', '.numeric-only', function(event) {

	var v = this.value;
	if ($.isNumeric(v) === false) {
		// chop off the last char entered
		this.value = this.value.slice(0, -1);
	}
});
