$(document).ready(function() {
	pills();
});

function pills() {
	// $('#rootwizard').bootstrapWizard({
	// 'tabClass' : 'nav nav-pills'
	// });

	$('#rootwizard').bootstrapWizard();

}

function placeReturnRequest(orderItemId) {
	console.log(orderItemId);
	$("#myModal").modal('show');
}

function showReturnBox(id) {
	if ($('#' + id).is(':visible')) {
		$('#' + id).hide();
	} else {
		$('#' + id).show();
	}
}
