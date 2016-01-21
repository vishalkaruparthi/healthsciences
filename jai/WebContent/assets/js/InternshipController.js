angular.module('internship-form', ['internship-form-opps-service']).controller('internship-form-controller',
		['toiJsontoString', 'stateList', 'internshipSubmit', function(toiJsontoString, stateList, internshipSubmit){
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
		
		var intershipJson = {};
		
		var stateSub = {};
		stateSub["stateid"] = self.newDetails.stateID;
		intershipJson["stateId"] = stateSub;
		
		var hoursJson = {};
		hoursJson["hoursID"] = self.newDetails.hoursID;
		intershipJson["hours_work"] = hoursJson;
		
		intershipJson["organizationName"] = self.newDetails.orgname;
		intershipJson["URL"] = self.newDetails.url;
		intershipJson["contactPerson"] = self.newDetails.contactperson;
		intershipJson["phoneNumber"] = self.newDetails.telephone;
		intershipJson["email"] = self.newDetails.email;
		intershipJson["internTypeID"] = self.newDetails.toi;
		intershipJson["internDesc"] = self.newDetails.internDesc;
		intershipJson["city"] = self.newDetails.cityName;
		intershipJson["zipcode"] = self.newDetails.zipCode;
		intershipJson["specialSkills"] = self.newDetails.specialSkills;
		intershipJson["paytype"] = self.newDetails.paymentType;
		intershipJson["payamount"] = self.newDetails.amount;
		intershipJson["postedDate"] = "";
		
		var params = {};
		params["internship"] = intershipJson;
		var xmlConvertor = new X2JS();
		var payload = xmlConvertor.json2xml_str(params);
		console.log(payload);
		
		internshipSubmit(payload).then(function(value){
			console.log(value);
		},function(value){
			console.log(value);
		});
		
	}
	
}])
