(function(){
	'use strict';
	
	angular.module('ufoblogger')
		.service('PublishService', 
			function($http) {
				
				this.publish = function Publish(title, description, category, author, tags, callback) {

					$http.post('/ufoblogger/web/publish/new', 
						{
							title: title,
							authorId: author,
							category: category, 
							description: description,
							tags: tags
						})
						.success(function (response) {
							console.log("PublishService - handleSuccess");
							callback(response);
						})
						.error(function (response) {
							console.log("PublishService - handleError");
							callback(response);
						});
				}
				
			}
		);
})();