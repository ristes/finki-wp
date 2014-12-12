var contextPath = "/web-programming";

/*
 * Generic CRUD resource REST service
 */
FirstApp.factory('Category', [ '$resource', function($resource) {
	return $resource(contextPath + '/data/rest/categories/:id', {}, {});
} ]);
