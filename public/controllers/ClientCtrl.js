app.controller(
  "ClientCtrl",
  ["$scope", "$location", "$routeParams", "ClientSrv",
  function($scope, $location, $params, servicio) {

    console.log("ClientCtrl loaded with action: "+$params.action)

    if(['new','edit','view'].indexOf($params.action) == -1){
      alert("Acción inválida: " + $params.action);
      $location.path("/");
    }

    function find(id){
  		servicio.find(id, function(error, data){
  			if(error){
          console.log(error);
  				return;
  			}
        for (var i = 0; i < data.requests.length; i++) {
          data.requests[i].date = new Date(data.requests[i].date);
        }
        $scope.data = data;
  		});
  	}

    $scope.save = function(){
  		servicio.save($scope.data, function(error, data){
  			if(error){
          console.log(error);
  				return;
  			}
  			$scope.data = data;
        $location.path("/")
  		});
  	}

    $scope.update = function(){
  		servicio.updateCuil(
        $scope.data.id,
        $scope.data.cuil,
        function(error, data){
  			if(error){
          console.log(error);
  				return;
  			}
  			$scope.data = data;
        $location.path("/")
  		});
  	}

    $scope.cancel = function(){
      $location.path("/");
    }



    $scope.action = $params.action;

    if ($scope.action == 'edit' || $scope.action == 'view') {
      find($params.id);
    }

  }]);
