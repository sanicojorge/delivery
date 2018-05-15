app.service(
  "ClientSrv",
  [ "$http",
    function($http){

	    this.findAll = function(callback){
		    $http.get("rest/clients").then(
			    function(result){
				    callback(false,result.data);
			    },
    			function(error){
    				callback(error);
    			});
	    }


      this.find = function(id, callback){
		    $http.get("rest/clients/" + id).then(
			    function(result){
				    callback(false,result.data);
			    },
    			function(error){
    				callback(error);
    			});
	    }


      this.save = function(data, callback){
        $http.post("rest/clients", data)
        .then(
			    function(result){
				    callback(false,result.data);
			    },
    			function(error){
    				callback(error);
    			});
	    }

      this.updateCuil = function(id, cuil, callback){
        console.log("Actualizando: "+id+" - "+cuil);
        $http({
          method:"PUT",
          url:"rest/clients/"+id,
          params:{"cuil": cuil} })
        .then(
			    function(result){
				    callback(false,result.data);
			    },
    			function(error){
    				callback(error);
    			});
	    }

      this.delete = function(id, callback){
        $http.delete("rest/clients/" + id)
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
