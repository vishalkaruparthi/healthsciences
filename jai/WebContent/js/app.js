'use strict';
var internshipModule = angular.module('internshipModule', ['ngRoute']).
    config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/form',{
            templateUrl : 'templates/internshipForm.html',
            controller : 'InternshipFormController',
            controllerAs : 'ctrlinit'
        });
        $routeProvider.otherwise({
            templateUrl : 'templates/internshipList.html',
            controller : 'InternshipListController',
            controllerAs : 'ilc'
        })
    }
])