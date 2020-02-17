//'use strict'

//var module = angular.module('league.controllers', []);
var fifapp = angular.module('league.controllers', []);

fifapp.controller('LeagueController', ["$scope", 'LeagueService', function($scope, LeagueService) {

    $scope.addLeague = function() {
        if ($scope.league != null && $scope.league.name && $scope.league.startDate) {
            LeagueService.addLeague($scope.league.name, $scope.league.startDate, $scope.league.endDate,
                    $scope.league.description, $scope.league.location)
                .then(function success(response) {
                        console.log(response.statusText);
                        console.log('Poprawnie dodano ligę');
                        $scope.message = 'Poprawnie dodano ligę';
                        $scope.errorMessage = '';
                    },
                    function error(response) {
                        console.log(response.statusText);
                        console.log('Błąd podczas dodawania ligi');
                        $scope.errorMessage = 'Błąd podczas dodawania ligi';
                        $scope.message = '';

                    });
        } else {
            console.log(response.statusText);
            console.log('Błąd podczas dodawania ligi x2');
            $scope.errorMessage = 'Uzupełnij dane';
            $scope.message = '';
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