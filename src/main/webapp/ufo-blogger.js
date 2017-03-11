(function () {
    'use strict';

	var ufobloggerapp = angular.module('ufoblogger', ['ngRoute']);

	ufobloggerapp.config(['$routeProvider', function ($routeProvider) {

		$routeProvider

			.when('/', 
				{
					templateUrl: 'pages/allarticles.html',
					controller: 'AllArticlesController',
					controllerAs: 'aac',
					resolve: {
                    			articlesFetched : ['$route', 'ArticlesFetchService', 
                    				function ($route, ArticlesFetchService) {
                        				return ArticlesFetchService.fetchAllArticles();
                    				}
                    			]
                			}
				})

	    	.when('/login',
			    {
			      templateUrl: 'pages/login.html',
			      controller: 'LoginController',
			      controllerAs: 'lc'
			    })

		    .when('/signup',
			    {
			      templateUrl:    'pages/signup.html',
			      controller:     'SignUpController',
			      controllerAs: 'sc'
			    })

		    .when('/publish',
			    {
			      templateUrl:    'pages/publish.html',
			      controller:     'PublishController',
			      controllerAs: 'pc'
			    })

		    .when('/search',
			    {
			      templateUrl:    'pages/search.html',
			      controller:     'SearchController',
			      controllerAs: 'search'
			    })

		    .when('/allposts',
			    {
			    	templateUrl:    'pages/allarticles.html',
			      	controller:     'AllArticlesController',
			      	controllerAs: 'aac'
			    	
			    })

		    .when('/technology',
			    {
			    	templateUrl:    'pages/technology.html',
			      	controller:     'TechnologyController',
			      	controllerAs: 'tc'
			    	
			    })

		    .when('/movies',
			    {
			    	templateUrl:    'pages/movies.html',
			      	controller:     'MoviesController',
			      	controllerAs: 'mc'
			    	
			    })

		    .when('/sports',
			    {
			    	templateUrl:    'pages/sports.html',
			      	controller:     'SportsController',
			      	controllerAs: 'sports'
			    	
			    })

	    	.otherwise(
			    {
			      redirectTo:     '/',
			      controller:     'AllArticlesController', 
			    });
	}]);

	ufobloggerapp.controller('SearchController', function ($scope, $compile) {
		console.log('SearchController');
	});

	ufobloggerapp.controller('TechnologyController', function ($scope, $compile) {
		console.log('TechnologyController');
	});

	ufobloggerapp.controller('MoviesController', function ($scope, $compile) {
		console.log('MoviesController');
	});

	ufobloggerapp.controller('SportsController', function ($scope, $compile) {
		console.log('SportsController');
	});

	ufobloggerapp.run(['$rootScope', function($rootScope) {
	    $rootScope.authenticated = false;
	}]);

})();