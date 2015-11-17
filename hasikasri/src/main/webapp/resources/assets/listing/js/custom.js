$(document).ready(function() {

	loadCategories();

	loadOnScrollToBottom();
	
	backToTop();
	
	slider();

});

// category supports ONLY 3 levels
function loadCategories() {

	var y = new Number($('#current_cat_id').val());
	var attributeIds = $('#attribute_ids').val();
	
	$
			.ajax({
				url : "category/getCategory",
				method : 'POST',
				contentType : "application/json; charset=utf-8",
				data : JSON.stringify(y),
				success : function(data) {

					// alert(JSON.stringify(data));

					if (data != null && data.breadcrumps != null) {
						loadRefiners(new Array(y), attributeIds);
						loadProducts(data.childrenIds, attributeIds);
						for (b = 0; b < data.breadcrumps.length; ++b) {

							var breadcrumb_name = data.breadcrumps[b].name;
							var breadcrumb_id = data.breadcrumps[b].id;

							var breadcrumb = "";

							if (data.name === breadcrumb_name) {
								breadcrumb = breadcrumb + '<li class="active">'
										+ breadcrumb_name + '</li>';
							} else {
								breadcrumb = breadcrumb
										+ '<li><a href="listing?cat='
										+ breadcrumb_id + '">'
										+ breadcrumb_name + '</a></li>';
							}

							$('#breadcrumb_category').append(breadcrumb);

						}
					}

					if (data == null || data.length <= 0) {
						alert('Could not load category - category does not exists');
						return;
					}

					var parentNodes = [];

					if (data.children != null && data.children.length > 0) {

						for (i = 0; i < data.children.length; ++i) {

							var childrenCategory = data.children[i];

							var grandChildrenNodes = [];

							if (childrenCategory.children != null
									&& childrenCategory.children.length > 0) {

								for (j = 0; j < childrenCategory.children.length; ++j) {

									var grandChildrenCategory = childrenCategory.children[j];

									var grandChildrenCategoryName = "";

									if (grandChildrenCategory != null) {
										grandChildrenCategoryName = grandChildrenCategory.name;
									}

									var greatGrandChildrenCategory = {
										text : grandChildrenCategoryName,
										href : 'listing?cat='
												+ grandChildrenCategory.id,
										tags : [ '0' ],
										nodes : ""
									}

									grandChildrenNodes
											.push(greatGrandChildrenCategory);
								}
							}

							var grandChildrenCategory = {
								text : childrenCategory.name,
								href : 'listing?cat=' + childrenCategory.id,
								tags : [ '0' ],
								nodes : ""
							}

							grandChildrenCategory.nodes = grandChildrenNodes;

							parentNodes.push(grandChildrenCategory);
						}

						parentNodes.nodes = grandChildrenNodes;
					}

					var defaultData = [];

					var masterCategory = {
						text : data.name,
						href : '#',
						tags : [ '0' ],
						nodes : ""
					};

					masterCategory.nodes = parentNodes;
					defaultData.push(masterCategory);

					$('#treeview10').treeview({
						color : "#428bca",
						enableLinks : true,
						data : defaultData
					});
				},
				failure : function(error) {
					alert(error);
				}
			});
}

function loadRefiners(categoryIds, attributeIds) {

	$.ajax({
					url : "product/findRefiners",
					method : 'POST',
					contentType : "application/json; charset=utf-8",
					data : getInputToLoadProducts(categoryIds, attributeIds.split(',').map(function(s){return Number(s);})),
					success : function(data) {
						renderRefiners(data);
					}
	});
}

function renderRefiners(refiners) {

	if (refiners != null && refiners.length > 0) {

		for (i = 0; i < refiners.length; ++i) {

			var refiner = refiners[i];

			var refiners_html = '<div class="refiner"><div class="panel panel-primary"><div class="panel-heading refiner"><button class="refiner_shrink_button" type="button" data-toggle="collapse" data-target="#shrink'
					+ refiner.name
					+ '"'
					+ 'aria-expanded="true" aria-controls="shrink">'
					+ '<span aria-hidden="false">'
					+ refiner.name
					+ '</span></button></div><div class="collapse in" id="shrink'
					+ refiner.name + '"><div class="panel-body">';

			var attributes = refiner.uniqueAttributes;

			var checkboxes = "";

			if (attributes != null && attributes.length > 0) {

				for (j = 0; j < attributes.length; ++j) {

					var attribute = attributes[j];

					var checkbox = '<div class="checkbox checkbox-success">'
							+ '<input class="refiner_checkboxes" onchange="loadProductsOnChange()" value="' + attribute.attributeIds +'" type="checkbox" id="checkbox'
							+ attribute.id + '"> <label for="checkbox'
							+ attribute.id + '"> ' + attribute.value
							+ ' </label>' + '</div>';
					checkboxes += checkbox;
				}
			}

			refiners_html += checkboxes + '</div></div></div></div>';

			$('#refiners_and_attributes').append(refiners_html);
		}
	}
}

function getInputToLoadProducts(categoryIds, attributeIds) {
	var input = {categoryIds:categoryIds,attributeIds:attributeIds};
	input = JSON.stringify(input);
	return input;
}

function loadProducts(categoryIds, attributeIds) {

	$('#child_category_ids').val(categoryIds);

	$.ajax({
		url : "product/findProducts?page=0",
		method : 'POST',
		contentType : "application/json; charset=utf-8",
		data : getInputToLoadProducts(categoryIds, attributeIds.split(',').map(function(s){return Number(s);})),
		success : function(data) {
			renderProducts(data,true);
		}
	});
}

function getProducts(categoryIds, attributeIds) {

	$.ajax({
		url : "product/findProducts?page=0",
		method : 'POST',
		contentType : "application/json; charset=utf-8",
		data : getInputToLoadProducts(categoryIds, attributeIds),
		success : function(data) {
			renderProducts(data, false);
			$(window).data('ajaxready', true);
		},
		beforeSend : function() {
			$('#loader-icon').show();
		},
		complete : function() {
			$('#loader-icon').hide();
		}
	});
}


function loadOnScrollToBottom() {

	var start = 1;

	$(window).data('ajaxready', true).scroll(
			function() {
			
			if ($(window).data('ajaxready') == false) return;
			
				if ($(window).scrollTop() >= ($(document).height() - $(window).height())) {
					
					$(window).data('ajaxready', false);
					
					$.ajax({
						url : "product/findProducts?page=" + start,
						method : 'POST',
						contentType : "application/json; charset=utf-8",
						data : getInputToLoadProducts($('#child_category_ids').val().split(',').map(function(s){return Number(s);}), $('#attribute_ids').val().split(',').map(function(s){return Number(s);})),
						success : function(data) {
							start += 1;
							renderProducts(data,true);
							$(window).data('ajaxready', true);
						},
						beforeSend : function() {
							$('#loader-icon').show();
						},
						complete : function() {
							$('#loader-icon').hide();
						}
					});
				}
			});
}

function backToTop() {
	
	var offset = 300,
	offset_opacity = 1200,
	scroll_top_duration = 700,
	$back_to_top = $('.cd-top');

	$(window).scroll(function(){
		( $(this).scrollTop() > offset ) ? $back_to_top.addClass('cd-is-visible') : $back_to_top.removeClass('cd-is-visible cd-fade-out');
		if( $(this).scrollTop() > offset_opacity ) { 
			$back_to_top.addClass('cd-fade-out');
		}
	});

	$back_to_top.on('click', function(event){
		event.preventDefault();
		$('body,html').animate({
			scrollTop: 0 ,
		 	}, scroll_top_duration
		);
	});
}

function renderProducts(data,append) {

	if (data != null && data.length > 0) {

		var all_products = "";

		for (i = 0; i < data.length; i++) {

			var id = data[i].id;
			var name = data[i].name;
			var shortName = data[i].shortName;
			var image = data[i].image;
			var price = data[i].price;
			var actualPrice = data[i].actualPrice;
			var off = data[i].off;

			var row_begin = i % 3;

			if (row_begin === 0) {

				if (i != 0) {
					all_products += '</div>';
				}

				all_products += '<div class="row product_row">';
			}

			all_products += '<div class="col-lg-4 product">'
					+ '<div class="thumbnail">'
					+ '<a href="http://google.com"><img src="' + image
					+ '" alt="' + name + '" class="thumbnail_images"></a>'
					+ '<div class="caption"><div class="product_name_div">'
					+ '<h6>' + shortName + '</h6></div>' + '<div id="' + id
					+ '" class="rating_div"></div>' + '<p class="price_info">'
					+ '<span class="price">Rs.' + price
					+ '</span> <span class="actual_price">Rs.' + actualPrice
					+ '</span></p>' + '</div></div></div>';

		}
		
		if(append === true) {
			$('.product_container').append(all_products);
		} else {
			$('.product_container').html(all_products);
		}
		

	} else {
		// $('.product_container').append('<h4>Oops. No products found.</h4>');
	}

	$.fn.raty.defaults.path = 'resources/assets/listing/images';
	assignRating(data);

}

function assignRating(data) {
	if (data != null && data.length > 0) {
		for (i = 0; i < data.length; i++) {
			var id = data[i].id;
			var rating = data[i].rating;
			$('#' + id).raty({
				readOnly : true,
				score : rating
			});
		}
	}
}


function slider() {
	 $('.nstSlider').nstSlider({
         "left_grip_selector": ".leftGrip",
         "right_grip_selector": ".rightGrip",
         "value_bar_selector": ".bar",
         "highlight": {
             "grip_class": "gripHighlighted",
             "panel_selector": ".highlightPanel"
         },
         "value_changed_callback": function(cause, leftValue, rightValue) {
             $('.leftLabel').text(leftValue);
             $('.rightLabel').text(rightValue);
         },
     });

     var highlightMin = Math.random() * 20,
         highlightMax = highlightMin + Math.random() * 80;
     $('.nstSlider').nstSlider('highlight_range', highlightMin, highlightMax);
}

function loadProductsOnChange() {
	
	var items = document.getElementsByClassName('refiner_checkboxes');
	var allAttributesIdsInPage = [];
	for(i = 0; i < items.length; i++) {
		if(items[i].checked) {
			allAttributesIdsInPage.push(items[i].value);
		}
	}
	
	if(allAttributesIdsInPage.length === 0) {
		allAttributesIdsInPage.push(-1);
	}

	document.getElementById('attribute_ids').value = allAttributesIdsInPage;

	

	getProducts($('#child_category_ids').val().split(',').map(function(s){return Number(s);}),$('#attribute_ids').val().split(',').map(function(s){return Number(s);}));
}

