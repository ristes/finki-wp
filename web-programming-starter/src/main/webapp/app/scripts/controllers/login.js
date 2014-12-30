
FirstApp.controller('LoginController', [
		'$scope',
		'$rootScope',
		'$location',
		'$cookieStore',
		'UserService',

		function($scope, $rootScope, $location, $cookieStore, UserService) {
			$scope.rememberMe = false;

			$scope.login = function() {
				UserService.authenticate($.param({
					username : $scope.username,
					password : $scope.password,
					rememberMe : $scope.rememberMe
				}), function(authenticationResult) {
					$rootScope.authToken = authenticationResult.token;
					$rootScope.loginAction = true;
					if ($rootScope.returnPath
							&& $rootScope.returnPath != "/login") {
						$location.path($rootScope.returnPath);
						delete $rootScope.returnPath;
					} else {
						$location.path("/");
					}
				});
			};
		} ]);