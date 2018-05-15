app.controller(
  "ClientsCtrl",
  ["$scope","$location","$route","ClientSrv",
  function($scope, $location, $route, servicio) {
    console.log("ClientsCtrl loaded...")

    function findAll(){
  		servicio.findAll( function(error, data){
  			if(error){
  				alert("Ocurrió un error: " + error);
  				return;
  			}
  			$scope.data = data;
  		})
  	}

  	findAll();
  }]);
