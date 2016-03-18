'use strict';

internshipModule.controller('InternshipFormController',
    ['$scope', 'stateList', 'internshipSubmit', function($scope, stateList, internshipSubmit){
        var self = this;
        $scope.titleA = "FORM FOR INTERNSHIPS (* Required Fields)";//Title of the page
        
        $scope.stateList = [];
        
        stateList.then(function(value) {
            console.log(value);
            $scope.stateList = value;
        }, function(reason) {
            alert('Failed to fetch states');
        });


        $scope.newDetails = {};
        $scope.stipendAmountHide = true;
        
        
        $scope.internshipTypesSelected = [];
        $scope.toggleIntershipTypes = function (item) {
            var idx = $scope.internshipTypesSelected.indexOf(item);
            if (idx > -1) $scope.internshipTypesSelected.splice(idx, 1);
            else $scope.internshipTypesSelected.push(item);
            console.log($scope.internshipTypesSelected);
        };
        $scope.existsIntershipTypes = function (item) {
            return $scope.internshipTypesSelected.indexOf(item) > -1;
        };
        
        
        $scope.academicPeriodsSelected = [];
        $scope.toggleacademicPeriods = function (item) {
            var idx = $scope.academicPeriodsSelected.indexOf(item);
            if (idx > -1) $scope.academicPeriodsSelected.splice(idx, 1);
            else $scope.academicPeriodsSelected.push(item);
            console.log($scope.academicPeriodsSelected)
        };
        $scope.existsacademicPeriods = function (item) {
            return $scope.academicPeriodsSelected.indexOf(item) > -1;
        };
        
        
        $scope.scheduleTypesSelected = [];
        $scope.toggleScheduleTypes = function (item) {
            var idx = $scope.scheduleTypesSelected.indexOf(item);
            if (idx > -1) $scope.scheduleTypesSelected.splice(idx, 1);
            else $scope.scheduleTypesSelected.push(item);
            console.log($scope.scheduleTypesSelected);
        };
        $scope.existsScheduleTypes = function (item) {
            return $scope.scheduleTypesSelected.indexOf(item) > -1;
        };
        
        
        $scope.registernewdetails = function(){
            
            $scope.newDetails.amount = $scope['int'+$scope.newDetails.paymentType] || 0;
            console.log($scope.newDetails);
            
            
            var internShipTypesV = $scope.internshipTypesSelected;
            var internshipTypesJSON = []
            for(var it=0;it<internShipTypesV.length;it++){
                  internshipTypesJSON.push({id:internShipTypesV[it]}); 
            }
            
            var academicPeriods = $scope.academicPeriodsSelected;
            var academicPeriodJSON = [];
            for(var j=0;j<academicPeriods.length;j++){
                academicPeriodJSON.push({id:academicPeriods[j]});
            }
            
            var scheduleTypes = $scope.scheduleTypesSelected;
            var scheduleTypesJSON = [];
            for(var k=0;k<scheduleTypes.length;k++){
                scheduleTypesJSON.push({hoursID:scheduleTypes[k]});
            }
            
            var intershipJson = {};

            var stateSub = {};
            stateSub["stateid"] = $scope.newDetails.stateID;
            intershipJson["stateId"] = stateSub;

            intershipJson["organizationName"] = $scope.newDetails.orgname;
            intershipJson["url"] = $scope.newDetails.url.toString;
            intershipJson["contactPerson"] = $scope.newDetails.contactperson;
            intershipJson["phoneNumber"] = $scope.newDetails.telephone;
            intershipJson["email"] = $scope.newDetails.email;
            
            intershipJson["internDesc"] = $scope.newDetails.internDesc;
            intershipJson["city"] = $scope.newDetails.cityName;
            intershipJson["zipcode"] = $scope.newDetails.zipCode;
            intershipJson["specialSkills"] = $scope.newDetails.specialSkills;
            intershipJson["payType"] = {id:$scope.newDetails.paymentType};
            intershipJson["payamount"] = $scope.newDetails.amount;
            intershipJson["postedDate"];
            
            intershipJson["internshipTypeList"] = internshipTypesJSON;
            intershipJson["academicPeriodList"] = academicPeriodJSON;
            intershipJson["hoursWorkList"] = scheduleTypesJSON;
           

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
