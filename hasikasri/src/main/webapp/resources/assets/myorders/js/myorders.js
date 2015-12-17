$(document).ready(function() {
	pills();
});

function pills() {
	// $('#rootwizard').bootstrapWizard({
	// 'tabClass' : 'nav nav-pills'
	// });

	$('#rootwizard').bootstrapWizard();

}

function showReturnBox(id) {
	if ($('#' + id).is(':visible')) {
		$('#' + id).hide();
	} else {
		$('#' + id).show();
	}
}
