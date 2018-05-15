app.service(
  "RequestSrv",
  [ "$http",
    function($http){

      this.find = function(cli_id, request_id, callback){
		    $http.get("rest/client/" + cli_id + "/request/" + request_id).then(
			    function(result){
				    callback(false,result.data);
			    },
    			function(error){
    				callback(error);
    			});
	    }


      this.addClientRequest = function(cli_id, data, callback){
		    $http.post("rest/client/" + cli_id + "/request", data)
        .then(
			    function(result){
				    callback(false,result.data);
			    },
    			function(error){
    				callback(error);
    			});
	    }

      this.removeClientRequest = function(cli_id, request_id, callback){
        $http.delete("rest/client/" + cli_id + "/request/" + request_id)
        .then(
			    function(result){
				    callback(false,result.data);
			    },
    			function(error){
    				callback(error);
    			});
	    }

      this.updateClientRequest = function(cli_id, data, callback){
        $http.put("rest/client/" + cli_id + "/request", data)
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
