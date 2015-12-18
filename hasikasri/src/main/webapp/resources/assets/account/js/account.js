$(document).ready(function() {

	profile();

});

function profile() {
	$("#change_password_label").click(function(e) {
		$("#password_fields").toggle(500);
	});
}
