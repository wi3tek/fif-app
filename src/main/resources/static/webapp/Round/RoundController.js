'use strict'

var fifapp = angular.module('round.controllers', []);

fifapp.controller('RoundController', ['$scope', 'RoundService', 'PlayerService', 'MatchService', '$routeParams', 'AlertService', '$rootScope', function($scope, RoundService, PlayerService, MatchService, $routeParams, AlertService) {
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
    $scope.lastRound;

    $(document).ready(function() {
        $("#eventAlert").hide();
        $(".alertAction").click(function showAlert() {
            $("#eventAlert").fadeTo(3500, 500).slideUp(500, function() {
                $("#eventAlert").slideUp(500);
            });
        });
    });

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
                    console.log('udało się pobrać ligę: ' + id)
                },
                function error(response) {
                    console.log('wystąpił błą pobrania ligi - odśwież stronę!')
                    if (response.status === 404) {
                        console.log('League not found');
                    } else {
                        console.log('Error getting league');
                    }
                })
    };




    $scope.getLeagueRounds = function() {
        $scope.leagueId = $routeParams.leagueId;
        RoundService.getLeagueRounds($scope.leagueId)
            .then(function success(response) {
                    $scope.rounds = response.data;
                    $scope.lastRound = $scope.rounds[0].roundId
                    console.log('Udało się pobrać kolejki ligowe!' + '$scope.lastRound =' + $scope.lastRound);
                    $scope.quantityOfRounds = countObjects(response.data);

                    RoundService.getRoundTable($scope.leagueId)
                        .then(function success(response) {
                                $scope.roundTable = response.data;
                                console.log('HEHE funkcja' + $scope.alertMessage + '\n' + response + '\n $scope.lastRound=' + $scope.lastRound);
                            },
                            function error(response) {
                                console.log('HEHE nieudana funkcja' + $scope.alertMessage + '\n' + response + '\n $scope.lastRound=' + $scope.lastRound);
                            })
                },
                function error(response) {
                    console.log('Błąd podczas pobrania rund ligowych')
                    if (response.status === 404) {
                        console.log('Rounds not found!');
                    } else {
                        console.log('Error getting rounds!');
                    }
                })
    }


    $scope.getRoundMatches = function(data) {
        RoundService.getRoundMatches(data.roundId)
            .then(function success(response) {
                    $scope.matches = response.data;
                    console.log('udało się pobrać mecze w kolejce');
                    $scope.matchesInDeletedRound = countObjects(response.data);

                },
                function error(response) {
                    if (response.status === 404) {
                        console.log('Matches no found');
                    } else {
                        console.log('Error getting Matches');
                    }
                })


    }


    $scope.getLeagueMatches = function() {
        $scope.leagueId = $routeParams.leagueId;
        RoundService.getLeagueMatches($scope.leagueId)
            .then(function success(response) {
                    $scope.leagueMatches = response.data;
                    console.log('Poprawnie pobrano listę meczów ligowych')

                    $scope.matchesInDeletedRound = countObjects(response.data);

                },
                function error(response) {
                    console.log('Wystąpił błąd podczas pobierania meczów ligowych')
                    if (response.status === 404) {
                        console.log('Matches in league not found');
                    } else {
                        console.log('Error getting league matches');
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
        $scope.getTeamsByRound();

    }



    $scope.setNewRoundSettings = function() {
        $scope.newRound = {};

    }

    $scope.editMatch = function() {
        if ($scope.matchEdited.homeGoals != null && $scope.matchEdited.homeTeamId != null) {
            RoundService.editMatch($scope.matchEdited.matchId, $scope.matchEdited.matchDate, $scope.matchEdited.homeFirstPlayerId, $scope.matchEdited.homeSecondPlayerId, $scope.matchEdited.awayFirstPlayerId, $scope.matchEdited.awaySecondPlayerId, $scope.matchEdited.homeGoals, $scope.matchEdited.awayGoals, $scope.matchEdited.homeTeamId, $scope.matchEdited.awayTeamId, $scope.matchEdited.comment, $scope.matchEdited.roundId, $scope.matchEdited.leagueId)
                .then(function success(response) {
                        AlertService.setAlert('Poprawna edycja wyniku', 1);
                        console.log('Poprawna edycja wyniku');
                        $scope.init();
                        console.log($scope.alertMessage + '\n' + response)

                    },
                    function error() {
                        AlertService.setAlert('Błąd podczas edycji wyniku', 0);
                        console.log($scope.alertMessage + '\n' + response);
                    });
        } else {
            AlertService.setAlert('Uzupełnij dane edytowanego meczu');
            console.log($scope.alertMessage + '\n' + response);
        }
    }


    $scope.getAllPlayers = function() {
        RoundService.getAllPlayers()
            .then(function success(response) {
                    $scope.players = response.data;
                    // $scope.playersKeyValue = players.reduce((acc, i) => {
                    //     acc[i.teamId] = i.name;
                    // })
                },
                function error(response) {
                    console.log('Błąd podczas pobierania graczy!');
                });
    }

    $scope.getTeams = function() {
        RoundService.getTeams()
            .then(function success(response) {
                    $scope.teams = response.data;
                },
                function error(response) {
                    console.log('Błąd podczas pobierania drużyn!');
                });
    }


    $scope.getTeamsByRound = function() {
        RoundService.getTeamsByRound($scope.activeRound.roundId)
            .then(function success(response) {
                    $scope.teams = response.data;
                    console.log('Poprawne pobranie drużyn');
                },
                function error(response) {
                    console.log('Błąd podczas pobierania drużyn!');

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
            MatchService.addNewMatch($scope.newMatch.homeFirstPlayerId, $scope.newMatch.homeSecondPlayerId,
                    $scope.newMatch.awayFirstPlayerId, $scope.newMatch.awaySecondPlayerId, $scope.newMatch.homeTeamId,
                    $scope.newMatch.awayTeamId, $scope.activeRound.roundId, $scope.activeRound.leagueId)
                .then(function success(response) {
                        AlertService.setAlert('Poprawnie dodano mecz', 1);
                        console.log($scope.alertMessage + '\n' + response);
                        $scope.init();

                    },
                    function error(response) {
                        AlertService.setAlert('Błąd podczas dodawania meczu', 0);
                        console.log($scope.alertMessage + '\n' + response);

                    });
        } else {
            AlertService.setAlert('Uzupełnij dane', 2);
            console.log($scope.alertMessage + '\n' + response);
        }


    }

    $scope.deleteMatch = function() {
        if ($scope.matchEdited != null) {
            RoundService.deleteMatch($scope.matchEdited.matchId)
                .then(function success(response) {
                        AlertService.setAlert('Poprawnie usunięto mecz', 1);
                        console.log($scope.alertMessage + '\n' + response);
                        $scope.init();
                    },
                    function error(response) {
                        AlertService.setAlert('Błąd podczas usuwania meczu', 0);
                        console.log(alertMessage + '\n' + response);
                    });

        } else {
            AlertService.setAlert('Błąd danych', 2);
            console.log($scope.alertMessage + '\n' + response);
        }
    }

    $scope.deleteRound = function() {
        $scope.getRoundMatches($scope.roundEdited);
        if ($scope.matchesInDeletedRound == 0) {
            if ($scope.roundEdited != null) {
                RoundService.deleteRound($scope.roundEdited.roundId)
                    .then(function success() {
                            AlertService.setAlert('Poprawnie usunięto kolejkę', 1);
                            $scope.init();
                        },
                        function error() {
                            AlertService.setAlert('Wystąpił błąd podczas usuwania kolejk', 0);
                            console.log($scope.alertMessage + '\n')
                        });
            } else {
                AlertService.setAlert('Błąd danych - brak kolejki', 0);
                console.log($scope.alertMessage)
            }
        } else {
            AlertService.setAlert('Nie można usunąć kolejki z przypisanymi meczami', 0);
            console.log($scope.alertMessage);

        }
    }


    $scope.addRound = function() {
        if ($scope.leagueId != null) {
            RoundService.addRound($scope.quantityOfRounds, $scope.leagueId, $scope.newRound.description)
                .then(function success(response) {
                        AlertService.setAlert('Poprawnie dodano kolejkę', 1);
                        console.log($scope.alertMessage + '\n' + response);
                        $scope.setNewRoundSettings;
                        $scope.resetNewRound;
                        $scope.init();
                    },
                    function error() {
                        AlertService.setAlert('Błąd podczas dodawania kolejki', 0);
                    });
        } else {
            AlertService.setAlert('Błąd danych - nie udało się dodać kolejki', 0);
        }
    }

    $scope.getLeagueTable = function() {
        RoundService.getLeagueTable($scope.leagueId)
            .then(function success(response) {
                    $scope.leagueTable = response.data;
                },
                function error(response) {
                    console.log($scope.alertMessage + '\n' + response);
                })
    }


    $scope.getPlayersMatchesInLeague = function(leagueId) {
        if (leagueId != null) {
            PlayerService.getPlayersMatchesInLeague(leagueId)
                .then(function success(response) {
                        $scope.playerMatches = response.data;
                    },
                    function error(response) {
                        console.log($scope.alertMessage + '\n' + response);
                    });
        } else {
            console.log('Błąd! Liga jest pusta')
        }
    }


}])