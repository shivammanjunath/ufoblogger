(function() {
	'use strict';
	
	angular.module('ufoblogger')
		.controller('LoginController', LoginController);
	
	LoginController.$inject = ['LoginService', '$location', '$rootScope'];
			
	function LoginController(LoginService, $location, $rootScope) {
		
		var lc = this;
		
		(function init() {
			$rootScope.loginErrorMessage = "";
			$rootScope.authenticated = false;
		})();
		
		this.login = function Login() {
			lc.verifying = true;

			console.log("LoginController.login()");
			LoginService.performLogin(lc.userEmail, lc.userPassword,
				function (response) {
					
					if ( response.loginStatus ) {
						LoginService.saveLoginData(response);
						$rootScope.authenticated = true;
						$rootScope.loginErrorMessage = "";
						$location.path('/');
						
					} else {
						console.log(response.errorMessage);
						$rootScope.authenticated = false;
						$rootScope.loginErrorMessage = response.errorMessage;
					}
					
					lc.verifying = false;
				}
			);
		};
		
	}

})();