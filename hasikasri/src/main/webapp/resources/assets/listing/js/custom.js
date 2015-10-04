$(document).ready(function() {

	$('.tree-toggle').click(function() {
		$(this).parent().children('ul.tree').toggle(200);
	});

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

					if (data.length <= 0) {
						alert('Could not load category - category does not exists');
						return;
					}

					$
							.each(
									data,
									function(index, json) {

										var parentNodes = [];

										if (json.children != null
												&& json.children.length > 0) {

											for (i = 0; i < json.children.length; ++i) {

												var childrenCategory = json.children[i];

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
															href : 'home',
															tags : [ '0' ],
															nodes : ""
														}

														grandChildrenNodes
																.push(greatGrandChildrenCategory);
													}
												}

												var grandChildrenCategory = {
													text : childrenCategory.name,
													href : 'home',
													tags : [ '0' ],
													nodes : ""
												}

												grandChildrenCategory.nodes = grandChildrenNodes;

												parentNodes
														.push(grandChildrenCategory);
											}

											parentNodes.nodes = grandChildrenNodes;
										}

										var defaultData = [];

										var masterCategory = {
											text : json.name,
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

									});

				},
				failure : function(error) {
					alert(error);
				}
			});

}
