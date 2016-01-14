angular.module('internship-form', ['internship-form-opps-service']).controller('internship-form-controller',['toiJsontoString', 'stateList', function(toiJsontoString, stateList){
	var self = this;
	self.titleA = "FORM FOR INTERNSHIPS (* Required Fields)";//Title of the page
	/*
	 * Details JSON to be updated to server
	 * newDetails = {
	 * 				orgname : "",
	 * 				url : "",
	 * 				contactperson : "",
	 * 				contactTitle : "",
	 * 				email : "",
	 * 				telephone : "",
	 * 				toi : "",
	 * 				internDesc : "",
	 * 				hoursID : "",
	 * 				cityName : "",
	 * 				stateID: "",
	 * 				zipCode : "",
	 * 				amount : "",
	 * 				
	 * 				
	 * 			}
	 */
	self.newDetails = {};
	self.stipendAmountHide = true;
	self.typeOfinternship = {"a":false,"b":false, "c":false, "d":false};
	self.wageType = {"int1":false, "int2":false, "int3":false};
	self.stateList = stateList;
	self.wageOnClick = function(obj){
		var woc = self.wageType;
		for ( var woc_key in woc) {
			self.wageType[woc_key] = obj.target.value === woc_key;
		}
		if(obj.target.value === "int1"){
			self.newDetails.amount = 0;
		}
	}
	
	self.registernewdetails = function(){
		self.newDetails.toi = toiJsontoString(self.typeOfinternship);
		
		console.log(self.newDetails);
	}
	
}])
