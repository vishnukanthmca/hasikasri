var CURRENT_CATEGORY = "cat";
var CHILD_CATEGORIES = "child_cat";
var ATTRIBUTES = "ref";
var SPLIT_CHAR = "^";
var JOIN_CHAR = "_";

$(document).ready(function() {

	getCategories();

});

function reRenderPage() {
	getRefiners();
	highlightCheckBoxes();
}

function getSelectedRefiners() {
	return $("input[name=refiner_checkboxes]:checked").map(function() {
		return this.id;
	}).get().join(SPLIT_CHAR);
}

function makeSelectedFromParam() {

	var param = getRequestParam(ATTRIBUTES);
	var refiners = param.split(SPLIT_CHAR);

	$("input[name=refiner_checkboxes]").each(function(index, element) {
		for (i = 0; i < refiners.length; i++) {
			if (refiners[i] === element.id) {
				$(this).prop('checked', true);
			}
		}
	});
}

function highlightCheckBoxes() {

	if (isEmpty(getSelectedRefiners())) {
		replaceRequestParameter(ATTRIBUTES, -1);
		return false;
	}

	replaceRequestParameter(ATTRIBUTES, getSelectedRefiners());

	makeSelectedFromParam();

	replaceRequestParameter(ATTRIBUTES, getSelectedRefiners());

}

function getProductsOnRefinerChange() {
	highlightCheckBoxes();
}

function getInputToLoadProducts() {

	var param = getRequestParam(ATTRIBUTES).split(SPLIT_CHAR);

	var attributeIds = [];

	for (i = 0; i < param.length; i++) {
		attributeIds.push(param[i].split("_").join(","));
	}

	attributeIds = attributeIds.join(",");

	var categoryIds = getRequestParam(CHILD_CATEGORIES);

	var numericAttributeIds = attributeIds.split(',').map(function(s) {
		return Number(s);
	});
	var numericCategoryIds = categoryIds.split(',').map(function(s) {
		return Number(s);
	});

	var input = {
		categoryIds : numericCategoryIds,
		attributeIds : numericAttributeIds
	};
	input = JSON.stringify(input);
	return input;
}

function getRefiners() {

	$.ajax({
		url : "product/findRefiners",
		method : 'POST',
		contentType : "application/json; charset=utf-8",
		data : getInputToLoadProducts(),
		success : function(data) {
			renderRefiners(data);
		}
	});
}

function renderRefiners(filters) {

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

					var idAndValue = changeCommaSeparatedToHashSeparated(attribute.attributeIds);

					var checkbox = '<div class="checkbox checkbox-success">'
							+ '<input name="refiner_checkboxes" class="refiner_checkboxes" id="'
							+ idAndValue
							+ '" onchange="getProductsOnRefinerChange()" value="'
							+ attribute.attributeIds
							+ '" type="checkbox" id="checkbox' + attribute.id
							+ '"> <label for="' + idAndValue + '"> '
							+ attribute.value + ' </label>' + '</div>';
					checkboxes += checkbox;
				}
			}

			refiners_html += checkboxes + '</div></div></div></div>';

			$('#refiners_and_attributes').append(refiners_html);
		}
	}
}

function changeCommaSeparatedToHashSeparated(attributeIds) {
	var comma = attributeIds;
	return comma.join(JOIN_CHAR);
}

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

						reRenderPage();

						// loadRefiners($('#current_cat_id').val(),
						// attributeIds);

						$('#child_category_ids').val(data.childrenIds);

						// loadProductsOnPageLoad($('#child_category_ids').val(),
						// attributeIds);

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

/** uTILITY METHODS * */
function updateRequestParameter(key, value) {

	var url = window.location.href;
	var attributes = getRequestParam(key);

	var attributesParam = "";

	var updatedValue = value;

	if (isEmpty(attributes)) {
		var updatedUrl = url + '&' + key + '=' + value;
		ChangeUrl(url, updatedUrl);

	} else {
		var duplicate = isDuplicateValue(attributes, value);
		if (!duplicate) {
			attributes += SPLIT_CHAR + value;
			var updatedUrl = updateQueryStringParameter(url, key, attributes);
			ChangeUrl(url, updatedUrl);
			console.log("updatedUrl = " + updatedUrl);
		} else {
			// do nothing
		}
	}
}

function replaceRequestParameter(key, value) {
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