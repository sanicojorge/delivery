var app = angular.module('app',['ngRoute']);

app.config(['$routeProvider', function(routeprovider) {

	routeprovider
	.when('/',{
		templateUrl:'partials/client-list.html',
		controller: 'ClientsCtrl'
	})
	.when('/product/',{
		templateUrl:'partials/product-list.html',
		controller: 'ProductsCtrl'
	})
	.when('/product/:id/:action',{
		templateUrl:'partials/product-form.html',
		controller: 'ProductCtrl'
	})
	.when('/product/:action',{
		templateUrl:'partials/product-form.html',
		controller: 'ProductCtrl'
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
