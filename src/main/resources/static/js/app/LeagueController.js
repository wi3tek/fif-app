'use strict'

var fifapp = angular.module('league.controllers', []);

fifapp.controller('LeagueController', ["$scope", 'LeagueService', function($scope, LeagueService) {
    $scope.leagueEdited;
    $scope.activeLeague;

    $scope.alertMessage;
    $scope.alertStatus;
    $scope.alertPrefix;

    $scope.addLeague = function() {
        if ($scope.league != null && $scope.league.name && $scope.league.startDate) {
            LeagueService.addLeague($scope.league.name, $scope.league.startDate, $scope.league.endDate,
                    $scope.league.description, $scope.league.location)
                .then(function success(response) {
                        $scope.setAlert('Poprawnie dodano ligę', 1);
                        console.log($scope.alertMessage + '\n' + response)
                        $scope.getListOfLeagues();
                        $scope.reset();
                    },
                    function error(response) {
                        $scope.setAlert('Błąd podczas dodawania ligi', 0);
                        console.log($scope.alertMessage + '\n' + response)

                    });
        } else {
            $scope.setAlert('Uzupełnij dane ligi', 0);
        }
    }

    $scope.updateLeague = function() {
        if ($scope.leagueEdited != null && $scope.leagueEdited.name && $scope.leagueEdited.startDate) {
            LeagueService.updateLeague($scope.activeLeague.leagueId, $scope.leagueEdited.name, $scope.leagueEdited.startDate, $scope.leagueEdited.endDate,
                    $scope.leagueEdited.description, $scope.leagueEdited.location)
                .then(function success(response) {
                        $scope.setAlert('Poprawnie zaktualizowano ligę', 1);
                        console.log($scope.alertMessage + '\n' + response)
                        $scope.getListOfLeagues();
                        $scope.reset();
                    },
                    function error(response) {
                        $scope.setAlert('Błąd podczas dodawania ligi', 0);
                        console.log($scope.alertMessage + '\n' + response)

                    });
        } else {
            $scope.setAlert('Uzupełnij dane ligi', 0);
        }
    }


    $scope.deleteLeague = function() {
        if ($scope.leagueEdited != null) {
            LeagueService.deleteLeague($scope.leagueEdited.leagueId)
                .then(function success(response) {
                        $scope.setAlert('Usunięto ligę "' + $scope.leagueEdited.name + '"!', 1)
                        $scope.init();
                        console.log($scope.alertMessage + '\n' + response)

                    },
                    function error(response) {
                        $scope.setAlert('Błąd podczas usuwania ligi "' + $scope.leagueEdited.name + '"!', 0)
                        console.log($scope.alertMessage + '\n' + response)
                    });

        } else {
            $scope.setAlert('Nie można odnaleźć ligi do usunięcia', 2)
            console.log($scope.alertMessage + ' ' + response)
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

    $scope.reset = function() {
        $scope.league = {};
        $scope.leagueForm.$setPristine();
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

    $(document).ready(function() {
        $("#eventAlert").hide();
        $(".alertAction").click(function showAlert() {
            $("#eventAlert").fadeTo(3500, 500).slideUp(500, function() {
                $("#eventAlert").slideUp(500);
            });
        });
    });

    $scope.claculateTime = function(dt) {
        return new Date(dt).getTime();

    }

    $scope.setLeagueEdited = function() {
        $scope.leagueEdited = $scope.activeLeague;
        $scope.leagueEdited.startDate = new Date($scope.leagueEdited.startDate);
    }


    $scope.setActiveLeague = function(league) {
        $scope.activeLeague = league;
    }

}]);