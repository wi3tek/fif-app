'use strict'

var fifapp = angular.module('round.controllers', []);

fifapp.controller('RoundController', ["$scope", 'RoundService', '$routeParams', function($scope, RoundService, $routeParams) {
    $scope.oneAtATime = true;
    $scope.matchEdited;
    $scope.activeRound;

    $scope.getLeague = function() {
        $scope.leagueId = $routeParams.leagueId;
        var id = $scope.leagueId;
        RoundService.getLeague($scope.leagueId)
            .then(function success(response) {
                    $scope.league = response.data;
                    $scope.league.id = id;
                    $scope.message = '';
                    $scope.errorMessage = '';
                },
                function error(response) {
                    $scope.message = '';
                    if (response.status === 404) {
                        $scope.errorMessage = 'League not found';
                    } else {
                        $scope.errorMessage = "Error getting league";
                    }
                })
    };

    $scope.getLeagueRounds = function() {
        $scope.leagueId = $routeParams.leagueId;
        RoundService.getLeagueRounds($scope.leagueId)
            .then(function success(response) {
                    $scope.rounds = response.data;
                    $scope.message = ''
                    $scope.errorMessage = '';
                },
                function error(response) {
                    if (response.status === 404) {
                        $scope.errorMessage = 'Rounds not found!';
                    } else {
                        $scope.errorMessage = "Error getting rounds!";
                    }
                })
    }


    $scope.getRoundMatches = function(data) {
        RoundService.getRoundMatches(data.roundId)
            .then(function success(response) {
                    $scope.matches = response.data;
                    $scope.message = '';
                    $scope.errorMessage = '';
                },
                function error(response) {
                    if (response.status === 404) {
                        $scope.errorMessage = 'Matches no found';
                    } else {
                        $scope.errorMessage = "Error getting Matches"
                    }
                })


    }


    $scope.getLeagueMatches = function() {
        $scope.leagueId = $routeParams.leagueId;
        RoundService.getLeagueMatches($scope.leagueId)
            .then(function success(response) {
                    $scope.leagueMatches = response.data;
                    $scope.message = ''
                    $scope.errorMessage = ''
                },
                function error(response) {
                    if (response.status === 404) {
                        $scope.errorMessage = 'Matches in league not found';
                    } else {
                        $scope.errorMessage = 'Error getting league matches'
                    }
                })
    }

    $scope.claculateTime = function(dt) {
        return new Date(dt).getTime();

    }


    $scope.init = function() {

        $scope.getLeague();
        $scope.getLeagueRounds();
        $scope.getLeagueMatches();
    }

    $scope.setEditContext = function(data) {
        $scope.matchEdited = data;
    }

    $scope.setNewMatchSettings = function(data) {
        $scope.activeRound = data;
        $scope.getAllPlayers();
        $scope.getTeams();

    }


    $scope.editMatch = function() {
        if ($scope.matchEdited.homeGoals != null && $scope.matchEdited.homeTeamId != null) {
            RoundService.editMatch($scope.matchEdited.matchId, $scope.matchEdited.matchDate, $scope.matchEdited.homeFirstPlayerId, $scope.matchEdited.homeSecondPlayerId, $scope.matchEdited.awayFirstPlayerId, $scope.matchEdited.awaySecondPlayerId, $scope.matchEdited.homeGoals, $scope.matchEdited.awayGoals, $scope.matchEdited.homeTeamId, $scope.matchEdited.awayTeamId, $scope.matchEdited.comment, $scope.matchEdited.updateDate, $scope.matchEdited.roundId, $scope.matchEdited.leagueId)
                .then(function success() {
                        $scope.message = 'Poprawna edycja meczu';
                        $scope.errorMessage = '';
                    },
                    function error() {
                        $scope.errorMessage = 'Błąd podczas edycji meczu';
                        $scope.message = ''
                    });
        } else {
            $scope.errorMessage = 'Uzupełnij dane';
            $scope.message = '';
        }
    }


    $scope.getAllPlayers = function() {
        RoundService.getAllPlayers()
            .then(function success(response) {
                    $scope.players = response.data;
                    // $scope.playersKeyValue = players.reduce((acc, i) => {
                    //     acc[i.teamId] = i.name;
                    // })
                    $scope.message = '';
                    $scope.errorMessage = '';
                },
                function error(response) {
                    $scope.message = '';
                    $scope.errorMessage = 'Błąd podczas pobierania graczy!';
                });
    }

    $scope.getTeams = function() {
        RoundService.getTeams()
            .then(function success(response) {
                    $scope.teams = response.data;
                    $scope.message = '';
                    $scope.errorMessage = '';
                },
                function error(response) {
                    $scope.message = '';
                    $scope.errorMessage = 'Błąd podczas pobierania graczy!';
                });
    }

    //below function is used to refresh selectpicker class in select angularjs elements
    $scope.$watch(function() {
        $('.selectpicker').selectpicker('refresh');
    });
}])