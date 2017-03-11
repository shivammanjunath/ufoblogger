(function(){
	'use strict';
	
	angular.module('ufoblogger')
		.service('SignUpService', 
			function($http) {
				var signupService = {};

				signupService.signup = SignUp;
				
				return signupService;
				
				function SignUp(fullname, email, password, phone, interest, callback) {
					
					$http.post('/ufoblogger/web/signup/user', 
						{
							userFullName: fullname,
							userEmail: btoa(email), 
							loginPassword: btoa(password),
							userPhoneNumber: btoa(phone),
							userInterestCategory: interest
						})
						.success(function (response) {
							callback(response);
						})
						.error(function (response) {
							callback(response);
						});
				}
				
			}
		);
})();