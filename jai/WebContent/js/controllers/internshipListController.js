'use strict';
internshipModule.controller('InternshipListController', ['$scope', 'intenshipsByState',
    function($scope, intenshipsByState){
        var self = this;
        
        this.resetAllIds = function(){
            self.allInternTypes = [1, 2, 3, 4];
            self.allscheduleTypes = [1, 2, 3];
            self.allacademicPeriods = [1, 2, 3, 4];
        };
        
        this.resetAllIds();
        
        this.arrayNegations = function(myArray, toRemove){
            myArray = myArray.filter( function( el ) {
              return toRemove.indexOf( el ) < 0;
            } );
            return myArray;
        };
        
        
        this.getList = function(){
//            console.log("cities selected"+$scope.citiesSelected);
//            console.log("internship types selected"+$scope.internshipTypesSelected);
//            console.log("shedule types selected"+$scope.scheduleTypesSelected);
//            console.log("academicPeriods types selected"+$scope.academicPeriodsSelected);
            var internTypes = self.arrayNegations(self.allInternTypes, $scope.internshipTypesSelected);
            var scheduleTypes = self.arrayNegations(self.allscheduleTypes, $scope.scheduleTypesSelected);
            var academicPeriodsTypes = self.arrayNegations(self.allacademicPeriods, $scope.academicPeriodsSelected);
            var stateID = $scope.state.selected;
            var payTypeID = $scope.payTypesSelction.selected;
            this.resetAllIds();
            console.log("internship types not selected"+internTypes);
            
            
            var level2 = {
                stateID: stateID,
                sortCriteria:11,
                payType:payTypeID,
                hoursWork:scheduleTypes,
                academicPeriod:academicPeriodsTypes,
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
            )
        };
        
        $scope.internshipList = [];
        
        $scope.cities = [{name:"Texas", id:43},{name:"All", id:-1}];
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
        
        
        $scope.internshipTypesSelected = [1];
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
        
        $scope.scheduleTypesSelected = [1];
        $scope.toggleScheduleTypes = function (item) {
            var idx = $scope.scheduleTypesSelected.indexOf(item);
            if (idx > -1) $scope.scheduleTypesSelected.splice(idx, 1);
            else $scope.scheduleTypesSelected.push(item);
            self.getList();
        };
        $scope.existsScheduleTypes = function (item) {
            return $scope.scheduleTypesSelected.indexOf(item) > -1;
        };
        
        
        $scope.academicPeriods = [{name:"Fall", id:1},
                                  {name:"Spring", id:2},
                                  {name:"Summer", id:3}];
        $scope.academicPeriodsSelected = [1];
        $scope.toggleacademicPeriods = function (item) {
            var idx = $scope.academicPeriodsSelected.indexOf(item);
            if (idx > -1) $scope.academicPeriodsSelected.splice(idx, 1);
            else $scope.academicPeriodsSelected.push(item);
            self.getList();
        };
        $scope.existsacademicPeriods = function (item) {
            return $scope.academicPeriodsSelected.indexOf(item) > -1;
        };
        
        
        $scope.payTypes = [{name:"No", id:1},
                          {name:"Stipend", id:2},
                          {name:"Wage", id:3},
                          {name:"To be determined", id:4}];
        
        $scope.payTypesSelction = {
            selected:2
        }
        
        $scope.payTypeSelected = function(){
            console.log($scope.payTypesSelction.selected);
            self.getList();
        }
        
    }
]);