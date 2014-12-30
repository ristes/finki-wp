/**
 * @ngdoc here we are configuring the module exposed through the FirstApp
 *        variable. The method receives an array that has a function as a last
 *        argument. Here, the angular inject the dependencies defined as strings
 *        in the array to the corresponding elements in the function. <br/> The
 *        $routeProvider is used to configure the routes. It maps templateUrl
 *        and optionally a controller to a given path. This is used by the
 *        ng-view directive. It replaces the content of the defining element
 *        with the content of the templateUrl, and connects it to the controller
 *        through the $scope.
 * @see https://docs.angularjs.org/guide/di
 */
FirstApp.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/', {
		templateUrl : 'views/main.html',
		controller : 'MainCtrl'
	});

	$routeProvider.when('/login', {
		templateUrl : 'views/login.html',
		controller : 'LoginController'
	});
	
	$routeProvider.when('/cities', {
		templateUrl : 'views/city.html',
		controller : 'CityController'
	});

	$routeProvider.when('/countries', {
		templateUrl : 'views/country.html',
		controller : 'CountryController'
	});

	$routeProvider.when('/categories', {
		templateUrl : 'views/category.html',
		controller : 'CategoryController'
	});
	
	$routeProvider.when('/books/:id?', {
		templateUrl : 'views/book.html',
		controller : 'BookController'
	});

	$routeProvider.when('/404', {
		templateUrl : '404.html'
	});
	$routeProvider.otherwise({
		redirectTo : '/'
	});
} ]);
