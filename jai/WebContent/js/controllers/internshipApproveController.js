'use strict';
internshipModule.controller('internshipApproveController',
        ['internshipApproveSvc', '$location', '$routeParams',function(internshipApproveSVC, $location, $routeParams){
            var self = this;
            self.isApproved = false;
            var internshipID = $routeParams.internshipID;
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