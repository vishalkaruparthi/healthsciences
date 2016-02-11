'use strict';
internshipModule.controller('InternshipListController', ['stateList', 'intenshipsByState',
    function(stateList, intenshipsByState){
        var self = this;
        self.internhsipsByState = [];
        self.currentDisplay = 0;

        var xmlConvertor = new X2JS();
        self.stateOnClick = function(stateID){
            var params = {};
            params['listcriteria'] = {
                'stateID' : stateID,
                'sortCriteria':11
            }
            var payload = xmlConvertor.json2xml_str(params);
            console.log(payload);
            intenshipsByState(payload).then(function(value){
                self.internhsipsByState = value.internshipList;
                //resp
                self.currentDisplay = 2;
            }, function(reason){
                alert("Failed to fetch intenships");
            });

        }

        self.statesShow = function(a){
            self.currentDisplay = a;
        }

        self.stateList = stateList.then;

        stateList.then(
            function(value) {
                self.stateList = value;
            }, function(reason) {
                alert('Failed to fetch states');
            });
    }
]);