(function() {
	'use strict';
	
	angular.module('ufoblogger')
		.controller('PublishController', PublishController);
	
	PublishController.$inject = ['PublishService', '$location', '$window', '$scope'];
			
	function PublishController(PublishService, $location, $window, $scope) {
		
		var pc = this;
		
		this.publish = function Publish() {
			pc.verifying = true;
			
			PublishService.publish(
				pc.title,
				pc.description,
				pc.category, 
				$window.sessionStorage.getItem("_id"),
				pc.tags,
				function (response) {

					if ( response.publishStatus ) {
						$scope.title = "";
						$scope.description = "";
						$scope.tags = "";
						$location.path('/');
					} else {
					}
					
					pc.verifying = false;
				}
			);
		};
		
	}

})();