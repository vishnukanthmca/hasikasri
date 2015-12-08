jQuery(document)
		.ready(
				function($) {

					$("#modal_trigger").leanModal({
						top : 100,
						overlay : 0.6,
						closeButton : ".modal_close"
					});

					$(function() {
						// Calling Login Form
						$("#login_form").click(function() {
							$(".social_login").hide();
							$(".user_login").show();
							return false;
						});

						// Calling Register Form
						$("#register_form").click(function() {
							$(".social_login").hide();
							$(".user_register").show();
							$(".header_title").text('Register');
							return false;
						});

						// Going back to Social Forms
						$(".back_btn").click(function() {
							$(".user_login").hide();
							$(".user_register").hide();
							$(".social_login").show();
							$(".header_title").text('Login');
							return false;
						});

					})

					// if you change this breakpoint in the style.css file (or
					// _layout.scss if you use SASS), don't forget to update
					// this value as well
					var $L = 1200, $menu_navigation = $('#main-nav'), $cart_trigger = $('#cd-cart-trigger'), $hamburger_icon = $('#cd-hamburger-menu'), $lateral_cart = $('#cd-cart'), $shadow_layer = $('#cd-shadow-layer');

					// open lateral menu on mobile
					$hamburger_icon.on('click', function(event) {
						event.preventDefault();
						// close cart panel (if it's open)
						$lateral_cart.removeClass('speed-in');
						toggle_panel_visibility($menu_navigation,
								$shadow_layer, $('body'));
					});

					// open cart
					$cart_trigger.on('click', function(event) {
						event.preventDefault();
						// close lateral menu (if it's open)
						$menu_navigation.removeClass('speed-in');
						toggle_panel_visibility($lateral_cart, $shadow_layer,
								$('body'));
					});

					// close lateral cart or lateral menu
					$shadow_layer
							.on(
									'click',
									function() {
										$shadow_layer.removeClass('is-visible');
										// firefox transitions break when parent
										// overflow is changed, so we need to
										// wait for the end of the trasition to
										// give the body an overflow hidden
										if ($lateral_cart.hasClass('speed-in')) {
											$lateral_cart
													.removeClass('speed-in')
													.on(
															'webkitTransitionEnd otransitionend oTransitionEnd msTransitionEnd transitionend',
															function() {
																$('body')
																		.removeClass(
																				'overflow-hidden');
															});
											$menu_navigation
													.removeClass('speed-in');
										} else {
											$menu_navigation
													.removeClass('speed-in')
													.on(
															'webkitTransitionEnd otransitionend oTransitionEnd msTransitionEnd transitionend',
															function() {
																$('body')
																		.removeClass(
																				'overflow-hidden');
															});
											$lateral_cart
													.removeClass('speed-in');
										}
									});

					// move #main-navigation inside header on laptop
					// insert #main-navigation after header on mobile
					move_navigation($menu_navigation, $L);
					$(window).on(
							'resize',
							function() {
								move_navigation($menu_navigation, $L);

								if ($(window).width() >= $L
										&& $menu_navigation
												.hasClass('speed-in')) {
									$menu_navigation.removeClass('speed-in');
									$shadow_layer.removeClass('is-visible');
									$('body').removeClass('overflow-hidden');
								}

							});

					displayCart();
				});

function toggle_panel_visibility($lateral_panel, $background_layer, $body) {
	if ($lateral_panel.hasClass('speed-in')) {
		// firefox transitions break when parent overflow is changed, so we need
		// to wait for the end of the trasition to give the body an overflow
		// hidden
		$lateral_panel
				.removeClass('speed-in')
				.one(
						'webkitTransitionEnd otransitionend oTransitionEnd msTransitionEnd transitionend',
						function() {
							$body.removeClass('overflow-hidden');
						});
		$background_layer.removeClass('is-visible');

	} else {
		$lateral_panel
				.addClass('speed-in')
				.one(
						'webkitTransitionEnd otransitionend oTransitionEnd msTransitionEnd transitionend',
						function() {
							$body.addClass('overflow-hidden');
						});
		$background_layer.addClass('is-visible');
	}
}

function move_navigation($navigation, $MQ) {
	if ($(window).width() >= $MQ) {
		$navigation.detach();
		$navigation.appendTo('header');
	} else {
		$navigation.detach();
		$navigation.insertAfter('header');
	}
}

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
		$("a.cd-go-to-cart").attr("href", "#");
	} else {
		$('.cd-cart-items').html(html);
		$('.cd-cart-total').show();
		$('.checkout-btn').html("Checkout");
		$("a.checkout-btn").attr("href", "hello");
		$('.cd-go-to-cart').html("Go to cart page");
		$("a.cd-go-to-cart").attr("href", "google");
	}
	$('#cart_total').html("Rs. " + total);

}
