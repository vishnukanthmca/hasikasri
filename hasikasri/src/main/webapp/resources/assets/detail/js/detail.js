$(document).ready(function() {
	search();
	zoom();
	raty();
	pills();
	displayCart();

});

function removeFromCart(productPid) {
	var cart = localStorage.getItem("cart");
	var products = JSON.parse(cart);

	if (products == null) {
		products = new Array();
	}

	for (i = 0; i < products.length; i++) {
		var pid = products[i].pid;

		if (productPid === pid) {
			products.splice(i, 1);
		}
	}

	localStorage.setItem("cart", JSON.stringify(products));
	displayCart();
}

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
			var newQuantity = (parseInt(products[i].quantity) + parseInt($(
					'#quantity').val()));
			var newPrice = parseInt(productPrice) * newQuantity;

			products[i].quantity = newQuantity;
			products[i].price = newPrice;
			isDuplicate = true;
		}
	}

	if (!isDuplicate) {

		var updatedPrice = parseInt($('#quantity').val())
				* parseInt(productPrice);

		var product = {
			pid : productPid,
			name : productName,
			price : updatedPrice,
			image : 'resources/assets/detail/images/small/image1.png',
			quantity : $('#quantity').val()
		};

		products.push(product);
	}

	localStorage.setItem("cart", JSON.stringify(products));
	displayCart();
	if (!$('#cd-cart').hasClass('speed-in')) {
		$('#main-nav').removeClass('speed-in');
		toggle_panel_visibility($('#cd-cart'), $('#cd-shadow-layer'), $('body'));
	}
}

function displayCart() {

	var string = localStorage.getItem("cart");
	var products = JSON.parse(string);

	var html = "";

	var total = 0;

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
					+ '<td><a href="#0" onclick="removeFromCart('
					+ pid
					+ ')" class="cd-item-remove cd-img-replace">Remove</a></td></tr></table></li>';
			html += node;
			total += parseInt(price);
		}
	}

	if (isEmpty(html)) {
		$('.cd-cart-items').html(
				"<div class='empty_cart'>Your cart is empty.</div>");
		$('.cd-cart-total').hide();
		$('.checkout-btn').html("");
		$("a.checkout-btn").attr("href", "#");
		$('.cd-go-to-cart').html("");
		("a.cd-go-to-cart").attr("href", "#");
	} else {
		$('.cd-cart-items').html(html);
		$('.cd-cart-total').show();
		$('.checkout-btn').html("Checkout");
		$("a.checkout-btn").attr("href", "hello");
		$('.cd-go-to-cart').html("Go to cart page");
		$("a.cd-go-to-cart").attr("href", "google");
	}
	$('#cart_total').html(total);

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

function isEmpty(str) {
	return (!str || 0 === str.length);
}
