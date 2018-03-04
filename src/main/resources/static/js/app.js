angular.module('myApp', ['angularUtils.directives.dirPagination' ,'ui.router', 'myApp.controllers'])

.config(function($stateProvider, $urlRouterProvider){
	
	$urlRouterProvider.otherwise("/inicio");
	
	$stateProvider
	
	.state('inicio', {
		url: "/inicio",
		templateUrl: "inicio.html"
		
	})	
	
	.state('clones',{
		url :"/clones",
		templateUrl: "clones.html",
		controller : "CloneController"
	})

});
function sucesso(msg){
	$.notify({
		message:msg
	}, {
		type:'then',
		timer:2000
	})
	
}


