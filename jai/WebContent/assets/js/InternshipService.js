var internshipFormOppsService = angular.module('internship-form-opps-service', [])
internshipFormOppsService.factory('toiJsontoString', function() {
	return function(toi){
		var toiArray = new Array();
		for ( var toi_key in toi) {
			toi[toi_key] ?  toiArray.push(toi_key) : "";
		}
		return toiArray.sort().join("|");
	};
});
internshipFormOppsService.factory('stateList', ['$http', function($https){
	var statesList = [{id:0, name: "Select State"}, {id:1, name: "Alabama"}];
	return statesList;
}]);
