(function() {
	'use strict';
	
	angular.module('ufoblogger')
		.controller('PublishController', PublishController);
	
	PublishController.$inject = ['PublishService', '$location'];
			
	function PublishController(PublishService, $location) {
		
		var pc = this;
		
		pc.publish = Publish;
		
		(function init() {
			
		})();
		
		function Publish() {
			pc.verifying = true;
			
			PublishService.publish(
				pc.title,
				pc.category, 
				pc.description,
				pc.author,
				pc.datetime,
				function (response) {

					if ( response.publishStatus ) {
					} else {
					}
					
					pc.verifying = false;
				}
			);
		};
		
	}

})();