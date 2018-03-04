angular.module('agenda', []).controller('portalController',
		function($scope, $http, $window) {

			var _apiHost = 'localhost:8080/agenda';
			$scope.linha = {};
			$scope.novo = false;
			
			$scope.findAllAgenda = function() {
				$http.get('http://' + _apiHost).then(function(response) {
					$scope.agendas = response.data;
				});
			};
			
			$scope.findAllAgenda();
			
			$scope.createAgenda = function(params) {
				$http.post('http://' + _apiHost, params).then(function(response) {
					$scope.findAllAgenda();
				});
			};
			
			$scope.updateAgenda = function(row) {
				$http.put('http://' + _apiHost + "/" + row.id, row).then(function(response) {
					$scope.findAllAgenda();
				});
			};
			
			$scope.deleteAgenda = function(row) {
				$http.delete('http://' + _apiHost + "/" + row.id).then(function(response) {
					$scope.findAllAgenda();
				});
			};

			$scope.selectLinha = function(row) {
				$scope.linha = row;
				$scope.novo = false;
			};

			$scope.clearLinha = function() {
				$scope.linha = {};
				$scope.novo = false;
			};

			$scope.novaLinha = function() {
				$scope.clearLinha();
				$scope.novo = true;
			};

		});

// (function(angular) {
// angular.module('app', ['ngResource']);
//
// angular.bootstrap(document.body, ['app']);
// })(angular);
//
// app.factory('portalService', function() {
// return $resource('/agenda/:id');
// });
//
// app.controller('portalController', ['$scope', 'portalService',
// function($scope, portalService) {
// $scope.agendas;
// portalService.query(function(data) {
// $scope.agendas = data;
// }
// }]);

// app.controller('portalController', ['$scope', '$http', function($scope,
// $http) {
// $scope.agendas;
// var baseUrl = '/agenda';
//
// $http.get(baseUrl).then(function(response) {
// $scope.agendas = response.data;
// }, function(err) {
// console.log(err);
// });
// }]);

// angular.module('agenda').factory('portalService', ['$http', function ($http)
// {
//	
// var _apiHost = 'http://localhost:8080/agenda';
//	
// return {
//		
// findAll: function() {
// $http.get(_apiHost).then(function(response) {
// return response.data;
// });
// }
//				
// findById: function(id) {
// $http.delete(_apiHost + '/'+ id).then(function(response) {
// return response.data;
// });
// }

// createAgenda: function(params) {
// $http.post(_apiHost, params).then(function(response) {
// return response.data;
// });
// }
//		
// updateAgenda: function(id, params) {
// $http.put(_apiHost + '/' + id, params).then(function(response) {
// return response.data;
// });
// }
//		
// deleteAgenda: function(id) {
// $http.delete(_apiHost + '/'+ id).then(function(response) {
// return response.data;
// });
// }
// }

// }]);
