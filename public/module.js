var app = angular.module('app',['ngRoute']);

app.config(['$routeProvider', function(routeprovider) {

	routeprovider
	.when('/',{
		templateUrl:'partials/client-list.html',
		controller: 'ClientsCtrl'
	})
	.when('/:action',{
		templateUrl:'partials/client-form.html',
		controller: 'ClientCtrl'
	})
	.when('/:action/:id',{
		templateUrl:'partials/client-form.html',
		controller: 'ClientCtrl'
	})
	.when('/client/:cliid/request/:action',{
		templateUrl:'partials/request-form.html',
		controller: 'RequestCtrl'
	})
	.when('/client/:cliid/request/:action/:id',{
		templateUrl:'partials/request-form.html',
		controller: 'RequestCtrl'
	})
	.otherwise({
		templateUrl: 'partials/404.html'
	})
}])
