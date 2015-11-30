$(document).ready(function() {
	search();
});

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
