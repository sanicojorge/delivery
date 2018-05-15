app.controller(
  "RequestCtrl",
  ["$scope", "$location", "$route", "$routeParams", "RequestSrv",
  function($scope, $location, $route, $params, servicio) {

    console.log("RequestCtrl loaded with action: "+ $params.action
      + " and Client: " + $params.cliid);

    var back_path = "/view/"+$params.cliid;

    if(['add','edit','view','delete'].indexOf($params.action) == -1){
      alert("Acción inválida: " + $params.action);
      $location.path(back_path);
    }

    function find(cli_id, req_id){
  		servicio.find(cli_id, req_id, function(error, data){
  			if(error){
          console.log(error);
  				return;
        }
        console.log (data);
            data.date = new Date(data.date);
                
  			$scope.data = data;
  		});
  	}


    $scope.save = function(){
  		servicio.addClientRequest(
        $params.cliid,
        $scope.data,
        function(error, data){
    			if(error){
            console.log(error);
    				return;
    			}
    			$scope.data = data;
          $location.path(back_path);
  		});
  	}

    $scope.delete = function(){
  		servicio.removeClientRequest(
        $params.cliid,
        $params.id,
        function(error, data){
    			if(error){
            console.log(error);
    				return;
    			}
    			$scope.data = data;
          $location.path(back_path);
  		});
  	}

    $scope.update = function(){
  		servicio.updateClientRequest(
        $params.cliid,
        $scope.data,
        function(error, data){
    			if(error){
            console.log(error);
    				return;
    			}
    			$scope.data = data;
          $location.path(back_path);
  		});
  	}

    $scope.cancel = function(){
      $location.path(back_path);
    }

    $scope.action = $params.action;
    $scope.cliid = $params.cliid;

    if($params.action == 'delete'){
      $scope.delete();
      $location.path(back_path);
      $route.reload();
    }

    if($params.action == 'edit' || $params.action == 'view'){
      find($params.cliid, $params.id);
    }

  }]);
