(function() {

	'use strict';

	angular.module('ufoblogger')
		.controller('LogoutController', LogoutController);

	LogoutController.$inject = ['$location', '$window', '$rootScope'];

	function LogoutController($location, $window, $rootScope) {

		$window.sessionStorage.clear();
		$rootScope.authenticated = false;
		$rootScope.$digest();
		$location.path('/');
	}
})();