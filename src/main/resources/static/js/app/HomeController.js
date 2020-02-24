'use strict'

var fifapp = angular.module('home.controllers', []);

fifapp.controller('HomeController', ["$scope", 'LeagueService', function($scope, LeagueService) {

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