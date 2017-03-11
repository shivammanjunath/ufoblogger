(function(){
	'use strict';
	
	angular.module('ufoblogger')
		.controller('AllArticlesController', 
			['ArticlesFetchService', '$location' , '$scope', 'articlesFetched', 
				function(ArticlesFetchService, $location, $scope, articlesFetched) {
				
				}
			]
		);
	
})();