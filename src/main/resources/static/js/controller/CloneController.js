var cloneApp = angular.module("CloneControllers",  []);

var urlBase = "http://localhost:8181";

cloneApp.controller("CloneController", function($scope, $http){

	//Listar Dados 
	
	$scope.listar = function(){
		$http.get(urlBase + "/clones").then(
				function(response){
					$scope.clones = response.data;
				}, function(response){
					window.alet("Erro de Get!");
				}
		);
	}
	
	$scope.listar();
	
	
	$scope.novo = function () {
		$scope.clone = "";
		
	}
	
	//Salvar Dados
	
	$scope.salvar = function(){
	
		//Salvando 
		if(!$scope.clone.identifier){
			
			$http.post(urlBase + "/clones/", $scope.clone).then(function(response){
				$scope.listar();
				$scope.novo();
				window.alert("Clone Cadastrado com Sucesso ");				
			},	function(response){
				      window.alert("Ja existe um Clone com esse nome");
			
			});
		}else{
			$http.put(urlBase + "/clones/" + $scope.clone.identifier, $scope.clone).then(
				function(response){
					$scope.listar();
				}, function(response){
					window.alet("Erro de PUT!");
				} );
		}
	}
	
	//Editar Dados
	
	$scope.editar = function(cloneSel){
		$scope.clone = angular.copy(cloneSel);
		$scope.clone.dataCriacao = new Date ($scope.clone.dataCriacao);
	}
	
	
	// Excluir Dados
	
	$scope.excluir = function(cloneSel){
		if(window.confirm("Tem certeza que quer excluir ?")){
			$http.delete(urlBase + "/clones/" + cloneSel.identifier).then(
					function(response){
						$scope.listar();
					}, function(response){
						window.alert("Erro de DELETE!");
					}
			);
		}
	}
	
	//Ordenação Campos
	$scope.orderByMe = function(cloneOrdenado){
		$scope.myOrderBy = cloneOrdenado;
	}
	

}   );
