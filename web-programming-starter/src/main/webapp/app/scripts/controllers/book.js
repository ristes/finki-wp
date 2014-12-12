FirstApp.controller('BookController', [ '$scope', 'crudService',
		'$routeParams', function($scope, crudService, $routeParams) {
			var service = crudService('books');

			$scope.entities = service.query();
			if ($routeParams.id) {
				$scope.entity = service.get({
					id : $routeParams.id
				});
			} else {
				$scope.entity = {};
			}

			$scope.edit = function(id) {
				$scope.entity = service.get({
					id : id
				});
			};

			$scope.save = function() {
				service.save($scope.entity, function(data) {
					$scope.entity = {};
					$scope.entities = service.query();
				});
			};

			$scope.remove = function(id) {
				service.remove({
					id : id
				}, function() {
					$scope.entities = service.query();
				});
			};

		} ]);
