app.service(
    "ProductSrv",
    [ "$http",
      function($http){

        this.findAll = function(callback){
		    $http.get("rest/products").then(
			    function(result){
				    callback(false,result.data);
			    },
    			function(error){
    				callback(error);
    			});
	    }
  
        this.find = function(product_id, callback){
              $http.get("rest/products/" + product_id ).then(
                  function(result){
                      callback(false,result.data);
                  },
                  function(error){
                      callback(error);
                  });
          }
  
  
        this.createProduct = function( data, callback){
              $http.post("rest/products/", data)
          .then(
                  function(result){
                      callback(false,result.data);
                  },
                  function(error){
                      callback(error);
                  });
          }
  
        this.removeProduct = function(product_id, callback){
          $http.delete("rest/products/" + product_id )
          .then(
                  function(result){
                      callback(false,result.data);
                  },
                  function(error){
                      callback(error);
                  });
          }
  
        this.updateProduct = function( data, callback){
          $http.put("rest/products/", data)
          .then(
                  function(result){
                      callback(false,result.data);
                      
                  },
                  function(error){
                      callback(error);
                  });
          }
      }
    ]);
  