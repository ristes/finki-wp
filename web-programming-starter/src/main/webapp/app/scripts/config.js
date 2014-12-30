'use strict';


FirstApp.constant('settings', {
  contextPath: _contextPath,
  dateFormats: ['DD-MM', 'DD-MM-YY', 'DD-MM-YYYY', 'DD-MM-YYYY HH:mm'],
  useAuthTokenHeader: true
});

FirstApp.value('version', '0.1');

// register the interceptor as a service

FirstApp.factory('HRHttpInterceptors', function($q, $location, $rootScope,
  $filter, toaster, settings) {
  return {
    'request': function(config) {
      // Prepend context path to each request to absolute path
      if (config.url.length > 0) {
        if (config.url.charAt(0) == "/") {
          config.url = settings.contextPath + config.url;
        }
      }
      // Add token in each request header
      var authToken = $rootScope.authToken;
      if (angular.isDefined(authToken)) {
        if (settings.useAuthTokenHeader) {
          config.headers['X-Auth-Token'] = authToken;
        } else {
          config.url = config.url + "?token=" + authToken;
        }
      }
      return config || $q.when(config);
    },
    'responseError': function(rejection) {
      var status = rejection.status;
      if (status == 400) {
        // invalid data 

      }
      if (status == 401) {
        if (!$rootScope.returnPath) {
          $rootScope.returnPath = $location.path();
        }
        $location.path("/login");
      }
      return $q.reject(rejection);
    }
  };
});