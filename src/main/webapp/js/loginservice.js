(function(){
	'use strict';
	
	angular.module('ufoblogger')
		.service('LoginService', 
			function($http, $window, $rootScope) {
				
				this.performLogin = function PerformLogin(userEmail, userPassword, callback) {
					console.log("*** Perform login with " + userEmail + " & " + userPassword + " ***");
					$rootScope.userEmail = userEmail;
					$http.post('/ufoblogger/web/signin/user', {loginEmail: btoa(userEmail), loginPassword: btoa(userPassword)})
						.success(function (response) {
							console.log("LoginService - handleSuccess");
							callback(response);
						})
						.error(function (response) {
							console.log("LoginService - handleError");
							$rootScope.userEmail = "";
							callback(response);
						});
				}

				this.saveLoginData = function SaveLoginData(loginData) {
					$window.sessionStorage.setItem("_id", loginData._id);
					$window.sessionStorage.setItem("userFullName", atob(loginData.userFullName));
					$window.sessionStorage.setItem("userInterest", loginData.userInterest);
					$window.sessionStorage.setItem("userToken", loginData.userToken);
					$rootScope.currentUser = $window.sessionStorage.getItem("userFullName");
				}
				
			}
		);
})();