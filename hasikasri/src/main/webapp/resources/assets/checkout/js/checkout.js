$(document).ready(function() {

	// $("#address_modal").modal('show');

	$('#edit_profile_div').click(function(e) {

		$("#myModal").modal('show');
	});

	showdialog();
	addaddress();
});

function showdialog() {
	$("#add_address_button").click(function(e) {
		$("#address_modal").modal('show');
	});

	$("#change_address").click(function(e) {
		$("#address_modal").modal('show');
	});
}

function addaddress() {
	$(".add_address_form").submit(function(e) {
		// console.log("hi");
		// e.preventDefault();
	});
}

function addAddressAjax() {
	$.ajax({
		url : "addAddress",
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

function addAddressInput() {
	var input = {

	}
}