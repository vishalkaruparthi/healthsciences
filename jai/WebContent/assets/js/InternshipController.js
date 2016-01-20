angular.module('internship-form', ['internship-form-opps-service']).controller('internship-form-controller',
		['toiJsontoString', 'stateList', function(toiJsontoString, stateList){
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
	self.stateList = stateList.then;
	stateList.then(function(value) {
		self.stateList = value;
		}, function(reason) {
		  alert('Failed to fetch states');
		});
	
	
	self.newDetails = {};
	self.stipendAmountHide = true;
	self.typeOfinternship = {"a":false,"b":false, "c":false, "d":false};

	
	self.registernewdetails = function(){
		self.newDetails.toi = toiJsontoString(self.typeOfinternship);
		self.newDetails.amount = self['int'+self.newDetails.paymentType] || 0;
		console.log(self.newDetails);
	}
	
}])
