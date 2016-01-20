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