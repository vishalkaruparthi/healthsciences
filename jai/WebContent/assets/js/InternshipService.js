var internshipFormOppsService = angular.module('internship-form-opps-service', ['commonServicesApp'])
internshipFormOppsService.factory('toiJsontoString', function() {
	return function(toi){
		var toiArray = new Array();
		for ( var toi_key in toi) {
			toi[toi_key] ?  toiArray.push(toi_key) : "";
		}
		return toiArray.sort().join("|");
	};
});
internshipFormOppsService.factory('stateList', ['httpcall', '$q',function(httpcall, $q){
	var statesList = [];
	var deferred = $q.defer();
	var successfunc = function(response){
		console.log(response.data.statesList);
		statesList = response.data.statesList;
		deferred.resolve(statesList);
	};
	var errorfunc = function(response){
		console.log("error " +response);
		deferred.reject(response);
	};
	var requestObj = {
			method : "GET",
			url : "http://localhost:8080/Internships/states/list",
			successcallback : successfunc,
			errorcallback : errorfunc,
			headers : {
					'Content-Type': 'application/xml',
					Accept: 'application/json'
				},
			data: {"deferred" : deferred}
	}
	
	httpcall(requestObj);
	var promise = deferred.promise;
	return promise;
}]);
internshipFormOppsService.factory('intenshipsByState', ['httpcall', '$q', function(httpcall, $q){
	var internships = [];
	var getInternshipsByState = function(data){
		var deferred = $q.defer();
		var successcallback = function(response){
			console.log(response.data);
			deferred.resolve(response.data);
		}
		var errorcallback = function(resp){
			deferred.reject(resp)
		}
		var requestObj = {
				method : "POST",
				url : "http://localhost:8080/Internships/internships/list",
				successcallback : successcallback,
				errorcallback : errorcallback,
				headers : {
						'Content-Type': 'application/xml',
						Accept: 'application/json'
					},
				data: data+""
		}
		httpcall(requestObj);
		var promise = deferred.promise;
		return promise;
	}
	return getInternshipsByState;
}]);

internshipFormOppsService.factory('internshipApproveSvc', ['httpcall', '$q', function(httpcall, $q){
	var approveInternship = function(data){
		var deferred = $q.defer();
		var successcallback = function(resp){
			deferred.resolve(resp.data);
		}
		var errorcallback = function(resp){
			deferred.reject(resp);
		}
		var url = "http://localhost:8080/Internships/internships/approve/"+data.internshipID;
		var requestObj = {
				method : "GET",
				"url" : url,
				successcallback : successcallback,
				errorcallback : errorcallback,
				headers : {
						'Content-Type': 'application/xml',
						Accept: 'application/json'
					}
		}
		httpcall(requestObj);
		var promise = deferred.promise;
		return promise;
	}
	return approveInternship;
}]);

internshipFormOppsService.factory('internshipSubmit', ['httpcall', '$q', function(httpcall, $q){
	var submitInternship = function(data){
		var deferred = $q.defer();
		var successcallback = function(resp){
			deferred.resolve(resp.data);
		}
		var errorcallback = function(resp){
			deferred.reject(resp);
		}
		var url = "http://localhost:8080/Internships/internhsips/formSubmit";
		var requestObj = {
				method : "POST",
				"url" : url,
				successcallback : successcallback,
				errorcallback : errorcallback,
				headers : {
						'Content-Type': 'application/xml',
						Accept: 'application/json'
					},
				data : data+""
		}
		httpcall(requestObj);
		var promise = deferred.promise;
		return promise;
	}
	return submitInternship;
}])
