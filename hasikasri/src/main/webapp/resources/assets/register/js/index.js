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

$(document).ready(function() {
	$('a').on('click', function() {
		window.location.href = "home";
	});
});
