'use strict'

var fifapp = angular.module('round.controllers', []);

fifapp.controller('RoundController', ["$scope", 'RoundService', '$routeParams', function($scope, RoundService, $routeParams, MatchService) {
    $scope.oneAtATime = true;
    $scope.matchEdited;
    $scope.activeRound;
    $scope.newMatch;
    $scope.matchToDelete;
    $scope.quantityOfRounds;
    $scope.leagueId;
    $scope.newRound;
    $scope.roundEdited;
    $scope.matchesInDeletedRound;

    function countObjects(superObject) {
        var count = 0;
        for (var i = 0; i < superObject.length; ++i) {
            count++;
        }
        return count;
    }

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
                    $scope.quantityOfRounds = countObjects(response.data);
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
                    $scope.matchesInDeletedRound = countObjects(response.data);

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
                    $scope.matchesInDeletedRound = countObjects(response.data);

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
        $scope.getLeagueTable();

    }

    $scope.setEditContext = function(data) {
        $scope.matchEdited = data;
    }

    $scope.setEditRoundContext = function(data) {
        $scope.roundEdited = data
    }

    $scope.setNewMatchSettings = function(data) {
        $scope.activeRound = data;
        $scope.newMatch = {};
        $scope.getAllPlayers();
        $scope.getTeams();

    }

    $scope.setNewRoundSettings = function() {
        $scope.newRound = {};

    }


    $scope.editMatch = function() {
        if ($scope.matchEdited.homeGoals != null && $scope.matchEdited.homeTeamId != null) {
            RoundService.editMatch($scope.matchEdited.matchId, $scope.matchEdited.matchDate, $scope.matchEdited.homeFirstPlayerId, $scope.matchEdited.homeSecondPlayerId, $scope.matchEdited.awayFirstPlayerId, $scope.matchEdited.awaySecondPlayerId, $scope.matchEdited.homeGoals, $scope.matchEdited.awayGoals, $scope.matchEdited.homeTeamId, $scope.matchEdited.awayTeamId, $scope.matchEdited.comment, $scope.matchEdited.roundId, $scope.matchEdited.leagueId)
                .then(function success() {
                        $scope.message = 'Poprawna edycja meczu';
                        $scope.errorMessage = '';
                        $scope.init();
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

    $scope.resetNewMatch = function() {
        $scope.newMatch = {};
        $scope.newMatchForm.$setPristine();
    }

    $scope.resetNewRound = function() {
        $scope.newRound = {};
        $scope.roundForm.$setPristine();
    }





    $scope.addNewMatch = function() {
        if ($scope.newMatch != null) {
            RoundService.addNewMatch($scope.newMatch.homeFirstPlayerId, $scope.newMatch.homeSecondPlayerId, $scope.newMatch.awayFirstPlayerId, $scope.newMatch.awaySecondPlayerId, $scope.newMatch.homeTeamId, $scope.newMatch.awayTeamId, $scope.newMatch.comments, $scope.activeRound.roundId, $scope.activeRound.leagueId)
                .then(function success() {
                        $scope.getLeague();
                        $scope.getLeagueRounds();
                        $scope.getLeagueMatches();
                        $scope.getLeagueTable();
                        $scope.message = 'Poprawnie dodano mecz';
                        $scope.errorMessage = '';
                    },
                    function error(response) {
                        $scope.errorMessage = 'Błąd podczas dodawania meczu';
                        $scope.message = '';

                    });
        } else {
            $scope.errorMessage = 'Uzupełnij dane';
            $scope.message = '';
        }


    }

    $scope.deleteMatch = function() {
        if ($scope.matchEdited != null) {
            RoundService.deleteMatch($scope.matchEdited.matchId)
                .then(function success() {
                        $scope.message = 'Poprawnie usunięto mecz';
                        $scope.errorMessage = '';
                        $scope.init();
                    },
                    function error() {
                        $scope.errorMessage = 'Błąd podczas usuwania meczu';
                        $scope.message = '';
                    });

        } else {
            $scope.errorMessage = 'Błąd danych';
            $scope.message = '';
        }
    }

    $scope.deleteRound = function() {
        $scope.getRoundMatches($scope.roundEdited);
        if ($scope.matchesInDeletedRound == 0) {
            if ($scope.roundEdited != null) {
                RoundService.deleteRound($scope.roundEdited.roundId)
                    .then(function success() {
                            $scope.message = 'Poprawnie usunięto kolejkę';
                            $scope.errorMessage = '';
                            $scope.init();
                        },
                        function error() {
                            $scope.errorMessage = 'Wystąpił nieoczekiwany błąd';
                            console.log('Wystąpił nieoczekiwany błąd')
                            $scope.message = '';
                        });
            } else {
                $scope.errorMessage = 'Błąd danych - brak kolejki';
                console.log('Błąd danych - brak kolejki')
                $scope.message = '';
            }
        } else {
            $scope.errorMessage = 'NIE MOŻNA USUNĄĆ RUNDY Z PRZYPISANYMI MECZAMI';
            console.log('NIE MOŻNA USUNĄĆ RUNDY Z PRZYPISANYMI MECZAMI');

        }
    }


    $scope.addRound = function() {
        if ($scope.leagueId != null) {
            RoundService.addRound($scope.quantityOfRounds, $scope.leagueId, $scope.newRound.description)
                .then(function success() {
                        $scope.message = 'Poprawnie dodano kolejkę';
                        $scope.errorMessage = '';
                        $scope.setNewRoundSettings;
                        $scope.resetNewRound;
                        $scope.init();
                    },
                    function error() {
                        console.log('Błąd podczas dodawania ligi');
                        $scope.errorMessage = 'Błąd podczas dodawania kolejki';
                        $scope.message = '';
                    });
        } else {
            console.log('Błąd danych');
            $scope.errorMessage = 'Błąd danych';
            $scope.message = '';
        }
    }

    $scope.getLeagueTable = function() {
        RoundService.getLeagueTable($scope.leagueId)
            .then(function success(response) {
                    $scope.leagueTable = response.data;
                    $scope.message = '';
                    $scope.errorMessage = '';
                },
                function error() {
                    $scope.message = '';
                    $scope.errorMessage = 'Błąd podczas pobierania tabeli ligowej'
                })
    }
}])