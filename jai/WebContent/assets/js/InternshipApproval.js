angular.module('internship-approve', ['internship-form-opps-service']).controller('internship-approve-controller',
		['internshipApproveSvc', '$location', function(internshipApproveSVC, $location){
	var self = this;
	self.isApproved = false;
	var internshipID = $location.search()["internshipID"];
	console.log(internshipID);
	var payload = {};
	payload["internshipID"] = internshipID;
	self.isApproved = internshipApproveSVC(payload).then(function(value){
		 var resp = value;
		 self.isApproved = resp;
	}, function(reason){
		alert("Failed to fetch intenships");
		self.isApproved = false;
	})
}])