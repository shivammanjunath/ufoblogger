(function(){
	'use strict';
	
	angular.module('ufoblogger')
		.service('LoginService', 
			function($http, $window) {
				var loginService = {};

				loginService.performLogin = PerformLogin;
				loginService.saveLoginData = SaveLoginData;
				
				return loginService;
				
				function PerformLogin(userEmail, userPassword, callback) {
					console.log("*** Perform login with " + userEmail + " & " + userPassword + " ***");
					$http.post('/ufoblogger/web/signin/user', {loginEmail: btoa(userEmail), loginPassword: btoa(userPassword)})
						.success(function (response) {
							console.log("LoginService - handleSuccess");
							callback(response);
						})
						.error(function (response) {
							console.log("LoginService - handleError");
							callback(response);
						});
				}

				function SaveLoginData(loginData) {
					$window.sessionStorage.setItem("_id", loginData._id);
					$window.sessionStorage.setItem("userFullName", loginData.userFullName);
					$window.sessionStorage.setItem("userInterest", loginData.userInterest);
					$window.sessionStorage.setItem("userToken", loginData.userToken);
				}
				
			}
		);
})();