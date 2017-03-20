(function() {
	'use strict';
	
	angular.module('ufoblogger')
		.controller('SignUpController', SignUpController);
	
	SignUpController.$inject = ['SignUpService', '$location', '$rootScope'];
			
	function SignUpController(SignUpService, $location, $rootScope) {
		
		var sc = this;
		
		sc.signup = Signup;
		
		(function init() {
			$rootScope.signupErrorMessage = "";
		})();
		
		function Signup() {
			sc.verifying = true;
			
			SignUpService.signup(
				sc.fullname,
				sc.email, 
				sc.password,
				sc.phone,
				sc.interest,
				function (response) {

					console.log(response.errorMessage);
					
					if ( response.signupStatus ) {
						$rootScope.signedup = true;
						$rootScope.signupErrorMessage = response.errorMessage;
					} else {
						$rootScope.signedup = false;
						$rootScope.signupErrorMessage = response.errorMessage;
					}
					
					sc.verifying = false;
				}
			);
		};
		
	}

})();