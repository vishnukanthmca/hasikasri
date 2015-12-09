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
	} else {
		// evt.preventDefault();
		// post();
		// console.log("after post called");
	}

});

function post() {

	$.ajax({
		url : "join",
		method : 'POST',
		contentType : "application/json; charset=utf-8",
		data : getInput(),
		success : function(data) {
			console.log(data);
		}
	});
}

function getInput() {

	var user = {
		name : $("#name").val(),
		id : $("#id").val(),
		email : $("#email").val()
	}

	return user;
}
