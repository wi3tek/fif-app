'use strict'

var fifapp = angular.module('player.controllers', []);

fifapp.controller('PlayerController', ["$scope", 'PlayerService', 'AlertService', function($scope, PlayerService, AlertService) {
    $scope.playerEdited;
    $scope.newPlayer;
    $scope.activePlayer;

    $(document).ready(function() {
        $("#eventAlert").hide();
        $(".alertAction").click(function showAlert() {
            $("#eventAlert").fadeTo(3500, 500).slideUp(500, function() {
                $("#eventAlert").slideUp(500);
            });
        });
    });

    $scope.addPlayer = function() {
        if ($scope.player != null && $scope.player.name && $scope.player.alias) {
            PlayerService.addPlayer($scope.player.name, $scope.player.alias, $scope.player.dateOfBirth, $scope.player.userId)
                .then(function success(response) {
                        AlertService.setAlert('Poprawnie dodano zawodnika "' + $scope.player.alias + '"', 1);
                        console.log(response)
                        $scope.init();
                        $scope.resetPlayerForm();
                    },
                    function error(response) {
                        AlertService.setAlert('Błąd podczas dodawania zawodnika "' + $scope.player.alias + '"', 0);
                        console.log(response)

                    });
        } else {}
    }

    $scope.updatePlayer = function() {
        if ($scope.playerEdited != null && $scope.playerEdited.name && $scope.playerEdited.alias) {
            PlayerService.updatePlayer($scope.playerEdited.playerId, $scope.playerEdited.name, $scope.playerEdited.alias, $scope.playerEdited.dateOfBirth,
                    $scope.playerEdited.joinDate, $scope.playerEdited.userId)
                .then(function success(response) {
                        AlertService.setAlert('Porpawnie zaktualizowano dane zawodnika "' + $scope.playerEdited.alias + '"', 1);
                        $scope.getPlayers();
                        $scope.resetPlayerForm();
                        console.log($scope.alertMessage + '\n' + response)
                    },
                    function error(response) {
                        AlertService.setAlert('Wystąpił błąd podczas aktualizacji zawodnika "' + $scope.playerEdited.alias + '"', 0);
                        console.log($scope.alertMessage + '\n' + response)

                    });
        } else {}
    }


    $scope.getPlayers = function() {
        PlayerService.getPlayers()
            .then(function success(response) {
                    $scope.players = response.data;
                    console.log('Pobrano graczy ' + response)
                },
                function error(response) {
                    console.log('Błąd podczas pobierania graczy ' + response)
                });
    }

    $scope.resetPlayerForm = function() {
        $scope.player = {};
        $scope.playerForm.$setPristine();
    }

    $scope.init = function() {
        $scope.getPlayers();
    }

    $scope.deletePlayer = function() {
        if ($scope.playerEdited != null) {
            PlayerService.deletePlayer($scope.playerEdited.playerId)
                .then(function success(response) {
                        AlertService.setAlert('Usunięto zawodnika "' + $scope.playerEdited.alias + '"!', 1)
                        $scope.init();
                        console.log($scope.alertMessage + '\n' + response)

                    },
                    function error(response) {
                        AlertService.setAlert('Błąd podczas usuwania zawodnika "' + $scope.playerEdited.alias + '"!', 0)
                        console.log($scope.alertMessage + '\n' + response)
                    });

        } else {
            AlertService.setAlert('Nie można odnaleźć zawodnika do usunięcia', 2)
            console.log($scope.alertMessage + ' ' + response)
        }
    }

    $scope.setActivePlayer = function(player) {
        $scope.activePlayer = player;
    }

    $scope.calculateAge = function() { // birthday is a date
        var _birthDay = new Date($scope.activePlayer.dateOfBirth)
        var ageDifMs = Date.now() - _birthDay.getTime();
        var ageDate = new Date(ageDifMs); // miliseconds from epoch
        return Math.abs(ageDate.getUTCFullYear() - 1970);
    }

    $scope.claculateTime = function(dt) {
        return new Date(dt).getTime();

    }

    $scope.setPlayerEdited = function() {
        $scope.playerEdited = $scope.activePlayer;
        $scope.playerEdited.dateOfBirth = new Date($scope.playerEdited.dateOfBirth);
    }



}]);