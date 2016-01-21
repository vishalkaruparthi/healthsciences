var commomServices = angular.module('commonServicesApp', []);
commomServices.factory('httpcall', ['$http', function($http){
	return function(requestObj){
		/* 
		 * requestObj = {
		 * 				method : get/post,
		 * 				url : "",
		 * 				successcallback : fun,
		 * 				errorcallback : fun,
		 * 				headers : {
		 * 						Content-Type: application/json, text/plain, * / *
		 * 						Accept: application/json, text/plain, * / *
		 * 					}
		 * 				data: { test: 'test' }
		 * 			} 
		 */
		$http({
			method : requestObj.method,
			url : requestObj.url,
			headers : requestObj.headers,
			data : requestObj.data || {}
		}).then(requestObj.successcallback, requestObj.errorcallback);
	}
}])

function getUrlParams(){
	var params = {};
	var queryString = window.location.search.substring(1).split("&");
	for(var i=0;i<queryString.length;i++){
		var k = queryString[i].split("=")[0];
		var v = queryString[i].split("=")[1];
		params[k] = v; 
	}
	return params;
}