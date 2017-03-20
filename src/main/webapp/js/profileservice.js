(function(){
	'use strict';
	
	angular.module('ufoblogger')
		.service('ProfileService', 
			function($http, $window, $rootScope) {
				
				this.updateProfile = function UpdateProfile(userFullName, callback) {

					var _id = $window.sessionStorage.getItem("_id");
					console.log("User full name is ", userFullName);
					console.log("User id is ", _id);
					
					$http.post('/ufoblogger/web/update/user', {fullName: btoa(userFullName), id: _id})
						.success(function (response) {
							console.log("ProfileService - update success");
							$window.sessionStorage.setItem("userFullName", atob(userFullName));
							$rootScope.currentUser = $window.sessionStorage.getItem("userFullName");
							callback(response);
						})
						.error(function (response) {
							console.log("ProfileService - handleError");
							callback(response);
						});
				}
			}
		);
})();