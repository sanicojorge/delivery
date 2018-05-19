app.controller(
    "ProductCtrl",
    ["$scope", "$location", "$route", "$routeParams", "ProductSrv",
    function($scope, $location, $route, $params, servicio) {
  
      console.log("ProductCtrl loaded with action: "+ $params.action );
      var back_path = "/product/";
  
      if(['new','edit','view','delete'].indexOf($params.action) == -1){
        alert("Acción inválida: " + $params.action);
        $location.path(back_path);
      }
  
      function find(){
            servicio.find($params.id, function(error, data){
                if(error){
            console.log(error);
                    return;
          }
         // console.log (data);
              //data.date = new Date(data.date);
                  
                $scope.data = data;
            });
        }
  
  
      $scope.save = function(){
            servicio.createProduct(
          
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
            servicio.removeProduct(
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
          servicio.updateProduct(
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

  
      if($params.action == 'delete'){
        $scope.delete();
        $location.path(back_path);
        $route.reload();
      }
  
      if($params.action == 'edit' || $params.action == 'view'){
        find($params.id);
      }
  
    }]);
  