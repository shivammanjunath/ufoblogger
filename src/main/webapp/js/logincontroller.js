(function() {
	'use strict';
	
	angular.module('ufoblogger')
		.controller('LoginController', LoginController);
	
	LoginController.$inject = ['LoginService', '$location', '$rootScope'];
			
	function LoginController(LoginService, $location, $rootScope) {
		
		var lc = this;
		
		lc.login = Login;
		
		(function init() {
			
		})();
		
		function Login() {
			lc.verifying = true;

			console.log("LoginController.login()");
			LoginService.performLogin(lc.userEmail, lc.userPassword,
				function (response) {
					
					if ( response.loginStatus ) {
						LoginService.saveLoginData(response);
						$rootScope.authenticated = true;
						$location.path('/');
					} else {
						console.log(response.errorMessage);
						$rootScope.authenticated = false;
						lc.responseMessage = response.errorMessage;
					}
					
					lc.verifying = false;
				}
			);
		};
		
	}

})();