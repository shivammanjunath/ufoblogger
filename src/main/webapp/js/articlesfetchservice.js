(function(){
	'use strict';
	
	angular.module('ufoblogger')
		.service('ArticlesFetchService', function($http) {

			var service = {};

			service.fetchAllArticles = FetchAllArticles;

			return service;

			function FetchAllArticles() {
				console.log("FetchAllArticles");
				//return $http.get('http://localhost:8080/ufoblogger/web/readarticles/public').then(handleSuccess, handleError);
				return $http.get('/ufoblogger/web/readarticles/public').then(handleSuccess, handleError);
			}


			function handleSuccess(response) {
	            console.log("handleSuccess");
	            return response.data;
        	}
 
	        function handleError(error) {
	            console.log("handleError");
	            return function () {
	                return { success: false, message: error };
	            };
	        }
			
		});
	
})();