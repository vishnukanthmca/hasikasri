$(document).ready(function() {

	loadCategories();

});

// category supports ONLY 3 levels
function loadCategories() {

	var y = new Number($('#current_cat_id').val());

	$
			.ajax({
				url : "category/getCategory",
				method : 'POST',
				contentType : "application/json; charset=utf-8",
				data : JSON.stringify(y),
				success : function(data) {

					if (data != null && data.breadcrumps != null) {
						loadRefiners(data.refiners);
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

function loadRefiners(refiners) {

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

			var attributes = refiner.attributes;

			var checkboxes = "";

			if (attributes != null && attributes.length > 0) {

				for (j = 0; j < attributes.length; ++j) {

					var attribute = attributes[j];

					var checkbox = '<div class="checkbox checkbox-success">'
							+ '<input type="checkbox" id="checkbox'
							+ attribute.id + '"> <label for="checkbox'
							+ attribute.id + '"> ' + attribute.name
							+ ' </label>' + '</div>';
					checkboxes += checkbox;
				}
			}

			refiners_html += checkboxes + '</div></div></div></div>';

			$('#refiners_and_attributes').append(refiners_html);
		}
	}
}
