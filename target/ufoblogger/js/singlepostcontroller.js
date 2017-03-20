(function() {
	'use strict';
	
	angular.module('ufoblogger')
		.controller('SinglePostController', SinglePostController);
	
	SinglePostController.$inject = ['$location', '$rootScope'];
			
	function SinglePostController($location, $rootScope) {
		
		var spc = this;
		
		this.viewPost = function ViewPost() {
			
		}
	}

})();