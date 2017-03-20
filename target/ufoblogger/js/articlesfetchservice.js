(function(){
	'use strict';
	
	angular.module('ufoblogger')
		.service('ArticlesFetchService', function($http) {

			this.fetchAllArticles = function FetchAllArticles() {
				console.log("FetchAllArticles");
				return $http.get('/ufoblogger/web/readarticles/public').then(handleSuccess, handleError);
			}

			function handleSuccess(response) {
	            console.log("handleSuccess" + response.data);
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