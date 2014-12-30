/*
 * Generic CRUD resource REST service
 */
FirstApp.factory('Category', [ '$resource', function($resource) {
	return $resource('/data/rest/categories/:id', {}, {});
} ]);
