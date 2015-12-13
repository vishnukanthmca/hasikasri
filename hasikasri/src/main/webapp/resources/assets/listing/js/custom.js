var CURRENT_CATEGORY = "cat";
var CHILD_CATEGORIES = "child_cat";
var ATTRIBUTES = "ref";
var SPLIT_CHAR = "^";
var JOIN_CHAR = "_";
var SPLIT_CHAR_ATTRIBUTES = ":";
var SORT = "sort";

$(document).ready(function() {

	getCategories();

	// listeners
	sort();
	search();
	login();
	loadOnScrollToBottom();
});

function reRenderPage(append) {
	getRefiners(append);
}

function getProducts(append) {

	var page = getRequestParam("page");

	if (isEmpty(page)) {
		page = 0;
	}

	$.ajax({
		url : "product/findProducts?page=" + page,
		method : 'POST',
		contentType : "application/json; charset=utf-8",
		data : getInput(),
		success : function(data) {
			renderProducts(data, append);
		}
	});
}

function renderProducts(data, append) {

	if (data != null && data.length > 0 && !isEmpty(data)) {

		var all_products = "";

		for (i = 0; i < data.length; i++) {

			var id = data[i].id;
			var name = data[i].name;
			var shortName = data[i].shortName;
			var image = data[i].image;
			var price = data[i].price;
			var actualPrice = data[i].actualPrice;
			var discount = data[i].discount;

			var row_begin = i % 3;

			if (row_begin === 0) {

				if (i != 0) {
					all_products += '</div>';
				}

				all_products += '<div class="row product_row">';
			}

			all_products += '<div class="col-lg-4 product">'
					+ '<div class="thumbnail">' + '<a><img src="'
					+ image
					+ '" alt="'
					+ name
					+ '" class="thumbnail_images" onclick="postToDetail('
					+ id
					+ ')" id="product'
					+ id
					+ '"></a>'
					+ '<div class="caption"><div class="product_name_div">'
					+ '<h6>'
					+ shortName
					+ '</h6></div>'
					+ '<div id="'
					+ id
					+ '" class="rating_div"></div>'
					+ '<p class="price_info">'
					+ '<span class="price">Rs.'
					+ price
					+ '</span> <span class="actual_price">Rs.'
					+ actualPrice
					+ '</span></p>' + '</div></div></div>';

		}

		if (append === true) {
			$('.product_container').append(all_products);
		} else {
			$('.product_container').html(all_products);
		}

	} else {
		if (append === false) {
			$('.product_container').html('<h4>Oops. No products found.</h4>');
		}
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

// refiner related method starts here
function getSelectedRefiners() {
	var checkedBoxes = [ "-1" ];
	$("input[name=refiner_checkboxes]:checked").map(
			function() {
				var label = $('#' + this.id).next("label").html();
				var value = label + SPLIT_CHAR_ATTRIBUTES
						+ getFirstValueFromId(this.id);
				checkedBoxes.push(value);
			});

	return checkedBoxes;
}

function getFirstValueFromId(id) {
	var ids = id.split(JOIN_CHAR);
	return ids[0];
}

function makeSelectedFromParam() {

	var param = getRequestParam(ATTRIBUTES);
	var refiners = param.split(",");

	$('#sort_div_left').empty();

	$("input[name=refiner_checkboxes]").each(function(index, element) {
		for (i = 0; i < refiners.length; i++) {
			if (isSameAttribute(refiners[i], element.id)) {
				$(this).prop('checked', true);
				addButtons(element.name, element.id);
			}
		}
	});
}

function addButtons(name, id) {
	var buttonId = 'button' + getLabelText(id) + SPLIT_CHAR_ATTRIBUTES
			+ getFirstValueFromId(id);

	var exists = false;

	$('button', $('#sort_div_left')).each(function() {
		if ($(this).prop("id") == buttonId) {
			exists = true;
			return;
		}
	});

	if (exists == false) {
		$('#sort_div_left')
				.append(
						'<button type="button" onclick="buttonClick(\''
								+ buttonId
								+ '\')" class="btn btn-primary btn-xs refiner_buttons" id="'
								+ buttonId
								+ '"><span class="glyphicon glyphicon-remove"></span>'
								+ getLabelText(id) + ' </button>');
	}
}

function buttonClick(id) {
	var button = id.replace('button', '');
	$("input[name=refiner_checkboxes]").each(function(index, element) {
		if (isSameAttribute(button, element.id)) {
			$(this).prop("checked", false);
		}
	});

	replaceRequestParameterForCheckBoxes(ATTRIBUTES, getSelectedRefiners());
	getProductsOnRefinerChange();
	// highlightCheckBoxes();
}

function isSameAttribute(param, checkboxId) {
	var label = getLabelText(checkboxId);
	var attr = label + SPLIT_CHAR_ATTRIBUTES + getFirstValueFromId(checkboxId);

	var isSame = attr === param;
	return isSame;
}

function getLabelText(id) {
	return $('#' + id).next("label").html();
}

function highlightCheckBoxes() {
	makeSelectedFromParam();
}

function getProductsOnRefinerChange() {
	// highlightCheckBoxes();
	reRenderPage(false);
}

function getIdsOfCheckboxes(names) {

	var selectedAttributesId = [];

	$("input[name=refiner_checkboxes]").each(function(index, element) {
		for (i = 0; i < names.length; i++) {
			if (isSameAttribute(names[i], element.id)) {
				selectedAttributesId.push(element.value);
			}
		}
	});

	return selectedAttributesId;
}

function getInput() {

	var param = getRequestParam(ATTRIBUTES);
	var attributeIds = param.split(",");
	var ids = "-1";

	if (attributeIds[0].indexOf("-1") > -1 && attributeIds.length <= 1) {
	} else {
		ids = getIdsOfCheckboxes(attributeIds).join(",");
	}

	var categoryIds = getRequestParam(CHILD_CATEGORIES);

	var numericAttributeIds = ids.split(',').map(function(s) {
		return Number(s);
	});

	var numericCategoryIds = categoryIds.split(',').map(function(s) {
		return Number(s);
	});

	var input = {
		categoryIds : numericCategoryIds,
		attributeIds : numericAttributeIds,
		sort : getRequestParam(SORT)
	};

	input = JSON.stringify(input);
	return input;
}

function getRefiners(append) {

	$.ajax({
		url : "product/findRefiners",
		method : 'POST',
		contentType : "application/json; charset=utf-8",
		data : getInput(),
		success : function(data) {
			renderRefiners(append, data);
		}
	});
}

function renderRefiners(append, filters) {

	var refiners = filters.refiners;

	$('#refiners_and_attributes').empty();

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

					var idAndValue = changeCommaSeparatedToHashSeparated(
							attribute.attributeIds, refiner.name);

					var checkbox = '<div class="checkbox checkbox-success">'
							+ '<input name="refiner_checkboxes" class="refiner_checkboxes" id="'
							+ idAndValue
							+ '" onchange="replaceRequestParameterForCheckBoxes(ATTRIBUTES, getSelectedRefiners());getProductsOnRefinerChange();" value="'
							+ attribute.attributeIds
							+ '" type="checkbox" id="checkbox' + attribute.id
							+ '"> <label for="' + idAndValue + '">'
							+ attribute.value + '</label>' + '</div>';
					checkboxes += checkbox;
				}
			}

			refiners_html += checkboxes + '</div></div></div></div>';

			$('#refiners_and_attributes').append(refiners_html);
		}
	}

	highlightCheckBoxes();

	getProducts(append);

}

function changeCommaSeparatedToHashSeparated(attributeIds, refinerName) {
	var comma = attributeIds.sort();
	var value = refinerName + comma.join(JOIN_CHAR);
	return value;
}

// refiner related method ends here

function getCategories() {

	var attributeIds = $('#attribute_ids').val();

	$
			.ajax({
				url : "category/getCategory",
				method : 'POST',
				contentType : "application/json; charset=utf-8",
				data : JSON.stringify($('#current_cat_id').val()),
				success : function(data) {

					if (data != null && data.breadcrumps != null) {

						replaceRequestParameter(CHILD_CATEGORIES,
								data.childrenIds);

						updateRequestParameter(ATTRIBUTES,
								getRequestParamForAttributes());

						createRequestParamForSort();

						replaceRequestParameter("page", 0);

						reRenderPage(false);

						$('#child_category_ids').val(data.childrenIds);

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

function getRequestParamForAttributes() {
	var attr = getRequestParam(ATTRIBUTES);
	if (isEmpty(attr)) {
		return -1;
	}

	return attr;
}

function sort() {
	$(".sort li a").click(function(e) {
		var anchorText = $("#dLabel").text();
		var selected = $(this).text();
		$("#dLabel").text(selected);
		$(this).text(anchorText);

		replaceRequestParameter(SORT, selected);

		e.preventDefault();

		reRenderPage(false);
	});
}

function swapSort(sort) {
	$('a', $('.sort')).each(function() {
		var matches = false;
		if ($(this).text().indexOf(sort) > -1) {
			matches = true;
		}
		var currentAnchor = $(this).text();
		var first = $("#dLabel").text();
		if (matches === true) {
			$(this).text(first);
			$("#dLabel").text(currentAnchor);
		}
	});
}

function loadOnScrollToBottom() {

	$(window).data('ajaxready', true).scroll(
			function() {

				if ($(window).data('ajaxready') == false) {
					return;
				}

				if ($(window).scrollTop() >= ($(document).height() - $(window)
						.height())) {

					var page = getRequestParam("page");
					replaceRequestParameter("page", ++page);
					$(window).data('ajaxready', true);

					reRenderPage(true);
				}

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

function postToDetail(id) {
	var input = '<input type="hidden" name="productId" value="' + id + '" />';
	$("body").append(
			'<form action="detail" method="post" id="product_">' + input
					+ '</form>');
	$("#product_").submit();
}

function login() {

	$("#login_button").click(function(e) {
		$.ajax({
			url : "login",
			method : 'POST',
			contentType : "application/json",
			data : getLoginInput(),
			success : function(data) {
				var message = "";
				if (data === "notregistered") {
					message = "You are not registered with us. Please signup."
				} else if (data === "false") {
					message = "Invalid credentials. Please try again."
				} else if (data == "true") {
					window.location = window.location.href;
				}
				$("#login_failed_message").html(message);
			}
		});
	});
}

function getLoginInput() {
	var login = {
		emailOrMobile : $("#emailOrMobile").val(),
		password : $("#password").val()
	}

	return JSON.stringify(login);
}

/** uTILITY METHODS * */
function updateRequestParameter(key, value) {

	var url = window.location.href;
	var attributes = getRequestParam(key);

	var attributesParam = "";

	var updatedValue = value;

	if (isEmpty(attributes)) {
		var updatedUrl = url + '&' + key + '=' + value;
		ChangeUrl(url, updatedUrl);

	}
}

function createRequestParamForSort() {
	var sort = getRequestParam(SORT);
	if (isEmpty(sort)) {
		replaceRequestParameter(SORT, $("#dLabel").text());
	} else {
		swapSort(sort);
	}

}

function replaceRequestParameter(key, value) {
	var url = window.location.href;
	var updatedUrl = updateQueryStringParameter(url, key, value);
	ChangeUrl(url, updatedUrl);
}

function replaceRequestParameterForCheckBoxes(key, value) {

	if (isEmpty(value)) {
		replaceRequestParameter(ATTRIBUTES, -1);
		return;
	}

	var url = window.location.href;
	var updatedUrl = updateQueryStringParameter(url, key, value);
	ChangeUrl(url, updatedUrl);
}

function ChangeUrl(page, url) {
	if (typeof (history.pushState) != "undefined") {
		var obj = {
			Page : page,
			Url : url
		};
		history.pushState({}, null, obj.Url);
	} else {
		window.location.href = "homePage";
		alert("Browser does not support HTML5.");
	}
}

function isDuplicateValue(attributes, value) {
	var values = attributes.split("--");
	for (i = 0; i < values.length; i++) {
		if (values[i] === value) {
			return true;
		}
	}
	return false;
}

function updateQueryStringParameter(uri, key, value) {
	var re = new RegExp("([?|&])" + key + "=.*?(&|#|$)", "i");
	if (uri.match(re)) {
		return uri.replace(re, '$1' + key + "=" + value + '$2');
	} else {
		var hash = '';
		if (uri.indexOf('#') !== -1) {
			hash = uri.replace(/.*#/, '#');
			uri = uri.replace(/#.*/, '');
		}
		var separator = uri.indexOf('?') !== -1 ? "&" : "?";
		return uri + separator + key + "=" + value + hash;
	}
}

function isEmpty(str) {
	return (!str || 0 === str.length);
}

function isBlank(str) {
	return (!str || /^\s*$/.test(str));
}

function getRequestParam(name) {
	if (name = (new RegExp('[?&]' + encodeURIComponent(name) + '=([^&]*)'))
			.exec(location.search))
		return decodeURIComponent(name[1]);
}

function removeRequestParameterValueOnly(key, value) {

	var updatedArray = [];
	var param = getRequestParam(key);
	if (!isEmpty(param)) {
		var values = param.split(SPLIT_CHAR);
		for (i = 0; i < values.length; i++) {
			if (parseInt(values[i]) === parseInt(value)) {

			} else {
				updatedArray.push(values[i]);
			}
		}
	} else {
		alert('Could not remove non-existing request parameter');
	}

	replaceRequestParameter(ATTRIBUTES, updatedArray);

	return updatedArray;
}

function removeRequestParameter(parameter) {
	url = window.location.href;
	var urlparts = url.split('?');

	if (urlparts.length >= 2) {
		var urlBase = urlparts.shift(); // get first part, and remove from array
		var queryString = urlparts.join("?"); // join it back up

		var prefix = encodeURIComponent(parameter) + '=';
		var pars = queryString.split(/[&;]/g);
		for ( var i = pars.length; i-- > 0;)
			// reverse iteration as may be destructive
			if (pars[i].lastIndexOf(prefix, 0) !== -1) // idiom for
				// string.startsWith
				pars.splice(i, 1);
		url = urlBase + '?' + pars.join('&');
	}
	return url;
}
