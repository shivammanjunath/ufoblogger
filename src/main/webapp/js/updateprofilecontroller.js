(function() {
	'use strict';
	
	angular.module('ufoblogger')
		.controller('ProfileController', ProfileController);
	
	ProfileController.$inject = ['ProfileService', '$location', '$rootScope', '$scope'];
			
	function ProfileController(ProfileService, $location, $rootScope, $scope) {
		
		var puc = this;

		$scope.fullname = $rootScope.currentUser;

		console.log("ProfileController & fullname is ", $rootScope.currentUser);

		this.update = function Update() {
			puc.verifying = true;

			console.log("ProfileController.Update()");
			ProfileService.updateProfile(puc.fullname,
				function (response) {
					
					if ( response ) {
						$location.path('/');
					} else {
						
					}
					
					puc.verifying = false;
				}
			);
		};
		
	}

})();