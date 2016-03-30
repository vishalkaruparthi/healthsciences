'use strict';
var internshipModule = angular.module('internshipModule', ['ngRoute', 'blockUI']).
    config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/form',{
            templateUrl : 'templates/internshipForm.html',
            controller : 'InternshipFormController'
        });
        $routeProvider.when('/approve/:internshipID',{
            templateUrl:'templates/internshipApprove.html',
            controller: 'internshipApproveController as iac'
        });
        $routeProvider.when('/submit/successfull',{
            templateUrl:'templates/internshipSubmitted.html'
        });
        $routeProvider.otherwise({
            templateUrl : 'templates/internshipList.html',
            controller : 'InternshipListController'
        });
    }
])