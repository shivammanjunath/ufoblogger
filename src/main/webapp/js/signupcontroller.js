(function() {
	'use strict';
	
	angular.module('ufoblogger')
		.controller('SignUpController', SignUpController);
	
	SignUpController.$inject = ['SignUpService', '$location'];
			
	function SignUpController(SignUpService, $location) {
		
		var sc = this;
		
		sc.signup = Signup;
		
		(function init() {
			
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
						sc.responseMessage = "";
					} else {
						sc.responseMessage = response.errorMessage;
					}
					
					sc.verifying = false;
				}
			);
		};
		
	}

})();