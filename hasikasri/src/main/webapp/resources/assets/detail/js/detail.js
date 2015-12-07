$(document).ready(function() {
	search();
	zoom();
	raty();
	pills();
	displayCart();

});

function addToCart(productPid, productPrice, productName) {

	var cart = localStorage.getItem("cart");
	var products = JSON.parse(cart);

	if (products == null) {
		products = new Array();
	}

	var isDuplicate = false;

	for (i = 0; i < products.length; i++) {
		var pid = products[i].pid;

		if (productPid === pid) {
			products[i].quantity = (parseInt(products[i].quantity) + parseInt($(
					'#quantity').val()));
			isDuplicate = true;
		}
	}

	if (!isDuplicate) {
		var product = {
			pid : productPid,
			name : productName,
			price : productPrice,
			image : 'resources/assets/detail/images/small/image1.png',
			quantity : $('#quantity').val()
		};

		products.push(product);
	}

	localStorage.setItem("cart", JSON.stringify(products));
	displayCart();
	if (!$('#cd-cart').hasClass('speed-in')) {
		// close lateral menu (if it's open)
		$('#main-nav').removeClass('speed-in');
		toggle_panel_visibility($('#cd-cart'), $('#cd-shadow-layer'), $('body'));
	}
}

function displayCart() {

	var string = localStorage.getItem("cart");
	// console.log("existing cart " + string);
	var products = JSON.parse(string);

	var html = "";

	if (products != null) {
		for (i = 0; i < products.length; i++) {

			var pid = products[i].pid;
			var name = products[i].name;
			var price = products[i].price;
			var image = products[i].image;
			var quantity = products[i].quantity;

			var node = '<li><table><tr><td class="cart_td"><img	src="'
					+ image
					+ '" height="50" width="75" /></td>'
					+ '<td class="cart_td"><span class="cd-qty">'
					+ quantity
					+ 'x</span></td>'
					+ '<td class="cart_td" width="200">'
					+ name
					+ '</td>'
					+ '<td class="cart_td"><div class="cd-price">Rs.'
					+ price
					+ '</div></td>'
					+ '<td><a href="#0" class="cd-item-remove cd-img-replace">Remove</a></td></tr></table></li>';
			html += node;
		}
	}

	$('.cd-cart-items').html(html);

	// // alert(object.age);
	// var obj = {
	// name : "velmani",
	// age : 28
	// };
	//
	// var obj1 = {
	// name : "vishnu",
	// age : 29
	// };
	//
	// var arr = new Array();
	// arr.push(obj);
	// arr.push(obj1);
	//
	// localStorage.setItem("cart", JSON.stringify(arr));

	// $('.cd-cart-items').html();
}

function pills() {
	// $('#rootwizard').bootstrapWizard({
	// 'tabClass' : 'nav nav-pills'
	// });

	$('#rootwizard').bootstrapWizard();

}

function raty() {
	$.fn.raty.defaults.path = 'resources/assets/detail/images';
	$('#rating').raty({
		readOnly : true,
		score : function() {
			return $(this).attr('data-score');
		}
	});
}

function zoom() {
	// initiate the plugin and pass the id of the div containing gallery images
	$("#zoom_03").elevateZoom({
		gallery : 'gallery_01',
		cursor : 'pointer',
		galleryActiveClass : 'active',
		imageCrossfade : true,
		zoomWindowWidth : 570,
		zoomWindowHeight : 430,
		loadingIcon : 'resources/assets/listing/images/GreenLoader.gif'
	});

	// pass the images to Fancybox
	$("#zoom_03").bind("click", function(e) {
		var ez = $('#zoom_03').data('elevateZoom');
		$.fancybox(ez.getGalleryList());
		return false;
	});

}

function search() {

	// Instantiate the Bloodhound suggestion engine
	var keywordsEngine = new Bloodhound(
			{
				datumTokenizer : function(datum) {
					return Bloodhound.tokenizers.whitespace(datum.value
							.toString());
				},
				queryTokenizer : Bloodhound.tokenizers.whitespace,
				// local : keywords,
				remote : {
					url : 'search/getTerms?',

					replace : function(url, uriEncodedQuery) {
						var val = $(".typeahead").filter(":focus").attr("id")
								.slice(0, -2);
						var res = (url + "&query=" + encodeURIComponent(uriEncodedQuery));
						return res
					},
					filter : function(keywords) {
						// Map the remote source JSON array to a JavaScript
						// object array
						return $.map(keywords, function(keyword) {
							console.log("keyword " + JSON.stringify(keywords));
							return {
								value : keyword.name
							};
						});
					}
				},
				dupDetector : function(remoteMatch, localMatch) {
					return remoteMatch.value === localMatch.value;
				}

			// },
			// prefetch : {
			// url : 'resources/assets/listing/js/keywords.json',
			// filter : function(keywords) {
			// // Map the remote source JSON array to a JavaScript object array
			// return $.map(keywords, function(keyword) {
			// return {
			// value : keyword.value
			// };
			// });
			// }
			// }
			});

	// kicks off the loading/processing of `local` and `prefetch`
	// keywordsEngine.initialize();

	$('#scrollable-dropdown-menu .typeahead').typeahead(null, {
		name : 'keyword',
		displayKey : 'value',
		// `ttAdapter` wraps the suggestion engine in an adapter that
		// is compatible with the typeahead jQuery plugin
		source : keywordsEngine.ttAdapter()
	});
}
