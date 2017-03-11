(function(){
	'use strict';
	
	angular.module('ufoblogger')
		.service('Publish', 
			function($http) {
				var publishService = {};

				publishService.publish = Publish;
				
				return publishService;
				
				function Publish(title, description, category, author, callback) {
					
					$http.post('/ufoblogger/web/publish/new', 
						{
							title: title, 
							category: category, 
							description: description, 
							authorId: author
						})
						.success(function (response) {
							console.log("LoginService - handleSuccess");
							callback(response);
						})
						.error(function (response) {
							console.log("LoginService - handleError");
							callback(response);
						});
				}
				
			}
		);
})();