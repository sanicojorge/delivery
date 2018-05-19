app.controller(
    "ProductsCtrl",
    ["$scope","$location","$route","ProductSrv",
    function($scope, $location, $route, servicio) {
      console.log("ProductsCtrl loaded...")
  
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