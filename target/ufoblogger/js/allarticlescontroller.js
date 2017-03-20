(function(){
	'use strict';
	
	angular.module('ufoblogger')
		.controller('AllArticlesController', AllArticlesController);

	AllArticlesController.$inject = ['ArticlesFetchService', '$location' , '$rootScope', '$scope', 'articlesFetched']; 
				
	function AllArticlesController(ArticlesFetchService, $location, $rootScope, $scope, articlesFetched) {

		var spc = this;

		$scope.articles = [];

		var i = 0;
		for ( ; i < articlesFetched.length; ++i ) {
			$scope.articles[i] = articlesFetched[i];
			$scope.articles[i].authorFullName = atob($scope.articles[i].authorFullName);
		}

		$scope.setItem = function(post) {
			console.log("Article is selected");
			$rootScope.selectedPost = post;
		}

	}

})();