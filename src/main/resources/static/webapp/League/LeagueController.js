'use strict'

var fifapp = angular.module('league.controllers', []);

fifapp.controller('LeagueController', ["$scope", 'LeagueService', 'AlertService', function($scope, LeagueService, AlertService) {
    $scope.leagueEdited;
    $scope.activeLeague;

    $scope.addLeague = function() {
        if ($scope.league != null && $scope.league.name && $scope.league.startDate) {
            LeagueService.addLeague($scope.league.name, $scope.league.startDate, $scope.league.endDate,
                    $scope.league.description, $scope.league.location, $rootScope.currentUser.id)
                .then(function success(response) {
                        AlertService.setAlert('Poprawnie dodano ligę', 1);
                        console.log($scope.alertMessage + '\n' + response)
                        $scope.getListOfLeagues();
                        $scope.reset();
                    },
                    function error(response) {
                        AlertService.setAlert('Błąd podczas dodawania ligi', 0);
                        console.log($scope.alertMessage + '\n' + response)

                    });
        } else {
            AlertService.setAlert('Uzupełnij dane ligi', 0);
        }
    }

    $scope.updateLeague = function() {
        if ($scope.leagueEdited != null && $scope.leagueEdited.name && $scope.leagueEdited.startDate) {
            LeagueService.updateLeague($scope.activeLeague.leagueId, $scope.leagueEdited.name, $scope.leagueEdited.startDate, $scope.leagueEdited.endDate,
                    $scope.leagueEdited.description, $scope.leagueEdited.location)
                .then(function success(response) {
                        AlertService.setAlert('Poprawnie zaktualizowano ligę', 1);
                        console.log($scope.alertMessage + '\n' + response)
                        $scope.getListOfLeagues();
                        $scope.reset();
                    },
                    function error(response) {
                        AlertService.setAlert('Błąd podczas dodawania ligi', 0);
                        console.log($scope.alertMessage + '\n' + response)

                    });
        } else {
            AlertService.setAlert('Uzupełnij dane ligi', 0);
        }
    }

    $scope.init = function() {
        $scope.getListOfLeagues();
    }


    $scope.deleteLeague = function() {
        if ($scope.leagueEdited != null) {
            LeagueService.deleteLeague($scope.leagueEdited.leagueId)
                .then(function success(response) {
                        AlertService.setAlert('Usunięto ligę "' + $scope.leagueEdited.name + '"!', 1)
                        $scope.init();
                        console.log($scope.alertMessage + '\n' + response)

                    },
                    function error(response) {
                        AlertService.setAlert('Błąd podczas usuwania ligi "' + $scope.leagueEdited.name + '"!', 0)
                        console.log($scope.alertMessage + '\n' + response)
                    });

        } else {
            AlertService.setAlert('Nie można odnaleźć ligi do usunięcia', 2)
            console.log($scope.alertMessage + ' ' + response)
        }
    }


    $scope.getListOfLeagues = function() {
        LeagueService.getAllLeagues()
            .then(function success(response) {
                    $scope.leagues = response.data;
                },
                function error(response) {});
    }

    $scope.reset = function() {
        $scope.league = {};
        $scope.leagueForm.$setPristine();
    }

    $(document).ready(function() {
        $("#eventAlert").hide();
        $(".alertAction").click(function showAlert() {
            $("#eventAlert").fadeTo(3500, 500).slideUp(500, function() {
                $("#eventAlert").slideUp(500);
            });
        });
    })







    $scope.claculateTime = function(dt) {
        return new Date(dt).getTime();

    }

    $scope.setLeagueEdited = function() {
        $scope.leagueEdited = $scope.activeLeague;
        $scope.leagueEdited.startDate = new Date($scope.leagueEdited.startDate);
        // $scope.leagueEdited.endDate = new Date($scope.leagueEdited.endDate);
        $scope.leagueEdited.endDate = null;
    }

    $scope.setActiveLeague = function(league) {
        $scope.activeLeague = league;
    }

}]);