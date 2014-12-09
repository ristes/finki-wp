var contextPath = "/web-programming";

/*
 * Generic CRUD resource REST service
 */
FirstApp.factory('crudService', [ '$resource', function($resource) {
	return function(type) {
		return $resource(contextPath + '/data/rest/' + type + '/:id', {}, {
			import : {
				method : 'POST',
				url : contextPath + "/data/rest/" + type + "/import"
			},
			paged : {
				method : 'GET',
				url : contextPath + "/data/rest/" + type + "/paged"
			}
		});
	};
} ]);
