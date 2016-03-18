'use strict';
internshipModule.controller('InternshipListController', ['$scope', 'intenshipsByState',
    function($scope, intenshipsByState){
        var self = this;
        
        this.resetAllIds = function(){
            self.allInternTypes = [1, 2, 3, 4];
            self.allscheduleTypes = [1, 2, 3];
        };
        
        this.resetAllIds();
        
        this.arrayNegations = function(myArray, toRemove){
            if(toRemove.length > 0){
                myArray = myArray.filter( function( el ) {
                  return toRemove.indexOf( el ) < 0;
                } );
                return myArray;
            }
            return toRemove;
            
        };
        
        
        this.getList = function(){
//            console.log("cities selected"+$scope.citiesSelected);
//            console.log("internship types selected"+$scope.internshipTypesSelected);
//            console.log("shedule types selected"+$scope.scheduleTypesSelected);
//            console.log("academicPeriods types selected"+$scope.academicPeriodsSelected);
            var internTypes = self.arrayNegations(self.allInternTypes, $scope.internshipTypesSelected);
            var scheduleTypes = self.arrayNegations(self.allscheduleTypes, $scope.scheduleTypesSelected);
            
            var stateID = $scope.state.selected;
            
            this.resetAllIds();
            console.log("internship types not selected"+internTypes);
            
            
            var level2 = {
                stateID: stateID,
                sortCriteria:11,
                hoursWork:scheduleTypes,
                internType:internTypes
            }
            
            var params = {};
            params.listcriteria = level2;
            
            var xmlConvertor = new X2JS();
            var payload = xmlConvertor.json2xml_str(params);
            
            console.log("payload "+payload);
            intenshipsByState(payload).then(
                function(resp){
                    console.log(resp);
                    $scope.internshipList = resp.internshipList;
                },
                function(resp){
                    console.log(resp);
                }
            );
        };
        
        $scope.internshipList = [];
        
        $scope.cities = [{name:"Texas", id:43},{name:"Other", id:-1}];
        $scope.state = {
            selected : 43
        };
        
        $scope.stateOnClick = function(){
            self.getList();
        };

        
//        $scope.citiesSelected = [43];
//        $scope.toggle = function (item) {
//            var idx = $scope.citiesSelected.indexOf(item);
//            if (idx > -1) $scope.citiesSelected.splice(idx, 1);
//            else $scope.citiesSelected.push(item);
//            self.getList();
//        };
//        $scope.exists = function (item) {
//            return $scope.citiesSelected.indexOf(item) > -1;
//        };
        
        
        $scope.internshipTypes = [{name:"Public Health/Health Promotion", id:1},
                                  {name:"Health Care Administration", id:2},
                                  {name:"Bilingiual Healthcare",id:3},
                                  {name:"Wellness Management",id:4}];
        
        
        $scope.internshipTypesSelected = [];
        $scope.toggleIntershipTypes = function (item) {
            var idx = $scope.internshipTypesSelected.indexOf(item);
            if (idx > -1) $scope.internshipTypesSelected.splice(idx, 1);
            else $scope.internshipTypesSelected.push(item);
            self.getList();
        };
        $scope.existsIntershipTypes = function (item) {
            return $scope.internshipTypesSelected.indexOf(item) > -1;
        };
        
        $scope.scheduleTypes = [{name:"half time for one semester",id:1},
                                {name:" full time for one semester",id:2},
                                {name:"half time for two semesters",id:3}];
        
        $scope.scheduleTypesSelected = [];
        $scope.toggleScheduleTypes = function (item) {
            var idx = $scope.scheduleTypesSelected.indexOf(item);
            if (idx > -1) $scope.scheduleTypesSelected.splice(idx, 1);
            else $scope.scheduleTypesSelected.push(item);
            self.getList();
        };
        $scope.existsScheduleTypes = function (item) {
            return $scope.scheduleTypesSelected.indexOf(item) > -1;
        };
        
        this.getList();
    }
]);