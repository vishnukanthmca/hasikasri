$(document).ready(function() {
	search();
	zoom();
	raty();
	pills();

});

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

	$('.review_rating').raty({
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
