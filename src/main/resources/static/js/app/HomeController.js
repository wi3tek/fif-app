'use strict'

var fifapp = angular.module('home.controllers', []);

fifapp.controller('HomeController', ["$scope", 'HomeService', '$window', '$rootScope', '$http', '$location', '$route', 'LeagueService', function($scope, HomeService, $window, $rootScope,
    $http, $location, $route, LeagueService) {

    $scope.alertMessage;
    $scope.alertStatus;
    $scope.alertPrefix;

    $scope.userCredentials;
    $scope.newUser;
    $scope.loginForm;


    if ($rootScope.authenticated) {
        $location.path("/");
        $scope.loginerror = false;
    } else {
        $location.path("/login");
        $scope.loginerror = true;
    }


    $scope.setAlert = function(message, status) {
        $scope.alertStatus = status;
        if (status == 1) {
            $scope.alertPrefix = 'SUKCES! '
            $scope.alertMessage = message;
        } else {
            if (status == 0) {
                $scope.alertPrefix = 'BŁĄD! '
                $scope.alertMessage = message;
            } else {
                $scope.alertPrefix = ''
                $scope.alertMessage = message;
            }
        }
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