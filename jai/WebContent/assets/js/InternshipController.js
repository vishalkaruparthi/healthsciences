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
	 * 				specialSkills : ""
	 * 				
	 * 			}
	 */
	self.newDetails = {};
	self.stipendAmountHide = true;
	self.typeOfinternship = {"a":false,"b":false, "c":false, "d":false};
	self.wageType = {"int1":false, "int2":false, "int3":false};
	self.stateList = stateList;
	
	self.registernewdetails = function(){
		self.newDetails.toi = toiJsontoString(self.typeOfinternship);
		self.newDetails.amount = self['int'+self.newDetails.paymentType] || 0;
		console.log(self.newDetails);
	}
	
}])
