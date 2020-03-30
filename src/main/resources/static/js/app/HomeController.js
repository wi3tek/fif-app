'use strict'

var fifapp = angular.module('home.controllers', []);

fifapp.controller('HomeController', ["$scope", '$window', '$rootScope', '$http', '$location', '$route', 'LeagueService', function($scope, $window, $rootScope,
    $http, $location, $route, LeagueService) {

    $scope.userCredentials;


    if ($rootScope.authenticated) {
        $location.path("/");
        $scope.loginerror = false;
    } else {
        $location.path("/login");
        $scope.loginerror = true;
    }


    $scope.getListOfLeagues = function() {
        LeagueService.getAllLeagues()
            .then(function success(response) {
                    $scope.leagues = response.data;
                    $scope.message = '';
                    $scope.errorMessage = '';
                },
                function error(response) {
                    $scope.message = '';
                    $scope.errorMessage = 'Błąd podczas pobierania lig!';
                });
    }

}]);