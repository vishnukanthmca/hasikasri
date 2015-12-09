//$("#login-button").click(function(event) {
//	event.preventDefault();
//
//	$('form').fadeOut(500);
//	$('.wrapper').addClass('form-success');
//});

$(document).on('keyup', '.numeric-only', function(event) {

	var v = this.value;
	if ($.isNumeric(v) === false) {
		// chop off the last char entered
		this.value = this.value.slice(0, -1);
	}
});

$('.form').submit(function(evt) {
	if (!$('.form').validate()) {
		evt.preventDefault();
	}
});