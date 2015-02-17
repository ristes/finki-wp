/*
 * Generic CRUD resource REST service
 */
FirstApp.factory('crudService', [ '$resource', 'settings', function($resource,settings) {
	return function(type) {
		return $resource(settings.contextPath+'/data/rest/' + type + '/:id', {}, {
			import : {
				method : 'POST',
				url : settings.contextPath+"/data/rest/" + type + "/import"
			},
			paged : {
				method : 'GET',
				url : settings.contextPath+"/data/rest/" + type + "/paged"
			}
		});
	};
} ]);
