'use strict'

var fifapp = angular.module('round.controllers', []);

fifapp.controller('RoundController', ["$scope", 'RoundService', 'PlayerService', '$routeParams', function($scope, RoundService, PlayerService, $routeParams, MatchService) {
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

    $scope.alertMessage;
    $scope.alertStatus;
    $scope.alertPrefix;

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
                        $scope.errorMessage = "Error getting league";
                        console.log('Error getting league');
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
                    console.log('Udało się pobrać kolejki ligowe!')
                    $scope.quantityOfRounds = countObjects(response.data);
                },
                function error(response) {
                    console.log('Błąd podczas pobrania rund ligowych')
                    if (response.status === 404) {
                        $scope.errorMessage = 'Rounds not found!';
                        console.log('Rounds not found!');
                    } else {
                        $scope.errorMessage = "Error getting rounds!";
                        console.log('Error getting rounds!');
                    }
                })
    }


    $scope.getRoundMatches = function(data) {
        RoundService.getRoundMatches(data.roundId)
            .then(function success(response) {
                    $scope.matches = response.data;
                    $scope.message = '';
                    console.log('udało się pobrać mecze w kolejce')
                    $scope.errorMessage = '';
                    $scope.matchesInDeletedRound = countObjects(response.data);

                },
                function error(response) {
                    if (response.status === 404) {
                        $scope.errorMessage = 'Matches no found';
                        console.log('Matches no found');
                    } else {
                        $scope.errorMessage = "Error getting Matches"
                        console.log('Error getting Matches');
                    }
                })


    }


    $scope.getLeagueMatches = function() {
        $scope.leagueId = $routeParams.leagueId;
        RoundService.getLeagueMatches($scope.leagueId)
            .then(function success(response) {
                    $scope.leagueMatches = response.data;
                    $scope.message = ''
                    console.log('Poprawnie pobrano listę meczów ligowych')
                    $scope.errorMessage = ''
                    $scope.matchesInDeletedRound = countObjects(response.data);

                },
                function error(response) {
                    console.log('Wystąpił błąd podczas pobierania meczów ligowych')
                    if (response.status === 404) {
                        $scope.errorMessage = 'Matches in league not found';
                        console.log('Matches in league not found');
                    } else {
                        $scope.errorMessage = 'Error getting league matches'
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
                        $scope.setAlert('Poprawna edycja wyniku', 1);
                        console.log('Poprawna edycja wyniku');
                        $scope.init();
                        console.log($scope.alertMessage + '\n' + response)

                    },
                    function error() {
                        $scope.setAlert('Błąd podczas edycji wyniku', 0);
                        console.log($scope.alertMessage + '\n' + response);
                        $scope.message = ''
                    });
        } else {
            $scope.setAlert('Uzupełnij dane edytowanego meczu');
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
                    $scope.message = '';
                    $scope.errorMessage = '';
                },
                function error(response) {
                    $scope.message = '';
                    $scope.errorMessage = 'Błąd podczas pobierania graczy!';
                    console.log('Błąd podczas pobierania graczy!');
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
                    $scope.errorMessage = 'Błąd podczas pobierania drużyn!';
                    console.log('Błąd podczas pobierania drużyn!');
                });
    }


    $scope.getTeamsByRound = function() {
        RoundService.getTeamsByRound($scope.activeRound.roundId)
            .then(function success(response) {
                    $scope.teams = response.data;
                    $scope.message = '';
                    console.log('Poprawne pobranie drużyn')
                    $scope.errorMessage = '';
                },
                function error(response) {
                    $scope.message = '';
                    $scope.errorMessage = 'Błąd podczas pobierania drużyn!';
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
            RoundService.addNewMatch($scope.newMatch.homeFirstPlayerId, $scope.newMatch.homeSecondPlayerId, $scope.newMatch.awayFirstPlayerId, $scope.newMatch.awaySecondPlayerId, $scope.newMatch.homeTeamId, $scope.newMatch.awayTeamId, $scope.activeRound.roundId, $scope.activeRound.leagueId)
                .then(function success(response) {
                        $scope.setAlert('Poprawnie dodano mecz', 1);
                        console.log($scope.alertMessage + '\n' + response);
                        $scope.init();

                    },
                    function error(response) {
                        $scope.setAlert('Błąd podczas dodawania meczu', 0);
                        console.log($scope.alertMessage + '\n' + response);

                    });
        } else {
            $scope.setAlert('Uzupełnij dane', 2);
            console.log($scope.alertMessage + '\n' + response);
        }


    }

    $scope.deleteMatch = function() {
        if ($scope.matchEdited != null) {
            RoundService.deleteMatch($scope.matchEdited.matchId)
                .then(function success(response) {
                        $scope.setAlert('Poprawnie usunięto mecz', 1);
                        console.log($scope.alertMessage + '\n' + response);
                        $scope.init();
                    },
                    function error(response) {
                        $scope.setAlert('Błąd podczas usuwania meczu', 0);
                        console.log(alertMessage + '\n' + response);
                        $scope.message = '';
                    });

        } else {
            $scope.setAlert('Błąd danych', 2);
            console.log($scope.alertMessage + '\n' + response);
            $scope.message = '';
        }
    }

    $scope.deleteRound = function() {
        $scope.getRoundMatches($scope.roundEdited);
        if ($scope.matchesInDeletedRound == 0) {
            if ($scope.roundEdited != null) {
                RoundService.deleteRound($scope.roundEdited.roundId)
                    .then(function success(response) {
                            $scope.setAlert('Poprawnie usunięto kolejkę', 1);
                            $scope.init();
                        },
                        function error(response) {
                            $scope.setAlert('Wystąpił błąd podczas usuwania kolejk', 0);
                            console.log($scope.alertMessage + '\n' + response)
                        });
            } else {
                $scope.setAlert('Błąd danych - brak kolejki', 0);
                console.log($scope.alertMessage)
            }
        } else {
            $scope.setAlert('Nie można usunąć kolejki z przypisanymi meczami', 0);
            console.log($scope.alertMessage);

        }
    }


    $scope.addRound = function() {
        if ($scope.leagueId != null) {
            RoundService.addRound($scope.quantityOfRounds, $scope.leagueId, $scope.newRound.description)
                .then(function success(response) {
                        $scope.setAlert('Poprawnie dodano kolejkę', 1);
                        console.log($scope.alertMessage + '\n' + response);
                        $scope.setNewRoundSettings;
                        $scope.resetNewRound;
                        $scope.init();
                    },
                    function error(response) {
                        $scope.setAlert('Błąd podczas dodawania ligi', 0);
                        $scope.errorMessage = 'Błąd podczas dodawania kolejki';
                    });
        } else {
            $scope.setAlert('Błąd danych - nie udało się dodać kolejki', 0);
            $scope.errorMessage = 'Błąd danych';
        }
    }

    $scope.getLeagueTable = function() {
        RoundService.getLeagueTable($scope.leagueId)
            .then(function success(response) {
                    $scope.leagueTable = response.data;
                },
                function error() {
                    $scope.setAlert('Błąd podczas pobierania tabeli ligowej', 0)
                    console.log($scope.alertMessage + '\n' + response);
                })
    }


    $scope.getPlayersMatchesInLeague = function(leagueId) {
        if (leagueId != null) {
            PlayerService.getPlayersMatchesInLeague(leagueId)
                .then(function success(response) {
                        $scope.playerMatches = response.data;
                        $scope.setAlert('Pobrano listę meczów gracza', 1)
                    },
                    function error(response) {
                        $scope.setAlert('Błąd podczas dodawania gracza!', 0);
                        console.log($scope.alertMessage + '\n' + response);
                    });
        } else {
            console.log('Błąd! Liga jest pusta')
        }
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

}])