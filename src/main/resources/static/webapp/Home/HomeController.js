'use strict'

var fifapp = angular.module('home.controllers', []);

fifapp.controller('HomeController', ["$scope", '$window', '$rootScope', '$http', '$location', '$route', 'LeagueService', function($scope, $window, $rootScope,
    $http, $location, $route, LeagueService) {

    $scope.userCredentials;

    // if ($rootScope.authenticated) {
    //     $location.path("/home");
    //     $scope.loginerror = false;
    // } else {
    //     $location.path("/home");
    //     $scope.loginerror = true;
    // }

}]);