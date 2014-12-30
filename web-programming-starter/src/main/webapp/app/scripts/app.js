'use strict';

/**
 * @ngdoc Definition of the application module. The first argument is the name
 *        of the module. It is used in the ng-app directive to expose the
 *        angular components that can be used. The second argument is an array
 *        that defines the dependencies (modules) that are used by the
 *        application. In this case we are only use the ngRoute module as a
 *        dependency in order to provide partial content inclusion through the
 *        routes
 * @see router.js for more information
 * @name avAngularStartupApp - the name of the module used in the ng-app
 *       directive
 * @description # avAngularStartupApp Main module of the application.
 */
var FirstApp = angular.module('avAngularStartupApp', [ 'ngResource', 'ngRoute',
		'ngAnimate', 'ngTable', 'ngTableExport', 'ngCookies',
		'chieffancypants.loadingBar', 'ui.bootstrap', 'ui.select2',
		'mgcrea.ngStrap', 'toaster', 'angularFileUpload',
		'pascalprecht.translate' ]);

FirstApp.config([ '$translateProvider', '$httpProvider', 'settings',
		function($translateProvider, $httpProvider, settings) {

			$httpProvider.interceptors.push('HRHttpInterceptors');
		} ]);