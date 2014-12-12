FirstApp.controller('CategoryController', [ '$scope', 'Category',
		function($scope, Category) {
			
			$scope.entities = Category.query();
			$scope.entity = {};

			$scope.edit = function(id) {
				$scope.entity = Category.get({
					id : id
				});
			};

			$scope.save = function() {
				Category.save($scope.entity, function(data) {
					$scope.entity = {};
					$scope.entities = Category.query();
				});
			};

			$scope.remove = function(id) {
				Category.remove({
					id : id
				}, function() {
					$scope.entities = Category.query();
				});
			};

		} ]);
